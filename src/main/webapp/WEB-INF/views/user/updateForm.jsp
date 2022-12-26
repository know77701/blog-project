<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<form>
  <div class="form-group">
    <label for="usernmae">username:</label>
    <input type="text" value="${principal.user.username}" class="form-control" placeholder="Enter username" id="username" readonly="readonly">
  </div>
  <div class="form-group">
    <label for="email">Email address:</label>
    <input type="email" value="${principal.user.email}" class="form-control" placeholder="Enter email" id="email">
  </div>
  <div class="form-group">
    <label for="password">Password:</label>
    <input type="password" class="form-control" placeholder="Enter password" id="password">
  </div>
  <input type="hidden"  id="id" value="${principal.user.id}">
  <button id="btn-update" class="btn btn-primary">수정완료</button>
</form>

<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>