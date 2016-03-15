package com.sync.core.utils;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;

import com.sync.core.beans.ContentBean;
import com.sync.core.engine.ConnectionManager;
import com.sync.core.pool.GalleryPool;
import com.sync.core.pool.SlidePool;



public class ServletUtilities extends HttpServlet
{
  private static final long serialVersionUID = 5530948851442982169L;
  protected JSONObject mp = null;
  protected List<FileItem> multiparts = null;
  
  public void init() throws ServletException
  {
    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>> INITIALIZE SERVLET ");
    initConn();
    initPool();
  }

  /** initiate db connection */
  private void initConn()
  {
    try
    {
      ConnectionManager cm = ConnectionManager.getInstance();
      cm.initDB();
    }
    catch(Exception e)
    { e.printStackTrace(); }
  }
  
  private void initPool() {
    this.loadSlidePool();
    this.loadGalleryPool();
    return;
  }
  

  private void loadSlidePool() {
    
    try {
      SlidePool sp = SlidePool.getInstance();
      
      if(sp.reload()){
        System.out.println("Slide Pool diisi untuk pertama kali");
      }else{
        System.out.println("Gagal mengisi Slide Pool untuk pertama kali");
      }
      
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Kesalahan mengisi Slide Pool untuk pertama kali");
    }
    return;
  }

  private void loadGalleryPool() {
    
    try {
      GalleryPool gp = GalleryPool.getInstance();
      
      if(gp.reload()){
        System.out.println("Gallery Pool diisi untuk pertama kali");
      }else{
        System.out.println("Gagal mengisi Gallery Pool untuk pertama kali");
      }
      
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Kesalahan mengisi Gallery Pool untuk pertama kali");
    }
    return;
  }

  public void isMultipartForm(HttpServletRequest req)
  throws ServletException, IOException
  {
    // Create a factory for disk-based file items
    FileItemFactory factory = new DiskFileItemFactory();
    
    // Create a new file upload handler
    ServletFileUpload upload = new ServletFileUpload(factory);
    mp = null;
    try {
      // Parse the request
      multiparts = upload.parseRequest(req);
      mp = new JSONObject();
      
      for (FileItem item : multiparts) {
        System.out.println("is form field : "+item.isFormField());
        if (item.isFormField()) {
          if(!Utilities.isEmpy(item.getFieldName()) && !Utilities.isEmpy(item.getString())){
            mp.put(item.getFieldName(), item.getString());
          }
        }
      }
    } 
    catch (Exception e) 
    {
      e.printStackTrace();
    }
    return;
  }
  
  public String getMultipartParam(String Name){
    try {
      if(null==mp){return null;}
      
      if(!mp.has(Name)){return null;}
      
      return mp.getString(Name);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
    
  }
  
  public void openURL
  (
    String url,
    HttpServletRequest req, 
    HttpServletResponse res
  )
  throws ServletException, IOException
  {
    RequestDispatcher rd = this.getServletConfig().
        getServletContext().getRequestDispatcher(url);
    
    rd.forward(req, res);
    return;
  }
  
  public void openContent
  (
    String svt,
    String prm,
    String urlPg,
    HttpServletRequest req, 
    HttpServletResponse res
  )
  throws ServletException, IOException
  {
    HttpSession ses = req.getSession(true);
    ContentBean cb = new ContentBean();
    
    cb.setCurrParam(prm);
    cb.setCurrServlet(svt);
    cb.setCurrPG(urlPg);
    
    ses.setAttribute(Constants.CONTENT_INFO, cb);
    
    openURL(Constants.CONTENT_PAGE, req, res);
    return;
  }
  
  public void openLookup
  (
    String urlPg,
    HttpServletRequest req, 
    HttpServletResponse res
  )
  throws ServletException, IOException
  {
    req.setAttribute(Constants.CONTENT_INFO, urlPg);
    
    openURL(Constants.LOOKUP_PAGE, req, res);
    return;
  }
}