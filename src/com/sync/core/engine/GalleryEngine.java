package com.sync.core.engine;

import java.io.File;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;

import com.sync.core.beans.GalleryBean;
import com.sync.core.beans.MessageBean;
import com.sync.core.pool.GalleryPool;
import com.sync.core.utils.Constants;
import com.sync.core.utils.CoreTable;
import com.sync.core.utils.Utilities;

public class GalleryEngine extends RootEngine{

  public GalleryEngine(){}
  
  public GalleryEngine(HttpServletRequest rq,HttpServletResponse rs){
    req = rq;
    res = rs;
  }
  
  public GalleryBean validateGallery(){
    System.out.println("BEGINNING VALIDATE");
    MessageBean msg = new MessageBean();
    GalleryBean gb = new GalleryBean();
    
    String temp;
    
    temp = Utilities.cleanInput(req.getParameter(Constants.FORM_GALLERY_TITLE));
    if(!Utilities.isEmpy(temp)){
      gb.setTitle(temp);
    }
    
    temp = Utilities.cleanInput(req.getParameter(Constants.FORM_GALLERY_DESC));
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
  
  public GalleryBean getGalleryInfo(String ID)
  {
    GalleryBean gbn = null;
    
    SQL = " SELECT * " +
          " FROM " +
          CoreTable.TABLE_GALLERY + 
          " WHERE " +
          CoreTable.COL_GALLERY_ID + "=" + ID + ";";
    
    try
    {
      super.getConnection();
      rs = super.executeQuery(SQL);
      
      if(null!=rs)
      {
        rs.next();
        gbn = new GalleryBean();
        gbn.setID(rs.getInt(CoreTable.COL_GALLERY_ID));
        gbn.setTitle(rs.getString(CoreTable.COL_GALLERY_TITLE));
        gbn.setDesc(rs.getString(CoreTable.COL_GALLERY_DESC));
        gbn.setPath(rs.getString(CoreTable.COL_GALLERY_PATH));
        gbn.setPathThumb(rs.getString(CoreTable.COL_GALLERY_PATHTHUMB));
        gbn.setDateCreate(
            Utilities.stringToDate(rs.getString(CoreTable.COL_GALLERY_DATECREATE), 
                Constants.DATE_DB_MEDIUM_PATTERN));
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
      gbn = null;
    }
    
    return gbn;
  }
  
  public GalleryBean[] getGalleryList()
  {
    GalleryBean[] lists = null;
    int row = 0;
    String currPage = req.getParameter(Constants.FORM_CURRENT_PAGE);
    String limit = req.getParameter(Constants.FORM_LIMIT_RECORD);
    
    addSQL = " order by "+CoreTable.COL_GALLERY_DATECREATE+" desc";
    
    String pagination = buildPagination(CoreTable.TABLE_GALLERY, 
                                        (null==currPage?1:Integer.parseInt(currPage)), 
                                        (null==limit?Constants.DEFAULT_LIMIT_RECORD:Integer.parseInt(limit)));
    req.setAttribute(Constants.HTML_PAGINATION, pagination);
    
    SQL = " SELECT * " +
          " FROM " + CoreTable.TABLE_GALLERY + addSQL + SQLlimit;
    System.out.println(SQL);
    try
    {
      super.getConnection();
      rs =  super.executeQuery(SQL);
      row = super.getTotalRow();
      
      if(row<=0) return null;
      
      lists = new GalleryBean[row];
      if(null!=rs)
      {
        for(int i=0; i<row; i++)
        {
          rs.next();
          lists[i] = new GalleryBean();
          lists[i].setID(rs.getInt(CoreTable.COL_GALLERY_ID));
          lists[i].setTitle(rs.getString(CoreTable.COL_GALLERY_TITLE));
          lists[i].setDesc(rs.getString(CoreTable.COL_GALLERY_DESC));
          lists[i].setPath(rs.getString(CoreTable.COL_GALLERY_PATH));
          lists[i].setPathThumb(rs.getString(CoreTable.COL_GALLERY_PATHTHUMB));
          lists[i].setDateCreate(Utilities.stringToDate(rs.getString(CoreTable.COL_GALLERY_DATECREATE), Constants.DATE_DB_MEDIUM_PATTERN));
        }
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    
    return lists;
  }
  
  public GalleryBean[] getAllGallery(){
    GalleryBean[] lists = null;
    
    SQL = " SELECT * FROM " + CoreTable.TABLE_GALLERY + " order by "+CoreTable.COL_GALLERY_DATECREATE+" desc";
    System.out.println(SQL);
    try
    {
      super.getConnection();
      rs =  super.executeQuery(SQL);
      int row = super.getTotalRow();
      
      if(row<=0) return null;
      
      lists = new GalleryBean[row];
      if(null!=rs)
      {
        for(int i=0; i<row; i++)
        {
          rs.next();
          lists[i] = new GalleryBean();
          lists[i].setID(rs.getInt(CoreTable.COL_GALLERY_ID));
          lists[i].setTitle(rs.getString(CoreTable.COL_GALLERY_TITLE));
          lists[i].setDesc(rs.getString(CoreTable.COL_GALLERY_DESC));
          lists[i].setDateCreate(
              Utilities.stringToDate(rs.getString(CoreTable.COL_GALLERY_DATECREATE), Constants.DATE_DB_MEDIUM_PATTERN));
          lists[i].setPath(rs.getString(CoreTable.COL_GALLERY_PATH));
          lists[i].setPathThumb(rs.getString(CoreTable.COL_GALLERY_PATHTHUMB));
        }
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    
    return lists;
  }
  
  public boolean createGallery(GalleryBean gbn)
  {
    boolean res = false;
    String name = FilenameUtils.getName(gbn.getPath());
    System.out.println("masuk path : "+gbn.getPath());
    System.out.println("name image : "+name);
    
    try
    {
      SQL = " INSERT INTO " + CoreTable.TABLE_GALLERY +
            " VALUES(null,?,?,?,?,?)";
      
      gbn.setPath(Constants.PICLIB_PATH+"/"+name);
      gbn.setPathThumb(Constants.PICLIB_THUMB_PATH+"/"+name);
      
      super.getConnection();
      stat = con.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS);
      stat.setString(1, gbn.getTitle());
      stat.setString(2, gbn.getDesc());
      stat.setString(4, gbn.getPath());
      stat.setString(3, gbn.getPathThumb());
      stat.setString(5, 
          Utilities.dateToString(gbn.getDateCreate(), Constants.DATE_DB_MEDIUM_PATTERN));
      
      System.out.println("INSERT USER INTO DATABASE "+stat);
      
      if(stat.executeUpdate()>0){
        rs = stat.getGeneratedKeys();
        if (rs.next()) {
          gbn.setID(rs.getInt(1));
          System.out.println("id baru "+gbn.getID());
        }
        
        GalleryPool gp = GalleryPool.getInstance();
        super.moveFile(Constants.FILE_TEMP_PATH+File.separator+name, Constants.PICLIB_PATH);
        super.moveFile(Constants.FILE_TEMP_THUMB_PATH+File.separator+name, Constants.PICLIB_THUMB_PATH);
        
        gp.put(gbn.getID(),gbn);
        
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
  
  public boolean updateGallery(GalleryBean gbn)
  {
    boolean res = false;
    String name = FilenameUtils.getName(gbn.getPath());
    boolean imageIsUpdate = false;
    GalleryPool gp = GalleryPool.getInstance();
    
    if(!gp.get(gbn.getID()).getPath().equals(gbn.getPath())){
      System.out.println("image is updated");
      imageIsUpdate = true;
    }
    
    if(imageIsUpdate){
      gbn.setPath(Constants.PICLIB_PATH+"/"+name);
      gbn.setPathThumb(Constants.PICLIB_THUMB_PATH+"/"+name);
    }
    
    try
    {
      SQL = "UPDATE " + CoreTable.TABLE_GALLERY +
            " SET "+CoreTable.COL_GALLERY_TITLE+"=?,"
            +CoreTable.COL_GALLERY_DESC+"=?,"
            +CoreTable.COL_GALLERY_PATH+"=?,"
            +CoreTable.COL_GALLERY_PATHTHUMB+"=?"
            +" WHERE "+CoreTable.COL_GALLERY_ID+"=?;";
      
      super.getConnection();
      stat = con.prepareStatement(SQL);
      stat.setString(1, gbn.getTitle());
      stat.setString(2, gbn.getDesc());
      stat.setString(3, gbn.getPath());
      stat.setString(4, gbn.getPathThumb());
      stat.setInt(5, gbn.getID());
      
      System.out.println("INSERT USER INTO DATABASE "+stat);
      
      if(stat.executeUpdate()>0){
        if(imageIsUpdate){
          super.moveFile(Constants.FILE_TEMP_PATH+File.separator+name, Constants.PICLIB_PATH);
          super.moveFile(Constants.FILE_TEMP_THUMB_PATH+File.separator+name, Constants.PICLIB_THUMB_PATH);
        }
        
        gp.put(gbn.getID(),gbn);
        
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
  
  public boolean deleteGallery(String[] ids)
  {
    boolean res = false;
    try
    {
      SQL = " DELETE FROM " + CoreTable.TABLE_GALLERY +
            " WHERE " +
            CoreTable.COL_GALLERY_ID + " IN ("+Utilities.joinForSQL(",", ids)+");";
      
      super.getConnection();
      stat = con.prepareStatement(SQL);
      
      System.out.println("DELETE DATABASE "+stat);
      
      if(stat.executeUpdate()>0){
        
        GalleryPool gp = GalleryPool.getInstance();
        GalleryBean tmp = null;
        
        for(int i=0;i<ids.length;i++){
          tmp = gp.get(Integer.parseInt(ids[i]));
          super.deleteFile(tmp.getPath());
          super.deleteFile(tmp.getPathThumb());
          gp.remove(Integer.parseInt(ids[i]));
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
