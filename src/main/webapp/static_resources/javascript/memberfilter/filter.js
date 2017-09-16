	$(document).on("click",".form_date",function(){
    	$(this).datetimepicker({
    		format: 'yyyy-mm-dd',
    		language:  'zh',
            weekStart: 1,
            todayBtn:  1,
    		autoclose: 1,
    		todayHighlight: 1,
    		startView: 2,
    		minView: 2,
    		forceParse: 0
        });
    });

    $(document).on("click",".form_time",function(){
    	$(this).datetimepicker({
    		language:  'fr',
            weekStart: 1,
            todayBtn:  1,
    		autoclose: 1,
    		todayHighlight: 1,
    		startView: 1,
    		minView: 0,
    		maxView: 1,
    		forceParse: 0
        });
    });
    
    $("#memberHelpModal").on('show.bs.modal', function(e){
    	var button = $(e.relatedTarget);
    	var recipient = button.data('whatever');
    	$(this).find('#memberHelpCon').text(recipient);
    });
    
    $(document).ready(function(){
    	if (conditions != null) {
    		initCondition();
    		submit(1);
    	}
    	
    	document.onchange = function() {
    		showFilterSure();
	    };
	    
	    document.onkeydown = function() {
	    	showFilterSure();
	    };
    });
    
    function showFilterSure() {
    	//将确认筛选替换成保存分组按钮
		$(".tx-filter-sure").show();
		$(".tx-save-group").hide();
		$(".tx-filter-user-count").hide();
    }
    
    //初始化条件
    function initCondition() {
    	for (var i = 0; i < conditions.length; i++) {
    		var condition = conditions[i];
    		var attrId = condition.attr_id;
    		var attrType = condition.attr_type;
    		var attrName = condition.attr_name;
    		var isFuzzysearch = condition.is_fuzzysearch;
    		var searchColumnName = condition.search_column_name;
    		var attrVals = condition.attr_vals;
    		var isSupportFuzzySearch = condition.is_support_fuzzy_search;
    		var action = condition.action;
    		changeFieldValue(attrId, attrType, attrName, condition.input_type, isSupportFuzzySearch, searchColumnName, action, attrVals, isFuzzysearch);
    	}
    }
    
    function changeFieldValue(attrId, attrType, attrName, inputType, isSupportFuzzySearch, searchColumnName, action, attrVals, isFuzzysearch) {
    	showFilterSure();
    	
    	var currentSpanId = "parent_"+attrId;
    	var $currentSpan = $("#"+currentSpanId);
    	var eValue = $currentSpan.attr("value");
    	if (eValue == 'active') {
    		var childId = "child_" + attrId;
    		$("#"+childId).remove();
    		$currentSpan.parent("li").removeClass("active");
    		$currentSpan.attr("value", "");
    		return;
    	}
    	
    	//根据inputType构建元素
    	switch (inputType) {
    	case '1':
    		buildElementStr(attrId, attrType, attrName, isSupportFuzzySearch, searchColumnName, action, attrVals, isFuzzysearch);
    		break;
    	case '2':
    		buildElementByExistHtml(attrId, attrType, action, attrVals);
    		break;
    	case '3':
    		buildElementTime(attrId, attrType, attrName, searchColumnName, action, attrVals);
    		break;
    	case '4':
    		buildElementNumber(attrId, attrType, attrName, searchColumnName, action, attrVals);
    		break;
    	case '6':
    		buildElementByExistHtml(attrId, attrType, action, attrVals);
    		break;
    	case '7':
    		buildElementByExistHtml(attrId, attrType, action, attrVals);
    		break;
    	default:
    		console.log("暂时不支持inputType: " + inputType + " attrId: " + attrId);
    		break;
    	}
    	$currentSpan.parent("li").addClass("active");
    	$currentSpan.attr("value", "active");
    }
    

    /**
     * 构建字符串搜索类型的输入元素
     * @param attrId
     * @param attrName
     * @param isSupportFuzzySearch
     */
    function buildElementStr(attrId, attrType, attrName, isSupportFuzzySearch, searchColumnName, action, attrValues, isFuzzysearch) {
    	var $parentElm = getParentElement(attrType);
		var childId =  "child_" + attrId;
    	var $templateItemBox = $("<div class='template_item_box tx-search-box-str' attrId='" + attrId + "' attrName='" + attrName + "' searchColumnName='" + searchColumnName + "' id='" + childId + "'></div>");
    	var $label =  $("<label class=\"template_title\">" + attrName + "</option>").appendTo($templateItemBox);
    	var $select = $("<select class=\"template_option\"></select>").appendTo($templateItemBox);
    	if (typeof(action) != 'undefined' && action == 'not in') {
	    	var $optionInclude = $("<option value='in'>包含</option>").appendTo($select);
	    	var $optionExclude = $("<option value='not in' selected>排除</option>").appendTo($select);
    	} else {
    		var $optionInclude = $("<option value='in'>包含</option>").appendTo($select);
	    	var $optionExclude = $("<option value='not in'>排除</option>").appendTo($select);
    	}
    	if (typeof(attrValues) != "undefined") {
	    	var $input = $("<input type='text' placeholder='输入" + attrName + "' class='template_input' value='" + attrValues + "'>").appendTo($templateItemBox);
    	} else {
	    	var $input = $("<input type='text' placeholder='输入" + attrName + "' class='template_input'>").appendTo($templateItemBox);
    	}
    	if (isSupportFuzzySearch == 'true') {
	    	var $labelSupportFuzzySearch = $("<label class=\"template_search\">模糊搜索</label>").appendTo($templateItemBox);
	    	if (isFuzzysearch == 'true') {
	    		var $inputSupportFuzzySearch = $("<input type='checkbox' class='tx-fuzzy-box' checked='checked'>").appendTo($labelSupportFuzzySearch);
	    	} else {
	    		var $inputSupportFuzzySearch = $("<input type='checkbox' class='tx-fuzzy-box'>").appendTo($labelSupportFuzzySearch);
	    	}
    	}
    	var $plus = $("<i class=\"plus\">+</i>").appendTo($templateItemBox);
    	var $minus = $("<i class=\"minus\">-</i>").appendTo($templateItemBox);
    	
    	$parentElm.append($templateItemBox);
    }
    
    /**
     * 构建时间的输入元素
     */
    function buildElementTime(attrId, attrType, attrName, searchColumnName, action, attrValues) {
    	var input1 = '';
    	var input2 = '';
    	if (typeof(attrValues) != 'undefined') {
    		input1 = attrValues.split(',')[0].trim();
    		input2 = attrValues.split(',')[1].trim();
    	}
    	
    	var dateFormat = 'yyyy MM dd';
    	var formClass = 'form_date';
    	if (searchColumnName == 'CONVERT(varchar(100), o.pay_time, 108)') {
    		dateFormat = 'hh:ii:ss';
    		formClass = 'form_time';
    	}
    	
    	var $parentElm = getParentElement(attrType);
    	var childId =  "child_" + attrId;
    	var $templateItemBox = $("<div class='template_item_box tx-search-box-time' attrId='" + attrId + "' searchColumnName='" + searchColumnName + "' id='" + childId + "'></div>");
    	var $label =  $("<label class=\"template_title\">" + attrName + "</option>").appendTo($templateItemBox);
    	var $select = $("<select class=\"template_option\"></select>").appendTo($templateItemBox);
    	if (typeof(action) != 'undefined' && action == 'not in') {
	    	var $optionInclude = $("<option value='in'>包含</option>").appendTo($select);
	    	var $optionExclude = $("<option value='not in' selected>排除</option>").appendTo($select);
    	} else {
    		var $optionInclude = $("<option value='in'>包含</option>").appendTo($select);
	    	var $optionExclude = $("<option value='not in'>排除</option>").appendTo($select);
    	}
    	var $startTime = $("<div class='template_date'></div>").appendTo($templateItemBox);
    	var $startTimeDiv = $("<div class='input-group date " + formClass + "' data-date='' data-date-format='" + dateFormat + "' data-link-format='" + dateFormat + "'></div>").appendTo($startTime);
    	if (input1 != '') {
    		console.log("input1: " + input1)
    		var $startTimeDivInput = $("<input class='form-control' size='16' type='text' readonly value='" + input1 + "'>").appendTo($startTimeDiv);
    	} else {
    		var $startTimeDivInput = $("<input class='form-control' size='16' type='text' value='' readonly>").appendTo($startTimeDiv);
    	}
    	var $startTimeDivSpan = $("<span class='input-group-addon'><span class='glyphicon glyphicon-calendar'></span></span>").appendTo($startTimeDiv);
    	
    	var $spanSplit = $("<span>-</span>").appendTo($templateItemBox);
    	
    	var $endTime = $("<div class='template_date'></div>").appendTo($templateItemBox);
    	var $endTimeDiv = $("<div class='input-group date " + formClass + "' data-date='' data-date-format='" + dateFormat + "' data-link-format='" + dateFormat + "'></div>").appendTo($endTime);
    	if (input2 != '') {
	    	var $endTimeDivInput = $("<input class='form-control' size='16' type='text' value='" + input2 + "' readonly>").appendTo($endTimeDiv);
    	} else {
	    	var $endTimeDivInput = $("<input class='form-control' size='16' type='text' value='' readonly>").appendTo($endTimeDiv);
    	}
    	var $endTimeDivSpan = $("<span class='input-group-addon'><span class='glyphicon glyphicon-calendar'></span></span>").appendTo($endTimeDiv);
    	$parentElm.append($templateItemBox);
    }
    
    /**
     * 构建数字的输入元素
     */
    function buildElementNumber(attrId, attrType, attrName, searchColumnName, action, attrValues) {
    	var input1 = '';
    	var input2 = '';
    	if (typeof(attrValues) != 'undefined') {
    		input1 = attrValues.split(',')[0].trim();
    		input2 = attrValues.split(',')[1].trim();
    	}
    	
    	var $parentElm = getParentElement(attrType);
    	
    	var childId =  "child_" + attrId;
    	var $templateItemBox = $("<div class='template_item_box tx-search-box-number' attrId='" + attrId + "' searchColumnName='" + searchColumnName + "' id='" + childId + "'></div>");
    	var $label =  $("<label class=\"template_title\">" + attrName + "</option>").appendTo($templateItemBox);
    	var $select = $("<select class=\"template_option\"></select>").appendTo($templateItemBox);
    	if (typeof(action) != 'undefined' && action == 'not in') {
	    	var $optionInclude = $("<option value='in'>包含</option>").appendTo($select);
	    	var $optionExclude = $("<option value='not in' selected>排除</option>").appendTo($select);
    	} else {
    		var $optionInclude = $("<option value='in'>包含</option>").appendTo($select);
	    	var $optionExclude = $("<option value='not in'>排除</option>").appendTo($select);
    	}
    	
    	if (input1 != '') {
    		var $inputStart = $("<input type='text' placeholder='输入数字' class='template_input' value='"+input1+"'>").appendTo($templateItemBox);
    	} else {
    		var $inputStart = $("<input type='text' placeholder='输入数字' class='template_input'>").appendTo($templateItemBox);
    	}
    	var text = $("<span></span>").text(" -").appendTo($templateItemBox);
    	if (input2 != '') {
    		var $inputEnd = $("<input type='text' placeholder='输入数字' class='template_input' value='"+input2+"'>").appendTo($templateItemBox);
    	} else {
    		var $inputEnd = $("<input type='text' placeholder='输入数字' class='template_input'>").appendTo($templateItemBox);
    	}
    	
    	
    	$parentElm.append($templateItemBox);
	}
    
    /**
     *构建选择的输入元素
     */
    function buildElementByExistHtml(attrId, attrType, action, attrValues) {
    	var $parentElm = getParentElement(attrType);
    	
    	var currentSpanId = "parent_"+attrId;
    	switch (attrType) {
    	case '1':
    		$(".tx-base-attrs").append($("#"+currentSpanId).prev().val());
    		break;
    	case '2':
    		$(".tx-shop-attrs").append($("#"+currentSpanId).prev().val());
    		break;
    	case '3':
    		$(".tx-rfm-attrs").append($("#"+currentSpanId).prev().val());
    		break;
    	case '4':
    		$(".tx-behavior-attrs").append($("#"+currentSpanId).prev().val());
    		break;
    	default:
    		console.log("尚不存在attrid: " + attrId + " 的节点.");
    		break;
    	}
    	
    	//初始化
    	var $currentAddElm = $("#child_"+attrId);
    	if (typeof(action) != 'undefined' && action == 'not in') {
    		var options = $currentAddElm.find('option');
    		if ($(options[1]).val() == action) {
    			$(options[1]).attr('selected', 'selected');
    		}
    	}
    	var inputs = $currentAddElm.find('input');
    	for (var i = 0; i < inputs.length; i++) {
    		var $input = $(inputs[i]);
    		if (typeof(attrValues) != 'undefined' && attrValues.indexOf($input.val()) > -1) {
    			$input.attr("checked", "checked");
    		}
    	}
    	
    	//对于特殊的节点进行特殊处理
    	if (attrId == '21' && typeof(attrValues) != 'undefined') {
    		var vals = attrValues.split(",");
    		var inputs = $currentAddElm.find('input');
    		$(inputs[0]).val(vals[0].trim());
    		$(inputs[1]).val(vals[1].trim());
    		$currentAddElm.find(".remove-selected").attr('barcode', vals[2].trim());
    		$currentAddElm.find(".remove-selected").show();
    	}
    	
    	if ((attrId == '49' || attrId == '54') && typeof(attrValues) != 'undefined') {
    		var vals = attrValues.split(",");
    		var inputs = $currentAddElm.find('input');
    		$(inputs[0]).val(vals[0].trim());
    		$(inputs[1]).val(vals[1].trim());
    		$(inputs[2]).val(vals[2].trim());
    		$(inputs[3]).val(vals[3].trim());
    	}
    }

    function getParentElement(attrType) {
    	var $parentElm = null;
    	switch (attrType) {
    	case '1':
    		$parentElm = $(".tx-base-attrs");
    		break;
    	case '2':
    		$parentElm = $(".tx-shop-attrs");
    		break;
    	case '3':
    		$parentElm = $(".tx-rfm-attrs");
    		break;
    	case '4':
    		$parentElm = $(".tx-behavior-attrs");
    		break;
    	default:
    		console.log("尚不存在attrid: " + attrId + " 的节点.");
    		break;
    	}
    	return $parentElm;
    }
    
    /**
     *执行搜索
     */
    function submit(page) {
    	//清空所有的错误输入提示
    	$(".tx-err-label").remove();
    	
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
    		$('.tx-search-failure').html('请输入正确的查询条件');
			$('.tx-search-failure').fadeIn(1000);
			$('.tx-search-failure').fadeOut(2000);
    		return;
    	}
    	
    	if (params.length == 0) {
    		$('.tx-search-failure').html('请输入查询条件');
			$('.tx-search-failure').fadeIn(1000);
			$('.tx-search-failure').fadeOut(2000);
			return;
    	}
    	
    	jsonBody.params = params;
    	console.log(JSON.stringify(jsonBody));
    	$(".loading").show();
    	$.post(
    		context_path + "/crm/v1/member/search",	
    		{'json_body': JSON.stringify(jsonBody), 'page': page},
    		function(data) {
    			if (data.code == 1) {
    				initAsyncPage(data.msg_data.page);
	    			renderCrmUsers(data.msg_data.users);
	    			$(".loading").hide();
	    			
	    			//将确认筛选替换成保存分组按钮
	    			$(".tx-filter-sure").hide();
	    			$(".tx-save-group").removeClass("hidden");
	    			$(".tx-filter-user-count").removeClass("hidden");
	    			$(".tx-save-group").show();
	    			$(".tx-filter-user-count").show();
	    			
	    			var totalCount = data.msg_data.page.totalCount;
	    			$(".tx-filter-user-count span").html(totalCount);
    			} else {
    				$('.tx-search-failure').html('查找失败，请输入正确的查找条件');
    				$('.tx-search-failure').fadeIn(1000);
    				$('.tx-search-failure').fadeOut(2000);
	    			$(".loading").hide();
    			}
    		},
    		'JSON'
    	);
    }
    
    function renderCrmUsers(users) {
    	$('#userTbody tr').remove();
    	$('#userTemplate').tmpl(users).appendTo('#userTbody');
    }
    
    /**
    *获取字符串查找的参数
    */
    function fillStrQueryParams(params) {
    	var $strSearchBoxs = $(".tx-search-box-str");
    	var strBoxSize = $strSearchBoxs.length;
    	for (var i = 0; i < strBoxSize; i++) {
			var $strSearchBox = $($strSearchBoxs[i]);
    	  	var param = {};
    	  	param.attr_id = $strSearchBox.attr("attrid");
    	  	param.param_name = $strSearchBox.attr('searchcolumnname');
    	  	param.action = $strSearchBox.find("select").val();
    	  
    	  	var values = new Array();
    	  	var searchValue = $($strSearchBox.find("input")[0]).val();
    	  	if (searchValue.trim() == '') {
    	  		var attrName = $($strSearchBoxs.find('label')[0]).html();
    	  		$($strSearchBox.find("input")[0]).after("<label class='tx-err-label' style='color:red'>请输入"+attrName+"</label>")
    	  		return false;
    	  	}
    	  	values.push(searchValue);
    	  	param.param_values = values;
    	  
    	  	param.is_fuzzy_search= $strSearchBox.find(".tx-fuzzy-box").prop('checked') == true?1:0;

    	  	params.push(param);
    	}
    	return true;
    }
    
	function fillNumberQueryParams(params) {
		var $numberSearchBoxs = $(".tx-search-box-number");
		var numberBoxSize = $numberSearchBoxs.length;
		for (var i = 0; i < numberBoxSize; i++) {
			var $numberSearchBox = $($numberSearchBoxs[i]);
			var param = {};
    	  	param.attr_id = $numberSearchBox.attr("attrid");
    	  	param.param_name = $numberSearchBox.attr('searchcolumnname');
    	  	param.action = $numberSearchBox.find("select").val();
    	  	
    	  	var values = new Array();
    	  	var $inputs = $numberSearchBox.find("input");
    	  	var start = $($inputs[0]).val();
    	  	var end = $($inputs[1]).val();
    	  	if (start.trim() == '' || start.trim() == '') {
    	  		var attrName = $($numberSearchBox.find('label')[0]).html();
    	    	$numberSearchBox.append("<label class='tx-err-label' style='color:red'>请输入"+attrName+"</label>");	
    	  		return false;
    	  	}
    	  	if (isNaN(start) || isNaN(end)) {
    	  		var attrName = $($numberSearchBox.find('label')[0]).html();
    	    	$numberSearchBox.append("<label class='tx-err-label' style='color:red'>请输入"+attrName+"</label>");	
    	  		return false;
    	  	}
    	  	values.push(start);
    	  	values.push(end);
    	  	param.param_values = values;

    	  	params.push(param);
		}
		return true;
    }
    
    function fillSelectQueryParams(params) {
    	var $selectSearchBoxs = $(".tx-search-box-select");

    	var selectBoxSize = $selectSearchBoxs.length;
    	for (var i = 0; i < selectBoxSize; i++) {
    		var $selectSearchBox = $($selectSearchBoxs[i]);

    	    var param = {};
   	    	param.attr_id = $selectSearchBox.attr("attrid");
   	    	param.param_name = $selectSearchBox.attr('searchcolumnname');
   	    	param.action = $selectSearchBox.find("select").val();
   	    	  
   	    	var values = new Array();
   	    	var $inputs = $selectSearchBox.find("input");
    	    var inputLen = $inputs.length;
    	    for (var j = 0; j < inputLen; j++) {
    	        $input = $($inputs[j]);
    	        if ($input.prop('checked') == true) {
    	        	values.push($input.val());
				}
			}
    	    if (values.length == 0) {
	    	    var attrName = $($selectSearchBox.find('label')[0]).html();
    	    	$($selectSearchBox.find("ul")[0]).after("<label class='tx-err-label' style='color:red'>请输入"+attrName+"</label>");	
    	    	return false;
    	    }
    	    
    	    param.param_values = values;
    	    
    	    params.push(param);
    	}
    	return true;
    }
    
    function fillTimeQueryParams(params) {
    	var $timeSearchBoxs = $(".tx-search-box-time");
    	var timeSearchBoxSize = $timeSearchBoxs.length;
    	
    	for (var i = 0; i < timeSearchBoxSize; i++) {
    		var $timeSearchBox = $($timeSearchBoxs[i]);
    		
    		var param = {};
   	    	param.attr_id = $timeSearchBox.attr("attrid");
   	    	param.param_name = $timeSearchBox.attr('searchcolumnname');
   	    	param.action = $timeSearchBox.find("select").val();
   	    	var $inputs = $timeSearchBox.find("input");
   	    	var values = new Array();
   	    	var start = $($inputs[0]).val();
   	    	var end = $($inputs[1]).val();
   	    	if (start == '' || end == '') {
   	    		var attrName = $($timeSearchBox.find('label')[0]).html();
   	    		$timeSearchBox.append("<label class='tx-err-label' style='color:red'>请输入"+attrName+"</label>");	
   	    		return false;
   	    	}
   	    	values.push(start);
   	    	values.push(end);
   	    	
   	     	param.param_values = values;
 	    	params.push(param);
    	}
    	return true;
    }
    
    function fillComplexTimeGoodsQueryParams(params) {
    	var $txBox = $(".tx-search-box-complex-time-goods");
    	if ($txBox.attr("attrid") == undefined) {
    		return true;
    	}
    	
    	var param = {};
    	param.attr_id = $txBox.attr("attrid");
	    param.param_name = $txBox.attr('searchcolumnname');
	    param.action = $txBox.find("select").val();
    	
	    var $inputs = $txBox.find("input");
    	var values = new Array();
    	param.param_values = values;
    	var start = $($inputs[0]).val();
    	var end = $($inputs[1]).val();
    	
    	var selectedBarcode = $(".tx-search-box-complex-time-goods .remove-selected").attr("barcode");
    	if (start == '' || end == '' || selectedBarcode == '') {
    		var attrName = $($txBox.find('label')[0]).html();
	    	$txBox.append("<label class='tx-err-label' style='color:red'>请输入"+attrName+"</label>");	
    		return false;
    	}
		
    	values.push(start);
    	values.push(end);
    	values.push(selectedBarcode);
    	
    	params.push(param);
    	return true;
    }
    
    function fillComplexTimePayTimesQueryParams(params) {
    	var $txBoxs = $(".tx-search-inputtype-7");
    	var txBoxLen = $txBoxs.length; 
    	for (var i = 0; i < txBoxLen; i++){
    		var $txBox = $($txBoxs[i]);
    		
	    	var param = {};
	    	param.attr_id = $txBox.attr("attrid");
		    param.param_name = $txBox.attr('searchcolumnname');
		    param.action = $txBox.find("select").val();
		    
		    var $inputs = $txBox.find("input");
	    	var values = new Array();
	    	param.param_values = values;
	    	var startTime = $($inputs[0]).val();
	    	var endTime = $($inputs[1]).val();
	    	var startNum = $($inputs[2]).val();
	    	var endNum = $($inputs[3]).val();
	    	
	    	if (startTime == '' || endTime == '' || startNum == '' || endNum == '') {
	    		var attrName = $($txBox.find('label')[0]).html();
		    	$txBox.append("<label class='tx-err-label' style='color:red'>请输入"+attrName+"</label>");	
	    		return false;
	    	}
	    	
	    	values.push(startTime);
	    	values.push(endTime);
	    	values.push(startNum);
	    	values.push(endNum);
	    	
	    	params.push(param);
    	}
    	return true;
    }
    
    /**
    * 重置条件
    */
    function resetConditions() {
    	$(".tx-base-attrs").children().remove();
    	$(".tx-shop-attrs").children().remove();
    	$(".tx-rfm-attrs").children().remove();
    	$(".tx-behavior-attrs").children().remove();
    	
    	$(".active").removeClass("active");
    	$("span").attr("value", "");
    }