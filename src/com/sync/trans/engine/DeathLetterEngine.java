package com.sync.trans.engine;

import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sync.core.beans.MessageBean;
import com.sync.core.engine.RootEngine;
import com.sync.core.utils.Utilities;
import com.sync.master.beans.MasterResidentBean;
import com.sync.master.beans.MasterUserBean;
import com.sync.master.engine.MasterResidentEngine;
import com.sync.master.utils.MasterConstants;
import com.sync.trans.beans.DeathLetterBean;
import com.sync.trans.utils.TransConstants;
import com.sync.trans.utils.TransTable;



public class DeathLetterEngine extends RootEngine
{
  private MasterResidentEngine re = null;
  
  public DeathLetterEngine(HttpServletRequest rq, HttpServletResponse rs)
  {
    req=rq;
    res=rs;
  }
  
  public DeathLetterEngine(){}
  
  public DeathLetterBean validate()
  {
    MessageBean msg = new MessageBean();
    DeathLetterBean bn = new DeathLetterBean();
    bn.setBeanMessage(msg);
    String tmp = "";
    MasterResidentBean rbn = null;
    
    //NIK
    tmp = req.getParameter(TransConstants.FORM_TRANS_DEATHLETTER_NIK);
    if(Utilities.isEmpy(tmp))
    {
      msg.setMessageBean(TransConstants.FORM_TRANS_DEATHLETTER_NIK, 
          "Mohon Isi NIK terlebih dahulu");
    }
    else
    {
      re = new MasterResidentEngine();
      if(null==rbn || !rbn.getNIK().equals(tmp))
      { 
        rbn =  re.getMasterResidentInfo(tmp);
      }
      
      if(null==rbn)
      {
        System.out.println("NULL");
        msg.setMessageBean(TransConstants.FORM_TRANS_DEATHLETTER_NIK, 
            "NIK:"+tmp+ " belum terdaftar di Data Penduduk. Daftarkan terlebih dahulu");
      }
      else
      {
        System.out.println("NOT NULL");
      }
      bn.setNIK(tmp);
    }
    
    //Name
    tmp = req.getParameter(TransConstants.FORM_TRANS_DEATHLETTER_NAME);
    if(Utilities.isEmpy(tmp))
    {
      msg.setMessageBean(TransConstants.FORM_TRANS_DEATHLETTER_NAME, 
          "Mohon Isi Nama terlebih dahulu");
    }
    else
    {
      bn.setName(tmp);
    }
    
    //Death date
    tmp = req.getParameter(TransConstants.FORM_TRANS_DEATHLETTER_DEATHDATE);
    if(Utilities.isEmpy(tmp))
    {
      msg.setMessageBean(TransConstants.FORM_TRANS_DEATHLETTER_DEATHDATE, 
          "Mohon Isi tanggal kematian terlebih dahulu");
    }
    else
    {
      if(!Utilities.isValidDateFormat(MasterConstants.DATE_HTML_SHORT_PATTERN, 
          tmp))
      {
        msg.setMessageBean(TransConstants.FORM_TRANS_DEATHLETTER_DEATHDATE, 
            "Mohon masukkan Tanggal Kematian dengan benar");
      }
      Date dt = Utilities.stringToDate(tmp, 
          MasterConstants.DATE_HTML_SHORT_PATTERN);
      bn.setDeathDate(dt);
    }
    
    //Note
    tmp = req.getParameter(TransConstants.FORM_TRANS_DEATHLETTER_NOTE);
    bn.setNote(tmp);
    
    return bn;
  }
  
