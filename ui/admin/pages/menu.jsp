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
      <li class="facebook"><a href="javascript:void(0)">Facebook</a>
          <ul>
          <li><a href="javascript:void(0)">Facebook Pages</a></li>
          <li><a href="javascript:void(0)">Facebook Groups</a></li>
          </ul>
      </li>
      <li class="google"><a href="javascript:void(0)">Google</a>
          <ul>
          <li><a href="javascript:void(0)">Google mail</a></li>
          <li><a href="javascript:void(0)">Google Plus</a></li>
          <li><a href="javascript:void(0)">Google Search &raquo;</a>
              <ul>
                  <li><a href="javascript:void(0)">Search Images</a></li>
                  <li><a href="javascript:void(0)">Search Web</a></li>
              </ul>
          </li>
          </ul>
      </li>
      <li class="twitter"><a href="<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH%>?<%=Constants.D%>=<%=Constants.D_LOGOUT%>">Logout</a></li>
    <!-- <li class="site-name"><a href="javascript:void(0)">&nbsp;</a></li> -->
  </ul>
</div>