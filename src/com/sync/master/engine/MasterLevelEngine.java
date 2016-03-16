package com.sync.master.engine;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sync.core.beans.MessageBean;
import com.sync.core.engine.RootEngine;
import com.sync.core.utils.Utilities;
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
	
	/** validate user input. */
	public MasterLevelAccessBean validate()
	{
		MessageBean msg = new MessageBean();
		MasterLevelAccessBean bn = new MasterLevelAccessBean();
		bn.setMessageBean(msg);
		String tmp = null;
		
		//Get Level ID
		tmp = req.getParameter(MasterConstants.FORM_MASTERUSERLEVELACCESS_LEVELID);
		if(!Utilities.isEmpy(tmp))
		{
			if(tmp.indexOf(" ")>=0)
			{
        msg.setMessageBean(MasterConstants.FORM_MASTERUSERLEVELACCESS_LEVELID, 
        "Tidak boleh memakai spasi");
      }
			bn.setID(tmp);
		}
		else
		{
			msg.setMessageBean(MasterConstants.FORM_MASTERUSERLEVELACCESS_LEVELID, 
	        "Masukkan Level ID");
		}
		
		//get Name
		tmp = req.getParameter(MasterConstants.FORM_MASTERUSERLEVELACCESS_NAME);
		if(!Utilities.isEmpy(tmp))
		{ bn.setName(tmp); }
		else
		{
			msg.setMessageBean(MasterConstants.FORM_MASTERUSERLEVELACCESS_NAME, 
	        "Masukkan Level ID");
		}
		
		//get Name
		tmp = req.getParameter(MasterConstants.FORM_MASTERUSERLEVELACCESS_NOTE);
		if(!Utilities.isEmpy(tmp))
		{ bn.setNote(tmp); }
		
		return bn;
	}
	
	/** Inserting to DB. */
	public boolean insert(MasterLevelAccessBean bn)
	{
		boolean res = false;
		try
		{
			SQL = "INSERT INTO " + MasterTable.TABLE_MASTER_LEVEL +
					"(" +
					MasterTable.COL_MASTER_LEVEL_LEVELID + ", " +
					MasterTable.COL_MASTER_LEVEL_LEVEL_NAME + ", " +
					MasterTable.COL_MASTER_LEVEL_LEVEL_NOTE +
					") VALUES (?,?,?)";
			
			super.getConnection();
			stat = con.prepareStatement(SQL);
			stat.setString(1, bn.getID());
			stat.setString(2, bn.getName());
			stat.setString(3, bn.getNote());
			System.out.println("QUERY UPDATE MASTER LEVEL: " + stat.toString());
			if(stat.executeUpdate() > 0) return true;
			else return false;
		}
		catch(Exception e)
		{e.printStackTrace();super.rollback(); res = false;}
		
		return res;
	}
	
	/** Update data in DB. */
	public boolean update(MasterLevelAccessBean bn)
	{
		boolean res = false;
		try
		{
			SQL = "UPDATE " + MasterTable.TABLE_MASTER_LEVEL + 
					" SET " +
					MasterTable.COL_MASTER_LEVEL_LEVEL_NAME + "=?, " +
					MasterTable.COL_MASTER_LEVEL_LEVEL_NOTE + "=? " +
					" WHERE " +
					MasterTable.COL_MASTER_LEVEL_LEVELID + "=?;";
			
			super.getConnection();
			stat = con.prepareStatement(SQL);
			stat.setString(1, bn.getName());
			stat.setString(2, bn.getNote());
			stat.setString(3, bn.getID());
			
			if(stat.executeUpdate() > 0) return true;
			else return false;
		}
		catch(Exception e)
		{e.printStackTrace();super.rollback();res=false;}
		
		return res;
	}
	
  public void closed()
  {
    super.finalize();
  }
}
