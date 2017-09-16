 //同步移除标签
	    function removeTag(userId,tagValueId,page){
	    	$('#removeUserTag').modal('hide');
	    	var userId = $("#currUserId").val();
	    	var tagValueId = $("#tagValueId").val();
	    	var page = $("#currPage").val();
	    	$.post(
	    			context_path + "/crm/v1/member/removeUserTag",	
	        		{'user_id':userId,'tag_value_id':tagValueId},
	        		function(data) {
	        			if(data.code == 1){
	        				window.location.href= context_path+"/crm/v1/member/list?page="+page;
	        			}else{
	        				$('.user-status-failure').html('标签移除失败，请稍后再试！');
	        				$('.user-status-failure').fadeIn(1000);
	        				$('.user-status-failure').fadeOut(2000);
	        				return;
	        			}
	        		},
	        		'JSON'
	        	); 	
	    }
	    $('#removeUserTag').on('show.bs.modal', function (event) {
	    	 var button = $(event.relatedTarget)
	    	 var recipient = button.data('whatever') 
	    	 var paramInfo= recipient.split(",");
	    	 $("#currUserId").val(paramInfo[0]);
	    	 $("#tagValueId").val(paramInfo[1]);
	    	 $("#currPage").val(paramInfo[2]);
	    })
	      $('#removeAsynUserTag').on('show.bs.modal', function (event) {
	    	 var button = $(event.relatedTarget)
	    	 var recipient = button.data('whatever') 
	    	 var paramInfo= recipient.split(",");
	    	 $("#currUserId").val(paramInfo[0]);
	    	 $("#tagValueId").val(paramInfo[1]);
	    	 $("#currPage").val(paramInfo[2]);
	    })
	  //异步移除标签
	    function removeAsynTag(userId,tagValueId,page){
	    	$('#removeAsynUserTag').modal('hide');
	    	var userId = $("#currUserId").val();
	    	var tagValueId = $("#tagValueId").val();
	    	var page = $("#currPage").val();
	    	$.post(
	    			context_path + "/crm/v1/member/removeUserTag",	
	        		{'user_id':userId,'tag_value_id':tagValueId},
	        		function(data) {
	        			if(data.code == 1){
	        			 submit(page);
	        			}else{
	        				$('.user-status-failure').html('标签移除失败，请稍后再试！');
	        				$('.user-status-failure').fadeIn(1000);
	        				$('.user-status-failure').fadeOut(2000);
	        				return;
	        			}
	        		},
	        		'JSON'
	        	); 	
	    }
	    //同步加入黑名单
	    $('#addBanlist').on('show.bs.modal', function (event) {
	    	 var button = $(event.relatedTarget)
	    	 var recipient = button.data('whatever') 
	    	 var userInfo = recipient.split(",");
	    	 $("#currUserId").val(userInfo[0]);
	    	 $("#currBanStatus").val(userInfo[1]);
	    	 $("#currPage").val(userInfo[2]);
	    })
	    //取消
	     $('#cancelBanlist').on('show.bs.modal', function (event) {
	    	 var button = $(event.relatedTarget)
	    	 var recipient = button.data('whatever') 
	    	 var userInfo = recipient.split(",");
	    	 $("#currUserId").val(userInfo[0]);
	    	 $("#currBanStatus").val(userInfo[1]);
	    	 $("#currPage").val(userInfo[2]);
	    })
	     //同步设置为黑客
	    $('#addHackerlist').on('show.bs.modal', function (event) {
	    	 var button = $(event.relatedTarget)
	    	 var recipient = button.data('whatever') 
	    	 var userInfo = recipient.split(",");
	    	 $("#currUserId").val(userInfo[0]);
	    	 $("#currBanStatus").val(userInfo[1]);
	    	 $("#currPage").val(userInfo[2]);
	    })
	    //解除黑客
	     $('#cancelHackerlist').on('show.bs.modal', function (event) {
	    	 var button = $(event.relatedTarget)
	    	 var recipient = button.data('whatever') 
	    	 var userInfo = recipient.split(",");
	    	 $("#currUserId").val(userInfo[0]);
	    	 $("#currBanStatus").val(userInfo[1]);
	    	 $("#currPage").val(userInfo[2]);
	    })
	    function addBanlistSure(){
	    	$('#addBanlist').modal('hide');
	    	var userId = $("#currUserId").val();
	    	var banStatus = $("#currBanStatus").val();
	    	var page = $("#currPage").val();
	    	console.log($("#currUserId").val(),$("#currBanStatus").val(),$("#currPage").val());
	    	$.post(
	    			context_path + "/crm/v1/member/changeMemberStatus",	
	        		{'user_id':userId,'ban_status':banStatus},
	        		function(data) {
	        			if(data.code == 1){
	        				window.location.href=context_path+"/crm/v1/member/list?page="+page;
	        			}else{
	        				$('.user-status-failure').html('用户状态变更失败，请稍后再试！');
	        				$('.user-status-failure').fadeIn(1000);
	        				$('.user-status-failure').fadeOut(2000);
	        				return;
	        			}
	        		},
	        		'JSON'
	        	);
	    }
	    //异步加入黑名单
	    $('#addAsynBanlist').on('show.bs.modal', function (event) {
	    	 var button = $(event.relatedTarget)
	    	 var recipient = button.data('whatever') 
	    	 var userInfo = recipient.split(",");
	    	 $("#currUserId").val(userInfo[0]);
	    	 $("#currBanStatus").val(userInfo[1]);
	    	 $("#currPage").val(userInfo[2]);
	    	 console.log(userInfo[2]);
	    })
	    //异步移除黑名单
	     $('#cancelAsynBanlist').on('show.bs.modal', function (event) {
	    	 var button = $(event.relatedTarget)
	    	 var recipient = button.data('whatever') 
	    	 var userInfo = recipient.split(",");
	    	 $("#currUserId").val(userInfo[0]);
	    	 $("#currBanStatus").val(userInfo[1]);
	    	 $("#currPage").val(userInfo[2]);
	    })
	     //异步设置为黑客
	    $('#addAsynHackerlist').on('show.bs.modal', function (event) {
	    	 var button = $(event.relatedTarget)
	    	 var recipient = button.data('whatever') 
	    	 var userInfo = recipient.split(",");
	    	 $("#currUserId").val(userInfo[0]);
	    	 $("#currBanStatus").val(userInfo[1]);
	    	 $("#currPage").val(userInfo[2]);
	    })
	    //异步解除黑客
	     $('#cancelAsynHackerlist').on('show.bs.modal', function (event) {
	    	 var button = $(event.relatedTarget)
	    	 var recipient = button.data('whatever') 
	    	 var userInfo = recipient.split(",");
	    	 $("#currUserId").val(userInfo[0]);
	    	 $("#currBanStatus").val(userInfo[1]);
	    	 $("#currPage").val(userInfo[2]);
	    })
	    function addAsynBanlistSure(){
	    	$('#addAsynBanlist').modal('hide');
	    	$('#cancelAsynBanlist').modal('hide');
	    	$('#cancelAsynHackerlist').modal('hide');
	    	$('#addAsynHackerlist').modal('hide');
	    	var userId = $("#currUserId").val();
	    	var banStatus = $("#currBanStatus").val();
	    	var page = $("#currPage").val();
	    	console.log($("#currUserId").val(),$("#currBanStatus").val(),$("#currPage").val());
	    	$.post(
	    			context_path + "/crm/v1/member/changeMemberStatus",	
	        		{'user_id':userId,'ban_status':banStatus},
	        		function(data) {
	        			if(data.code == 1){
	        			 submit(page);
	        			}else{
	        				$('.user-status-failure').html('用户状态变更失败，请稍后再试！');
	        				$('.user-status-failure').fadeIn(1000);
	        				$('.user-status-failure').fadeOut(2000);
	        				return;	
	        			}
	        		},
	        		'JSON'
	        	);
	    }