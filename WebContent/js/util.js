function deleteHandle(ele,url){
	var idInfo="";
	var obj=document.all(ele);
	if(obj.length==undefined){
		if(obj.checked){
			idInfo += obj.value+"|";
		}
	}else{
		for(var x=0;x<obj.length;x++){
			if(obj[x].checked){
				idInfo += obj[x].value+"|";
			}
		}
	}
	if(idInfo==""){
		alert("您还没有选择任何要删除的数据")
	}else{
		if(window.confirm("你确定要删除这些数据么")){
			window.location=url+"?ids="+idInfo;
		}
	}

}
function selectAll(ele,all){
	var obj=document.all(ele);
	if(obj.length==undefined){
		obj.checked=document.getElementById(all).checked;
	}else{
		for(var x=0;x<obj.length;x++){
			obj[x].checked=document.getElementById(all).checked;
		}
	}
}
function validateEmpty(ele){
	var obj=document.getElementById(ele);
	if(obj.value==""){
		obj.className="wrong";
		return false;
	}else{
		obj.className="right"
	   return true;
	}
}
function validateRegex(ele,regex){
	var obj=document.getElementById(ele);
	if(obj.value==""){
		obj.className="wrong";
		return false;
	}else{
		if(regex.test(obj.value)){
			obj.className="right"
				   return true;
		}else{
			obj.className="wrong";
			return false;
		}
	}
}
function goTime(){
	var gt=parseInt(document.getElementById("mytime").innerHTML);
	gt--;
	if(gt==0){
		window.location=goUrl;
	}else{
		document.getElementById("mytime").innerHTML=gt;
		setTimeout(goTime,1000);
	}
}