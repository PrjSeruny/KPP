package com.sync.trans.utils;

import com.sync.core.utils.Constants;


public class TransConstants extends Constants
{
  public static final String SVT_TRANS_PATH = SERVLET_PATH + "/trans";
  public static final String TRANS_PATH = UI_PATH + "/trans";
  public static final String PAGES_PATH = TRANS_PATH + "/pages";
  public static final String SCRIPTS_PATH = TRANS_PATH + "/scripts";
  
  /***  Value of what */
  public static final String TRANS_DEATHLETTER = "dthlttr";
  public static final String TRANS_BIRTHLETTER = "birthlttr";
  
  
  /** Value of Parameter */
  public static final String DEATHLETTER_LIST = "dthlttrlist";
  public static final String DEATHLETTER_INFO = "dthlttrinf";
  public static final String BIRTHLETTER_LIST = "brthlttrlist";
  public static final String BIRTHLETTER_INFO = "brthlttrinfo";
  
  /** For setting page */
  /* Death Letter */
  public static final String PAGE_DEATHLETTER_LIST = PAGES_PATH + "/deathletterlist.jsp";
  public static final String PAGE_DEATHLETTER_INFO = PAGES_PATH + "/deathletterinfo.jsp";
  public static final String PAGE_DEATHLETTER_EDIT = PAGES_PATH + "/deathletteredit.jsp";
  
  /* Birth Letter */
  public static final String PAGE_BIRTHLETTER_LIST = PAGES_PATH + "/birthletterlist.jsp";
  public static final String PAGE_BIRTHLETTER_INFO = PAGES_PATH + "/birthletterinfo.jsp";
  public static final String PAGE_BIRTHLETTER_EDIT = PAGES_PATH + "/birthletteredit.jsp";
  
  
  /** Value of object in HTML pages */
  public static final String FORM_TRANS_DEATHLETTER_NIK = "FORM_TRANS_DEATHLETTER_NIK";
  public static final String FORM_TRANS_DEATHLETTER_NAME = "FORM_TRANS_DEATHLETTER_NAME";
  public static final String FORM_TRANS_DEATHLETTER_DEATHDATE = "FORM_TRANS_DEATHLETTER_DEATHDATE";
  public static final String FORM_TRANS_DEATHLETTER_NOTE = "FORM_TRANS_DEATHLETTER_NOTE";


  
  
}