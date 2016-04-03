package com.sync.master.utils;

import com.sync.core.utils.Constants;



public class MasterConstants extends Constants
{
  public static final String SVT_MASTER_PATH = SERVLET_PATH + "/master";
  public static final String MASTER_PATH = UI_PATH + "/master";
  public static final String PAGES_PATH = MASTER_PATH + "/pages";
  public static final String SCRIPTS_PATH = MASTER_PATH + "/scripts";
  
  public static final String USER_LIST="usrlst";
  public static final String USER_INFO="usrinfo";
  
  public static final String MASTERRESIDENT_LIST = "mstrrsdnlst";
  public static final String MASTERRESIDENT_INFO = "mstrrsdninfo";
  
  public static final String MASTERREGION_LIST = "rgionlst";
  public static final String MASTERREGION_INFO = "rgioninfo";
  public static final String MASTERREGION_KEC_LIST = "keclist";
  public static final String MASTERREGION_KEL_LIST = "kellist";
  public static final String MASTERLEVEL_LIST = "lvllist";
  public static final String MASTERLEVEL_INFO = "lvlinfo";
  
  public static final String MASTER_USER = PAGES_PATH + "/master_user.jsp";
  public static final String MASTER_USER_LIST = PAGES_PATH + "/master_user_list.jsp";
  public static final String MASTER_USER_LOOKUP = PAGES_PATH + "/master_user_lookup.jsp";
  public static final String MASTER_USER_EDIT = PAGES_PATH + "/master_user_edit.jsp";
  
  public static final String MASTER_LEVELACCESS_PG = PAGES_PATH + "/master_levelaccess.jsp";
  public static final String MASTER_LEVELACCESS_LIST = PAGES_PATH + "/master_levelaccess_list.jsp";
  public static final String MASTER_LEVELACCESS_LOOKUP = PAGES_PATH + "/master_levelaccess_lookup.jsp";
  public static final String MASTER_LEVELACCESS_EDIT = PAGES_PATH + "/master_levelaccess_edit.jsp";
  public static final String LEVEL_ACCESS_EDIT = PAGES_PATH + "/levelaccess.jsp";
  
  public static final String MASTER_REGIONS = PAGES_PATH + "/region.jsp";
  public static final String MASTER_REGION_LIST = PAGES_PATH + "/region_list.jsp";
  public static final String MASTER_REGION_EDIT = PAGES_PATH + "/region_edit.jsp";
  public static final String MASTER_REGION_INFO = PAGES_PATH + "/region_info.jsp";
  public static final String MASTER_REGION_LOOKUP = PAGES_PATH + "/region_lookup.jsp";
  public static final String CITY_LOOKUP = PAGES_PATH + "/city_lookup.jsp";
  public static final String KEL_LOOKUP = PAGES_PATH + "/kel_lookup.jsp";
  public static final String KEC_LOOKUP = PAGES_PATH + "/kec_lookup.jsp";
  
  public static final String MASTER_RESIDENTS = PAGES_PATH + "/master_resident.jsp";  
  public static final String MASTER_RESIDENT_LIST = PAGES_PATH + "/master_resident_list.jsp";
  public static final String MASTER_RESIDENT_EDIT = PAGES_PATH + "/master_resident_edit.jsp";
  public static final String MASTER_RESIDENT_INFO = PAGES_PATH + "/master_resident_info.jsp";
  public static final String MASTER_RESIDENT_LOOKUP = PAGES_PATH + "/resident_lookup.jsp";

  /* Value of what feature */
  public static final String MASTERUSER = "musr";
  public static final String MASTER_RESIDENT = "mrsdnt";
  public static final String MASTER_REGION = "mrgion";
  public static final String MASTER_REGION_CITY = "mrgioncty";
  public static final String MASTER_REGION_KEL = "mrgionkel";
  public static final String MASTER_REGION_KEC = "mrgionkec";
  public static final String MASTER_LEVEL_ACCESS = "mlvlacc";
  public static final String LEVELACCESS = "lvlaccess";
  
