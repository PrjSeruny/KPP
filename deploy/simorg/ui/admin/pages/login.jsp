<%@page import="com.sync.core.utils.Constants,
                com.sync.master.beans.MasterUserBean,
                com.sync.master.utils.MasterConstants,
                com.sync.core.beans.MessageBean"
%>
<%
   MasterUserBean ubn = (MasterUserBean) session.getAttribute(MasterConstants.MASTERUSER);
   MessageBean msg = null;
   if(null!=ubn)  msg = ubn.getMessageBean();
%>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Login</title>
        <link rel="stylesheet" href="<%=Constants.ROOT_PATH%><%=Constants.SCRIPTS_PATH%>/login.css">
  </head>
  <body>
    <div class="wrapper">
        <div class="container">
            <h1>Welcome</h1>
            <form class="form" method="post" action="<%=Constants.ROOT_PATH + Constants.SERVLET_PATH%>?<%=Constants.D%>=<%=Constants.D_LOGON%>">
                <input type="hidden" name="<%=Constants.ACT%>" value="<%=Constants.ACT_LOGIN%>">
                <input type="text" placeholder="Username" name="<%=Constants.FORM_LOGIN_USERNAME%>">
                <input type="password" placeholder="Password" name="<%=Constants.FORM_LOGIN_PASSWD%>">
                <button type="submit" >Login</button><br>
                <%=null!=msg && null!=msg.getMessageBean(Constants.FORM_LOGIN_PASSWD)?msg.getMessageBean(Constants.FORM_LOGIN_PASSWD):""%>
            </form>
        </div>
        <ul class="bg-bubbles">
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>
    <div class="footer">Copyright &copy; 2015 by SyncProject</div>
    <script src='<%=Constants.ROOT_PATH%><%=Constants.SCRIPTS_PATH%>/jquery.min.js'></script>
    <script type="text/javascript">
     $("#login-button").click(function(event){
             event.preventDefault();
         
         $('form').fadeOut(500);
         $('.wrapper').addClass('form-success');
    });
     </script>
  </body>
</html>
