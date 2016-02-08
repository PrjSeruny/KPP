package com.sync.master.engine;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sync.core.engine.ConnectionDB;


public class MasterRegionEngine extends ConnectionDB
{
  private HttpServletRequest req;
  private HttpServletResponse res;
  
  public MasterRegionEngine(){}
  
  public MasterRegionEngine(Connection conn)
  { super(conn); }
  
  public MasterRegionEngine(HttpServletRequest rq, HttpServletResponse rs)
  {
    req=rq;
    res=rs;
  }
}