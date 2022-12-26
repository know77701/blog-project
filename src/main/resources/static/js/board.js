let index ={
	init: function(){
		$("#btn-save").on("click", ()=>{ // this 를 바인딩하기 위해 화살표 함수 사용
			this.save();
		});
		$("#btn-delete").on("click", ()=>{ // this 를 바인딩하기 위해 화살표 함수 사용
			this.deleteById();
		});
		$("#btn-update").on("click", ()=>{ // this 를 바인딩하기 위해 화살표 함수 사용
			this.update();
		});
	},
	
	save: function(){
		let data = {
			title: $("#title").val(),
			content: $("#content").val(),
		}
		
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
	deleteById: function(){
		let id = $("#id").text();
		
		$.ajax({
			type:"DELETE",
			url: "/api/board/"+id,
		}).done(function(res){
			alert("삭제 완료");
			location.href="/";
		}).fail(function(err){
			console.log(JSON.stringify(err));
		});
	},
	update: function(){
		let id = $("#id").val();
		let data = {
			title: $("#title").val(),
			content: $("#content").val(),
		}
		
		$.ajax({
			type:"PUT",
			url: "/api/board/"+id,
			data : JSON.stringify(data),
			contentType : "application/json;charset=utf-8"
		}).done(function(res){
			alert("글수정 완료");
			location.href="/";
		}).fail(function(err){
			console.log(JSON.stringify(err));
		});
	},
}

index.init();
