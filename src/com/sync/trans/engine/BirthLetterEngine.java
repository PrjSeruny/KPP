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
import com.sync.master.beans.MasterResidentHistoryBean;
import com.sync.master.beans.MasterUserBean;
import com.sync.master.engine.MasterResidentEngine;
import com.sync.master.engine.MasterResidentHistoryEngine;
import com.sync.master.utils.MasterConstants;
import com.sync.trans.beans.BirthLetterBean;
import com.sync.trans.utils.TransConstants;
import com.sync.trans.utils.TransTable;



public class BirthLetterEngine extends RootEngine
{
  private MasterResidentEngine re = null;
  private MasterResidentHistoryEngine rehist = null;
  
  public BirthLetterEngine(HttpServletRequest rq, HttpServletResponse rs)
  {
    req=rq;
    res=rs;
  }
  
  public BirthLetterEngine(){}
  
  public BirthLetterBean validate()
  {
    MessageBean msg = new MessageBean();
    BirthLetterBean bn = new BirthLetterBean();
    bn.setBeanMessages(msg);
    String tmp = "";
    MasterResidentBean rbn = null;
    
    //NIK
    tmp = req.getParameter(TransConstants.FORM_TRANS_BIRTHLETTER_NIK);
    if(Utilities.isEmpy(tmp))
    {
      msg.setMessageBean(TransConstants.FORM_TRANS_BIRTHLETTER_NIK, 
          "Mohon Isi NIK terlebih dahulu");
    }
    else
    {
      bn.setNIK(tmp);
    }
    
    //KKNo
    tmp = req.getParameter(TransConstants.FORM_TRANS_BIRTHLETTER_KKNO);
    if(Utilities.isEmpy(tmp))
    {
      msg.setMessageBean(TransConstants.FORM_TRANS_BIRTHLETTER_KKNO, 
          "Mohon Isi No.KK terlebih dahulu");
    }
    else
    {
      bn.setKKNo(tmp);
    }
    
    //Name
    tmp = req.getParameter(TransConstants.FORM_TRANS_BIRTHLETTER_NAME);
    if(Utilities.isEmpy(tmp))
    {
      msg.setMessageBean(TransConstants.FORM_TRANS_BIRTHLETTER_NAME, 
          "Mohon Isi Nama terlebih dahulu");
    }
    else
    {
      bn.setName(tmp);
    }
    
    //Birth date
    tmp = req.getParameter(TransConstants.FORM_TRANS_BIRTHLETTER_BIRTHDATE);
    if(Utilities.isEmpy(tmp))
    {
      msg.setMessageBean(TransConstants.FORM_TRANS_BIRTHLETTER_BIRTHDATE, 
          "Mohon Isi tanggal kelahiran terlebih dahulu");
    }
    else
    {
      if(!Utilities.isValidDateFormat(MasterConstants.DATE_HTML_SHORT_PATTERN, 
          tmp))
      {
        msg.setMessageBean(TransConstants.FORM_TRANS_BIRTHLETTER_BIRTHDATE, 
            "Mohon masukkan Tanggal kelahiran dengan benar");
      }
      Date dt = Utilities.stringToDate(tmp, 
          MasterConstants.DATE_HTML_SHORT_PATTERN);
      bn.setBirthDate(dt);
    }
    
    //Father NIK
    tmp = req.getParameter(TransConstants.FORM_TRANS_BIRTHLETTER_FATHERNIK);
    if(Utilities.isEmpy(tmp))
    {
      msg.setMessageBean(TransConstants.FORM_TRANS_BIRTHLETTER_FATHERNIK, 
          "Mohon Isi NIK Ayah terlebih dahulu");
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
        msg.setMessageBean(TransConstants.FORM_TRANS_BIRTHLETTER_FATHERNIK, 
            "NIK Ayah:"+tmp+ " belum terdaftar di Data Penduduk. Daftarkan terlebih dahulu");
      }
      else
      {
        System.out.println("NOT NULL");
      }
      bn.setFatherNIK(tmp);
    }
    
