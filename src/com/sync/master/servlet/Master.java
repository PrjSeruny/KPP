package com.sync.master.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sync.core.beans.MessageBean;
import com.sync.core.servlet.CoreServlet;
import com.sync.core.utils.Constants;
import com.sync.core.utils.Utilities;
import com.sync.master.beans.LevelAccessBean;
import com.sync.master.beans.MasterLevelAccessBean;
import com.sync.master.beans.MasterRegionBean;
import com.sync.master.beans.MasterRegionKecamatanBean;
import com.sync.master.beans.MasterRegionKelurahanBean;
import com.sync.master.beans.MasterResidentBean;
import com.sync.master.beans.MasterUserBean;
import com.sync.master.engine.LevelAccessEngine;
import com.sync.master.engine.MasterLevelEngine;
import com.sync.master.engine.MasterRegionEngine;
import com.sync.master.engine.MasterResidentEngine;
import com.sync.master.engine.UserEngine;
import com.sync.master.utils.MasterConstants;


public class Master extends CoreServlet 
{
  /**
   * 
   */
  private static final long serialVersionUID = -8355012163307129032L;
  
  public void init(){}
  
  /** Default method first calling in servlet */
  public void doGet(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    this.doPost(req, res);
    return;
  }
  
  public void doPost(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    String what = req.getParameter(Constants.W);
    if(!Utilities.isEmpy(what) && what.equals(MasterConstants.MASTERUSER))
    {
      this.MasterUser(req, res);
    }
    else if(!Utilities.isEmpy(what) && what.equals(MasterConstants.MASTER_REGION))
    {
      this.MasterRegion(req, res);
    }
    else if(!Utilities.isEmpy(what) && what.equals(MasterConstants.MASTER_RESIDENT))
    {
      this.MasterResident(req, res);
    }
    else if(!Utilities.isEmpy(what) && what.equals(MasterConstants.MASTER_LEVEL_ACCESS))
    { this.MasterlevelAccess(req, res); }
    else if(!Utilities.isEmpy(what) && what.equals(MasterConstants.LEVELACCESS))
    { this.LevelAccess(req, res); }
    else
    {
      super.openURL(MasterConstants.HOME_PAGE, req, res);
    }
    return;
  }
  
  /** Manage route of Master User */
  private void MasterUser(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    String act = req.getParameter(MasterConstants.ACT);
    
    if(!Utilities.isEmpy(act) && act.equals(MasterConstants.ACT_CREATE))
    {
      this.doCreateMasterUser(req, res);
    }
    else if(!Utilities.isEmpy(act) && act.equals(MasterConstants.ACT_UPDATE))
    {
      this.doUpdateMasterUser(req, res);
    }
    else if(!Utilities.isEmpy(act) && act.equals(MasterConstants.ACT_DELETE))
    {
      this.doDeleteMasterUser(req, res);
    }
    else if(!Utilities.isEmpy(act) && act.equals(MasterConstants.ACT_INFO))
    {
      this.doViewMasterUser(req, res);
    }
    else if
    (
        !Utilities.isEmpy(act) && 
        (act.equals(MasterConstants.ACT_LIST) || act.equals(MasterConstants.ACT_LOOKUP))
    )
    {
      this.doListMasterUsers(req, res);
    }
    else
    {
      this.doViewMasterUser(req, res);
    }
    return;
  }
  
