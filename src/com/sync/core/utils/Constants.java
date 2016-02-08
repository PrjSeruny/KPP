package com.sync.core.utils;


/**
 * Constants value 
 *
 */
public class Constants
{
  /** Contants for what to do process in servlet */
  public static final String D="d";
  /** Contants for what to process in servlet */
  public static final String W="w";
  
  public static final String DBPATH = "DBPATH";
  public static final String DBDRIVER = "DBDRIVER";
  
  /** Constants for login into database */
  public static final String D_LOGON = "dlogon";
  /** Constants for logout into database */
  public static final String D_LOGOUT = "dlogout";

  public static final String D_VIEW = "vw";
  
  public static final String DATE_HTML_MEDIUM_PATTERN = "dd-MM-yyyy hh:mm:ss";
  public static final String DATE_DB_MEDIUM_PATTERN = "yyyy-MM-dd HH:mm:ss";
  public static final String DATE_HTML_SHORT_PATTERN = "dd-MM-yyyy";
  public static final String DATE_DB_SHORT_PATTERN = "yyyy-MM-dd";
  
  public static final String ROOT_PATH = "/simorg";
  public static final String SERVLET_PATH = "/index";
  public static final String UI_PATH = "/ui";
  
  public static final String ADMIN_PATH = UI_PATH + "/admin";
  public static final String PAGES_PATH = ADMIN_PATH + "/pages";
  public static final String IMAGES_PATH = ADMIN_PATH + "/images";
  public static final String SCRIPTS_PATH = ADMIN_PATH + "/scripts";
  
  public static final String INDEX_PAGE = PAGES_PATH + "/index.jsp";
  public static final String LOGIN_PAGE = PAGES_PATH + "/login.jsp";
  public static final String LOGOUT_PAGE = PAGES_PATH + "/logout.jsp";
  public static final String GATEWAY_PAGE = PAGES_PATH + "/gateway.jsp";
  public static final String CONTENT_PAGE = PAGES_PATH + "/content.jsp";
  public static final String LOOKUP_PAGE = PAGES_PATH + "/lookupgateway.jsp";
  public static final String MENU_PAGE = PAGES_PATH + "/menu.jsp";
  public static final String ERRORMSG_PAGE = PAGES_PATH + "/errormsg.jsp";

  public static final String HOME_PRM = "home";
  public static final String HOME_PAGE = PAGES_PATH + "/home.jsp";
  
  public static final String DATA_STAT = "sts";
  public static final String DATA_ARCHIEVE = "archve";
  public static final String DATA_CURRENT = "curr";
  
  public static final String ACT = "act";
  public static final String ACT_LOGIN = "actlgn";
  public static final String ACT_LIST = "actlst";
  public static final String ACT_LOOKUP = "actlkp";
  public static final String ACT_CREATE = "actcrt";
  public static final String ACT_CREATE_SAVE = "actcrtsv";
  public static final String ACT_DELETE = "actdlt";
  public static final String ACT_UPDATE = "actupdt";
  public static final String ACT_UPDATE_SAVE = "actupdtsv";
  public static final String ACT_VIEW = "vw";
  public static final String ACT_INFO = "info";
  
  public static final String BTN_SAVE = "btnsve";
  public static final String BTN_CANCEL = "btncncl";
  public static final String BTN_DONE = "btndone";
  public static final String CHKBOX = "chkbox";
  
  public static final String LOOKUP_SINGLE = "lkpsgl";
  public static final String LOOKUP_MULTI = "lkpmlt";
  
  public static final String CONTENT_INFO = "CONTENT_INFO";

  public static final String HTML_PAGINATION = "HTML_PAGINATION";
  public static final String FORM_CURRENT_PAGE = "FORM_CURRENT_PAGE";
  public static final String FORM_SEARCH_RECORD = "FORM_SEARCH_RECORD";
  public static final String FORM_LIMIT_RECORD = "FORM_LIMIT_RECORD";
  public static final int DEFAULT_LIMIT_RECORD = 10;
  public static final int[] LIMIT_RECORD = {10,50,100};
  
  /* Form Login **/
  public static final String FORM_LOGIN_USERNAME = "usrnm";
  public static final String FORM_LOGIN_PASSWD = "psswd";
  
  public static final int SEX_F = 1;
  public static final int SEX_M = 2;
  
  public static final String MARITALSTAT_SINGLE = "SINGLE";
  public static final String MARITALSTAT_MARRIED = "MARRIED";
  public static final String MARITALSTAT_WIDOW = "WIDOW";
  
  public static final String RELIGION_ISLAM = "ISLAM";
  public static final String RELIGION_CHRISTIAN = "CHRISTIAN";
  public static final String RELIGION_KATOLIK = "KATOLIK";
  public static final String RELIGION_HINDU = "HINDU";
  public static final String RELIGION_BUDHA = "BUDHA";
  public static final String RELIGION_OTHERS = "OTHERS";
  
  
}