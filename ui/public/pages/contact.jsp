<%@page import="com.sync.home.utils.PublicConstants"%>
<%@page import="com.sync.core.utils.Constants"%>
<!DOCTYPE HTML>
<!-- Website Template by freewebsitetemplates.com -->
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
				<img src="images/florida.jpg" alt=""> 
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
				<!-- <div class="search">
					<h3>search</h3>
					<form action="index.html">
						<input type="text" name="search" id="search" value="Search here...">
						<input type="hidden" name="submit" id="submitBtn" value="">
					</form>
				</div> -->
				<div class="contact">
					<h3>contact information</h3>
					<ul class="first">
						<li class="office">
							<b>our office</b><span>Jl.Patemon 1/4, Surabaya</span>
						</li>
						<li class="telephone">
							561-574-0800
						</li>
						<li class="fax">
							561-574-0811
						</li>
						<li class="email">
							<a href="#">info@domain.com</a>
						</li>
					</ul>
					<!-- <ul>
						<li class="office">
							<b>vancouver office</b><span>471 melody Lane Richmond, VA 23225</span>
						</li>
						<li class="telephone">
							804-417-2482
						</li>
						<li class="fax">
							804-417-2483
						</li>
						<li class="email">
							<a href="http://www.freewebsitetemplates.com/misc/contact">info@fl.cardiocenter.com</a>
						</li>
					</ul> -->
				</div>
				<!-- <div>
					<h3>office hours:</h3>
					<span>Monday - Friday <span>7:00 a.m. - 4:30 p.m.</span></span> <span>Saturdays &amp; Sundays <span>7:00 a.m. - 12:00 p.m.</span></span>
				</div> -->
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