package com.sync.report.engine;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sync.core.beans.MessageBean;
import com.sync.core.engine.RootEngine;
import com.sync.core.utils.Utilities;
import com.sync.master.utils.MasterConstants;
import com.sync.master.utils.MasterTable;
import com.sync.report.beans.ResidentAnalysisBean;
import com.sync.report.beans.ResidentAnalysisDetailsBean;
import com.sync.report.utils.ReportConstants;


public class ResidentAnalysisEngine extends RootEngine
{
  
  public ResidentAnalysisEngine(){}
  
  public ResidentAnalysisEngine(HttpServletRequest rq, HttpServletResponse rs)
  {
    req=rq;
    res=rs;
  }
  
  public ResidentAnalysisBean validate()
  {
    ResidentAnalysisBean bn = new ResidentAnalysisBean();
    MessageBean msg = new MessageBean();
    String temp = "";
    
    bn.setBeanMessages(msg);
    temp = req.getParameter(ReportConstants.FORM_RESIDENTANALYSIS_SEARCH);
    System.out.println(">>>>>>>>>>>>>>>> SEARCH= "+temp);
    if(Utilities.isEmpy(temp))
    {
      msg.setMessageBean(ReportConstants.FORM_RESIDENTANALYSIS_SEARCH, 
          "Pilih Tipe Pencarian");
    }
    else
    {
      bn.setWhatToSearch(temp);
    }
    
    temp = req.getParameter(ReportConstants.FORM_RESIDENTANALYSIS_CITY);
    System.out.println(">>>>>>>>>>>>>>>> CITY= "+temp);
    if(!Utilities.isEmpy(temp))
    {
      bn.setCitys(temp.split(ReportConstants.DELIMITER_SEMICOLON));
    }
    
    temp = req.getParameter(ReportConstants.FORM_RESIDENTANALYSIS_KEC);
    System.out.println(">>>>>>>>>>>>>>>> KEC= "+temp);
    if(!Utilities.isEmpy(temp))
    {
      bn.setKecVal(temp.split(ReportConstants.DELIMITER_SEMICOLON));
    }
    
    temp = req.getParameter(ReportConstants.FORM_RESIDENTANALYSIS_KEL);
    System.out.println(">>>>>>>>>>>>>>>> KEL= "+temp);
    if(!Utilities.isEmpy(temp))
    {
      bn.setKelVal(temp.split(ReportConstants.DELIMITER_SEMICOLON));
    }
    
    temp = req.getParameter(ReportConstants.FORM_RESIDENTANALYSIS_GROUPBY);
    if(!Utilities.isEmpy(temp))
    {
      bn.setGroupBy(temp);
    }
    
    return bn;
  }
  
  
  public ResidentAnalysisBean search(ResidentAnalysisBean bn)
  {
    if(bn.getWhatToSearch().equals(
        ReportConstants.FORM_RESIDENTANALYSIS_SEARCH_DETAILS))
    {
      bn = this.searchDetails(bn);
    }
    else
    {
      bn = this.searchRecap(bn);
    }
    
    return bn;
  }
  
