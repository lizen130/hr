window.onload=function(){
	document.getElementById("selall").addEventListener("click", function(e) {
		selectAll("deptno","selall");
	}, false);
	document.getElementById("deletebut").addEventListener("click",function(e){
		deleteHandle("deptno","dept_delete_do.jsp");
	},false)
}