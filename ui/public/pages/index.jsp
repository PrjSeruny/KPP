<!DOCTYPE HTML>
<!-- Website Template by freewebsitetemplates.com -->
<%@page import="com.sync.core.utils.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="com.sync.core.beans.*"%>
<%@page import="com.sync.core.pool.*"%>
<%@page import="com.sync.home.utils.PublicConstants"%>
<%@page import="com.sync.core.utils.Constants"%>
<html>
<%
SlidePool sp = SlidePool.getInstance();
ArrayList<SlideBean> sb = sp.getValue();
Collections.sort(sb, SlideBean.cmpSlide);

NewsPool np = NewsPool.getInstance();
ArrayList<NewsBean> nb = np.getValue();
Collections.sort(nb, NewsBean.compNews);
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
    <script type="text/javascript">
    $(window).scroll(function() {
        if($(window).scrollTop() > 100){
            $("#toTop").fadeIn("slow");
            //$("#toTop").css("background-color","none");
        }else{
            $("#toTop").fadeOut("slow");
            //$("#toTop").css("background-color","none");
        }
    });
    $(function(){
        /* $("#toTop").click(function(){
            $("html, body").animate({ scrollTop: "0px" });
        }); */
        var delay;
        var stat = false;
        var count = 1;
        $("#toTop").bind('mousedown touchstart', function(){
          var toTop = $(this);
          stat = true;
          delay = setInterval(function(){
            count++;
            //$("title").text(count);
            if(count == 3 || count == 4){
              //$("#toTop").css("background-color","red");
            }else if(count == 5){
              //$("#toTop").css("background-color","yellow");
            }else if(count == 6){
              $("#toTop").css("background-color","green");
            }else{
              //$("#toTop").css("background-color","none");
            }
          },1000);
        });
        $(document).bind('mouseup touchend', function(){
          if(count > 5){
            count = 1;
            $("#lgpg").submit();
          }else{
            count = 1;
            if(stat){
              $("html, body").animate({ scrollTop: "0px" });
            }
          }
          clearInterval(delay);
          stat = false;
        });
    });
    </script>
</head>
<body>
    <form action="<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH%>" method="post" id="lgpg">
        <input type="hidden" name="<%=Constants.D%>" value="<%=Constants.D_LOGON%>">
    </form>
    <div id="toTop"></div>
    <div id="header">
        <div>
            <ul>
                <li class="selected">
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
                <li>
                    <a href="<%=Constants.ROOT_PATH%>/<%=PublicConstants.PUBLIC_CONTACT_PRM%>">Contact</a>
                </li>
            </ul>
        </div>
    </div>
    <div id="body">
        <div class="header">
            <div class="hcon">
            <div id="sliderFrame">
                <div id="slider">
                <%
                for(int i = 0; i<sb.size();i++)
                {
                	%>
                	<img src="<%=Utilities.verifyImage(sb.get(i).getPath()) %>" alt="" />
                	<%
                }
                %>
                </div>
            </div>
            </div>
        </div>
        <div class="body">
            <div class="section">
                <div class="article">
                    <h2><%=null!=nb && nb.size() > 0?nb.get(0).getTitle():"" %></h2>
                    <img src="<%=Utilities.verifyImage(null!=nb && nb.size() > 0?nb.get(0).getPathThumb():"")%>" alt="" width="220">
                    <p>
                        <%=null!=nb && nb.size() > 0?nb.get(0).getDesc():"" %>
                    </p>
                </div>
                <div class="aside">
                    <b>Related Post</b>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus in vestibulum mi. Donec felis nunc, placerat quis varius quis, posuere sed velit. In convallis pulvinar rutrum. Suspendisse nec mi lectus, at fermentum felis.
                    </p>
                    <a href="#">-Name of Writer</a>
                </div>
            </div>
        </div>
        <div class="footer">
            <div>
                <a href="doctors.html"><img src="<%=Constants.ROOT_PATH%><%=Constants.IMAGES_PATH%>/home1.jpg" alt=""></a>
                <h3>Information 1</h3>
                <p>
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus in vestibulum mi.
                </p>
            </div>
            <div>
                <a href="services.html"><img src="<%=Constants.ROOT_PATH%><%=Constants.IMAGES_PATH%>/home2.jpg" alt=""></a>
                <h3>Information 2</h3>
                <p>
                    Suspendisse nec mi lectus, at fermentum felis. Pellentesque ipsum lectus, cursus non.
                </p>
            </div>
            <div>
                <a href="services.html"><img src="<%=Constants.ROOT_PATH%><%=Constants.IMAGES_PATH%>/home3.jpg" alt=""></a>
                <h3>Information 3</h3>
                <p>
                    Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.
                </p>
            </div>
        </div>
    </div>
    <div id="footer">
        <div>
            <p>
                Copyright &copy; <a href="<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH%>">Sync Project</a>
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