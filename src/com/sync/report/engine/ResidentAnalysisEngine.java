package com.sync.report.engine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sync.core.engine.RootEngine;
import com.sync.core.utils.Utilities;
import com.sync.report.beans.ResidentAnalysisBean;
import com.sync.report.utils.ReportConstants;


public class ResidentAnalysisEngine extends RootEngine
{
  public ResidentAnalysisEngine(){}
  
  public ResidentAnalysisEngine(HttpServletRequest rq, HttpServletResponse rs)
  {
    req=rq;
    res=rs;
  }
  
  public ResidentAnalysisBean validate()
  {
    ResidentAnalysisBean bn = new ResidentAnalysisBean();
    String temp = "";
    
    temp = req.getParameter(ReportConstants.FORM_RESIDENTANALYSIS_SEARCH_DETAILS);
    bn.setWhatToSearch(temp);
    
    temp = req.getParameter(ReportConstants.FORM_RESIDENTANALYSIS_SEARCH_RECAP);
    bn.setWhatToSearch(temp);
    
    temp = req.getParameter(ReportConstants.FORM_RESIDENTANALYSIS_CITY);
    if(!Utilities.isEmpy(temp))
    {
      bn.setCitys(temp.split(";"));
    }
    
    temp = req.getParameter(ReportConstants.FORM_RESIDENTANALYSIS_KEC);
    if(!Utilities.isEmpy(temp))
    {
      bn.setKecVal(temp.split(";"));
    }
    
    temp = req.getParameter(ReportConstants.FORM_RESIDENTANALYSIS_KEL);
    if(!Utilities.isEmpy(temp))
    {
      bn.setKelVal(temp.split(";"));
    }
    
    return bn;
  }
  
  public ResidentAnalysisBean search(ResidentAnalysisBean bn)
  {
    
    return bn;
  }
  
  public void closed()
  {
    super.finalize();
  }
}