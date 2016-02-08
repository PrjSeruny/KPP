<%@page import=" java.io.*,
               com.sync.core.utils.Constants,
               com.sync.master.utils.MasterConstants,
               com.sync.master.beans.MasterUserBean"
%>
<%
   MasterUserBean ubn = (MasterUserBean) request.getAttribute(MasterConstants.USER_INFO);
%>
<html>
<body>
<table>
<tr><td><jsp:include page="<%=Constants.HOME_PAGE%>" flush="true"/></td></tr>
<tr>
  <td>
    <form name="info" method="post" action="<%=MasterConstants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>">
    <input type="hidden" name="<%=MasterConstants.W%>" value="<%=MasterConstants.MASTERUSER%>">
    <input type="hidden" name="<%=MasterConstants.ACT%>" value="<%=MasterConstants.ACT_UPDATE%>">
    <input type="hidden" name="<%=MasterConstants.FORM_MASTERUSER_USERID%>" value="<%=ubn.getUser()%>">
     <table>
        <tr><td>Info User</td></tr>
        <tr>
          <td>
             <table border="1">
                <tr>
                  <td>UserID:</td>
                  <td><%=ubn.getUser()%></td>
                </tr>
                <tr>
                  <td>Nama:</td>
                  <td><%=ubn.getName()%></td>
                </tr>
             </table>
          </td>
        </tr>
     </table>
       <button type="submit" value="Ubah">Ubah</button>
       <button type="submit" name="<%=MasterConstants.BTN_DONE%>" value="<%=MasterConstants.BTN_DONE%>">Selesai</button>
     </form>
  </td>
</tr>
</table>