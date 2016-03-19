package com.sync.master.pool;

import java.util.ArrayList;
import java.util.Arrays;

import com.sync.core.beans.GalleryBean;
import com.sync.core.pool.GalleryPool;
import com.sync.master.beans.LevelAccessBean;
import com.sync.master.engine.LevelAccessEngine;

public class LevelAccessPool 
{
	private static LevelAccessPool p = new LevelAccessPool();
	private ArrayList<LevelAccessBean> collections;
	private static final Object lock = new Object();
	
	/** Constructor*/
	private LevelAccessPool()
	{ collections = new ArrayList<LevelAccessBean>();}
	
	public static synchronized LevelAccessPool getInstance()
	{
		if(null==p)
		{
			synchronized(lock)
      { if(null==p) p = new LevelAccessPool(); }
		}
		
		return p;
	}
	
	public void put(LevelAccessBean val)
  { synchronized(lock) { collections.add(val); } }
	
	public void Renew(ArrayList<LevelAccessBean> val)
	{ collections.clear(); collections = val;}
	
	public boolean reload()
  {
		synchronized(lock)
    {
			LevelAccessEngine lp = new LevelAccessEngine();
			boolean res = false;
			LevelAccessBean[] details = null;
			
			try
      {
				LevelAccessBean bn = lp.list();
				if(null!=bn && null!=bn.getDetails()) 
				{
					collections.clear();
					details = bn.getDetails();
					collections = new ArrayList<LevelAccessBean>(Arrays.asList(details));
					
					res = true;
				}
				else throw new Exception("Level Access Pool gagal di isi");
      }
			catch (Exception e)
      {
        System.out.println("Level Access Pool gagal di isi");
        e.printStackTrace();
        res = false;
      }
			
			return res;
    }
  }
	
	public ArrayList<LevelAccessBean> getAll()
	{ return collections; }
	
	public boolean checkValidate(String LevelID, String MenuID, String Permission)
	{
		boolean result = false;
		for (int i = 0; i < collections.size(); i++) 
		{
			System.out.println("CHK VALIDATE LEVELID: " + collections.get(i).getLevelID());
			System.out.println("CHK VALIDATE MENUID: " + collections.get(i).getMenuID());
			System.out.println("CHK VALIDATE PERMISSION: " + collections.get(i).getPermission());
			if(
					collections.get(i).getLevelID().equals(LevelID) &
					collections.get(i).getMenuID().equals(MenuID) &
					collections.get(i).getPermission().equals(Permission)
				)
			{
				result = true;
				break;
			}
		}
		
		return result;
	}
}
