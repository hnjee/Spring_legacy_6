<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<c:import url = "../template/boot.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="container">
	  <h1>글 수정하기</h1>
	  <form action="./${board}Update" method="post">
	 
	   <input type="hidden" class="form-control" id="num" name="num" value="${vo.num}">
	   <div class="form-group">
	      <label for="title">제목</label> <br/>
	      <input type="text" class="form-control" id="title" placeholder="Enter Title" name="title">
	    </div>    
	    
	    <div class="form-group">
	      <label for="writer"> 작성자 </label> <br/>
	      <input type="text" class="form-control" id="writer" name="writer" value="${vo.writer}" readonly> 
	    </div> 
	    
	    <div class="form-group">
	      <label for="contents">내용 </label> <br/>
	      <input type="text" class="form-control" id="contents" placeholder="Enter Contents" name="contents">
	    </div>  
	  
	    <button type="submit" class="btn btn-default">Submit</button>
	  </form>
	</div>
</body>
</html>