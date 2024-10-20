window.onload = function () {
	setEditAttribute();
	setDate();
	alertBox();
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

	// 添加按钮
	aCancle[1].onclick = function () {
		closeAlertBox();

	}

	// 关闭窗口
	function closeAlertBox() {
		oAlertBox.querySelector('div').style.animation = 'closeAlertBox 0s';
		setTimeout(function () {
			oAlertBox.style.width = '0';
			oAlertBox.style.height = '0';
		}, 0);
	}

	
}