package com.sync.master.engine;

import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sync.core.beans.MessageBean;
import com.sync.core.engine.RootEngine;
import com.sync.core.utils.Utilities;
import com.sync.master.beans.MasterResidentBean;
import com.sync.master.beans.MasterUserBean;
import com.sync.master.utils.MasterConstants;
import com.sync.master.utils.MasterTable;


public class MasterResidentEngine extends RootEngine
{
  //private HttpServletRequest req;
  //private HttpServletResponse res;
  //private String SQL = "";
  //private ResultSet rs = null;
  //private MasterResidentEngine re = null;
  
  public MasterResidentEngine(){}
  
  /*public MasterResidentEngine(Connection conn)
  { super(conn); }*/
  
  public MasterResidentEngine(HttpServletRequest rq, HttpServletResponse rs)
  {
    req=rq;
    res=rs;
  }
  
  public MasterResidentBean validate()
  {
    System.out.println("BEGINNING VALIDATING RESIDENT");
    MessageBean msg = new MessageBean();
    MasterResidentBean bn = new MasterResidentBean();
    String temp = "";
    bn.setBeanMessages(msg);
    
    /* NIK **/
    temp = Utilities.trim(req.getParameter(
        MasterConstants.FORM_MASTERRESIDENT_NIK));
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 1");
      msg.setMessageBean(MasterConstants.FORM_MASTERRESIDENT_NIK, 
          "Mohon masukkan No.NIK");
    }
    else
    {
      bn.setNIK(temp);
    }
    
