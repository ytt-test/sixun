<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- 声明动态获取项目路径 --%>
<c:set value="${pageContext.request.contextPath }" var="path"></c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<script language="javascript">
	function asd(count, url) {
		document.getElementById("div1").style.display = "block";
		var sp = document.getElementById('sp');
		sp.innerHTML = count;
		if (--count > 0)
			setTimeout("asd(" + count + ",'" + url + "')", 1000);
		else
			location.href = url;
	}
</script>
<style>
.button {
	background-color: green; /* Green */
	border-radius: 5px;
	color: white;
	padding: 10px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 10px;
	position: relative;
	top: 400px;
}


.button1:hover {
	background-color: white;
	color: black;
	border: 2px solid #4CAF50;
}

.button1 {
	background-color: #4CAF50;
	color: white;
}
</style>
</head>
<body>
	<div align="center">
		<br />
		<input class="button button1" type="button"
			onclick="asd(5,'register.jsp');" value="点击跳转" />
		<div id="div1" style="display:none;">
			<span id="sp"></span>秒后自动跳转注册页面
		</div>
		<div class="img" align="center" >
			<img src="${path}/App/images/zhuceshibai.png" alt="" />
		</div>
</body>
</html>