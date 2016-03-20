<%@page import="com.sync.master.beans.MasterRegionKelurahanBean"%>
<%@page import="com.sync.master.beans.MasterRegionKecamatanBean"%>
<%@page import="com.sync.master.beans.MasterRegionBean"%>
<%@page import="com.sync.master.beans.MasterResidentBean"%>
<%@page import=" java.io.*,
               com.sync.core.utils.Constants,
               com.sync.master.utils.MasterConstants,
               com.sync.core.beans.MessageBean,
               com.sync.core.utils.Utilities,
               com.sync.master.beans.MasterUserBean"
%>
<%
   MasterRegionBean[] list = (MasterRegionBean[]) request.getAttribute(MasterConstants.MASTERREGION_LIST);
   String isMulti = (String)request.getParameter(MasterConstants.LOOKUP_MULTI);
   String search = (String)request.getParameter(MasterConstants.FORM_SEARCH_RECORD);
   String pagination = (String)request.getAttribute(MasterConstants.HTML_PAGINATION);
%>
<fieldset class="wrapper">
  <div class="form" style="clear:left">
    <form method="post" class="" dst="userlist" id="userlist" 
      action="<%=MasterConstants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=MasterConstants.W%>=<%=MasterConstants.MASTER_REGION_CITY%>&<%=MasterConstants.ACT%>=<%=MasterConstants.ACT_LOOKUP%>">
      <input  type="hidden" name="<%=isMulti!=null?MasterConstants.LOOKUP_MULTI:MasterConstants.LOOKUP_SINGLE%>" value="1">

      <fieldset>
        <div class="list-con">
        <a href="javascript:void(0)" class="reload" title="Refresh">Refresh</a>
        <div class="search">
          <input type="text" placeholder="Cari..." autofocus
            name="<%=MasterConstants.FORM_SEARCH_RECORD%>" value="<%=!Utilities.isEmpy(search)?search:"" %>">
            <a href="javascript:void(0)"></a>
        </div>
            <table border="0" class="list-tb" width="100%">
              <tr>
              <% if(isMulti!=null)
              { 
              %>
                <th><input type="checkbox" class="selAll userids putValues" child="userid"></th>
              <% 
              } 
              %>
                <th>Kota</th>
                <th width="300px">Nama Kota</th>
              </tr>
        <%
           if(null!=list && list.length>0)
           {
              for(int i=0; i<list.length; i++)
              {
        %>
                 <tr>
        <% 
                if(isMulti!=null)
                { 
        %>
                   <td align="center"><input class="selChild userid putValues" parent="userids" type="checkbox" name="<%=MasterConstants.FORM_MASTERREGION_REGID%>" value="<%=list[i].getRegionID()%>"></td>
         <% 
                 } 
         %>

                   <td valign="top">
                <% 
                if(isMulti!=null)
                { 
                %>
                   <%=list[i].getRegionID()%>
                <% 
                } 
                else
                { 
                %>
            <!-- 
            CARA MEMAKAI PUT VALUE SINGLE
            1. menggunakan element a dengan isi href adalah "javascript:void(0)"
            2. harus memiliki class putValue
            3. tambahkan attribute value dengan isi content yang akan ditempelkan pada halaman yang memanggil fungsi LOOKUP SINGLE, content bisa lebih dari 1 (dipisah oleh semicolon)
             -->
                     <a href="javascript:void(0)" class="putValue" value="<%=list[i].getRegionID()%>;<%=list[i].getStateProv()%>">
                       <%=list[i].getRegionID()%>
                     </a>
                   <% } %>
                   </td>
                   <td valign="top"><%=list[i].getRegionName()%></td>
                 </tr>
        <%        
              }
           }
           else
           {
        %>
                 <tr>
                   <td valign="top" align="center" colspan="7">Daftar Kota tidak ditemukan!</td>
                 </tr>
        <%
           }
        %>     
          </table>
        </div>
      </fieldset>
      <%=pagination %>
    </form>
  </div>
</fieldset>
        

