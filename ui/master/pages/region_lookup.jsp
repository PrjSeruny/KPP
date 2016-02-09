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
   Boolean showW = (Boolean)request.getAttribute(MasterConstants.FORM_MASTERREGION_REGIONONLY);
   MasterRegionBean[] list = (MasterRegionBean[]) request.getAttribute(MasterConstants.MASTERREGION_LIST);
   MasterRegionKecamatanBean[] kec = (MasterRegionKecamatanBean[]) request.getAttribute(MasterConstants.MASTERREGION_KEC_LIST);
   MasterRegionKelurahanBean[] kel = (MasterRegionKelurahanBean[]) request.getAttribute(MasterConstants.MASTERREGION_KEL_LIST);
%>
<script>
function putState(stateProv)
{
	eval("self.opener.document.create.<%=MasterConstants.FORM_MASTERRESIDENT_REGION%>.value=stateProv");
}

function putCity(region)
{
	eval("self.opener.document.create.<%=MasterConstants.FORM_MASTERRESIDENT_BIRTHCITY%>.value=region");
}

function putAll(region, kec, kel)
{
	eval("self.opener.document.create.<%=MasterConstants.FORM_MASTERRESIDENT_CITY%>.value=region");
	eval("self.opener.document.create.<%=MasterConstants.FORM_MASTERRESIDENT_KECAMATAN%>.value=kec");
	eval("self.opener.document.create.<%=MasterConstants.FORM_MASTERRESIDENT_KELURAHAN%>.value=kel");
}
</script>
<fieldset>
  <div class="list-con">
    <table class="list-tb" width="100%">
  <%
     if(null!=list && list.length>0)
     {
%>
        <tr>
	      <th>Region</th>
	      <th>Nama</th>
	      <th>Propinsi</th>
	    </tr>
<%       
       for(int i=0; i<list.length; i++)
       {
%>
          <tr>
            <td valign="top">
<%
          if(showW)
          {
%>
              <a href="javascript:putCity('<%=list[i].getRegionID()%>');"><%=list[i].getRegionID()%></a>
<%            
          }
          else
          {
%>
             <a href="javascript:putState('<%=list[i].getStateProv()%>');location.href=('<%=MasterConstants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=MasterConstants.W%>=<%=MasterConstants.MASTER_REGION%>&<%=MasterConstants.ACT%>=<%=MasterConstants.ACT_LOOKUP%>&<%=MasterConstants.FOR%>=<%=MasterConstants.FOR_KEC%>&<%=MasterConstants.FORM_MASTERREGION_REGID%>=<%=list[i].getRegionID()%>');"><%=list[i].getRegionID()%></a>
<%
          }
%>          
            </td>
            <td valign="top"><%=list[i].getRegionName()%></td>
            <td valign="top"><%=list[i].getStateProv()%></td>
          </tr>
<%       
        }
      }
     else if(null!=kec && kec.length>0)
     {
%>
        <tr>
          <th>Kecamatan</th>
          <th>Nama</th>
        </tr>
<%       
       for(int i=0; i<kec.length; i++)
       {
%>
          <tr>
            <td valign="top"><a href="<%=MasterConstants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=MasterConstants.W%>=<%=MasterConstants.MASTER_REGION%>&<%=MasterConstants.ACT%>=<%=MasterConstants.ACT_LOOKUP%>&<%=MasterConstants.FOR%>=<%=MasterConstants.FOR_KEL%>&<%=MasterConstants.FORM_MASTERREGION_REGID%>=<%=kec[i].getRegionID()%>&<%=MasterConstants.FORM_MASTERREGION_KECID%>=<%=kec[i].getKecamatanID()%>"><%=kec[i].getKecamatanID()%></a></td>
            <td valign="top"><%=kec[i].getName()%></td>
          </tr>
<%         
       }
     }
     else if(null!=kel && kel.length>0)
     {
%>
        <tr>
          <th>Kelurahan</th>
          <th>Nama</th>
        </tr>
<%       
        for(int i=0; i<kel.length; i++)
        {
%>
          <tr>
            <td valign="top"><a href="javascript:putAll('<%=kel[i].getRegionID()%>','<%=kel[i].getKecamatanID()%>','<%=kel[i].getKelurahanID()%>');"><%=kel[i].getKelurahanID()%></a></td>
            <td valign="top"><%=kel[i].getName()%></td>
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
        

