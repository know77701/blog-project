let index ={
	init: function(){
		$("#btn-save").on("click", ()=>{ // this 를 바인딩하기 위해 화살표 함수 사용
			this.save();
		});
	},
	
	save: function(){
		let data = {
			title: $("#title").val(),
			content: $("#content").val(),
		}
		
		// ajax 호출 시 default 비동기 호출
		$.ajax({
			type:"POST",
			url: "/api/board",
			data : JSON.stringify(data),
			contentType : "application/json;charset=utf-8"
		}).done(function(res){
			alert("글쓰기 완료");
			location.href="/";
		}).fail(function(err){
			console.log(JSON.stringify(err));
		});
	},
}

index.init();
