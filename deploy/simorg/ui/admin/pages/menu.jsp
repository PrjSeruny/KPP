<%@page import="com.sync.master.utils.MasterConstants"%>
<%@page import="com.sync.core.utils.Constants"%>
<html>
<body>
<table>
<tr><td>MASTER: </td></tr>
 <tr>
   <td><a href="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=Constants.W%>=<%=MasterConstants.MASTERUSER%>&<%=MasterConstants.ACT%>=<%=MasterConstants.ACT_LIST%>">Master User</a></td>
   <td><a href="#">Master Penduduk</a></td>
 </tr>
 <tr><td><a href="<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH%>?<%=Constants.D%>=<%=Constants.D_LOGOUT%>">Logout</a></td></tr>
</table>
</body>
</html>