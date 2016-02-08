package com.sync.core.engine;

import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sync.core.utils.Constants;
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
