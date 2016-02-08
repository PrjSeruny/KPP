package com.sync.master.engine;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sync.core.beans.MessageBean;
import com.sync.core.engine.RootEngine;
import com.sync.core.utils.Utilities;
import com.sync.master.beans.MasterUserBean;
import com.sync.master.utils.MasterConstants;
import com.sync.master.utils.MasterTable;


public class UserEngine extends RootEngine
{
  /*private HttpServletRequest req;
  private HttpServletResponse res;
  private String SQL = "";
  private String addSQL = "";
  private String SQLlimit = "";
  private ResultSet rs = null;
  private UserEngine u = null;*/
  private String username = null;
  private String passwd = null;
  
  public UserEngine(){}
  
 /* public UserEngine(Connection conn)
  { super(conn); }*/
  
  public UserEngine(HttpServletRequest rq, HttpServletResponse rs)
  {
    req=rq;
    res=rs;
  }
  
  /** Validating user login */
  public MasterUserBean validateLogin()
  {
    System.out.println("BEGINNING VALIDATE LOGIN");
    MessageBean msg = new MessageBean();
    MasterUserBean u = new MasterUserBean();
    
    username = req.getParameter(MasterConstants.FORM_LOGIN_USERNAME);
    if(!Utilities.isEmpy(username))
    {
      u.setUser(username);
    }
    passwd = req.getParameter(MasterConstants.FORM_LOGIN_PASSWD);
    
    System.out.println("USER="+username + " PASS= "+passwd);
    
    u = this.userValidate(username, passwd);
    if(null==u || Utilities.isEmpy(u.getUser()))
    {
      msg.setMessageBean(MasterConstants.FORM_LOGIN_PASSWD, 
          "Username atau Password Anda salah!!!");
      u = new MasterUserBean();
    }
    System.out.println("USER= "+u.getUser() + " NAME= "+u.getName());
    u.setMessageBean(msg);
    return u;
  }
  
  /** Validating creating master user */
  public MasterUserBean validate()
  {
    System.out.println("BEGINNING VALIDATE");
    MessageBean msg = new MessageBean();
    MasterUserBean u = new MasterUserBean();
    String act = req.getParameter(MasterConstants.ACT);
    String tamp = "";
    
    //UserID
    tamp = req.getParameter(MasterConstants.FORM_MASTERUSER_USERID);
    if(!Utilities.isEmpy(tamp))
    {
      if(tamp.indexOf(" ")>=0){
        msg.setMessageBean(MasterConstants.FORM_MASTERUSER_USERID, 
        "Tidak boleh memakai spasi");
      }
      u.setUser(tamp);
    }
    else
    {
      msg.setMessageBean(MasterConstants.FORM_MASTERUSER_USERID, 
          "Masukkan userID");
    }
    
    //Nama
    tamp = req.getParameter(MasterConstants.FORM_MASTERUSER_NAME);
    if(!Utilities.isEmpy(tamp))
    {
      u.setName(tamp);
    }
    else
    {
      msg.setMessageBean(MasterConstants.FORM_MASTERUSER_NAME, 
          "Masukkan Nama");
    }
    
    //Password
    tamp = req.getParameter(MasterConstants.FORM_MASTERUSER_PASSWD);
    if(!Utilities.isEmpy(tamp))
    {
      u.setPassword(tamp);
    }
    else
    {
      if(!Utilities.isEmpy(act) && act.equals(MasterConstants.ACT_UPDATE)){}
      else{
      msg.setMessageBean(MasterConstants.FORM_MASTERUSER_PASSWD, 
          "Masukkan Kata sandi");
      }
    }
    
    u.setMessageBean(msg);
    return u;
  }
  
