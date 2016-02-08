package com.sync.master.beans;

import java.util.Date;

import com.sync.core.beans.MessageBean;


public class MasterUserBean
{
  private String user = null;
  private String name = null;
  private Date createDate = null;
  private String createUser = null;
  private Date entryDate = null;
  private String entryUser = null;
  private MessageBean msg = null;
  private String passwd = null;
  
  public MasterUserBean(){}
  
  
  /** Sets Username */
  public void setUser(String val){ user = val; }
  /** Gets Username */
  public String getUser(){ return user; }

  /** Sets Name */
  public void setName(String val){ name = val; }
  /** Gets Name */
  public String getName(){ return name; }
  
  /** Sets Password */
  public void setPassword(String val){ passwd = val; }
  /** Gets Password */
  public String getPassword(){ return passwd; }
  
  /** Sets MessageBean */
  public void setMessageBean(MessageBean val){ msg = val; }
  /** Gets MessageBean */
  public MessageBean getMessageBean(){ return msg; }
  
  /** Sets Create Date */
  public void setCreateDate(Date val){ createDate = val; }
  /** Gets Create Date */
  public Date getCreateDate(){ return createDate; }
  
  /** Sets Create User */
  public void setCreateUser(String val){ createUser = val; }
  /** Gets Create User */
  public String getCreateUser(){ return createUser; }
  
  /** Sets Entry Date */
  public void setEntryDate(Date val){ entryDate = val; }
  /** Gets Entry Date */
  public Date getEntryDate(){ return entryDate; }
  
  /** Sets Entry User */
  public void setEntryUser(String val){ entryUser = val; }
  /** Gets Entry User */
  public String getEntryUser(){ return entryUser; }
  
}