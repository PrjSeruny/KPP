package com.sync.master.engine;

import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sync.core.engine.RootEngine;
import com.sync.core.utils.Utilities;
import com.sync.master.beans.MasterResidentBean;
import com.sync.master.beans.MasterResidentHistoryBean;
import com.sync.master.beans.MasterUserBean;
import com.sync.master.utils.MasterConstants;
import com.sync.master.utils.MasterTable;


public class MasterResidentHistoryEngine extends RootEngine
{
  
  public MasterResidentHistoryEngine(){}
  
  public MasterResidentHistoryEngine(HttpServletRequest rq, HttpServletResponse rs)
  {
    req=rq;
    res=rs;
  }
  
  public MasterResidentBean next() throws SQLException
  {
    MasterResidentBean bn = null;
    if(rs.next())
    {
      bn = new MasterResidentBean();
      bn.setNIK(rs.getString(MasterTable.COL_MASTER_RESIDENTHISTORY_NIK));
      bn.setKKNo(rs.getString(MasterTable.COL_MASTER_RESIDENTHISTORY_KK));
      bn.setName(rs.getString(MasterTable.COL_MASTER_RESIDENTHISTORY_NAME));
      bn.setSex(rs.getInt(MasterTable.COL_MASTER_RESIDENTHISTORY_SEX));
      bn.setReligion(rs.getString(MasterTable.COL_MASTER_RESIDENTHISTORY_RELIGION));
      bn.setMaritalStatus(rs.getString(
          MasterTable.COL_MASTER_RESIDENTHISTORY_MARITALSTATUS));
      bn.setFamilyPos(rs.getString(MasterTable.COL_MASTER_RESIDENTHISTORY_FAMILYPOS));
      bn.setNationality(rs.getString(
          MasterTable.COL_MASTER_RESIDENTHISTORY_NATIONALITY));
      bn.setAddress(rs.getString(MasterTable.COL_MASTER_RESIDENTHISTORY_ADDRESS));
      bn.setCity(rs.getString(MasterTable.COL_MASTER_RESIDENTHISTORY_CITY));
      bn.setRegion(rs.getString(MasterTable.COL_MASTER_RESIDENTHISTORY_REGION));
      bn.setPostalCode(rs.getString(
          MasterTable.COL_MASTER_RESIDENTHISTORY_POSTALCODE));
      bn.setRT(rs.getString(MasterTable.COL_MASTER_RESIDENTHISTORY_RT));
      bn.SetRW(rs.getString(MasterTable.COL_MASTER_RESIDENTHISTORY_RW));
      bn.setKelurahan(rs.getString(MasterTable.COL_MASTER_RESIDENTHISTORY_KELURAHAN));
      bn.setKecamatan(rs.getString(MasterTable.COL_MASTER_RESIDENTHISTORY_KECAMATAN));
      bn.setEntryDate(Utilities.stringToDate(
          rs.getString(MasterTable.COL_MASTER_RESIDENTHISTORY_ENTRYDATE), 
          MasterConstants.DATE_DB_MEDIUM_PATTERN));
      bn.setEntryUser(rs.getString(MasterTable.COL_MASTER_RESIDENTHISTORY_ENTRYUSER));
    }
    return bn;
  }
  