    /* KK No **/
    temp = Utilities.trim(req.getParameter(
        MasterConstants.FORM_MASTERRESIDENT_KK));
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 2");
      msg.setMessageBean(MasterConstants.FORM_MASTERRESIDENT_KK, 
          "Mohon masukkan No.KK");
    }
    else
    {
      bn.setKKNo(temp);
    }
    
    /* Name **/
    temp = Utilities.trim(req.getParameter(
        MasterConstants.FORM_MASTERRESIDENT_NAME));
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 3");
      msg.setMessageBean(MasterConstants.FORM_MASTERRESIDENT_NAME, 
          "Mohon masukkan Nama");
    }
    else
    {
      bn.setName(temp);
    }
    
    /* BirthCity **/
    temp = Utilities.trim(req.getParameter(
        MasterConstants.FORM_MASTERRESIDENT_BIRTHCITY));
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 4");
      msg.setMessageBean(MasterConstants.FORM_MASTERRESIDENT_BIRTHCITY, 
          "Mohon masukkan Kota Kelahiran");
    }
    else
    {
      bn.setBirthCity(temp);
    }
    
    /* BirthDate **/
    temp = Utilities.trim(req.getParameter(
        MasterConstants.FORM_MASTERRESIDENT_BIRTHDATE));
    System.out.println("DATE= "+temp);
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 5");
      msg.setMessageBean(MasterConstants.FORM_MASTERRESIDENT_BIRTHDATE, 
          "Mohon masukkan Tanggal Kelahiran");
    }
    else
    {
      if(!Utilities.isValidDateFormat(MasterConstants.DATE_HTML_SHORT_PATTERN, 
          temp))
      {
        System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 6");
        msg.setMessageBean(MasterConstants.FORM_MASTERRESIDENT_BIRTHDATE, 
            "Mohon masukkan Tanggal Kelahiran dengan benar");
      }
      Date dt = Utilities.stringToDate(temp, 
          MasterConstants.DATE_HTML_SHORT_PATTERN);
      bn.setBirthDate(dt);
    }
    
    /* Sex **/
    temp = Utilities.trim(req.getParameter(
        MasterConstants.FORM_MASTERRESIDENT_SEX));
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 7");
      msg.setMessageBean(MasterConstants.FORM_MASTERRESIDENT_SEX, 
          "Mohon masukkan Jenis Kelamin");
    }
    else
    {
      bn.setSex(Integer.parseInt(temp));
    }
    
    /* Religion **/
    temp = Utilities.trim(req.getParameter(
        MasterConstants.FORM_MASTERRESIDENT_RELIGION));
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 8");
      msg.setMessageBean(MasterConstants.FORM_MASTERRESIDENT_RELIGION, 
          "Mohon masukkan Agama");
    }
    else
    {
      bn.setReligion(temp);
    }
    
    /* Marital Status **/
    temp = Utilities.trim(req.getParameter(
        MasterConstants.FORM_MASTERRESIDENT_MARITALSTATUS));
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 9");
      msg.setMessageBean(MasterConstants.FORM_MASTERRESIDENT_MARITALSTATUS, 
          "Mohon masukkan Status Perkawinan");
    }
    else
    {
      bn.setMaritalStatus(temp);
    }
    
    /* Work **/
    temp = Utilities.trim(req.getParameter(
        MasterConstants.FORM_MASTERRESIDENT_WORK));
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 10");
      msg.setMessageBean(MasterConstants.FORM_MASTERRESIDENT_WORK, 
          "Mohon masukkan data pekerjaan");
    }
    else
    {
      bn.setWork(temp);
    }
    
    /* Nationality **/
    temp = Utilities.trim(req.getParameter(
        MasterConstants.FORM_MASTERRESIDENT_NATIONALITY));
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 11");
      msg.setMessageBean(MasterConstants.FORM_MASTERRESIDENT_NATIONALITY, 
          "Mohon masukkan data Kewarganegaraan");
    }
    else
    {
      bn.setNationality(temp);
    }
    
    /* Address **/
    temp = Utilities.trim(req.getParameter(
        MasterConstants.FORM_MASTERRESIDENT_ADDRESS));
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 12");
      msg.setMessageBean(MasterConstants.FORM_MASTERRESIDENT_ADDRESS, 
          "Mohon masukkan data alamat");
    }
    else
    {
      bn.setAddress(temp);
    }
    
    /* City **/
    temp = Utilities.trim(req.getParameter(
        MasterConstants.FORM_MASTERRESIDENT_CITY));
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 13");
      msg.setMessageBean(MasterConstants.FORM_MASTERRESIDENT_CITY, 
          "Mohon masukkan data kota tinggal");
    }
    else
    {
      bn.setCity(temp);
    }
    
    /* Region **/
    temp = Utilities.trim(req.getParameter(
        MasterConstants.FORM_MASTERRESIDENT_REGION));
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 14");
      msg.setMessageBean(MasterConstants.FORM_MASTERRESIDENT_REGION, 
          "Mohon masukkan data propinsi ");
    }
    else
    {
      bn.setRegion(temp);
    }
    
    /* Postal Code **/
    temp = Utilities.trim(req.getParameter(
        MasterConstants.FORM_MASTERRESIDENT_POSTALCODE));
    if(Utilities.isEmpy(temp))
    {
      msg.setMessageBean(MasterConstants.FORM_MASTERRESIDENT_POSTALCODE, 
          "Mohon masukkan no kode pos ");
    }
    else
    {
      bn.setPostalCode(temp);
    }
    
    /* RT **/
    temp = Utilities.trim(req.getParameter(
        MasterConstants.FORM_MASTERRESIDENT_RT));
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 16");
      msg.setMessageBean(MasterConstants.FORM_MASTERRESIDENT_RT, 
          "Mohon masukkan data RT ");
    }
    else
    {
      bn.setRT(temp);
    }
    
    /* RW **/
    temp = Utilities.trim(req.getParameter(
        MasterConstants.FORM_MASTERRESIDENT_RW));
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 17");
      msg.setMessageBean(MasterConstants.FORM_MASTERRESIDENT_RW, 
          "Mohon masukkan data RW ");
    }
    else
    {
      bn.SetRW(temp);
    }
    
    /* Kelurahan **/
    temp = Utilities.trim(req.getParameter(
        MasterConstants.FORM_MASTERRESIDENT_KELURAHAN));
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 18");
      msg.setMessageBean(MasterConstants.FORM_MASTERRESIDENT_KELURAHAN, 
          "Mohon masukkan data Kelurahan ");
    }
    else
    {
      bn.setKelurahan(temp);
    }
    
    /* Kecamatan **/
    temp = Utilities.trim(req.getParameter(
        MasterConstants.FORM_MASTERRESIDENT_KECAMATAN));
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 19");
      msg.setMessageBean(MasterConstants.FORM_MASTERRESIDENT_KECAMATAN, 
          "Mohon masukkan data Kecamatan ");
    }
    else
    {
      bn.setKecamatan(temp);
    }
    
    /* Note **/
    temp = Utilities.trim(req.getParameter(
        MasterConstants.FORM_MASTERRESIDENT_NOTE));
    if(!Utilities.isEmpy(temp))
    {
      bn.setNote(temp);
    }
    System.out.println("END VALIDATING RESIDENT");
    return bn;
  }
  
  /** Getting All Master Resident Data */
  public MasterResidentBean[] listOfResidents(String stat)
  {
    MasterResidentBean[] lists = null;
    int row = 0;
    String currPage = req.getParameter(MasterConstants.FORM_CURRENT_PAGE);
    String search = req.getParameter(MasterConstants.FORM_SEARCH_RECORD);
    String limit = req.getParameter(MasterConstants.FORM_LIMIT_RECORD);

    addSQL = " WHERE ";
    
    if(!Utilities.isEmpy(stat) && stat.equals(MasterConstants.DATA_ARCHIEVE))
    {
      addSQL += MasterTable.COL_MASTER_RESIDENT_VOIDDATE +
          " IS NOT NULL AND " + MasterTable.COL_MASTER_RESIDENT_VOIDUSER +
          " IS NOT NULL ";
    }
    else
    {
      addSQL += MasterTable.COL_MASTER_RESIDENT_VOIDDATE +
          " IS NULL AND " + MasterTable.COL_MASTER_RESIDENT_VOIDUSER +
          " IS NULL ";
    }
    
    if(!Utilities.isEmpy(search)){
      addSQL += "AND ("+MasterTable.COL_MASTER_RESIDENT_KK+" LIKE '%"+search+"%' OR " +
          MasterTable.COL_MASTER_RESIDENT_NAME+" like '%"+search+"%' OR " +
          MasterTable.COL_MASTER_RESIDENT_NIK+" like '%"+search+"%')";
    }
    
    String pagination = buildPagination(MasterTable.TABLE_MASTER_RESIDENT, 
                                        (null==currPage?1:Integer.parseInt(currPage)), 
                                        (null==limit?MasterConstants.DEFAULT_LIMIT_RECORD:Integer.parseInt(limit)));
    req.setAttribute(MasterConstants.HTML_PAGINATION, pagination);
    
    SQL = " SELECT " +
          MasterTable.TABLE_MASTER_RESIDENT + ".* " +
          " FROM " + MasterTable.TABLE_MASTER_RESIDENT + addSQL + SQLlimit;
        
    try
    {
      super.getConnection();
      rs =  super.executeQuery(SQL);
      row = super.getTotalRow();
      
      if(row<=0) return null;
      
      lists = new MasterResidentBean[row];
      if(null!=rs)
      {
        for(int i=0; i<row; i++)
        {
          lists[i] = this.next();
        }
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    
    return lists;
  }
  
  public MasterResidentBean next() throws SQLException
  {
    MasterResidentBean bn = null;
    if(rs.next())
    {
      bn = new MasterResidentBean();
      bn.setNIK(rs.getString(MasterTable.COL_MASTER_RESIDENT_NIK));
      bn.setKKNo(rs.getString(MasterTable.COL_MASTER_RESIDENT_KK));
      bn.setName(rs.getString(MasterTable.COL_MASTER_RESIDENT_NAME));
      bn.setBirthCity(rs.getString(MasterTable.COL_MASTER_RESIDENT_BIRTHCITY));
      System.out.println("TGL "+rs.getString(MasterTable.COL_MASTER_RESIDENT_BIRTHDATE));
      bn.setBirthDate(Utilities.stringToDate(
          rs.getString(MasterTable.COL_MASTER_RESIDENT_BIRTHDATE), 
          MasterConstants.DATE_DB_SHORT_PATTERN));
      bn.setDeathDate(Utilities.stringToDate(
          rs.getString(MasterTable.COL_MASTER_RESIDENT_DEATHDATE), 
          MasterConstants.DATE_DB_SHORT_PATTERN));
      bn.setSex(rs.getInt(MasterTable.COL_MASTER_RESIDENT_SEX));
      bn.setReligion(rs.getString(MasterTable.COL_MASTER_RESIDENT_RELIGION));
      bn.setMaritalStatus(rs.getString(
          MasterTable.COL_MASTER_RESIDENT_MARITALSTATUS));
      bn.setWork(rs.getString(MasterTable.COL_MASTER_RESIDENT_WORK));
      bn.setNationality(rs.getString(
          MasterTable.COL_MASTER_RESIDENT_NATIONALITY));
      bn.setAddress(rs.getString(MasterTable.COL_MASTER_RESIDENT_ADDRESS));
      bn.setCity(rs.getString(MasterTable.COL_MASTER_RESIDENT_CITY));
      bn.setRegion(rs.getString(MasterTable.COL_MASTER_RESIDENT_REGION));
      bn.setPostalCode(rs.getString(
          MasterTable.COL_MASTER_RESIDENT_POSTALCODE));
      bn.setRT(rs.getString(MasterTable.COL_MASTER_RESIDENT_RT));
      bn.SetRW(rs.getString(MasterTable.COL_MASTER_RESIDENT_RW));
      bn.setKelurahan(rs.getString(MasterTable.COL_MASTER_RESIDENT_KELURAHAN));
      bn.setKecamatan(rs.getString(MasterTable.COL_MASTER_RESIDENT_KECAMATAN));
      bn.setNote(rs.getString(MasterTable.COL_MASTER_RESIDENT_NOTE));
      bn.setCreateDate(Utilities.stringToDate(
          rs.getString(MasterTable.COL_MASTER_RESIDENT_CREATEDATE), 
          MasterConstants.DATE_DB_MEDIUM_PATTERN));
      bn.setCreateUser(rs.getString(MasterTable.COL_MASTER_RESIDENT_CREATEUSER));
      bn.setEntryDate(Utilities.stringToDate(
          rs.getString(MasterTable.COL_MASTER_RESIDENT_ENTRYDATE), 
          MasterConstants.DATE_DB_MEDIUM_PATTERN));
      bn.setEntryUser(rs.getString(MasterTable.COL_MASTER_RESIDENT_ENTRYUSER));
      bn.setVoidDate(Utilities.stringToDate(
          rs.getString(MasterTable.COL_MASTER_RESIDENT_VOIDDATE), 
          MasterConstants.DATE_DB_MEDIUM_PATTERN));
      bn.setVoidUser(rs.getString(MasterTable.COL_MASTER_RESIDENT_VOIDUSER));
    }
    return bn;
  }
  
  public MasterResidentBean getMasterResidentInfo(String nik)
  {
    MasterResidentBean ubn = null;
    
    SQL = " SELECT " +
          MasterTable.TABLE_MASTER_RESIDENT + ".* " +
          " FROM " +
          MasterTable.TABLE_MASTER_RESIDENT + 
          " WHERE " +
          MasterTable.COL_MASTER_RESIDENT_NIK + "='" + nik + "';";
    
    try
    {
      super.getConnection();
      rs = super.executeQuery(SQL);
      
      if(null!=rs)
      {
        ubn = new MasterResidentBean();
        ubn = this.next();
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
      ubn = null;
    }
    
    return ubn;
  }
  
  public boolean createMasterResident(MasterResidentBean ubn)
  {
    System.out.println("ENGINE CREATE NEW RESIDENT");
    boolean res = false;
    HttpSession ses = req.getSession(false);
    MasterUserBean uses = (MasterUserBean)ses.getAttribute(
        MasterConstants.MASTERUSER);
    
    try
    {
      SQL = " INSERT INTO " + MasterTable.TABLE_MASTER_RESIDENT +
            "(" +
               MasterTable.COL_MASTER_RESIDENT_NIK + "," +
               MasterTable.COL_MASTER_RESIDENT_KK + "," +
               MasterTable.COL_MASTER_RESIDENT_NAME + "," +
               MasterTable.COL_MASTER_RESIDENT_BIRTHCITY + "," +
               MasterTable.COL_MASTER_RESIDENT_BIRTHDATE + "," +
               MasterTable.COL_MASTER_RESIDENT_SEX + "," +
               MasterTable.COL_MASTER_RESIDENT_RELIGION + "," +
               MasterTable.COL_MASTER_RESIDENT_MARITALSTATUS + "," +
               MasterTable.COL_MASTER_RESIDENT_WORK + "," +
               MasterTable.COL_MASTER_RESIDENT_NATIONALITY + "," +
               MasterTable.COL_MASTER_RESIDENT_ADDRESS + "," +
               MasterTable.COL_MASTER_RESIDENT_CITY + "," +
               MasterTable.COL_MASTER_RESIDENT_REGION + "," +
               MasterTable.COL_MASTER_RESIDENT_POSTALCODE + "," +
               MasterTable.COL_MASTER_RESIDENT_RT + "," +
               MasterTable.COL_MASTER_RESIDENT_RW + "," +
               MasterTable.COL_MASTER_RESIDENT_KELURAHAN + "," +
               MasterTable.COL_MASTER_RESIDENT_KECAMATAN + "," +
               MasterTable.COL_MASTER_RESIDENT_NOTE + "," +
               MasterTable.COL_MASTER_RESIDENT_CREATEDATE + "," +
               MasterTable.COL_MASTER_RESIDENT_CREATEUSER +
             ")" +
            " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      
      super.getConnection();
      stat = con.prepareStatement(SQL);
      
      stat.setString(1, ubn.getNIK());
      stat.setString(2, ubn.getKKNo());
      stat.setString(3, ubn.getName());
      stat.setString(4, ubn.getBirthCity());
      stat.setString(5, Utilities.dateToString(ubn.getBirthDate(), 
          MasterConstants.DATE_DB_SHORT_PATTERN));
      stat.setInt(6, ubn.getSex());
      stat.setString(7, ubn.getReligion());
      stat.setString(8, ubn.getMaritalStatus());
      stat.setString(9, ubn.getWork());
      stat.setString(10, ubn.getNationality());
      stat.setString(11, ubn.getAddress());
      stat.setString(12, ubn.getCity());
      stat.setString(13, ubn.getRegion());
      stat.setString(14, ubn.getPostalCode());
      stat.setString(15, ubn.getRT());
      stat.setString(16, ubn.getRW());
      stat.setString(17, ubn.getKelurahan());
      stat.setString(18, ubn.getKecamatan());
      stat.setString(19, ubn.getNote());
      stat.setString(20, Utilities.dateToString(new Date(), 
          MasterConstants.DATE_DB_MEDIUM_PATTERN));
      stat.setString(21, uses.getUser());
      
      System.out.println("END ENGINE CREATE NEW RESIDENT");
      if(stat.executeUpdate()>0) return true;
      else return false;
    }
    catch(Exception e)
    {
      e.printStackTrace();
      super.rollback();
      res = false;
      System.out.println("ERR ENGINE CREATE NEW RESIDENT "+e.getMessage());
    }
    
    return res;
  }
  
  public boolean updateMasterResident(MasterResidentBean ubn)
  {
    boolean res = false;
    HttpSession ses = req.getSession(false);
    MasterUserBean uses = (MasterUserBean)ses.getAttribute(
        MasterConstants.MASTERUSER);
    
    try
    {
      SQL = " UPDATE " + MasterTable.TABLE_MASTER_RESIDENT +
            " SET " +
            MasterTable.COL_MASTER_RESIDENT_NAME + "=?, " +
            MasterTable.COL_MASTER_RESIDENT_BIRTHCITY + "=?, " +
            MasterTable.COL_MASTER_RESIDENT_BIRTHDATE + "=?, " +
            MasterTable.COL_MASTER_RESIDENT_SEX + "=?, " +
            MasterTable.COL_MASTER_RESIDENT_RELIGION + "=?, " +
            MasterTable.COL_MASTER_RESIDENT_WORK + "=?, " +
            MasterTable.COL_MASTER_RESIDENT_NATIONALITY + "=?, " +
            MasterTable.COL_MASTER_RESIDENT_NOTE + "=?, " +
            MasterTable.COL_MASTER_RESIDENT_ENTRYDATE + "=?, " +
            MasterTable.COL_MASTER_RESIDENT_ENTRYUSER + "=? " +
            " WHERE " +
            MasterTable.COL_MASTER_RESIDENT_NIK + "=?;";
      
      super.getConnection();
      stat = con.prepareStatement(SQL);
      stat.setString(1, ubn.getName());
      stat.setString(2, ubn.getBirthCity());
      stat.setString(3, Utilities.dateToString(ubn.getBirthDate(), 
          MasterConstants.DATE_DB_SHORT_PATTERN));
      stat.setInt(4, ubn.getSex());
      stat.setString(5, ubn.getReligion());
      stat.setString(6, ubn.getWork());
      stat.setString(7, ubn.getNationality());
      stat.setString(8, ubn.getNote());
      stat.setString(9, Utilities.dateToString(new Date(), 
          MasterConstants.DATE_DB_MEDIUM_PATTERN));
      stat.setString(10, uses.getUser());
      stat.setString(11, ubn.getNIK());
      
      if(stat.executeUpdate()>0) return true;
      else return false;
    }
    catch(Exception e)
    {
      e.printStackTrace();
      super.rollback();
      res = false;
    }
    return res;
  }
  
  public boolean updateDeathDate(MasterResidentBean ubn)
  {
    boolean res = false;
    
    try
    {
      SQL = " UPDATE " + MasterTable.TABLE_MASTER_RESIDENT +
            " SET " +
            MasterTable.COL_MASTER_RESIDENT_DEATHDATE + "=? " +
            " WHERE " +
            MasterTable.COL_MASTER_RESIDENT_NIK + "=?;";
      
      super.getConnection();
      stat = con.prepareStatement(SQL);
      stat.setString(1, Utilities.dateToString(ubn.getDeathDate(), 
          MasterConstants.DATE_DB_MEDIUM_PATTERN));
      stat.setString(2, ubn.getNIK());
      
      if(stat.executeUpdate()>0) return true;
      else return false;
    }
    catch(Exception e)
    {
      e.printStackTrace();
      super.rollback();
      res = false;
    }
    return res;
  }
  
  
  public boolean delete(String[] niks)
  {
    boolean res = false;
    HttpSession ses = req.getSession(false);
    MasterUserBean uses = (MasterUserBean)ses.getAttribute(
        MasterConstants.MASTERUSER);
    
    try
    {
      SQL = " UPDATE " + MasterTable.TABLE_MASTER_RESIDENT +
          " SET " +
          MasterTable.COL_MASTER_RESIDENT_VOIDDATE + "=?, " +
          MasterTable.COL_MASTER_RESIDENT_VOIDUSER + "=? " +
          " WHERE " +
          MasterTable.COL_MASTER_RESIDENT_NIK + "=?;";
    
    super.getConnection();
    stat = con.prepareStatement(SQL);
    
    for(int i=0; i<niks.length; i++)
    {
      stat.setString(1, Utilities.dateToString(new Date(), 
          MasterConstants.DATE_DB_MEDIUM_PATTERN));
      stat.setString(2, uses.getUser());
      stat.setString(3, niks[i]);
      stat.executeUpdate();
    }
    
    res = true;
  }
    catch(Exception e)
    {
      e.printStackTrace();
      super.rollback();
      res = false;
    }
    
    return res;
  }
  
  
  public void closed()
  {
    super.finalize();
  }
  
}