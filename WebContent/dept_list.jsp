<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="cn.mldn.vo.*" %>
<%@ page import="cn.mldn.util.factory.*" %>
<%@ page import="cn.mldn.service.*" %>
<%@ page import="cn.mldn.service.impl.*" %>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.
getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("UTF-8");
String updateUrl=basePath+"dept_update.jsp";
%>
<html>
<head>
<base href="<%=basePath%>">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" herf="css/style.css">
<script type="text/javascript" src="js/util.js"></script>
<script type="text/javascript" src="js/dept_list.js"></script>
</head>
<body>
<table border="1">
    <tr><td colspan="10">所有部门信息</td>
    </tr>
    <tr>
    <td><input type="checkbox" id="selall" name="selall"></td>
    <td>部门编号</td>
    <td>部门名称</td>
    <td>部门地址</td>
    <td>部门人数</td>
    <td>平均工资</td>
    <td>平均工龄</td>
    <td>最高工资</td>
    <td>最低工资</td>
    <td>操作</td>
    </tr>
<%    IDeptService ids=ServiceFactory.getInstance(DeptServiceImpl.class);
      List<Dept> result=ids.list();
      Iterator<Dept> iter=result.iterator();  
       while(iter.hasNext()){
    	   Dept vo=iter.next();
%>
     <tr>
    <td><input type="checkbox" id="deptno" value="<%=vo.getDeptno() %>"></td>
    <td><%=vo.getDeptno() %></td>
    <td><%=vo.getDname() %></td>
    <td><%=vo.getLoc() %></td>
    <td><%=vo.getMso().get("count") %></td>
    <td><%=vo.getMso().get("avg") %></td>
    <td><%=vo.getMso().get("avgyear") %></td>
    <td><%=vo.getMso().get("max") %></td>
    <td><%=vo.getMso().get("min") %></td>
    <td><a href="<%=updateUrl%>?deptno=<%=vo.getDeptno()%>">编辑</a></td>
    </tr>
    <%
    }
    %>
</table>
 <input type="submit" value="删除所有选中的信息" id="deletebut" name="deletebut">
</body>
</html>