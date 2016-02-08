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
   String isMulti = (String)request.getParameter(MasterConstants.LOOKUP_MULTI);
   
%>
<fieldset class="wrapper">
  <div class="form" style="clear:left">
    <form method="post" class="" dst="userlist" id="userlist" 
      action="<%=MasterConstants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=MasterConstants.W%>=<%=MasterConstants.MASTERUSER%>&<%=MasterConstants.ACT%>=<%=MasterConstants.ACT_LOOKUP%>">
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
            <!-- 
			CARA MEMAKAI PUT VALUE MULTI
			1. checkbox pada header digunakan untuk select all checkbox yang ada di masing2 record
			2. checkbox header harus memiliki class selAll
			3. tambahkan class pada checkbox header untuk identifikasi kalau checkbox ini adalah parent sperti pada contoh dibawah, ditambahkan class "userids" untuk parentnya
			4. checkbox header harus memiliki class putValues sebagai tanda kalau checkbox ini digunakan untuk PUT VALUE MULTI
			5. tambahkan attribute child untuk identifikasi childnya menggunakan class apa
             -->
              <tr>
              <% if(isMulti!=null){ %>
                <th><input type="checkbox" class="selAll userids putValues" child="userid"></th>
              <% } %>
                <th>Username</th>
                <th width="300px">Nama Lengkap</th>
              </tr>
        <%
           if(null!=list && list.length>0)
           {
              for(int i=0; i<list.length; i++)
              {
        %>
                 <tr>
                   <% if(isMulti!=null){ %>

            <!-- 
            LANJUTAN CARA MEMAKAI PUT VALUE MULTI
            6. checkbox pada masing2 record harus  memiliki class selChild
            7. tambahkan class pada masing2 checkbox record untuk identifikasi kalau checkbox ini adalah child sperti pada contoh dibawah, ditambahkan class "userid" untuk childnya
            8. pada masing2 checkbox record harus memiliki class putValues sebagai tanda kalau checkbox ini digunakan untuk PUT VALUE MULTI
            9. tambahkan attribute parent untuk identifikasi parentnya menggunakan class apa
            10. isi value checkbox untuk ditempelkan pada element yang sudah ditentukan pada halaman yang memanggil fungsi LOOKUP MULTI
             -->
                   <td align="center"><input class="selChild userid putValues" parent="userids" type="checkbox" name="<%=MasterConstants.FORM_MASTERUSER_USERID%>" value="<%=list[i].getUser()%>"></td>
                   <% } %>

                   <td valign="top">
                   <% if(isMulti!=null){ %>
                      <%=list[i].getUser()%>
                   <% } else{ %>
            <!-- 
            CARA MEMAKAI PUT VALUE SINGLE
            1. menggunakan element a dengan isi href adalah "javascript:void(0)"
            2. harus memiliki class putValue
            3. tambahkan attribute value dengan isi content yang akan ditempelkan pada halaman yang memanggil fungsi LOOKUP SINGLE, content bisa lebih dari 1 (dipisah oleh semicolon)
             -->
                     <a href="javascript:void(0)" class="putValue" value="<%=list[i].getUser()%>;<%=list[i].getName()%>">
                       <%=list[i].getUser()%>
                     </a>
                   <% } %>
                   </td>
                   <td valign="top"><%=list[i].getName()%></td>
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
    </form>
  </div>
</fieldset>