<!DOCTYPE HTML>
<%@page import="com.sync.home.utils.PublicConstants"%>
<%@page import="com.sync.core.utils.Constants"%>
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
				<li >
					<a href="<%=Constants.ROOT_PATH%><%=PublicConstants.SVT_PUBLIC_PATH%>?<%=Constants.W%>=<%=PublicConstants.PUBLIC_HOME_PRM%>">Home</a>
				</li>
				<li class="selected">
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
		</div>
	</div>
	<div id="body">
		<div class="content">
			<div id="section">
				<h2>about</h2>
				<p>
					We Have Free Templates for Everyone. Our website templates are created with inspiration, checked for quality and originality and meticulously sliced and coded. <b>What's more, they're absolutely free! You can do a lot with them. You can modify them.</b>
				</p>
				<img src="images/old-couple.jpg" alt="">
				<div class="article">
					<div>
						<h3>We Have Free Templates for <br> Everyone</h3>
						<p>
							You can use them to design websites for clients, so long as you agree with the <a href="http://www.freewebsitetemplates.com/about/terms">Terms of Use</a>. You can even remove all our links if you want to.
						</p>
						<h3>We Have More Templates for You</h3>
						<p>
							Looking for more templates? Just browse through all our <a href="http://www.freewebsitetemplates.com/">Free Website Templates</a> and find what you're looking for. But if you don't find any website template you can use, you can try our <a href="http://www.freewebsitetemplates.com/freewebdesign/">Free Web Design</a> service and tell us all about it. Maybe you're looking for something different, something special. And we love the challenge of doing something different and something special.
						</p>
					</div>
					<div>
						<h3>Be Part of Our Community</h3>
						<p>
							If you're experiencing issues and concerns about this website template, join the discussion on <a href="http://www.freewebsitetemplates.com/forums/">on our forum</a> and meet other people in the community who share the same interests with you.
						</p>
						<h3>Template details</h3>
						<p>
							Design version 4
						</p>
						<p>
							Code version 3
						</p>
						<p>
							Website Template details, discussion and updates for this <a href="http://www.freewebsitetemplates.com/discuss/cardiologywebsitetemplate/">Cardiology Website Template</a>.
						</p>
						<p>
							Website Template design by <a href="http://www.freewebsitetemplates.com/">Free Website Templates</a>.
						</p>
						<p>
							Please feel free to remove some or all the text and links of this page and replace it with your own About content.
						</p>
					</div>
				</div>
			</div>
			<div id="sidebar">
				<!-- <div class="search">
					<h3>search</h3>
					<form action="index.html">
						<input type="text" name="search" id="search" value="Search here...">
						<input type="hidden" name="submit" id="submitBtn" value="">
					</form>
				</div> -->
				<!-- <div class="testimonials">
					<h3>patients' testimonials</h3>
					<ul>
						<li>
							<p>
								Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus in vestibulum mi. Donec felis nunc, placerat quis varius quis. In convallis pulvinar rutrum. Suspendisse nec mi lectus, at fermentum felis.
							</p>
							<a href="#" >-Mr.Robinson, Ohio</a>
						</li>
						<li>
							<p>
								Sed vehicula dui ac odio dictum a luctus purus aliquam. Suspendisse potenti. Integer feugiat dolor ut odio tincidunt pulvinar. Suspendisse eget mauris sapien, sed convallis purus.
							</p>
							<a href="#" >-John Mainstreet, Minnesota</a>
						</li>
						<li>
							<p>
								Morbi dignissim nunc sed metus faucibus venenatis. Etiam eu purus sit amet velit semper adipiscing non et est. Cras vulputate blandit nulla, ac tristique velit pellentesque et.
							</p>
							<a href="#" >-Jessica Greene, New York</a>
						</li>
					</ul>
				</div> -->
				<div class="awards">
					<h3>awards</h3>
					<a href="#" class="first"><img src="images/award.jpg" alt=""></a> <a href="#"><img src="images/award2.jpg" alt=""></a>
				</div>
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