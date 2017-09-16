$(document).ready(function(){
	initPage();
	$('.tx-pre-click-event').bind('click', preList);
	$('.tx-next-click-event').bind('click', nextList);
	$('.tx-current-click-event').bind('click', currentList);
	$('.tx-page-onkeydown').bind('keydown', gotoPage);
});

var preList = function(e) {
	var currentPage = parseInt($($('.tx-active-page').find('a')[0]).attr('currentPage'));
	$currentTarget = $(e.currentTarget);
	if ($currentTarget.parent().hasClass('disabled')) {
		return;
	}
	getPage(currentPage - 1);
};

var nextList = function(e) {
	var currentPage = parseInt($($('.tx-active-page').find('a')[0]).attr('currentPage'));
	$currentTarget = $(e.currentTarget);
	if ($currentTarget.parent().hasClass('disabled')) {
		return;
	}
	getPage(currentPage + 1);
};

var currentList = function(e) {
	$currentTarget = $(e.currentTarget);
	getPage($currentTarget.attr('currentPage'));
};

var gotoPage = function(e) {
	if (e.keyCode == 13) {
		$currentTarget = $(e.currentTarget);
		var pagNum = $currentTarget.val()<totalPage ? $currentTarget.val():totalPage;
		getPage(pagNum);
	}
};

function getPage(page) {
	window.location.href = tagetUrl+"page="+page;
}

function initPage() {
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
			$(".tx-next-page").before("<li class='active tx-active-page'><a href='#' class='tx-current-click-event' currentPage='"+ i +"'>" + i + "<span class='sr-only'>(current)</span></a></li>");	
		} else {
			$(".tx-next-page").before("<li><a href='#' class='tx-current-click-event' currentPage='"+ i +"'>" + i + "</a></li>");
		}
	}
}