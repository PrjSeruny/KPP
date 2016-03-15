<%@page import="com.sync.core.beans.MessageBean"%>
<%@page import="java.util.Date"%>
<%@page import="com.sync.core.utils.Utilities"%>
<%@page import="com.sync.core.beans.GalleryBean"%>
<%@page import=" java.io.*,
               com.sync.core.utils.Constants"
%>
<%

String act = (String)request.getAttribute(Constants.ACT);
GalleryBean gbn = (GalleryBean)request.getAttribute(Constants.GALLERY_SETTING_INFO_BEAN);

MessageBean msg = null;

if(null!=gbn && gbn.getMessageBean()!=null && gbn.getMessageBean().anyMessageExist()){
  msg = gbn.getMessageBean();
}


%>

<%
String crAct = (String)request.getParameter(Constants.ACT);
if(null!=crAct && (crAct.equals(Constants.ACT_CREATE_SAVE) || crAct.equals(Constants.ACT_UPDATE_SAVE))){
%>
<script type="text/javascript">
openAjaxUrl('#glist','<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH%>?<%=Constants.W%>=<%=Constants.GALLERY_SETTING_PRM %>&<%=Constants.ACT%>=<%=Constants.ACT_LIST%>');
</script>  
<%
}
%>
  <form method="post" action="<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH%>" class="ajax-form" dst="gedit">
    <input type="hidden" name="<%=Constants.ACT%>" value="<%=act%>">
          <input type="hidden" name="<%=Constants.FORM_GALLERY_ID %>" value="<%=null!=gbn?Utilities.showStringValue(gbn.getID()+""):""%>">
    <div class="form">
      <h2 class="title">Tambah Gallery</h2>
      <label class="errormsg"></label>
      <fieldset>
        <div style="min-width: 180px;margin-right: 0px">
          <label></label>
          <%
          String path = "",path_thumb = "",addBtn = "",cls="new",style="",ttl="Unggah Gambar";
          if(null!=gbn && null!=gbn.getPath()){
            path = gbn.getPath();
            path_thumb = gbn.getPathThumb();
            addBtn = "<a href='javascript:void(0)' class='imgview' imgpath='"+Utilities.verifyImage(gbn.getPath())+"' title='Lihat'></a>";
            cls = "update";
            ttl = "Ubah";
            style = "background-image:url('"+Utilities.verifyImage(gbn.getPathThumb())+"?"+new Date().getTime()+"')";
          }
          %>
	        <ul class="upload-img">
	          <li url="<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH %>" style="width: 170px;height: 170px;<%=style %>">
	            <%=addBtn%>
	            <a href="javascript:void(0)" class="<%=cls %>" title="<%=ttl %>"></a>
	            <div class="addParam">
	              <input type="hidden" name="<%=Constants.W %>" value="<%=Constants.GALLERY_SETTING_PRM%>">
	              <!-- PARAMETER YANG HARUS ADA DALAM FORM, NAMA DAN CLASS PARAMETER SUDAH PATEN-->
	              <input type="hidden" class="inputPath" name="image" value="<%=Utilities.showStringValue(path) %>">
	              <input type="hidden" class="inputPath_thumb" name="image_thumb" value="<%=Utilities.showStringValue(path_thumb)%>">
	            </div>
	          </li>
          </ul>
          <br><span class="erroritm"><%=null!=msg?Utilities.showStringValue(msg.getMessageBean(Constants.FORM_IMAGE_PATH)):"" %></span>
        </div>
        <div style="min-width: 320px;">
          <label>Judul</label>
          <input type="text" name="<%=Constants.FORM_GALLERY_TITLE %>" value="<%=null!=gbn?Utilities.showStringValue(gbn.getTitle()):""%>">
          <br><span class="erroritm"></span>
          <br>
          <label>Keterangan</label>
          <textarea style="height: 77px" name="<%=Constants.FORM_GALLERY_DESC %>"><%=null!=gbn?Utilities.showStringValue(gbn.getDesc()):""%></textarea>
          <br><span class="erroritm"></span>
        </div>
      </fieldset>
      <fieldset>
        <div>
          <input type="submit" value="Simpan"><!-- <input type="reset" value="Reset" class="negate"> -->
          <% 
          String btnName = (!act.equals(Constants.ACT_UPDATE_SAVE))?"Reset":"Batal Ubah";
          %>
          <input type="button" value="<%=btnName %>" class="negate" onclick="javascript:openAjaxUrl('#gedit','<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH%>?<%=Constants.W%>=<%=Constants.GALLERY_SETTING_PRM %>&<%=Constants.ACT%>=<%=Constants.ACT_CREATE%>')">
        </div>
      </fieldset>
    </div>
  </form>