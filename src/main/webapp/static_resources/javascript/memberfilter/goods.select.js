$(document).ready(function(){
	$(".tx-goods-select-value").bind('keydown', enterSelectGoods);
});

function enterSelectGoods(e) {
	if (e.keyCode == 13) {
		selectGoods(1);
	}
}

function selectGoods(page) {
	console.log(page);
	var searchType = $(".tx-select-goods-condition").val();
	var queryValue = $(".tx-goods-select-value").val();
	$.post(
    		context_path + "/crm/v1/goods/search",	
    		{'search_type': searchType, 'query_value': queryValue, 'page': page},
    		function(data) {
    			if (data.code == 1) {
    				$('.tx-search-goods div').remove();
    		    	$('#goodsTemplate').tmpl(data.msg_data.goods).appendTo('.tx-search-goods');

    		    	initCurrentPage(data.msg_data.page);
    			} else {
					$('.tx-search-failure').fadeIn(3000);
					$('.tx-search-failure').fadeOut(2000);
    			}
    		},
    		'JSON'
    	);
}

function initCurrentPage(page) {
	//移除所有的li
	$('.tx-select-goods-ul li').remove();
	
	var totalPage = page.totalPage;
	var totalCount = page.totalCount;
	var currentPage = page.currentPage;
	var next = page.next;
	var pre = page.pre;
	
	$('.tx-select-goods-ul').append("<li class='tx-select-goods-pre-page'><a href='javascript:void(0);' aria-label='Previous' class='tx-pre-click-event'><span aria-hidden='true'>上一页</span></a></li>");
	$('.tx-select-goods-ul').append("<li class='tx-select-goods-next-page'><a href='javascript:void(0);' aria-label='Next' class='tx-next-click-event'><span aria-hidden='true'>下一页</span></a></li>");
	$('.tx-select-goods-ul').append("<li class='info'><span>共" + totalPage + "页, " + totalCount + "条记录</span></li>");
	$('.tx-select-goods-ul').append("<li class='info'><span>去第<input type='text' style='width:50px; height: 20px' value='' class='page-num tx-page-onkeydown'>页</span></li>");
	$('.tx-page-select-goods-nav').removeClass('hidden');
	$('.tx-page-select-goods-nav').addClass('show');
	
	if (pre == false) {
		$(".tx-select-goods-pre-page").addClass("disabled");
	}
	if (next == false) {
		$(".tx-select-goods-next-page").addClass("disabled");
	}
	var point = 0;
	var startPoint = currentPage - 3 < 1?1:currentPage - 3;
	for (var i = startPoint; i <= totalPage; i++) {
		point++;
		if (point == 10) {
			break;
		}
		if (i == currentPage) {
			$(".tx-select-goods-next-page").before("<li class='active tx-select-goods-active-page'><a href='javascript:void(0);' class='tx-current-click-event' currentPage='"+ i +"'>" + i + "<span class='sr-only'>(current)</span></a></li>");	
		} else {
			$(".tx-select-goods-next-page").before("<li><a href='javascript:void(0);' class='tx-current-click-event' currentPage='"+ i +"'>" + i + "</a></li>");
		}
	}
	
	$('.tx-pre-click-event').bind('click', preCurrentList);
	$('.tx-next-click-event').bind('click', nextCurrentList);
	$('.tx-current-click-event').bind('click', currentCurrentList);
	$('.tx-page-onkeydown').bind('keydown', gotoCurrentPage);
	$('.goods-filter-list button').bind('click', checkGoods);
}

var preCurrentList = function(e) {
	var currentPage = parseInt($($('.tx-select-goods-active-page').find('a')[0]).attr('currentPage'));
	$currentTarget = $(e.currentTarget);
	if ($currentTarget.parent().hasClass('disabled')) {
		return;
	}
	selectGoods(currentPage - 1);
};

var nextCurrentList = function(e) {
	var currentPage = parseInt($($('.tx-select-goods-active-page').find('a')[0]).attr('currentPage'));
	$currentTarget = $(e.currentTarget);
	if ($currentTarget.parent().hasClass('disabled')) {
		return;
	}
	selectGoods(currentPage + 1);
};

var currentCurrentList = function(e) {
	$currentTarget = $(e.currentTarget);
	selectGoods($currentTarget.attr('currentPage'));
};

var gotoCurrentPage = function(e) {
	if (e.keyCode == 13) {
		$currentTarget = $(e.currentTarget);
		var pagNum = $currentTarget.val();
		selectGoods(pagNum);
	}
};

var checkGoods = function(e){
	$(".goods-selected").hide();
	$(".goods-selected").attr("isSelected", "0");
	$(e.currentTarget).siblings(".goods-selected").show();
	$(e.currentTarget).siblings(".goods-selected").attr("isSelected", "1");
};

function selectedGoods() {
	var selectedBarcode = "";
	var $goodsSelecteds = $(".goods-selected");
	$.each($goodsSelecteds, function(){
		if ($(this).attr("isSelected") == "1") {
			selectedBarcode = $(this).attr("goodsBarcode");
		}
	});
	
	console.log("selectedBarcode: " + selectedBarcode);
	
	if (selectedBarcode != "") {
		$(".remove-selected").attr("barcode", selectedBarcode);
		$(".remove-selected").show();
	} else {
		$(".remove-selected").hide();
		$(".remove-selected").attr("barcode", "");
	}
}