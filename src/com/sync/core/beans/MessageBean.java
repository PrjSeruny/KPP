package com.sync.core.beans;

import java.util.HashMap;


/**
 * Bean for handler message 
 *
 */
public class MessageBean
{
  public static final String MSG_ERR = "MSG_ERR";
  public static final String MSG_WARNING = "MSG_WARNING";
  public static final String MSG_INFO = "MSG_INFO";
  
  public static final String MSG_ERR_COL = "#FF0000";
  public static final String MSG_ERR_WARNING = "#FFFF01";
  public static final String MSG_ERR_INFO = "#0000FF";
  private HashMap<String, String> msgbn = new HashMap<String, String>();
  
  /** Regular Constructor */
  public MessageBean(){}
  
  public void setMessageBean(String formfield, String ErrMsg)
  {
    msgbn.put(formfield, ErrMsg);
  }

  public String getMessageBean(String formfield)
  {
    return msgbn.get(formfield);
  }
  
  public String showMessage(String formfield)
  {
    if(null!=msgbn.get(formfield))
    {
      return msgbn.get(formfield);
    }else{
      return "";
    }
  }
  
  public boolean anyMessageExist(){
    if(msgbn.isEmpty()){return false;}
    else{return true;}
  }
  
  public boolean isErrorExist()
  {
    if(null!=msgbn && msgbn.size()>0) return true;
    else return false;
  }
}