package com.sync.core.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sync.core.beans.CompanyBean;
import com.sync.core.beans.GalleryBean;
import com.sync.core.beans.MessageBean;
import com.sync.core.beans.NewsBean;
import com.sync.core.beans.SlideBean;
import com.sync.core.engine.CompanyEngine;
import com.sync.core.engine.GalleryEngine;
import com.sync.core.engine.NewsEngine;
import com.sync.core.engine.SlideEngine;
import com.sync.core.utils.Constants;
import com.sync.core.utils.ServletUtilities;
import com.sync.core.utils.Utilities;
import com.sync.home.utils.PublicConstants;
import com.sync.master.beans.LevelAccessBean;
import com.sync.master.beans.MasterResidentBean;
import com.sync.master.beans.MasterUserBean;
import com.sync.master.engine.MasterResidentEngine;
import com.sync.master.engine.UserEngine;
import com.sync.master.utils.MasterConstants;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;

public class CoreServlet extends ServletUtilities
{
  private HttpSession session;
  
  /**
	 * Generated Serial Version ID
	 */
	private static final long serialVersionUID = 7611029007026627755L;

	/** Default method first calling in servlet */
  public void doGet(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    System.out.println("CORE DO GET");
    this.doPost(req, res);
  }

  public void doPost(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    boolean isMultipart = ServletFileUpload.isMultipartContent(req);
    
    if(isMultipart){
      //System.out.println("ismultipart : "+req.toString());
      this.isMultipartForm(req);
      String w = this.getMultipartParam(Constants.W);
      System.out.println("what : "+w);
      if(null!=w && w.equals(Constants.SLIDE_SETTING_PRM)){
        System.out.println("masuk slide setting");
        doCreateSlide(req,res);
      }
      else if(null!=w && (w.equals(Constants.GALLERY_SETTING_PRM) || w.equals(Constants.NEWS_SETTING_PRM))){
        doUploadToTemp(req,res);
      }else{
        generalUploadImage(req, res);
      }
      
      return;
    }
    
    System.out.println("CORE DO POST");
    String _do = req.getParameter(Constants.D);
    String w = req.getParameter(Constants.W);
    System.out.println("DO =" +_do);
    if(!Utilities.isEmpy(_do) && _do.equals(Constants.D_LOGON))
    { 
      this.doLogon(req, res);
    }
    else if(!Utilities.isEmpy(_do) && _do.equals(Constants.D_LOGOUT))
    {
      this.doLogout(req, res);
    }
    else if(!Utilities.isEmpy(_do) && _do.equals(Constants.D_SEARCH))
    {
      this.doViewHome(req, res);;
    }
    else //show website
    {
      if(!Utilities.isEmpy(w))
      { 
        this.doView(req, res);
        return;
      }
      
      super.openURL(PublicConstants.PUBLIC_HOME_PAGE, req, res);
    }
    return;
  }
  
