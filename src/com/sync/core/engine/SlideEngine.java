package com.sync.core.engine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sync.core.beans.SlideBean;
import com.sync.core.pool.SlidePool;
import com.sync.core.utils.CoreTable;

public class SlideEngine extends RootEngine{

  public SlideEngine(){}
  
  public SlideEngine(HttpServletRequest rq,HttpServletResponse rs){
    req = rq;
    res = rs;
  }
  
  public SlideBean[] getSlideList(){
    SlideBean[] lists = null;
    
    SQL = " SELECT * FROM " + CoreTable.TABLE_SLIDE + " order by "+CoreTable.COL_SLIDE_ID;
    System.out.println(SQL);
    try
    {
      super.getConnection();
      rs =  super.executeQuery(SQL);
      int row = super.getTotalRow();
      
      if(row<=0) return null;
      
      lists = new SlideBean[row];
      if(null!=rs)
      {
        for(int i=0; i<row; i++)
        {
          rs.next();
          lists[i] = new SlideBean();
          lists[i].setId(rs.getInt(CoreTable.COL_SLIDE_ID));
          lists[i].setPath(rs.getString(CoreTable.COL_SLIDE_PATH));
          lists[i].setPathThumb(rs.getString(CoreTable.COL_SLIDE_PATHTHUMB));
        }
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    
    return lists;
  }
  
  public boolean createSlide(SlideBean sbn)
  {
    boolean res = false;
    try
    {
      SQL = " INSERT INTO " + CoreTable.TABLE_SLIDE +
            "(" +
            CoreTable.COL_SLIDE_ID + "," +
            CoreTable.COL_SLIDE_PATH + "," +
            CoreTable.COL_SLIDE_PATHTHUMB + 
             ")" +
            " VALUES(?,?,?) ON DUPLICATE KEY UPDATE " +   
            CoreTable.COL_SLIDE_PATH + "=?," + 
            CoreTable.COL_SLIDE_PATHTHUMB + "=?;";
      
      super.getConnection();
      stat = con.prepareStatement(SQL);
      stat.setInt(1, sbn.getId());
      stat.setString(2, sbn.getPath());
      stat.setString(3, sbn.getPathThumb());
      stat.setString(4, sbn.getPath());
      stat.setString(5, sbn.getPathThumb());
      
      System.out.println("INSERT USER INTO DATABASE "+stat);
      
      if(stat.executeUpdate()>0){
        SlidePool sp = SlidePool.getInstance();
        sp.put(sbn.getId(), sbn);
        
        return true;
      }
      else return false;
    }
    catch(Exception e)
    {
      e.printStackTrace();
      super.rollback();
      res = false;
    }
    return res;
  }
  
  public boolean deleteSlide(int id)
  {
    boolean res = false;
    try
    {
      SQL = " DELETE FROM " + CoreTable.TABLE_SLIDE +
            " WHERE " +
            CoreTable.COL_SLIDE_ID + "=?;";
      
      super.getConnection();
      stat = con.prepareStatement(SQL);
      stat.setInt(1, id);
      
      System.out.println("DELETE DATABASE "+stat);
      
      if(stat.executeUpdate()>0){
        
        SlidePool sp = SlidePool.getInstance();
        sp.remove(id);
        
        return true;
      }
      else return false;
    }
    catch(Exception e)
    {
      e.printStackTrace();
      super.rollback();
      res = false;
    }
    return res;
  }
  
  public void closed()
  {
    super.finalize();
  }
}
