window.onload = function () {
	setEditAttribute();
	setDate();
	alertBox();
	alertBox2();
//	alertBox3();
}

// 表格有任何更改时调用此方法 
// 给表格所有选项添加给编辑属性
function setEditAttribute() {
	var aEdit = document.querySelectorAll('.edit');
	var aTr = document.querySelectorAll('tbody tr');

	for (var i = 0; i < aEdit.length; i++) {
		aEdit[i].index =  i;

		aEdit[i].onclick = function () {

			var aTd = aTr[this.index].querySelectorAll('td');
			for (var j = 1; j < aTd.length - 1; j++) {
				aTd[j].setAttribute('contenteditable', 'true');
				aTd[j].setAttribute('spellcheck', 'false');
			}
			
			aTd[1].focus();
		}
	}
}

// 设置时间
function setDate() {
	var oDate = new Date();
	var time = oDate.getFullYear() + ' - ' + (oDate.getMonth() + 1) + ' - ' + oDate.getDate();
	document.getElementsByClassName('time')[0].innerText = time;
}

// 弹出添加管理员
function alertBox() {
	var oAlertBox = document.querySelector('#alert-box');
	var showAlertBoxBtn = document.querySelector('#add-admin');
	var aCancle = oAlertBox.querySelectorAll('a');
	showAlertBoxBtn.onclick = function () {
		oAlertBox.style.width = '100%';
		oAlertBox.style.height = '100%';
		oAlertBox.querySelector('div').style.animation = 'alertBox 0s';
	}


	// 取消按钮
	aCancle[0].onclick = function () {
		closeAlertBox();

	}

//	 //添加按钮
//	aCancle[1].onclick = function () {
//		closeAlertBox();
//
//	}

	// 关闭窗口
	function closeAlertBox() {
		oAlertBox.querySelector('div').style.animation = 'closeAlertBox 0s';
		setTimeout(function () {
			oAlertBox.style.width = '0';
			oAlertBox.style.height = '0';
		}, 0);
	}

	
}
//添加用户弹窗
function alertBox2() {
	var oAlertBox2 = document.querySelector('#alert-box2');
	var showAlertBoxBtn2 = document.querySelector('#add-User');
	var aCancle2 = oAlertBox2.querySelectorAll('a');
	showAlertBoxBtn2.onclick = function () {
		oAlertBox2.style.width = '100%';
		oAlertBox2.style.height = '100%';
		$("#uname").val("");
  		$("#userage").val("");
  		$("#usersex").val("");
  		$("#userIdcard").val("");
  		$("#usertelep").val("");
  		$("#useraddress").val("");
  		$("#usernamecheck").html("");
  		$("#agecheck").html("");
  		$("#sexcheck").html("");
  		$("#sfzcheck").html("");
  		$("#telcheck").html("");
  		$("#addresscheck").html("");
		oAlertBox2.querySelector('div').style.animation = 'alertBox 500s';
	}


	// 取消按钮
	aCancle2[0].onclick = function () {
		closeAlertBox2();

	}

//	 //添加按钮
//	aCancle[1].onclick = function () {
//		closeAlertBox();
//
//	}

	// 关闭窗口
	function closeAlertBox2() {
		oAlertBox2.querySelector('div').style.animation = 'closeAlertBox 500s';
		setTimeout(function () {
			oAlertBox2.style.width = '0';
			oAlertBox2.style.height = '0';
		}, 500);
	}

	
}
//function alertBox3() {
//	var oAlertBox3 = document.querySelector('#alert-box3');
//	var showAlertBoxBtn3 = document.querySelector('#add-User');
//	var aCancle3 = oAlertBox3.querySelectorAll('a');
//	showAlertBoxBtn3.onclick = function () {
//		oAlertBox3.style.width = '100%';
//		oAlertBox3.style.height = '100%';
//		oAlertBox3.querySelector('div').style.animation = 'alertBox 500s';
//	}
//
//
//	// 取消按钮
//	aCancle3[0].onclick = function () {
//		closeAlertBox3();
//
//	}
//
////	 //添加按钮
////	aCancle[1].onclick = function () {
////		closeAlertBox();
////
////	}
//
//	// 关闭窗口
//	function closeAlertBox3() {
//		oAlertBox3.querySelector('div').style.animation = 'closeAlertBox 500s';
//		setTimeout(function () {
//			oAlertBox3.style.width = '0';
//			oAlertBox3.style.height = '0';
//		}, 500);
//	}
//
//	
//}