<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<c:set value="${pageContext.request.contextPath }" var="path"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>无线点餐平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${path }/sys/style/js/jquery.js"></script>
<script type="text/javascript" src="${path }/sys/style/js/page_common.js"></script>
<link href="${path }/sys/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${path }/sys/style/css/index_1.css" />
</head>
<body>
	{<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="${path }/sys/style/images/title_arrow.gif" /> 菜系列表
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>
	<!-- 过滤条件 -->
	<div id="QueryArea">
		<form action="${pageContext.request.contextPath }/servlet/type?method=list" method="post">
			<input type="hidden" name="method" value="search">
			<input type="text" name="typeName" title="请输入菜系名称">
			<input type="submit" value="搜索">
		</form>
	</div>

	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>菜系编号</td>
					<td>菜系名称</td>
					<td>操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">
				<c:choose>
		     <c:when test="${not empty requestScope.typeList}">
		         <c:forEach items="${requestScope.typeList}" var="type" varStatus="vs">
		             <tr>
						<td>${vs.count}</td>
						<td>${type.typeName}</td>
						<td>
							<a href="${path }/servlet/type?method=findById&id=${type.id}" class="FunctionButton">更新</a> 
							<a href="${path }/servlet/type?method=delete&id=${type.id}" class="FunctionButton">删除</a>
						</td>
					</tr>
		         </c:forEach>
		     </c:when>
		     <c:otherwise>
		        <tr><td>不好意思，没有餐桌信息，请联系管理员或添加</td></tr>
		     </c:otherwise>
		  </c:choose>	
			</tbody>
		</table>
		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
			<div class="FunctionButton">
				<a href="${path }/sys/type/saveType.jsp">添加</a>
			</div>
		</div>
	</div>
</body>
</html>
