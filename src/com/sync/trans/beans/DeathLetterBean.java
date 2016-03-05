package com.sync.trans.beans;

import java.util.Date;

import com.sync.core.beans.DataPreferenceBean;
import com.sync.core.beans.MessageBean;


public class DeathLetterBean extends DataPreferenceBean
{
  private String NIK = null;
  private String Name = null;
  private Date DeathDate = null;
  private String Note = null;
  private MessageBean msg = null;
  
  public DeathLetterBean(){}
  
  public void setBeanMessage(MessageBean val){ msg = val; }
  public MessageBean getBeanMessage(){ return msg; }
  
  public void setNIK(String val){ NIK = val; }
  public String getNIK(){ return NIK; }
  
  public void setName(String val){ Name = val; }
  public String getName(){ return Name; }
  
  public void setDeathDate(Date val){ DeathDate = val; }
  public Date getDeathDate(){ return DeathDate; }
  
  public void setNote(String val){ Note = val; }
  public String getNote(){ return Note; }
  
}