window.onresize = function(){
	changeFrameHeight();
}

window.onload = function(){
}

function doExportExcel(){
		
	let url = "WebController";
	let async = false;
	let params = "dataUrl=" + document.getElementById("iframepage").src;
	
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

