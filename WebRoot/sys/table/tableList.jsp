<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- 声明动态获取项目路径 --%>
<c:set value="${pageContext.request.contextPath }" var="path"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
<!-- 包含公共的JSP代码片段 -->

<title>无线点餐平台</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${path }/sys/style/js/jquery.js"></script>
<script type="text/javascript"
	src="${path }/sys/style/js/page_common.js"></script>
<link href="${path }/sys/style/css/common_style_blue.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="${path }/sys/style/css/index_1.css" />
</head>
<body>
	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="${path }/sys/style/images/title_arrow.gif" /> 餐桌列表
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>


	<!-- 过滤条件 -->
	<div id="QueryArea">
		<form action="${path }/servlet/table?method=list" method="post">
			<input type="hidden" name="method" value="search"> <input
				type="text" name="tableName" title="请输入餐桌名称"> <input
				type="submit" value="搜索">
		</form>
	</div>
	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" cellspacing="0" cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>编号</td>
					<td>桌名</td>
					<td>状态</td>
					<td>预定时间</td>
					<td>操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">

				<c:choose>
					<c:when test="${not empty requestScope.tableList}">
						<c:forEach items="${requestScope.tableList}" var="table"
							varStatus="vs">
							<tr class="TableDetail1">
								<td align="center">${vs.count }&nbsp;</td>
								<td align="center">${table.tableName }&nbsp;</td>
								<td align="center">${table.tableStatue==0?'未预定':'已预订' }</td>
								<td align="center">${table.orderDate }</td>
								<td><a
									href="${path }/servlet/table?method=update&id=${table.id}&tableStatue=${table.tableStatue}"
									class="FunctionButton">${table.tableStatue==0?'预定':'退桌' }</a> <a
									href="${path }/servlet/table?method=delete&id=${table.id}"
									onClick="return delConfirm(${table.tableStatue});" class="FunctionButton">删除</a></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td>不好意思，没有餐桌信息，请联系管理员或添加</td>
						</tr>
					</c:otherwise>
				</c:choose>




			</tbody>
		</table>

		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
			<div class="FunctionButton">
				<a href="${path }/sys/table/saveTable.jsp">添加</a>
			</div>
		</div>
	</div>
</body>
</html>
