function check(){
			if(registform.fTel.value == ""){
				alert("FTEL不能为空！");
				return false;
			}
			if(registform.fPassword.value == ""){
				alert("PASSWORD不能为空！");
				return false;
			}
			if(registform.fPwd.value == ""){
				alert("PASSWORD AGAIN不能为空！");
				return false;
			}
			
			if(registform.fPassword.value != registform.fPwd.value){
					alert("两次输入密码不一样！");
					return false;
				}
			return true;
				
		}
	


addEventListener("load", function() { 
	setTimeout(hideURLbar, 0); 
	}, false); 
function hideURLbar(){ 
	window.scrollTo(0,1); 
	} 