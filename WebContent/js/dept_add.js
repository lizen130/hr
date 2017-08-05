window.onload=function(){
    document.getElementById("deptno").addEventListener("blur",validateDeptno,false);	
    document.getElementById("dname").addEventListener("blur",validateDname,false);	
    document.getElementById("loc").addEventListener("blur",validateLoc,false);	
    document.getElementById("add_form").addEventListener("submit",function(e){
    	if(validate()==false){
    		e.preventDefault();
    	}
    },false);	
}
function validateDeptno(){
	return validateRegex("deptno",/^\d{1,4}$/);
}
function validateDname(){
	return validateEmpty("dname");
}
function validateLoc(){
	return validateEmpty("loc");
}
function validate(){
	return validateDeptno()&&
	       validateDname()&&
	       validateLoc();
}