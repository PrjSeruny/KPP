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
      <li class="home"><a href="javascript:void(0)" url="<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH%>?<%=Constants.W%>=<%=Constants.HOME_PRM%>">Home</a></li>
      <li class="public"><a href="javascript:void(0)">Public Setting</a>
          <ul>
          <li><a href="javascript:void(0)" url="<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH%>?<%=Constants.W%>=<%=Constants.SLIDE_SETTING_PRM%>">Gambar Slide</a></li>
          <li><a href="javascript:void(0)" url="<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH%>?<%=Constants.W%>=<%=Constants.COMPANY_SETTING_PRM%>">Kontak Setting</a></li>
          <li><a href="javascript:void(0)" url="<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH%>?<%=Constants.W%>=<%=Constants.PROFILE_SETTING_PRM%>">Profile</a></li>
          <li><a href="javascript:void(0)" url="<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH%>?<%=Constants.W%>=<%=Constants.GALLERY_SETTING_PRM%>">Gallery Foto</a></li>
          <li><a href="javascript:void(0)" url="<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH%>?<%=Constants.W%>=<%=Constants.NEWS_SETTING_PRM%>">Berita</a></li>
          </ul>
      </li> 
      <li class="master"><a href="javascript:void(0)">Master</a>
          <ul>
          <li><a href="javascript:void(0)" url="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=Constants.W%>=<%=MasterConstants.MASTERUSER%>">Master User</a></li>
          <li><a href="javascript:void(0)" url="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=Constants.W%>=<%=MasterConstants.MASTER_REGION%>">Master Region</a></li>
          <li><a href="javascript:void(0)" url="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=Constants.W%>=<%=MasterConstants.MASTER_RESIDENT%>&<%=MasterConstants.DATA_STAT%>=<%=MasterConstants.DATA_CURRENT%>">Master Penduduk</a></li>
          <li><a href="javascript:void(0)" url="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=Constants.W%>=<%=MasterConstants.MASTER_LEVEL_ACCESS%>">Master Level Access</a></li>
		  <li><a href="javascript:void(0)" url="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=Constants.W%>=<%=MasterConstants.LEVELACCESS%>">Level Access</a></li>
          </ul>
      </li> 
      <li class="process"><a href="javascript:void(0)">Transaksi</a>
          <ul>
          <li><a href="javascript:void(0)" url="<%=TransConstants.ROOT_PATH%><%=TransConstants.SVT_TRANS_PATH%>?<%=TransConstants.W%>=<%=TransConstants.TRANS_FAMILYCARDMUT%>&<%=TransConstants.DATA_STAT%>=<%=TransConstants.DATA_CURRENT%>">Mutasi KK</a></li>
          <li><a href="javascript:void(0)" url="<%=TransConstants.ROOT_PATH%><%=TransConstants.SVT_TRANS_PATH%>?<%=TransConstants.W%>=<%=TransConstants.TRANS_BIRTHLETTER%>&<%=TransConstants.DATA_STAT%>=<%=TransConstants.DATA_CURRENT%>">Data Kelahiran</a></li>
          <li><a href="javascript:void(0)" url="<%=TransConstants.ROOT_PATH%><%=TransConstants.SVT_TRANS_PATH%>?<%=TransConstants.W%>=<%=TransConstants.TRANS_DEATHLETTER%>&<%=TransConstants.DATA_STAT%>=<%=TransConstants.DATA_CURRENT%>">Data Kematian</a></li>
          </ul>
      </li>
      <li class="report"><a href="javascript:void(0)">Laporan</a>
          <ul>
          <li><a href="javascript:void(0)">Laporan Penduduk</a></li>
          </ul>
      </li>
      <li class="logout"><a href="<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH%>?<%=Constants.D%>=<%=Constants.D_LOGOUT%>">Logout</a></li>
  </ul>
</div>