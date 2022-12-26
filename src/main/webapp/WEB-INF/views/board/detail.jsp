<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

	<button class="btn btn-secondary" onclick="history.back();">돌아가기</button>
	<c:if test="${board.user.id == principal.user.id }">
		<a href="/board/${board.id}/updateForm" class="btn btn-warning">수정</a>
		<button id="btn-delete" class="btn btn-danger">삭제</button>
	</c:if>
	<br>
	<br>
	<div>
		글번호 : <span id="id">${board.id}</span>
		작성자 : <span id="id">${board.user.username}</span>
	</div>
	<br />
	<hr>
	  <div class="form-group">
	    <h1>${board.title}</h1>
	  </div>
	<hr />
	<div class="form-group">
	  <div>${board.content}</div>
	</div>

	<hr />

 <button id="btn-save" class="btn btn-primary">저장</button>

<script>
  $('.summernote').summernote({
    tabsize: 4,
    height: 100
  });
</script>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp" %>