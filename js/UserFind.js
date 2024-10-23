//角色管理   	
	
  	var tel = "";
  	//分页查询
  	function PageChangeRead(btn){
			$.ajax({
				url:"http://localhost:8088/WebProject/UserReadPage.do",
				type:"post",
				data:{"currentPage":btn},
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
							$(btn).css("color","red");
							var tr = "<tr><td>"+UserData[i].id+"</td><td>"+UserData[i].username+"</td><td>"+UserData[i].leve+""+
							"</td><td>"+UserData[i].telep+"</td><td id='show'><span>操作</span>"+
							"<div class='clearfix'><a href='#' class='edit' id='updateclick"+i+"'onclick='updateOnclick(this);'>修改</a><a href='javascript:void(0)' id='deleteclick"+i+"' onclick='deleteOnclick(this.id)'>删除</a></div>"+
							"</td></tr>";
							$("#tb").append(tr);
						}
					}
				},
				error:function(){ 
					alert("null");
				}
			});
		} 	
 
  $(function(){
	  $("#preservations").html("");
	$("#updatePasstable").hide();
	var i = 1;
	var totalPage = 0;
  	$("#Pagechange").hide();
  	var level = getCookie("level");
  	if(level=="A"){
		var li='<h2 class="right"><i></i><a href="#" id="admin_List">角色管理</a></h2>'+
		'<h2 id="add-admin" class="right"><i></i><a href="javascript:void(0)" id="">添加管理</a></h2>';
         $("#nav1").append(li);	
  	}else if(level=="B"){
		var li='<h2 id="add-admin" class="right"><i></i><a href="#" id="">添加管理</a></h2>';
		$("#nav1").append(li);	
  	}
  	//点击管理员信息查询
  	$("#admin_List").click(function(){
  		$("#preservations").html("");
  		$("#queryErr").html("");
  		$("#usertable").html("");
  			var usertable = '<thead>'+
				'<tr>'+
			'<th>Id</th>'+
			'<th>Name</th>'+
			'<th>Level</th>'+
			'<th>Tel</th>'+
			'<th>Operation</th>'+
		'</tr>'+
	'</thead><tbody id="tb"></tbody>';
  			$("#usertable").append(usertable);
  			$("#Pagechange").show();
  			$("#login_info").text("管理员信息");
  			$("#tb").html("");
  			$("#usertable").show();
  			$("#updatePasstable").hide();
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
  							var tr = "<tr><td>"+UserData[i].id+"</td><td>"+UserData[i].username+"</td><td>"+UserData[i].leve+""+
  							"</td><td>"+UserData[i].telep+"</td><td id='show'><span>操作</span>"+
  							"<div class='clearfix'><a href='#' class='edit' id='updateclick"+i+"'onclick='updateOnclick(this);'>修改</a><a id='deleteclick"+i+"' href='javascript:void(0)' onclick='deleteOnclick(this.id);'>删除</a></div>"+
  							"</td></tr>";
  							$("#tb").append(tr);
  							
  						}
  						$("#Pagechange ul").html("");
  						//遍历页码
					for(var j = 1;j<=totalPage1;j++){
						$("#Pagechange ul").append("<li><a href='javascript:PageChangeRead("+j+")'>"+j+"</a></li>");
						
					}
//						var pliu = $("#Pagechange ul").text().length;
//						if(pliu<totalPage1){
//	  						var li = "<li><a href='#' id='to'"+totalPage1+">"+totalPage1+"</a></li>";
//	  						$("#Pagechange ul").append(li);
//						}

  					}
  				},
  				error:function(){
  					alert("null");
  				}
  				
  			});
  			
  		});
  	//退出登录
  		$("#getLogin").click(function(){
  			delCookie("cookies");
  			window.location.href="login.html";
  		});
  		//下一页
  		$("#nextPage").click(function(){
  			i=i+1;
  			if(i>totalPage){
  				i=totalPage;
  			}
  			PageChangeRead(i);
  		});
  		//上一页
  		$("#PreviousPage").click(function(){
  			i=i-1;
  			if(i<1){
  				i=1;
  			}
  			PageChangeRead(i);
  		});
  });
