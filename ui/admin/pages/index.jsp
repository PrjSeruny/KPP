<!DOCTYPE HTML>
<!-- Website Template by freewebsitetemplates.com -->
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
    <script type="text/javascript">

    // By default, data/elements cannot be dropped in other elements. To allow a drop, we must prevent the default handling of the element
    document.addEventListener("dragover", function(event) {
        event.preventDefault();
    });
    document.addEventListener("drop", function(event) {
        event.preventDefault();
        if ( event.target.id == "toTop" ) {
            var data = event.dataTransfer.getData("Text");
            //alert(data);
            if(data=="lp"){
                //window.location.href="login.html";
                $("#lgpg").submit();
            }
            
        }
    });
    document.addEventListener("dragstart", function(event) {
        // The dataTransfer.setData() method sets the data type and the value of the dragged data
        event.dataTransfer.setData("Text", event.target.id);
    });

    $(window).scroll(function() {
        if($(window).scrollTop() > 100){
            $("#toTop").fadeIn("slow");
        }else{
            $("#toTop").fadeOut("slow");
        }
    });
    $(function(){
        $("#toTop").click(function(){
            $("html, body").animate({ scrollTop: "0px" });
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
                    <a href="<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH%>">Home</a>
                </li>
                <li>
                    <a href="<%=Constants.ROOT_PATH%><%=Constants.PAGES_PATH%>/about.html">About</a>
                </li>
                <li>
                    <a href="<%=Constants.ROOT_PATH%><%=Constants.PAGES_PATH%>/blog.html">News</a>
                </li>
                <li>
                    <a href="<%=Constants.ROOT_PATH%><%=Constants.PAGES_PATH%>/services.html">Gallery</a>
                </li>
                <li>
                    <a href="<%=Constants.ROOT_PATH%><%=Constants.PAGES_PATH%>/contact.html">Contact</a>
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
        <div class="header">
            <div class="hcon">

            <div id="sliderFrame">
                <div id="slider">
                    <img src="<%=Constants.ROOT_PATH%><%=Constants.IMAGES_PATH%>/1.jpg" alt="" />
                    <img src="<%=Constants.ROOT_PATH%><%=Constants.IMAGES_PATH%>/2.jpg" alt="" />
                    <img src="<%=Constants.ROOT_PATH%><%=Constants.IMAGES_PATH%>/3.jpg" alt="" />
                </div>
            </div>
                <!-- <img src="images/biking.jpg" alt=""> -->
                <ul>
                    <li>
                        <a href="#">LINK 1</a>
                    </li>
                    <li>
                        <a href="#" id="lp">LINK 2</a>
                    </li>
                    <li>
                        <a href="#">LINK 3</a>
                    </li>
                    <li>
                        <a href="#">LINK 4</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="body">
            <div class="section">
                <div class="article">
                    <h2>News Information</h2>
                    <img src="<%=Constants.ROOT_PATH%><%=Constants.IMAGES_PATH%>/piclib/Loyalis.jpg" alt="" width="220">
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus in vestibulum mi. Donec felis nunc, placerat quis varius quis, posuere sed velit. In convallis pulvinar rutrum. Suspendisse nec mi lectus, at fermentum felis. Pellentesque ipsum lectus, cursus non pharetra vitae, placerat vitae tellus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.
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
                    <a href="<%=Constants.ROOT_PATH%><%=Constants.SERVLET_PATH%>">home</a>
                </li>
                <li>
                    <a href="<%=Constants.ROOT_PATH%><%=Constants.PAGES_PATH%>/about.html">about</a>
                </li>
                <li>
                    <a href="<%=Constants.ROOT_PATH%><%=Constants.PAGES_PATH%>/blog.html">news</a>
                </li>
                <li>
                    <a href="<%=Constants.ROOT_PATH%><%=Constants.PAGES_PATH%>/services.html">gallery</a>
                </li>
                <li>
                    <a href="<%=Constants.ROOT_PATH%><%=Constants.PAGES_PATH%>/contact.html">contact</a>
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