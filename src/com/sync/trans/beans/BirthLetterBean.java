package com.sync.trans.beans;

import java.util.Date;

import com.sync.core.beans.DataPreferenceBean;
import com.sync.core.beans.MessageBean;



public class BirthLetterBean extends DataPreferenceBean
{
  private String NIK = null;
  private String KKNo = null;
  private String Name = null;
  private Date BirthDate = null;
  private String FatherNIK = null;
  private String FatherName = null;
  private String MotherNIK = null;
  private String MotherName = null;
  private String Note = null;
  private MessageBean msg = null;
  
  public BirthLetterBean(){}
  
  
  public void setNIK(String val){ NIK = val; }
  public String getNIK(){ return NIK; }
  
  public void setKKNo(String val){ KKNo = val; }
  public String getKKNo(){ return KKNo; }
  
  public void setName(String val){ Name = val; }
  public String getName(){ return Name; }
  
  public void setBirthDate(Date val){ BirthDate = val; }
  public Date getBirthDate(){ return BirthDate; }
  
  public void setFatherNIK(String val){ FatherNIK = val; }
  public String getFatherNIK(){ return FatherNIK; }
  
  public void setFatherName(String val){ FatherName = val; }
  public String getFatherName(){ return FatherName; }
  
  public void setMotherNIK(String val){ MotherNIK = val; }
  public String getMotherNIK(){ return MotherNIK; }
  
  public void setMotherName(String val){ MotherName = val; }
  public String getMotherName(){ return MotherName; }
  
  public void setNote(String val){ Note = val; }
  public String getNote(){ return Note; }
  
  public void setBeanMessages(MessageBean val){ msg = val; }
  public MessageBean getBeanMessages(){ return msg; }
  
  
  
  
  
}