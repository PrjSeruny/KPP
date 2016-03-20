package com.sync.core.pool;

import java.util.ArrayList;
import java.util.TreeMap;

import com.sync.core.beans.SlideBean;
import com.sync.core.engine.SlideEngine;

public class SlidePool {

  private static SlidePool p = new SlidePool();
  private TreeMap<Integer, SlideBean> collections;
  private static final Object lock = new Object();
  
  /**
   * Constructor.
   */
  private SlidePool()
  { collections = new TreeMap<Integer, SlideBean>(); }

  /**
   * Get this instance of the modules pool.
   */
  public static synchronized SlidePool getInstance()
  {
    if(null==p)
    {
      synchronized(lock)
      { if(null==p) p = new SlidePool(); }
    }

    return p;
  }
  
  public void put(Integer key, SlideBean val)
  { synchronized(lock) { collections.put(key, val); } }

  public SlideBean get(Integer key) { return collections.get(key); }

  public ArrayList<SlideBean> getValue()
  {
  	ArrayList<SlideBean> value = new ArrayList<SlideBean>(collections.values());
  	return value;
  }
  
  public void remove(Integer key) 
  { synchronized(lock) { collections.remove(key); } }
  
  public boolean reload()
  {
    synchronized(lock)
    {
      SlideEngine se = new SlideEngine();
      boolean res = false;
      
      try
      {
        SlideBean[] list = se.getSlideList();
        if(null!=list)
        {
          //Clear the old pool first
          collections.clear();
          
          //Relist the result.      
          for(int l=0; l<list.length; l++)
          { this.put(list[l].getId(), list[l]); }
          
          res = true;

          System.out.println("Slide pool berhasil di isi");
        }
      }
      catch (Exception e)
      {
        System.out.println("Slide pool gagal di isi");
        e.printStackTrace();
        res = false;
      }
      
      se.closed();
      return res;
    }
  }
  
}
