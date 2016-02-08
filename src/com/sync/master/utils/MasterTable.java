package com.sync.master.utils;


public class MasterTable
{
  public static final String TABLE_USERLOGIN = "UserLogin";
  public static final String COL_USERLOGIN_ID = TABLE_USERLOGIN + ".ID";
  public static final String COL_USERLOGIN_PASSWD = TABLE_USERLOGIN + ".Password";
  public static final String COL_USERLOGIN_NAME = TABLE_USERLOGIN + ".Name";
  public static final String COL_USERLOGIN_CREATEDATE = TABLE_USERLOGIN + ".CreateDate";
  public static final String COL_USERLOGIN_CREATEUSER = TABLE_USERLOGIN + ".CreateUser";
  public static final String COL_USERLOGIN_ENTRYDATE = TABLE_USERLOGIN + ".EntryDate";
  public static final String COL_USERLOGIN_ENTRYUSER = TABLE_USERLOGIN + ".EntryUser";
  public static final String COL_USERLOGIN_VOIDDATE = TABLE_USERLOGIN + ".VoidDate";
  public static final String COL_USERLOGIN_VOIDUSER = TABLE_USERLOGIN + ".VoidUser";
  
  /* Master Region **/
  public static final String TABLE_MASTERREGION = "MasterRegion";
  public static final String COL_MASTERREGION_REGIONID = TABLE_MASTERREGION + ".RegionID";
  public static final String COL_MASTERREGION_NAME = TABLE_MASTERREGION + ".RegionName";
  public static final String COL_MASTERREGION_NOTE = TABLE_MASTERREGION + ".Note";
  public static final String COL_MASTERREGION_CREATEDATE = TABLE_MASTERREGION + ".CreateDate";
  public static final String COL_MASTERREGION_CREATEUSER = TABLE_MASTERREGION + ".CreateUser";
  public static final String COL_MASTERREGION_ENTRYDATE = TABLE_MASTERREGION + ".EntryDate";
  public static final String COL_MASTERREGION_ENTRYUSER = TABLE_MASTERREGION + ".EntryUser";
  public static final String COL_MASTERREGION_VOIDDATE = TABLE_MASTERREGION + ".VoidDate";
  public static final String COL_MASTERREGION_VOIDUSER = TABLE_MASTERREGION + ".VoidUser";
  
  /* Master Region Kecamatan **/
  public static final String TABLE_MASTER_REGION_KEC = "MasterRegionKecamatan";
  public static final String COl_MASTER_REGION_REGIONID = TABLE_MASTER_REGION_KEC + ".RegionID";
  public static final String COl_MASTER_REGION_KECAMATANID = TABLE_MASTER_REGION_KEC + ".KecamatanID";
  public static final String COl_MASTER_REGION_NAME = TABLE_MASTER_REGION_KEC + ".Name";
  public static final String COl_MASTER_REGION_NOTE = TABLE_MASTER_REGION_KEC + ".Note";
  
  /* Master Region Kelurahan **/
  public static final String TABLE_MASTER_REGION_KEL = "MasterRegionKelurahan";
  public static final String COL_MASTER_REGION_KEL_REGIONID = TABLE_MASTER_REGION_KEL + ".RegionID";
  public static final String COL_MASTER_REGION_KEL_KECAMATANID = TABLE_MASTER_REGION_KEL + ".KecamatanID";
  public static final String COL_MASTER_REGION_KEL_KELURAHANID = TABLE_MASTER_REGION_KEL + ".KelurahanID";
  public static final String COL_MASTER_REGION_KEL_NAME = TABLE_MASTER_REGION_KEL + ".Name";
  public static final String COL_MASTER_REGION_KEL_NOTE = TABLE_MASTER_REGION_KEL + ".Note";
  
  /* Master Resident */
  public static final String TABLE_MASTER_RESIDENT = "MasterResident";
  public static final String COL_MASTER_RESIDENT_NIK = TABLE_MASTER_RESIDENT + ".NIK";
  public static final String COL_MASTER_RESIDENT_KK = TABLE_MASTER_RESIDENT + ".KKNo";
  public static final String COL_MASTER_RESIDENT_NAME = TABLE_MASTER_RESIDENT + ".Name";
  public static final String COL_MASTER_RESIDENT_BIRTHCITY = TABLE_MASTER_RESIDENT + ".BirthCity";
  public static final String COL_MASTER_RESIDENT_BIRTHDATE = TABLE_MASTER_RESIDENT + ".BirthDate";
  public static final String COL_MASTER_RESIDENT_SEX = TABLE_MASTER_RESIDENT + ".Sex";
  public static final String COL_MASTER_RESIDENT_RELIGION = TABLE_MASTER_RESIDENT + ".Religion";
  public static final String COL_MASTER_RESIDENT_MARITALSTATUS = TABLE_MASTER_RESIDENT + ".MaritalStatus";
  public static final String COL_MASTER_RESIDENT_WORK = TABLE_MASTER_RESIDENT + ".Work";
  public static final String COL_MASTER_RESIDENT_NATIONALITY = TABLE_MASTER_RESIDENT + ".Nationality";
  public static final String COL_MASTER_RESIDENT_ADDRESS = TABLE_MASTER_RESIDENT + ".Address";
  public static final String COL_MASTER_RESIDENT_CITY = TABLE_MASTER_RESIDENT + ".City";
  public static final String COL_MASTER_RESIDENT_REGION = TABLE_MASTER_RESIDENT + ".Region";
  public static final String COL_MASTER_RESIDENT_POSTALCODE = TABLE_MASTER_RESIDENT + ".PostalCode";
  public static final String COL_MASTER_RESIDENT_RT = TABLE_MASTER_RESIDENT + ".RT";
  public static final String COL_MASTER_RESIDENT_RW = TABLE_MASTER_RESIDENT + ".RW";
  public static final String COL_MASTER_RESIDENT_KELURAHAN = TABLE_MASTER_RESIDENT + ".Kelurahan";
  public static final String COL_MASTER_RESIDENT_KECAMATAN = TABLE_MASTER_RESIDENT + ".Kecamatan";
  public static final String COL_MASTER_RESIDENT_NOTE = TABLE_MASTER_RESIDENT + ".Note";
  public static final String COL_MASTER_RESIDENT_CREATEDATE = TABLE_MASTER_RESIDENT + ".CreateDate";
  public static final String COL_MASTER_RESIDENT_CREATEUSER = TABLE_MASTER_RESIDENT + ".CreateUser";
  public static final String COL_MASTER_RESIDENT_ENTRYDATE = TABLE_MASTER_RESIDENT + ".EntryDate";
  public static final String COL_MASTER_RESIDENT_ENTRYUSER = TABLE_MASTER_RESIDENT + ".EntryUser";
  public static final String COL_MASTER_RESIDENT_VOIDDATE = TABLE_MASTER_RESIDENT + ".VoidDate";
  public static final String COL_MASTER_RESIDENT_VOIDUSER = TABLE_MASTER_RESIDENT + ".VoidUser";
  
  
}