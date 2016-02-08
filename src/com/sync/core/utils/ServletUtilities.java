package com.sync.core.utils;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sync.core.beans.ContentBean;
import com.sync.core.engine.ConnectionManager;



public class ServletUtilities extends HttpServlet
{
  private static final long serialVersionUID = 5530948851442982169L;
  
  public void init() throws ServletException
  {
    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>> INITIALIZE SERVLET ");
    initConn();
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