    //Father Name
    tmp = req.getParameter(TransConstants.FORM_TRANS_BIRTHLETTER_FATHERNAME);
    if(Utilities.isEmpy(tmp))
    {
      msg.setMessageBean(TransConstants.FORM_TRANS_BIRTHLETTER_FATHERNAME, 
          "Mohon Isi nama Ayah terlebih dahulu");
    }
    else
    {
      bn.setFatherName(tmp);
    }
    
    //Mother NIK
    tmp = req.getParameter(TransConstants.FORM_TRANS_BIRTHLETTER_MOTHERNIK);
    if(Utilities.isEmpy(tmp))
    {
      msg.setMessageBean(TransConstants.FORM_TRANS_BIRTHLETTER_MOTHERNIK, 
          "Mohon Isi NIK Ibu terlebih dahulu");
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
        msg.setMessageBean(TransConstants.FORM_TRANS_BIRTHLETTER_MOTHERNIK, 
            "NIK Ibu:"+tmp+ " belum terdaftar di Data Penduduk. Daftarkan terlebih dahulu");
      }
      else
      {
        System.out.println("NOT NULL");
      }
      bn.setMotherNIK(tmp);
    }
    
    //Mother Name
    tmp = req.getParameter(TransConstants.FORM_TRANS_BIRTHLETTER_MOTHERNAME);
    if(Utilities.isEmpy(tmp))
    {
      msg.setMessageBean(TransConstants.FORM_TRANS_BIRTHLETTER_MOTHERNAME, 
          "Mohon Isi nama ibu terlebih dahulu");
    }
    else
    {
      bn.setMotherName(tmp);
    }
    
    //Note
    tmp = req.getParameter(TransConstants.FORM_TRANS_BIRTHLETTER_NOTE);
    bn.setNote(tmp);
    
    return bn;
  }
  
  public BirthLetterBean[] listOfLetter(String stat)
  {
    BirthLetterBean[] lists = null;
    int row = 0;
    String currPage = req.getParameter(MasterConstants.FORM_CURRENT_PAGE);
    String search = req.getParameter(MasterConstants.FORM_SEARCH_RECORD);
    String limit = req.getParameter(MasterConstants.FORM_LIMIT_RECORD);

    addSQL = " WHERE ";
    
    if(!Utilities.isEmpy(stat) && stat.equals(MasterConstants.DATA_ARCHIEVE))
    {
      addSQL += TransTable.COL_BIRTHLETTER_PROCESSDATE +
          " IS NOT NULL AND " + TransTable.COL_BIRTHLETTER_PROCESSUSER +
          " IS NOT NULL " +
          " AND " + TransTable.COL_BIRTHLETTER_CANCELPROCESSDATE + " IS NULL " +
          " AND " + TransTable.COL_BIRTHLETTER_CANCELPROCESSUSER + " IS NULL ";
    }
    /*else if(!Utilities.isEmpy(stat) && stat.equals(MasterConstants.DATA_RECYCLE))
    {
      addSQL += TransTable.COL_BIRTHLETTER_VOIDDATE +
          " IS NOT NULL AND " + TransTable.COL_BIRTHLETTER_VOIDDATE +
          " IS NOT NULL "+
          " AND " + TransTable.COL_BIRTHLETTER_PROCESSDATE + " IS NULL " +
          " AND " + TransTable.COL_BIRTHLETTER_PROCESSUSER + " IS NULL ";
    }*/
    else
    {
      addSQL += TransTable.COL_BIRTHLETTER_PROCESSDATE + " IS NULL " +
          " AND " + TransTable.COL_BIRTHLETTER_PROCESSUSER + " IS NULL ";
    }
    
    if(!Utilities.isEmpy(search)){
      addSQL += "AND ("+TransTable.COL_BIRTHLETTER_NAME +" LIKE '%"+search+"%' OR " +
          TransTable.COL_BIRTHLETTER_NIK +" like '%"+search+"%')";
    }
    
    String pagination = buildPagination(TransTable.TABLE_BIRTHLETTER, 
                                        (null==currPage?1:Integer.parseInt(currPage)), 
                                        (null==limit?MasterConstants.DEFAULT_LIMIT_RECORD:
                                          Integer.parseInt(limit)));
    req.setAttribute(MasterConstants.HTML_PAGINATION, pagination);
    
    SQL = " SELECT " +
          TransTable.TABLE_BIRTHLETTER + ".* " +
          " FROM " + TransTable.TABLE_BIRTHLETTER + addSQL + SQLlimit;
        
    try
    {
      super.getConnection();
      rs =  super.executeQuery(SQL);
      row = super.getTotalRow();
      
      if(row<=0) return null;
      
      lists = new BirthLetterBean[row];
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
  
  public BirthLetterBean next() throws SQLException
  {
    BirthLetterBean bn = null;
    if(rs.next())
    {
      bn = new BirthLetterBean();
      bn.setNIK(rs.getString(TransTable.COL_BIRTHLETTER_NIK));
      bn.setName(rs.getString(TransTable.COL_BIRTHLETTER_NAME));
      bn.setKKNo(rs.getString(TransTable.COL_BIRTHLETTER_KKNO));
      bn.setBirthDate(Utilities.stringToDate(
          rs.getString(TransTable.COL_BIRTHLETTER_BIRTHDATE), 
          TransConstants.DATE_DB_SHORT_PATTERN));
      bn.setFatherNIK(rs.getString(TransTable.COL_BIRTHLETTER_FATHERNIK));
      bn.setFatherName(rs.getString(TransTable.COL_BIRTHLETTER_FATHERNAME));
      bn.setMotherNIK(rs.getString(TransTable.COL_BIRTHLETTER_MOTHERNIK));
      bn.setMotherName(rs.getString(TransTable.COL_BIRTHLETTER_MOTHERNAME));
      bn.setCreateDate(Utilities.stringToDate(
          rs.getString(TransTable.COL_BIRTHLETTER_CREATEDATE), 
          TransConstants.DATE_DB_MEDIUM_PATTERN));
      bn.setCreateUser(rs.getString(TransTable.COL_BIRTHLETTER_CREATEUSER));
      bn.setEntryDate(Utilities.stringToDate(
          rs.getString(TransTable.COL_BIRTHLETTER_ENTRYDATE), 
          TransConstants.DATE_DB_MEDIUM_PATTERN));
      bn.setEntryUser(rs.getString(TransTable.COL_BIRTHLETTER_ENTRYUSER));
      bn.setProcessDate(Utilities.stringToDate(
          rs.getString(TransTable.COL_BIRTHLETTER_PROCESSDATE), 
          TransConstants.DATE_DB_MEDIUM_PATTERN));
      bn.setProcessUser(rs.getString(TransTable.COL_BIRTHLETTER_PROCESSUSER));
      bn.setCancelProcessDate(Utilities.stringToDate(
          rs.getString(TransTable.COL_BIRTHLETTER_CANCELPROCESSDATE), 
          TransConstants.DATE_DB_MEDIUM_PATTERN));
      bn.setCancelProcessUser(
          rs.getString(TransTable.COL_BIRTHLETTER_CANCELPROCESSUSER));
      bn.setNote(rs.getString(TransTable.COL_BIRTHLETTER_NOTE));
    }
    return bn;
  }
  
  public BirthLetterBean getBirthLetterInfo(String NIK)
  {
    BirthLetterBean bn = null;
    
    SQL = " SELECT " +
          TransTable.TABLE_BIRTHLETTER + ".* " +
          " FROM " +
          TransTable.TABLE_BIRTHLETTER +
          " WHERE " +
          TransTable.COL_BIRTHLETTER_NIK + "='" + NIK + "';";
    
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
  
  public boolean createBirthLetter(BirthLetterBean bn)
  {
    boolean res = false;
    HttpSession ses = req.getSession(false);
    MasterUserBean user = (MasterUserBean)ses.getAttribute(
        MasterConstants.MASTERUSER);
    
    try
    {
      SQL = " INSERT INTO " + TransTable.TABLE_BIRTHLETTER +
            "(" +
                 TransTable.COL_BIRTHLETTER_NIK + "," +
                 TransTable.COL_BIRTHLETTER_KKNO + "," +
                 TransTable.COL_BIRTHLETTER_NAME + "," +
                 TransTable.COL_BIRTHLETTER_BIRTHDATE + "," +
                 TransTable.COL_BIRTHLETTER_FATHERNIK + "," +
                 TransTable.COL_BIRTHLETTER_FATHERNAME + "," +
                 TransTable.COL_BIRTHLETTER_MOTHERNIK + "," +
                 TransTable.COL_BIRTHLETTER_MOTHERNAME + "," +
                 TransTable.COL_BIRTHLETTER_CREATEDATE + "," +
                 TransTable.COL_BIRTHLETTER_CREATEUSER + "," +
                 TransTable.COL_BIRTHLETTER_NOTE +
            ")" +
            " VALUES(?,?,?,?,?,?,?,?,?,?,?);";
      
      super.getConnection();
      stat = con.prepareStatement(SQL);
      
      stat.setString(1, bn.getNIK());
      stat.setString(2, bn.getKKNo());
      stat.setString(3, bn.getName());
      stat.setString(4, Utilities.dateToString(bn.getBirthDate(), 
          TransConstants.DATE_DB_SHORT_PATTERN));
      stat.setString(5, bn.getFatherNIK());
      stat.setString(6, bn.getFatherName());
      stat.setString(7, bn.getMotherNIK());
      stat.setString(8, bn.getMotherName());
      stat.setString(9, Utilities.dateToString(new Date(), 
          TransConstants.DATE_DB_MEDIUM_PATTERN));
      stat.setString(10, user.getUser());
      stat.setString(11, bn.getNote());
      
      if(stat.executeUpdate()>0) return true;
      else return false;
      
    }
    catch(Exception e)
    {
      super.rollback();
      e.printStackTrace();
      res = false;
      MessageBean msg = new MessageBean();
      msg.setMessageBean(MessageBean.MSG_ERR, e.getMessage());
      bn.setBeanMessages(msg);
    }
    return res;
  }
  
  
  public boolean updateBirthLetter(BirthLetterBean bn)
  {
    boolean res = false;
    HttpSession ses = req.getSession(false);
    MasterUserBean user = (MasterUserBean)ses.getAttribute(
        MasterConstants.MASTERUSER);
    
    try
    {
      SQL = " UPDATE " + TransTable.TABLE_BIRTHLETTER + 
            " SET " +
            TransTable.COL_BIRTHLETTER_KKNO + "=?," +
            TransTable.COL_BIRTHLETTER_NAME + "=?," +
            TransTable.COL_BIRTHLETTER_BIRTHDATE + "=?," +
            TransTable.COL_BIRTHLETTER_FATHERNIK + "=?," +
            TransTable.COL_BIRTHLETTER_FATHERNAME + "=?," +
            TransTable.COL_BIRTHLETTER_MOTHERNIK + "=?," +
            TransTable.COL_BIRTHLETTER_MOTHERNAME + "=?," +
            TransTable.COL_BIRTHLETTER_NOTE + "=?, " +
            TransTable.COL_BIRTHLETTER_ENTRYDATE + "=?, " +
            TransTable.COL_BIRTHLETTER_ENTRYUSER + "=? " +
            " WHERE " +
            TransTable.COL_BIRTHLETTER_NIK + "=?";
      
      super.getConnection();
      stat = con.prepareStatement(SQL);
      stat.setString(1, bn.getKKNo());
      stat.setString(2, bn.getName());
      stat.setString(3, Utilities.dateToString(bn.getBirthDate(), 
          TransConstants.DATE_DB_SHORT_PATTERN));
      stat.setString(4, bn.getFatherNIK());
      stat.setString(5, bn.getFatherName());
      stat.setString(6, bn.getMotherNIK());
      stat.setString(7, bn.getMotherName());
      stat.setString(8, bn.getNote());
      stat.setString(9, Utilities.dateToString(new Date(), 
          TransConstants.DATE_DB_MEDIUM_PATTERN));
      stat.setString(10, user.getUser());
      stat.setString(11, bn.getNIK());
      
      if(stat.executeUpdate()>0) return true;
      else return false;
      
    }
    catch(Exception e)
    {
      e.printStackTrace();
      super.rollback();
      res = false;
      MessageBean msg = new MessageBean();
      msg.setMessageBean(MessageBean.MSG_ERR, e.getMessage());
      bn.setBeanMessages(msg);
    }
    
    return res;
  }
  
  
  public boolean updateStatusProcess(BirthLetterBean bn)
  {
    boolean res = false;
    
    try
    {
      SQL = " UPDATE " + TransTable.TABLE_BIRTHLETTER + 
            " SET " +
            TransTable.COL_BIRTHLETTER_PROCESSDATE + "=?, " +
            TransTable.COL_BIRTHLETTER_PROCESSUSER + "=?, " +
            TransTable.COL_BIRTHLETTER_CANCELPROCESSDATE + "=?, " +
            TransTable.COL_BIRTHLETTER_CANCELPROCESSUSER + "=? " +
            " WHERE " +
            TransTable.COL_BIRTHLETTER_NIK + "=?";
      
      super.getConnection();
      stat = con.prepareStatement(SQL);
      stat.setString(1, Utilities.dateToString(bn.getProcessDate(), 
          TransConstants.DATE_DB_MEDIUM_PATTERN));
      stat.setString(2, bn.getProcessUser());
      stat.setString(3, Utilities.dateToString(bn.getCancelProcessDate(), 
          TransConstants.DATE_DB_MEDIUM_PATTERN));
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
      MessageBean msg = new MessageBean();
      msg.setMessageBean(MessageBean.MSG_ERR, e.getMessage());
      bn.setBeanMessages(msg);
    }
    
    return res;
  }
  
  public boolean delete(String[] niks)
  {
    boolean res = false;
    
    try
    {
      SQL = " DELETE FROM " + TransTable.TABLE_BIRTHLETTER +
          " WHERE " +
          TransTable.COL_BIRTHLETTER_NIK + "=?;";
    
    super.getConnection();
    stat = con.prepareStatement(SQL);
    
    for(int i=0; i<niks.length; i++)
    {
      stat.setString(1, niks[i]);
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
  
  
  public boolean proceedBirthLetter(BirthLetterBean bn, boolean cancelled)
  {
    boolean res = false;
    HttpSession ses = req.getSession(false);
    String errMsg = null;
    try
    {
      
      MasterUserBean user = (MasterUserBean)ses.getAttribute(
          MasterConstants.MASTERUSER);
      
      if(!cancelled)
      {
          bn.setProcessDate(new Date());
          bn.setProcessUser(user.getUser());
          bn.setCancelProcessDate(null);
          bn.setCancelProcessUser(null);
          //this.proceedResidentHistory(bn, false);
      }
      else
      {
        bn.setProcessDate(null);
        bn.setProcessUser(null);
        bn.setCancelProcessDate(new Date());
        bn.setCancelProcessUser(user.getUser());
      }
      
      if(Utilities.isEmpy(errMsg))
      {
        if(!this.updateStatusProcess(bn))
        {
          throw new Exception("Gagal Update status process");
        }
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
      bn.setBeanMessages(msg);
    }
    return res;
  }
  
  private String proceedResidentHistory(BirthLetterBean bn, boolean cancel)
  {
    System.out.println("PROCEED RESIDENT HISTORY!!!!!!!");
    MasterResidentBean rebn = null;
    String errMsg = null;
    MasterResidentBean newrebn = null;
    MasterResidentHistoryBean hisrebn = null;
    HttpSession ses = req.getSession(false);
    
    try
    {
      MasterUserBean user = (MasterUserBean)ses.getAttribute(
          MasterConstants.MASTERUSER);
      
      if(!cancel)
      {
        /** Mencari detail data berdasarkan NIK ayah */
        re = new MasterResidentEngine();
        rebn = re.getMasterResidentInfo(bn.getFatherNIK());
        
        if(null==rebn || !rebn.getNIK().equals(bn.getFatherNIK()))
        { 
          rebn =  re.getMasterResidentInfo(bn.getFatherNIK());
        }
        
        if(null==rebn)
        {
          throw new Exception(
              "NIK Ayah:"+bn.getNIK()+ " belum terdaftar di Data Penduduk. "
                  + "Daftarkan terlebih dahulu");
        }
        else
        {
          /** inserting into master resident **/
          newrebn = new MasterResidentBean();
          newrebn.setNIK(bn.getNIK());
          newrebn.setName(bn.getName());
          newrebn.setKKNo(bn.getKKNo());
          newrebn.setBirthDate(bn.getBirthDate());
          newrebn.setReligion(rebn.getReligion());
          newrebn.setMaritalStatus(TransConstants.MARITALSTAT_SINGLE);
          newrebn.setFamilyPos(TransConstants.FAMILY_POS_CHILD);
          newrebn.setNationality(rebn.getNationality());
          newrebn.setAddress(rebn.getAddress());
          newrebn.setCity(rebn.getCity());
          newrebn.setRegion(rebn.getRegion());
          newrebn.setPostalCode(rebn.getPostalCode());
          newrebn.setKelurahan(rebn.getKelurahan());
          newrebn.setKecamatan(rebn.getKecamatan());
          newrebn.SetRW(rebn.getRW());
          newrebn.setRT(rebn.getRT());
          newrebn.setCreateDate(new Date());
          newrebn.setCreateUser(user.getUser());
          super.getConnection();
          re = new MasterResidentEngine();
          if(!re.createMasterResident(newrebn))
          {
            throw new Exception("Error: Gagal membuat data master penduduk");
          }
          
          /** inserting into master resident history */
          hisrebn = new MasterResidentHistoryBean();
          hisrebn.setNIK(bn.getNIK());
          hisrebn.setName(bn.getName());
          hisrebn.setKKNo(bn.getKKNo());
          hisrebn.setReligion(rebn.getReligion());
          hisrebn.setMaritalStatus(TransConstants.MARITALSTAT_SINGLE);
          hisrebn.setFamilyPos(TransConstants.FAMILY_POS_CHILD);
          hisrebn.setNationality(rebn.getNationality());
          hisrebn.setAddress(rebn.getAddress());
          hisrebn.setCity(rebn.getCity());
          hisrebn.setRegion(rebn.getRegion());
          hisrebn.setPostalCode(rebn.getPostalCode());
          hisrebn.setKelurahan(rebn.getKelurahan());
          hisrebn.setKecamatan(rebn.getKecamatan());
          hisrebn.SetRW(rebn.getRW());
          hisrebn.setRT(rebn.getRT());
          hisrebn.setEntryDate(new Date());
          hisrebn.setEntryUser(user.getUser());
          super.getConnection();
          rehist = new MasterResidentHistoryEngine();
          if(!rehist.createMasterResidentHistory(hisrebn))
          {
            throw new Exception("Error: Gagal membuat history data master penduduk");
          }
          
        }
      }
      else
      {
        
      }
      
    }
    catch(Exception e)
    {
      super.rollback();
      errMsg = e.getMessage();
    }
    
    return errMsg;
  }
  

  
  public void closed()
  {
    if(null!=re) re.closed();
    if(null!=rehist) rehist.closed();
    
    super.finalize();
  }
}