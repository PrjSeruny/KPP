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
  <link rel="stylesheet" type="text/css" href="<%=Constants.ROOT_PATH%><%=Constants.SCRIPTS_PATH%>/jquery.datetimepicker.css">
  <link rel="stylesheet" type="text/css" href="<%=Constants.ROOT_PATH%><%=Constants.SCRIPTS_PATH%>/content.css">
  <link rel="stylesheet" type="text/css" href="<%=Constants.ROOT_PATH%><%=Constants.SCRIPTS_PATH%>/fileUploadStyle.css">
  <script type="text/javascript" src="<%=Constants.ROOT_PATH%><%=Constants.SCRIPTS_PATH%>/jquery.min.js"></script>
  <script type="text/javascript" src="<%=Constants.ROOT_PATH%><%=Constants.SCRIPTS_PATH%>/jquery.livequery.min.js"></script>
  <script type="text/javascript" src="<%=Constants.ROOT_PATH%><%=Constants.SCRIPTS_PATH%>/jquery.form.js"></script>
  <script type="text/javascript" src="<%=Constants.ROOT_PATH%><%=Constants.SCRIPTS_PATH%>/jquery.datetimepicker.full.min.js"></script>
  <script type="text/javascript" src="<%=Constants.ROOT_PATH%><%=Constants.SCRIPTS_PATH%>/tinymce/tinymce.min.js"></script>
  <script type="text/javascript" src="<%=Constants.ROOT_PATH%><%=Constants.SCRIPTS_PATH%>/fileUploadScript.js"></script>
  <script type="text/javascript" src="<%=Constants.ROOT_PATH%><%=Constants.SCRIPTS_PATH%>/content.js"></script>
  <script type="text/javascript">
  $(function(){
    $('.date').livequery(function() {
        $.datetimepicker.setLocale('en');
        $(this).datetimepicker({
            timepicker:false,
            format:'d-m-Y',
            formatDate:'d-m-Y'
        });
    });
  });
  tinymce.init({
    selector: ".tiny",
	  theme: "modern",
	  menubar: false,
	  plugins: [
	      "advlist autolink lists link image charmap print preview hr anchor pagebreak",
	      "searchreplace wordcount visualblocks visualchars code fullscreen",
	      "insertdatetime media nonbreaking save table contextmenu directionality",
	      "emoticons template paste textcolor colorpicker textpattern"
	  ],
	  toolbar1: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image | print preview media | forecolor backcolor emoticons",
	    forced_root_block : 'div'
	});
  </script>
</head>
<body>
  <jsp:include page="<%=cp%>" flush="true"/>

  <div id="imagePreview">
    <span><img alt="" src=""><a href="javascript:void(0)" title="Tutup">x</a></span>
  </div>
	<form id="UploadForm" method="post"
	  enctype="multipart/form-data"
	  action="<%=Constants.ROOT_PATH + Constants.SERVLET_PATH%>">
	  <input type="file" size="60" id="myfile" name="myfile">
	
	  <div id="progressbox">
	    <div id="progressbar"></div>
	    <div id="percent">0%</div>
	  </div>
	  <div id="message"></div>
	</form>
</body>
</html>