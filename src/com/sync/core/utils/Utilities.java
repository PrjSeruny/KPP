package com.sync.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * For all utilities and tools
 * which are used and needs for
 * process in this program 
 *
 */
public class Utilities
{
  private static SimpleDateFormat sdf;
  
  /** Check String value whether is empty or not */
  public static boolean isEmpy(String val)
  {
    if(null!=val && val.length()>0) return false;
    else return true;
  }
  
  public static String showStringValue(String val)
  {
    if(null!=val && val.length()>0) return val;
    else return "";
  }
  
  /** Convert String to Date format */
  public static Date stringToDate(String val, String pattern)
  {
    try
    {
      if(!Utilities.isEmpy(val))
      {
        sdf = new SimpleDateFormat(pattern);
        return sdf.parse(val);
      }
      return null;
    }
    catch(Exception e)
    {
      e.printStackTrace();
      System.out.println("CANNOT PARSING STRING TO DATE= "+e.getMessage());
      return null;
    }
  }
  
  /** Checking vali date format */
  public static boolean isValidDateFormat(String format, String value)
  {
    Date date = null;
    try 
    {
      if(value == null){ return false; }
      SimpleDateFormat sdf = new SimpleDateFormat(format);
      date = sdf.parse(value);
      
      if (!value.equals(sdf.format(date))) 
      {
        date = null;
      }
    } 
    catch (ParseException ex) 
    {
      ex.printStackTrace();
      System.out.println("cannot format= "+ex.getMessage());
    }
    return date != null;
}
  
  /** Convert Date to String format  */
  public static String dateToString(Date val, String pattern)
  {

    try
    {
      sdf = new SimpleDateFormat(pattern);
      return sdf.format(val);
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    
    return null;
  }
  
  /** Trim string from space */
  public static String trim(String val)
  {
    if(!isEmpy(val))
    {
      val = val.trim();
    }
    
    return val;
  }
  
}