  private ResidentAnalysisBean searchDetails(ResidentAnalysisBean bn)
  {
    String city = "", nik="", kec="", kel="";
    int row = 0;
    
    try
    {
      SQL = " SELECT " +
            MasterTable.TABLE_MASTER_RESIDENT + ".* " +
            " FROM " +
            MasterTable.TABLE_MASTER_RESIDENT;
      
      if(
          (null!=bn.getCitys()&&bn.getCitys().length>0) ||
          (null!=bn.getNIKs()&&bn.getNIKs().length>0) ||
          (null!=bn.getKecVal()&&bn.getKecVal().length>0) ||
          (null!=bn.getKelVal()&&bn.getKelVal().length>0)
        )
      {
        SQL += " WHERE ";
      }
      
      if(null !=bn.getCitys() && bn.getCitys().length>0)
      {
        city = Utilities.joinForSQL(",", bn.getCitys());
        SQL += MasterTable.COL_MASTER_RESIDENT_CITY + " IN(" + city + ")";
      }
      
      if(null!=bn.getNIKs()&&bn.getNIKs().length>0)
      {
        if(!Utilities.isEmpy(city)) SQL += " AND ";
        nik = Utilities.joinForSQL(",", bn.getNIKs());
        SQL += MasterTable.COL_MASTER_RESIDENT_NIK + " IN(" + nik + ")";
      }
      
      if(null!=bn.getKecVal()&&bn.getKecVal().length>0)
      {
        if(!Utilities.isEmpy(city)||!Utilities.isEmpy(nik)) SQL += " AND ";
        kec = Utilities.joinForSQL(",", bn.getKecVal());
        SQL += MasterTable.COL_MASTER_RESIDENT_KECAMATAN + " IN(" + kec + ")";
      }
      
      if(null!=bn.getKelVal()&&bn.getKelVal().length>0)
      {
        if(!Utilities.isEmpy(city)||!Utilities.isEmpy(nik)||
            !Utilities.isEmpy(kec))
        {
          SQL += " AND ";
        }
        
        kel = Utilities.joinForSQL(",", bn.getKelVal());
        SQL += MasterTable.COL_MASTER_RESIDENT_KELURAHAN + " IN(" + kel + ")";
      }
      
      if(!Utilities.isEmpy(bn.getGroupBy()))
      {
        SQL += " ORDER BY ";
        
        if(bn.getGroupBy().equals(ReportConstants.FORM_RESIDENTANALYSIS_GROUPBY_CITY))
        {
          SQL += MasterTable.COL_MASTER_RESIDENT_CITY;
        }
        else if(bn.getGroupBy().equals(ReportConstants.FORM_RESIDENTANALYSIS_GROUPBY_KEC))
        {
          SQL += MasterTable.COL_MASTER_RESIDENT_KECAMATAN;
        }
        else
        {
          SQL += MasterTable.COL_MASTER_RESIDENT_KELURAHAN;
        }
      }
      System.out.println(">>>>>>>>>>>>>> SQL="+SQL);
      
      super.getConnection();
      rs = super.executeQuery(SQL);
      row = super.getTotalRow();
      System.out.println(">>>>>>>>>>>>>> ROW="+row);
      ResidentAnalysisDetailsBean[] det = new ResidentAnalysisDetailsBean[row];
      if(null!=rs)
      {
        for(int i=0; i<row; i++)
        {
          det[i] = new ResidentAnalysisDetailsBean();
          det[i] = this.next();
        }
      }
      
      bn.setDetails(det);
    }
    catch(Exception e)
    {
      e.printStackTrace();
      bn.setDetails(null);
    }
    
    return bn;
  }
  
  private ResidentAnalysisBean searchRecap(ResidentAnalysisBean bn)
  {
    return bn;
  }
  
  
  public ResidentAnalysisDetailsBean next() throws SQLException
  {
    ResidentAnalysisDetailsBean bn = null;
    if(rs.next())
    {
      bn = new ResidentAnalysisDetailsBean();
      bn.setNIK(rs.getString(MasterTable.COL_MASTER_RESIDENT_NIK));
      bn.setKKNo(rs.getString(MasterTable.COL_MASTER_RESIDENT_KK));
      bn.setName(rs.getString(MasterTable.COL_MASTER_RESIDENT_NAME));
      bn.setBirthCity(rs.getString(MasterTable.COL_MASTER_RESIDENT_BIRTHCITY));
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
      bn.setFamilyPos(rs.getString(MasterTable.COL_MASTER_RESIDENT_FAMILYPOS));
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
      bn.setEmail(rs.getString(MasterTable.COL_MASTER_RESIDENT_EMAIL));
      bn.setPhoneNo(rs.getString(MasterTable.COL_MASTER_RESIDENT_PHONENO));
      bn.setMobileNo(rs.getString(MasterTable.COL_MASTER_RESIDENT_MOBILENO));
    }
    return bn;
  }
  
  public void closed()
  {
    super.finalize();
  }
}