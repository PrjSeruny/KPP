package com.sync.trans.engine;

import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sync.core.beans.MessageBean;
import com.sync.core.engine.RootEngine;
import com.sync.core.utils.Utilities;
import com.sync.master.beans.MasterUserBean;
import com.sync.master.utils.MasterConstants;
import com.sync.trans.beans.FamilyCardMutationBean;
import com.sync.trans.utils.TransConstants;
import com.sync.trans.utils.TransTable;


public class FamilyCardMutationEngine extends RootEngine
{
  public FamilyCardMutationEngine(){}
  
  public FamilyCardMutationEngine(HttpServletRequest rq, HttpServletResponse rs)
  {
    req=rq;
    res=rs;
  }
  
  public FamilyCardMutationBean validate()
  {
    System.out.println("BEGINNING VALIDATING FAMILY CARD MUTATION");
    MessageBean msg = new MessageBean();
    FamilyCardMutationBean bn = new FamilyCardMutationBean();
    String temp = "";
    bn.setBeanMessages(msg);
    
    /* NIK **/
    temp = Utilities.trim(req.getParameter(
        TransConstants.FORM_FAMILYCARDMUT_NIK));
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 1");
      msg.setMessageBean(TransConstants.FORM_FAMILYCARDMUT_NIK, 
          "Mohon masukkan No.NIK");
    }
    else
    {
      bn.setNIK(temp);
    }
    
