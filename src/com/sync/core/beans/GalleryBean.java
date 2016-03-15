package com.sync.core.beans;

import java.util.Date;

public class GalleryBean {
  private int id;
  private String title,desc,path,path_thumb;
  private Date dateCreate;
  private MessageBean msg = null;

  
  /** Sets MessageBean */
  public void setMessageBean(MessageBean val){ msg = val; }
  /** Gets MessageBean */
  public MessageBean getMessageBean(){ return msg; }
  
  /**
   * @return the dateCreate
   */
  public Date getDateCreate() {
    return dateCreate;
  }

  /**
   * @param dateCreate the dateCreate to set
   */
  public void setDateCreate(Date val) {
    dateCreate = val;
  }

  public GalleryBean(){}

  /**
   * @return the id
   */
  public int getID() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setID(int val) {
    id = val;
  }

  /**
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param title the title to set
   */
  public void setTitle(String val) {
    title = val;
  }

  /**
   * @return the desc
   */
  public String getDesc() {
    return desc;
  }

  /**
   * @param desc the desc to set
   */
  public void setDesc(String val) {
    desc = val;
  }

  /**
   * @return the path
   */
  public String getPath() {
    return path;
  }

  /**
   * @param path the path to set
   */
  public void setPath(String val) {
    path = val;
  }

  /**
   * @return the path_thumb
   */
  public String getPathThumb() {
    return path_thumb;
  }

  /**
   * @param path_thumb the path_thumb to set
   */
  public void setPathThumb(String val) {
    path_thumb = val;
  }
  
  
}
