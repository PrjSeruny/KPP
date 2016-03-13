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
  public static final String TRANS_FAMILYCARDMUT = "fmlycardmut";
  
  
  /** Value of Parameter */
  public static final String DEATHLETTER_LIST = "dthlttrlist";
  public static final String DEATHLETTER_INFO = "dthlttrinf";
  public static final String BIRTHLETTER_LIST = "brthlttrlist";
  public static final String BIRTHLETTER_INFO = "brthlttrinfo";
  public static final String FAMILYCARDMUT_LIST = "fmlycrdlist";
  public static final String FAMILYCARDMUT_INFO = "fmlycrdinfo";
  
  /** For setting page */
  /* Family Card Mutation */
  public static final String PAGE_FAMILYCARDMUT_LIST = PAGES_PATH + "/familycardmut_list.jsp";
  public static final String PAGE_FAMILYCARDMUT_INFO = PAGES_PATH + "/familycardmut_info.jsp";
  public static final String PAGE_FAMILYCARDMUT_EDIT = PAGES_PATH + "/familycardmut_edit.jsp";
  
  /* Death Letter */
  public static final String PAGE_DEATHLETTER_LIST = PAGES_PATH + "/deathletterlist.jsp";
  public static final String PAGE_DEATHLETTER_INFO = PAGES_PATH + "/deathletterinfo.jsp";
  public static final String PAGE_DEATHLETTER_EDIT = PAGES_PATH + "/deathletteredit.jsp";
  
  /* Birth Letter */
  public static final String PAGE_BIRTHLETTER_LIST = PAGES_PATH + "/birthletterlist.jsp";
  public static final String PAGE_BIRTHLETTER_INFO = PAGES_PATH + "/birthletterinfo.jsp";
  public static final String PAGE_BIRTHLETTER_EDIT = PAGES_PATH + "/birthletteredit.jsp";
  
  /** Value of object in HTML pages */
  /*------------- Family Card Mutation ----------------*/
  public static final String FORM_FAMILYCARDMUT_NIK = "FORM_FAMILYCARDMUT_NIK";
  public static final String FORM_FAMILYCARDMUT_NAME = "FORM_FAMILYCARDMUT_NAME";
  public static final String FORM_FAMILYCARDMUT_STARTDATE = "FORM_FAMILYCARDMUT_STARTDATE";
  public static final String FORM_FAMILYCARDMUT_OLDKK = "FORM_FAMILYCARDMUT_OLDKK";
  public static final String FORM_FAMILYCARDMUT_NEWKK = "FORM_FAMILYCARDMUT_NEWKK";
  public static final String FORM_FAMILYCARDMUT_SEX = "FORM_FAMILYCARDMUT_SEX";
  public static final String FORM_FAMILYCARDMUT_RELIGION = "FORM_FAMILYCARDMUT_RELIGION";
  public static final String FORM_FAMILYCARDMUT_MARITALSTATUS = "FORM_FAMILYCARDMUT_MARITALSTATUS";
  public static final String FORM_FAMILYCARDMUT_FAMILYPOS = "FORM_FAMILYCARDMUT_FAMILYPOS";
  public static final String FORM_FAMILYCARDMUT_NATIONALITY = "FORM_FAMILYCARDMUT_NATIONALITY";
  public static final String FORM_FAMILYCARDMUT_ADDRESS = "FORM_FAMILYCARDMUT_ADDRESS";
  public static final String FORM_FAMILYCARDMUT_CITY = "FORM_FAMILYCARDMUT_CITY";
  public static final String FORM_FAMILYCARDMUT_REGION = "FORM_FAMILYCARDMUT_REGION";
  public static final String FORM_FAMILYCARDMUT_POSTALCODE = "FORM_FAMILYCARDMUT_POSTALCODE";
  public static final String FORM_FAMILYCARDMUT_RT = "FORM_FAMILYCARDMUT_RT";
  public static final String FORM_FAMILYCARDMUT_RW = "FORM_FAMILYCARDMUT_RW";
  public static final String FORM_FAMILYCARDMUT_KELURAHAN = "FORM_FAMILYCARDMUT_KELURAHAN";
  public static final String FORM_FAMILYCARDMUT_KECAMATAN = "FORM_FAMILYCARDMUT_KECAMATAN";
  public static final String FORM_FAMILYCARDMUT_NOTE = "FORM_FAMILYCARDMUT_NOTE";
  
  
  /*------------- Death Letter ----------------------*/
  public static final String FORM_TRANS_DEATHLETTER_NIK = "FORM_TRANS_DEATHLETTER_NIK";
  public static final String FORM_TRANS_DEATHLETTER_NAME = "FORM_TRANS_DEATHLETTER_NAME";
  public static final String FORM_TRANS_DEATHLETTER_DEATHDATE = "FORM_TRANS_DEATHLETTER_DEATHDATE";
  public static final String FORM_TRANS_DEATHLETTER_NOTE = "FORM_TRANS_DEATHLETTER_NOTE";

  /*------------- Birth Letter ----------------------*/
  public static final String FORM_TRANS_BIRTHLETTER_NIK = "FORM_TRANS_BIRTHLETTER_NIK";
  public static final String FORM_TRANS_BIRTHLETTER_KKNO = "FORM_TRANS_BIRTHLETTER_KKNO";
  public static final String FORM_TRANS_BIRTHLETTER_NAME= "FORM_TRANS_BIRTHLETTER_NAME";
  public static final String FORM_TRANS_BIRTHLETTER_BIRTHDATE = "FORM_TRANS_BIRTHLETTER_BIRTHDATE";
  public static final String FORM_TRANS_BIRTHLETTER_FATHERNIK = "FORM_TRANS_BIRTHLETTER_FATHERNIK";
  public static final String FORM_TRANS_BIRTHLETTER_FATHERNAME = "FORM_TRANS_BIRTHLETTER_FATHERNAME";
  public static final String FORM_TRANS_BIRTHLETTER_MOTHERNIK = "FORM_TRANS_BIRTHLETTER_MOTHERNIK";
  public static final String FORM_TRANS_BIRTHLETTER_MOTHERNAME = "FORM_TRANS_BIRTHLETTER_MOTHERNAME";
  public static final String FORM_TRANS_BIRTHLETTER_NOTE = "FORM_TRANS_BIRTHLETTER_NOTE";
  
}