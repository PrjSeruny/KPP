<%@page import="com.sync.core.utils.Constants,
               com.sync.core.beans.ContentBean"
%>
<%
String content = (String)request.getAttribute(Constants.CONTENT_INFO);
String isMulti = (String)request.getParameter(Constants.LOOKUP_MULTI);
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width" />
  <title>Lookup</title>
  <link rel="stylesheet" type="text/css" href="<%=Constants.ROOT_PATH%><%=Constants.SCRIPTS_PATH%>/content.css">
  <script type="text/javascript" src="<%=Constants.ROOT_PATH%><%=Constants.SCRIPTS_PATH%>/jquery.min.js"></script>
  <script type="text/javascript" src="<%=Constants.ROOT_PATH%><%=Constants.SCRIPTS_PATH%>/content.js"></script>
  <script type="text/javascript">
  	<% if(isMulti!=null){ %>
  		$(window).load(function(){
  			var lookupTarget = self.opener.lookupTarget;
  			if(self.opener.$(lookupTarget[0]).val() != ""){
  				lookupValues = self.opener.$(lookupTarget[0]).val().split(";");
  			}

			$(".selChild.putValues").each(function(){
				if(lookupValues.indexOf(this.value) > -1){
					$(this).prop("checked",true);
				}
			});

			var checkedlist = $(".selChild.putValues:checkbox:checked");
			if(checkedlist.length == $(".selChild.putValues").length){
				$(".selAll.putValues").prop("checked",true);
			}
  		});
	<% } %>
  </script>
</head>

<body>
  <jsp:include page="<%=content%>" flush="true"/>
</body>
</html>
