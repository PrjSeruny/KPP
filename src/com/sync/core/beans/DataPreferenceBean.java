package com.sync.core.beans;

import java.util.Date;


public class DataPreferenceBean
{
  private Date createDate = null;
  private String createUser = null;
  private Date entryDate = null;
  private String entryUser = null;
  private Date voidDate = null;
  private String voidUser = null;
  private Date LockDate = null;
  private String LockUser = null;
  private Date OpenLockDate = null;
  private String OpenLockUser = null;
  private Date ProcessDate = null;
  private String ProcessUser = null;
  private Date cancelProcessDate = null;
  private String cancelProcessUser = null;
  
  
  public DataPreferenceBean(){}
  
  public void setCreateDate(Date val){ createDate = val; }
  public Date getCreateDate(){ return createDate; }
  
  public void setCreateUser(String val){ createUser = val; }
  public String getCreateUser(){ return createUser; }
  
  public void setEntryDate(Date val){ entryDate = val; }
  public Date getEntryDate(){ return entryDate; }
  
  public void setEntryUser(String val){ entryUser = val; }
  public String getEntryUser(){ return entryUser; }
  
  public void setVoidDate(Date val){ voidDate = val; }
  public Date getVoidDate(){ return voidDate; }
  
  public void setVoidUser(String val){ voidUser = val; }
  public String getVoidUser(){ return voidUser; }
  
  public void setLockDate(Date val){ LockDate = val; }
  public Date getLockDate(){ return LockDate; }
  
  public void setLockUser(String val){ LockUser = val; }
  public String getLockUser(){ return LockUser; }
  
  public void setOpenLockDate(Date val){ OpenLockDate = val; }
  public Date getOpenLockDate(){ return OpenLockDate; }
  
  public void setOpenLockUser(String val){ OpenLockUser = val; }
  public String getOpenLockUser(){ return OpenLockUser; }
  
  public void setProcessDate(Date val){ ProcessDate = val; }
  public Date getProcessDate(){ return ProcessDate; }
  
  public void setProcessUser(String val){ ProcessUser = val; }
  public String getProcessUser(){ return ProcessUser; }
  
  public void setCancelProcessDate(Date val){ cancelProcessDate = val; }
  public Date getCancelProcessDate(){ return cancelProcessDate; }
  
  public void setCancelProcessUser(String val){ cancelProcessUser = val; }
  public String getCancelProcessUser(){ return cancelProcessUser; }
  
}