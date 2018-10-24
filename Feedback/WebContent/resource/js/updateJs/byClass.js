$(function(){
	$("#query").unbind('click').on("click",function(){
		$.ajax({
            url:"reportForms_findReportForms",
            dataType:"html",
            data: {"classId":$("#classId").val()},
            type:"post",
            beforeSend: function(){
                loading = loadingFlash("#main_column", 10, 35, 150);
            },
            success:function(result){
            	$(loading).remove();
                $(".reportForms").html(result);
            },
            error:function(XMLHttpRequest, textStatus, errorThrown){
            	$(loading).remove();
            	popUpMessage("#main_column", "查询失败："+XMLHttpRequest
                		+textStatus+errorThrown, 5000, 35, 30);
            }
        });
	});
});