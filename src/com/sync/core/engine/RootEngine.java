package com.sync.core.engine;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;

import com.sync.core.utils.Constants;
import com.sync.core.utils.Utilities;
import com.sync.master.beans.MasterUserBean;
import com.sync.master.utils.MasterConstants;

public class RootEngine extends ConnectionDB
{
  protected HttpServletRequest req;
  protected HttpServletResponse res;
  protected String SQL = "";
  protected String addSQL = "";
  protected String SQLlimit = "";
  protected ResultSet rs = null;
  
  public MasterUserBean getUserInSession()
  {
    HttpSession session=req.getSession(true);
    
    return (MasterUserBean)session.getAttribute(MasterConstants.MASTERUSER);
  }
  
  public JSONObject uploadFileUniqueID(List<FileItem> multiparts,String dest, String exts[], long maxsize){
    return uploadFile(multiparts, dest, exts, maxsize, true, false);
  }
  
  public JSONObject uploadFile(List<FileItem> multiparts,String dest, String exts[], long maxsize){
    return uploadFile(multiparts, dest, exts, maxsize, false, true);
  }
  
  /**
   * Function For Upload File
   * @param dest is destination of uploaded file
   * @param exts is extension that allowed to upload
   * @param maxsize is maximal size of an upload file
   * @return an json object
   */
  public JSONObject uploadFile(List<FileItem> multiparts,String dest, String exts[], long maxsize, boolean unique, boolean delPrevFile){
    // Create a factory for disk-based file items
    //FileItemFactory factory = new DiskFileItemFactory();
    System.out.println("masuk upload file");
    
    // Create a new file upload handler
    //ServletFileUpload upload = new ServletFileUpload(factory);

    JSONObject result = null;
    
    try {
      System.out.println("masuk Try");
      // Parse the request
      /*@SuppressWarnings("unchecked")
      List<FileItem> multiparts = upload.parseRequest(req);*/

      for (FileItem item : multiparts) {
        System.out.println("masuk For : "+item.getContentType());
        
        if (!item.isFormField()) {
          File file = new File(item.getName());
          String name = file.getName();
          String ext = FilenameUtils.getExtension(file.getPath()).toLowerCase();
          
          if(unique){name = String.valueOf(new Date().getTime())+"."+ext;}
          
          String location = Constants.DIR_PATH + Constants.ROOT_PATH + dest + File.separator + name;
          long size = item.getSize();
          
          System.out.println("pt "+file.getPath()+", ext "+ext+", size "+size);
          
          if(null!=exts && !Arrays.asList(exts).contains(ext)){
            throw new Exception("File yang dipilih tidak didukung");
          }
          
          if(maxsize>0 && size > maxsize){
            System.out.println("limited : "+(maxsize>0 && size > maxsize));
            throw new Exception("Kapasitas file terlalu besar");
          }
          
          File f = new File(location);
          if(f.exists() && f.isFile()){
             throw new Exception("Terdapat file yang sama pada server ("+name+")");
          }else{
            item.write(f);
            result = new JSONObject();
            
            try {
              result.put("ajax_status", "success");
              result.put("path", dest+"/"+name);
            } catch (Exception e2) {
              e2.printStackTrace();
            }
          }
        }else{
          System.out.println("name : "+item.getFieldName()+" , value : "+item.getString());
          if(
              !Utilities.isEmpy(item.getString()) && 
              (item.getFieldName().equals("image") || item.getFieldName().equals("image_thumb")) &&
              delPrevFile
          )
          {
            deleteFile(item.getString());
          }
        }
      }
    } 
    catch (Exception e) 
    {
      e.printStackTrace();
      String error = "Error : "+e.getMessage();
      System.out.println(error);
      result = new JSONObject();
      
      try {
        result.put("ajax_status", "error");
        result.put("msg", error);
      } catch (Exception e2) {
        e2.printStackTrace();
      }
      
    }
    return result;
  }

  public void createThumbnail(JSONObject img) {
    createThumbnail(img, Constants.PICLIB_THUMB_PATH);
  }

