<%@page import="com.sync.core.utils.Utilities"%>
<%@page import="com.sync.core.beans.GalleryBean"%>
<%@page import=" java.io.*,
               com.sync.core.utils.Constants"
%>
<%
   String pagination = (String)request.getAttribute(Constants.HTML_PAGINATION);
   GalleryBean[] list = (GalleryBean[]) request.getAttribute(Constants.GALLERY_SETTING_LIST_BEAN);
   
%>
<style>
.img-thumb{
    display: inline-block;
    width: 100px;
    height: 100px;
    border: solid 2px #C3C2C2;
    background-size: contain;
    background-position: center;
    background-repeat: no-repeat;
}
</style>
  <div class="form" style="clear:left">
    <h2 class="title">Daftar Gallery</h2>
    <form method="post" class="ajax-form" dst="glist"
      action="<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH%>?<%=Constants.W%>=<%=Constants.GALLERY_SETTING_PRM%>">
			<fieldset>
			  <div class="list-con">
			  <a href="javascript:void(0)" class="reload" title="Refresh">Refresh</a>
			  <a href="javascript:void(0)" class="delete" title="Hapus" style="<%=null!=list && list.length>0?"":"display:none" %>">Hapus</a>
			  <div class="search" style="visibility: hidden;">
			    <input type="text" placeholder="Cari..." 
			      name="<%=Constants.FORM_SEARCH_RECORD%>" value="">
			      <a href="javascript:void(0)"></a>
			  </div>
			      <table border="0" class="list-tb" width="100%">
			        <tr>
			          <th><input type="checkbox" class="selAll userids" child="userid"></th>
			          <th>Foto</th>
			          <th width="200px">Judul</th>
			          <th width="300px">Keterangan</th>
			        </tr>
			  <%
			     if(null!=list && list.length>0)
			     {
			        for(int i=0; i<list.length; i++)
			        {
			  %>
			           <tr>
			             <td align="center"><input class="selChild userid del" parent="userids" type="checkbox" name="<%=Constants.FORM_GALLERY_ID%>" value="<%=list[i].getID()%>"></td>
			             <td valign="top">
		                 <a href="javascript:void(0)" class="img-thumb imgview" imgpath="<%=Utilities.verifyImage(list[i].getPath()) %>" style="background-image: url(<%=Utilities.verifyImage(list[i].getPathThumb()) %>)"></a>
			             </td>
			             <td valign="top">
                     <a style="display: block;height: 105px;width: 100%;"
                     href="javascript:openAjaxUrl('#gedit','<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH%>?<%=Constants.W%>=<%=Constants.GALLERY_SETTING_PRM %>&<%=Constants.ACT%>=<%=Constants.ACT_UPDATE%>&<%=Constants.FORM_GALLERY_ID%>=<%=list[i].getID()%>')">
			                 <%=Utilities.showStringValue(list[i].getTitle())%>
			               </a>
			             </td>
			             <td valign="top"><%=Utilities.showStringValue(list[i].getDesc())%></td>
			           </tr>
			  <%        
			        }
			     }
			     else
			     {
			  %>
			           <tr>
			             <td valign="top" align="center" colspan="7">Daftar Gallery tidak ditemukan!</td>
			           </tr>
			  <%
			     }
			  %>     
			    </table>
			  </div>
			</fieldset>
			<%=pagination %>

      <input type="hidden" name="<%=Constants.ACT%>" value="<%=Constants.ACT_LIST%>">

    </form>
  </div>