<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- 声明动态获取项目路径 --%>
<c:set value="${pageContext.request.contextPath }" var="path"></c:set>
<!DOCTYPE HTML>
<html>
<head>
<title>联系我们</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Seeking Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap-3.1.1.min.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href='http://fonts.useso.com/css?family=Roboto:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
<!--font-Awesome-->
<link href="css/font-awesome.css" rel="stylesheet"> 
<!---font-Awesome-->
<style media="screen">
#x1{
	font-size: 30px;
	color: #ffffff;
	position: absolute;
	top: 20px;
}
</style>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
	<div class="container">
	    <div class="navbar-header">
	        <a class="navbar-brand" href="index.jsp"><span id="x1">思迅人才网</span></a>
	    </div>
	    <!--/.navbar-header-->
	    <div class="navbar-collapse collapse" id="bs-example-navbar-collapse-1" style="height: 1px;">
	        <ul class="nav navbar-nav">
	        	<li><a href="index.jsp">首页</a></li>
		        <li class="dropdown">
		        	<a href="zhaopinxinxi.jsp">招聘信息</a>
		        </li>
		        <li class="dropdown">
		        	<a href="peixunkecheng.jsp">技能培训</a>
		        </li>
		        <li class="dropdown">
		            <a href="#" class="dropdown-toggle" data-toggle="dropdown">就业服务<b class="caret"></b></a>
		            <ul class="dropdown-menu">
			            <li><a href="jiuye.jsp">就业信息</a></li>
			            <li><a href="zuozong.jsp">就业指导</a></li>
			            <!-- <li><a href="jobs.jsp"></a></li> -->
			            <!-- <li><a href="jobs.jsp">模拟就业</a></li> -->
			            <li><a href="dangan.jsp">学籍档案</a></li>
			            <!-- <li><a href="jobs.jsp">常见问题</a></li> -->
		            </ul>
		        </li>
		        <li class="dropdown">
		            <a href="chuangyezhichi.jsp" class="dropdown-toggle">创业支持</a>
		        </li>
		        
		        <li><a href="lianxiwomen.jsp">联系我们</a></li>
	        </ul>
	    </div>
	    <div class="clearfix"> </div>
	  </div>
	    <!--/.navbar-collapse-->
	</nav>
<div class="banner_1">
	<div class="container">
		<div id="search_wrapper1">
		   <div id="search_form" class="clearfix">
		    <h1>Start your job search</h1>
		    <p>
			 <input type="text" class="text" placeholder=" " value="Enter Keyword(s)" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Enter Keyword(s)';}">
			 <input type="text" class="text" placeholder=" " value="Location" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Location';}">
			 <label class="btn2 btn-2 btn2-1b"><input type="submit" value="Find Jobs"></label>
			</p>
           </div>
		</div>
   </div> 
</div>	
<div class="container">
    <div class="single">  
	   <div class="contact_top" style="height: 600px">
	   	 <h2>联系我们</h2>
			<br/><br/><br/><br/><br/>
          <div class="col-sm-4">
	   	   <address class="addr">
                <p class="secondary3">
                   地址：<br/>&nbsp;&nbsp;&nbsp;&nbsp;西安市西斜七路十字西北角紫薇龙腾新世界1号楼<br/>2504室</p>
                <p class="secondary3">电话：<br>&nbsp;&nbsp;&nbsp;&nbsp;4008-505-369、029-68029335、029-68208993</p>
                <p class="secondary3">交通：<br>&nbsp;&nbsp;&nbsp;&nbsp;乘坐教育专线、6路、14路、14路区间、16路、<br>34路、35路、205路、210路、218路、219路、<br>220路、268路、311路、313路、322路、400路、<br>411路、503路、506路、508路、900路、900路区间、<br>916路在西斜七路站下车即可</p>
           </address>
          </div>
	   </div>
	   <div  id="ditu"><iframe " width="716px" height="500px"  src="amp.jsp" frameborder=0></iframe> </div>
    </div>
</div>
<div class="footer_bottom">
  <div class="container">
    <div class="col-sm-2">
  		<ul class="f_list2">
			<li><a>关于我们</a></li>
			<li><a href="index.jsp">公司介绍</a></li>
			<li><a href="index.jsp">企业文化</a></li>
			<li><a href="index.jsp">联系我们</a></li>
	    </ul>
  	</div>
  	<div class="col-sm-2">
  		<ul class="f_list2">
			<li><a>新闻中心</a></li>
			<li><a href="index.jsp">企业新闻</a></li>
			<li><a href="index.jsp">行业资讯</a></li>
			<li><a href="index.jsp">网站公告</a></li>
	    </ul>
  	</div>
  	<div class="col-sm-2">
  		<ul class="f_list2">
			<li><a>课程体系</a></li>
			<li><a href="index.jsp">网络工程师</a></li>
			<li><a href="index.jsp">WEB工程师</a></li>
			<li><a href="index.jsp">JAVA工程师</a></li>
	    </ul>
  	</div>
  	<div class="col-sm-2">
       <ul class="f_list2">
			<li><a>企业合作</a></li>
			<li><a href="index.jsp"></a></li>
			<li><a href="index.jsp"></a></li>
			<li><a href="index.jsp"></a></li>
	    </ul>
  	</div>
  	<div class="col-sm-2">
       <ul class="f_list2">
			<li><a>人才网</a></li>
			<li><a href="index.jsp"></a></li>
			<li><a href="index.jsp"></a></li>
			<li><a href="index.jsp"></a></li>
	    </ul>
  	</div>
  	<div class="col-sm-2">
       <ul class="f_list2">
			<li><a>联系我们</a></li>
			<li><a href="index.jsp"></a></li>
			<li><a href="index.jsp"></a></li>
			<li><a href="index.jsp"></a></li>
	    </ul>
  	</div>
  	<div class="clearfix"> </div>
	<div class="copy">
		<p>西安思迅电子信息技术有限公司&nbsp;&nbsp; 版权所有&nbsp;&nbsp; 陕ICP备14003943号 &copy; 2014-2017 Secent.Net ALL RIGHTS RESERVED </p>
	</div>
  </div>
</div>
</body>
</html>			