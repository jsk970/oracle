function check(){
			if(loginform.fTel.value == ""){
				alert("fTel不能为空！");
				return false;
				}
			if(loginform.fPassword.value == ""){
				alert("PASSWORD不能为空！");
				return false;
			}
				
		}

addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); 
function hideURLbar(){ window.scrollTo(0,1); } 