  public DeathLetterBean[] listOfLetter(String stat)
  {
    DeathLetterBean[] lists = null;
    int row = 0;
    String currPage = req.getParameter(MasterConstants.FORM_CURRENT_PAGE);
    String search = req.getParameter(MasterConstants.FORM_SEARCH_RECORD);
    String limit = req.getParameter(MasterConstants.FORM_LIMIT_RECORD);

    addSQL = " WHERE ";
    
    if(!Utilities.isEmpy(stat) && stat.equals(MasterConstants.DATA_ARCHIEVE))
    {
      addSQL += TransTable.COL_DEATHLETTER_VOIDDATE +
          " IS NOT NULL AND " + TransTable.COL_DEATHLETTER_VOIDUSER +
          " IS NOT NULL ";
    }
    else
    {
      addSQL += TransTable.COL_DEATHLETTER_VOIDDATE +
          " IS NULL AND " + TransTable.COL_DEATHLETTER_VOIDUSER +
          " IS NULL ";
    }
    
    if(!Utilities.isEmpy(search)){
      addSQL += "AND ("+TransTable.COL_DEATHLETTER_NAME+" LIKE '%"+search+"%' OR " +
          TransTable.COL_DEATHLETTER_NIK+" like '%"+search+"%')";
    }
    
    String pagination = buildPagination(TransTable.TABLE_DEATHLETTER, 
                                        (null==currPage?1:Integer.parseInt(currPage)), 
                                        (null==limit?MasterConstants.DEFAULT_LIMIT_RECORD:Integer.parseInt(limit)));
    req.setAttribute(MasterConstants.HTML_PAGINATION, pagination);
    
    SQL = " SELECT " +
          TransTable.TABLE_DEATHLETTER + ".* " +
          " FROM " + TransTable.TABLE_DEATHLETTER + addSQL + SQLlimit;
        
    try
    {
      super.getConnection();
      rs =  super.executeQuery(SQL);
      row = super.getTotalRow();
      
      if(row<=0) return null;
      
      lists = new DeathLetterBean[row];
      if(null!=rs)
      {
        for(int i=0; i<row; i++)
        {
          lists[i] = this.next();
        }
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    
    return lists;
  
  }
  
  public DeathLetterBean next() throws SQLException
  {
    DeathLetterBean bn = null;
    if(rs.next())
    {
      bn = new DeathLetterBean();
      bn.setNIK(rs.getString(TransTable.COL_DEATHLETTER_NIK));
      bn.setName(rs.getString(TransTable.COL_DEATHLETTER_NAME));
      bn.setDeathDate(Utilities.stringToDate(
          rs.getString(TransTable.COL_DEATHLETTER_DEATHDATE), 
          TransConstants.DATE_DB_SHORT_PATTERN));
      bn.setCreateDate(Utilities.stringToDate(
          rs.getString(TransTable.COL_DEATHLETTER_CREATEDATE), 
          TransConstants.DATE_DB_MEDIUM_PATTERN));
      bn.setCreateUser(rs.getString(TransTable.COL_DEATHLETTER_CREATEUSER));
      bn.setEntryDate(Utilities.stringToDate(
          rs.getString(TransTable.COL_DEATHLETTER_ENTRYDATE), 
          TransConstants.DATE_DB_MEDIUM_PATTERN));
      bn.setEntryUser(rs.getString(TransTable.COL_DEATHLETTER_ENTRYUSER));
      bn.setProcessDate(Utilities.stringToDate(
          rs.getString(TransTable.COL_DEATHLETTER_PROCESSDATE), 
          TransConstants.DATE_DB_MEDIUM_PATTERN));
      bn.setProcessUser(rs.getString(TransTable.COL_DEATHLETTER_PROCESSUSER));
      bn.setNote(rs.getString(TransTable.COL_DEATHLETTER_NOTE));
    }
    return bn;
  }
  
  public DeathLetterBean getDeathLetterInfo(String NIK)
  {
    DeathLetterBean bn = null;
    
    SQL = " SELECT " +
          TransTable.TABLE_DEATHLETTER + ".* " +
          " FROM " +
          TransTable.TABLE_DEATHLETTER +
          " WHERE " +
          TransTable.COL_DEATHLETTER_NIK + "='" + NIK + "';";
    
    try
    {
      super.getConnection();
      rs = super.executeQuery(SQL);
      
      if(null!=rs)
      {
        bn = this.next();
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
      bn = null;
    }
    return bn;
  }
  
  public boolean createDeathLetter(DeathLetterBean bn)
  {
    boolean res = false;
    HttpSession ses = req.getSession(false);
    MasterUserBean user = (MasterUserBean)ses.getAttribute(
        MasterConstants.MASTERUSER);
    
    try
    {
      SQL = " INSERT INTO " + TransTable.TABLE_DEATHLETTER +
            "(" +
                 TransTable.COL_DEATHLETTER_NIK + "," +
                 TransTable.COL_DEATHLETTER_NAME + "," +
                 TransTable.COL_DEATHLETTER_DEATHDATE + "," +
                 TransTable.COL_DEATHLETTER_CREATEDATE + "," +
                 TransTable.COL_DEATHLETTER_CREATEUSER + "," +
                 TransTable.COL_DEATHLETTER_NOTE +
            ")" +
            " VALUES(?,?,?,?,?,?);";
      
      super.getConnection();
      stat = con.prepareStatement(SQL);
      
      stat.setString(1, bn.getNIK());
      stat.setString(2, bn.getName());
      stat.setString(3, Utilities.dateToString(bn.getDeathDate(), 
          TransConstants.DATE_DB_SHORT_PATTERN));
      stat.setString(4, Utilities.dateToString(new Date(), 
          TransConstants.DATE_DB_SHORT_PATTERN));
      stat.setString(5, user.getUser());
      stat.setString(6, bn.getNote());
      
      if(stat.executeUpdate()>0) return true;
      else return false;
      
    }
    catch(Exception e)
    {
      super.rollback();
      e.printStackTrace();
      res = false;
    }
    return res;
  }
  
  
  public boolean updateDeathLetter(DeathLetterBean bn)
  {
    boolean res = false;
    HttpSession ses = req.getSession(false);
    MasterUserBean user = (MasterUserBean)ses.getAttribute(
        MasterConstants.MASTERUSER);
    
    try
    {
      SQL = " UPDATE " + TransTable.TABLE_DEATHLETTER + 
            " SET " +
            TransTable.COL_DEATHLETTER_DEATHDATE + "=?," +
            TransTable.COL_DEATHLETTER_NOTE + "=?, " +
            TransTable.COL_DEATHLETTER_ENTRYDATE + "=?, " +
            TransTable.COL_DEATHLETTER_ENTRYUSER + "=? " +
            " WHERE " +
            TransTable.COL_DEATHLETTER_NIK + "=?";
      
      super.getConnection();
      stat = con.prepareStatement(SQL);
      stat.setString(1, Utilities.dateToString(bn.getDeathDate(), 
          TransConstants.DATE_DB_SHORT_PATTERN));
      stat.setString(2, bn.getNote());
      stat.setString(3, Utilities.dateToString(new Date(), 
          TransConstants.DATE_DB_SHORT_PATTERN));
      stat.setString(4, user.getUser());
      stat.setString(5, bn.getNIK());
      
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
  
  
  public boolean updateStatusProcess(DeathLetterBean bn)
  {
    boolean res = false;
    
    try
    {
      SQL = " UPDATE " + TransTable.TABLE_DEATHLETTER + 
            " SET " +
            TransTable.COL_DEATHLETTER_PROCESSDATE + "=?, " +
            TransTable.COL_DEATHLETTER_PROCESSUSER + "=?, " +
            TransTable.COL_DEATHLETTER_CANCELPROCESSDATE + "=?, " +
            TransTable.COL_DEATHLETTER_CANCELPROCESSUSER + "=? " +
            " WHERE " +
            TransTable.COL_DEATHLETTER_NIK + "=?";
      
      super.getConnection();
      stat = con.prepareStatement(SQL);
      stat.setString(1, Utilities.dateToString(bn.getProcessDate(), 
          TransConstants.DATE_DB_SHORT_PATTERN));
      stat.setString(2, bn.getProcessUser());
      stat.setString(3, Utilities.dateToString(bn.getCancelProcessDate(), 
          TransConstants.DATE_DB_SHORT_PATTERN));
      stat.setString(4, bn.getCancelProcessUser());
      stat.setString(5, bn.getNIK());
      
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
  
  public boolean delete(String[] niks)
  {
    boolean res = false;
    HttpSession ses = req.getSession(false);
    MasterUserBean uses = (MasterUserBean)ses.getAttribute(
        MasterConstants.MASTERUSER);
    
    try
    {
      SQL = " UPDATE " + TransTable.TABLE_DEATHLETTER +
          " SET " +
          TransTable.COL_DEATHLETTER_VOIDDATE + "=?, " +
          TransTable.COL_DEATHLETTER_VOIDUSER + "=? " +
          " WHERE " +
          TransTable.COL_DEATHLETTER_NIK + "=?;";
    
    super.getConnection();
    stat = con.prepareStatement(SQL);
    
    for(int i=0; i<niks.length; i++)
    {
      stat.setString(1, Utilities.dateToString(new Date(), 
          MasterConstants.DATE_DB_MEDIUM_PATTERN));
      stat.setString(2, uses.getUser());
      stat.setString(3, niks[i]);
      stat.executeUpdate();
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
  
  
  public boolean proceedDeathLetter(DeathLetterBean bn, boolean cancelled)
  {
    boolean res = false;
    MasterResidentBean rebn = null;
    HttpSession ses = req.getSession(false);
    
    try
    {
      re = new MasterResidentEngine();
      rebn = re.getMasterResidentInfo(bn.getNIK());
      
      if(null==rebn || !rebn.getNIK().equals(bn.getNIK()))
      { 
        rebn =  re.getMasterResidentInfo(bn.getNIK());
      }
      
      if(null==rebn)
      {
        throw new Exception(
            "NIK:"+bn.getNIK()+ " belum terdaftar di Data Penduduk. "
                + "Daftarkan terlebih dahulu");
      }
      else
      {
        if(!cancelled)
        { rebn.setDeathDate(new Date()); }
        else { rebn.setDeathDate(null); }
        
        if(!re.updateDeathDate(rebn))
        {
          throw new Exception("Gagal Update status kematian");
        }
      }
      
      MasterUserBean user = (MasterUserBean)ses.getAttribute(
          MasterConstants.MASTERUSER);
      
      if(!cancelled)
      {
        bn.setProcessDate(new Date());
        bn.setProcessUser(user.getUser());
        bn.setCancelProcessDate(null);
        bn.setCancelProcessUser(null);
      }
      else
      {
        bn.setProcessDate(null);
        bn.setProcessUser(null);
        bn.setCancelProcessDate(new Date());
        bn.setCancelProcessUser(user.getUser());
      }
      
      if(!this.updateStatusProcess(bn))
      {
        throw new Exception("Gagal Update status process");
      }
      
      res = true;
    }
    catch(Exception e)
    {
      e.printStackTrace();
      super.rollback();
      res = false;
      MessageBean msg=new MessageBean();
      msg.setMessageBean(MessageBean.MSG_ERR, e.getMessage());
      bn.setBeanMessage(msg);
    }
    return res;
  }
  
  public void closed()
  {
    if(null!=re) re.closed();
    super.finalize();
  }
}