function initAsyncPage(page) {
	//移除所有的li
	$('.tx-ul li').remove();
	
	var totalPage = page.totalPage;
	var totalCount = page.totalCount;
	var currentPage = page.currentPage;
	var next = page.next;
	var pre = page.pre;
	
	$('.tx-ul').append("<li class='tx-pre-page'><a href='javascript:void(0);' aria-label='Previous' class='tx-pre-click-event'><span aria-hidden='true'>上一页</span></a></li>");
	$('.tx-ul').append("<li class='tx-next-page'><a href='javascript:void(0);' aria-label='Next' class='tx-next-click-event'><span aria-hidden='true'>下一页</span></a></li>");
	$('.tx-ul').append("<li class='info'><span>共" + totalPage + "页, " + totalCount + "条记录</span></li>");
	$('.tx-ul').append("<li class='info'><span>去第<input type='text' style='width:50px; height: 20px' value='' class='page-num tx-page-onkeydown'>页</span></li>");
	$('.tx-page-nav').removeClass('hidden');
	$('.tx-page-nav').addClass('show');
	
	if (pre == false) {
		$(".tx-pre-page").addClass("disabled");
	}
	if (next == false) {
		$(".tx-next-page").addClass("disabled");
	}
	var point = 0;
	var startPoint = currentPage - 3 < 1?1:currentPage - 3;
	for (var i = startPoint; i <= totalPage; i++) {
		point++;
		if (point == 10) {
			break;
		}
		if (i == currentPage) {
			$(".tx-next-page").before("<li class='active tx-active-page'><a href='javascript:void(0);' class='tx-current-click-event' currentPage='"+ i +"'>" + i + "<span class='sr-only'>(current)</span></a></li>");	
		} else {
			$(".tx-next-page").before("<li><a href='javascript:void(0);' class='tx-current-click-event' currentPage='"+ i +"'>" + i + "</a></li>");
		}
	}
	
	$('.tx-pre-click-event').bind('click', preAsyncList);
	$('.tx-next-click-event').bind('click', nextAsyncList);
	$('.tx-current-click-event').bind('click', currentAsyncList);
	$('.tx-page-onkeydown').bind('keydown', gotoAsyncPage);
}
function commonLoad(type){
	if(type==null || type==''){
		var loadHtml = '<div class="loading"><img src="'+ context_path +'/images/loading.gif"></div>';
		if($(".loading").length == 0){
			$("body").append(loadHtml);
		}
		$(".loading").show();
	}else if(type="close"){
		$(".loading").hide();
	}
}

var preAsyncList = function(e) {
	commonLoad();
	var currentPage = parseInt($($('.tx-active-page').find('a')[0]).attr('currentPage'));
	$currentTarget = $(e.currentTarget);
	if ($currentTarget.parent().hasClass('disabled')) {
		return;
	}
	submit(currentPage - 1);
};

var nextAsyncList = function(e) {
	commonLoad();
	var currentPage = parseInt($($('.tx-active-page').find('a')[0]).attr('currentPage'));
	console.log("currentPage: " + currentPage);
	$currentTarget = $(e.currentTarget);
	if ($currentTarget.parent().hasClass('disabled')) {
		return;
	}
	submit(currentPage + 1);
};

var currentAsyncList = function(e) {
	commonLoad();
	$currentTarget = $(e.currentTarget);
	submit($currentTarget.attr('currentPage'));
};

var gotoAsyncPage = function(e) {
	if (e.keyCode == 13) {
		commonLoad();
		$currentTarget = $(e.currentTarget);
		var pagNum = $currentTarget.val();
		submit(pagNum);
	}
};