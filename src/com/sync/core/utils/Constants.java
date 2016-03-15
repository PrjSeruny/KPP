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
  public static final String DIR_PATH = System.getProperty("user.dir")+"/webapps";
  public static final String SERVLET_PATH = "/index";
  public static final String UI_PATH = "/ui";
  
  public static final String ADMIN_PATH = UI_PATH + "/admin";
  public static final String PAGES_PATH = ADMIN_PATH + "/pages";
  public static final String IMAGES_PATH = ADMIN_PATH + "/images";
  public static final String PICLIB_PATH = IMAGES_PATH + "/piclib";
  public static final String PICLIB_THUMB_PATH = PICLIB_PATH + "/thumb";
  public static final String FILE_PATH = ADMIN_PATH + "/file";
  public static final String FILE_TEMP_PATH = FILE_PATH + "/temp";
  public static final String FILE_TEMP_THUMB_PATH = FILE_TEMP_PATH + "/thumb";
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
  public static final String SLIDE_SETTING_PRM = "sldst";
  public static final String SLIDE_SETTING_PG = PAGES_PATH + "/slide_setting.jsp";
  public static final String FORM_SLIDE_ID = "FORM_SLIDE_ID";

  public static final String GALLERY_SETTING_INFO_BEAN = "GALLERY_SETTING_INFO_BEAN";
  public static final String GALLERY_SETTING_LIST_BEAN = "GALLERY_SETTING_LIST_BEAN";
  public static final String GALLERY_SETTING_PRM = "glry";
  public static final String GALLERY_SETTING_PG = PAGES_PATH + "/galleryview.jsp";
  public static final String GALLERY_LIST_PG = PAGES_PATH + "/gallerylist.jsp";
  public static final String GALLERY_EDIT_PG = PAGES_PATH + "/galleryedit.jsp";
  public static final String FORM_GALLERY_ID = "FORM_GALLERY_ID";
  public static final String FORM_GALLERY_TITLE = "FORM_GALLERY_TITLE";
  public static final String FORM_GALLERY_DESC = "FORM_GALLERY_DESC";
  
  public static final String DELETE_IMAGE_FILE = "dltimg";
  
  public static final String DATA_STAT = "sts";
  public static final String DATA_ARCHIEVE = "archve";
  public static final String DATA_RECYCLE = "rcycl";
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
  public static final String BTN_PROC = "btnproc";
  public static final String BTN_CANCELPROC = "btncnclproc";
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
  
  public static final String FOR = "for";
  public static final String FOR_KEL = "forkel";
  public static final String FOR_KEC = "forkec";
  
  public static final String FAMILY_POS_MOTHER = "Mother";
  public static final String FAMILY_POS_FATHER = "Father";
  public static final String FAMILY_POS_CHILD = "Child";
  
  public static final String FORM_FIELD1 = "FORM_FIELD1";
  public static final String FORM_FIELD2 = "FORM_FIELD2";
  public static final String FORM_FIELD3 = "FORM_FIELD3";
  public static final String FORM_FIELD4 = "FORM_FIELD4";
  public static final String FORM_FIELD5 = "FORM_FIELD5";
  public static final String FORM_FIELD6 = "FORM_FIELD6";
  public static final String FORM_FIELD7 = "FORM_FIELD7";
  public static final String FORM_FIELD8 = "FORM_FIELD8";
  public static final String FORM_FIELD9 = "FORM_FIELD9";
  public static final String FORM_FIELD10 = "FORM_FIELD10";
  
  public static final String AJAX_STATUS = "ajax_status";
  public static final String AJAX_ERROR = "error";
  public static final String AJAX_SUCCESS = "success";
  public static final String AJAX_MESSAGE = "msg";
  
  //CONSTANT INI DIGUNAKAN UNTUK PARAMETER JSON (AJAX RESPON)
  public static final String FORM_FILE_PATH = "path";
  public static final String FORM_FILE_PATHTHUMB = "path_thumb";

  //CONSTANT INI DIGUNAKAN UNTUK PARAMETER UPLOAD IMAGE, DAN SUDAH PATEN KARENA DIGUNAKAN OLEH JAVASCRIPT (TIDAK BOLEH DIRUBAH)
  public static final String FORM_IMAGE_PATH = "image";
  public static final String FORM_IMAGE_PATHTHUMB = "image_thumb";
  
}