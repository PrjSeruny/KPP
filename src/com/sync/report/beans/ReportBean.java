package com.sync.report.beans;



public class ReportBean
{
  private String whatTosearch = null;
  private String[] NIKs = null;
  private String[] Citys = null;
  private String[] Region = null;
  private String[] KelVal = null;
  private String[] KecVal = null;
  private String GroupBy = null;
  
  public ReportBean(){}
  
  public void setWhatToSearch(String val){ whatTosearch = val; }
  public String getWhatToSearch(){ return whatTosearch; }
  
  public void setNIKs(String[] val){ NIKs = val; }
  public String[] getNIKs(){ return NIKs; }
  
  public void setCitys(String[] val){ Citys = val; }
  public String[] getCitys(){ return Citys; }
  
  public void setRegions(String[] val){ Region = val; }
  public String[] getRegions(){ return Region; }
  
  public void setKelVal(String[] val){ KelVal = val; }
  public String[] getKelVal(){ return KelVal; }
  
  public void setKecVal(String[] val){ KecVal = val; }
  public String[] getKecVal(){ return KecVal; }
  
  public void setGroupBy(String val){ GroupBy = val; }
  public String getGroupBy(){ return GroupBy; }
  
}