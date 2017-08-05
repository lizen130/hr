<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <div>
     <div><%=request.getParameter("ret") %></div>
     <div><span id="mytime">5</span>秒后跳转页面</div>
 </div>
 <script type="text/javascript">
     var goUrl="<%=request.getParameter("url") %>"
     goTime();
</script>