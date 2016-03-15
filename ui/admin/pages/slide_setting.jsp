<%@page import="java.util.Date,
               java.io.*,
               com.sync.core.utils.Constants,
               com.sync.core.utils.Utilities,
               com.sync.core.beans.SlideBean,
               com.sync.core.pool.SlidePool"
%>
<%
SlidePool sp = SlidePool.getInstance();
SlideBean sb = null;
%>
<fieldset class="wrapper">
  <div class="form">
    <h2 class="title">Setting Gambar Slide</h2>
    <fieldset>
      <div>
        <ul class="upload-img">
    <% 
    int length = 6;
    String addBtn = "", cls="new", style="", ttl = "";
    for(int i=1;i<=length;i++){
      addBtn = "";cls="new";style="";ttl="Unggah Gambar";
      sb = sp.get(i);
      
      if(null!=sb){
        addBtn = "<a href='javascript:void(0)' class='imgview' imgpath='"+Utilities.verifyImage(sb.getPath())+"' title='Lihat'></a>";
        addBtn += "<a href='javascript:void(0)' class='imgdel' title='Hapus'></a>";
        cls = "update";
        ttl = "Ubah";
        style = "background-image:url('"+Utilities.verifyImage(sb.getPathThumb())+"?"+new Date().getTime()+"')";
      }
    %>
          <li style="width:240px;margin-right:10px;<%=style%>" url="<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH %>">
            <%=addBtn%>
            <a href="javascript:void(0)" class="<%=cls%>" title="<%=ttl%>"></a>
            <form>
            <input type="hidden" name="<%=Constants.FORM_SLIDE_ID %>" value="<%=i%>">
            <input type="hidden" name="<%=Constants.W %>" value="<%=Constants.SLIDE_SETTING_PRM%>">
            <input type="hidden" class="inputPath" name="image" value="<%=null!=sb?sb.getPath():""%>">
            <input type="hidden" class="inputPath_thumb" name="image_thumb" value="<%=null!=sb?sb.getPathThumb():""%>">
            </form>
          </li>
    <% 
      if(i%2==0 && i!=length){
    %>
        </ul>
      </div>
    </fieldset>
    <fieldset>
      <div>
        <!-- <label>Input Image</label> -->
        <ul class="upload-img">
    <%
      }
    } 
    %>
        </ul>
      </div>
    </fieldset>
    <fieldset>
    <b style="margin:0px 0px 0px 10px">Catatan :</b>
      <ul style="margin: 0px;list-style-type: decimal;padding-left:25px;margin-top: 5px;">
        <li><i>Kapasitas gambar maximal 500kb.</i></li>
        <li><i>Rekomendasi Ukuran gambar 400x960 pixel.</i></li>
      </ul>
    </fieldset>
  </div>
</fieldset>