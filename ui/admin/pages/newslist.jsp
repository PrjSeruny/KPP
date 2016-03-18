<%@page import="com.sync.core.beans.NewsBean"%>
<%@page import="com.sync.core.utils.Utilities"%>
<%@page import=" java.io.*,
               com.sync.core.utils.Constants"
%>
<%
   String pagination = (String)request.getAttribute(Constants.HTML_PAGINATION);
   NewsBean[] list = (NewsBean[]) request.getAttribute(Constants.NEWS_SETTING_LIST_BEAN);
   
%>
<style>
.img-thumb{
    display: inline-block;
    width: 150px;
    height: 150px;
    /* border: solid 2px #C3C2C2; */
    background-size: contain;
    background-position: center;
    background-repeat: no-repeat;
}
.horizontal-list{
    list-style: none;
    padding: 0px;
}
.horizontal-list li{
    display: inline-block;
    margin-right: 10px;
    margin-bottom: 10px;
    float: left;
    background: rgb(58, 179, 169);
    padding: 3px;
}
.horizontal-list li > a{ background-color: whitesmoke; }
.horizontal-list li > div{
    display: block;
    width: 100%;
}
.horizontal-list li > div > a{
    display: block;
    width: 50%;
    float: left;
    color: white;
    text-align: center;    
    height: 25px;
    line-height: 25px;
}
.horizontal-list li > div > a:hover{
    color: white;
    background: #44BFB5;
}
</style>
<fieldset class="wrapper">
  <div class="form" style="clear:left;width:97%">
    <h2 class="title">Daftar Berita</h2>
    <form method="post"
      action="<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH%>?<%=Constants.W%>=<%=Constants.NEWS_SETTING_PRM%>">
      <fieldset>
        <div class="list-con" style="margin: 5px 10px 10px 10px;">
	        <ul class="horizontal-list">
	        <% 
		        if(null!=list && list.length>0)
	          {
	             for(int i=0; i<list.length; i++)
	             {
	       %>   
		            <li>
		              <a href="javascript:void(0)" class="img-thumb imgview" imgpath="<%=Utilities.verifyImage(list[i].getPath()) %>" style="background-image: url(<%=Utilities.verifyImage(list[i].getPathThumb()) %>)"></a>
		              <div>
		                <a href="<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH%>?<%=Constants.W%>=<%=Constants.NEWS_SETTING_PRM%>&<%=Constants.ACT%>=<%=Constants.ACT_INFO%>&<%=Constants.FORM_NEWS_ID%>=<%=list[i].getID()%>">Lihat</a>
		                <a href="javascript:void(0)"
		                onclick="javascript:if(!confirm('Anda yakin akan menghapus berita ini?')){return false;}else{window.location.href='<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH%>?<%=Constants.W%>=<%=Constants.NEWS_SETTING_PRM%>&<%=Constants.ACT%>=<%=Constants.ACT_DELETE%>&<%=Constants.FORM_NEWS_ID%>=<%=list[i].getID()%>';}"
		                >Hapus</a>
		              </div>
		            </li>
	       <%        
	             }
	          }
	        %>
            <li style="padding-bottom: 0px;">
              <a 
              style="background-image: url(<%=Constants.ROOT_PATH+Constants.IMAGES_PATH%>/plus.png);background-size: 100px;"
              href="<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH%>?<%=Constants.W%>=<%=Constants.NEWS_SETTING_PRM%>&<%=Constants.ACT%>=<%=Constants.ACT_CREATE%>" class="img-thumb" title="Tambah News"></a>
            </li>
	        </ul>
        </div>
      </fieldset>
      <%=pagination %>

    </form>
  </div>
</fieldset>