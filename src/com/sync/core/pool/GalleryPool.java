package com.sync.core.pool;

import java.util.HashMap;

import com.sync.core.beans.GalleryBean;
import com.sync.core.engine.GalleryEngine;

public class GalleryPool {

  private static GalleryPool p = new GalleryPool();
  private HashMap<Integer, GalleryBean> collections;
  private static final Object lock = new Object();

  /**
   * Constructor.
   */
  private GalleryPool()
  { collections = new HashMap<Integer, GalleryBean>(); }

  /**
   * Get this instance of the modules pool.
   */
  public static synchronized GalleryPool getInstance()
  {
    if(null==p)
    {
      synchronized(lock)
      { if(null==p) p = new GalleryPool(); }
    }

    return p;
  }
  
  public void put(Integer key, GalleryBean val)
  { synchronized(lock) { collections.put(key, val); } }

  public GalleryBean get(Integer key) { return collections.get(key); }

  public void remove(Integer key) 
  { synchronized(lock) { collections.remove(key); } }
  
  public boolean reload()
  {
    synchronized(lock)
    {
      GalleryEngine ge = new GalleryEngine();
      boolean res = false;
      
      try
      {
        GalleryBean[] list = ge.getAllGallery();
        if(null!=list)
        {
          //Clear the old pool first
          collections.clear();
          
          //Relist the result.      
          for(int l=0; l<list.length; l++)
          { this.put(list[l].getID(), list[l]); }
          
          res = true;

          System.out.println("Gallery pool berhasil di isi");
        }
      }
      catch (Exception e)
      {
        System.out.println("Gallery pool gagal di isi");
        e.printStackTrace();
        res = false;
      }
      
      ge.closed();
      return res;
    }
  }
  
}
