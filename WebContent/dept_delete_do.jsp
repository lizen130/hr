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
</head>
<body>

	<%  String url = basePath + "dept_list.jsp";
	    String deptnos=request.getParameter("ids");
	    String redeptnos[]=deptnos.split("\\|");
		IDeptService ids = ServiceFactory.getInstance(DeptServiceImpl.class);
		Set<Integer> result=new HashSet<Integer>();
	    for(int x=0;x<redeptnos.length;x++){
	    	result.add(Integer.parseInt(redeptnos[x]));
	    }
	    String ret="删除部门数据失败！";
	    if(ids.delete(result)){
	    	ret="删除部门数据成功";
	    }
	%>
<jsp:include page="goTime.jsp">
     <jsp:param value="<%=ret %>" name="ret"/>
     <jsp:param value="<%=url %>" name="url"/>
</jsp:include>
</body>
</html>