  /** Validating user and password 
   *  process in database
   * */
  private MasterUserBean userValidate(String username, String pass)
  {
    MasterUserBean ubn = new MasterUserBean();
    /*u = new UserEngine(super.getConnection());*/
    
    try
    {
      SQL = " SELECT " +
           MasterTable.COL_USERLOGIN_ID + "," +
           MasterTable.COL_USERLOGIN_NAME +
          " FROM " + MasterTable.TABLE_USERLOGIN +
          " WHERE " + MasterTable.COL_USERLOGIN_ID + "='" +
          username + "' AND " + MasterTable.COL_USERLOGIN_PASSWD +
          "=SHA('" + pass + "');";
      
      super.getConnection();
      rs =  super.executeQuery(SQL);
      if(null!=rs)
      {
        rs.last();
        int row = rs.getRow();
        rs.beforeFirst();
        
        if(row<=0) return null;
        
        for(int i=0; i<row; i++)
        {
          rs.next();
          ubn.setUser(rs.getString(MasterTable.COL_USERLOGIN_ID));
          ubn.setName(rs.getString(MasterTable.COL_USERLOGIN_NAME));
        }
      }
      
    }
    catch(Exception e)
    {
      e.printStackTrace();
      ubn = null;
    }
    System.out.println("ubn "+ubn);
    return ubn;
  }
  
