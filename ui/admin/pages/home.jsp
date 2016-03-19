<%@page import="com.sync.master.beans.MasterUserBean"%>
<%@page import=" java.io.*,
               com.sync.core.utils.Constants,
               com.sync.master.utils.MasterConstants,
               com.sync.core.utils.Utilities,
               com.sync.master.beans.MasterResidentBean"
%>
<%
   String pagination = (String)request.getAttribute(MasterConstants.HTML_PAGINATION);
   String act = (String)request.getParameter(MasterConstants.ACT);
   String search = (String)request.getParameter(MasterConstants.FORM_SEARCH_RECORD);

   MasterResidentBean[] list = (MasterResidentBean[]) request.getAttribute(MasterConstants.MASTERRESIDENT_LIST);
   
   String[] jenis = {"","Perempuan","Laki-laki"};
   String style = "";
   String welcometxt = "Selamat Datang<br> Di Halaman Administrator Kependudukan";
   
   HttpSession ses = request.getSession(true);
   MasterUserBean ubn = (MasterUserBean)ses.getAttribute(MasterConstants.MASTERUSER);
   
   if(null==ubn){
     style = "background: linear-gradient(to bottom right, #C5C5C5 0%, #F9F9F9 100%);"+
         "position: absolute;"+
         "top: 0px;"+
         "left: 0;"+
         "width: 100%;"+
         "height: 93%;"+
         "overflow: hidden;"+
         "margin: 0px;"+
         "padding-top: 3%;";
     welcometxt = "Silahkan isi Nama atau NIK pada kolom Cari Penduduk";
   }
%>
<style>
#welcome{
  font-size: 30px;
  font-weight: bold;
  color: #00968A;
  font-style: italic;
  margin-top: 30px;
  text-shadow: 3px 3px 4px #C5C5C5;
}
</style>
<form action="<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH%>" method="post" id="lgpg">
  <input type="hidden" name="<%=Constants.D%>" value="<%=Constants.D_LOGON%>">
</form>
<fieldset class="wrapper" style="<%=style%>">
  <div class="form" style="clear:left;width: 90%;margin: auto;display: -webkit-box;min-height: 500px;"> 
	  <fieldset style="width:100%">
	    <form method="post" action="<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH%>?<%=Constants.W%>=<%=Constants.HOME_PRM%>">
        <input type="hidden" name="<%=MasterConstants.ACT%>" value="<%=MasterConstants.ACT_LIST%>">
        
		    <div class="list-con" style="text-align: center;width: 100%;">
		      <div class="search" style="float: none;margin-bottom: 10px;margin-top: 5px;">
		        <input type="text" placeholder="Cari Penduduk" 
		        name="<%=Constants.FORM_SEARCH_RECORD%>" value="<%=Utilities.stripNull(search)%>" style="width: 250px;font-size: 17px;">
		        <a href="javascript:void(0)" style="width: 17px;height: 20px;"></a>
		      </div>
		      <% if(null==ubn){ %>
		      <input type="button" value="Kembali ke Login" style="float: right;" onclick="javascript:$('#lgpg').submit()">
		      <% } %>
      <%
      if(null!=act){
      %>
		      <table border="0" class="list-tb" style="width: 100%;">
				    <tr>
				        <th>NIK</th>
				        <th>No.KK</th>
				        <th>Nama</th>
				        <th>Jenis Kelamin</th>
				        <th>Tgl Lahir</th>
				        <th>Alamat</th>
				        <th>Agama</th>
				    </tr>
			<%
			     if(null!=list && list.length>0)
			     {
			       for(int i=0; i<list.length; i++)
			       {
			  %>
			          <tr>
			            <td valign="top"><a href="<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH%>?<%=Constants.W%>=<%=Constants.HOME_PRM%>&<%=Constants.ACT%>=<%=Constants.ACT_INFO%>&<%=MasterConstants.FORM_MASTERRESIDENT_NIK%>=<%=list[i].getNIK()%>"><%=list[i].getNIK()%></a></td>
			            <td valign="top"><%=list[i].getKKNo()%></td>
			            <td valign="top" align="left"><%=list[i].getName()%></td>
                  <td valign="top"><%=jenis[list[i].getSex()]%></td>
                  <td valign="top"><%=Utilities.dateToString(list[i].getBirthDate(), Constants.DATE_HTML_SHORT_PATTERN)%></td>
			            <td valign="top" align="left"><%=list[i].getAddress()%></td>
			            <td valign="top"><%=list[i].getReligion()%></td>
			          </tr>
			    <%       
			        }
			      }
			      else
			      {
			  %>
			         <tr>
			           <td valign="top" align="center" colspan="8">Data yang dicari tidak ditemukan!</td>
			         </tr>
			  <%
			      }
			  %>   				    
		      </table>
	      <%
	       }else{
	      %>
		      <div id="welcome"><%=welcometxt %></div>
		    <%
         }
        %>
        </div>
	    </form>
	  </fieldset>
  <%=Utilities.stripNull(pagination)%>
  </div>
</fieldset>