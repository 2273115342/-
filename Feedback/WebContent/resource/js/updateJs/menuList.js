$(function(){
	$(".page span").each(function(){
		$(this).on("click",function(){
			$.ajax({
	            url:"menuAction_menuManage",
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
	$(".alertMenu").each(function(){
		$(this).on("click",function(){
			$.ajax({
	            url:"menuAction_alertMenu",
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
	
	$(".deleteMenu").each(function(){
		$(this).on("click",function(){
			if (confirm("您确定要删除  "+findFatherBrothers(this,"td",2)+"  这个菜单吗？")){
				$.ajax({
		            url:"menuAction_deleteMenu",
		            dataType:"html",
		            data: {"menuId":findFatherBrothers(this, "td", 1)},
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
		            	popUpMessage(".page", "删除失败："+XMLHttpRequest
		                		+textStatus+errorThrown, 5000, 35, 30);
		            }
		        });
			}
		});
	});
	
	$(".deletePitchOn").on("click",function(){
		if($("input[name='ids']:checked").val()==null||$("input[name='ids']:checked").length<=0){
			popUpMessage(this, "请选择要删除的菜单id", 3000, 15, 25, false);
			return false;
		}
		if (!confirm("您确定要删除这些选中的菜单吗？")){
			return false;
		}
	});
	
	$(".closeAlertPageMain").on("click",function(){
		$(".alertPageMain").hide();
		$(".maskWindow").hide();
	});
});