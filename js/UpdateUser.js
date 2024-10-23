    var uid = "";
  	var uname = "";
  	var ur = "";
  	var leve = "";
  	var telephone = "";
  	var i = 0;
  	var parent1 = "";
  	var btn1 = "";
  	var par1 = "";
  	function UpdateUser(){
  		var id = $("#userid").val();
  		uid = id;
  		var username = $("#username").val().trim();
  		uname = username;
  		var level = $("#level").val().trim();
  		var telep = $("#tel").val().trim();
  		tel = telep;
  		var reg = /(\d{3}-|\d{4}-)?(\d{8}|\d{7})/;
  		var updown = true;
  		if(username==""){
  			alert("用户名不能为空");
  			updown = false;
  			return;
  		}
  		if(level==""){
  			alert("级别不能为空");
  			updown = false;
  			return;
  		}
  		if(telep==""){
  			alert("联系方式不能为空");
  			updown = false;
  			return;
  		}
  		if(!reg.test(telep)){
  			alert("手机号不匹配");
  			updown = false;
  			return;
  		}
  		var lev = level.toUpperCase();
  		leve = lev;
  		if(lev=="A"||lev=="B"||lev=="C"){
  			updown = true;
  		}else{
  			alert("级别输入错误");
  			updown = false;
  			return;
  		}
  		
  		if(updown&&ur==username){
  			$.ajax({
				url:"http://localhost:8088/WebProject/Update.do",
				type:"post",
				data:{"userid":id,"username":username,"level":lev,"tel":telep},
				dataType:"json",
				success:function(result){
					var i = result.status;
					if(i=="0"){
						alert(result.msg);
				  		i++;
						yes(id,username,level,telep);
						return;
					}else{
						alert("修改失败");
						return;
					}
				},
				error:function(){
					alert("null");
				}
			})
  		}
  		if(updown&&ur!=username){
  			$.ajax({
  				url:"http://localhost:8088/WebProject/RegisterRead.do",
  				type:"post",
  				data:{"username":username},
  				dataType:"json",
  				success:function(result){
  					var status = result.status;
  					if(status=="0"){
  						alert(result.msg);
  						$.ajax({
  							url:"http://localhost:8088/WebProject/Update.do",
  							type:"post",
  							data:{"userid":id,"username":username,"level":lev,"tel":telep},
  							dataType:"json",
  							success:function(result){
  								var i = result.status;
  								if(i=="0"){
  									alert("修改成功");
  							  		i++;
  									yes(id,username,lev,telep);
  									return;
  								}else{
  									alert("修改失败");
  									return;
  								}
  							},
  							error:function(){
  								alert("null");
  							}
  						})
  					}else{
  						alert(result.msg);
  						$("#username").val("");
	  					$("#pwd").val("");
	  					$("#telephone").val("");
  						return;
  					}
  				},
  				error:function(){
  					alert("null");
  				}
  			})
  		}
  	}

  	
  	function updateOnclick(btn){
  		btn1 = btn;
  		var parent = $(btn).parent().parent().parent().children();
  		parent1 = parent;
  		var id = parent.eq(0).text();
  		var user = parent.eq(1).text();
  		ur = user;
  		parent.eq(0).html("<input type='text' id='userid' readonly='readonly' value="+id+">");
  		//parent.eq(1).html("<input type='text' id='username' value=''/>");
  		parent.eq(1).html("<input type='text' id='username' value="+parent.eq(1).text().trim()+" readonly = 'readonly'>");
  		parent.eq(2).html("<input type='text' id='level' value="+parent.eq(2).text().trim()+">");
  		parent.eq(3).html("<input type='text' id='tel' value="+parent.eq(3).text().trim()+">");
  		var par = $("#tb").children();
  		par1 = par;
  		for(var j = 0;j<par.length;j++){
  			par.eq(j).children().eq(4).children().next().eq(0).children().eq(0).attr("onclick","#");
  		}
  		$(btn).attr("id","preservation");
  		$(btn).attr("onclick","UpdateUser()");
  		var a = $(btn).html();
  		$(btn).html("保存");
  		if(i>=1){
  			$(btn).attr("onclick","updateOnclick()");
  			$(btn).attr("id","");
  			$(btn).html("修改");
  			i=0;
  			return;
  		}

  	}
  	function yes(id,name,leve,telep){
  		parent1.eq(0).html(id);
  		parent1.eq(1).html(name);
  		parent1.eq(2).html(leve.toUpperCase());
  		parent1.eq(3).html(telep);
  		i=0;
  		if(i==0){
  			up();
  		}
  	}
  	function up(){
  		for(var j = 0;j<par1.length;j++){
  			par1.eq(j).children().eq(4).children().next().eq(0).children().eq(0).attr("onclick","updateOnclick(this)");
  			par1.eq(j).children().eq(4).children().next().eq(0).children().eq(0).html("修改");
  		}
  	}