  /* For form input user */
  public static final String FORM_MASTERUSER_USERID = "FORM_MASTERUSER_USERID";
  public static final String FORM_MASTERUSER_PASSWD = "FORM_MASTERUSER_PASSWD";
  public static final String FORM_MASTERUSER_NAME = "FORM_MASTERUSER_NAME";
  public static final String FORM_MASTERUSER_LEVEL = "FORM_MASTERUSER_LEVEL";
  
  /* For Form input Master Resident */
  public static final String FORM_MASTERRESIDENT_NIK = "FORM_MASTERRESIDENT_NIK";
  public static final String FORM_MASTERRESIDENT_KK = "FORM_MASTERRESIDENT_KK";
  public static final String FORM_MASTERRESIDENT_NAME = "FORM_MASTERRESIDENT_NAME";
  public static final String FORM_MASTERRESIDENT_BIRTHCITY = "FORM_MASTERRESIDENT_BIRTHCITY";
  public static final String FORM_MASTERRESIDENT_BIRTHDATE = "FORM_MASTERRESIDENT_BIRTHDATE";
  public static final String FORM_MASTERRESIDENT_SEX = "FORM_MASTERRESIDENT_SEX";
  public static final String FORM_MASTERRESIDENT_RELIGION = "FORM_MASTERRESIDENT_RELIGION";
  public static final String FORM_MASTERRESIDENT_MARITALSTATUS = "FORM_MASTERRESIDENT_MARITALSTATUS";
  public static final String FORM_MASTERRESIDENT_FAMILYPOS = "FORM_MASTERRESIDENT_FAMILYPOS";
  public static final String FORM_MASTERRESIDENT_WORK = "FORM_MASTERRESIDENT_WORK";
  public static final String FORM_MASTERRESIDENT_NATIONALITY = "FORM_MASTERRESIDENT_NATIONALITY";
  public static final String FORM_MASTERRESIDENT_ADDRESS = "FORM_MASTERRESIDENT_ADDRESS";
  public static final String FORM_MASTERRESIDENT_CITY = "FORM_MASTERRESIDENT_CITY";
  public static final String FORM_MASTERRESIDENT_REGION = "FORM_MASTERRESIDENT_REGION";
  public static final String FORM_MASTERRESIDENT_POSTALCODE = "FORM_MASTERRESIDENT_POSTALCODE";
  public static final String FORM_MASTERRESIDENT_RT = "FORM_MASTERRESIDENT_RT";
  public static final String FORM_MASTERRESIDENT_RW = "FORM_MASTERRESIDENT_RW";
  public static final String FORM_MASTERRESIDENT_KELURAHAN = "FORM_MASTERRESIDENT_KELURAHAN";
  public static final String FORM_MASTERRESIDENT_KECAMATAN = "FORM_MASTERRESIDENT_KECAMATAN";
  public static final String FORM_MASTERRESIDENT_NOTE = "FORM_MASTERRESIDENT_NOTE";
  public static final String FORM_MASTERRESIDENT_EMAIL = "FORM_MASTERRESIDENT_EMAIL";
  public static final String FORM_MASTERRESIDENT_MOBILENO = "FORM_MASTERRESIDENT_MOBILENO";
  public static final String FORM_MASTERRESIDENT_PHONENO = "FORM_MASTERRESIDENT_PHONENO";
  
  public static final String FORM_MASTERREGION_REGID = "FORM_MASTERREGION_REGID";
  public static final String FORM_MASTERREGION_KECID = "FORM_MASTERREGION_KECID";
  public static final String FORM_MASTERREGION_KELID = "FORM_MASTERREGION_KELID";
  public static final String FORM_MASTERREGION_REGIONONLY = "FORM_MASTERREGION_REGIONONLY";
  
  public static final String FORM_MASTERUSERLEVELACCESS_LEVELID = "FORM_MASTERUSERLEVELACCESS_LEVELID";
  public static final String FORM_MASTERUSERLEVELACCESS_NAME = "FORM_MASTERUSERLEVELACCESS_NAME";
  public static final String FORM_MASTERUSERLEVELACCESS_NOTE = "FORM_MASTERUSERLEVELACCESS_NOTE";
  
}