package com.sync.master.beans;

import com.sync.core.beans.DataPreferenceBean;
import com.sync.core.beans.MessageBean;




public class MasterRegionKelurahanBean extends DataPreferenceBean
{
  private String RegionID = null;
  private String KecamatanID = null;
  private String KelurahanID = null;
  private String Name = null;
  private String Note = null;
  private MessageBean msg = null;
  
  /** Regular Constructor */
  public MasterRegionKelurahanBean(){}

  public void setBeanMessages(MessageBean val){ msg = val; }
  public MessageBean getBeanMessages(){ return msg; }
  
  public void setRegionID(String val){ RegionID = val; }
  public String getRegionID(){ return RegionID; }
  
  public void setKecamatanID(String val){ KecamatanID = val; }
  public String getKecamatanID(){ return KecamatanID; }
  
  public void setKelurahanID(String val){ KelurahanID = val; }
  public String getKelurahanID(){ return KelurahanID; }
  
  public void setName(String val){ Name = val; }
  public String getName(){ return Name; }
  
  public void setNote(String val){ Note = val; }
  public String getNote(){ return Note; }
  
}