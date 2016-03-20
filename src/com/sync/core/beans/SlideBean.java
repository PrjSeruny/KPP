package com.sync.core.beans;

import java.util.Comparator;

public class SlideBean {
  int id;
  String Path;
  String Path_Thumb;
  
  public SlideBean(){}

  public int getId() {
    return id;
  }

  public void setId(int val) {
    id = val;
  }

  public String getPath() {
    return Path;
  }

  public void setPath(String val) {
    Path = val;
  }

  public String getPathThumb() {
    return Path_Thumb;
  }

  public void setPathThumb(String val) {
    Path_Thumb = val;
  }
  
  public static Comparator<SlideBean> cmpSlide = new Comparator<SlideBean>() {

		public int compare(SlideBean o1, SlideBean o2) {
			int id_1 = o1.getId();
			int id_2 = o2.getId();
			
			return id_1 - id_2;
		}
  	
	};
}
