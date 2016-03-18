<%@page import="com.sync.core.beans.NewsBean"%>
<%@page import="com.sync.core.beans.MessageBean"%>
<%@page import="java.util.Date"%>
<%@page import="com.sync.core.utils.Utilities"%>
<%@page import=" java.io.*,
               com.sync.core.utils.Constants"
%>
<%

String act = (String)request.getAttribute(Constants.ACT);
NewsBean nbn = (NewsBean)request.getAttribute(Constants.NEWS_SETTING_INFO_BEAN);

MessageBean msg = null;

if(null!=nbn && nbn.getMessageBean()!=null && nbn.getMessageBean().anyMessageExist()){
  msg = nbn.getMessageBean();
}


%>
<fieldset class="wrapper">
  <form method="post" action="<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH%>">
    <input type="hidden" name="<%=Constants.ACT%>" value="<%=act%>">
          <input type="hidden" name="<%=Constants.FORM_NEWS_ID %>" value="<%=null!=nbn?Utilities.showStringValue(nbn.getID()+""):""%>">
    <div class="form">
      <h2 class="title">Tambah Berita</h2>
      <label class="errormsg"></label>
      <fieldset>
        <div style="min-width: 180px;margin-right: 0px">
          <label>Gambar</label>
          <%
          String path = "",path_thumb = "",addBtn = "",cls="new",style="",ttl="Unggah Gambar";
          if(null!=nbn && null!=nbn.getPath()){
            path = nbn.getPath();
            path_thumb = nbn.getPathThumb();
            addBtn = "<a href='javascript:void(0)' class='imgview' imgpath='"+Utilities.verifyImage(nbn.getPath())+"' title='Lihat'></a>";
            cls = "update";
            ttl = "Ubah";
            style = "background-image:url('"+Utilities.verifyImage(nbn.getPathThumb())+"?"+new Date().getTime()+"')";
          }
          %>
          <ul class="upload-img">
            <li url="<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH %>" style="width: 170px;height: 170px;<%=style %>">
              <%=addBtn%>
              <a href="javascript:void(0)" class="<%=cls %>" title="<%=ttl %>"></a>
              <div class="addParam">
                <input type="hidden" name="<%=Constants.W %>" value="<%=Constants.NEWS_SETTING_PRM%>">
                <!-- PARAMETER YANG HARUS ADA DALAM FORM, NAMA DAN CLASS PARAMETER SUDAH PATEN-->
                <input type="hidden" class="inputPath" name="image" value="<%=Utilities.showStringValue(path) %>">
                <input type="hidden" class="inputPath_thumb" name="image_thumb" value="<%=Utilities.showStringValue(path_thumb)%>">
              </div>
            </li>
          </ul>
          <br><span class="erroritm"><%=null!=msg?Utilities.showStringValue(msg.getMessageBean(Constants.FORM_IMAGE_PATH)):"" %></span>
        </div>
      </fieldset>
      
      <fieldset>
        <div style="min-width: 320px;">
          <label>Judul</label>
          <input type="text" name="<%=Constants.FORM_NEWS_TITLE %>" value="<%=null!=nbn?Utilities.showStringValue(nbn.getTitle()):""%>">
          <br><span class="erroritm"><%=null!=msg?Utilities.showStringValue(msg.getMessageBean(Constants.FORM_NEWS_TITLE)):"" %></span>
          <br>
          <label>Deskripsi</label>
          <textarea rows="50" class="tiny" name="<%=Constants.FORM_NEWS_DESC %>"><%=null!=nbn?Utilities.showStringValue(nbn.getDesc()):""%></textarea>
          <br><span class="erroritm"><%=null!=msg?Utilities.showStringValue(msg.getMessageBean(Constants.FORM_NEWS_DESC)):"" %></span>
        </div>
      </fieldset>
      
      <fieldset>
        <div>
          <input type="submit" value="Simpan"><!-- <input type="reset" value="Reset" class="negate"> -->
          <input type="button" value="Batal" class="negate" onclick="javascript:window.location.href='<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH%>?<%=Constants.W%>=<%=Constants.NEWS_SETTING_PRM %>'">
        </div>
      </fieldset>
    </div>
  </form>
  </fieldset>