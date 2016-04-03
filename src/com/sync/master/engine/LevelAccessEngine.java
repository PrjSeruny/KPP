package com.sync.master.engine;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sync.core.engine.RootEngine;
import com.sync.core.utils.Constants;
import com.sync.core.utils.Utilities;
import com.sync.master.beans.LevelAccessBean;
import com.sync.master.pool.LevelAccessPool;
import com.sync.master.utils.MasterConstants;
import com.sync.master.utils.MasterTable;
import com.sync.report.utils.ReportConstants;
import com.sync.trans.utils.TransConstants;

public class LevelAccessEngine extends RootEngine 
{
	LevelAccessPool lap = LevelAccessPool.getInstance();
	
	/** Default Constructor. */
	public LevelAccessEngine(){}
	
	/** Constructor dengan Request dan Response dari user */
	public LevelAccessEngine(HttpServletRequest rq, HttpServletResponse rs)
	{ 
		req=rq;
    res=rs;
	}
	
	public LevelAccessBean list()
	{
		int row = 0;
		LevelAccessBean bn = new LevelAccessBean();
		LevelAccessBean[] details;
		
		SQL = "SELECT * FROM " + MasterTable.TABLE_LEVEL_ACCESS +
				" ORDER BY " + MasterTable.COL_LEVELACCESS_LEVELID +
				", " + MasterTable.COL_LEVELACCESS_MENUID;
		
		try
		{
			super.getConnection();
			rs = super.executeQuery(SQL);
			row = super.getTotalRow();
			
			if(row <= 0) return null;
			details = new LevelAccessBean[row];
			if(null!=rs)
			{
				for (int i = 0; i < details.length; i++) {
					details[i] = this.next();
				}
			}
			
			bn.setDetails(details);
		}
		catch(Exception e)
		{ e.printStackTrace();}
		
		return bn;
	}
	
	public LevelAccessBean next() throws SQLException
	{
		LevelAccessBean bn = null;
		if(null!=rs & rs.next())
		{
			bn = new LevelAccessBean();
			bn.setLevelID(rs.getString(MasterTable.COL_LEVELACCESS_LEVELID));
			bn.setMenuID(rs.getString(MasterTable.COL_LEVELACCESS_MENUID));
			bn.setPermission(rs.getString(MasterTable.COL_LEVELACCESS_PERMISSION));
		}
		
		return bn;
	}
	
	public LevelAccessBean validateEntry()
	{
		HashMap<String, String[]> Permission =
				new HashMap<String, String[]>();
		String tmp = null;
		LevelAccessBean bn = new LevelAccessBean();
		
		/** get Level ID. */
		tmp = req.getParameter(MasterConstants.FORM_MASTERUSER_LEVEL);
		if(!Utilities.isEmpy(tmp))
		{ bn.setLevelID(tmp);}
		
		//Validate Public Setting 
		Permission = this.validatePublicSetting(bn, Permission);
		//Validate Master
		Permission = this.validateMaster(bn, Permission);
		//Validate Master
		Permission = this.validateTransaction(bn, Permission);
	  //Validate Report
		Permission = this.validateReport(bn, Permission);
		
		bn.setDataPermission(Permission);
		
		return bn;
	}
	
	public HashMap<String, String[]> validatePublicSetting(LevelAccessBean bn, HashMap<String, String[]> Permission)
	{
		/** Object. */
		String[] tmpPermission = null;
		
		//Slide Setting Permission
		tmpPermission = req.getParameterValues(Constants.SLIDE_SETTING_PRM);
		if(null!=tmpPermission && tmpPermission.length > 0)
		{
			Permission.put(Constants.SLIDE_SETTING_PRM, tmpPermission);
		}
		
		//Gallery Setting Permission
		tmpPermission = req.getParameterValues(Constants.GALLERY_SETTING_PRM);
		if(null!=tmpPermission && tmpPermission.length > 0)
		{
			Permission.put(Constants.GALLERY_SETTING_PRM, tmpPermission);
		}
		
		//News Setting Permission
		tmpPermission = req.getParameterValues(Constants.NEWS_SETTING_PRM);
		if(null!=tmpPermission && tmpPermission.length > 0)
		{
			Permission.put(Constants.NEWS_SETTING_PRM, tmpPermission);
		}
		
		//News Setting Permission
		tmpPermission = req.getParameterValues(Constants.COMPANY_SETTING_PRM);
		if(null!=tmpPermission && tmpPermission.length > 0)
		{
			Permission.put(Constants.COMPANY_SETTING_PRM, tmpPermission);
		}
			
		//News Setting Permission
		tmpPermission = req.getParameterValues(Constants.PROFILE_SETTING_PRM);
		if(null!=tmpPermission && tmpPermission.length > 0)
		{
			Permission.put(Constants.PROFILE_SETTING_PRM, tmpPermission);
		}
		
		return Permission;
	}
	
