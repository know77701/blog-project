<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>


<form>
  <div class="form-group">
    <label for="title">Title</label>
    <input value=${board.title } type="text" name="title" class="form-control" placeholder="Enter title" id="title">
  </div>

	<div class="form-group">
	  <label for="content">Content</label>
	  <textarea class="form-control summernote" rows="5" id="content">${board.content }</textarea>
	</div>

  <input type="hidden" id="id" value="${board.id}">
</form>

 <button id="btn-update" class="btn btn-primary">저장</button>

<script>
  $('.summernote').summernote({
    tabsize: 4,
    height: 100
  });
</script>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp" %>