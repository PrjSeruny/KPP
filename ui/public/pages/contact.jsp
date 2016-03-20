<%@page import="com.sync.core.beans.CompanyBean"%>
<%@page import="com.sync.core.pool.CompanyPool"%>
<%@page import="com.sync.home.utils.PublicConstants"%>
<%@page import="com.sync.core.utils.Constants"%>
<!DOCTYPE HTML>
<!-- Website Template by freewebsitetemplates.com -->
<%
CompanyPool cp = CompanyPool.getInstance();
CompanyBean cb = new CompanyBean();
String latitude = cp.get(Constants.COMPANY_LAT_PARAM).getValue();
String longitude = cp.get(Constants.COMPANY_LONG_PARAM).getValue(); 
%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Company Profile</title>

	<link rel="stylesheet" href="<%=Constants.ROOT_PATH%><%=Constants.SCRIPTS_PATH%>/style.css" type="text/css">
    <link href="<%=Constants.ROOT_PATH%><%=Constants.SCRIPTS_PATH%>/themes/1/js-image-slider.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=Constants.ROOT_PATH%><%=Constants.SCRIPTS_PATH%>/jquery.min.js"></script>
    <script src="<%=Constants.ROOT_PATH%><%=Constants.SCRIPTS_PATH%>/themes/1/js-image-slider.js" type="text/javascript"></script>
	<!--[if IE 7]>
		<link rel="stylesheet" href="css/ie7.css" type="text/css">
	<![endif]-->
	<style>
      #map {
        width: 500px;
        height: 400px;
      }
    </style>
	<script>
      function initMap() {
        var mapDiv = document.getElementById('map');
        var map = new google.maps.Map(mapDiv, {
          center: {lat: <%=latitude%>, lng: <%=longitude%>},
          zoom: 8
        });
      }
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?callback=initMap"
    async defer></script>
</head>
<body>
	<div id="header">
		<div>
			<ul>
          <li>
              <a href="<%=Constants.ROOT_PATH%>/<%=PublicConstants.PUBLIC_HOME_PRM%>">Home</a>
          </li>
          <li>
              <a href="<%=Constants.ROOT_PATH%>/<%=PublicConstants.PUBLIC_ABOUT_PRM%>">About</a>
          </li>
          <li>
              <a href="<%=Constants.ROOT_PATH%>/<%=PublicConstants.PUBLIC_NEWS_PRM%>">News</a>
          </li>
          <li>
              <a href="<%=Constants.ROOT_PATH%>/<%=PublicConstants.PUBLIC_GALLERY_PRM%>">Gallery</a>
          </li>
          <li class="selected">
              <a href="<%=Constants.ROOT_PATH%>/<%=PublicConstants.PUBLIC_CONTACT_PRM%>">Contact</a>
          </li>
      </ul>
		</div>
	</div>
	<div id="body">
		<div class="content">
			<div id="section">
				<h2>contact</h2>
				<b><a href="#">visit our office</a></b> 
				<div id="map"></div> 
				<!-- <b><a href="#">visit our vancouver office</a></b> 
				<img src="images/vancouver.jpg" alt=""> -->
				<form action="index.html">
					<b>send us a message</b> <span>Please feel free for send us a message </span>
					<input type="text" name="fname" id="fname" value="Name">
					<input type="text" name="email" id="email" value="Email Addess">
					<!-- <select name="offices">
						<option>Choose Clinic Office</option>
					</select> -->
					<textarea name="message" id="message" cols="30" rows="10">Write Message Here...</textarea>
					<input type="submit" name="send" id="send" value="send message">
				</form>
			</div>
			<div id="sidebar">
				<div class="contact">
					<h3>contact information</h3>
					<ul class="first">
						<li class="office">
							<b>our office</b><span>
							<%
							cb = cp.get(Constants.COMPANY_ADDRESS_PARAM);
							out.println(cb.getValue());
							%>
							</span>
						</li>
						<li class="telephone">
							<%
							cb = cp.get(Constants.COMPANY_PHONE_PARAM);
							out.println(cb.getValue());
							%>
						</li>
						<li class="fax">
							<%
							cb = cp.get(Constants.COMPANY_FAX_PARAM);
							out.println(cb.getValue());
							%>
						</li>
						<li class="email">
							<a href="#">
							<%
							cb = cp.get(Constants.COMPANY_EMAIL_PARAM);
							out.println(cb.getValue());
							%>
							</a>
						</li>
					</ul>
			</div>
		</div>
	</div>
	<div id="footer">
		<div>
			<p>
				Copyright &copy; <a href="index.html">Sync Project</a>
			</p>
			<ul>
                <li>
                    <a href="<%=Constants.ROOT_PATH%><%=PublicConstants.SVT_PUBLIC_PATH%>?<%=Constants.W%>=<%=PublicConstants.PUBLIC_HOME_PRM%>">Home</a>
                </li>
                <li>
                    <a href="<%=Constants.ROOT_PATH%><%=PublicConstants.SVT_PUBLIC_PATH%>?<%=Constants.W%>=<%=PublicConstants.PUBLIC_ABOUT_PRM%>">About</a>
                </li>
                <li>
                    <a href="<%=Constants.ROOT_PATH%><%=PublicConstants.SVT_PUBLIC_PATH%>?<%=Constants.W%>=<%=PublicConstants.PUBLIC_NEWS_PRM%>">News</a>
                </li>
                <li>
                    <a href="<%=Constants.ROOT_PATH%><%=PublicConstants.SVT_PUBLIC_PATH%>?<%=Constants.W%>=<%=PublicConstants.PUBLIC_GALLERY_PRM%>">Gallery</a>
                </li>
                <li>
                    <a href="<%=Constants.ROOT_PATH%><%=PublicConstants.SVT_PUBLIC_PATH%>?<%=Constants.W%>=<%=PublicConstants.PUBLIC_CONTACT_PRM%>">Contact</a>
                </li>
                <!-- <li>
                    <a href="forms.html">forms</a>
                </li>
                <li>
                    <a href="blog.html">blog</a>
                </li> -->
            </ul>
			<div>
				<span>stay connected:</span>
				<a href="#" id="facebook">facebook</a>
				<a href="#" id="twitter">twitter</a>
				<a href="#" id="googleplus">googleplus</a>
			</div>
		</div>
	</div>
</body>
</html>