   	var cookies= getCookie("cookies");
  	if(cookies==null){
  		 window.location.href="login.html";
  	}
  $(function(){
	var i = 1;
	var totalPage = 0;
  	$("#usertable").hide();
  	$("#Pagechange").hide();
  	var level = getCookie("level");
  	if(level=="A"){
		var li='<h2 class="right"><i></i><a href="#" id="admin_List">角色管理</a></h2>'+
		'<h2 id="add-admin" class="right"><i></i><a href="javascript:void(0)" id="">添加管理</a></h2>';
         $("#nav1").append(li);	
  	}else if(level=="B"){
		var li='<h2 id="add-admin" class="right"><i></i><a href="javascript:void(0)" id="">添加管理</a></h2>';
		$("#nav1").append(li);	
  	}
  	$("#admin_List").click(function(){
  			$("#Pagechange").show();
  			$("#login_info").text("管理员信息");
  			$("#usertable").show();
  			$.ajax({
  				url:"http://localhost:8088/WebProject/UserReadPage.do",
  				type:"post",
  				data:{"currentPage":i},
  				dataType:"json",
  				success:function(result){
  					var UserData = result.data;
  					var totalPage1 = result.currentPage;
  					totalPage=totalPage1;
  					if(result.status==1){
 						alert("nodataRead");
  					}else{
  						$("#tb").html("");
  							
  						for(var i = 0;i<UserData.length;i++){
  							//获取字符串
  							//对字符串进行截取
  							//用replace进行字符串的替换
  							var str = UserData[i].telep;
  							var str1 = str.substr(3,4);
  							var telep = str.replace(str1,"****");
  							var tr = "<tr><td>"+UserData[i].id+"</td><td>"+UserData[i].username+"</td><td>"+UserData[i].leve+""+
  							"</td><td>"+telep+"</td><td id='show'><span>操作</span>"+
  							"<div class='clearfix'><a href='javascript:void(0)' class='edit'>修改</a><a href='javascript:void(0)'>删除</a></div>"+
  							"</td></tr>";
  							$("#tb").append(tr);

  							
  						}
  					}
  				},
  				error:function(){
  					alert("null");
  				}
  			})
  		});
  		$("#getLogin").click(function(){
  			delCookie("cookies");
  			window.location.href="login.html";
  		});
  		$("#nextPage").click(function(){
  			i=i+1;
  			if(i>totalPage){
  				i=totalPage;
  			}
  			$.ajax({
  				url:"http://localhost:8088/WebProject/UserReadPage.do",
  				type:"post",
  				data:{"currentPage":i},
  				dataType:"json",
  				success:function(result){
  					var UserData = result.data;
  					if(result.status==1){
 						alert("nodataRead");
  					}else{
  						$("#tb").html("");
  						for(var i = 0;i<UserData.length;i++){
  							//获取字符串
  							//对字符串进行截取
  							//用replace进行字符串的替换
  							var str = UserData[i].telep;
  							var str1 = str.substr(3,4);
  							var telep = str.replace(str1,"****");
  							var tr = "<tr><td>"+UserData[i].id+"</td><td>"+UserData[i].username+"</td><td>"+UserData[i].leve+""+
  							"</td><td>"+telep+"</td><td id='show'><span>操作</span>"+
  							"<div class='clearfix'><a href='javascript:void(0)' class='edit'>修改</a><a href='javascript:void(0)'>删除</a></div>"+
  							"</td></tr>";
  							$("#tb").append(tr);

  							
  						}
  					}
  				},
  				error:function(){
  					alert("null");
  				}
  			})
  		});
  		$("#PreviousPage").click(function(){
  			i=i-1;
  			if(i<1){
  				i=1;
  			}
  			$.ajax({
  				url:"http://localhost:8088/WebProject/UserReadPage.do",
  				type:"post",
  				data:{"currentPage":i},
  				dataType:"json",
  				success:function(result){
  					var UserData = result.data;
  					var totalPage = result.currentPage;
  					if(result.status==1){
 						alert("nodataRead");
  					}else{
  						$("#tb").html("");
  						for(var i = 0;i<UserData.length;i++){
  							//获取字符串
  							//对字符串进行截取
  							//用replace进行字符串的替换
  							var str = UserData[i].telep;
  							var str1 = str.substr(3,4);
  							var telep = str.replace(str1,"****");
  							var tr = "<tr><td>"+UserData[i].id+"</td><td>"+UserData[i].username+"</td><td>"+UserData[i].leve+""+
  							"</td><td>"+telep+"</td><td id='show'><span>操作</span>"+
  							"<div class='clearfix'><a href='javascript:void(0)' class='edit'>修改</a><a href='javascript:void(0)'>删除</a></div>"+
  							"</td></tr>";
  							$("#tb").append(tr);

  							
  						}
  					}
  				},
  				error:function(){
  					alert("null");
  				}
  			})
  		});
  })
