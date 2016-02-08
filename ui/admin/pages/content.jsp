<%@page import="com.sync.core.utils.Constants,
               com.sync.core.beans.ContentBean,
               com.sync.master.beans.MasterUserBean,
               com.sync.master.utils.MasterConstants"
%>
<%
  MasterUserBean ubn = (MasterUserBean)session.getAttribute(MasterConstants.MASTERUSER);
  ContentBean cb = (ContentBean)session.getAttribute(Constants.CONTENT_INFO);
  String cp = Constants.HOME_PAGE;
  if(null!=cb){
    cp = cb.getCurrPG();
  }
%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="<%=Constants.ROOT_PATH%><%=Constants.SCRIPTS_PATH%>/content.css">
  <script type="text/javascript" src="<%=Constants.ROOT_PATH%><%=Constants.SCRIPTS_PATH%>/jquery.min.js"></script>
  <script type="text/javascript" src="<%=Constants.ROOT_PATH%><%=Constants.SCRIPTS_PATH%>/content.js"></script>
  <script type="text/javascript">
  $(function(){
    $(".form .upload-img a").click(function(){
      var upload = $(this).closest("li").find("input");
      upload.click();
    });
  });
  </script>
</head>
<body>
  <jsp:include page="<%=cp%>" flush="true"/>
</body>
</html>