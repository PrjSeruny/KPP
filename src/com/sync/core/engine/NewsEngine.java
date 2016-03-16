package com.sync.core.engine;

import java.io.File;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;

import com.sync.core.beans.NewsBean;
import com.sync.core.beans.MessageBean;
import com.sync.core.beans.NewsBean;
import com.sync.core.pool.NewsPool;
import com.sync.core.utils.Constants;
import com.sync.core.utils.CoreTable;
import com.sync.core.utils.Utilities;

public class NewsEngine extends RootEngine{
  public NewsEngine(){}
  
  public NewsEngine(HttpServletRequest rq,HttpServletResponse rs){
    req = rq;
    res = rs;
  }
  
  public NewsBean validateNews(){
    System.out.println("BEGINNING VALIDATE");
    MessageBean msg = new MessageBean();
    NewsBean gb = new NewsBean();
    
    String temp;
    
    temp = Utilities.cleanInput(req.getParameter(Constants.FORM_NEWS_TITLE));
    if(!Utilities.isEmpy(temp)){
      gb.setTitle(temp);
    }
    
    temp = Utilities.cleanInput(req.getParameter(Constants.FORM_NEWS_DESC));
    if(!Utilities.isEmpy(temp)){
      gb.setDesc(temp);
    }
    
    temp = Utilities.cleanInput(req.getParameter(Constants.FORM_IMAGE_PATH));
    if(!Utilities.isEmpy(temp)){
      System.out.println("path : "+temp);
      gb.setPath(temp);
    }else{
      msg.setMessageBean(Constants.FORM_IMAGE_PATH, "Silahkan Upload gambar!");
    }
    
    temp = Utilities.cleanInput(req.getParameter(Constants.FORM_IMAGE_PATHTHUMB));
    if(!Utilities.isEmpy(temp)){
      System.out.println("path thumb : "+temp);
      gb.setPathThumb(temp);
    }else{
      msg.setMessageBean(Constants.FORM_IMAGE_PATHTHUMB, "Silahkan Upload gambar!");
    }
    
    gb.setMessageBean(msg);
    
    return gb;
  }
  