  public void createThumbnail(JSONObject img, String dest) {
    int maxSize = 200;
    try {
      //Creating thumbnail image
      //Read the original image
      String filePath = Constants.DIR_PATH + Constants.ROOT_PATH + img.getString("path");
      System.out.println("thumb path : "+filePath);
      File file = new File(filePath);
      BufferedImage SlideBufImg = ImageIO.read(file);
      
      int oriW = SlideBufImg.getWidth();
      int oriH = SlideBufImg.getHeight();
      int newW = maxSize;
      int newH = maxSize;

      System.out.println("ori size : "+oriW+"x"+oriH);
      
      if(oriW > oriH){
        newH = (newW * oriH) / oriW;
      }
      else if(oriH > oriW){
        newW = (newH * oriW) / oriH;
      }

      System.out.println("final size : "+newW+"x"+newH);
      
      //Creating and preparing new image thumbnail
      BufferedImage SlideBufImgThumb = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_RGB);
      Graphics2D g2Thumb = SlideBufImgThumb.createGraphics();
      g2Thumb.drawImage(SlideBufImg, 0, 0, newW, newH, null);
      g2Thumb.dispose();
      
      ByteArrayOutputStream SlideByteStream = new ByteArrayOutputStream();
      
      
      //initialize buffer output stream for efficiency                 
      //BufferedOutputStream
      BufferedOutputStream SlideBOS = new BufferedOutputStream(SlideByteStream);
      
      String fileName = file.getName();
      String ext = FilenameUtils.getExtension(file.getPath());
      System.out.println("name "+fileName+", ext "+ext);

      String URLpath = dest + "/" + fileName;
      String fPath = Constants.DIR_PATH + Constants.ROOT_PATH + URLpath;
      
      System.out.println(fPath);
      System.out.println(URLpath);
      
      ImageIO.write(SlideBufImgThumb,ext,SlideBOS);     
      
      // Flush ByteArrayOutputStream                              
      SlideByteStream.flush();         

      //convert the bytes in stream to byte array
      //byte[]
      byte[] newimage = SlideByteStream.toByteArray(); 
      
      //Prepare output thumbnail file path
      //File outputThumbPic = new File(fPath);
      
     // File ImageThumb 
      FileOutputStream SlideFOS = new FileOutputStream(fPath);             
      SlideFOS.write(newimage);
      SlideFOS.flush();  
      SlideFOS.close();
      img.put("path_thumb", URLpath);
      System.out.println("sukses buat thumb "+img.toString());
      
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.out.println("ERROR : Gagal membuat thumbnail, "+e.getMessage());
      try {
        img.put("ajax_status", "error");
        img.put("msg", "ERROR : Gagal membuat thumbnail, "+e.getMessage());
      } catch (Exception e2) {
        // TODO: handle exception
        e2.printStackTrace();
        System.out.println("Error : "+e2.getMessage());
      }
    }
    return;
  }

  public JSONObject deleteImageFile() {
    JSONObject result = null;
    String img = req.getParameter("image");
    String img_thumb = req.getParameter("image_thumb");
    
    try {
        result = new JSONObject();
        String stat = deleteFile(img);
        deleteFile(img_thumb);
        
        if(null!=stat){
          throw new Exception(stat);
        }
        
        result.put("ajax_status", "success");
        
    } catch (Exception e) {
      try {
        result = new JSONObject();
        result.put("ajax_status", "error");
        result.put("msg",e.getMessage());
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }
    
    return result;
  }
  
  public boolean moveFile(String src, String dest){
    boolean result = false;
    
    try {
      File fsrc = new File(Constants.DIR_PATH + Constants.ROOT_PATH + src);
      File fdest = new File(Constants.DIR_PATH + Constants.ROOT_PATH + dest + File.separator + fsrc.getName());
      fsrc.renameTo(fdest);
      
      result = true;
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
    
    return result;
  }
  
  public String deleteFile(String path){
    String result = null;
    
    File file = new File(Constants.DIR_PATH + Constants.ROOT_PATH + path);
    
    try {
      
      if(file.exists() && file.isFile()){
        if(!file.delete()){
          result = "ERROR : File tidak dapat dihapus!";
        }
      }
    } catch (Exception e) {
      result = "ERROR : "+e.getMessage();
      e.printStackTrace();
    }
    
    return result;
  }
  
  public String buildPagination(String table, int currPage, int limit)
  {    
    SQL = " SELECT COUNT(*) AS COUNT_RECORD" +
    " FROM " + table + addSQL;
    int row = 0;
    try
    {
      super.getConnection();
      rs =  super.executeQuery(SQL);
      
      if(null!=rs)
      {
          rs.next();
          row = rs.getInt("COUNT_RECORD");
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    
    System.out.println("ROW = "+row);
    if(row<=0){return "";}
    
    int max = (int)Math.ceil(((double)row)/((double)limit));

    String result = "";
    if(max>1){

      int begin = (currPage-1)*limit;
      SQLlimit = " limit "+begin+", "+limit;
      
      result = "<div class='list-control'>"+
                      "<ul class='pagination'>";
      if(currPage>1){
        result +="<li class='first'><a href='javascript:void(0)'><<</a></li>"+
          "<li class='prev'><a href='javascript:void(0)'><</a></li>";
      }

      result += "<li class='page'><select name='"+Constants.FORM_CURRENT_PAGE+"' max='"+max+"'>";
      for(int i=1;i<=max;i++)
      {
        result += "<option value='"+i+"' "+(i==currPage?"selected":"")+">"+i+"</option>";
      }
      result += "</select><span>"+currPage+" / "+max+"</span></li>";
      
      if(currPage<max){
        result += "<li class='next'><a href='javascript:void(0)'>></a></li>"+
          "<li class='last'><a href='javascript:void(0)'>>></a></li>";
      }
      
      result += "</ul></div>";
    }
    
    
    if(row > Constants.DEFAULT_LIMIT_RECORD)
    {
      result += "<div class='drecord'>Tampilkan : " + 
                "<select name="+Constants.FORM_LIMIT_RECORD+">";
      
      for(int i=0;i<Constants.LIMIT_RECORD.length;i++){
        result += "<option value="+Constants.LIMIT_RECORD[i]+" "+(limit==Constants.LIMIT_RECORD[i]?"selected":"")+">"+Constants.LIMIT_RECORD[i]+"</option>"; 
      }
      
      result += "</select></div>";
      
    }
    
    System.out.println("pagination = "+result);
    return result;
  }
}
