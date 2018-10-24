function delSingle(id) {
	if (confirm("操作不可恢复,你确认要结束吗？")) {
		document.getElementById("id").value = id;
		document.frmAction.action = "feedBackAction_end";
		document.frmAction.submit();
	}
}