<%@page import="com.sync.core.beans.NewsBean"%>
<%@page import="com.sync.core.beans.MessageBean"%>
<%@page import="java.util.Date"%>
<%@page import="com.sync.core.utils.Utilities"%>
<%@page import=" java.io.*,
               com.sync.core.utils.Constants"
%>
<%

NewsBean nbn = (NewsBean)request.getAttribute(Constants.NEWS_SETTING_INFO_BEAN);


%>
<style>

.img-thumb{
    display: inline-block;
    width: 150px;
    height: 150px;
    border: solid 2px #C3C2C2;
    background-size: contain;
    background-position: center;
    background-repeat: no-repeat;
    float: left;
    margin: 0px 10px 10px 0px;
}
</style>
<fieldset class="wrapper">
    <div class="form" style="width:97%">
      <fieldset>
        <div style="margin: 5px 10px 10px 10px;width:100%">
         <a href="javascript:void(0)" class="img-thumb imgview" imgpath="<%=Utilities.verifyImage(nbn.getPath()) %>" style="background-image: url(<%=Utilities.verifyImage(nbn.getPathThumb()) %>)"></a>
         <h3 style="margin: 0px 0px 5px 0px;"><%=nbn.getTitle() %></h3>
         <%=nbn.getDesc() %>
        </div>
      </fieldset>
      
      <fieldset>
        <div>
          <input type="button" value="Ubah"
          onclick="javascript:window.location.href='<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH%>?<%=Constants.W%>=<%=Constants.NEWS_SETTING_PRM%>&<%=Constants.ACT%>=<%=Constants.ACT_UPDATE%>&<%=Constants.FORM_NEWS_ID%>=<%=nbn.getID()%>'"><!-- <input type="reset" value="Reset" class="negate"> -->
          <input type="button" value="Kembali" class="negate" onclick="javascript:window.location.href='<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH%>?<%=Constants.W%>=<%=Constants.NEWS_SETTING_PRM %>'">
        </div>
      </fieldset>
    </div>
  </fieldset>