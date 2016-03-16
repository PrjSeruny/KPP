package com.sync.master.engine;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sync.core.engine.RootEngine;
import com.sync.master.beans.MasterLevelAccessBean;
import com.sync.master.utils.MasterConstants;
import com.sync.master.utils.MasterTable;

public class MasterLevelEngine extends RootEngine 
{
	/** Default Constructor. */
	public MasterLevelEngine(){}
	
	/** Constructor with request. */
	public MasterLevelEngine(HttpServletRequest req, HttpServletResponse res)
	{
		this.req = req;
		this.res = res;
	}
	
	/** get Master level. */
	public MasterLevelAccessBean[] listOfAccess()
	{
		int row = 0;
		MasterLevelAccessBean[] lists = null;
		SQL = "SELECT * FROM " + MasterTable.TABLE_MASTER_LEVEL;
		System.out.println("TESSSSSSSSSSSSSSSSSSSSSSST 1");
		try
		{
			super.getConnection();
			rs = super.executeQuery(SQL);
			row = super.getTotalRow();
			//Check if found result
			if(row<=0) return null;
			lists = new MasterLevelAccessBean[row];
			if(null!=rs)
			{
				for (int i = 0; i < lists.length; i++) 
				{
					lists[i] = this.next();
				}
			} else {System.out.println("RS IS NUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUULLLLLLLLLLL"); }
		}
		catch(Exception e)
		{
			System.out.println("SOMETHING ERROR COK: " + e.getMessage());
			e.printStackTrace();
		}
		
		return lists;
	}
	
	/** Getting Region info only */
  public MasterLevelAccessBean getAccessInfo(String levelID)
  {
  	MasterLevelAccessBean ubn = null;
    
    SQL = " SELECT " +
          MasterTable.TABLE_MASTER_LEVEL + ".* " +
          " FROM " +
          MasterTable.TABLE_MASTER_LEVEL + 
          " WHERE " +
          MasterTable.COL_MASTER_LEVEL_LEVELID + "='" + levelID + "';";
    
    try
    {
      super.getConnection();
      rs = super.executeQuery(SQL);
      
      if(null!=rs)
      {
        ubn = new MasterLevelAccessBean();
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
	
	/** get Next data. */
	public MasterLevelAccessBean next() throws SQLException
	{
		MasterLevelAccessBean bn = null;
		if(null!=rs & rs.next())
		{
			bn = new MasterLevelAccessBean();
			bn.setID(rs.getString(MasterTable.COL_MASTER_LEVEL_LEVELID));
			bn.setName(rs.getString(MasterTable.COL_MASTER_LEVEL_LEVEL_NAME));
			bn.setNote(rs.getString(MasterTable.COL_MASTER_LEVEL_LEVEL_NOTE));
		}else{System.out.println("RS NEEEEEEEEEEEEEEXT IS NULL");}
		
		return bn;
	}
	
  public void closed()
  {
    super.finalize();
  }
}
