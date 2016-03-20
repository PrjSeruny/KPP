package com.sync.trans.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sync.core.beans.MessageBean;
import com.sync.core.servlet.CoreServlet;
import com.sync.core.utils.Utilities;
import com.sync.master.beans.LevelAccessBean;
import com.sync.trans.beans.BirthLetterBean;
import com.sync.trans.beans.DeathLetterBean;
import com.sync.trans.beans.FamilyCardMutationBean;
import com.sync.trans.engine.BirthLetterEngine;
import com.sync.trans.engine.DeathLetterEngine;
import com.sync.trans.engine.FamilyCardMutationEngine;
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
    else if(!Utilities.isEmpy(what) && 
        what.equals(TransConstants.TRANS_BIRTHLETTER))
    {
      this.TransBirthLetter(req, res);
    }
    else if(!Utilities.isEmpy(what) && 
        what.equals(TransConstants.TRANS_FAMILYCARDMUT))
    {
      this.TransFamilyCardMutation(req, res);
    }
    else
    {
      super.openURL(TransConstants.HOME_PAGE, req, res);
    }
  }
  
  private void TransDeathLetter(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    String act = req.getParameter(TransConstants.ACT);
    if(!Utilities.isEmpy(act) && 
        (act.equals(TransConstants.ACT_CREATE)||
            act.equals(TransConstants.ACT_CREATE_SAVE))
      )
    {
      this.doCreateDeathLetter(req, res);
    }
    else 
      if(!Utilities.isEmpy(act) && 
        (act.equals(TransConstants.ACT_UPDATE) || 
            act.equals(TransConstants.ACT_UPDATE_SAVE))
       )
    {
      this.doUpdateDeathLetter(req, res);
    }
    else if(!Utilities.isEmpy(act) && act.equals(TransConstants.ACT_DELETE))
    {
      this.doDeleteDeathLetter(req, res);
    }
    else if(!Utilities.isEmpy(act) && act.equals(TransConstants.ACT_LIST))
    {
      this.doListDeathLetter(req, res);
    }
    else if(!Utilities.isEmpy(act) && act.equals(TransConstants.ACT_INFO))
    {
      this.doViewDeathLetter(req, res);
    }
    else
    {
      this.doDeathLetter(req, res);
    }
    return;
  }
  
  private void doDeathLetter(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
  	if(!super.validateAcces(
  			req, 
  			res, 
  			TransConstants.TRANS_DEATHLETTER, 
  			LevelAccessBean.PERMIT_LIST))
  	{
  		super.openURL(TransConstants.ERROR_PAGE, req, res);
  		return;
  	}
  	
    String stat = req.getParameter(TransConstants.DATA_STAT);
    DeathLetterEngine ue = new DeathLetterEngine(req, res);
    DeathLetterBean[] lists = ue.listOfLetter(stat);
    
    req.setAttribute(TransConstants.DEATHLETTER_LIST,lists);
    
    if(null!=ue)ue.closed();
    super.openContent(
        TransConstants.SVT_TRANS_PATH, 
        TransConstants.TRANS_DEATHLETTER, 
        TransConstants.PAGE_DEATHLETTER, 
        req, res);
    return;
  
  }
  
  private void TransFamilyCardMutation(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    String act = req.getParameter(TransConstants.ACT);
    if(!Utilities.isEmpy(act) && 
        (act.equals(TransConstants.ACT_CREATE)||
            act.equals(TransConstants.ACT_CREATE_SAVE))
      )
    {
      this.doCreateFamilyCardMut(req, res);
    }
    else 
      if(!Utilities.isEmpy(act) && 
        (act.equals(TransConstants.ACT_UPDATE) || 
            act.equals(TransConstants.ACT_UPDATE_SAVE))
       )
    {
      this.doUpdateFamilyCardMut(req, res);
    }
    else if(!Utilities.isEmpy(act) && act.equals(TransConstants.ACT_DELETE))
    {
      this.doDeleteFamilyCardMut(req, res);
    }
    else if(!Utilities.isEmpy(act) && act.equals(TransConstants.ACT_LIST))
    {
      this.doListFamilyCardMut(req, res);
    }
    else if(!Utilities.isEmpy(act) && act.equals(TransConstants.ACT_INFO))
    {
      this.doViewFamilyCardMut(req, res);
    }
    else
    {
      this.doFamilyCardMut(req, res);
    }
    return;
  }
  
  private void doFamilyCardMut(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
  	if(!super.validateAcces(
  			req, 
  			res, 
  			TransConstants.TRANS_FAMILYCARDMUT, 
  			LevelAccessBean.PERMIT_LIST))
  	{
  		super.openURL(TransConstants.ERROR_PAGE, req, res);
  		return;
  	}
    String stat = req.getParameter(TransConstants.DATA_STAT);
    FamilyCardMutationEngine ue = new FamilyCardMutationEngine(req, res);
    FamilyCardMutationBean[] lists = ue.listOfFamilyCard(stat);
    
    req.setAttribute(TransConstants.FAMILYCARDMUT_LIST, lists);
    
    if(null!=ue)ue.closed();
    super.openContent(
        TransConstants.SVT_TRANS_PATH, 
        TransConstants.TRANS_FAMILYCARDMUT, 
        TransConstants.PAGE_FAMILYCARDMUT, 
        req, res);
    return;
  
  }
  
  private void doCreateFamilyCardMut(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
  	if(!super.validateAcces(
  			req, 
  			res, 
  			TransConstants.TRANS_FAMILYCARDMUT, 
  			LevelAccessBean.PERMIT_CREATE))
  	{
  		super.openURL(TransConstants.ERROR_PAGE, req, res);
  		return;
  	}
    System.out.println("CREATE NEW FAMILY CARD MUTATION");
    String act = req.getParameter(TransConstants.ACT);
    FamilyCardMutationEngine re = new FamilyCardMutationEngine(req, res);
    FamilyCardMutationBean rbn = null;
    System.out.println("ACTION= "+act);
    
    if(null!=req.getParameter(TransConstants.BTN_CANCEL))
    {
      System.out.println("BTN CANCEL PRESSED>>>>>>>>>>>>>>>>>>>> ");
      this.doFamilyCardMut(req, res);
      return;     
    }
    
    if(!Utilities.isEmpy(act) && act.equals(TransConstants.ACT_CREATE_SAVE))
    {
      System.out.println("SAVING AND VALIDATING NEW FAMILY CARD ");
      rbn = re.validate();
      req.setAttribute(TransConstants.FAMILYCARDMUT_INFO, rbn);
      
      if(null!=rbn && rbn.getBeanMessages().isErrorExist())
      {
        System.out.println("SAVING AND VALIDATING NEW FAMILY CARD MUT ERROR EXIST");
        req.setAttribute(TransConstants.FAMILYCARDMUT_INFO, rbn);
        req.setAttribute(TransConstants.ACT, TransConstants.ACT_CREATE_SAVE);
        super.openContent(TransConstants.SVT_TRANS_PATH, 
            TransConstants.TRANS_FAMILYCARDMUT, 
            TransConstants.PAGE_FAMILYCARDMUT_EDIT, req, res);
        return;      
      }
      
      if(!re.create(rbn))
      {
        if(null!=re)re.closed();
        req.setAttribute(TransConstants.FAMILYCARDMUT_INFO, rbn);
        super.openContent(TransConstants.SVT_TRANS_PATH, 
            TransConstants.TRANS_FAMILYCARDMUT, 
            TransConstants.PAGE_FAMILYCARDMUT_EDIT, req, res);
        return;
      }
      
      if(null!=re)re.closed();
      req.setAttribute(TransConstants.FAMILYCARDMUT_INFO, rbn);
      super.openContent(TransConstants.SVT_TRANS_PATH, 
          TransConstants.TRANS_FAMILYCARDMUT, 
          TransConstants.PAGE_FAMILYCARDMUT_INFO, req, res);
      return;
    }
    else
    {
      System.out.println("OPEN PAGE CREATE NEW FAMILY CARD");
      req.setAttribute(TransConstants.ACT, TransConstants.ACT_CREATE_SAVE);
      super.openContent(TransConstants.SVT_TRANS_PATH, 
          TransConstants.TRANS_FAMILYCARDMUT, 
          TransConstants.PAGE_FAMILYCARDMUT_EDIT, req, res);
      return;      
    }
  }
  
  private void doUpdateFamilyCardMut(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
  	if(!super.validateAcces(
  			req, 
  			res, 
  			TransConstants.TRANS_FAMILYCARDMUT, 
  			LevelAccessBean.PERMIT_UPDATE))
  	{
  		super.openURL(TransConstants.ERROR_PAGE, req, res);
  		return;
  	}
    System.out.println("UPDATING FAMILY CARD MUT");
    String nik = req.getParameter(TransConstants.FORM_FAMILYCARDMUT_NIK);
    String sDate = req.getParameter(TransConstants.FORM_FAMILYCARDMUT_STARTDATE);
    String act = req.getParameter(TransConstants.ACT);
    FamilyCardMutationEngine re = new FamilyCardMutationEngine(req, res);
    FamilyCardMutationBean rebn = null;
    MessageBean msg = null;
    
    System.out.println("ACTION= "+act);
    
    if(
        !Utilities.isEmpy(req.getParameter(TransConstants.BTN_DONE)) ||
        !Utilities.isEmpy(req.getParameter(TransConstants.BTN_CANCEL))
      )
    {
      System.out.println("DONE PRESSED");
      this.doViewFamilyCardMut(req, res);
      return;
    }
    
    if(Utilities.isEmpy(nik) || Utilities.isEmpy(sDate))
    {
      System.out.println("NO NIK");
      super.openURL(TransConstants.ERRORMSG_PAGE, req, res);
      return;
    }
    
    if(!Utilities.isEmpy(act) && act.equals(TransConstants.ACT_UPDATE_SAVE))
    {
      System.out.println("ENTER VALIDATE fAMILY CARD");
      rebn = re.validate();
      req.setAttribute(TransConstants.ACT, TransConstants.ACT_UPDATE_SAVE);
      msg = rebn.getBeanMessages();
      
      if(null!=msg && msg.isErrorExist())
      {
        System.out.println("ERROR VALIDATING UPDATING");
      }
      
      if(!re.update(rebn))
      {
        System.out.println("ERROR UPDATING");
      }
      
      if(null!=re) re.closed();
      this.doViewFamilyCardMut(req, res);
      return;
    }
    else if(null!=req.getParameter(TransConstants.BTN_PROC))
    {
      rebn = re.getFamilyCardMutationInfo(req.getParameter(
          TransConstants.FORM_FAMILYCARDMUT_NIK),
          req.getParameter(
              TransConstants.FORM_FAMILYCARDMUT_STARTDATE));
      
      if(!re.proceed(rebn, false))
      {
        System.out.println("ERROR UPDATING STATUS PROCEED FAMILY CARD");
      }
      
      if(null!=re) re.closed();
      this.doViewFamilyCardMut(req, res);
      return;
    }
    else if(null!=req.getParameter(TransConstants.BTN_CANCELPROC))
    {
      rebn = re.getFamilyCardMutationInfo(req.getParameter(
          TransConstants.FORM_FAMILYCARDMUT_NIK),
          req.getParameter(
              TransConstants.FORM_FAMILYCARDMUT_STARTDATE));
      
      if(!re.proceed(rebn, true))
      {
        System.out.println("ERROR UPDATING STATUS CANCEL PROCEED FAMILY CARD");
      }
      
      if(null!=re) re.closed();
      this.doViewFamilyCardMut(req, res);
      return;
    }
    else
    {
      System.out.println("ENTER GETTING Family Card");
      rebn = re.getFamilyCardMutationInfo(nik, sDate);
      if(null!=rebn)
      {
        System.out.println("NIK= "+rebn.getNIK());
        System.out.println("Nama= "+rebn.getName());
        req.setAttribute(TransConstants.FAMILYCARDMUT_INFO, rebn);
        req.setAttribute(TransConstants.ACT, TransConstants.ACT_UPDATE_SAVE);
      }
      super.openContent(TransConstants.SVT_TRANS_PATH, 
                        TransConstants.TRANS_FAMILYCARDMUT, 
                        TransConstants.PAGE_FAMILYCARDMUT_EDIT, req, res);
      return;
    }
  
  }
  
  private void doDeleteFamilyCardMut(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
  	if(!super.validateAcces(
  			req, 
  			res, 
  			TransConstants.TRANS_FAMILYCARDMUT, 
  			LevelAccessBean.PERMIT_DELETE))
  	{
  		super.openURL(TransConstants.ERROR_PAGE, req, res);
  		return;
  	}
  	
  	System.out.println("PREPARING DELETE Card Mutation");
    String[] lists = req.getParameterValues(TransConstants.CHKBOX);
    
    if(null==lists)
    {
      System.out.println("Mohon dicentang data yang ingin dihapus");
    }
    
    FamilyCardMutationEngine re = new FamilyCardMutationEngine(req, res);
    if(!re.delete(lists))
    {
      System.out.println("ERROR DELETING DATA");
    }
    
    if(null!=re)re.closed();
    this.doListFamilyCardMut(req, res);
    return;
  }
  
  private void doListFamilyCardMut(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
  	if(!super.validateAcces(
  			req, 
  			res, 
  			TransConstants.TRANS_FAMILYCARDMUT, 
  			LevelAccessBean.PERMIT_LIST))
  	{
  		super.openURL(TransConstants.ERROR_PAGE, req, res);
  		return;
  	}
    String stat = req.getParameter(TransConstants.DATA_STAT);
    FamilyCardMutationEngine re = new FamilyCardMutationEngine(req, res);
    FamilyCardMutationBean[] lists = re.listOfFamilyCard(stat);
    
    req.setAttribute(TransConstants.FAMILYCARDMUT_LIST, lists);
    
    if(null!=re)re.closed();
    super.openContent(
        TransConstants.SVT_TRANS_PATH, 
        TransConstants.TRANS_FAMILYCARDMUT, 
        TransConstants.PAGE_FAMILYCARDMUT_LIST, 
        req, res);
    return;
  
  }
  
  private void doViewFamilyCardMut(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
  	if(!super.validateAcces(
  			req, 
  			res, 
  			TransConstants.TRANS_FAMILYCARDMUT, 
  			LevelAccessBean.PERMIT_INFO))
  	{
  		super.openURL(TransConstants.ERROR_PAGE, req, res);
  		return;
  	}
    System.out.println("VIEWING INFO FAMILY CARD MUTATION");
    String nik = req.getParameter(TransConstants.FORM_FAMILYCARDMUT_NIK);
    String sDate  = req.getParameter(TransConstants.FORM_FAMILYCARDMUT_STARTDATE);
    FamilyCardMutationEngine re = new FamilyCardMutationEngine(req, res);
    FamilyCardMutationBean rebn = null;
    
    if(null!=req.getParameter(TransConstants.BTN_DONE))
    {
        this.doFamilyCardMut(req, res);
        return;
    }
    
    rebn = re.getFamilyCardMutationInfo(nik, sDate);
    System.out.println("DISPLAYING INFO FAMILY CARD MUTATION");
    req.setAttribute(TransConstants.FAMILYCARDMUT_INFO, rebn);
    
    if(null!=re)re.closed();
    super.openContent(TransConstants.SVT_TRANS_PATH, 
        TransConstants.TRANS_FAMILYCARDMUT, 
        TransConstants.PAGE_FAMILYCARDMUT_INFO, req, res);
    return;
  
  
  }
  
  private void TransBirthLetter(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    String act = req.getParameter(TransConstants.ACT);
    if(!Utilities.isEmpy(act) && 
        (act.equals(TransConstants.ACT_CREATE)||
            act.equals(TransConstants.ACT_CREATE_SAVE))
      )
    {
      this.doCreateBirthLetter(req, res);
    }
    else 
      if(!Utilities.isEmpy(act) && 
        (act.equals(TransConstants.ACT_UPDATE) || 
            act.equals(TransConstants.ACT_UPDATE_SAVE))
       )
    {
      this.doUpdateBirthLetter(req, res);
    }
    else if(!Utilities.isEmpy(act) && act.equals(TransConstants.ACT_DELETE))
    {
      this.doDeleteBirthLetter(req, res);
    }
    else if(!Utilities.isEmpy(act) && act.equals(TransConstants.ACT_LIST))
    {
      this.doListBirthLetter(req, res);
    }
    else if(!Utilities.isEmpy(act) && act.equals(TransConstants.ACT_INFO))
    {
      this.doViewBirthLetter(req, res);
    }
    else
    {
      this.doBirthLetter(req, res);
    }
    return;
  }
  
  private void doBirthLetter(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
  	if(!super.validateAcces(
  			req, 
  			res, 
  			TransConstants.TRANS_BIRTHLETTER, 
  			LevelAccessBean.PERMIT_LIST))
  	{
  		super.openURL(TransConstants.ERROR_PAGE, req, res);
  		return;
  	}
  	
    String stat = req.getParameter(TransConstants.DATA_STAT);
    BirthLetterEngine ue = new BirthLetterEngine(req, res);
    BirthLetterBean[] lists = ue.listOfLetter(stat);
    
    req.setAttribute(TransConstants.BIRTHLETTER_LIST, lists);
    
    if(null!=ue)ue.closed();
    super.openContent(
        TransConstants.SVT_TRANS_PATH, 
        TransConstants.TRANS_BIRTHLETTER, 
        TransConstants.PAGE_BIRTHLETTER, 
        req, res);
    return;
  }
  
  
  
  private void doCreateBirthLetter(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
  	if(!super.validateAcces(
  			req, 
  			res, 
  			TransConstants.TRANS_BIRTHLETTER, 
  			LevelAccessBean.PERMIT_CREATE))
  	{
  		super.openURL(TransConstants.ERROR_PAGE, req, res);
  		return;
  	}
  	
    System.out.println("CREATE NEW BIRTH LETTER");
    String act = req.getParameter(TransConstants.ACT);
    BirthLetterEngine re = new BirthLetterEngine(req, res);
    BirthLetterBean rbn = null;
    System.out.println("ACTION= "+act);
    
    if(null!=req.getParameter(TransConstants.BTN_CANCEL))
    {
      System.out.println("BTN CANCEL PRESSED>>>>>>>>>>>>>>>>>>>> ");
      this.doBirthLetter(req, res);
      return;     
    }
    
    if(!Utilities.isEmpy(act) && act.equals(TransConstants.ACT_CREATE_SAVE))
    {
      System.out.println("SAVING AND VALIDATING NEW BIRTH LETTER");
      rbn = re.validate();
      req.setAttribute(TransConstants.BIRTHLETTER_INFO, rbn);
      
      if(null!=rbn && rbn.getBeanMessages().isErrorExist())
      {
        System.out.println("SAVING AND VALIDATING NEW BIRTH LETTER ERROR EXIST");
        req.setAttribute(TransConstants.BIRTHLETTER_INFO, rbn);
        req.setAttribute(TransConstants.ACT, TransConstants.ACT_CREATE_SAVE);
        super.openContent(TransConstants.SVT_TRANS_PATH, 
            TransConstants.TRANS_BIRTHLETTER, 
            TransConstants.PAGE_BIRTHLETTER_EDIT, req, res);
        return;      
      }
      
      if(!re.createBirthLetter(rbn))
      {
        if(null!=re)re.closed();
        req.setAttribute(TransConstants.BIRTHLETTER_INFO, rbn);
        super.openContent(TransConstants.SVT_TRANS_PATH, 
            TransConstants.TRANS_BIRTHLETTER, 
            TransConstants.PAGE_BIRTHLETTER_EDIT, req, res);
        return;
      }
      
      if(null!=re)re.closed();
      req.setAttribute(TransConstants.BIRTHLETTER_INFO, rbn);
      super.openContent(TransConstants.SVT_TRANS_PATH, 
          TransConstants.TRANS_BIRTHLETTER, 
          TransConstants.PAGE_BIRTHLETTER_INFO, req, res);
      return;
    }
    else
    {
      System.out.println("OPEN PAGE CREATE NEW BIRTH LETTER");
      req.setAttribute(TransConstants.ACT, TransConstants.ACT_CREATE_SAVE);
      super.openContent(TransConstants.SVT_TRANS_PATH, 
          TransConstants.TRANS_BIRTHLETTER, 
          TransConstants.PAGE_BIRTHLETTER_EDIT, req, res);
      return;      
    }
    
  }
  
  private void doUpdateBirthLetter(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
  	if(!super.validateAcces(
  			req, 
  			res, 
  			TransConstants.TRANS_BIRTHLETTER, 
  			LevelAccessBean.PERMIT_UPDATE))
  	{
  		super.openURL(TransConstants.ERROR_PAGE, req, res);
  		return;
  	}
  	
    System.out.println("UPDATING BIRTH LETTER");
    String nik = req.getParameter(TransConstants.FORM_TRANS_BIRTHLETTER_NIK);
    String act = req.getParameter(TransConstants.ACT);
    BirthLetterEngine re = new BirthLetterEngine(req, res);
    BirthLetterBean rebn = null;
    MessageBean msg = null;
    
    System.out.println("ACTION= "+act);
    
    if(
        !Utilities.isEmpy(req.getParameter(TransConstants.BTN_DONE)) ||
        !Utilities.isEmpy(req.getParameter(TransConstants.BTN_CANCEL))
      )
    {
      System.out.println("DONE PRESSED");
      this.doViewBirthLetter(req, res);
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
      System.out.println("ENTER VALIDATE birth letter");
      rebn = re.validate();
      req.setAttribute(TransConstants.ACT, TransConstants.ACT_UPDATE_SAVE);
      msg = rebn.getBeanMessages();
      
      if(null!=msg && msg.isErrorExist())
      {
        System.out.println("ERROR VALIDATING UPDATING");
      }
      
      if(!re.updateBirthLetter(rebn))
      {
        System.out.println("ERROR UPDATING");
      }
      
      if(null!=re) re.closed();
      this.doViewBirthLetter(req, res);
      return;
    }
    else if(null!=req.getParameter(TransConstants.BTN_PROC))
    {
      rebn = re.getBirthLetterInfo(req.getParameter(
          TransConstants.FORM_TRANS_BIRTHLETTER_NIK));
      
      if(!re.proceedBirthLetter(rebn, false))
      {
        System.out.println("ERROR UPDATING STATUS PROCEED KELAHIRAN");
      }
      
      if(null!=re) re.closed();
      this.doViewBirthLetter(req, res);
      return;
    }
    else if(null!=req.getParameter(TransConstants.BTN_CANCELPROC))
    {
      rebn = re.getBirthLetterInfo(req.getParameter(
          TransConstants.FORM_TRANS_BIRTHLETTER_NIK));
      
      if(!re.proceedBirthLetter(rebn, true))
      {
        System.out.println("ERROR UPDATING CANCEL PROCEED STATUS KELAHIRAN");
      }
      
      if(null!=re) re.closed();
      this.doViewBirthLetter(req, res);
      return;
    }
    else
    {
      System.out.println("ENTER GETTING Birth Letter");
      rebn = re.getBirthLetterInfo(nik);
      if(null!=rebn)
      {
        System.out.println("NIK= "+rebn.getNIK());
        System.out.println("Nama= "+rebn.getName());
        req.setAttribute(TransConstants.BIRTHLETTER_INFO, rebn);
        req.setAttribute(TransConstants.ACT, TransConstants.ACT_UPDATE_SAVE);
      }
      super.openContent(TransConstants.SVT_TRANS_PATH, 
                        TransConstants.TRANS_BIRTHLETTER, 
                        TransConstants.PAGE_BIRTHLETTER_EDIT, req, res);
      return;
    }
  }
  
  private void doDeleteBirthLetter(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
  	if(!super.validateAcces(
  			req, 
  			res, 
  			TransConstants.TRANS_BIRTHLETTER, 
  			LevelAccessBean.PERMIT_DELETE))
  	{
  		super.openURL(TransConstants.ERROR_PAGE, req, res);
  		return;
  	}
  	
    System.out.println("PREPARING DELETE Birth Letter");
    String[] niks = req.getParameterValues(TransConstants.CHKBOX);
    
    if(null==niks)
    {
      System.out.println("Mohon dicentang data yang ingin dihapus");
    }
    else
    {
      System.out.println("DATA DEL= "+niks.length);
    }
    
    BirthLetterEngine re = new BirthLetterEngine(req, res);
    if(!re.delete(niks))
    {
      System.out.println("ERROR DELETING DATA");
    }
    
    if(null!=re)re.closed();
    this.doListBirthLetter(req, res);
    return;
  
  }
  
  private void doListBirthLetter(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
  	if(!super.validateAcces(
  			req, 
  			res, 
  			TransConstants.TRANS_BIRTHLETTER, 
  			LevelAccessBean.PERMIT_LIST))
  	{
  		super.openURL(TransConstants.ERROR_PAGE, req, res);
  		return;
  	}
    String stat = req.getParameter(TransConstants.DATA_STAT);
    BirthLetterEngine re = new BirthLetterEngine(req, res);
    BirthLetterBean[] lists = re.listOfLetter(stat);
    
    req.setAttribute(TransConstants.BIRTHLETTER_LIST, lists);
    
    if(null!=re)re.closed();
    super.openContent(
        TransConstants.SVT_TRANS_PATH, 
        TransConstants.TRANS_BIRTHLETTER, 
        TransConstants.PAGE_BIRTHLETTER_LIST, 
        req, res);
    return;
  }
  
  private void doViewBirthLetter(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
  	if(!super.validateAcces(
  			req, 
  			res, 
  			TransConstants.TRANS_BIRTHLETTER, 
  			LevelAccessBean.PERMIT_INFO))
  	{
  		super.openURL(TransConstants.ERROR_PAGE, req, res);
  		return;
  	}
  	
    System.out.println("VIEWING INFO BIRTH LETTER");
    String nik = req.getParameter(TransConstants.FORM_TRANS_BIRTHLETTER_NIK);
    BirthLetterEngine re = new BirthLetterEngine(req, res);
    BirthLetterBean rebn = null;
    
    if(null!=req.getParameter(TransConstants.BTN_DONE))
    {
        this.doBirthLetter(req, res);
        return;
    }
    
    rebn = re.getBirthLetterInfo(nik);
    System.out.println("DISPLAYING INFO BIRTH LETTER");
    req.setAttribute(TransConstants.BIRTHLETTER_INFO, rebn);
    
    if(null!=re)re.closed();
    super.openContent(TransConstants.SVT_TRANS_PATH, 
        TransConstants.TRANS_BIRTHLETTER, 
        TransConstants.PAGE_BIRTHLETTER_INFO, req, res);
    return;
  
  }
  
  private void doCreateDeathLetter(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
  	if(!super.validateAcces(
  			req, 
  			res, 
  			TransConstants.TRANS_DEATHLETTER, 
  			LevelAccessBean.PERMIT_CREATE))
  	{
  		super.openURL(TransConstants.ERROR_PAGE, req, res);
  		return;
  	}
    System.out.println("CREATE NEW DEATH LETTER");
    String act = req.getParameter(TransConstants.ACT);
    DeathLetterEngine re = new DeathLetterEngine(req, res);
    DeathLetterBean rbn = null;
    System.out.println("ACTION= "+act);
    
    if(null!=req.getParameter(TransConstants.BTN_CANCEL))
    {
      System.out.println("BTN CANCEL PRESSED>>>>>>>>>>>>>>>>>>>> ");
      this.doDeathLetter(req, res);
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
        req.setAttribute(TransConstants.ACT, TransConstants.ACT_CREATE_SAVE);
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
  	if(!super.validateAcces(
  			req, 
  			res, 
  			TransConstants.TRANS_DEATHLETTER, 
  			LevelAccessBean.PERMIT_UPDATE))
  	{
  		super.openURL(TransConstants.ERROR_PAGE, req, res);
  		return;
  	}
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
  	if(!super.validateAcces(
  			req, 
  			res, 
  			TransConstants.TRANS_DEATHLETTER, 
  			LevelAccessBean.PERMIT_DELETE))
  	{
  		super.openURL(TransConstants.ERROR_PAGE, req, res);
  		return;
  	}
  	
    System.out.println("PREPARING DELETE Death Letter");
    String[] niks = req.getParameterValues(TransConstants.CHKBOX);
    
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
  	if(!super.validateAcces(
  			req, 
  			res, 
  			TransConstants.TRANS_DEATHLETTER, 
  			LevelAccessBean.PERMIT_LIST))
  	{
  		super.openURL(TransConstants.ERROR_PAGE, req, res);
  		return;
  	}
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
  	if(!super.validateAcces(
  			req, 
  			res, 
  			TransConstants.TRANS_DEATHLETTER, 
  			LevelAccessBean.PERMIT_INFO))
  	{
  		super.openURL(TransConstants.ERROR_PAGE, req, res);
  		return;
  	}
  	
    System.out.println("VIEWING INFO DEATH LETTER");
    String nik = req.getParameter(TransConstants.FORM_TRANS_DEATHLETTER_NIK);
    DeathLetterEngine re = new DeathLetterEngine(req, res);
    DeathLetterBean rebn = null;
    
    if(null!=req.getParameter(TransConstants.BTN_DONE))
    {
        this.doDeathLetter(req, res);
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