  private void doUploadToTemp(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException 
  {
    res.setContentType("application/json;charset=utf-8");
    long maxSize = 512000; //limit file size 500kb
    String filter[] = {"jpg","png","gif"};
    
    GalleryEngine ge = new GalleryEngine(req,res);
    JSONObject up = ge.uploadFileUniqueID(multiparts,Constants.FILE_TEMP_PATH, filter, maxSize);
    
    
    if(null!=up){
      try {
        if(up.getString(Constants.AJAX_STATUS).equals(Constants.AJAX_SUCCESS)){
          ge.createThumbnail(up,Constants.FILE_TEMP_THUMB_PATH);
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      PrintWriter pr = res.getWriter();
      pr.print(up.toString());
      pr.close();
    }
    ge.closed();
    return;
  }

  private void doCreateSlide(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException 
  {

    res.setContentType("application/json;charset=utf-8");
    long maxSize = 512000; //limit file size 500kb
    String filter[] = {"jpg","png","gif"};
    
    SlideEngine se = new SlideEngine(req, res);
    JSONObject up = se.uploadFile(multiparts, Constants.PICLIB_PATH, filter, maxSize);
    
    int id = Integer.parseInt(getMultipartParam(Constants.FORM_SLIDE_ID));
    
    try {
      if(null!=up && up.getString(Constants.AJAX_STATUS).equals(Constants.AJAX_SUCCESS))
      {
        se.createThumbnail(up);
        System.out.println(up.toString());
        if(up.getString(Constants.AJAX_STATUS).equals(Constants.AJAX_SUCCESS)){
          SlideBean sbn = new SlideBean();
          sbn.setId(id);
          sbn.setPath(up.getString(Constants.FORM_FILE_PATH));
          sbn.setPathThumb(up.getString(Constants.FORM_FILE_PATHTHUMB));
          
          if(!se.createSlide(sbn)){
            up.put(Constants.AJAX_STATUS, Constants.AJAX_ERROR);
            up.put(Constants.AJAX_MESSAGE, "ERROR : Gagal menambah ke database!");
          }
        }
        
      }
    } catch (Exception e) {
      e.printStackTrace();
      try {
        if(null!=up){
          up.put(Constants.AJAX_STATUS, Constants.AJAX_ERROR);
          up.put(Constants.AJAX_MESSAGE, "ERROR : "+e.getMessage());
        }
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }

    if(null!=se)se.closed();
    PrintWriter pr = res.getWriter();
    pr.print(up.toString());
    pr.close();
    
    return;
  }

  private void generalUploadImage(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    res.setContentType("application/json;charset=utf-8");
    long maxSize = 512000; //limit file size 500kb
    String filter[] = {"jpg","png","gif"};
    
    UserEngine re = new UserEngine(req,res);
    JSONObject up = re.uploadFile(multiparts,Constants.PICLIB_PATH, filter, maxSize);
    
    
    if(null!=up){
      try {
        if(!up.get("ajax_status").equals("error")){
          re.createThumbnail(up);
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      PrintWriter pr = res.getWriter();
      pr.print(up.toString());
      pr.close();
    }
    re.closed();
    return;
  }
  
  private void doView(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    String w = req.getParameter(Constants.W);

    if(!Utilities.isEmpy(w) && w.equals(Constants.HOME_PRM))
    { 
      this.doViewHome(req, res);
    }
    else if(!Utilities.isEmpy(w) && w.equals(Constants.SLIDE_SETTING_PRM))
    {
      this.doSlideSetting(req,res);
    }
    else if(!Utilities.isEmpy(w) && w.equals(Constants.GALLERY_SETTING_PRM))
    {
      this.doGallerySetting(req,res);
    }   
    else if(!Utilities.isEmpy(w) && w.equals(Constants.NEWS_SETTING_PRM))
    {
      this.doNewsSetting(req,res);
    }    
    else if(!Utilities.isEmpy(w) && w.equals(Constants.COMPANY_SETTING_PRM))
    {
      this.doCompanySetting(req,res);
    }    
    else if(!Utilities.isEmpy(w) && w.equals(Constants.PROFILE_SETTING_PRM))
    {
      this.doProfileSetting(req,res);
    }    
    else if(!Utilities.isEmpy(w) && w.equals(Constants.DELETE_IMAGE_FILE))
    {
      this.doDeleteImage(req,res);
    }
    else //show website
    {
      this.doViewHome(req, res);
    }
    return;
  }
  
  private void doProfileSetting(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
  	if(!super.validateAcces(
  			req, 
  			res, 
  			Constants.PROFILE_SETTING_PRM, 
  			LevelAccessBean.PERMIT_INFO))
  	{
  		super.openURL(Constants.ERROR_PAGE, req, res);
  		return;
  	}
  	
    String act = req.getParameter(Constants.ACT);
    System.out.println("action : "+act);
    if (!Utilities.isEmpy(act) && act.equals(Constants.ACT_CREATE_SAVE)){
      CompanyEngine ce = new CompanyEngine(req, res);
      CompanyBean[] cbs = ce.validateContact();
      ce.createCompanySetting(cbs);
      ce.closed();
    }
  
    super.openContent(
        Constants.SERVLET_PATH, 
        Constants.PROFILE_SETTING_PRM, 
        Constants.PROFILE_SETTING_EDIT_PG, 
        req, res);
    return;
  }

  private void doCompanySetting(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
  	if(!super.validateAcces(
  			req, 
  			res, 
  			Constants.COMPANY_SETTING_PRM, 
  			LevelAccessBean.PERMIT_INFO))
  	{
  		super.openURL(Constants.ERROR_PAGE, req, res);
  		return;
  	}
  	
    String act = req.getParameter(Constants.ACT);
    System.out.println("action : "+act);
    if (!Utilities.isEmpy(act) && act.equals(Constants.ACT_CREATE_SAVE)){
      CompanyEngine ce = new CompanyEngine(req, res);
      CompanyBean[] cbs = ce.validateContact();
      ce.createCompanySetting(cbs);
      ce.closed();
    }

    super.openContent(
        Constants.SERVLET_PATH, 
        Constants.COMPANY_SETTING_PRM, 
        Constants.COMPANY_SETTING_EDIT_PG, 
        req, res);
    return;
  }

  private void doNewsSetting(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    String act = req.getParameter(Constants.ACT);
    System.out.println("action : "+act);
    if(!Utilities.isEmpy(act) && act.equals(Constants.ACT_INFO)){
      doNewsInfo(req,res);
    }
    else if (!Utilities.isEmpy(act) && (
        act.equals(Constants.ACT_UPDATE) || 
        act.equals(Constants.ACT_CREATE) || 
        act.equals(Constants.ACT_UPDATE_SAVE) || 
        act.equals(Constants.ACT_CREATE_SAVE)
        
    )){
      doNewsEdit(req,res);
    }
    else{
      doNewsList(req,res);
    }
    return;
  }

  private void doNewsInfo(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    String id = req.getParameter(Constants.FORM_NEWS_ID);
    NewsEngine ne = new NewsEngine(req, res);

    NewsBean nbn = ne.getNewsInfo(id);
    req.setAttribute(Constants.NEWS_SETTING_INFO_BEAN, nbn);
    
    ne.closed();
    
    super.openContent(
        Constants.SERVLET_PATH, 
        Constants.NEWS_SETTING_PRM, 
        Constants.NEWS_INFO_PG, 
        req, res);
    return;
  }

  private void doNewsEdit(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    String act = req.getParameter(Constants.ACT);
    String id = req.getParameter(Constants.FORM_NEWS_ID);
    NewsEngine ne = new NewsEngine(req, res);
    
    if(!Utilities.isEmpy(act) && act.equals(Constants.ACT_UPDATE)){
      NewsBean nbn = ne.getNewsInfo(id);
      req.setAttribute(Constants.NEWS_SETTING_INFO_BEAN, nbn);
      req.setAttribute(Constants.ACT, Constants.ACT_UPDATE_SAVE);
    }
    else if(!Utilities.isEmpy(act) && act.equals(Constants.ACT_CREATE_SAVE)){
      NewsBean nbn = ne.validateNews();
      nbn.setEntryDate(new Date());
      
      if(nbn.getMessageBean().anyMessageExist()){
        req.setAttribute(Constants.NEWS_SETTING_INFO_BEAN, nbn);
      }else{
        if(ne.createNews(nbn)){
          ne.closed();
          doNewsList(req, res);
          return;
        }else{
          req.setAttribute(Constants.NEWS_SETTING_INFO_BEAN, nbn);
        }        
      }
      
      req.setAttribute(Constants.ACT, Constants.ACT_CREATE_SAVE);
    }
    else if(!Utilities.isEmpy(act) && act.equals(Constants.ACT_UPDATE_SAVE)){
      NewsBean nbn = ne.validateNews();
      nbn.setID(Integer.parseInt(id));
      ne.updateNews(nbn);
      
      if(nbn.getMessageBean().anyMessageExist()){
        req.setAttribute(Constants.NEWS_SETTING_INFO_BEAN, nbn);
        req.setAttribute(Constants.ACT, Constants.ACT_UPDATE_SAVE);
      }else{
        ne.closed();
        doNewsList(req, res);
        return;
      }
      
    }
    else{
      req.setAttribute(Constants.ACT, Constants.ACT_CREATE_SAVE);
    }
    
    ne.closed();
    
    super.openContent(
        Constants.SERVLET_PATH, 
        Constants.NEWS_SETTING_PRM, 
        Constants.NEWS_EDIT_PG, 
        req, res);
    return;
    
  }

  private void doNewsList(HttpServletRequest req, HttpServletResponse res) 
  throws ServletException, IOException
  {
    String act = req.getParameter(Constants.ACT);
    String id = req.getParameter(Constants.FORM_NEWS_ID);
    
    NewsEngine ne = new NewsEngine(req,res);
    
    if(!Utilities.isEmpy(act) && act.equals(Constants.ACT_DELETE) && null==id)
    {
      doDeleteImage(req, res);
      return;
    }
    
    if(!Utilities.isEmpy(act) && act.equals(Constants.ACT_DELETE)){
      ne.deleteNews(id);
    }

    NewsBean[] nbn = ne.getNewsList();
    req.setAttribute(Constants.NEWS_SETTING_LIST_BEAN, nbn);
    
    ne.closed();
    super.openContent(
        Constants.SERVLET_PATH, 
        Constants.NEWS_SETTING_PRM, 
        Constants.NEWS_LIST_PG,
        req, res);
    return;
  }

  private void doGallerySetting(HttpServletRequest req, HttpServletResponse res) 
  throws ServletException, IOException
  {
    String act = req.getParameter(Constants.ACT);
    System.out.println("action : "+act);
    if(!Utilities.isEmpy(act) && (act.equals(Constants.ACT_LIST) || act.equals(Constants.ACT_DELETE))){
      doGalleryList(req,res);
    }
    else if (!Utilities.isEmpy(act) && (
        act.equals(Constants.ACT_UPDATE) || 
        act.equals(Constants.ACT_CREATE) || 
        act.equals(Constants.ACT_UPDATE_SAVE) || 
        act.equals(Constants.ACT_CREATE_SAVE)
        
    )){
      doGalleryEdit(req,res);
    }
    else{
      doGalleryView(req,res);
    }
    return;
  }

  private void doGalleryEdit(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    String act = req.getParameter(Constants.ACT);
    String id = req.getParameter(Constants.FORM_GALLERY_ID);
    GalleryEngine ge = new GalleryEngine(req, res);
    
    if(!Utilities.isEmpy(act) && act.equals(Constants.ACT_UPDATE)){
      GalleryBean gbn = ge.getGalleryInfo(id);
      req.setAttribute(Constants.GALLERY_SETTING_INFO_BEAN, gbn);
      req.setAttribute(Constants.ACT, Constants.ACT_UPDATE_SAVE);
    }
    else if(!Utilities.isEmpy(act) && act.equals(Constants.ACT_CREATE_SAVE)){
      GalleryBean gbn = ge.validateGallery();
      gbn.setDateCreate(new Date());
      
      if(gbn.getMessageBean().anyMessageExist()){
        req.setAttribute(Constants.GALLERY_SETTING_INFO_BEAN, gbn);
      }else{
        ge.createGallery(gbn);        
      }
      
      req.setAttribute(Constants.ACT, Constants.ACT_CREATE_SAVE);
    }
    else if(!Utilities.isEmpy(act) && act.equals(Constants.ACT_UPDATE_SAVE)){
      GalleryBean gbn = ge.validateGallery();
      gbn.setID(Integer.parseInt(id));
      ge.updateGallery(gbn);
      
      if(gbn.getMessageBean().anyMessageExist()){
        req.setAttribute(Constants.GALLERY_SETTING_INFO_BEAN, gbn);
        req.setAttribute(Constants.ACT, Constants.ACT_UPDATE_SAVE);
      }else{
        req.setAttribute(Constants.ACT, Constants.ACT_CREATE_SAVE);
      }
      
    }
    else{
      req.setAttribute(Constants.ACT, Constants.ACT_CREATE_SAVE);
    }
    
    ge.closed();
    
    super.openURL(Constants.GALLERY_EDIT_PG, req, res);
    return;
  }

  private void doGalleryList(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    String act = req.getParameter(Constants.ACT);
    String[] ids = req.getParameterValues(Constants.FORM_GALLERY_ID);
    
    System.out.println("content type : "+req.getContentType());
    System.out.println("content type : "+res.getContentType());
    GalleryEngine ge = new GalleryEngine(req,res);
    
    if(!Utilities.isEmpy(act) && act.equals(Constants.ACT_DELETE) && null==ids)
    {
      doDeleteImage(req, res);
      return;
    }
    
    if(!Utilities.isEmpy(act) && act.equals(Constants.ACT_DELETE)){
      ge.deleteGallery(ids);
    }

    GalleryBean[] gbn = ge.getGalleryList();
    req.setAttribute(Constants.GALLERY_SETTING_LIST_BEAN, gbn);
    
    ge.closed();
    super.openURL(Constants.GALLERY_LIST_PG, req, res);
    return;
  }

  private void doGalleryView(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {

    GalleryEngine ge = new GalleryEngine(req,res);
    GalleryBean[] gbn = ge.getGalleryList();
    req.setAttribute(Constants.GALLERY_SETTING_LIST_BEAN, gbn);
    req.setAttribute(Constants.ACT, Constants.ACT_CREATE_SAVE);
    
    ge.closed();
    super.openContent(
        Constants.SERVLET_PATH, 
        Constants.GALLERY_SETTING_PRM, 
        Constants.GALLERY_SETTING_PG, 
        req, res);
    return;
  }

  private void doSlideSetting(HttpServletRequest req, HttpServletResponse res) 
  throws ServletException, IOException
  {
    String act = req.getParameter(Constants.ACT);
    
    if(null!=act && act.equals(Constants.ACT_DELETE)){
      this.doDeleteSlide(req,res);
      return;
    }
    
    super.openContent(
        Constants.SERVLET_PATH, 
        Constants.SLIDE_SETTING_PRM, 
        Constants.SLIDE_SETTING_PG, 
        req, res);
    return;
  }

  private void doDeleteSlide(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
  {
    res.setContentType("application/json;charset=utf-8");
    System.out.println("mulai delete");
    
    SlideEngine se = new SlideEngine(req,res);
    JSONObject del = null;
    
    int id = Integer.parseInt(req.getParameter(Constants.FORM_SLIDE_ID));
    try {

      if(!se.deleteSlide(id)){
        del = new JSONObject();
        del.put(Constants.AJAX_STATUS, Constants.AJAX_ERROR);
        del.put(Constants.AJAX_MESSAGE, "ERROR : Gagal menghapus database!");
      }else{
        del = se.deleteImageFile();
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    System.out.println("selesai delete");
    
    se.closed();
    
    PrintWriter pr = res.getWriter();
    pr.print(del.toString());
    pr.close();
    
    return;
  }

  private void doDeleteImage(HttpServletRequest req, HttpServletResponse res) 
  throws ServletException, IOException
  {
    res.setContentType("application/json;charset=utf-8");
    System.out.println("mulai delete");
    
    UserEngine re = new UserEngine(req,res);
    JSONObject del = re.deleteImageFile();
    
    System.out.println("selesai delete");

    if(null!=del){
      PrintWriter pr = res.getWriter();
      pr.print(del.toString());
      pr.close();
    }
    re.closed();
    return;
  }

  private void doViewHome(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    String act = req.getParameter(Constants.ACT);
    
    if(!Utilities.isEmpy(act) && act.equals(Constants.ACT_LIST)){
      MasterResidentEngine re = new MasterResidentEngine(req, res);
      MasterResidentBean[] lists = re.listOfResidents();
      
      req.setAttribute(MasterConstants.MASTERRESIDENT_LIST, lists);
      
      if(null!=re)re.closed();
    }else if(!Utilities.isEmpy(act) && act.equals(Constants.ACT_INFO)){
      String nik = req.getParameter(MasterConstants.FORM_MASTERRESIDENT_NIK);
      MasterResidentEngine re = new MasterResidentEngine(req, res);
      MasterResidentBean rebn = null;
      
      rebn = re.getMasterResidentInfo(nik);
      System.out.println("DISPLAYING INFO RESIDENT");
      req.setAttribute(MasterConstants.MASTERRESIDENT_INFO, rebn);
      
      if(null!=re)re.closed();
      super.openContent(
          Constants.SERVLET_PATH, 
          Constants.HOME_PRM, 
          Constants.HOME_INFO_PAGE, 
          req, res);
      return;
    }
    
    super.openContent(
        Constants.SERVLET_PATH, 
        Constants.HOME_PRM, 
        Constants.HOME_PAGE, 
        req, res);
    return;
  }
  
  /** Logon process */
  private void doLogon(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
     session=req.getSession(true);
     String act  = req.getParameter(Constants.ACT);
     MasterUserBean usrbn = new MasterUserBean();
    
    if(!Utilities.isEmpy(act) && act.equals(Constants.ACT_LOGIN))
    {
      UserEngine ue = new UserEngine(req, res);
      usrbn = ue.validateLogin();
      
      req.setAttribute(MasterConstants.MASTERUSER, usrbn);
      if(!Utilities.isEmpy(usrbn.getUser()))
      {
        session.setAttribute(MasterConstants.MASTERUSER, usrbn);
        super.openURL(Constants.GATEWAY_PAGE, req, res);
        return;
      }
      else
      {
        MessageBean msg = usrbn.getMessageBean();
        System.out.println("ERR = "+msg.getMessageBean(Constants.FORM_LOGIN_PASSWD));
        session.setAttribute(MasterConstants.MASTERUSER, usrbn);
        super.openURL(Constants.LOGIN_PAGE, req, res);
        return;
      }
    }
    else
    {
      usrbn = (MasterUserBean)session.getAttribute(MasterConstants.MASTERUSER);
      if(null!=usrbn){
        super.openURL(Constants.GATEWAY_PAGE, req, res);
      }else{
        super.openURL(Constants.LOGIN_PAGE, req, res);
      }
      return;
    }
  }
  
  /** Logout process */
  private void doLogout(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    if(null!=session){
      session.invalidate();
      session = null;
    }
    super.openURL(Constants.LOGIN_PAGE, req, res);
    return;
  }
  
  
}