  /** Getting All Master User Data */
  public MasterUserBean[] listOfUsers()
  {
    MasterUserBean[] lists = null;
    int row = 0;
    String currPage = req.getParameter(MasterConstants.FORM_CURRENT_PAGE);
    String search = req.getParameter(MasterConstants.FORM_SEARCH_RECORD);
    String limit = req.getParameter(MasterConstants.FORM_LIMIT_RECORD);
    
    addSQL = " WHERE "+MasterTable.COL_USERLOGIN_VOIDDATE+" IS NULL AND " +
              MasterTable.COL_USERLOGIN_VOIDUSER+" IS NULL";
    
    if(!Utilities.isEmpy(search)){
      addSQL += " AND ("+MasterTable.COL_USERLOGIN_ID+" LIKE '%"+search+"%' OR " +
      		MasterTable.COL_USERLOGIN_NAME+" like '%"+search+"%')";
    }
    
    String pagination = buildPagination(MasterTable.TABLE_USERLOGIN, 
                                        (null==currPage?1:Integer.parseInt(currPage)), 
                                        (null==limit?MasterConstants.DEFAULT_LIMIT_RECORD:Integer.parseInt(limit)));
    req.setAttribute(MasterConstants.HTML_PAGINATION, pagination);
    
    SQL = " SELECT " +
          MasterTable.TABLE_USERLOGIN + ".* " +
          " FROM " + MasterTable.TABLE_USERLOGIN + addSQL + SQLlimit;
    System.out.println(SQL);
    try
    {
      super.getConnection();
      rs =  super.executeQuery(SQL);
      row = super.getTotalRow();
      
      if(row<=0) return null;
      
      lists = new MasterUserBean[row];
      if(null!=rs)
      {
        for(int i=0; i<row; i++)
        {
          rs.next();
          lists[i] = new MasterUserBean();
          lists[i].setUser(rs.getString(MasterTable.COL_USERLOGIN_ID));
          lists[i].setName(rs.getString(MasterTable.COL_USERLOGIN_NAME));
          lists[i].setCreateDate(Utilities.stringToDate(rs.getString(MasterTable.COL_USERLOGIN_CREATEDATE), MasterConstants.DATE_DB_MEDIUM_PATTERN));
          lists[i].setCreateUser(rs.getString(MasterTable.COL_USERLOGIN_CREATEUSER));
          lists[i].setEntryDate(Utilities.stringToDate(rs.getString(MasterTable.COL_USERLOGIN_ENTRYDATE), MasterConstants.DATE_DB_MEDIUM_PATTERN));
          lists[i].setEntryUser(rs.getString(MasterTable.COL_USERLOGIN_ENTRYUSER));
        }
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    
    return lists;
  }
  
  public MasterUserBean getMasterUserInfo(String userID)
  {
    MasterUserBean ubn = null;
    
    SQL = " SELECT " +
          MasterTable.TABLE_USERLOGIN + ".* " +
          " FROM " +
          MasterTable.TABLE_USERLOGIN + 
          " WHERE " +
          MasterTable.COL_USERLOGIN_ID + "='" + userID + "';";
    
    try
    {
      super.getConnection();
      rs = super.executeQuery(SQL);
      
      if(null!=rs)
      {
        rs.next();
        ubn = new MasterUserBean();
        ubn.setUser(rs.getString(MasterTable.COL_USERLOGIN_ID));
        ubn.setName(rs.getString(MasterTable.COL_USERLOGIN_NAME));
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
      ubn = null;
    }
    
    return ubn;
  }
  
  
  public boolean createMasterUser(MasterUserBean ubn)
  {
    boolean res = false;
    try
    {
      SQL = " INSERT INTO " + MasterTable.TABLE_USERLOGIN +
            "(" +
               MasterTable.COL_USERLOGIN_ID + "," +
               MasterTable.COL_USERLOGIN_NAME + "," +
               MasterTable.COL_USERLOGIN_PASSWD + "," +
               MasterTable.COL_USERLOGIN_CREATEDATE + "," +
               MasterTable.COL_USERLOGIN_CREATEUSER +
             ")" +
            " VALUES(?,?,SHA(?),?,?)";
      
      super.getConnection();
      stat = con.prepareStatement(SQL);
      stat.setString(1, ubn.getUser());
      stat.setString(2, ubn.getName());
      stat.setString(3, ubn.getPassword());
      stat.setString(4, Utilities.dateToString(new Date(), 
          MasterConstants.DATE_DB_MEDIUM_PATTERN));
      stat.setString(5, getUserInSession().getUser());
      
      System.out.println("INSERT USER INTO DATABASE "+stat);
      
      if(stat.executeUpdate()>0) return true;
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
  
  public boolean updateMasterUser(MasterUserBean ubn)
  {
    boolean res = false;
    try
    {
      SQL = " UPDATE " + MasterTable.TABLE_USERLOGIN +
            " SET " +
            MasterTable.COL_USERLOGIN_NAME + "=?, " +
            MasterTable.COL_USERLOGIN_ENTRYDATE + "=?, " +
            MasterTable.COL_USERLOGIN_ENTRYUSER + "=? " +
            " WHERE " +
            MasterTable.COL_USERLOGIN_ID + "=?;";
      
      super.getConnection();
      stat = con.prepareStatement(SQL);
      stat.setString(1, ubn.getName());
      stat.setString(2, Utilities.dateToString(new Date(), 
          MasterConstants.DATE_DB_MEDIUM_PATTERN));
      stat.setString(3, super.getUserInSession().getUser());
      stat.setString(4, ubn.getUser());
      
      if(stat.executeUpdate()>0) return true;
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

  public boolean deleteMasterUser()
  {
    boolean res = false;
    try
    {
      String users = "";
      String[] ids = req.getParameterValues(MasterConstants.FORM_MASTERUSER_USERID);
      System.out.println("array : "+ids.length);
      if(null!=ids && ids.length > 0){
        users = String.join("','",ids);
        System.out.println("array : "+users);
        
        SQL = "UPDATE "+ MasterTable.TABLE_USERLOGIN + " SET "+
        MasterTable.COL_USERLOGIN_VOIDDATE + "=?, " +
        MasterTable.COL_USERLOGIN_VOIDUSER + "=? " +
        " WHERE " +
        MasterTable.COL_USERLOGIN_ID + " IN('"+users+"');";
        
        super.getConnection();
        stat = con.prepareStatement(SQL);
        stat.setString(1, Utilities.dateToString(new Date(), 
            MasterConstants.DATE_DB_MEDIUM_PATTERN));
        stat.setString(2, super.getUserInSession().getUser());
        
        if(stat.executeUpdate()>0) return true;
        else return false;
      }
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