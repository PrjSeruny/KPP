package com.sync.core.pool;

import java.util.TreeMap;

import com.sync.core.beans.CompanyBean;
import com.sync.core.engine.CompanyEngine;

public class CompanyPool {
  private static CompanyPool p = new CompanyPool();
  private TreeMap<String, CompanyBean> collections;
  private static final Object lock = new Object();
  
  /**
   * Constructor.
   */
  private CompanyPool()
  { collections = new TreeMap<String, CompanyBean>(); }

  /**
   * Get this instance of the modules pool.
   */
  public static synchronized CompanyPool getInstance()
  {
    if(null==p)
    {
      synchronized(lock)
      { if(null==p) p = new CompanyPool(); }
    }

    return p;
  }
  
  public void put(String key, CompanyBean val)
  { synchronized(lock) { collections.put(key, val); } }

  public CompanyBean get(String key) { return collections.get(key); }

  public void remove(String key) 
  { synchronized(lock) { collections.remove(key); } }
  
  public boolean reload()
  {
    synchronized(lock)
    {
      CompanyEngine ce = new CompanyEngine();
      boolean res = false;
      
      try
      {
        CompanyBean[] list = ce.getAllCompanySetting();
        if(null!=list)
        {
          //Clear the old pool first
          collections.clear();
          
          //Relist the result.      
          for(int l=0; l<list.length; l++)
          { this.put(list[l].getParam(), list[l]); }
          
          res = true;

          System.out.println("Company pool berhasil di isi");
        }
      }
      catch (Exception e)
      {
        System.out.println("Company pool gagal di isi");
        e.printStackTrace();
        res = false;
      }
      
      ce.closed();
      
      return res;
    }
  }
}
