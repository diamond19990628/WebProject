//删除用户
function deleteOnclick(btn){
		var par_del = $("#"+btn+"").prev().parent().parent().parent().children();
		var id = par_del.eq(0).text();
		if(id==admin.id){
			alert("无法删除当前登录的账户");
			return;
		}
		$.ajax({
  		url:"http://localhost:8088/WebProject/Delete.do",
  		type:"post",
  		data:{"id":id},
  		dataType:"json",
  			success:function(result){
  				var status = result.status;
				if(status=="0"){
					alert("yes");
					$("#"+btn+"").parent().parent().parent().remove();
				}else{
					alert("no");
				}
  			},
  			error:function(){
  				alert("null");
  			}  		
  		})
  }