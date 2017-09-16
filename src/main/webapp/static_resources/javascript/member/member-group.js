$(document).ready(function(){
	$(".tx-member-mast-title").bind('click', collapseCategory);
});

var collapseCategory = function(event) {
	$currentTarget = $(event.currentTarget);
	var catId = $currentTarget.attr("categoryId");
	$("#memberGroup"+catId).toggle();
	
	if($currentTarget.find("i").hasClass("glyphicon-plus")){
		$currentTarget.find("i").removeClass("glyphicon-plus").addClass("glyphicon-minus");
	}else{
		$currentTarget.find("i").removeClass("glyphicon-minus").addClass("glyphicon-plus");
	}
};

function saveCategory(categoryId) {
	$(".tx-error-category-name").hide();
	
	var categoryName = $("#newCategoryInput").val();
	if (categoryName.trim() == '') {
		$(".tx-error-category-name").removeClass("hidden");
		$(".tx-error-category-name").show();
		return;
	}
	$.get(
    		context_path + "/crm/v1/group/ajax/categoryGroup/save",
    		{'category_id': categoryId, category_name: categoryName},
    		function(data) {
    			if (data.code == 1) {
    				window.location.href = context_path+"/crm/v1/group/category/list";
    			} else {
    				alert("创建分类失败.");
    			}
    		},
    		'JSON'
    	);
}

function updateCategory(categoryId) {
	var categoryName = $("#updateCategoryInput_"+categoryId).val();
	if (categoryName.trim() == '') {
		alert("请输入分类名称!");
		return;
	}
	$.get(
    		context_path + "/crm/v1/group/ajax/categoryGroup/save",
    		{'category_id': categoryId, category_name: categoryName},
    		function(data) {
    			if (data.code == 1) {
    				window.location.href = context_path+"/crm/v1/group/category/list";
    			} else {
    				alert("创建分类失败.");
    			}
    		},
    		'JSON'
    	);
}

function deleteCategory(categoryId) {
	var deleteMast = confirm("确定删除该分类？");
	if(deleteMast == false){
		return;
	}
	$.get(
    		context_path + "/crm/v1/group/ajax/categoryGroup/delete",
    		{'category_id': categoryId},
    		function(data) {
    			if (data.code == 1) {
    				window.location.href = context_path+"/crm/v1/group/category/list";
    			} else {
    				alert("删除分类失败.");
    			}
    		},
    		'JSON'
    	);
}

//编辑title
$(document).on("click",".member-mast-edit",function(){
	var categoryId = $(this).attr("categoryId");
	$("#updateCategoryInput_"+categoryId).val($("#category_name_"+categoryId).html());
	$(this).parent().siblings(".member-mast-chage").show();
});


//保存title
/*$(document).on("click",".tx-save-mast",function(){
	var mastVal = $(this).siblings("input").val();
	console.log(mastVal,$(this).parent().siblings(".member-mast-title span").text());
	$(this).parent().siblings(".member-mast-title").children("span").text(mastVal);
	$(this).parent().hide();
});*/

//取消保存title
$(document).on("click",".tx-save-cancle",function(){
	$(this).parent().hide();
});
