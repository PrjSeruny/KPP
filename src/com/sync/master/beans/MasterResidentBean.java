package com.sync.master.beans;

import java.util.Date;

import com.sync.core.beans.DataPreferenceBean;
import com.sync.core.beans.MessageBean;
import com.sync.master.utils.MasterConstants;



public class MasterResidentBean extends DataPreferenceBean
{
  private String NIK = null;
  private String KKNo = null;
  private String Name = null;
  private String BirthCity = null;
  private Date BirthDate = null;
  private int Sex;
  private String Religion = null;
  private String MaritalStatus = null;
  private String Work = null;
  private String Nationality = null;
  private String Address = null;
  private String City = null;
  private String Region = null;
  private String PostalCode = null;
  private String RT = null;
  private String RW = null;
  private String Kelurahan = null;
  private String Kecamatan = null;
  private String Note = null;
  private MessageBean msg = null;
  
  public MasterResidentBean(){}
  
  public void setBeanMessages(MessageBean val){ msg = val; }
  public MessageBean getBeanMessages(){ return msg; }
  
  
  public void setNIK(String val){ NIK = val; }
  public String getNIK(){ return NIK; }
  
  public void setKKNo(String val){ KKNo = val; }
  public String getKKNo(){ return KKNo; }
  
  public void setName(String val){ Name = val; }
  public String getName(){ return Name; }
  
  public void setBirthCity(String val){ BirthCity  = val; }
  public String getBirthCity(){ return BirthCity; }
  
  public void setBirthDate(Date val){ BirthDate = val; }
  public Date getBirthDate(){ return BirthDate; }
  
  public void setSex(int val){ Sex = val; }
  public int getSex(){ return Sex; }
  
  public void setReligion(String val){ Religion = val; }
  public String getReligion(){ return Religion; }
  public String getReligionVal()
  { 
    if(Religion.equals(MasterConstants.RELIGION_ISLAM)) return "Islam";
    else if(Religion.equals(MasterConstants.RELIGION_CHRISTIAN)){ return "Kristen"; }
    else if(Religion.equals(MasterConstants.RELIGION_KATOLIK)){ return "Katolik"; }
    else if(Religion.equals(MasterConstants.RELIGION_HINDU)){ return "Hindu"; }
    else if(Religion.equals(MasterConstants.RELIGION_BUDHA)){ return "Budha"; }
    else{return "Lainnya"; }
  }
  
  public void setMaritalStatus(String val){ MaritalStatus = val; }
  public String getMaritalStatus(){ return MaritalStatus; }
  public String getMaritalStatusVal()
  { 
    if(MaritalStatus.equals(MasterConstants.MARITALSTAT_SINGLE)){ return "Lajang"; }
    else if(MaritalStatus.equals(MasterConstants.MARITALSTAT_MARRIED)){ return "Menikah"; }
    else{ return "Duda/Janda"; }
  }
  
  public void setWork(String val){ Work = val; }
  public String getWork(){ return Work; }
  
  public void setNationality(String val){ Nationality = val; }
  public String getNationality(){ return Nationality; }
  
  public void setAddress(String val){ Address = val; }
  public String getAddress(){ return Address; }
  
  public void setCity(String val){ City = val; }
  public String getCity(){ return City; }
  
  public void setRegion(String val){ Region = val; }
  public String getRegion(){ return Region; }
  
  public void setPostalCode(String val){ PostalCode = val; }
  public String getPostalCode(){ return PostalCode; }
  
  public void setRT(String val){ RT = val; }
  public String getRT(){ return RT; }
  
  public void SetRW(String val){ RW = val; }
  public String getRW(){ return RW; }
  
  public void setKelurahan(String val){ Kelurahan = val; }
  public String getKelurahan(){ return Kelurahan; }
  
  public void setKecamatan(String val){ Kecamatan = val; }
  public String getKecamatan(){ return Kecamatan; }
  
  public void setNote(String val){ Note = val; }
  public String getNote(){ return Note; }
  
}