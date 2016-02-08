<%@page import="com.sync.core.utils.Constants,
               com.sync.master.beans.MasterUserBean,
               com.sync.master.utils.MasterConstants"
%>
<%
   MasterUserBean ubn = (MasterUserBean)session.getAttribute(MasterConstants.MASTERUSER);
%>
<html>
<body>
<table>
<tr><td>Selamat datang <%=null!=ubn?ubn.getName():"N/A"%></td></tr>
<tr><td><jsp:include page="<%=Constants.MENU_PAGE%>" flush="true"/></td></tr>
</table>
</body>
</html>