    /* Name **/
    temp = Utilities.trim(req.getParameter(
        TransConstants.FORM_FAMILYCARDMUT_NAME));
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 3");
      msg.setMessageBean(TransConstants.FORM_FAMILYCARDMUT_NAME, 
          "Mohon masukkan Nama");
    }
    else
    {
      bn.setName(temp);
    }
    
    /* Start date **/
    temp = Utilities.trim(req.getParameter(
        TransConstants.FORM_FAMILYCARDMUT_STARTDATE));
    System.out.println("DATE= "+temp);
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 5");
      msg.setMessageBean(TransConstants.FORM_FAMILYCARDMUT_STARTDATE, 
          "Mohon masukkan Tanggal Mulai Berlaku KK baru");
    }
    else
    {
      if(!Utilities.isValidDateFormat(MasterConstants.DATE_HTML_SHORT_PATTERN, 
          temp))
      {
        System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 6");
        msg.setMessageBean(TransConstants.FORM_FAMILYCARDMUT_STARTDATE, 
            "Mohon masukkan Tanggal Mulai Berlaku KK baru dengan benar");
      }
      Date dt = Utilities.stringToDate(temp, 
          MasterConstants.DATE_HTML_SHORT_PATTERN);
      bn.setStartDate(dt);
    }
    
    /* Old KK No **/
    temp = Utilities.trim(req.getParameter(
        TransConstants.FORM_FAMILYCARDMUT_OLDKK));
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 2");
      msg.setMessageBean(TransConstants.FORM_FAMILYCARDMUT_OLDKK, 
          "Mohon masukkan No.KK lama");
    }
    else
    {
      bn.setOldKK(temp);
    }
    
    /* New KK No **/
    temp = Utilities.trim(req.getParameter(
        TransConstants.FORM_FAMILYCARDMUT_NEWKK));
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 2");
      msg.setMessageBean(TransConstants.FORM_FAMILYCARDMUT_NEWKK, 
          "Mohon masukkan No.KK baru");
    }
    else
    {
      bn.setNewKK(temp);
    }
    
    /* Sex **/
    temp = Utilities.trim(req.getParameter(
        TransConstants.FORM_FAMILYCARDMUT_SEX));
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 7");
      msg.setMessageBean(TransConstants.FORM_FAMILYCARDMUT_SEX, 
          "Mohon masukkan Jenis Kelamin");
    }
    else
    {
      bn.setSex(Integer.parseInt(temp));
    }
    
    /* Religion **/
    temp = Utilities.trim(req.getParameter(
        TransConstants.FORM_FAMILYCARDMUT_RELIGION));
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 8");
      msg.setMessageBean(TransConstants.FORM_FAMILYCARDMUT_RELIGION, 
          "Mohon masukkan Agama");
    }
    else
    {
      bn.setReligion(temp);
    }
    
    /* Marital Status **/
    temp = Utilities.trim(req.getParameter(
        TransConstants.FORM_FAMILYCARDMUT_MARITALSTATUS));
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 9");
      msg.setMessageBean(TransConstants.FORM_FAMILYCARDMUT_MARITALSTATUS, 
          "Mohon masukkan Status Perkawinan");
    }
    else
    {
      bn.setMaritalStatus(temp);
    }
    
    /*Family Position **/
    temp = Utilities.trim(req.getParameter(
        TransConstants.FORM_FAMILYCARDMUT_FAMILYPOS));
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 9a");
      msg.setMessageBean(TransConstants.FORM_FAMILYCARDMUT_FAMILYPOS, 
          "Mohon masukkan Posisi dalam Keluarga");
    }
    else
    {
      bn.setFamilyPos(temp);
    }
    
    /* Nationality **/
    temp = Utilities.trim(req.getParameter(
        TransConstants.FORM_FAMILYCARDMUT_NATIONALITY));
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 11");
      msg.setMessageBean(TransConstants.FORM_FAMILYCARDMUT_NATIONALITY, 
          "Mohon masukkan data Kewarganegaraan");
    }
    else
    {
      bn.setNationality(temp);
    }
    
    /* Address **/
    temp = Utilities.trim(req.getParameter(
        TransConstants.FORM_FAMILYCARDMUT_ADDRESS));
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 12");
      msg.setMessageBean(TransConstants.FORM_FAMILYCARDMUT_ADDRESS, 
          "Mohon masukkan data alamat");
    }
    else
    {
      bn.setAddress(temp);
    }
    
    /* City **/
    temp = Utilities.trim(req.getParameter(
        TransConstants.FORM_FAMILYCARDMUT_CITY));
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 13");
      msg.setMessageBean(TransConstants.FORM_FAMILYCARDMUT_CITY, 
          "Mohon masukkan data kota tinggal");
    }
    else
    {
      bn.setCity(temp);
    }
    
    /* Region **/
    temp = Utilities.trim(req.getParameter(
        TransConstants.FORM_FAMILYCARDMUT_REGION));
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 14");
      msg.setMessageBean(TransConstants.FORM_FAMILYCARDMUT_REGION, 
          "Mohon masukkan data propinsi ");
    }
    else
    {
      bn.setRegion(temp);
    }
    
    /* Postal Code **/
    temp = Utilities.trim(req.getParameter(
        TransConstants.FORM_FAMILYCARDMUT_POSTALCODE));
    if(Utilities.isEmpy(temp))
    {
      msg.setMessageBean(TransConstants.FORM_FAMILYCARDMUT_POSTALCODE, 
          "Mohon masukkan no kode pos ");
    }
    else
    {
      bn.setPostalCode(temp);
    }
    
    /* RT **/
    temp = Utilities.trim(req.getParameter(
        TransConstants.FORM_FAMILYCARDMUT_RT));
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 16");
      msg.setMessageBean(TransConstants.FORM_FAMILYCARDMUT_RT, 
          "Mohon masukkan data RT ");
    }
    else
    {
      bn.setRT(temp);
    }
    
    /* RW **/
    temp = Utilities.trim(req.getParameter(
        TransConstants.FORM_FAMILYCARDMUT_RW));
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 17");
      msg.setMessageBean(TransConstants.FORM_FAMILYCARDMUT_RW, 
          "Mohon masukkan data RW ");
    }
    else
    {
      bn.SetRW(temp);
    }
    
    /* Kelurahan **/
    temp = Utilities.trim(req.getParameter(
        TransConstants.FORM_FAMILYCARDMUT_KELURAHAN));
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 18");
      msg.setMessageBean(TransConstants.FORM_FAMILYCARDMUT_KELURAHAN, 
          "Mohon masukkan data Kelurahan ");
    }
    else
    {
      bn.setKelurahan(temp);
    }
    
    /* Kecamatan **/
    temp = Utilities.trim(req.getParameter(
        TransConstants.FORM_FAMILYCARDMUT_KECAMATAN));
    if(Utilities.isEmpy(temp))
    {
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEE 19");
      msg.setMessageBean(TransConstants.FORM_FAMILYCARDMUT_KECAMATAN, 
          "Mohon masukkan data Kecamatan ");
    }
    else
    {
      bn.setKecamatan(temp);
    }
    
    /* Note **/
    temp = Utilities.trim(req.getParameter(
        TransConstants.FORM_FAMILYCARDMUT_NOTE));
    if(!Utilities.isEmpy(temp))
    {
      bn.setNote(temp);
    }
    System.out.println("END VALIDATING FAMILY CARD");
    return bn;
  }
  
  /** Getting All Master Resident Data */
  public FamilyCardMutationBean[] listOfFamilyCard(String stat)
  {
    FamilyCardMutationBean[] lists = null;
    int row = 0;
    String currPage = req.getParameter(MasterConstants.FORM_CURRENT_PAGE);
    String search = req.getParameter(MasterConstants.FORM_SEARCH_RECORD);
    String limit = req.getParameter(MasterConstants.FORM_LIMIT_RECORD);

    addSQL = " WHERE ";
    
    if(!Utilities.isEmpy(stat) && stat.equals(MasterConstants.DATA_ARCHIEVE))
    {
      addSQL += TransTable.COL_FAMILYCARDMUT_PROCESSDATE +
          " IS NOT NULL AND " + TransTable.COL_FAMILYCARDMUT_PROCESSUSER +
          " IS NOT NULL " +
          " AND " + TransTable.COL_FAMILYCARDMUT_VOIDDATE + " IS NULL " +
          " AND " + TransTable.COL_FAMILYCARDMUT_VOIDUSER + " IS NULL ";
    }
    else if(!Utilities.isEmpy(stat) && stat.equals(MasterConstants.DATA_RECYCLE))
    {
      addSQL += TransTable.COL_FAMILYCARDMUT_VOIDDATE +
          " IS NOT NULL AND " + TransTable.COL_FAMILYCARDMUT_VOIDDATE +
          " IS NOT NULL "+
          " AND " + TransTable.COL_FAMILYCARDMUT_PROCESSDATE + " IS NULL " +
          " AND " + TransTable.COL_FAMILYCARDMUT_PROCESSUSER + " IS NULL ";
    }
    else
    {
      addSQL += TransTable.COL_FAMILYCARDMUT_VOIDDATE +
          " IS NULL " + 
          " AND " + TransTable.COL_FAMILYCARDMUT_VOIDUSER + " IS NULL " +
          " AND " + TransTable.COL_FAMILYCARDMUT_PROCESSDATE + " IS NULL " +
          " AND " + TransTable.COL_FAMILYCARDMUT_PROCESSUSER + " IS NULL ";
    }
    
    String pagination = buildPagination(TransTable.TABLE_FAMILYCARDMUT, 
                                        (null==currPage?1:Integer.parseInt(currPage)), 
                                        (null==limit?MasterConstants.DEFAULT_LIMIT_RECORD:Integer.parseInt(limit)));
    req.setAttribute(MasterConstants.HTML_PAGINATION, pagination);
    
    SQL = " SELECT " +
          TransTable.TABLE_FAMILYCARDMUT + ".* " +
          " FROM " + TransTable.TABLE_FAMILYCARDMUT + addSQL + SQLlimit;
        
    try
    {
      super.getConnection();
      rs =  super.executeQuery(SQL);
      row = super.getTotalRow();
      
      if(row<=0) return null;
      
      lists = new FamilyCardMutationBean[row];
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
  
  public FamilyCardMutationBean next() throws SQLException
  {
    FamilyCardMutationBean bn = null;
    if(rs.next())
    {
      bn = new FamilyCardMutationBean();
      bn.setNIK(rs.getString(TransTable.COL_FAMILYCARDMUT_NIK));
      bn.setOldKK(rs.getString(TransTable.COL_FAMILYCARDMUT_OLDKK));
      bn.setNewKK(rs.getString(TransTable.COL_FAMILYCARDMUT_NEWKK));
      bn.setName(rs.getString(TransTable.COL_FAMILYCARDMUT_NAME));
      bn.setStartDate(Utilities.stringToDate(
          rs.getString(TransTable.COL_FAMILYCARDMUT_STARTDATE), 
          MasterConstants.DATE_DB_SHORT_PATTERN));
      bn.setSex(rs.getInt(TransTable.COL_FAMILYCARDMUT_SEX));
      bn.setReligion(rs.getString(TransTable.COL_FAMILYCARDMUT_RELIGION));
      bn.setMaritalStatus(rs.getString(
          TransTable.COL_FAMILYCARDMUT_MARITALSTATUS));
      bn.setFamilyPos(rs.getString(TransTable.COL_FAMILYCARDMUT_FAMILYPOS));
      bn.setNationality(rs.getString(
          TransTable.COL_FAMILYCARDMUT_NATIONALITY));
      bn.setAddress(rs.getString(TransTable.COL_FAMILYCARDMUT_ADDRESS));
      bn.setCity(rs.getString(TransTable.COL_FAMILYCARDMUT_CITY));
      bn.setRegion(rs.getString(TransTable.COL_FAMILYCARDMUT_REGION));
      bn.setPostalCode(rs.getString(
          TransTable.COL_FAMILYCARDMUT_POSTALCODE));
      bn.setRT(rs.getString(TransTable.COL_FAMILYCARDMUT_RT));
      bn.SetRW(rs.getString(TransTable.COL_FAMILYCARDMUT_RW));
      bn.setKelurahan(rs.getString(TransTable.COL_FAMILYCARDMUT_KELURAHAN));
      bn.setKecamatan(rs.getString(TransTable.COL_FAMILYCARDMUT_KECAMATAN));
      bn.setNote(rs.getString(TransTable.COL_FAMILYCARDMUT_NOTE));
      bn.setCreateDate(Utilities.stringToDate(
          rs.getString(TransTable.COL_FAMILYCARDMUT_CREATEDATE), 
          MasterConstants.DATE_DB_MEDIUM_PATTERN));
      bn.setCreateUser(rs.getString(TransTable.COL_FAMILYCARDMUT_CREATEUSER));
      bn.setEntryDate(Utilities.stringToDate(
          rs.getString(TransTable.COL_FAMILYCARDMUT_ENTRYDATE), 
          MasterConstants.DATE_DB_MEDIUM_PATTERN));
      bn.setEntryUser(rs.getString(TransTable.COL_FAMILYCARDMUT_ENTRYUSER));
      bn.setVoidDate(Utilities.stringToDate(
          rs.getString(TransTable.COL_FAMILYCARDMUT_VOIDDATE), 
          MasterConstants.DATE_DB_MEDIUM_PATTERN));
      bn.setVoidUser(rs.getString(TransTable.COL_FAMILYCARDMUT_VOIDUSER));
      bn.setProcessDate(Utilities.stringToDate(
          rs.getString(TransTable.COL_FAMILYCARDMUT_PROCESSDATE), 
          TransConstants.DATE_DB_MEDIUM_PATTERN));
      bn.setProcessUser(rs.getString(TransTable.COL_FAMILYCARDMUT_PROCESSUSER));
      bn.setCancelProcessDate(Utilities.stringToDate(
          rs.getString(TransTable.COL_FAMILYCARDMUT_CANCELPROCESSDATE), 
          TransConstants.DATE_DB_MEDIUM_PATTERN));
      bn.setCancelProcessUser(
          rs.getString(TransTable.COL_FAMILYCARDMUT_CANCELPROCESSUSER));
    }
    return bn;
  }
  
  public FamilyCardMutationBean getFamilyCardMutationInfo(String nik, String startDate)
  {
    FamilyCardMutationBean ubn = null;
    Date tDate = Utilities.stringToDate(startDate, TransConstants.DATE_HTML_SHORT_PATTERN);
    SQL = " SELECT " +
          TransTable.TABLE_FAMILYCARDMUT + ".* " +
          " FROM " +
          TransTable.TABLE_FAMILYCARDMUT + 
          " WHERE " +
          TransTable.COL_FAMILYCARDMUT_NIK + "='" + nik + "'" +
          " AND " + TransTable.COL_FAMILYCARDMUT_STARTDATE + "='" + 
          Utilities.dateToString(tDate, TransConstants.DATE_DB_SHORT_PATTERN) + "'";
    
    System.out.println(">>>>>>>>>>>>>>>>>>>> SQL= "+SQL);
    try
    {
      super.getConnection();
      rs = super.executeQuery(SQL);
      
      if(null!=rs)
      {
        ubn = new FamilyCardMutationBean();
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
  
  public boolean create(FamilyCardMutationBean ubn)
  {
    System.out.println("ENGINE CREATE NEW RESIDENT");
    boolean res = false;
    HttpSession ses = req.getSession(false);
    MasterUserBean uses = (MasterUserBean)ses.getAttribute(
        MasterConstants.MASTERUSER);
    
    try
    {
      SQL = " INSERT INTO " + TransTable.TABLE_FAMILYCARDMUT +
            "(" +
               TransTable.COL_FAMILYCARDMUT_NIK + "," +
               TransTable.COL_FAMILYCARDMUT_NAME + "," +
               TransTable.COL_FAMILYCARDMUT_STARTDATE + "," +
               TransTable.COL_FAMILYCARDMUT_OLDKK + "," +
               TransTable.COL_FAMILYCARDMUT_NEWKK + "," +
               TransTable.COL_FAMILYCARDMUT_SEX + "," +
               TransTable.COL_FAMILYCARDMUT_RELIGION + "," +
               TransTable.COL_FAMILYCARDMUT_MARITALSTATUS + "," +
               TransTable.COL_FAMILYCARDMUT_FAMILYPOS + "," +
               TransTable.COL_FAMILYCARDMUT_NATIONALITY + "," +
               TransTable.COL_FAMILYCARDMUT_ADDRESS + "," +
               TransTable.COL_FAMILYCARDMUT_CITY + "," +
               TransTable.COL_FAMILYCARDMUT_REGION + "," +
               TransTable.COL_FAMILYCARDMUT_POSTALCODE + "," +
               TransTable.COL_FAMILYCARDMUT_RT + "," +
               TransTable.COL_FAMILYCARDMUT_RW + "," +
               TransTable.COL_FAMILYCARDMUT_KELURAHAN + "," +
               TransTable.COL_FAMILYCARDMUT_KECAMATAN + "," +
               TransTable.COL_FAMILYCARDMUT_NOTE + "," +
               TransTable.COL_FAMILYCARDMUT_CREATEDATE + "," +
               TransTable.COL_FAMILYCARDMUT_CREATEUSER +
             ")" +
            " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      
      super.getConnection();
      stat = con.prepareStatement(SQL);
      
      stat.setString(1, ubn.getNIK());
      stat.setString(2, ubn.getName());
      stat.setString(3, Utilities.dateToString(ubn.getStartDate(), 
          MasterConstants.DATE_DB_SHORT_PATTERN));
      stat.setString(4, ubn.getOldKK());
      stat.setString(5, ubn.getNewKK());
      stat.setInt(6, ubn.getSex());
      stat.setString(7, ubn.getReligion());
      stat.setString(8, ubn.getMaritalStatus());
      stat.setString(9, ubn.getFamilyPos());
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
      
      System.out.println("END ENGINE CREATE NEW FAMILY CARD");
      if(stat.executeUpdate()>0) return true;
      else return false;
    }
    catch(Exception e)
    {
      e.printStackTrace();
      super.rollback();
      res = false;
      System.out.println("ERR ENGINE CREATE FAMILY CARDT "+e.getMessage());
    }
    
    return res;
  }
  
  public boolean update(FamilyCardMutationBean ubn)
  {
    boolean res = false;
    HttpSession ses = req.getSession(false);
    MasterUserBean uses = (MasterUserBean)ses.getAttribute(
        MasterConstants.MASTERUSER);
    
    try
    {
      SQL = " UPDATE " + TransTable.TABLE_FAMILYCARDMUT +
            " SET " +
            TransTable.COL_FAMILYCARDMUT_NAME + "=?, " +
            TransTable.COL_FAMILYCARDMUT_OLDKK + "=?, " +
            TransTable.COL_FAMILYCARDMUT_NEWKK + "=?, " +
            TransTable.COL_FAMILYCARDMUT_SEX + "=?, " +
            TransTable.COL_FAMILYCARDMUT_RELIGION + "=?, " +
            TransTable.COL_FAMILYCARDMUT_MARITALSTATUS + "=?, " +
            TransTable.COL_FAMILYCARDMUT_FAMILYPOS + "=?, " +
            TransTable.COL_FAMILYCARDMUT_NATIONALITY + "=?, " +
            TransTable.COL_FAMILYCARDMUT_ADDRESS + "=?, " +
            TransTable.COL_FAMILYCARDMUT_CITY + "=?, " +
            TransTable.COL_FAMILYCARDMUT_REGION + "=?, " +
            TransTable.COL_FAMILYCARDMUT_POSTALCODE + "=?, " +
            TransTable.COL_FAMILYCARDMUT_KELURAHAN + "=?, " +
            TransTable.COL_FAMILYCARDMUT_KECAMATAN + "=?, " +
            TransTable.COL_FAMILYCARDMUT_RT + "=?, " +
            TransTable.COL_FAMILYCARDMUT_RW + "=?, " +
            TransTable.COL_FAMILYCARDMUT_NOTE + "=?, " +
            TransTable.COL_FAMILYCARDMUT_ENTRYDATE + "=?, " +
            TransTable.COL_FAMILYCARDMUT_ENTRYUSER + "=? " +
            " WHERE " +
            TransTable.COL_FAMILYCARDMUT_NIK + "=? AND " +
            TransTable.COL_FAMILYCARDMUT_STARTDATE + "=? ";
      
      super.getConnection();
      stat = con.prepareStatement(SQL);
      stat.setString(1, ubn.getName());
      stat.setString(2, ubn.getOldKK());
      stat.setString(3, ubn.getNewKK());
      stat.setInt(4, ubn.getSex());
      stat.setString(5, ubn.getReligion());
      stat.setString(6, ubn.getMaritalStatus());
      stat.setString(7, ubn.getFamilyPos());
      stat.setString(8, ubn.getNationality());
      stat.setString(9, ubn.getAddress());
      stat.setString(10, ubn.getCity());
      stat.setString(11, ubn.getRegion());
      stat.setString(12, ubn.getPostalCode());
      stat.setString(13, ubn.getKelurahan());
      stat.setString(14, ubn.getKecamatan());
      stat.setString(15, ubn.getRT());
      stat.setString(16, ubn.getRW());
      stat.setString(17, ubn.getNote());
      stat.setString(18, Utilities.dateToString(new Date(), 
          MasterConstants.DATE_DB_MEDIUM_PATTERN));
      stat.setString(19, uses.getUser());
      stat.setString(20, ubn.getNIK());
      stat.setString(21, Utilities.dateToString(ubn.getStartDate(), 
          MasterConstants.DATE_DB_SHORT_PATTERN));
      
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
  

  

  
  
  public boolean delete(String[] niks, String[] tdate)
  {
    boolean res = false;
    HttpSession ses = req.getSession(false);
    MasterUserBean uses = (MasterUserBean)ses.getAttribute(
        MasterConstants.MASTERUSER);
    
    try
    {
      SQL = " UPDATE " + TransTable.TABLE_FAMILYCARDMUT +
          " SET " +
          TransTable.COL_FAMILYCARDMUT_VOIDDATE + "=?, " +
          TransTable.COL_FAMILYCARDMUT_VOIDUSER + "=? " +
          " WHERE " +
          TransTable.COL_FAMILYCARDMUT_NIK + "=?  AND " +
          TransTable.COL_FAMILYCARDMUT_STARTDATE + "=? ";
    
    super.getConnection();
    stat = con.prepareStatement(SQL);
    
    for(int i=0; i<niks.length; i++)
    {
      stat.setString(1, Utilities.dateToString(new Date(), 
          MasterConstants.DATE_DB_MEDIUM_PATTERN));
      stat.setString(2, uses.getUser());
      stat.setString(3, niks[i]);
      stat.setString(4, tdate[i]);
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
  
  public boolean proceed(FamilyCardMutationBean bn, boolean cancelled)
  {
    boolean res = false;
    HttpSession ses = req.getSession(false);
    
    try
    {
      
      MasterUserBean user = (MasterUserBean)ses.getAttribute(
          MasterConstants.MASTERUSER);
      
      if(!cancelled)
      {
        bn.setProcessDate(new Date());
        bn.setProcessUser(user.getUser());
        bn.setCancelProcessDate(null);
        bn.setCancelProcessUser(null);
      }
      else
      {
        bn.setProcessDate(null);
        bn.setProcessUser(null);
        bn.setCancelProcessDate(new Date());
        bn.setCancelProcessUser(user.getUser());
      }
      
      if(!this.updateStatusProcess(bn))
      {
        throw new Exception("Gagal Update status process");
      }
      
      res = true;
    }
    catch(Exception e)
    {
      e.printStackTrace();
      super.rollback();
      res = false;
      MessageBean msg=new MessageBean();
      msg.setMessageBean(MessageBean.MSG_ERR, e.getMessage());
      bn.setBeanMessages(msg);
    }
    return res;
  }
  
  public boolean updateStatusProcess(FamilyCardMutationBean bn)
  {
    boolean res = false;
    
    try
    {
      SQL = " UPDATE " + TransTable.TABLE_FAMILYCARDMUT + 
            " SET " +
            TransTable.COL_FAMILYCARDMUT_PROCESSDATE + "=?, " +
            TransTable.COL_FAMILYCARDMUT_PROCESSUSER + "=?, " +
            TransTable.COL_FAMILYCARDMUT_CANCELPROCESSDATE + "=?, " +
            TransTable.COL_FAMILYCARDMUT_CANCELPROCESSUSER + "=? " +
            " WHERE " +
            TransTable.COL_FAMILYCARDMUT_NIK + "=? AND " +
            TransTable.COL_FAMILYCARDMUT_STARTDATE + "=? ";
      
      super.getConnection();
      stat = con.prepareStatement(SQL);
      stat.setString(1, Utilities.dateToString(bn.getProcessDate(), 
          TransConstants.DATE_DB_MEDIUM_PATTERN));
      stat.setString(2, bn.getProcessUser());
      stat.setString(3, Utilities.dateToString(bn.getCancelProcessDate(), 
          TransConstants.DATE_DB_MEDIUM_PATTERN));
      stat.setString(4, bn.getCancelProcessUser());
      stat.setString(5, bn.getNIK());
      stat.setString(6, Utilities.dateToString(bn.getStartDate(), 
          TransConstants.DATE_DB_SHORT_PATTERN));
      
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
  
  public void closed()
  {
    super.finalize();
  }
  
}