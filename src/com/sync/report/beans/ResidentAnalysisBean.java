package com.sync.report.beans;

import com.sync.core.beans.MessageBean;



public class ResidentAnalysisBean extends ReportBean
{
  private ResidentAnalysisDetailsBean[] collects = null;
  private MessageBean msg = null;

  public ResidentAnalysisBean(){}
  
  public void setBeanMessages(MessageBean val){ msg = val; }
  public MessageBean getBeanMessages(){ return msg; }
  
  
  public void setDetails(ResidentAnalysisDetailsBean[] val){ collects = val; }
  public ResidentAnalysisDetailsBean[] getDetails(){ return collects; }
  
}