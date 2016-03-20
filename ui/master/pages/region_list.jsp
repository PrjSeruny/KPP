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
   String pagination = (String)request.getAttribute(MasterConstants.HTML_PAGINATION);
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
%>

    
<input type="hidden" name="<%=MasterConstants.ACT%>" value="<%=MasterConstants.ACT_LIST%>">
<input id="stat" type="hidden" name="<%=MasterConstants.DATA_STAT%>" value="<%=stat%>">
<fieldset>

  <div class="list-con">
    <a href="javascript:void(0)" class="reload" title="Refresh">Refresh</a>

    <div class="search">
      <input type="text" placeholder="Cari..." 
        name="<%=MasterConstants.FORM_SEARCH_RECORD%>" value="<%=!Utilities.isEmpy(search)?search:"" %>">
        <a href="javascript:void(0)"></a>
    </div>

    <table border="0" class="list-tb" width="100%">
    <tr>
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
 <%=pagination %>

<input type="hidden" name="<%=MasterConstants.ACT%>" value="<%=MasterConstants.ACT_LIST%>">        

