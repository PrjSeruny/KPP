package com.sync.core.utils;

import java.io.File;
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
  
  public static String verifyImage(String path)
  {
    String filePath = Constants.DIR_PATH + Constants.ROOT_PATH + path;
    String result = "."  + Constants.IMAGES_PATH + "/noimage.jpg";
    
    File file = new File(filePath);
    if(file.exists() && file.isFile()){
      result = "." + path;
    }
    
    return result;
    
  }

  public static final String stripNull(String value)
  {
    if(null==value) return "";

    return value;
  }
  
  public static final String cleanInput(String original)
  {
    if(null==original){return null;}
    
    String singleQuote = "`";
    String doubleQuote = "``";
    String result = original;
    result = result.replaceAll("\'", singleQuote);
    result = result.replaceAll("\"", doubleQuote);
    result = result.trim();
    
    return result;
  }
  
}
