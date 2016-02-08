package com.sync.core.engine;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.sync.core.prop.CoreProperties;
import com.sync.core.utils.Constants;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


public class ConnectionManager
{
  //private String dbDriver="com.mysql.jdbc.Driver";
  //private String dbPath="jdbc:mysql://localhost:3306/ninku";
  private String user = CoreProperties.DB_USER;
  private String pass = CoreProperties.DB_PWD;
  private String dbDriver;
  private String dbPath;
  
  private HikariConfig hkrCfg;
  private HikariDataSource cpool;
  private static ConnectionManager a = new ConnectionManager();
  
  private ConnectionManager(){}
  
  public final static synchronized ConnectionManager getInstance(){ return a; }
  
  /**
   * initialize hikari connection pool
   */
  public void initDB() throws Exception
  {
    try
    {
      Properties prop = new Properties();
      InputStream input = null;
      input = new FileInputStream(
          "C:/Tech/Apache/Tomcat/webapps/simorg/WEB-INF/initf/db.init");
      prop.load(input);
      // get the property value and print it out
      dbDriver = prop.getProperty(Constants.DBDRIVER);
      dbPath = prop.getProperty(Constants.DBPATH);

      hkrCfg = new HikariConfig();
      //Must have params
      hkrCfg.setDriverClassName(dbDriver);
      hkrCfg.setJdbcUrl(dbPath);
      hkrCfg.setUsername(user);
      hkrCfg.setPassword(pass);
      hkrCfg.setAutoCommit(false);
      
      //Optional Params
      hkrCfg.setMinimumIdle(20);
      hkrCfg.setMaximumPoolSize(50);
      hkrCfg.setConnectionTimeout(30000);
      hkrCfg.setIdleTimeout(600000);
      hkrCfg.setMaxLifetime(1800000);
      
      //Initializing the Hikari DB Pool
      cpool = new HikariDataSource(hkrCfg);
    }
    catch(Exception e)
    {
      e.printStackTrace();
      this.finalize();
      throw e;
    }
  }
  
  /** Getting Connection */
  public Connection getConnection()
  { 
    try
    { 
      if(cpool==null)
      {
        System.out.println("CONNECTION POOL IS NULL CON NULLLLLLL");
      }
      
      return cpool.getConnection(); 
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    
    return null;
  }
  
  /** Return connection */
  private void returnConnection(Connection returns)
  {
    try
    {
      if(!returns.isClosed()) 
      {
        returns.clearWarnings();
        returns.close();
      }
    }
    catch(SQLException e)
    { 
      e.printStackTrace();
    }
    finally
    {
      returns = null;
    }
  }
  
  /** Returns the connection from connection manager */
  public void returnDefaultConnection
  (
    Connection conn
  )
  throws NullPointerException
  { 
    this.returnConnection(conn);
    
    try
    { 
      if(null!=conn) conn.close();
      conn = null;
    }
    catch(SQLException e)
    {
      e.printStackTrace();
      System.out.println(
          "WARNING: Error manual connection close:" + e.getMessage());
    }
  }
  
  /** Clear all after finish */
 public void finalize()
 {
   cpool.close();

   try
   { super.finalize(); }
   catch(Throwable e)
   { e.printStackTrace(); }
 }
 
}