  public boolean createMasterResidentHistory(MasterResidentHistoryBean ubn)
  {
    System.out.println("ENGINE CREATE NEW RESIDENTHISTORY");
    boolean res = false;
    HttpSession ses = req.getSession(false);
    MasterUserBean uses = (MasterUserBean)ses.getAttribute(
        MasterConstants.MASTERUSER);
    
    try
    {
      SQL = " INSERT INTO " + MasterTable.TABLE_MASTER_RESIDENTHISTORY +
            "(" +
               MasterTable.COL_MASTER_RESIDENTHISTORY_NIK + "," +
               MasterTable.COL_MASTER_RESIDENTHISTORY_STARTDATE + "," +
               MasterTable.COL_MASTER_RESIDENTHISTORY_ENDDATE + "," +
               MasterTable.COL_MASTER_RESIDENTHISTORY_KK + "," +
               MasterTable.COL_MASTER_RESIDENTHISTORY_NAME + "," +
               MasterTable.COL_MASTER_RESIDENTHISTORY_SEX + "," +
               MasterTable.COL_MASTER_RESIDENTHISTORY_RELIGION + "," +
               MasterTable.COL_MASTER_RESIDENTHISTORY_MARITALSTATUS + "," +
               MasterTable.COL_MASTER_RESIDENTHISTORY_FAMILYPOS + "," +
               MasterTable.COL_MASTER_RESIDENTHISTORY_NATIONALITY + "," +
               MasterTable.COL_MASTER_RESIDENTHISTORY_ADDRESS + "," +
               MasterTable.COL_MASTER_RESIDENTHISTORY_CITY + "," +
               MasterTable.COL_MASTER_RESIDENTHISTORY_REGION + "," +
               MasterTable.COL_MASTER_RESIDENTHISTORY_POSTALCODE + "," +
               MasterTable.COL_MASTER_RESIDENTHISTORY_KELURAHAN + "," +
               MasterTable.COL_MASTER_RESIDENTHISTORY_KECAMATAN + "," +
               MasterTable.COL_MASTER_RESIDENTHISTORY_RT + "," +
               MasterTable.COL_MASTER_RESIDENTHISTORY_RW + "," +
               MasterTable.COL_MASTER_RESIDENTHISTORY_ENTRYDATE + "," +
               MasterTable.COL_MASTER_RESIDENTHISTORY_ENTRYUSER +
             ")" +
            " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      
      super.getConnection();
      stat = con.prepareStatement(SQL);
      
      stat.setString(1, ubn.getNIK());
      stat.setString(2, Utilities.dateToString(ubn.getStartDate(), 
          MasterConstants.DATE_DB_SHORT_PATTERN));
      stat.setString(3, Utilities.dateToString(ubn.getEndDate(), 
          MasterConstants.DATE_DB_SHORT_PATTERN));
      stat.setString(4, ubn.getKKNo());
      stat.setString(5, ubn.getName());
      stat.setInt(6, ubn.getSex());
      stat.setString(7, ubn.getReligion());
      stat.setString(8, ubn.getMaritalStatus());
      stat.setString(9, ubn.getFamilyPos());
      stat.setString(10, ubn.getNationality());
      stat.setString(11, ubn.getAddress());
      stat.setString(12, ubn.getCity());
      stat.setString(13, ubn.getRegion());
      stat.setString(14, ubn.getPostalCode());
      stat.setString(15, ubn.getKelurahan());
      stat.setString(16, ubn.getKecamatan());
      stat.setString(17, ubn.getRT());
      stat.setString(18, ubn.getRW());
      stat.setString(19, Utilities.dateToString(new Date(), 
          MasterConstants.DATE_DB_SHORT_PATTERN));
      stat.setString(20, uses.getUser());
      
      if(stat.executeUpdate()>0)
      {
        System.out.println("SUCCEED CREATED RESIDENT HIST");
        return true;
      }
      else return false;
    }
    catch(Exception e)
    {
      e.printStackTrace();
      super.rollback();
      res = false;
      System.out.println("ERR ENGINE CREATE NEW RESIDENTHISTORY "+e.getMessage());
    }
    
    return res;
  }
  
  public boolean delete(String niks, String sDate)
  {
    boolean res = false;
    
    try
    {
      SQL = " DELETE FROM " + MasterTable.TABLE_MASTER_RESIDENTHISTORY +
          " WHERE " +
          MasterTable.COL_MASTER_RESIDENTHISTORY_NIK + "=? " +
          " AND " + MasterTable.COL_MASTER_RESIDENTHISTORY_STARTDATE;
    
    super.getConnection();
    stat = con.prepareStatement(SQL);
    
      stat.setString(1, niks);
      stat.setString(2, niks);
      stat.executeUpdate();
    
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