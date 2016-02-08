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
}