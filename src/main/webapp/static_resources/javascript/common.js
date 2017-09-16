$(function(){
	//回车输入
	var item = "#project_check_form .item,#project_settlement_form .item";
	var itemLength = $(item).length;
	$(item).keydown(function(e){
		if(e.keyCode==13){
			$(this).next(".item").find("input,select").focus();
		}
	});
});