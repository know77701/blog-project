let index ={
	init: function(){
		$("#btn-save").on("click", ()=>{ // this 를 바인딩하기 위해 화살표 함수 사용
			this.save();
		});
		$("#btn-update").on("click", ()=>{ // this 를 바인딩하기 위해 화살표 함수 사용
			this.update();
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
			console.log(res);
			alert("회원가입 완료");
			location.href="/";
		}).fail(function(err){
			console.log(JSON.stringify(err));
		});
	},
	update: function(){
		let data = {
			id : $("#id").val(),
			password: $("#password").val(),
			email: $("#email").val(),
		}
		
		$.ajax({
			type:"PUT",
			url: "/user",
			data : JSON.stringify(data),
			contentType : "application/json;charset=utf-8"
		}).done(function(res){
			alert("수정이 완료되었습니다.");
			location.href="/";
		}).fail(function(err){
			console.log(JSON.stringify(err));
		});
	}
}

index.init();
