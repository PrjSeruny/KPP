package com.sync.report.beans;



public class ResidentAnalysisBean extends ReportBean
{
  private ResidentAnalysisDetailsBean[] collects = null;

  public ResidentAnalysisBean(){}
  
  public void setDetails(ResidentAnalysisDetailsBean[] val){ collects = val; }
  public ResidentAnalysisDetailsBean[] getDetails(){ return collects; }
  
}