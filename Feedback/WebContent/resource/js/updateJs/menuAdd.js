$(function(){
	$("#clear").on("click",function(){
		$("#frmAction")[0].reset()
	});
	$("#submit").on("click",function(){
		if(!inpValue("#menuName","菜单名不能为空",15,25)){
			return false;
		};
		if(!inpValue("#url","响应的链接不能为空",15,25)){
			return false;
		};
		if($("#menuIcon").attr("value").trim().length<=0&&$("#menuIcon").val().trim().length<=0){
			popUpMessage("#menuIcon","上传的图片不能为空", 2000, 15, 25);
			return false;
		};
		if(maxlen-$("#menuDesc").val().length<0){
			popUpMessage(this, "输入的字数已经上限",2000, 15, 25); //此方法为封装的一个提示方法
			$("#menuDesc").focus();
			return false;
		}
		if($("#menuIcon").attr("value").trim().length>0){
			$("#frmAction").attr("action","menuAction_updateMenu?menuIconOld="+$("#menuIcon").attr("value"));
		}
	});
	var maxlen = 40;
	$("#menuDesc").bind("input propertychange",function(){
		$(".checkText").html("你还能输入"+(maxlen-$("#menuDesc").val().length)+"字");
		if(maxlen-$("#menuDesc").val().length<=0){
			$("#menuDesc").focus();
			popUpMessage("#menuDesc", "输入的字数已经上限", 3000, 15, 25);
		}
	});
	$("#menuDesc").focus(function(){
		$(".checkText").html("你还能输入"+(maxlen-$("#menuDesc").val().length)+"字");
	});
	$("#menuDesc").blur(function(){
		$(".checkText").html("");
	});
	
	$("#menuIcon").on("change",function(){
		var $file = $(this);
        var fileObj = $file[0];
        var windowURL = window.URL || window.webkitURL;
        var dataURL;
        var $img = $("#updateImg");
        //简单判断文件格式是否正确
        var imgSuffixName = "BMP,JPG,JPEG,PNG,GIF";
        var imgSuffixName2 = $("#menuIcon").val().substr($("#menuIcon").val().length-3,3).toUpperCase();
        if(imgSuffixName.indexOf(imgSuffixName2)==-1){
        	popUpMessage("#menuIcon", "选择的图片格式不正确，请选择以"+imgSuffixName+"为后缀名的文件", 3000, 15, 25);
        	$("#menuIcon").val("");
        	 $(".imgArea").hide();
        	return false;
        }
        if (fileObj && fileObj.files && fileObj.files[0]) {
            dataURL = windowURL.createObjectURL(fileObj.files[0]);
            $img.attr('src', dataURL);
        } else {
            dataURL = $file.val();
            var imgObj = document.getElementById("updateImg");
            imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
            imgObj.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;
        }
        $(".imgArea").show();
	});
});