  public NewsBean getNewsInfo(String ID)
  {
    NewsBean nbn = null;
    
    SQL = " SELECT * " +
          " FROM " +
          CoreTable.TABLE_NEWS + 
          " WHERE " +
          CoreTable.COL_NEWS_ID + "=" + ID + ";";
    
    try
    {
      super.getConnection();
      rs = super.executeQuery(SQL);
      
      if(null!=rs)
      {
        rs.next();
        nbn = new NewsBean();
        nbn.setID(rs.getInt(CoreTable.COL_NEWS_ID));
        nbn.setTitle(rs.getString(CoreTable.COL_NEWS_TITLE));
        nbn.setDesc(rs.getString(CoreTable.COL_NEWS_DESC));
        nbn.setPath(rs.getString(CoreTable.COL_NEWS_PATH));
        nbn.setPathThumb(rs.getString(CoreTable.COL_NEWS_PATHTHUMB));
        nbn.setEntryDate(
            Utilities.stringToDate(rs.getString(CoreTable.COL_NEWS_ENTRYDATE), 
                Constants.DATE_DB_MEDIUM_PATTERN));
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
      nbn = null;
    }
    
    return nbn;
  }
  
  public NewsBean[] getNewsList()
  {
    NewsBean[] lists = null;
    int row = 0;
    String currPage = req.getParameter(Constants.FORM_CURRENT_PAGE);
    String limit = req.getParameter(Constants.FORM_LIMIT_RECORD);
    
    addSQL = " order by "+CoreTable.COL_NEWS_ENTRYDATE+" desc";
    
    String pagination = buildPagination(CoreTable.TABLE_NEWS, 
                                        (null==currPage?1:Integer.parseInt(currPage)), 
                                        (null==limit?Constants.DEFAULT_LIMIT_RECORD:Integer.parseInt(limit)));
    req.setAttribute(Constants.HTML_PAGINATION, pagination);
    
    SQL = " SELECT * " +
          " FROM " + CoreTable.TABLE_NEWS + addSQL + SQLlimit;
    System.out.println(SQL);
    try
    {
      super.getConnection();
      rs =  super.executeQuery(SQL);
      row = super.getTotalRow();
      
      if(row<=0) return null;
      
      lists = new NewsBean[row];
      if(null!=rs)
      {
        for(int i=0; i<row; i++)
        {
          rs.next();
          lists[i] = new NewsBean();
          lists[i].setID(rs.getInt(CoreTable.COL_NEWS_ID));
          lists[i].setTitle(rs.getString(CoreTable.COL_NEWS_TITLE));
          lists[i].setDesc(rs.getString(CoreTable.COL_NEWS_DESC));
          lists[i].setPath(rs.getString(CoreTable.COL_NEWS_PATH));
          lists[i].setPathThumb(rs.getString(CoreTable.COL_NEWS_PATHTHUMB));
          lists[i].setEntryDate(Utilities.stringToDate(rs.getString(CoreTable.COL_NEWS_ENTRYDATE), Constants.DATE_DB_MEDIUM_PATTERN));
        }
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    
    return lists;
  }
  
  public NewsBean[] getAllNews(){
    NewsBean[] lists = null;
    
    SQL = " SELECT * FROM " + CoreTable.TABLE_NEWS + " order by "+CoreTable.COL_NEWS_ENTRYDATE+" desc";
    System.out.println(SQL);
    try
    {
      super.getConnection();
      rs =  super.executeQuery(SQL);
      int row = super.getTotalRow();
      
      if(row<=0) return null;
      
      lists = new NewsBean[row];
      if(null!=rs)
      {
        for(int i=0; i<row; i++)
        {
          rs.next();
          lists[i] = new NewsBean();
          lists[i].setID(rs.getInt(CoreTable.COL_NEWS_ID));
          lists[i].setTitle(rs.getString(CoreTable.COL_NEWS_TITLE));
          lists[i].setDesc(rs.getString(CoreTable.COL_NEWS_DESC));
          lists[i].setEntryDate(
              Utilities.stringToDate(rs.getString(CoreTable.COL_NEWS_ENTRYDATE), Constants.DATE_DB_MEDIUM_PATTERN));
          lists[i].setPath(rs.getString(CoreTable.COL_NEWS_PATH));
          lists[i].setPathThumb(rs.getString(CoreTable.COL_NEWS_PATHTHUMB));
        }
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    
    return lists;
  }
  
  public boolean createGallery(NewsBean nbn)
  {
    boolean res = false;
    String name = FilenameUtils.getName(nbn.getPath());
    System.out.println("masuk path : "+nbn.getPath());
    System.out.println("name image : "+name);
    
    try
    {
      SQL = " INSERT INTO " + CoreTable.TABLE_NEWS +
            " VALUES(null,?,?,?,?,?)";
      
      nbn.setPath(Constants.PICLIB_PATH+"/"+name);
      nbn.setPathThumb(Constants.PICLIB_THUMB_PATH+"/"+name);
      
      super.getConnection();
      stat = con.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS);
      stat.setString(1, nbn.getTitle());
      stat.setString(2, nbn.getDesc());
      stat.setString(4, nbn.getPath());
      stat.setString(3, nbn.getPathThumb());
      stat.setString(5, 
          Utilities.dateToString(nbn.getEntryDate(), Constants.DATE_DB_MEDIUM_PATTERN));
      
      System.out.println("INSERT USER INTO DATABASE "+stat);
      
      if(stat.executeUpdate()>0){
        rs = stat.getGeneratedKeys();
        if (rs.next()) {
          nbn.setID(rs.getInt(1));
          System.out.println("id baru "+nbn.getID());
        }
        
        NewsPool np = NewsPool.getInstance();
        super.moveFile(Constants.FILE_TEMP_PATH+File.separator+name, Constants.PICLIB_PATH);
        super.moveFile(Constants.FILE_TEMP_THUMB_PATH+File.separator+name, Constants.PICLIB_THUMB_PATH);
        
        np.put(nbn.getID(),nbn);
        
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
  
  public boolean updateNews(NewsBean nbn)
  {
    boolean res = false;
    String name = FilenameUtils.getName(nbn.getPath());
    boolean imageIsUpdate = false;
    NewsPool np = NewsPool.getInstance();
    
    if(!np.get(nbn.getID()).getPath().equals(nbn.getPath())){
      System.out.println("image is updated");
      imageIsUpdate = true;
    }
    
    if(imageIsUpdate){
      nbn.setPath(Constants.PICLIB_PATH+"/"+name);
      nbn.setPathThumb(Constants.PICLIB_THUMB_PATH+"/"+name);
    }
    
    try
    {
      SQL = "UPDATE " + CoreTable.TABLE_NEWS +
            " SET "+CoreTable.COL_NEWS_TITLE+"=?,"
            +CoreTable.COL_NEWS_DESC+"=?,"
            +CoreTable.COL_NEWS_ENTRYDATE+"=?,"
            +CoreTable.COL_NEWS_PATH+"=?,"
            +CoreTable.COL_NEWS_PATHTHUMB+"=?"
            +" WHERE "+CoreTable.COL_NEWS_ID+"=?;";
      
      nbn.setEntryDate(new Date());
      
      super.getConnection();
      stat = con.prepareStatement(SQL);
      stat.setString(1, nbn.getTitle());
      stat.setString(2, nbn.getDesc());
      stat.setString(3, Utilities.dateToString(nbn.getEntryDate(), Constants.DATE_DB_MEDIUM_PATTERN));
      stat.setString(4, nbn.getPath());
      stat.setString(5, nbn.getPathThumb());
      stat.setInt(6, nbn.getID());
      
      System.out.println("INSERT USER INTO DATABASE "+stat);
      
      if(stat.executeUpdate()>0){
        if(imageIsUpdate){
          super.moveFile(Constants.FILE_TEMP_PATH+File.separator+name, Constants.PICLIB_PATH);
          super.moveFile(Constants.FILE_TEMP_THUMB_PATH+File.separator+name, Constants.PICLIB_THUMB_PATH);
        }
        
        np.put(nbn.getID(),nbn);
        
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
  
  public boolean deleteNews(String[] ids)
  {
    boolean res = false;
    try
    {
      SQL = " DELETE FROM " + CoreTable.TABLE_NEWS +
            " WHERE " +
            CoreTable.COL_NEWS_ID + " IN ("+String.join(",", ids)+");";
      
      super.getConnection();
      stat = con.prepareStatement(SQL);
      
      System.out.println("DELETE DATABASE "+stat);
      
      if(stat.executeUpdate()>0){
        
        NewsPool np = NewsPool.getInstance();
        NewsBean tmp = null;
        
        for(int i=0;i<ids.length;i++){
          tmp = np.get(Integer.parseInt(ids[i]));
          super.deleteFile(tmp.getPath());
          super.deleteFile(tmp.getPathThumb());
          np.remove(Integer.parseInt(ids[i]));
        }
        
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
