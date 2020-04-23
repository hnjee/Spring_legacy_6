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
		<div class="jumbotron">
			<h1>Bootstrap Tutorial</h1>
			<p>Bootstrap is the most popular HTML, CSS, and JS framework for
				developing responsive, mobile-first projects on the web.</p>
		</div>
	</div>
	
	<div class="container">
	  <h1>Member Information</h1>
	  <form action="" method="post">
	    <div class="form-group">
	      <label for="id">아이디:</label>
	      <input type="text" class="form-control" id="id" name="id" value="${member.id}" >
	    </div>
	    <div class="form-group">
	      <label for="pw">비밀번호:</label>
	      <input type="password" class="form-control" id="pw" placeholder="Enter Password" name="pw">
	    </div>
	    
	    <div class="form-group">
	      <label for="name">이름: </label>
	      <input type="text" class="form-control" id="name" name="name" value="${member.name}">
	    </div>  
	      
	    <div class="form-group">
	      <label for="age">나이: </label>
	      <input type="text" class="form-control" id="age"  name="age" value="${member.age}">
	    </div> 
	    
	     <div class="form-group">
	      <label for="phone">핸드폰번호: </label>
	      <input type="text" class="form-control" id="phone" name="phone" value="${member.phone}">
	    </div> 
	    <div class="form-group">
	      <label for="email">E-mail: </label>
	      <input type="text" class="form-control" id="email" name="email" value="${member.email}">
	    </div>
	  </form>
	  <button class="btn btn-primary" id="update">Update</button>
	  <button class="btn btn-danger" id="delete">Delete</button> 
	</div>
	<script type="text/javascript">
		$("#update").click(function(){
			location.href = "./memberUpdate";
		});
		$("#delete").click(function(){
			var res = confirm("정말 탈퇴하시겠습니까? 비밀번호를 정확히 입력하여야 탈퇴가 가능합니다.");
			if(res) {
				location.href = "./memberDelete";
			} 
		});
	</script>
	
</body>
</html>