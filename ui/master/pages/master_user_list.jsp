<%@page import="java.util.Date"%>
<%@page import="com.sync.master.utils.MasterTable"%>
<%@page import=" java.io.*,
               com.sync.master.utils.MasterConstants,
               com.sync.core.beans.MessageBean,
               com.sync.core.utils.Utilities,
               com.sync.master.beans.MasterUserBean"
%>
<%
   String pagination = (String)request.getAttribute(MasterConstants.HTML_PAGINATION);
   String search = (String)request.getParameter(MasterConstants.FORM_SEARCH_RECORD);
   MasterUserBean[] list = (MasterUserBean[]) request.getAttribute(MasterConstants.USER_LIST);
   String type="";
   
%>
<fieldset>
  <div class="list-con">
  <a href="javascript:void(0)" class="reload" title="Refresh">Refresh</a>
  <a href="javascript:void(0)" class="delete" title="Hapus" style="<%=null!=list && list.length>0?"":"display:none" %>">Hapus</a>
  <div class="search">
    <input type="text" placeholder="Cari..." 
      name="<%=MasterConstants.FORM_SEARCH_RECORD%>" value="<%=!Utilities.isEmpy(search)?search:"" %>">
      <a href="javascript:void(0)"></a>
  </div>
      <table border="0" class="list-tb" width="100%">
        <tr>
          <th rowspan="2"><input type="checkbox" class="selAll userids" child="userid"></th>
          <th rowspan="2">Username</th>
          <th rowspan="2">Nama Lengkap</th>
          <th colspan="2">Dibuat</th>
          <th colspan="2">Terakhir Diubah</th>
        </tr>
        <tr>
          <th>Tanggal</th>
          <th>User Input</th>
          <th>Tanggal</th>
          <th>User Input</th>
        </tr>
  <%
     if(null!=list && list.length>0)
     {
        for(int i=0; i<list.length; i++)
        {
  %>
           <tr>
             <td align="center"><input class="selChild userid del" parent="userids" type="checkbox" name="<%=MasterConstants.FORM_MASTERUSER_USERID%>" value="<%=list[i].getUser()%>"></td>
             <td valign="top"><a href="<%=MasterConstants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=MasterConstants.W%>=<%=MasterConstants.MASTERUSER %>&<%=MasterConstants.ACT%>=<%=MasterConstants.ACT_UPDATE%>&<%=MasterConstants.FORM_MASTERUSER_USERID%>=<%=list[i].getUser()%>"><%=list[i].getUser()%></a></td>
             <td valign="top"><%=list[i].getName()%></td>
             <td valign="top"><%=Utilities.showStringValue(Utilities.dateToString(list[i].getCreateDate(),MasterConstants.DATE_HTML_MEDIUM_PATTERN))%></td>
             <td valign="top"><%=Utilities.showStringValue(list[i].getCreateUser())%></td>
             <td valign="top"><%=Utilities.showStringValue(Utilities.dateToString(list[i].getEntryDate(),MasterConstants.DATE_HTML_MEDIUM_PATTERN))%></td>
             <td valign="top"><%=Utilities.showStringValue(list[i].getEntryUser())%></td>
           </tr>
  <%        
        }
     }
     else
     {
  %>
           <tr>
             <td valign="top" align="center" colspan="7">Daftar User tidak ditemukan!</td>
           </tr>
  <%
     }
  %>     
    </table>
  </div>
</fieldset>
<%=pagination %>

<input type="hidden" name="<%=MasterConstants.ACT%>" value="<%=MasterConstants.ACT_LIST%>">