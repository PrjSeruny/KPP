package com.sync.master.beans;

import com.sync.core.beans.DataPreferenceBean;
import com.sync.core.beans.MessageBean;


public class MasterRegionBean extends DataPreferenceBean
{
  private String RegionID = null;
  private String RegionName = null;
  private String Note = null;
  private MessageBean msg = null;
  
  /** Regular Constructor */
  public MasterRegionBean(){}

  public void setBeanMessages(MessageBean val){ msg = val; }
  public MessageBean getBeanMessages(){ return msg; }
  
  public void setRegionID(String val){ RegionID = val; }
  public String getRegionID(){ return RegionID; }
  
  public void setRegionName(String val){ RegionName = val; }
  public String getRegionName(){ return RegionName; }
  
  public void setNote(String val){ Note = val; }
  public String getNote(){ return Note; }
  
}