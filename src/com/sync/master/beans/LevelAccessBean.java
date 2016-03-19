package com.sync.master.beans;

import java.util.HashMap;

import com.sync.core.beans.DataPreferenceBean;

public class LevelAccessBean extends DataPreferenceBean 
{
	public static final String PERMIT_LIST = "pL";
	public static final String PERMIT_INFO = "pI";
	public static final String PERMIT_CREATE = "pC";
	public static final String PERMIT_UPDATE = "pU";
	public static final String PERMIT_DELETE = "pD";
	
	private String LevelID = null;
	private String ModulID = null;
	private String MenuID = null;
	private String Permission = null;

	private HashMap<String, LevelAccessBean[]> dataAccess = null;
	private HashMap<String, String[]> dataPermission = null;
	private LevelAccessBean[] details = null;
	
	/** Constructor. */
	public LevelAccessBean(){}
	
	/** Set LevelID*/
	public void setLevelID(String val) { LevelID = val; }
	/** Get LevelID*/
	public String getLevelID() { return LevelID;}
	
	/** Set ModulID*/
	public void setModulID(String val) { ModulID = val; }
	/** Get ModulID*/
	public String getModulID() { return ModulID;}
	
	/** Set Menu*/
	public void setMenuID(String val) { MenuID= val; }
	/** Get Menu*/
	public String getMenuID() { return MenuID;}
	
	/** Set Permission*/
	public void setPermission(String val) { Permission = val; }
	/** Get Permission*/
	public String getPermission() { return Permission;}
	
	public void setDataAccess(HashMap<String, LevelAccessBean[]> val) { dataAccess = val; }
	public HashMap<String, LevelAccessBean[]> getDataAccess(){ return dataAccess; }
	
	public void setDataPermission(HashMap<String, String[]> val) { dataPermission = val; }
	public HashMap<String, String[]> getDataPermission(){ return dataPermission; }
	
	public void setDetails(LevelAccessBean[] val) { details = val; }
	public LevelAccessBean[] getDetails() { return details; }
}
