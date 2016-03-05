package com.sync.trans.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sync.core.beans.MessageBean;
import com.sync.core.servlet.CoreServlet;
import com.sync.core.utils.Utilities;
import com.sync.master.utils.MasterConstants;
import com.sync.trans.beans.DeathLetterBean;
import com.sync.trans.engine.DeathLetterEngine;
import com.sync.trans.utils.TransConstants;



public class Transaction extends CoreServlet
{
  /**
   * 
   */
  private static final long serialVersionUID = -1586613011818111803L;
  
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
    String what = req.getParameter(TransConstants.W);
    if(!Utilities.isEmpy(what) && 
        what.equals(TransConstants.TRANS_DEATHLETTER))
    {
      this.TransDeathLetter(req, res);
    }
    else
    {
      super.openURL(MasterConstants.HOME_PAGE, req, res);
    }
  }
  
  public void TransDeathLetter(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    String act = req.getParameter(MasterConstants.ACT);
    if(!Utilities.isEmpy(act) && 
        (act.equals(MasterConstants.ACT_CREATE)||
            act.equals(MasterConstants.ACT_CREATE_SAVE))
      )
    {
      this.doCreateDeathLetter(req, res);
    }
    else 
      if(!Utilities.isEmpy(act) && 
        (act.equals(MasterConstants.ACT_UPDATE) || 
            act.equals(MasterConstants.ACT_UPDATE_SAVE))
       )
    {
      this.doUpdateDeathLetter(req, res);
    }
    else if(!Utilities.isEmpy(act) && act.equals(MasterConstants.ACT_DELETE))
    {
      this.doDeleteDeathLetter(req, res);
    }
    else if(!Utilities.isEmpy(act) && act.equals(MasterConstants.ACT_LIST))
    {
      this.doListDeathLetter(req, res);
    }
    else if(!Utilities.isEmpy(act) && act.equals(MasterConstants.ACT_INFO))
    {
      this.doViewDeathLetter(req, res);
    }
    else
    {
      this.doListDeathLetter(req, res);
    }
    return;
  }
  
  private void doCreateDeathLetter(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    System.out.println("CREATE NEW DEATH LETTER");
    String act = req.getParameter(TransConstants.ACT);
    DeathLetterEngine re = new DeathLetterEngine(req, res);
    DeathLetterBean rbn = null;
    System.out.println("ACTION= "+act);
    
    if(null!=req.getParameter(TransConstants.BTN_CANCEL))
    {
      System.out.println("BTN CANCEL PRESSED>>>>>>>>>>>>>>>>>>>> ");
      this.doListDeathLetter(req, res);
      return;     
    }
    
    if(!Utilities.isEmpy(act) && act.equals(TransConstants.ACT_CREATE_SAVE))
    {
      System.out.println("SAVING AND VALIDATING NEW DEATH LETTER");
      rbn = re.validate();
      req.setAttribute(TransConstants.DEATHLETTER_INFO, rbn);
      
      if(null!=rbn && rbn.getBeanMessage().isErrorExist())
      {
        System.out.println("SAVING AND VALIDATING NEW DEATH LETTER ERROR EXIST");
        req.setAttribute(TransConstants.DEATHLETTER_INFO, rbn);
        req.setAttribute(TransConstants.ACT, MasterConstants.ACT_CREATE_SAVE);
        super.openContent(TransConstants.SVT_TRANS_PATH, 
            TransConstants.TRANS_DEATHLETTER, 
            TransConstants.PAGE_DEATHLETTER_EDIT, req, res);
        return;      
      }
      
      if(!re.createDeathLetter(rbn))
      {
        if(null!=re)re.closed();
        req.setAttribute(TransConstants.DEATHLETTER_INFO, rbn);
        super.openContent(TransConstants.SVT_TRANS_PATH, 
            TransConstants.TRANS_DEATHLETTER, 
            TransConstants.PAGE_DEATHLETTER_EDIT, req, res);
        return;
      }
      
      if(null!=re)re.closed();
      req.setAttribute(TransConstants.DEATHLETTER_INFO, rbn);
      super.openContent(TransConstants.SVT_TRANS_PATH, 
          TransConstants.TRANS_DEATHLETTER, 
          TransConstants.PAGE_DEATHLETTER_INFO, req, res);
      return;
    }
    else
    {
      System.out.println("OPEN PAGE CREATE NEW DEATH LETTER");
      req.setAttribute(TransConstants.ACT, TransConstants.ACT_CREATE_SAVE);
      super.openContent(TransConstants.SVT_TRANS_PATH, 
          TransConstants.TRANS_DEATHLETTER, 
          TransConstants.PAGE_DEATHLETTER_EDIT, req, res);
      return;      
    }
  }
  
  private void doUpdateDeathLetter(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    System.out.println("UPDATING DEATH LETTER");
    String nik = req.getParameter(TransConstants.FORM_TRANS_DEATHLETTER_NIK);
    String act = req.getParameter(TransConstants.ACT);
    DeathLetterEngine re = new DeathLetterEngine(req, res);
    DeathLetterBean rebn = null;
    MessageBean msg = null;
    
    System.out.println("ACTION= "+act);
    
    if(
        !Utilities.isEmpy(req.getParameter(TransConstants.BTN_DONE)) ||
        !Utilities.isEmpy(req.getParameter(TransConstants.BTN_CANCEL))
      )
    {
      System.out.println("DONE PRESSED");
      this.doViewDeathLetter(req, res);
      return;
    }
    
    if(Utilities.isEmpy(nik))
    {
      System.out.println("NO NIK");
      super.openURL(TransConstants.ERRORMSG_PAGE, req, res);
      return;
    }
    
    if(!Utilities.isEmpy(act) && act.equals(TransConstants.ACT_UPDATE_SAVE))
    {
      System.out.println("ENTER VALIDATE death letter");
      rebn = re.validate();
      req.setAttribute(TransConstants.ACT, TransConstants.ACT_UPDATE_SAVE);
      msg = rebn.getBeanMessage();
      
      if(null!=msg && msg.isErrorExist())
      {
        System.out.println("ERROR VALIDATING UPDATING");
      }
      
      if(!re.updateDeathLetter(rebn))
      {
        System.out.println("ERROR UPDATING");
      }
      
      if(null!=re) re.closed();
      this.doViewDeathLetter(req, res);
      return;
    }
    else if(null!=req.getParameter(TransConstants.BTN_PROC))
    {
      rebn = re.getDeathLetterInfo(req.getParameter(
          TransConstants.FORM_TRANS_DEATHLETTER_NIK));
      
      if(!re.proceedDeathLetter(rebn, false))
      {
        System.out.println("ERROR UPDATING STATUS KEMATIAN");
      }
      
      if(null!=re) re.closed();
      this.doViewDeathLetter(req, res);
      return;
    }
    else if(null!=req.getParameter(TransConstants.BTN_CANCELPROC))
    {
      rebn = re.getDeathLetterInfo(req.getParameter(
          TransConstants.FORM_TRANS_DEATHLETTER_NIK));
      
      if(!re.proceedDeathLetter(rebn, true))
      {
        System.out.println("ERROR UPDATING STATUS KEMATIAN");
      }
      
      if(null!=re) re.closed();
      this.doViewDeathLetter(req, res);
      return;
    }
    else
    {
      System.out.println("ENTER GETTING Death Letter");
      rebn = re.getDeathLetterInfo(nik);
      if(null!=rebn)
      {
        System.out.println("NIK= "+rebn.getNIK());
        System.out.println("Nama= "+rebn.getName());
        req.setAttribute(TransConstants.DEATHLETTER_INFO, rebn);
        req.setAttribute(TransConstants.ACT, TransConstants.ACT_UPDATE_SAVE);
      }
      super.openContent(TransConstants.SVT_TRANS_PATH, 
                        TransConstants.TRANS_DEATHLETTER, 
                        TransConstants.PAGE_DEATHLETTER_EDIT, req, res);
      return;
    }
  
  }
  
  private void doDeleteDeathLetter(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    System.out.println("PREPARING DELETE Death Letter");
    String[] niks = req.getParameterValues(MasterConstants.CHKBOX);
    
    if(null==niks)
    {
      System.out.println("Mohon dicentang data yang ingin dihapus");
    }
    else
    {
      System.out.println("DATA DEL= "+niks.length);
    }
    
    DeathLetterEngine re = new DeathLetterEngine(req, res);
    if(!re.delete(niks))
    {
      System.out.println("ERROR DELETING DATA");
    }
    
    if(null!=re)re.closed();
    this.doListDeathLetter(req, res);
    return;
  
  }
  
  private void doListDeathLetter(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    String stat = req.getParameter(TransConstants.DATA_STAT);
    DeathLetterEngine re = new DeathLetterEngine(req, res);
    DeathLetterBean[] lists = re.listOfLetter(stat);
    
    req.setAttribute(TransConstants.DEATHLETTER_LIST, lists);
    
    if(null!=re)re.closed();
    super.openContent(
        TransConstants.SVT_TRANS_PATH, 
        TransConstants.TRANS_DEATHLETTER, 
        TransConstants.PAGE_DEATHLETTER_LIST, 
        req, res);
    return;
  }
  
  private void doViewDeathLetter(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    System.out.println("VIEWING INFO DEATH LETTER");
    String nik = req.getParameter(TransConstants.FORM_TRANS_DEATHLETTER_NIK);
    DeathLetterEngine re = new DeathLetterEngine(req, res);
    DeathLetterBean rebn = null;
    
    if(null!=req.getParameter(TransConstants.BTN_DONE))
    {
        this.doListDeathLetter(req, res);
        return;
    }
    
    rebn = re.getDeathLetterInfo(nik);
    System.out.println("DISPLAYING INFO DEATH LETTER");
    req.setAttribute(TransConstants.DEATHLETTER_INFO, rebn);
    
    if(null!=re)re.closed();
    super.openContent(TransConstants.SVT_TRANS_PATH, 
        TransConstants.TRANS_DEATHLETTER, 
        TransConstants.PAGE_DEATHLETTER_INFO, req, res);
    return;
  }
  
}