	public HashMap<String, String[]> validateMaster(LevelAccessBean bn, HashMap<String, String[]> Permission)
	{
		/** Object. */
		String[] tmpPermission = null;
		
		//Master User Permission
		tmpPermission = req.getParameterValues(MasterConstants.MASTERUSER);
		if(null!=tmpPermission && tmpPermission.length > 0)
		{
			Permission.put(MasterConstants.MASTERUSER, tmpPermission);
		}
		
		//Master Region Permission
		tmpPermission = req.getParameterValues(MasterConstants.MASTER_REGION);
		if(null!=tmpPermission && tmpPermission.length > 0)
		{
			Permission.put(MasterConstants.MASTER_REGION, tmpPermission);
		}
		
		//master Resident Permission
		tmpPermission = req.getParameterValues(MasterConstants.MASTER_RESIDENT);
		if(null!=tmpPermission && tmpPermission.length > 0)
		{
			Permission.put(MasterConstants.MASTER_RESIDENT, tmpPermission);
		}
		
		//master Resident Permission
		tmpPermission = req.getParameterValues(MasterConstants.MASTER_LEVEL_ACCESS);
		if(null!=tmpPermission && tmpPermission.length > 0)
		{
			Permission.put(MasterConstants.MASTER_LEVEL_ACCESS, tmpPermission);
		}
			
		//master Resident Permission
		tmpPermission = req.getParameterValues(MasterConstants.LEVELACCESS);
		if(null!=tmpPermission && tmpPermission.length > 0)
		{
			Permission.put(MasterConstants.LEVELACCESS, tmpPermission);
		}
		
		return Permission;
	}
	
	public HashMap<String, String[]> validateTransaction(LevelAccessBean bn, HashMap<String, String[]> Permission)
	{
		/** Object. */
		String[] tmpPermission = null;
		
		//Master User Permission
		tmpPermission = req.getParameterValues(TransConstants.TRANS_FAMILYCARDMUT);
		if(null!=tmpPermission && tmpPermission.length > 0)
		{
			Permission.put(TransConstants.TRANS_FAMILYCARDMUT, tmpPermission);
		}
		
		//Master User Permission
		tmpPermission = req.getParameterValues(TransConstants.TRANS_BIRTHLETTER);
		if(null!=tmpPermission && tmpPermission.length > 0)
		{
			Permission.put(TransConstants.TRANS_BIRTHLETTER, tmpPermission);
		}
		
		//Master User Permission
		tmpPermission = req.getParameterValues(TransConstants.TRANS_DEATHLETTER);
		if(null!=tmpPermission && tmpPermission.length > 0)
		{
			Permission.put(TransConstants.TRANS_DEATHLETTER, tmpPermission);
		}
		
		return Permission;
	}
	
	public HashMap<String, String[]> validateReport(LevelAccessBean bn, HashMap<String, String[]> Permission)
	{
	  String[] tmpPermission = null;

    tmpPermission = req.getParameterValues(ReportConstants.REPORT_RESIDENTANALYSIS);
    if(null!=tmpPermission && tmpPermission.length > 0)
    {
      Permission.put(ReportConstants.REPORT_RESIDENTANALYSIS, tmpPermission);
    }
    
		return Permission;
	}
	
	
	public boolean insertLevelAccess(LevelAccessBean bn)
	{
		boolean res = false;
		
		ArrayList<LevelAccessBean> listsP = 
				new ArrayList<LevelAccessBean>();
		
		try
		{
			listsP = this.Convert(bn);
			if(null!=listsP)
			{
				for (int i = 0; i < listsP.size(); i++) {
					res = this.insert(listsP.get(i));
					if(!res) throw new Exception("ERROR INSERTING ACCESS PERMISSION");
				}
			}
		}
		catch(Exception e)
		{e.printStackTrace();super.rollback();res=false;}
		
		return res;
	}
	
	public boolean insert(LevelAccessBean bn)
	{
		boolean res = false;
		try
		{
			SQL = "INSERT INTO " + MasterTable.TABLE_LEVEL_ACCESS +
					"(" +
					MasterTable.COL_LEVELACCESS_LEVELID + ", " +
					MasterTable.COL_LEVELACCESS_MENUID + ", " +
					MasterTable.COL_LEVELACCESS_PERMISSION + 
					")" +
					"VALUES (?,?,?) ON DUPLICATE KEY UPDATE " +
					MasterTable.COL_LEVELACCESS_LEVELID + "=?, " +
					MasterTable.COL_LEVELACCESS_MENUID + "=?, " +
					MasterTable.COL_LEVELACCESS_PERMISSION + "=?;";
			
			super.getConnection();
			stat = con.prepareStatement(SQL);
			stat.setString(1, bn.getLevelID());
			stat.setString(2, bn.getMenuID());
			stat.setString(3, bn.getPermission());
			stat.setString(4, bn.getLevelID());
			stat.setString(5, bn.getMenuID());
			stat.setString(6, bn.getPermission());
			System.out.println("QUERY INSERT UPDATE : " + stat.toString());
			
			if(stat.executeUpdate() > 0) return true;
			else return false;
		}
		catch(Exception e)
		{
			e.printStackTrace();super.rollback();
			res = false;
		}
		
		return res;
	}
	
	private ArrayList<LevelAccessBean> Convert(LevelAccessBean bn)
	{
		ArrayList<LevelAccessBean> listP = 
				new ArrayList<LevelAccessBean>();
		LevelAccessBean tmp = null;
		HashMap<String, String[]> tmpPms = 
				new HashMap<String, String[]>();
		
		//Check bn
		if(null==bn) return null;
		
		//get permission data
		tmpPms = bn.getDataPermission();
		if(null!=tmpPms)
		{
			for (Map.Entry<String, String[]> entry : tmpPms.entrySet()) 
			{
				String key = entry.getKey();
		    String[] value = entry.getValue();
		    for (int i = 0; i < value.length; i++) {
		    	tmp = new LevelAccessBean();
					tmp.setLevelID(bn.getLevelID());
					tmp.setMenuID(key);
					tmp.setPermission(value[i]);
					
					listP.add(tmp);
				}
			}
		}
		
		return listP;
	}
	
  public void closed()
  {
    super.finalize();
    //if all success, renew pool
		lap.reload();
		if(null!=lap) lap = null;
  }
}
