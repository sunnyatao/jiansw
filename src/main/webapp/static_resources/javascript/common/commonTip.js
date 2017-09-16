//回调函数 的调用方法  invokeFunc("funcName"[, arg1, arg2]) 或   invokeFunc(func[, arg1, arg2])
function invokeFunc(func){
	var argsArr = []
	for(var i in arguments){
		if(i > 0){
			argsArr.push(arguments[i])
		}
	}
	switch(typeof func){
		case "function" : 
			func.apply(window, argsArr);
			break;
		case "string"	:
			window[func].apply(window, argsArr);
			break;
	}
}

function commonAlert(tip, callback){
	var tipCon = '<div class="com-error-tip" style="display:block;">';
	tipCon += '<div style="width:100%;height:100%;position:fixed;left:0;top:0;background:rgba(255,255,255,0.6);z-index:1001;"></div>';
	tipCon += '<p style="width:300px;position:fixed;left:50%;top:50px;margin-left:-158px;text-align:center;color:#fff;border-radius:3px;background:#ff6c00;font-size:13PX;line-height:22px;padding:8px 16px;z-index:1002;">'+ tip +'</p>';
	tipCon += '</div>';
	if($(".com-error-tip").length == 0){
		$("body").append(tipCon);
	}
	setTimeout(function(){
		$(".com-error-tip").remove();
		invokeFunc(callback)
	},5000);
}