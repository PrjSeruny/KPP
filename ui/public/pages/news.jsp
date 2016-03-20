<%@page import="com.sync.core.utils.Utilities"%>
<%@page import="java.util.Collections"%>
<%@page import="com.sync.core.beans.NewsBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sync.core.pool.NewsPool"%>
<%@page import="com.sync.home.utils.PublicConstants"%>
<%@page import="com.sync.core.utils.Constants"%>
<!DOCTYPE HTML>
<!-- Website Template by freewebsitetemplates.com -->
<html>
<%
NewsPool sp = NewsPool.getInstance();
ArrayList<NewsBean> sb = sp.getValue();
Collections.sort(sb, NewsBean.compNews);
%>
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
                <li class="selected">
                    <a href="<%=Constants.ROOT_PATH%>/<%=PublicConstants.PUBLIC_NEWS_PRM%>">News</a>
                </li>
                <li>
                    <a href="<%=Constants.ROOT_PATH%>/<%=PublicConstants.PUBLIC_GALLERY_PRM%>">Gallery</a>
                </li>
                <li>
                    <a href="<%=Constants.ROOT_PATH%>/<%=PublicConstants.PUBLIC_CONTACT_PRM%>">Contact</a>
                </li>
            </ul>
		</div>
	</div>
	<div id="body">
		<div class="content">
			<div id="blog">
				<ul>
					<%
					for(int i=0;i<sb.size();i++)
					{
						%>
						<li>
							<div class="article">
								<h3><%=sb.get(i).getTitle() %></h3>
								<p>
									<%=sb.get(i).getDesc() %>
								</p>
								<a href="#" class="more">readmore</a>
							</div>
							<div class="stats">
								<img src="<%=Utilities.verifyImage(sb.get(i).getPathThumb())%>" alt="">
							</div>
						</li>
						<%
					}
					%>
				</ul>
				<ul class="paging">
					<li class="first">
						<a href="#">next</a>
					</li>
					<li class="selected">
						<a href="#">1</a>
					</li>
					<li>
						<a href="#">2</a>
					</li>
					<li>
						<a href="#">3</a>
					</li>
					<li class="last">
						<a href="#">previous</a>
					</li>
				</ul>
			</div>
			<div id="sidebar">
				<div class="search">
					<h3>search news</h3>
					<form action="index.html">
						<input type="text" name="search" id="search" value="Search here...">
						<input type="hidden" name="submit" id="submitBtn" value="">
					</form>
				</div>
				<div class="category">
					<h3>News categories</h3>
					<ul>
						<li>
							<a href="blog-single.html">Category 1</a>
						</li>
						<li>
							<a href="blog-single.html">Category 2</a>
						</li>
						<li>
							<a href="blog-single.html">Category 3</a>
						</li>
						<li>
							<a href="blog-single.html">Category 4</a>
						</li>
						<li>
							<a href="blog-single.html">Category 5</a>
						</li>
					</ul>
				</div>
				<div class="posts">
					<h3>popular posts</h3>
					<ul>
						<li>
							<a href="blog-single.html">News title 2</a>
						</li>
						<li>
							<a href="blog-single.html">News title 1</a>
						</li>
						<li>
							<a href="blog-single.html">News title 3</a>
						</li>
					</ul>
				</div>
				<!-- <div class="tweets">
					<h3>recent tweets</h3>
					<ul>
						<li>
							<a href="#">Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Donec suscipit nibh diam, quis sodales turpis. <i>(30 mins ago)</i></a>
						</li>
						<li>
							<a href="#">In non erat ac ante commodo lacinia. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed imperdiet arcu ut massa fermentum non porttitor mi pretium. <i>(1 hour ago)</i></a>
						</li>
					</ul>
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