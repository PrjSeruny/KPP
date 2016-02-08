package com.sync.core.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sync.core.beans.MessageBean;
import com.sync.core.utils.Constants;
import com.sync.core.utils.ServletUtilities;
import com.sync.core.utils.Utilities;
import com.sync.master.beans.MasterUserBean;
import com.sync.master.engine.UserEngine;
import com.sync.master.utils.MasterConstants;

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
    else //show website
    {
      if(!Utilities.isEmpy(w))
      { 
        this.doView(req, res);
        return;
      }
      
      super.openURL(Constants.INDEX_PAGE, req, res);
      return;
    }
  }
  
  private void doView(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    String w = req.getParameter(Constants.W);
    if(!Utilities.isEmpy(w) && w.equals(Constants.HOME_PRM))
    { 
      this.doViewHome(req, res);
    }
    else //show website
    {
      super.openContent(
          Constants.SERVLET_PATH, 
          Constants.HOME_PRM, 
          Constants.HOME_PAGE, 
          req, res);
      return;
    }
    return;
  }
  
  private void doViewHome(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
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