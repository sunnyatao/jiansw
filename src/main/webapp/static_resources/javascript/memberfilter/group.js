function openSaveModel() {
	if (originalGroupName != '' && originalGroupName != 'null') {
		$("#groupName").val(originalGroupName);
	}
	
	$.get(
    		context_path + "/crm/v1/group/ajax/category/list",
    		{},
    		function(data) {
    			if (data.code == 1) {
    				$('#categorySelect').find('option').remove();
    				$('#categorySelect').append("<option value='-1'>请选择</option>");
    				
    				var categories = data.msg_data.categories;
    				for (var i = 0; i < categories.length; i++) {
    					var category = categories[i];
    					if (category.categoryId == originalCategoryId) {
    						$('#categorySelect').append("<option value='"+ category.categoryId +"' selected>" + category.categoryName + "</option>");
    					} else {
    						$('#categorySelect').append("<option value='"+ category.categoryId +"'>" + category.categoryName + "</option>");
    					}
    				}
    			} else {
    				alert("获取分类失败");
    			}
    		},
    		'JSON'
    	);
}

function saveGroup() {
	$(".tx-error-select-category").hide();
	$(".tx-error-group-name").hide();
	$(".tx-error-search-condition").hide();
	
	//获取categoryId
	var categoryId = $('#categorySelect').val();
	var groupName = $('#groupName').val();
	var userCount = $(".tx-filter-user-count span").html();
	
	if (categoryId == '-1') {
		$(".tx-error-select-category").removeClass("hidden").show();
		return;
	}

	if (groupName.trim() == '') {
		$(".tx-error-group-name").removeClass("hidden").show();
		return;
	}
	
	//获取搜索条件
	var jsonBody = {};
	var params = new Array();
	var fillResult = true;
	if (!fillStrQueryParams(params)) {
		fillResult = false;
	}
	if (!fillSelectQueryParams(params)) {
		fillResult = false;
	}
	if (!fillTimeQueryParams(params)) {
		fillResult = false;
	}
	if (!fillNumberQueryParams(params)) {
		fillResult = false;
	}
	if (!fillComplexTimeGoodsQueryParams(params)) {
		fillResult = false;
	}
	if (!fillComplexTimePayTimesQueryParams(params)) {
		fillResult = false;
	}
	
	if (fillResult == false) {
		$('.tx-error-search-condition').removeClass("hidden").show();
		return;
	}
	
	if (params.length == 0) {
		$('.tx-error-search-condition').removeClass("hidden").show();
		return;
	}
	jsonBody.params = params;
	
	$.get(
    		context_path + "/crm/v1/group/ajax/group/save",
    		{'json_body': JSON.stringify(jsonBody), 'category_id': categoryId, 'group_name': groupName, 'user_count': userCount, 'user_group_id': originalUserGroupId},
    		function(data) {
    			if (data.code == 1) {
    				window.location.href = context_path+"/crm/v1/group/category/list";
    			} else {
    				alert("保存分组失败");
    			}
    		},
    		'JSON'
    	);
}