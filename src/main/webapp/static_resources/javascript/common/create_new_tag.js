function init(tagId) {
	$("#tagOptionId").children().remove();
	if (tagId == -1) {
		console.log('create input');
		for (var i = 0; i < 2; i++) {
			var add='<div class="grid_item" id='+i+'d  data-class="tagSelect">'
				+'<label  class="label-title">标签选项'+i+'：</label>'
				+'<div>'
				+'<span>'
				+'<input type="text" id=item'+i+' value="" maxlength="32">'
				+'</span>&nbsp;'
				+'<i class="ico-add" onclick="addText()">+</i>';
			 if (i > 0) {  
				add += '<i class="ico-delete" onclick="delText()">-</i>'
			 } 
			add+='<span class="msg msg-error" style="display:none" id="itemError'+i+'">';
			add+='<span >请输入标签选项</span></span></div></div>';

			$("#tagOptionId").append(add);
		}
	}
}

function addTag(e, title, tagId) {
	init(tagId);
	$("#tagOptionId").show();
	//title 用来区分insert和update的。
	$("#myModalLabel").html(title);
	
	if (tagId != -1) {
		var tds = $(e).parent().parent().children();
		var tagName = $(tds[1]).html();
		var tagType = $(tds[3]).attr('tagType');
		var tagValues = $(tds[2]).html();
		
		$("#tagName").val(tagName);
		$("input[name='checkType']").each(function(){
			if ($(this).val() == tagType) {
				console.log("当前类型值: " + $(this).val());
				$(this).prop('checked', true);
			}
		});
		
		if (tagValues != '') {
			var values = tagValues.split('、')
			for (var i=0; i < values.length; i++) {
				var add='<div class="grid_item" id='+i+'d  data-class="tagSelect">'
					+'<label  class="label-title">标签选项'+i+'：</label>'
					+'<div>'
					+'<span>'
					+'<input type="text" id=item'+i+' value="' + values[i] + '" maxlength="32">'
					+'</span>&nbsp;'
					+'<i  class="ico-add" onclick="addText()">+</i>';
				if (i > 0) { 
					add += '<i class="ico-delete" onclick="delText()">-</i>'
				}
				add+='<span class="msg msg-error" style="display:none" id="itemError'+i+'">';
				add+='<span >请输入标签选项</span></span></div></div>';

				$("#tagOptionId").append(add);
			}
		}
	}
	$("#submitTagId").attr("onclick", "doInsert(" + tagId + ")");
}


function doShowMenu(e){
	var value=$(e).attr("value");
	if(value=="1" || value=="2"){
		$("#textDescription").hide();
		$("#timeDescription").hide();	
		$("#tagOptionId").show();
	}else if(value=="3"){
		$("#timeDescription").hide();
		$("#textDescription").show();
		$("#tagOptionId").hide();
	}else if(value=="4"){
		$("#textDescription").hide();
		$("#timeDescription").show();
		$("#tagOptionId").hide();
	}
}

function addText(){
	var i = $("[data-class=tagSelect]").length;
	var add='<div class="grid_item" id='+i+'d  data-class="tagSelect">'
		+'<label  class="label-title">标签选项'+i+'：</label>'
		+'<div>'
		+'<span>'
		+'<input type="text" id=item'+i+' value="" maxlength="32">'
		+'</span>&nbsp;'
		+'<i  class="ico-add" onclick="addText()">+</i>'
		+'<i class="ico-delete" onclick="delText()">-</i>'
		+'<span class="msg msg-error" style="display:none" id="itemError'+i+'">'
		+'<span >请输入标签选项</span></span></div></div>';

	$("#tagOptionId").append(add);
}

function delText(){
	var i = $("[data-class=tagSelect]").length-1;
	$("#"+i+"d").remove();
}

function doInsert(tagId) {   
	$(".msg-error").hide();
	var check = $("input[name='checkType']:checked");
	var tagSize = $("[data-class=tagSelect]").length;
	if($.trim($("#tagName").val())!=""){
		var tagName = $("#tagName").val();
		tagName = tagName.replace("'","‘");
		$("#tagNameError").hide();
	}else{
		$("#tagNameError").show();
		return ;
	}
	var tagType = check.val();
	var tags = new Array();
	if (tagType == "1" || tagType == "2") {
		for(var i=0;i<tagSize;i++){
			var tagValue = $.trim($("#item"+i).val());
	        if(tagValue==""){
	            $("#itemError"+i).show();
			   return ;
	        } else {
	        	tags.push(tagValue);
	        }
	    }
	}
	/*将数组形成json形式,传到后台  */
	var tagValues = JSON.stringify(tags); 
	console.log(tagValues);
	$.ajax({
		type:"POST",
		url: contextPath+"/crm/v1/tag/ajax/insert",   
		data: {"tagName":tagName,"type": tagType,"tagValues": tagValues, "tagId": tagId},
		dataType: 'json',
		success:function(data){
			if(data.reason=="Success"){
				window.location.href= targetUrl;       //contextPath+"crm/v1/tag/list"
			}else {
				$("#tagNameHas").show();
				return ;
			}
		}
		
	});	
}