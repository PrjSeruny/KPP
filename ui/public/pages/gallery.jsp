<%@page import="com.sync.core.utils.Utilities"%>
<%@page import="com.sync.core.pool.GalleryPool"%>
<%@page import="com.sync.core.beans.GalleryBean"%>
<%@page import="com.sync.home.utils.PublicConstants"%>
<%@page import="com.sync.core.utils.Constants"%>
<!DOCTYPE HTML>
<!-- Website Template by freewebsitetemplates.com -->
<%
GalleryPool gp = GalleryPool.getInstance();
GalleryBean[] lists = gp.getValue();
%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Company Profile</title>
	<link rel="stylesheet" href="<%=Constants.ROOT_PATH%><%=Constants.SCRIPTS_PATH%>/style.css" type="text/css">
    <link href="<%=Constants.ROOT_PATH%><%=Constants.SCRIPTS_PATH%>/themes/1/js-image-slider.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=Constants.ROOT_PATH%><%=Constants.SCRIPTS_PATH%>/jquery.min.js"></script>
    <script src="<%=Constants.ROOT_PATH%><%=Constants.SCRIPTS_PATH%>/themes/1/js-image-slider.js" type="text/javascript"></script>
    <script type="text/javascript" src="<%=Constants.ROOT_PATH%><%=Constants.SCRIPTS_PATH%>/fileUploadScript.js"></script>
  	<script type="text/javascript" src="<%=Constants.ROOT_PATH%><%=Constants.SCRIPTS_PATH%>/content.js"></script>
  	<link rel="stylesheet" type="text/css" href="<%=Constants.ROOT_PATH%><%=Constants.SCRIPTS_PATH%>/content.css">
  	<link rel="stylesheet" type="text/css" href="<%=Constants.ROOT_PATH%><%=Constants.SCRIPTS_PATH%>/fileUploadStyle.css">
	<!--[if IE 7]>
		<link rel="stylesheet" href="css/ie7.css" type="text/css">
	<![endif]-->
	<style>
.img-thumb{
    display: inline-block;
    width: 100px;
    height: 100px;
    border: solid 2px #C3C2C2;
    background-size: contain;
    background-position: center;
    background-repeat: no-repeat;
}
</style>
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
           <li class="selected">
               <a href="<%=Constants.ROOT_PATH%>/<%=PublicConstants.PUBLIC_GALLERY_PRM%>">Gallery</a>
           </li>
           <li>
               <a href="<%=Constants.ROOT_PATH%>/<%=PublicConstants.PUBLIC_CONTACT_PRM%>">Contact</a>
           </li>
      </ul>
		</div>
	</div>
	<style type="text/css">
	#body #content #section > img{
		float: left;
		margin: 0 7px 21px;
	}
	li { display: inline;}
	</style>
	<div id="body">
		<div id="content" style="background:white">
			<div id="section" style="width:880px">
				<h2 style="text-align: center;padding-bottom: 0px;">Album Gallery</h2>
				<div>
				<ul>
						<%
						for(int i=0;i<lists.length; i++)
						{
							%>
							<li><a href="javascript:void(0)" class="img-thumb imgview" imgpath="<%=Utilities.verifyImage(lists[i].getPath()) %>" style="background-image: url(<%=Utilities.verifyImage(lists[i].getPathThumb()) %>)"></a></li>
							<%
						}
						%>
						
					</ul>
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
  <div id="imagePreview">
    <span><img alt="" src=""><a href="javascript:void(0)" title="Tutup">x</a></span>
  </div>
</body>
</html> 