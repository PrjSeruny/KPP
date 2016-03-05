<%@page import="com.sync.trans.utils.TransConstants"%>
<%@page import="com.sync.master.utils.MasterConstants"%>
<%@page import="com.sync.core.utils.Constants"%>
<div id="nav-con">
  <div id="nav-open"></div>
  <div id="search">
    <input type="text" placeholder="Cari . . .">
    <a href="javascript:void(0)"></a>
  </div>
  <ul id="nav">
      <li class="yahoo"><a href="javascript:void(0)">Master</a>
          <ul>
          <li><a href="javascript:void(0)" url="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=Constants.W%>=<%=MasterConstants.MASTERUSER%>">Master User</a></li>
          <li><a href="javascript:void(0)" url="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=Constants.W%>=<%=MasterConstants.MASTER_REGION%>">Master Region</a></li>
          <li><a href="javascript:void(0)" url="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=Constants.W%>=<%=MasterConstants.MASTER_RESIDENT%>&<%=MasterConstants.DATA_STAT%>=<%=MasterConstants.DATA_CURRENT%>">Master Penduduk</a></li>
          </ul>
      </li> 
      <li class="facebook"><a href="javascript:void(0)">Transaksi</a>
          <ul>
          <li><a href="javascript:void(0)">Data KK Baru</a></li>
          <li><a href="javascript:void(0)">Data Kelahiran</a></li>
          <li><a href="javascript:void(0)" url="<%=TransConstants.ROOT_PATH%><%=TransConstants.SVT_TRANS_PATH%>?<%=TransConstants.W%>=<%=TransConstants.TRANS_DEATHLETTER%>&<%=TransConstants.DATA_STAT%>=<%=TransConstants.DATA_CURRENT%>">Data Kematian</a></li>
          </ul>
      </li>
      <li class="facebook"><a href="javascript:void(0)">Laporan</a>
          <ul>
          <li><a href="javascript:void(0)">Laporan Penduduk</a></li>
          </ul>
      </li>
      <li class="twitter"><a href="<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH%>?<%=Constants.D%>=<%=Constants.D_LOGOUT%>">Logout</a></li>
  </ul>
</div>