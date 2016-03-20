package com.sync.core.beans;

import java.util.Comparator;
import java.util.Date;

public class NewsBean {
  private int id;
  private String title,desc,path,path_thumb;
  private Date entryDate;
  private MessageBean msg = null;

  public NewsBean(){}
  
  /** Sets MessageBean */
  public void setMessageBean(MessageBean val){ msg = val; }
  /** Gets MessageBean */
  public MessageBean getMessageBean(){ return msg; }
  
  /**
   * @return the dateCreate
   */
  public Date getEntryDate() {
    return entryDate;
  }

  /**
   * @param dateCreate the dateCreate to set
   */
  public void setEntryDate(Date val) {
    entryDate = val;
  }

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
  
  public static Comparator<NewsBean> compNews = new Comparator<NewsBean>() {
		public int compare(NewsBean o1, NewsBean o2) {
			return o2.getEntryDate().compareTo(o1.getEntryDate());
		}
	};
}
