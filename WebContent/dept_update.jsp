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
<link rel="stylesheet" type="text/css" herf="css/style.css">
<script type="text/javascript" src="js/util.js"></script>
</head>
<body>
<%
   Integer id=Integer.parseInt(request.getParameter("deptno"));
   IDeptService ids = ServiceFactory.getInstance(DeptServiceImpl.class);
   Dept vo=ids.find(id);
   
%>
	<form id="update_form" method="post" action="<%=basePath%>dept_update_do.jsp">
		<table>
			<tr>
				<td colspan="3" class="title">修改部门信息</td>
			</tr>
			<tr>
				<td>部门编号：</td>
				<td><input type="text" class="normal" value="<%=vo.getDeptno() %>" readonly></td>
				<td></td>
			</tr>
			<tr>
				<td>部门名称：</td>
				<td><input type="text" id="dname" name="dname" class="normal" value="<%=vo.getDname() %>"></td>
				<td>请输入部门名称</td>
			</tr>
			<tr>
				<td>部门地址：</td>
				<td><input type="text" id="loc" name="loc" class="normal" value="<%=vo.getLoc() %>"></td>
				<td>请输入部门地址</td>
			</tr>
			<tr>
			    <td><input type="submit" value="提交"></td> 
                <td><input type="hidden" id="deptno" name="deptno" value="<%=vo.getDeptno() %>"></td>
			</tr>
		</table>
	</form>
</body>
</html>