package com.sync.master.beans;

import com.sync.core.beans.DataPreferenceBean;

/**
 * This class used to hold Level Access Data. 
 * @author SANFON
 */
public class MasterLevelAccessBean extends DataPreferenceBean
{
	private String ID = null;
	private String Name = null;
	private String Note = null;
	
	/** Default Constructor. */
	public MasterLevelAccessBean(){}
	
	/** Get ID. */
	public void setID(String val) { ID = val; }
	/** Set ID. */
	public String getID() { return ID; }
	
	/** Get Name. */
	public void setName(String val) { Name = val; }
	/** Set Name. */
	public String getName() { return Name; }
	
	/** Set Note. */
	public void setNote(String val) { Note = val; }
	/** Get Note. */
	public String getNote() { return Note; }
}
