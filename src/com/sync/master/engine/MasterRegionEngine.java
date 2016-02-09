package com.sync.master.engine;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sync.core.engine.RootEngine;
import com.sync.core.utils.Utilities;
import com.sync.master.beans.MasterRegionBean;
import com.sync.master.beans.MasterRegionKecamatanBean;
import com.sync.master.beans.MasterRegionKelurahanBean;
import com.sync.master.utils.MasterConstants;
import com.sync.master.utils.MasterTable;


public class MasterRegionEngine extends RootEngine
{
  public MasterRegionEngine(){}
  
  public MasterRegionEngine(HttpServletRequest rq, HttpServletResponse rs)
  {
    req=rq;
    res=rs;
  }
  
  /** Getting All Master Region Data */
  public MasterRegionBean[] listOfRegion(String stat)
  {
    MasterRegionBean[] lists = null;
    int row = 0;
    String currPage = req.getParameter(MasterConstants.FORM_CURRENT_PAGE);
    String search = req.getParameter(MasterConstants.FORM_SEARCH_RECORD);
    String limit = req.getParameter(MasterConstants.FORM_LIMIT_RECORD);

    addSQL = " WHERE ";
    
    if(!Utilities.isEmpy(stat) && stat.equals(MasterConstants.DATA_ARCHIEVE))
    {
      addSQL += MasterTable.COL_MASTERREGION_VOIDDATE +
          " IS NOT NULL AND " + MasterTable.COL_MASTERREGION_VOIDUSER +
          " IS NOT NULL ";
    }
    else
    {
      addSQL += MasterTable.COL_MASTERREGION_VOIDDATE +
          " IS NULL AND " + MasterTable.COL_MASTERREGION_VOIDUSER +
          " IS NULL ";
    }
    
    if(!Utilities.isEmpy(search)){
      addSQL += "AND ("+MasterTable.COL_MASTER_RESIDENT_KK+" LIKE '%"+search+"%' OR " +
          MasterTable.COL_MASTER_RESIDENT_NAME+" like '%"+search+"%' OR " +
          MasterTable.COL_MASTER_RESIDENT_NIK+" like '%"+search+"%')";
    }
    
    String pagination = buildPagination(MasterTable.TABLE_MASTERREGION, 
                                        (null==currPage?1:Integer.parseInt(currPage)), 
                                        (null==limit?MasterConstants.DEFAULT_LIMIT_RECORD:Integer.parseInt(limit)));
    req.setAttribute(MasterConstants.HTML_PAGINATION, pagination);
    
    SQL = " SELECT " +
          MasterTable.TABLE_MASTERREGION + ".* " +
          " FROM " + MasterTable.TABLE_MASTERREGION  +
          " ORDER BY " + MasterTable.COL_MASTERREGION_REGIONID;
        
    try
    {
      super.getConnection();
      rs =  super.executeQuery(SQL);
      row = super.getTotalRow();
      
      if(row<=0) return null;
      
      lists = new MasterRegionBean[row];
      if(null!=rs)
      {
        for(int i=0; i<row; i++)
        {
          lists[i] = this.nextRegion();
        }
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    
    return lists;
  }
  
  /** Getting next region data */
  public MasterRegionBean nextRegion() throws SQLException
  {
    MasterRegionBean bn = null;
    if(rs.next())
    {
      bn = new MasterRegionBean();
      bn.setRegionID(rs.getString(MasterTable.COL_MASTERREGION_REGIONID));
      bn.setRegionName(rs.getString(MasterTable.COL_MASTERREGION_NAME));
      bn.setStateProv(rs.getString(MasterTable.COL_MASTERREGION_STATEPROV));
      bn.setNote(rs.getString(MasterTable.COL_MASTERREGION_NOTE));
      bn.setCreateDate(Utilities.stringToDate(
          rs.getString(MasterTable.COL_MASTERREGION_CREATEDATE), 
          MasterConstants.DATE_DB_MEDIUM_PATTERN));
      bn.setCreateUser(rs.getString(MasterTable.COL_MASTERREGION_CREATEUSER));
      bn.setEntryDate(Utilities.stringToDate(
          rs.getString(MasterTable.COL_MASTERREGION_ENTRYDATE), 
          MasterConstants.DATE_DB_MEDIUM_PATTERN));
      bn.setEntryUser(rs.getString(MasterTable.COL_MASTERREGION_ENTRYUSER));
    }
    return bn;
  }
  
  /** Getting next Kecamatan data */
  public MasterRegionKecamatanBean nextKecamatan() throws SQLException
  {
    MasterRegionKecamatanBean bn = null;
    if(rs.next())
    {
      bn = new MasterRegionKecamatanBean();
      bn.setRegionID(rs.getString(
          MasterTable.COl_MASTER_REGION_KEC_REGIONID));
      bn.setKecamatanID(rs.getString(
          MasterTable.COl_MASTER_REGION_KEC_KECAMATANID));
      bn.setName(rs.getString(
          MasterTable.COl_MASTER_REGION_KEC_NAME));
      bn.setNote(rs.getString(
          MasterTable.COl_MASTER_REGION_KEC_NOTE));
      
    }
    return bn;
  }
  
  /** Getting next Kelurahan data */
  public MasterRegionKelurahanBean nextKelurahan() throws SQLException
  {
    MasterRegionKelurahanBean bn = null;
    if(rs.next())
    {
      bn = new MasterRegionKelurahanBean();
      bn.setRegionID(rs.getString(
          MasterTable.COL_MASTER_REGION_KEL_REGIONID));
      bn.setKecamatanID(rs.getString(
          MasterTable.COL_MASTER_REGION_KEL_KECAMATANID));
      bn.setKelurahanID(rs.getString(
          MasterTable.COL_MASTER_REGION_KEL_KELURAHANID));
      bn.setName(rs.getString(
          MasterTable.COL_MASTER_REGION_KEL_NAME));
      bn.setNote(rs.getString(
          MasterTable.COL_MASTER_REGION_KEL_NOTE));
      
    }
    return bn;
  }
  
  /** Getting Region info only */
  public MasterRegionBean getRegionInfo(String regID)
  {
    MasterRegionBean ubn = null;
    
    SQL = " SELECT " +
          MasterTable.TABLE_MASTERREGION + ".* " +
          " FROM " +
          MasterTable.TABLE_MASTERREGION + 
          " WHERE " +
          MasterTable.COL_MASTERREGION_REGIONID + "='" + regID + "';";
    
    try
    {
      super.getConnection();
      rs = super.executeQuery(SQL);
      
      if(null!=rs)
      {
        ubn = new MasterRegionBean();
        ubn = this.nextRegion();
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
      ubn = null;
    }
    
    return ubn;
  }
  
  /** Getting Kecamatan Info */
  public MasterRegionKecamatanBean[] getKecamatanInfo(String regID)
  {
    MasterRegionKecamatanBean[] ubn = null;
    
    SQL = " SELECT " +
          MasterTable.TABLE_MASTER_REGION_KEC + ".* " +
          " FROM " +
          MasterTable.TABLE_MASTER_REGION_KEC + 
          " WHERE " +
          MasterTable.COl_MASTER_REGION_KEC_REGIONID + "='" + regID + "';";
    
    try
    {
      super.getConnection();
      rs = super.executeQuery(SQL);
      int row = super.getTotalRow();
      
      ubn = new MasterRegionKecamatanBean[row];
      for(int i=0; i<row; i++)
      {
        ubn[i] = this.nextKecamatan();
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
      ubn = null;
    }
    
    return ubn;
  }
  
  /** Getting Kelurahan Info */
  public MasterRegionKelurahanBean[] getKelurahanInfo(String regID)
  {
    return this.getKelurahanInfo(regID, null);
  }
  
  /** Getting Kelurahan Info */
  public MasterRegionKelurahanBean[] getKelurahanInfo(String regID, String KecamatanID)
  {
    MasterRegionKelurahanBean[] ubn = null;
    
    SQL = " SELECT " +
          MasterTable.TABLE_MASTER_REGION_KEL + ".* " +
          " FROM " +
          MasterTable.TABLE_MASTER_REGION_KEL + 
          " WHERE " +
          MasterTable.COL_MASTER_REGION_KEL_REGIONID + "='" + regID + "'";
    
    if(!Utilities.isEmpy(KecamatanID))
    {
      SQL += " AND " + MasterTable.COL_MASTER_REGION_KEL_KECAMATANID + "='" +
             KecamatanID + "'";
    }
    
    try
    {
      super.getConnection();
      rs = super.executeQuery(SQL);
      int row = super.getTotalRow();
      
      ubn = new MasterRegionKelurahanBean[row];
      for(int i=0; i<row; i++)
      {
        ubn[i] = this.nextKelurahan();
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
      ubn = null;
    }
    
    return ubn;
  }
  
  /** Getting Master Region Info and all details */
  public MasterRegionBean getMasterRegionInfo(String regID)
  {
    MasterRegionBean bn = null;
    
    try
    {
      bn = this.getRegionInfo(regID);
      if(null!=bn)
      {
        bn.setKecamatanInfo(this.getKecamatanInfo(regID));
        if(null!=bn.getKecamatanInfo() && bn.getKecamatanInfo().length>0)
        {
          for(int i=0; i<bn.getKecamatanInfo().length; i++)
          {
            bn.getKecamatanInfo()[i].setKelurahanInfo(
                this.getKelurahanInfo(regID, 
                                    bn.getKecamatanInfo()[i].getKecamatanID()));
          }
        }
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
      bn = null;
    }
    
    return bn;
  }
  
  
  public void closed()
  {
    super.finalize();
  }
  
}