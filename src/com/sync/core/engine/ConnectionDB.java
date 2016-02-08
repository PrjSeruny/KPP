package com.sync.core.engine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ConnectionDB
{
  protected Connection con;
  protected PreparedStatement stat;
  protected ResultSet rs;
  
  public ConnectionDB(){}
  
  /** Constructor that passes the DB Connection object */
  public ConnectionDB(Connection _conn)
  { con = _conn; }
  
  /** 
   * For getting the connection.
   * Always set the connection's auto commit to false. 
   */
  public Connection getConnection() 
  {
    try 
    { 
      if(null!=con && con.isClosed()) 
      { 
        System.out.println("CON ISCLOSED");
        con = ConnectionManager.getInstance().getConnection();
      }
    }
    catch(Exception e)
    { 
      e.printStackTrace();
      con = null;
    }
    
    if(null==con)
    {
      synchronized(this)
      { 
        if(null==con) 
        {
          System.out.println("CON IS NULL");
          con = ConnectionManager.getInstance().getConnection(); 
        }
      }
    }
    
    //Setting auto commit
    this.setAutoCommit(false);
    
    if(null!=con)
    {
      System.out.println("CONNECTED con DB");
    }
    else
    {
      System.out.println("FAILED con DB");
    }
    
    return con; 
  }
  
  /** Sets the autocommit Status. */
  public void setAutoCommit(boolean status)
  {
    System.out.println(">>>>>>>>>>>>>>> 1");
    if(null==con)
    {
      synchronized(this)
      {
        System.out.println(">>>>>>>>>>>>>>> 2");
        if(null==con) con = ConnectionManager.getInstance().getConnection();
        System.out.println(">>>>>>>>>>>>>>> 3");
      }
    }
    
    try
    {
      System.out.println(">>>>>>>>>>>>>>> 4 status= "+status);
      con.setAutoCommit(status);
      System.out.println(">>>>>>>>>>>>>>> 5");
    }
    catch (SQLException e)
    {
      //Error Setting autocommit
      e.printStackTrace();
      System.out.println(">>>>>>>>>>>>>>> 6 ewrr= "+e.getMessage());
    }    
  }
  
  
  /** Getting auto Commit status */
  public boolean getAutoCommit()
  {
    if(con==null) return false;
    
    try
    {
      return con.getAutoCommit();
    }
    catch(SQLException e)
    {
      e.printStackTrace();
    }
    return false;
  }
  
  
  /** Commit handler */
  public boolean commit()
  {
    try
    {
      if(!this.getAutoCommit())
      {
        con.commit();
      }
      return true;
    }
    catch(Exception e)
    {
      e.printStackTrace();
      return false;
    }
  }
  
  
  /** RollBack Transaction **/
  public boolean rollback()
  {
    try
    {
      con.rollback();
      return true;
    }
    catch(SQLException e)
    {
      e.printStackTrace();
      return false;
    }
  }

  /** For clearing garbage collector */
  public void clearMemory()
  {
    System.runFinalization();
    System.gc();
  }
  
  /** For execute query */
  public ResultSet executeQuery(String SQL) throws SQLException
  {
    stat = con.prepareStatement(SQL);
    rs = stat.executeQuery();
    return rs;
  }
  
  public int getTotalRow() throws SQLException
  {
    int row = 0;
    if(null!=rs)
    {
      rs.last();
      row = rs.getRow();
      rs.beforeFirst();
    }
    
    return row;
  }
  

  public void finalize()
  {
    if(null!=con) 
    {
      this.commit();
      
      try
      { if(!con.getAutoCommit()) con.setAutoCommit(true); }
      catch(Exception e)
      { 
        e.printStackTrace();
      }
      
      ConnectionManager.getInstance().returnDefaultConnection(con);
      
      try
      {
        con = null;
        if(null!=rs) rs.close();
        if(null!=stat) stat.close();
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
    }    
    
    this.clearMemory();
  }
  
}