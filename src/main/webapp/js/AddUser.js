	$(function(){
		$("#UpdateDiv").hide();
		var MathReg = /\d/;
		var level = getCookie("level");
		if(level=="A"){
			var option = '<option value="A">A</option><option value="B">B</option><option value="C">C</option>';
			$("#select").append(option);
		}
		if(level=="B"){
			var option = '<option value="B">B</option><option value="C">C</option>';
			$("#select").append(option);
		}
		$("#check").click(function(){
			var username = $("#username").val();
			var password = $("#pwd").val();
			var levelInput=$("#select").val();
			var id = $("#id").val();
			var reg = /(\d{3}-|\d{4}-)?(\d{8}|\d{7})/;
			var updown = true;
			if(username==""){
				$("#sp1").text("用户名不能为空");
				updown = false;
				return;
			}
			if(password==""){
				$("#sp2").text("密码不能为空");
				updown = false;
				return;
			}
			if(id==""){
				alert("员工编号不能为空");
				return;
			}
			if(!MathReg.test(id)){
				alert("员工编号输入错误");
				updown = false;
				return;
			}
			if(updown){
				$.ajax({
	  				url:"http://localhost:8088/WebProject/RegisterRead.do",
	  				type:"post",
	  				data:{"username":username,"id":id},
	  				dataType:"json",
	  				success:function(result){
	  					var status = result.status;
	  					alert(result.msg);
	  					if(status=="0"){
	  						var userinfo = result.data;
	  						$.ajax({
	  			  				url:"http://localhost:8088/WebProject/Register.do",
	  			  				type:"post",
	  			  				data:{"username":username,"password":password,"telephone":userinfo.telep,"levelInput":levelInput,"id":id},
	  			  				dataType:"json",
	  			  				success:function(result){
	  			  					var status = result.status;
	  			  					if(status=="1"){
	  			  						$("#username").text(result.msg);
	  			  					}else{
	  			  						$("#username").text(result.msg);
	  			  						$("#username").val("");
	  			  						$("#id").val("");
	  			  						$("#pwd").val("");
	  			  						alert("添加成功");
	  			  						close();
	  			  					}
	  			  				},
	  			  				error:function(){
	  			  					alert("null");
	  			  				}
	  			  			})
	  					}else{
	  						$("#username").val("");
		  					$("#pwd").val("");
		  					$("#name").val("");
	  						return;
	  					}
	  				},
	  				error:function(){
	  					alert("null");
	  				}
	  			})

			}
			
			
		});
		function close(){
			$("#alert-box div").attr("class");
			$("#alert-box div").attr("class","closeAlertBox 0s");
			$("#alert-box").css("width","0px");
			$("#alert-box").css("height","0px");
		}
	})
	 	 var cookies= getCookie("cookies");
 		
  	if(cookies==null){
  		 window.location.href="login.html";
  	}
  	
  //修改密码
 	function Cancel(){
 		$("#updatePasstable").hide();
 	}
 	//触发修改密码
  	function UpdatePassword(){
  		$("#queryErr").html("");
  		$("#updatePasstable").show();
  		$("#OldPassword").text("");
	  	$("#pass1").text("");
	  	$("#pass2").text("");
  		$("#login_info").text("修改密码");
		$("#usertable").html("");
  		$("#Pagechange").hide();
  		$("#preservations").html("");
  	}
  	//提交修改密码
  	function checkPass(){
  		var boo = true;
  		var username = admin.username;
  		var OldPassword = $("#OldPassword").val();
  		var NewPass1 = $("#pass1").val();
  		var NewPass2 = $("#pass2").val();
  		if(OldPassword==""){
  			alert("原始密码不能为空");
  			boo = false;
  		}
  		if(NewPass1==""){
  			alert("新密码不能为空");
  			boo = false;
  		}
  		if(NewPass1!=NewPass2){
  			alert("两次密码输入不一致");
  			boo = false;
  		}
  		if(OldPassword==NewPass1){
  			boo = false;
  			$("#OldPassword").html("");
	  		$("#pass1").html("");
	  		$("#pass2").html("");
  			$("#updatePasstable").hide();
  		}
  		if(boo){
  			$.ajax({
	  				url:"http://localhost:8088/WebProject/ReadPassword.do",
	  				type:"post",
	  				data:{"OldPassword":OldPassword,"username":username},
	  				dataType:"json",
	  				success:function(result){
	  					//如果原密码匹配成功
	  					if(result.status=="0"){
	  					$.ajax({
	  						url:"http://localhost:8088/WebProject/UpdatePass.do",
	  						type:"post",
	  						data:{"password":NewPass1,"username":username},
	  						dataType:"json",
	  						success:function(result){
	  							if(result.status=="0"){
	  								alert(result.msg);
	  								$("#OldPassword").html("");
	  								$("#pass1").html("");
	  								$("#pass2").html("");
	  								delCookie("cookies");
	  								//定时跳转
  									function TimeJump(count){
	  									$("#updatePasstable").html("<p style='text-align: center;padding-left:100px'>由于您修改了密码，系统将于"+count+"秒后返回登录界面</p>");
	  									window.setTimeout(function(){
	  										count--;
	  										if(count==0){
	  											delCookie("cookies");
	  											location.href="index.html";
	  										}
	  										TimeJump(count);
	  									},1000);
	  									
	  								}
	  								TimeJump(5);
	  							}
	  						},
	  					error:function(){
	  						alert("null");
	  					}
	  				});
	  			}
	  			else{
	  				alert("原始密码不正确");
	  						
	  			}
	  		},
	  		error:function(){
	  			alert("null");
	  		}
	  	});
  	}
}