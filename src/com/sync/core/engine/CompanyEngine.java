package com.sync.core.engine;

import java.io.File;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;

import com.sync.core.beans.CompanyBean;
import com.sync.core.beans.MessageBean;
import com.sync.core.beans.NewsBean;
import com.sync.core.beans.SlideBean;
import com.sync.core.pool.CompanyPool;
import com.sync.core.pool.NewsPool;
import com.sync.core.pool.SlidePool;
import com.sync.core.utils.Constants;
import com.sync.core.utils.CoreTable;
import com.sync.core.utils.Utilities;

public class CompanyEngine extends RootEngine {
  
  public CompanyEngine(){}
  
  public CompanyEngine(HttpServletRequest rq,HttpServletResponse rs){
    req = rq;
    res = rs;
  }
  
  public CompanyBean[] validateContact(){
    System.out.println("BEGINNING VALIDATE");
    
    ArrayList<CompanyBean> abn = new ArrayList<CompanyBean>();
    String temp;
    CompanyBean bn;
    
    Enumeration names = req.getParameterNames();
    
    while (names.hasMoreElements()) {
      String paramName = (String)names.nextElement();
      System.out.println("param : "+paramName);
      
      if(paramName.equals(Constants.W) || paramName.equals(Constants.ACT)){continue;}

      temp = Utilities.cleanInput(req.getParameter(paramName));
      System.out.println("value : "+temp);
      
      if(!Utilities.isEmpy(temp)){
        bn = new CompanyBean();
        bn.setParam(paramName);
        bn.setValue(temp);
        
        abn.add(bn);
      }
    }
   
    CompanyBean[] result = null;
    
    if(null!=abn && abn.size() > 0){
      result = abn.toArray(new CompanyBean[abn.size()]);
    }
    
    return result;
  }
  

  
  public CompanyBean[] getAllCompanySetting(){
    CompanyBean[] lists = null;
    
    SQL = " SELECT * FROM " + CoreTable.TABLE_COMPANY;
    System.out.println(SQL);
    try
    {
      super.getConnection();
      rs =  super.executeQuery(SQL);
      int row = super.getTotalRow();
      
      if(row<=0) return null;
      
      lists = new CompanyBean[row];
      if(null!=rs)
      {
        for(int i=0; i<row; i++)
        {
          rs.next();
          lists[i] = new CompanyBean();
          lists[i].setParam(rs.getString(CoreTable.COL_COMPANY_PARAM));
          lists[i].setValue(rs.getString(CoreTable.COL_COMPANY_VALUE));
        }
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    
    return lists;
  }

  public boolean createCompanySetting(CompanyBean[] cbn)
  {
    boolean res = false;
    CompanyPool cp = CompanyPool.getInstance();
    try
    {
      SQL = " INSERT INTO " + CoreTable.TABLE_COMPANY +
            "(" +
            CoreTable.COL_COMPANY_PARAM + "," +
            CoreTable.COL_COMPANY_VALUE + 
             ")" +
            " VALUES(?,?) ON DUPLICATE KEY UPDATE " +   
            CoreTable.COL_COMPANY_VALUE + "=?;";
      
      super.getConnection();
      stat = con.prepareStatement(SQL);
      
      if(null!=cbn && cbn.length > 0){
        for(int i=0; i<cbn.length;i++){
          stat.setString(1, cbn[i].getParam());
          stat.setString(2, cbn[i].getValue());
          stat.setString(3, cbn[i].getValue());
          
          if(stat.executeUpdate()>0){
            cp.put(cbn[i].getParam(), cbn[i]);
          }
        }
      }
      
      res = true;
      
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
