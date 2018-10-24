$(function(){
	anotherImg();
	inpFocal('#loginName','focusInput');
	inpFocal('#password','focusInput');
	inpFocal('#code','focusInput');
	$('#Submit').on('click',function(){
		if(!(inpValue('#loginName','账号不能为空！',25,40))){
			return false;
		}
		if(!(inpValue('#password','密码不能为空！',25,40))){
			return false;
		}
		if(!(inpValue('#code','验证码不能为空！',25,40))){
			return false;
		}
		if($("#code").val().length<4){
			popUpMessage("#code", "请输入正确的验证码", 2000, 25, 40);
			return false;
		}
	})
	
	/**
	 * 点击验证码图片跟换验证码
	 */
	function anotherImg(){
		$("#codeImg").on('click',function(){
			$("#codeImg").attr("src","pages/util/rand.jsp?rnd="+Math.random());
		});
	}
});