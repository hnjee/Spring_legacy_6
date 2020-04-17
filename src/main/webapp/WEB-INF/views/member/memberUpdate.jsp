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
			<h1>MemberUpdate</h1>
			<p>Bootstrap is the most popular HTML, CSS, and JS framework for
				developing responsive, mobile-first projects on the web.</p>
		</div>
	</div>
	
	<div class="container">
	  <h1>Member Information 수정</h1>
	  <form action="./memberUpdate" method="post">
	    <div class="form-group">
	      <label for="id">아이디:</label>
	      <input type="text" class="form-control" id="id" placeholder="Enter id" name="id" value="${member.id}" readonly>
	    </div>
	
	    <div class="form-group">
	      <label for="pw">비밀번호: </label>
	      <input type="password" class="form-control" id="pw" placeholder="Enter pw" name="pw">
	    </div>    
	    
	    <div class="form-group">
	      <label for="name">이름: </label>
	      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name" value="${member.name}">
	    </div>  
	      
	    <div class="form-group">
	      <label for="age">나이: </label>
	      <input type="text" class="form-control" id="age" placeholder="Enter age" name="age" value="${member.age}">
	    </div> 
	    
	     <div class="form-group">
	      <label for="phone">핸드폰번호: </label>
	      <input type="text" class="form-control" id="phone" placeholder="Enter phone number" name="phone" value="${member.phone}">
	    </div> 
	    <div class="form-group">
	      <label for="email">E-mail: </label>
	      <input type="text" class="form-control" id="email" placeholder="Enter email" name="email" value="${member.email}">
	    </div>
	    <button class="btn btn-primary">Update</button>
	  </form> 
	</div>
	
	<script type="text/javascript">
		<c:if test="${method eq 'POST' and result ne 1}">
				alert('비밀번호 일치하지 않아 정보 수정에 실패하였습니다');
   		</c:if>
	</script>
	
	    
	
</body>
</html>