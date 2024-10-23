var admin;
var username = getCookie("Username");
$.ajax( {
	url : "http://localhost:8088/WebProject/AdminFind.do",
	type : "post",
	data : {
		"username" : username
	},
	dataType : "json",
	success : function(result) {
		var status = result.status;
		admin = result.data;
	}
})