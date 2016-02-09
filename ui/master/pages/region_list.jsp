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
   String act = (String)request.getAttribute(MasterConstants.ACT);
   String search = (String)request.getParameter(MasterConstants.FORM_SEARCH_RECORD);
   String stat = (String)request.getParameter(MasterConstants.DATA_STAT);
   if(Utilities.isEmpy(stat))
   {
      stat = MasterConstants.DATA_CURRENT;
   } 

   MasterRegionBean[] list = (MasterRegionBean[]) request.getAttribute(MasterConstants.MASTERREGION_LIST);
   MessageBean msg = null;
   String type="";
   System.out.println(">>>>>>>>>>>>> JSP ACTION= "+act);
%>

    
<input type="hidden" name="<%=MasterConstants.ACT%>" value="<%=MasterConstants.ACT_LIST%>">
<input id="stat" type="hidden" name="<%=MasterConstants.DATA_STAT%>" value="<%=stat%>">
<fieldset>

  <div class="list-con">
    <div class="data-stat">
    <% if(stat.equals(MasterConstants.DATA_CURRENT)){out.println("DATA AKTIF");}else{ %>
      <a href="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=Constants.W%>=<%=MasterConstants.MASTER_REGION%>&<%=MasterConstants.DATA_STAT%>=<%=MasterConstants.DATA_CURRENT%>" >DATA AKTIF</a>
    <% } %>
        |
    <% if(stat.equals(MasterConstants.DATA_ARCHIEVE)){out.println("ARSIP");}else{ %> 
      <a href="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=Constants.W%>=<%=MasterConstants.MASTER_REGION%>&<%=MasterConstants.DATA_STAT%>=<%=MasterConstants.DATA_ARCHIEVE%>">ARSIP</a>
    <% } %>
    </div>
    <!-- a href="javascript:void(0)" class="reload" title="Refresh">Refresh</a>
    <a href="javascript:void(0)" class="delete" title="Hapus" style="<%=null!=list && list.length>0?"":"display:none" %>">Hapus</a>
    <a href="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=Constants.W%>=<%=MasterConstants.MASTER_REGION%>&<%=MasterConstants.ACT%>=<%=MasterConstants.ACT_CREATE%>" class="add" title="Tambah" >Tambah</a -->

    <!-- div class="search">
      <input type="text" placeholder="Cari..." 
        name="<%=MasterConstants.FORM_SEARCH_RECORD%>" value="<%=!Utilities.isEmpy(search)?search:"" %>">
        <a href="javascript:void(0)"></a>
    </div -->

    <table border="0" class="list-tb" width="100%">
    <tr>
        <th><input type="checkbox" class="selAll regionids" child="regionid"></th> 
        <th>Region</th>
        <th>Nama</th>
        <th>Propinsi</th>
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
              <input type="checkbox" class="selChild regionid del" parent="regionids" name="<%=MasterConstants.CHKBOX%>" value="<%=list[i].getRegionID()%>">
            </td>
            <td valign="top"><a href="<%=MasterConstants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=MasterConstants.W%>=<%=MasterConstants.MASTER_REGION%>&<%=MasterConstants.ACT%>=<%=MasterConstants.ACT_INFO%>&<%=MasterConstants.FORM_MASTERREGION_REGID%>=<%=list[i].getRegionID()%>"><%=list[i].getRegionID()%></a></td>
            <td valign="top"><%=list[i].getRegionName()%></td>
            <td valign="top"><%=list[i].getStateProv()%></td>
            <td valign="top"><%=list[i].getCreateUser()%></td>
            <td valign="top"><%=null!=list[i].getEntryDate()?Utilities.dateToString(list[i].getEntryDate(), 
                MasterConstants.DATE_HTML_SHORT_PATTERN):""%></td>
          </tr>
    <%       
        }
      }
      else
      {
  %>
         <tr>
           <td valign="top" align="center" colspan="8">Daftar Region tidak ditemukan!</td>
         </tr>
  <%
      }
  %>     
    </table>
  </div>
</fieldset>
        

