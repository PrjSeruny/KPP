package com.sync.core.pool;

import java.util.ArrayList;
import java.util.HashMap;

import com.sync.core.beans.NewsBean;
import com.sync.core.engine.NewsEngine;

public class NewsPool {

  private static NewsPool p = new NewsPool();
  private HashMap<Integer, NewsBean> collections;
  private static final Object lock = new Object();

  /**
   * Constructor.
   */
  private NewsPool()
  { collections = new HashMap<Integer, NewsBean>(); }

  /**
   * Get this instance of the modules pool.
   */
  public static synchronized NewsPool getInstance()
  {
    if(null==p)
    {
      synchronized(lock)
      { if(null==p) p = new NewsPool(); }
    }

    return p;
  }
  
  public void put(Integer key, NewsBean val)
  { synchronized(lock) { collections.put(key, val); } }

  public NewsBean get(Integer key) { return collections.get(key); }

  public ArrayList<NewsBean> getValue()
  {
  	ArrayList<NewsBean> value = new ArrayList<NewsBean>(collections.values());
  	return value;
  }
  
  public void remove(Integer key) 
  { synchronized(lock) { collections.remove(key); } }
  
  public boolean reload()
  {
    synchronized(lock)
    {
      NewsEngine ne = new NewsEngine();
      boolean res = false;
      
      try
      {
        NewsBean[] list = ne.getAllNews();
        if(null!=list)
        {
          //Clear the old pool first
          collections.clear();
          
          //Relist the result.      
          for(int l=0; l<list.length; l++)
          { this.put(list[l].getID(), list[l]); }
          
          res = true;

          System.out.println("News pool berhasil di isi");
        }
      }
      catch (Exception e)
      {
        System.out.println("News pool gagal di isi");
        e.printStackTrace();
        res = false;
      }
      
      ne.closed();
      
      return res;
    }
  }

}
