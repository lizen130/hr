<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="cn.mldn.vo.*"%>
<%@ page import="cn.mldn.util.factory.*"%>
<%@ page import="cn.mldn.service.*"%>
<%@ page import="cn.mldn.service.impl.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<base href="<%=basePath%>">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/util.js"></script>
<script type="text/javascript" src="js/dept_add.js"></script>
</head>
<body>
	<form action="<%=basePath%>dept_add_do.jsp" method="post" id="add_form">
	     <table>
			<tr>
				<td colspan="3" class="title">增加部门信息</td>
			</tr>
			<tr>
				<td>部门编号：</td>
				<td><input type="text" id="deptno" name="deptno" class="normal"></td>
				<td>请输入部门编号</td>
			</tr>
			<tr>
				<td>部门名称：</td>
				<td><input type="text" id="dname" name="dname" class="normal"></td>
				<td>请输入部门名称</td>
			</tr>
			<tr>
				<td>部门地址：</td>
				<td><input type="text" id="loc" name="loc" class="normal"></td>
				<td>请输入部门地址</td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="提交" id="submit"> <input
					type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>