  /** Manage route of Master Regions */
  private void MasterRegion(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {

    String act = req.getParameter(MasterConstants.ACT);
    
    if(!Utilities.isEmpy(act) && act.equals(MasterConstants.ACT_CREATE))
    {
      this.doCreateMasterRegion(req, res);
    }
    else if(!Utilities.isEmpy(act) && act.contains(MasterConstants.ACT_UPDATE))
    {
      this.doUpdateMasterRegion(req, res);
    }
    else if(!Utilities.isEmpy(act) && act.equals(MasterConstants.ACT_DELETE))
    {
      this.doDeleteMasterRegion(req, res);
    }
    else if(!Utilities.isEmpy(act) && act.equals(MasterConstants.ACT_INFO))
    {
      this.doViewMasterRegion(req, res);
    }
    else if(!Utilities.isEmpy(act) && act.equals(MasterConstants.ACT_LOOKUP))
    {
      this.doLookupMasterRegion(req, res);
    }
    else
    {
      this.doMasterRegion(req, res);
    }
  }
  
  private void doCreateMasterRegion(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    
  }
  
  private void doUpdateMasterRegion(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    
  }
  
  private void doDeleteMasterRegion(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    
  }
  
  private void doViewMasterRegion(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    System.out.println("VIEWING INFO REGION");
    String regID = req.getParameter(MasterConstants.FORM_MASTERREGION_REGID);
    MasterRegionEngine re = new MasterRegionEngine(req, res);
    MasterRegionBean rebn = null;
    
    if(null!=req.getParameter(MasterConstants.BTN_DONE))
    {
        this.doMasterRegion(req, res);
        return;
    }
    
    rebn = re.getMasterRegionInfo(regID);
    System.out.println("DISPLAYING INFO REGION");
    req.setAttribute(MasterConstants.MASTERREGION_INFO, rebn);
    
    if(null!=re)re.closed();
    super.openContent(MasterConstants.SVT_MASTER_PATH, 
        MasterConstants.MASTER_REGION, 
        MasterConstants.MASTER_REGION_INFO, req, res);
    return;
  
  }
  
  private void doMasterRegion(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    String stat = req.getParameter(MasterConstants.DATA_STAT);
    MasterRegionEngine re = new MasterRegionEngine(req, res);
    MasterRegionBean[] lists = re.listOfRegion(stat);
    
    req.setAttribute(MasterConstants.MASTERREGION_LIST, lists);
    
    if(null!=re)re.closed();
    super.openContent(
        MasterConstants.SVT_MASTER_PATH, 
        MasterConstants.MASTER_REGION, 
        MasterConstants.MASTER_REGION_LIST, 
        req, res);
    return;
  
  }
  
  private void doLookupMasterRegion(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    String _for = req.getParameter(MasterConstants.FOR);
    MasterRegionBean[] bn = null;
    String regID = null;
    String kecID = null;
    MasterRegionKecamatanBean[] regKec = null;
    MasterRegionKelurahanBean[] regKel = null;
    MasterRegionEngine re = new MasterRegionEngine(req, res);
    boolean showW = Boolean.parseBoolean(req.getParameter(MasterConstants.FORM_MASTERREGION_REGIONONLY));
    String propfield=req.getParameter(MasterConstants.FORM_FIELD1);
    String cityfield=req.getParameter(MasterConstants.FORM_FIELD2);
    String kecfield = req.getParameter(MasterConstants.FORM_FIELD3);
    String kelfield = req.getParameter(MasterConstants.FORM_FIELD4);
    
    System.out.println(">>>>>>>>>>>>>>>>>>> SHOW WHAT"+showW);
    System.out.println(">>>>>>>>>>>>>>>>>>> prop="+propfield+" ciry="+cityfield+ " kec="+kecfield+ " kelfield="+kelfield);
    
    if(!Utilities.isEmpy(_for) && _for.equals(MasterConstants.FOR_KEC))
    {
      regID = req.getParameter(MasterConstants.FORM_MASTERREGION_REGID);
      regKec = re.getKecamatanInfo(regID);
      req.setAttribute(MasterConstants.MASTERREGION_KEC_LIST, regKec);
      req.setAttribute(MasterConstants.FORM_FIELD1, propfield);
      req.setAttribute(MasterConstants.FORM_FIELD2, cityfield);
      req.setAttribute(MasterConstants.FORM_FIELD3, kecfield);
      req.setAttribute(MasterConstants.FORM_FIELD4, kelfield);
      super.openLookup(MasterConstants.MASTER_REGION_LOOKUP, req, res);
      return;
    }
    else if(!Utilities.isEmpy(_for) && _for.equals(MasterConstants.FOR_KEL))
    {
      regID = req.getParameter(MasterConstants.FORM_MASTERREGION_REGID);
      kecID = req.getParameter(MasterConstants.FORM_MASTERREGION_KECID);
      regKel = re.getKelurahanInfo(regID, kecID);
      req.setAttribute(MasterConstants.MASTERREGION_KEL_LIST, regKel);
      req.setAttribute(MasterConstants.FORM_FIELD1, propfield);
      req.setAttribute(MasterConstants.FORM_FIELD2, cityfield);
      req.setAttribute(MasterConstants.FORM_FIELD3, kecfield);
      req.setAttribute(MasterConstants.FORM_FIELD4, kelfield);
      super.openLookup(MasterConstants.MASTER_REGION_LOOKUP, req, res);
      return;
    }
    else
    {
      bn = re.listOfRegion(MasterConstants.DATA_CURRENT);
      req.setAttribute(MasterConstants.FORM_MASTERREGION_REGIONONLY, showW);
      req.setAttribute(MasterConstants.MASTERREGION_LIST, bn);
      req.setAttribute(MasterConstants.FORM_FIELD1, propfield);
      req.setAttribute(MasterConstants.FORM_FIELD2, cityfield);
      req.setAttribute(MasterConstants.FORM_FIELD3, kecfield);
      req.setAttribute(MasterConstants.FORM_FIELD4, kelfield);
      super.openLookup(MasterConstants.MASTER_REGION_LOOKUP, req, res);
      return;
    }
  }
  
  private void MasterResident(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    String act = req.getParameter(MasterConstants.ACT);
    
    if(!Utilities.isEmpy(act) && 
        (act.equals(MasterConstants.ACT_CREATE)||
            act.equals(MasterConstants.ACT_CREATE_SAVE))
      )
    {
      this.doCreateMasterResident(req, res);
    }
    else 
      if(!Utilities.isEmpy(act) && 
        (act.equals(MasterConstants.ACT_UPDATE) || 
            act.equals(MasterConstants.ACT_UPDATE_SAVE))
       )
    {
      this.doUpdateMasterResident(req, res);
    }
    else if(!Utilities.isEmpy(act) && act.equals(MasterConstants.ACT_DELETE))
    {
      this.doDeleteMasterResident(req, res);
    }
    else if(!Utilities.isEmpy(act) && act.equals(MasterConstants.ACT_LIST))
    {
      this.doListMasterResidents(req, res);
    }
    else if(!Utilities.isEmpy(act) && act.equals(MasterConstants.ACT_INFO))
    {
      this.doViewMasterResident(req, res);
    }
    else if(!Utilities.isEmpy(act) && act.equals(MasterConstants.ACT_LOOKUP))
    {
      this.doLookupMasterResidents(req, res);
    }
    else
    {
      this.doMasterResidents(req, res);
    }
    return;
  }
  
  private void doMasterResidents(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    MasterResidentEngine ue = new MasterResidentEngine(req, res);
    MasterResidentBean[] lists = ue.listOfResidents();
    
    req.setAttribute(MasterConstants.MASTERRESIDENT_LIST, lists);
    
    if(null!=ue)ue.closed();
    super.openContent(
        MasterConstants.SVT_MASTER_PATH, 
        MasterConstants.MASTER_RESIDENT, 
        MasterConstants.MASTER_RESIDENTS, 
        req, res);
    return;
  }
  
  private void doCreateMasterUser(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    System.out.println("BEGINNING CREATE USER");
    UserEngine ue = new UserEngine(req, res);
    MasterUserBean ubn = ue.validate();
    
    if(ubn.getMessageBean().anyMessageExist())
    {
      System.out.println("THERE IS ERROR ON INPUT USER");
      req.setAttribute(MasterConstants.USER_INFO, ubn);
    }else{
      if(!ue.createMasterUser(ubn)){
        System.out.println("THERE IS ERROR ON CREATE USER");
        ubn.getMessageBean().setMessageBean(MasterConstants.ERRORMSG_PAGE, 
            "Error : Gagal menambahkan user!");
        req.setAttribute(MasterConstants.USER_INFO, ubn);
      }
      System.out.println("FINISH CREATE USER");
    }
    
    ue.closed();
    this.doViewMasterUser(req, res);
    return;
  }
  
  private void doUpdateMasterUser(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    System.out.println("BEGINNING UPDATE USER >>>>>>>>>>>>>>>>>>>>>>>> ");
    String userID = req.getParameter(MasterConstants.FORM_MASTERUSER_USERID);
    UserEngine ue = new UserEngine(req, res);
    MasterLevelEngine LvlEngine = new MasterLevelEngine(req,res);
    MasterUserBean ubn = null;
    MasterLevelAccessBean[] AccessBn;
    
    if(
        !Utilities.isEmpy(req.getParameter(MasterConstants.BTN_DONE)) ||
        !Utilities.isEmpy(req.getParameter(MasterConstants.BTN_CANCEL))
      )
    {
      System.out.println("DONE PRESSED");
      this.doViewMasterUser(req, res);
      return;
    }
    
    if(Utilities.isEmpy(userID))
    {
      System.out.println("NO USERID");
      super.openURL(MasterConstants.ERRORMSG_PAGE, req, res);
      return;
    }
    
    if(!Utilities.isEmpy(req.getParameter(MasterConstants.BTN_SAVE)))
    {
      System.out.println("ENTER VALIDATE USER INPUT");
      ubn = ue.validate();
      if(ubn.getMessageBean().anyMessageExist())
      {
        req.setAttribute(MasterConstants.USER_INFO, ubn);
      }else{
        if(!ue.updateMasterUser(ubn)){
          ubn.getMessageBean().setMessageBean(MasterConstants.ERRORMSG_PAGE, 
              "Error : Gagal merubah user!");
          req.setAttribute(MasterConstants.USER_INFO, ubn);
        }else{
          if(null!=ue)ue.closed();
          this.doViewMasterUser(req, res);
          return;
        }
      }
    }

      
    if(null==ubn)
    {
      ubn = ue.getMasterUserInfo(userID);
      AccessBn = LvlEngine.listOfAccess();
      req.setAttribute(MasterConstants.MASTERLEVEL_LIST, AccessBn);
      req.setAttribute(MasterConstants.USER_INFO, ubn);
    }
    
    if(null!=ue)ue.closed();
    super.openContent(
        MasterConstants.SVT_MASTER_PATH, 
        MasterConstants.MASTERUSER, 
        MasterConstants.MASTER_USER_EDIT, 
        req, res);
    return;
    
  }
  
  private void doDeleteMasterUser(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    UserEngine ue = new UserEngine(req, res);
    ue.deleteMasterUser();
    ue.closed();
    this.doListMasterUsers(req, res);
    return;
  }
  
  private void doViewMasterUser(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    /*String userID = req.getParameter(MasterConstants.FORM_MASTERUSER_USERID);
    UserEngine ue = new UserEngine(req, res);
    MasterUserBean ubn = null; 
    ubn = ue.getMasterUserInfo(userID);
    
    req.setAttribute(MasterConstants.USER_INFO, ubn);*/
    UserEngine ue = new UserEngine(req, res);
    MasterLevelEngine LevelEng = new MasterLevelEngine(req, res);
    MasterUserBean[] lists = ue.listOfUsers();
    MasterLevelAccessBean[] acccessLists = LevelEng.listOfAccess();
    req.setAttribute(MasterConstants.MASTERLEVEL_LIST, acccessLists);
    req.setAttribute(MasterConstants.USER_LIST, lists);
    
    ue.closed();
    LevelEng.closed();
    super.openContent(
        MasterConstants.SVT_MASTER_PATH, 
        MasterConstants.MASTERUSER, 
        MasterConstants.MASTER_USER, 
        req, res);
    return;
  }
  
  private void doListMasterUsers(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    String act = req.getParameter(MasterConstants.ACT);
    
    UserEngine ue = new UserEngine(req, res);
    MasterUserBean[] lists = ue.listOfUsers();
    
    req.setAttribute(MasterConstants.USER_LIST, lists);
    ue.closed();
    
    if(act.equals(MasterConstants.ACT_LOOKUP))
    {
      super.openLookup(MasterConstants.MASTER_USER_LOOKUP, req, res);
      return;
    }
    
    super.openURL(
        MasterConstants.MASTER_USER_LIST, 
        req, res);
    return;
  }
  
  private void doCreateMasterResident(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    System.out.println("CREATE NEW RESIDENT");
    String act = req.getParameter(MasterConstants.ACT);
    MasterResidentEngine re = new MasterResidentEngine(req, res);
    MasterResidentBean rbn = null;
    System.out.println("ACTION= "+act);
    
    if(null!=req.getParameter(MasterConstants.BTN_CANCEL))
    {
      System.out.println("BTN CANCEL PRESSED>>>>>>>>>>>>>>>>>>>> ");
      this.doMasterResidents(req, res);
      return;     
    }
    
    if(!Utilities.isEmpy(act) && act.equals(MasterConstants.ACT_CREATE_SAVE))
    {
      System.out.println("SAVING AND VALIDATING NEW RESIDENT");
      rbn = re.validate();
      req.setAttribute(MasterConstants.MASTERRESIDENT_INFO, rbn);
      
      if(null!=rbn && rbn.getBeanMessages().isErrorExist())
      {
        System.out.println("SAVING AND VALIDATING NEW RESIDENT ERROR EXIST");
        req.setAttribute(MasterConstants.MASTERRESIDENT_INFO, rbn);
        req.setAttribute(MasterConstants.ACT, MasterConstants.ACT_CREATE_SAVE);
        super.openContent(MasterConstants.SVT_MASTER_PATH, 
            MasterConstants.MASTER_RESIDENT, 
            MasterConstants.MASTER_RESIDENT_EDIT, req, res);
        return;      
      }
      
      if(!re.createMasterResident(rbn))
      {
        if(null!=re)re.closed();
        req.setAttribute(MasterConstants.MASTERRESIDENT_INFO, rbn);
        super.openContent(MasterConstants.SVT_MASTER_PATH, 
            MasterConstants.MASTER_RESIDENT, 
            MasterConstants.MASTER_RESIDENT_EDIT, req, res);
        return;
      }
      
      if(null!=re)re.closed();
      req.setAttribute(MasterConstants.MASTERRESIDENT_INFO, rbn);
      super.openContent(MasterConstants.SVT_MASTER_PATH, 
                        MasterConstants.MASTER_RESIDENT, 
                        MasterConstants.MASTER_RESIDENT_INFO, req, res);
      return;
    }
    else
    {
      System.out.println("OPEN PAGE CREATE NEW RESIDENT");
      req.setAttribute(MasterConstants.ACT, MasterConstants.ACT_CREATE_SAVE);
      super.openContent(MasterConstants.SVT_MASTER_PATH, 
          MasterConstants.MASTER_RESIDENT, 
          MasterConstants.MASTER_RESIDENT_EDIT, req, res);
      return;      
    }
  }
  
  private void doUpdateMasterResident(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    System.out.println("UPDATING MASTER RESIDEN");
    String nik = req.getParameter(MasterConstants.FORM_MASTERRESIDENT_NIK);
    String act = req.getParameter(MasterConstants.ACT);
    MasterResidentEngine re = new MasterResidentEngine(req, res);
    MasterResidentBean rebn = null;
    MessageBean msg = null;
    
    System.out.println("ACTION= "+act);
    
    if(
        !Utilities.isEmpy(req.getParameter(MasterConstants.BTN_DONE)) ||
        !Utilities.isEmpy(req.getParameter(MasterConstants.BTN_CANCEL))
      )
    {
      System.out.println("DONE PRESSED");
      this.doViewMasterResident(req, res);
      return;
    }
    
    if(Utilities.isEmpy(nik))
    {
      System.out.println("NO NIK");
      super.openURL(MasterConstants.ERRORMSG_PAGE, req, res);
      return;
    }
    
    if(!Utilities.isEmpy(act) && act.equals(MasterConstants.ACT_UPDATE_SAVE))
    {
      System.out.println("ENTER VALIDATE USER INPUT");
      rebn = re.validate();
      req.setAttribute(MasterConstants.ACT, MasterConstants.ACT_UPDATE_SAVE);
      msg = rebn.getBeanMessages();
      
      if(null!=msg && msg.isErrorExist())
      {
        System.out.println("ERROR VALIDATING UPDATING");
      }
      
      if(!re.updateMasterResident(rebn))
      {
        System.out.println("ERROR UPDATING");
      }
      
      if(null!=re) re.closed();
      this.doViewMasterResident(req, res);
      return;
    }
    else
    {
      System.out.println("ENTER GETTING USER DETAIL INFO");
      rebn = re.getMasterResidentInfo(nik);
      if(null!=rebn)
      {
        System.out.println("NIK= "+rebn.getNIK());
        System.out.println("Nama= "+rebn.getName());
        req.setAttribute(MasterConstants.MASTERRESIDENT_INFO, rebn);
        req.setAttribute(MasterConstants.ACT, MasterConstants.ACT_UPDATE_SAVE);
      }
      super.openContent(MasterConstants.SVT_MASTER_PATH, 
          MasterConstants.MASTER_RESIDENT, 
          MasterConstants.MASTER_RESIDENT_EDIT, req, res);
      return;
    }
  }
  
  private void doDeleteMasterResident(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    System.out.println("PREPARING DELETE RESIDENT");
    String[] niks = req.getParameterValues(MasterConstants.CHKBOX);
    
    if(null==niks)
    {
      System.out.println("Mohon dicentang data yang ingin dihapus");
    }
    else
    {
      System.out.println("DATA DEL= "+niks.length);
    }
    
    MasterResidentEngine re = new MasterResidentEngine(req, res);
    if(!re.delete(niks))
    {
      System.out.println("ERROR DELETING DATA");
    }
    
    if(null!=re)re.closed();
    this.doListMasterResidents(req, res);
    return;
  }
  
  private void doViewMasterResident(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    System.out.println("VIEWING INFO RESIDENT");
    String nik = req.getParameter(MasterConstants.FORM_MASTERRESIDENT_NIK);
    MasterResidentEngine re = new MasterResidentEngine(req, res);
    MasterResidentBean rebn = null;
    
    if(null!=req.getParameter(MasterConstants.BTN_DONE))
    {
        this.doMasterResidents(req, res);
        return;
    }
    
    rebn = re.getMasterResidentInfo(nik);
    System.out.println("DISPLAYING INFO RESIDENT");
    req.setAttribute(MasterConstants.MASTERRESIDENT_INFO, rebn);
    
    if(null!=re)re.closed();
    super.openContent(MasterConstants.SVT_MASTER_PATH, 
        MasterConstants.MASTER_RESIDENT, 
        MasterConstants.MASTER_RESIDENT_INFO, req, res);
    return;
  }
  
  private void doLookupMasterResidents(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException
      {
        String _for = req.getParameter(MasterConstants.FOR);
        MasterResidentBean[] bn = null;
        MasterResidentEngine re = new MasterResidentEngine(req, res);
        
        bn = re.lookup();
        req.setAttribute(MasterConstants.MASTERRESIDENT_LIST, bn);
        super.openLookup(MasterConstants.MASTER_RESIDENT_LOOKUP, req, res);
        return;
      
      }
  
  private void doListMasterResidents(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    MasterResidentEngine re = new MasterResidentEngine(req, res);
    MasterResidentBean[] lists = re.listOfResidents();
    
    req.setAttribute(MasterConstants.MASTERRESIDENT_LIST, lists);
    
    if(null!=re)re.closed();
    super.openURL(
        MasterConstants.MASTER_RESIDENT_LIST, 
        req, res);
    return;
  }
  
  private void MasterlevelAccess(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    String act = req.getParameter(MasterConstants.ACT);
    
    if(!Utilities.isEmpy(act) && act.equals(MasterConstants.ACT_CREATE))
    {
      this.doCreateMasterLevel(req, res);
    }
    else if(!Utilities.isEmpy(act) && act.equals(MasterConstants.ACT_UPDATE))
    {
      this.doUpdateMasterLevel(req, res);
    }
    else if(!Utilities.isEmpy(act) && act.equals(MasterConstants.ACT_DELETE))
    {
      //this.doDeleteMasterUser(req, res);
    }
    else if(!Utilities.isEmpy(act) && act.equals(MasterConstants.ACT_INFO))
    {
      this.doViewMasterLevelAccess(req, res);
    }
    else if
    (
        !Utilities.isEmpy(act) && 
        (act.equals(MasterConstants.ACT_LIST) || act.equals(MasterConstants.ACT_LOOKUP))
    )
    {
      this.doListMasterLevelAccess(req, res);
    }
    else
    {
      this.doViewMasterLevelAccess(req, res);
    }
    return;
  }
  
  private void doViewMasterLevelAccess(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    MasterLevelEngine LevelEng = new MasterLevelEngine(req, res);
    MasterLevelAccessBean[] acccessLists = LevelEng.listOfAccess();
    req.setAttribute(MasterConstants.MASTERLEVEL_LIST, acccessLists);
    
    LevelEng.closed();
    super.openContent(
        MasterConstants.SVT_MASTER_PATH, 
        MasterConstants.MASTER_LEVEL_ACCESS, 
        MasterConstants.MASTER_LEVELACCESS_PG, 
        req, res);
    return;
  }
  
  private void doCreateMasterLevel(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
  	System.out.println("BEGINNING CREATE ACCESS LEVEL");
    MasterLevelEngine ml = new MasterLevelEngine(req, res);
    MasterLevelAccessBean ubn = ml.validate();
    
    if(ubn.getMessageBean().anyMessageExist())
    {
      System.out.println("THERE IS ERROR ON INPUT MASTER LEVEL");
      req.setAttribute(MasterConstants.MASTERLEVEL_INFO, ubn);
    }
    else
    {
      if(!ml.insert(ubn))
      {
        System.out.println("THERE IS ERROR ON CREATE MASTER LEVEL");
        ubn.getMessageBean().setMessageBean(MasterConstants.ERRORMSG_PAGE, 
            "Error : Gagal menambahkan user!");
        req.setAttribute(MasterConstants.MASTERLEVEL_INFO, ubn);
      }
      System.out.println("FINISH CREATE USER");
    }
    
    ml.closed();
    this.doViewMasterLevelAccess(req, res);
    return;
  }
  
  private void doUpdateMasterLevel(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
  	String LevelID = req.getParameter(MasterConstants.FORM_MASTERUSERLEVELACCESS_LEVELID);
  	MasterLevelEngine ml = new MasterLevelEngine(req, res);
  	MasterLevelAccessBean bn = null;
  	
  	if(
        !Utilities.isEmpy(req.getParameter(MasterConstants.BTN_DONE)) ||
        !Utilities.isEmpy(req.getParameter(MasterConstants.BTN_CANCEL))
      )
    {
      System.out.println("DONE PRESSED");
      this.doViewMasterLevelAccess(req, res);
      return;
    }
  	
  	if(Utilities.isEmpy(LevelID))
    {
      System.out.println("NO USERID");
      super.openURL(MasterConstants.ERRORMSG_PAGE, req, res);
      return;
    }
  	
  	if(!Utilities.isEmpy(req.getParameter(MasterConstants.BTN_SAVE)))
    {
      System.out.println("ENTER VALIDATE USER INPUT");
      bn = ml.validate();
      if(bn.getMessageBean().anyMessageExist())
      {
        req.setAttribute(MasterConstants.MASTERLEVEL_INFO, bn);
      }
      else
      {
        if(!ml.update(bn))
        {
          bn.getMessageBean().setMessageBean(MasterConstants.ERRORMSG_PAGE, 
              "Error : Gagal merubah user!");
          req.setAttribute(MasterConstants.MASTERLEVEL_INFO, bn);
        }
        else
        {
          if(null!=ml) ml.closed();
          this.doViewMasterLevelAccess(req, res);
          return;
        }
      }
    }
  	
  	if(null==bn)
    {
      bn = ml.getAccessInfo(LevelID);
      req.setAttribute(MasterConstants.MASTERLEVEL_INFO, bn);
    }
    
    if(null!=ml) ml.closed();
    super.openContent(
        MasterConstants.SVT_MASTER_PATH, 
        MasterConstants.MASTER_LEVEL_ACCESS, 
        MasterConstants.MASTER_LEVELACCESS_EDIT, 
        req, res);
    return;
  }
  
  private void doListMasterLevelAccess(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    String act = req.getParameter(MasterConstants.ACT);
    
    MasterLevelEngine ml = new MasterLevelEngine(req, res);
    MasterLevelAccessBean[] lists = ml.listOfAccess();
    
    req.setAttribute(MasterConstants.MASTERLEVEL_LIST, lists);
    ml.closed();
    
    if(act.equals(MasterConstants.ACT_LOOKUP))
    {
      super.openLookup(MasterConstants.MASTER_LEVELACCESS_LOOKUP, req, res);
      return;
    }
    
    super.openContent(
        MasterConstants.SVT_MASTER_PATH, 
        MasterConstants.MASTER_LEVEL_ACCESS, 
        MasterConstants.MASTER_LEVELACCESS_LIST, 
        req, res);
    return;
  }
  
  private void LevelAccess(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
  	String act = req.getParameter(MasterConstants.ACT);
    
    if(!Utilities.isEmpy(act) && 
        (act.equals(MasterConstants.ACT_CREATE)||
            act.equals(MasterConstants.ACT_CREATE_SAVE))
      )
    {
      this.doCreateAccess(req, res);
    }
    else
    {
      this.doLevelAccess(req, res);
    }
    return;
  }
  
  private void doCreateAccess(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
  	LevelAccessEngine la = null;
  	LevelAccessBean lab = null;
  	//Validate
  	if(null==la) la = new LevelAccessEngine(req, res);
  	lab = la.validateEntry();
  	
  	if(null!=lab)
  	{
  		la.insertLevelAccess(lab);
  	}
  	else System.out.println("TEST 1.B: BEAN LEVEL ACCESS IS NULL");
  	if(null!=la) la.closed();
  	this.doLevelAccess(req, res);
  }
  
  private void doLevelAccess(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
  	String LevelID = req.getParameter(MasterConstants.FORM_MASTERUSER_LEVEL);
  	MasterLevelEngine ml = new MasterLevelEngine(req, res);
  	MasterLevelAccessBean[] list = ml.listOfAccess();
  	
  	
  	if(null!=list) req.setAttribute(MasterConstants.MASTERLEVEL_LIST, list);
  	req.setAttribute(MasterConstants.FORM_MASTERUSER_LEVEL, LevelID);
  	if(null!=ml) ml.closed();
    super.openContent(
        MasterConstants.SVT_MASTER_PATH, 
        MasterConstants.LEVELACCESS, 
        MasterConstants.LEVEL_ACCESS_EDIT, 
        req, res);
    return;
  }
}