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
   String act = (String)request.getAttribute(MasterConstants.ACT);
   MasterRegionBean ubn = (MasterRegionBean)request.getAttribute(MasterConstants.MASTERREGION_INFO);
   MessageBean msg = null;
   String type="";
   String tmp="";
   System.out.println(">>>>>>>>>>>>> JSP ACTION= "+act);
   if(null!=ubn)
   {
     msg = ubn.getBeanMessages();
   }
   
%>
<fieldset class="wrapper">
 <form name="info" method="post" action="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>">
 <input type="hidden" name="<%=MasterConstants.W%>" value="<%=MasterConstants.MASTER_REGION%>">
 <input type="hidden" name="<%=MasterConstants.ACT%>" value="<%=MasterConstants.ACT_UPDATE%>">
    <div class="form">
        <h2 class="title">Info Region</h2>
        <fieldset>
            <div >
                <table border="0" style="float:left;margin-right:20px" width="500px">
                <tr>
                    <td class="bold">Propinsi</td>
                    <td>: <%=null!=ubn?ubn.getStateProv():""%></td>
                 </tr>
                 <tr>
                    <td class="bold" width="150px">Region</td>
                    <td>
                        : <%=null!=ubn?ubn.getRegionID():""%>
                       <input type="hidden" name="<%=MasterConstants.FORM_MASTERREGION_REGID%>" value="<%=null!=ubn?ubn.getRegionID():""%>">
                    </td>
                 </tr>
                 <tr>
                    <td class="bold">Nama</td>
                    <td>: <%=null!=ubn?ubn.getRegionName():""%></td>
                 </tr>
                 <tr>
                    <td class="bold">Catatan</td>          
                    <td>: <%=null!=ubn?ubn.getNote():""%></td>
                 </tr>
               </table>
            </div>
        </fieldset>
<%
  if(null!=ubn.getKecamatanInfo())
  {
   MasterRegionKecamatanBean[] kecbn = ubn.getKecamatanInfo();
   if(null!=kecbn && kecbn.length>0)
   {
%>   
         <table border="0" class="list-tb" width="100%">
		    <tr>
		        <th>Kecamatan</th>
		        <th>Nama</th>
		    </tr>
<%
      for(int i=0; i<kecbn.length; i++)
      {
%>
           <tr>
              <td><%=kecbn[i].getKecamatanID() %></td>
              <td><%=kecbn[i].getName()%></td>
           </tr>
<%        
      }
%>		    
		 </table>
<%
   }
  }
%>
<br>
        <fieldset><div>
            <!-- input type="submit" value="Ubah" -->
            <input type="submit" name="<%=MasterConstants.BTN_DONE %>" value="Selesai" class="negate">
        </div></fieldset>
    </div>
 </form>
</fieldset>