function changeFieldValue(attrId, attrType, attrName, inputType, isSupportFuzzySearch) {
	//根据inputType构建元素
	console.log(attrId);
	switch (inputType) {
	case 1:
		buildElementStr(attrId, attrType, attrName, inputType, isSupportFuzzySearch);
		break;
	case 2:
	
		break;
	case 3:
	
		break;
	case 4:
		
		break;

	default:
		break;
	}
}

/**
 * 构建字符串搜索类型的输入元素
 * @param attrId
 * @param attrName
 * @param isSupportFuzzySearch
 */
/*function buildElementStr(attrId, attrType, attrName, isSupportFuzzySearch) {
	 <div class='template_item_box'>
	<label class='template_title'>姓名</label>
	<select class='template_option'>
		<option>排除</option>
		<option>包含</option>
	</select>
	<input type='text' placeholder='输入姓名' class='template_input'>
	<label class='template_search'><input type='checkbox'>模糊搜索</label>
	<i class='plus'>+</i>
	<i class='minus'>-</i>
	</div> 
	var $parentElm = null;
	switch (attrType) {
	case 1:
		$parentElm = $("#tx-base-attrs");
		break;
	case 2:
		$parentElm = $("#tx-shop-attrs");
		break;
	case 3:
		$parentElm = $("#tx-rfm-attrs");
		break;
	case 4:
		$parentElm = $("#tx-behavior-attrs");
		break;
	default:
		console.log("尚不存在attrid: " + attrId + " 的节点.");
		break;
	}
	
	var $label =  $("<label class=\"template_title\">" + attrName + "</option>").appendTo($parentElm);
	var $select = $("<select class=\"template_option\"></select>").appendTo($parentElm);
	var $optionExclude = $("<option>排除</option>").appendTo($select);
	var $optionInclude = $("<option>包含</option>").appendTo($select);
	var $input = $("<input type='text' placeholder='输入" + attrName + "' class='template_input'>").appendTo($parentElm);
	var $labelSupportFuzzySearch = $("<label class=\"template_search\">" + attrName + "</option>").appendTo($parentElm);
	var $inputSupportFuzzySearch = $("<input type='checkbox'>").appendTo($labelSupportFuzzySearch);
	var $plus = $("<i class=\"plus\">" + attrName + "</i>").appendTo($parentElm);
	var $plus = $("<i class=\"minus\">" + attrName + "</i>").appendTo($parentElm);
}*/