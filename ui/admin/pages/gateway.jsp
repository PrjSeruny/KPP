<%@page import="com.sync.core.utils.Constants,
               com.sync.core.beans.ContentBean,
               com.sync.master.beans.MasterUserBean,
               com.sync.master.utils.MasterConstants"
%>
<%
  MasterUserBean ubn = (MasterUserBean)session.getAttribute(MasterConstants.MASTERUSER);
  ContentBean cb = (ContentBean)session.getAttribute(Constants.CONTENT_INFO);
  String svt = "";
  String w = "";
  if(null!=cb){
    svt = cb.getCurrServlet();
    w = cb.getCurrParam();
  }else{
    svt = Constants.SERVLET_PATH;
    w = Constants.HOME_PRM;
  }
%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width" />
  <title>Admin</title>
  <link rel="stylesheet" type="text/css" href="<%=Constants.ROOT_PATH%><%=Constants.SCRIPTS_PATH%>/gateway.css">
  <script type="text/javascript" src="<%=Constants.ROOT_PATH%><%=Constants.SCRIPTS_PATH%>/jquery.min.js"></script>
</head>

<body>
  <jsp:include page="<%=Constants.MENU_PAGE%>" flush="true"/>
  <iframe src="<%=Constants.ROOT_PATH%><%=svt%>?<%=Constants.W%>=<%=w%>" id="content"></iframe>
  <div class="el-cover">
    <span>Loading . . .</span>
  </div>
<script>
$(document).ready(function(){
  
  $("#nav li").hover(function(){
    $(this).children('ul').hide();
    $(this).children('ul').fadeIn('fast');
  },
  function () {
    $('ul', this).fadeOut('fast');            
  });
  
  $("#nav-open").click(function(){
    $("#nav").toggle();
  });
  
  $("#nav a").click(function(){
    var url = $(this).attr("url");
    if(url && url!=""){
      $("#content").attr("src",url);
      $("#nav ul").hide();

      cover(true,"Opening Menu...");
    }
  });

  $("#content").load(function(){
    cover(false);
  });
});

function cover(stat,text){
  var cst = "Loading . . .";
  if(text){
    cst = text;
  }
  if(stat){
    $(".el-cover span").text(cst);
    $(".el-cover").fadeIn("fast");

  }else{
    $(".el-cover").fadeOut("fast");
  }
}
</script>
</body>
</html>
