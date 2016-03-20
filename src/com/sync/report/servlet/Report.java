package com.sync.report.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sync.core.servlet.CoreServlet;
import com.sync.core.utils.Utilities;
import com.sync.report.beans.ResidentAnalysisBean;
import com.sync.report.engine.ResidentAnalysisEngine;
import com.sync.report.utils.ReportConstants;
import com.sync.trans.utils.TransConstants;



public class Report extends CoreServlet
{
  /**
   * 
   */
  private static final long serialVersionUID = 159987904399639824L;

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
    if(!Utilities.isEmpy(what) 
        && what.equals(ReportConstants.REPORT_RESIDENTANALYSIS))
    {
      this.doSearchResidentAnalysis(req, res);
    }
    else
    {
      super.openURL(TransConstants.HOME_PAGE, req, res);
      return;
    }
  }
  
  private void doSearchResidentAnalysis(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException
  {
    String act = req.getParameter(ReportConstants.ACT);
    ResidentAnalysisEngine rae = new ResidentAnalysisEngine(req, res);
    ResidentAnalysisBean bn = new ResidentAnalysisBean();
    
    if(!Utilities.isEmpy(act) && act.equals(ReportConstants.ACT_SEARCH_QUERY))
    {
      System.out.println("OOOOOOOOOOOOOOOOOOOOO searching1");
      bn = rae.validate();
      req.setAttribute(ReportConstants.RESIDENTANALYSIS_LIST, bn);
      if(null!=bn.getBeanMessages() && bn.getBeanMessages().isErrorExist())
      {
        super.openContent(
            ReportConstants.SVT_REPORT_PATH, 
            ReportConstants.REPORT_PATH, 
            ReportConstants.PAGE_RESIDENTANALYSIS_SEARCH, 
            req, res);
        return;
      }
      
      System.out.println("OOOOOOOOOOOOOOOOOOOOO searching2");
      bn = rae.search(bn);
      System.out.println("OOOOOOOOOOOOOOOOOOOOO searching3");
      req.setAttribute(ReportConstants.RESIDENTANALYSIS_LIST, bn);
      if(null!=rae)rae.closed();
    }
    
    super.openContent(
        ReportConstants.SVT_REPORT_PATH, 
        ReportConstants.REPORT_PATH, 
        ReportConstants.PAGE_RESIDENTANALYSIS_SEARCH, 
        req, res);
    return;
  }
}