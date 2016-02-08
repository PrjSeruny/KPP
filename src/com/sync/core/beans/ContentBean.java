package com.sync.core.beans;

public class ContentBean {

  private String currServlet;
  private String currParam;
  private String currPG;
  
  /** Regular Constructor */
  public ContentBean(){}

  public String getCurrServlet() {
    return currServlet;
  }

  public void setCurrServlet(String val) {
    currServlet = val;
  }

  public String getCurrParam() {
    return currParam;
  }

  public void setCurrParam(String val) {
    currParam = val;
  }

  public String getCurrPG() {
    return currPG;
  }

  public void setCurrPG(String val) {
    currPG = val;
  }
  
  
  
}
