$(function(){
	$(".page span").each(function(){
		$(this).on("click",function(){
			$.ajax({
	            url:"menuAction_menuManage?lookMenu=1",
	            dataType:"html",
	            data: {"page":$(this).attr("page")},
	            traditional:true,   //阻止深度序列化
	            type:"post",
	            beforeSend: function(){
	                loading = loadingFlash(".alertPageMain", 10, 35, 150);
	            },
	            success:function(result){
	            	$(loading).remove();
	                $("body").html(result);
	            },
	            error:function(XMLHttpRequest, textStatus, errorThrown){
	            	$(loading).remove();
	            	popUpMessage(".page", "查询失败："+XMLHttpRequest
	                		+textStatus+errorThrown, 5000, 35, 30);
	            }
	        });
		});
	});
	$(".lookMenu").each(function(){
		$(this).on("click",function(){
			$.ajax({
	            url:"menuAction_alertMenu?lookMenu=1",
	            dataType:"html",
	            data: {"menuId":findFatherBrothers(this, "td", 1)},
	            type:"post",
	            beforeSend: function(){
	            	$(".maskWindow").show();
	                loading = loadingFlash(".alertPageMain", 10, 35, 150);
	            },
	            success:function(result){
	            	$(loading).remove();
	    			$(".alertPageMain").show();
	                $(".alterAddPage").html(result);
	                
	            },
	            error:function(XMLHttpRequest, textStatus, errorThrown){
	            	$(loading).remove();
	            	popUpMessage(".page", "查询失败："+XMLHttpRequest
	                		+textStatus+errorThrown, 5000, 35, 30);
	            }
	        });
		});
	});
	
	$(".closeAlertPageMain").on("click",function(){
		$(".maskWindow").hide();
		$(".alertPageMain").hide();
	});
});