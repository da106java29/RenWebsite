window.onresize = function(){
	changeFrameHeight();
}

window.onload = function(){
}

function doExportExcel(){
		
	let url = "WebController";
	let async = false;
	let filename;
	let src = "dataUrl=" + document.getElementById("iframepage").src;
	let params;
	
	if(document.getElementById("filename").value != ""){
		filename = document.getElementById("filename").value;
	}else{
		filename = "ExportExcel_ByJava";
	}
	
	params = "dataUrl=" + document.getElementById("iframepage").src + "&filename=" + filename;
	
	let xhr = new XMLHttpRequest();
	
	xhr.addEventListener("load", function(){
		let status = xhr.status;
		
		if(status == "200"){
			alert("Export Is OK!! back-end return : " + status);
		}else{
			alert("SomeThing Error!!")
		}
		
	}, false);
	
	xhr.open("POST", url, async);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
//	xhr.setRequestHeader("Content-type", "application/application/json;charset=utf-8");
	
	xhr.send(params);
}

function changeFrameHeight(){
    var ifm = document.getElementById("iframepage");
    
    ifm.height = document.documentElement.clientHeight;
    ifm.width = document.documentElement.clientWidth;
}

