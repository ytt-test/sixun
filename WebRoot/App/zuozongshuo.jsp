<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- 声明动态获取项目路径 --%>
<c:set value="${pageContext.request.contextPath }" var="path"></c:set>
<!DOCTYPE HTML>
<html>
<head>
<title>就业分析</title>
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
       <div class="box_1">
       	<h3>面试前的准备工作</h3>
        <div class="col-md-5">
        	<img src="images/1.png" class="img-responsive" alt=""/>
        </div>
        <a href="zuozong.jsp" class="btn_3">返回列表</a>
        <div class="col-md-7 service_box1">
        	<h5>&nbsp;&nbsp;&nbsp;&nbsp;准备的物品有：简历，签字笔，英语四六级证书（如果有的话）复印件，身份证复印件，成绩单，在校期间获得的一些荣誉证书复印件。</h5>
        	<p>&nbsp;&nbsp;&nbsp;&nbsp;简历打印成黑白的就可以了，不需要彩色的，这样会降低求职成本。有的同学以为彩色打印的简历是对企业的尊重，其实不是这样的，有很多企业看重的是实实在在的东西，所以我们还不如把里边的内容写实在了，少一些花里胡哨，多一些朴实无华。<br>
        	&nbsp;&nbsp;&nbsp;&nbsp;最好能经常随身携带笔记本。每天把自己要去求职的每一家公司名称，地址以及求职岗位记录下来，好的offer自然就来了 。我自己在大学毕业的时候就犯过这样的错误，只记得自己投出去了很多简历，却忘记了公司名称，有时甚至忘记自己投的岗位了，试想如此粗心大意，好职位，好企业能找到你吗？<br>
        	&nbsp;&nbsp;&nbsp;&nbsp;有自己专属的邮箱，有的同学图一时方便，只有QQ邮箱，我们可以申请一个简单好记的个人邮箱，比如：zhanghua@163.com，类似这种跟姓名相关的邮箱，不要太长，这样也好记，也显得正式一些。<br>&nbsp;&nbsp;&nbsp;&nbsp;最后准备一个比较好使用的手机，最起码要信号好，话费充足，这样才不会丢掉任何一个机会。
        	</p>
        	
        </div>
        <div class="clearfix"> </div>
       </div>
       <div class="box_3">
       	  <h3>游客留言</h3>
       	  <div class="col-md-6 testimonial">
		    <blockquote>
				<p>怎样给面试官留下好的印象？今天我有一场面试，觉得那个岗位很适合我，想给面试官留下好的印象，需要做些什么准备</p>
			</blockquote>
			<div class="author">
				<figure class="author-img">
					<img src="images/f2.jpg" class="img-responsive" alt=""/>
				</figure>
				<h6>董健东</h6>
				<span class="author-info">西安石油大学</span>
			</div>
		  </div>
		  <div class="col-md-6 testimonial">
		    <blockquote>
				<p>我是应届毕业生，毕业已经有一个月了，想出去找工作，但不知道自己都能干些什么，与专业相关的工作不想去做，想找一些其他行业的工作，我是学物流的，怎样给自己的职业定位</p>
			</blockquote>
			<div class="author">
				<figure class="author-img">
					<img src="images/f1.jpg" class="img-responsive" alt=""/>
				</figure>
				<h6>谢红红</h6>
				<span class="author-info">西京学院</span>
			</div>
		 </div>
		 <form>
			<div class="to">
             	<input type="text" class="text" value="姓名" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '姓名';}">
			 	<!-- <input type="text" class="text" value="Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}" style="margin-left:3%"> -->
			</div>
			<div class="text">
               <textarea  value="留言" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '留言';}">留言</textarea>
            </div>
            <div class="form-submit1">
	           <input name="submit" type="submit" id="submit" value="提交"><br>
	        </div>
			<div class="clearfix"></div>
          </form>
		 <div class="clearfix"> </div>
       </div>
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