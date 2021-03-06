<%@page import="com.sync.trans.beans.FamilyCardMutationBean"%>
<%@page import="com.sync.trans.beans.BirthLetterBean"%>
<%@page import="com.sync.trans.beans.DeathLetterBean"%>
<%@page import="com.sync.trans.utils.TransConstants"%>
<%@page import=" java.io.*,
               com.sync.core.utils.Constants,
               com.sync.core.beans.MessageBean,
               com.sync.core.utils.Utilities,
               com.sync.master.beans.MasterUserBean"
%>
<%
   String pagination = (String)request.getAttribute(TransConstants.HTML_PAGINATION);
   String act = (String)request.getAttribute(TransConstants.ACT);
   String search = (String)request.getParameter(TransConstants.FORM_SEARCH_RECORD);
   String stat = (String)request.getParameter(TransConstants.DATA_STAT);
   if(Utilities.isEmpy(stat))
   {
      stat = TransConstants.DATA_CURRENT;
   } 

   FamilyCardMutationBean[] list = (FamilyCardMutationBean[]) request.getAttribute(TransConstants.FAMILYCARDMUT_LIST);
   MessageBean msg = null;
   String type="";
   System.out.println(">>>>>>>>>>>>> JSP ACTION= "+act);
%>

    
<input type="hidden" name="<%=TransConstants.ACT%>" value="<%=TransConstants.ACT_LIST%>">
<input id="stat" type="hidden" name="<%=TransConstants.DATA_STAT%>" value="<%=stat%>">
<fieldset>
  <div class="list-con">
    <div class="data-stat">
    <% if(stat.equals(TransConstants.DATA_CURRENT)){out.println("DATA AKTIF");}else{ %>
      <a href="<%=Constants.ROOT_PATH%><%=TransConstants.SVT_TRANS_PATH%>?<%=Constants.W%>=<%=TransConstants.TRANS_FAMILYCARDMUT%>&<%=TransConstants.DATA_STAT%>=<%=TransConstants.DATA_CURRENT%>" >DATA AKTIF</a>
    <% } %>
        |
    <% if(stat.equals(TransConstants.DATA_ARCHIEVE)){out.println("ARSIP");}else{ %> 
      <a href="<%=Constants.ROOT_PATH%><%=TransConstants.SVT_TRANS_PATH%>?<%=Constants.W%>=<%=TransConstants.TRANS_FAMILYCARDMUT%>&<%=TransConstants.DATA_STAT%>=<%=TransConstants.DATA_ARCHIEVE%>">ARSIP</a>
    <% } %>
    </div>
    <a href="javascript:void(0)" class="reload" title="Refresh">Refresh</a>
    <a href="javascript:void(0)" class="delete" title="Hapus" style="<%=null!=list && list.length>0?"":"display:none" %>">Hapus</a>
    <a href="<%=Constants.ROOT_PATH%><%=TransConstants.SVT_TRANS_PATH%>?<%=Constants.W%>=<%=TransConstants.TRANS_FAMILYCARDMUT%>&<%=TransConstants.ACT%>=<%=TransConstants.ACT_CREATE%>" class="add" title="Tambah" >Tambah</a>

    <div class="search">
      <input type="text" placeholder="Cari..." 
        name="<%=TransConstants.FORM_SEARCH_RECORD%>" value="<%=!Utilities.isEmpy(search)?search:"" %>">
        <a href="javascript:void(0)"></a>
    </div>
    <table border="0" class="list-tb" width="100%">
    <tr>
        <th><input type="checkbox" class="selAll birthlettids" child="birthlettid"></th> 
        <th>NIK</th>
        <th>Nama</th>
        <th>Tgl Mulai Berlaku</th>
        <th>Pembuat Data</th>
        <th>Tgl Ubah Data</th>
    </tr>
  <%
     if(null!=list && list.length>0)
     {
       for(int i=0; i<list.length; i++)
       {
  %>
          <tr>
            <td align="center">
              <input type="checkbox" class="selChild birthlettid del" parent="birthlettids" name="<%=TransConstants.CHKBOX%>" value="<%=list[i].getNIK()%><%=TransConstants.DELIMITER_TILDA%><%=Utilities.dateToString(list[i].getStartDate(), TransConstants.DATE_HTML_SHORT_PATTERN)%>">
            </td>
            <td valign="top"><a href="<%=TransConstants.ROOT_PATH%><%=TransConstants.SVT_TRANS_PATH%>?<%=TransConstants.W%>=<%=TransConstants.TRANS_FAMILYCARDMUT%>&<%=TransConstants.ACT%>=<%=TransConstants.ACT_INFO%>&<%=TransConstants.FORM_FAMILYCARDMUT_NIK%>=<%=list[i].getNIK()%>&<%=TransConstants.FORM_FAMILYCARDMUT_STARTDATE%>=<%=Utilities.dateToString(list[i].getStartDate(), TransConstants.DATE_HTML_SHORT_PATTERN)%>"><%=list[i].getNIK()%></a></td>
            <td valign="top"><%=list[i].getName()%></td>
            <td valign="top"><%=Utilities.dateToString(list[i].getStartDate(), TransConstants.DATE_HTML_SHORT_PATTERN) %></td>
            <td valign="top"><%=list[i].getCreateUser()%></td>
            <td valign="top"><%=null!=list[i].getEntryDate()?Utilities.dateToString(list[i].getEntryDate(), 
                TransConstants.DATE_HTML_SHORT_PATTERN):""%></td>
          </tr>
    <%       
        }
      }
      else
      {
%>
         <tr>
           <td valign="top" align="center" colspan="8">Daftar Mutasi KK tidak ditemukan!</td>
         </tr>
<%
      }
%>     
    </table>
  </div>
</fieldset>
 <%=pagination %>

<input type="hidden" name="<%=TransConstants.ACT%>" value="<%=TransConstants.ACT_LIST%>">    

