$(function(){
	var notOwnedMenuId = new Array();
	$("input[name='notOwned']").change(function() {
		if($.inArray($(this).val(),notOwnedMenuId)==-1){
			notOwnedMenuId.push($(this).val());
			$(this).next().css("color","red");
		}else{
			notOwnedMenuId.removeByValue($(this).val());
			$(this).next().css("color","black");
		}
	});
	var OwnedMenuId = new Array();
	var roleMenuId = new Array();
	$("input[name='Owned']").change(function() {
		if($.inArray($(this).val(),OwnedMenuId)==-1){
			OwnedMenuId.push($(this).val());
			roleMenuId.push($(this).attr("rmId"));
			$(this).next().css("color","red");
		}else{
			OwnedMenuId.removeByValue($(this).val());
			roleMenuId.removeByValue($(this).attr("rmId"));
			$(this).next().css("color","black");
		}
	});
	$(".returnPage").on("click",function(){
		$(".alterAddPage").hide();
		$(".maskWindow").hide();
	});
	$(".okAlert").on("click",function(){
		$.ajax({
            url:"menuAction_alertRoleMenu",
            dataType:"html",
            data: {"addMenuId":notOwnedMenuId,"deleteMenuId":OwnedMenuId,"roleMenuId":roleMenuId,"roleId":$("#roleName").attr("roleId")},
            traditional:true,   //阻止深度序列化
            type:"post",
            beforeSend: function(){
                $('.loading').html('正在处理请稍后...');
            },
            success:function(result){
                $("body").html(result);
            },
            error:function(XMLHttpRequest, textStatus, errorThrown){
            	popUpMessage("#alertRoleMenue", "修改失败："+XMLHttpRequest
                		+textStatus+errorThrown, 5000, 35, 30);
            }
        });
		return false;
	});
});	