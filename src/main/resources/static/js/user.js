let index ={
	init: function(){
		$("#btn-save").on("click", ()=>{ // this 를 바인딩하기 위해 화살표 함수 사용
			this.save();
		});
	},
	
	save: function(){
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val(),
		}
		
		$.ajax({
			type:"POST",
			url: "/auth/join",
			data : JSON.stringify(data),
			contentType : "application/json;charset=utf-8"
		}).done(function(res){
			alert("회원가입 완료");
			location.href="/";
		}).fail(function(err){
			console.log(JSON.stringify(err));
		});
	}
}

index.init();
