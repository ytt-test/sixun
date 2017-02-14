<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- 声明动态获取项目路径 --%>
<c:set value="${pageContext.request.contextPath }" var="path"></c:set>
<!DOCTYPE HTML>
<html>
<head>
<title>就业信息</title>
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
<!--font-Awesome-->
<style type="text/css">
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
	        
	        <a class="navbar-brand" href="index.jsp"><!--<img src="images/logo.png" alt=""/>--><span id="x1">思迅人才网</span></a>
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
			           <!--  <li><a href="jobs.jsp">模拟就业</a></li> -->
			            <li><a href="dangan.jsp">学籍档案</a></li>
			            <!-- <li><a href="jobs.jsp">常见问题</a></li> -->
		            </ul>
		        </li>
		        <li class="dropdown">
		            <a href="chuangyezhichi.jsp" class="dropdown-toggle" >创业支持</a>
		            
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
      <div class="col-sm-10 follow_left">
			<h3>就业明星</h3>
             <div class="follow_jobs">
			    <a>
					<img src="images/f1.jpg" alt="" class="img-circle img-responsive">
					<div class="title">
						<h5>CCNP&nbsp;&nbsp;&nbsp;&nbsp;周松泉</h5>
						<p>学员周松泉，毕业于西安邮电大学，通过我中心CCNP课程的努力学习，成功就职于武汉烽火科技，年薪8万.</p>
					</div>
					<!-- <div class="data">
						<span class="city"><i class="fa fa-map-marker"></i>New York City</span>
						<span class="type full-time"><i class="fa fa-clock-o"></i>Full Time</span>
						<span class="sallary"><i class="fa fa-dollar"></i>45,000</span>
					</div> -->
				</a>
				<a >
					<div class="featured"></div>
					<img src="images/f2.jpg" alt="" class="img-circle">
					<div class="title">
						<h5>CCIE&nbsp;&nbsp;&nbsp;&nbsp;雷田媛</h5>
						<p>学员雷田媛，毕业于西安邮电大学，通过我中心CCIE课程的努力学习，成功就职于华为科技有限公司，年薪15万.</p>
					</div>
					
				</a>
				<a href=>
					<img src="images/f3.jpg" alt="" class="img-circle">
					<div class="title">
						<h5>CCIE&nbsp;&nbsp;&nbsp;&nbsp;戴凯莉</h5>
						<p>学员戴凯莉，在我中心学习CCIE课程，成功就职于海康威视，月薪 9000元。</p>
					</div>
					
				</a>
				<a >
					<img src="images/f4.jpg" alt="" class="img-circle">
					<div class="title">
						<h5>CCIE&nbsp;&nbsp;&nbsp;&nbsp;陈尔文</h5>
						<p>学员陈尔文，在我中心参加CCIE学习，成功就职于上海合达，年薪10万。</p>
					</div>
					<!-- <div class="data">
						<span class="city"><i class="fa fa-map-marker"></i>Boston</span>
						<span class="type full-time"><i class="fa fa-clock-o"></i>Full Time</span>
						<span class="sallary"><i class="fa fa-dollar"></i>55,000</span>
					</div> -->
				</a>
				<a>
					<div class="featured"></div>
					<img src="images/f1.jpg" alt="" class="img-circle">
					<div class="title">
						<h5>CCNP&nbsp;&nbsp;&nbsp;&nbsp;侯群群</h5>
						<p>学员侯群群，通过在我中心参加CCNP学习，成功就职于绿盟科技，月薪6500元。</p>
					</div>
					
				</a>
				<a class="hidden-job">
					<img src="images/f2.jpg" alt="" class="img-circle">
					<div class="title">
						<h5>CCIE&nbsp;&nbsp;&nbsp;&nbsp;沈鑫</h5>
						<p>学员沈鑫，通过在我中心参加CCIE学习，成功就业与志成电子，月薪7000元。</p>
					</div>
					
				</a>
				<a class="hidden-job">
					<img src="images/f3.jpg" alt="" class="img-circle">
					<div class="title">
						<h5>CCNP&nbsp;&nbsp;&nbsp;&nbsp;刘涛</h5>
						<p>学员刘涛，通过在我企业学习CCNP，成功就职于中兴电子，月薪9000元。</p>
					</div>
					
				</a>
				
				<ul class="pagination">
					<li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
					<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
					<!-- <li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li> -->
					<li><a href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
			   </ul>
		    </div>
		</div>
		<div class="col-sm-2">
			<h4 class="m_1">热门标签</h4>
			<table class="table">
                    <tbody>
                        <tr class="unread checked">
                            <td class="hidden-xs">网络工程师</td>
                        </tr>
                       <tr class="unread checked">
                            <td class="hidden-xs">数据中心</td>
                        </tr>
                        <tr class="unread checked">
                            <td class="hidden-xs">Linux</td>
                        </tr>
                        <tr class="unread checked">
                            <td class="hidden-xs">WEB前端</td>
                        </tr>
                        <tr class="unread checked">
                            <td class="hidden-xs">路由&交换</td>
                        </tr>
                        <tr class="unread checked">
                            <td class="hidden-xs">安全</td>
                        </tr>
                        <tr class="unread checked">
                            <td class="hidden-xs">运营商</td>
                        </tr>
                        <tr class="unread checked">
                            <td class="hidden-xs">协作</td>
                        </tr>
                </tbody>
             </table>
             <h4 class="m_1">热门新闻</h4>
             <table class="table">
                    <tbody>
                        <tr class="unread checked">
                        	<td class="hidden-xs">热烈庆祝内蒙古农业大学来我中心</td>
                        </tr>
                        <tr class="unread checked">
                        	<td class="hidden-xs">热烈庆祝红星美凯龙来我中心参加</td>
                        </tr>
                        <tr class="unread checked">
                        	<td class="hidden-xs">西安大学生就业创业联盟工作研讨</td>
                        </tr>
                        <tr class="unread checked">
                        	<td class="hidden-xs">思迅师资力量介绍</td>
                        </tr>
                        <tr class="unread checked">
                        	<td class="hidden-xs">西安市人力资源和社会保障局授予</td>
                        </tr>
                        <tr class="unread checked">
                        	<td class="hidden-xs">0学费入学成现实，政府补助等你</td>
                        </tr>
                </tbody>
             </table>
            </div>
		<div class="clearfix"> </div>
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