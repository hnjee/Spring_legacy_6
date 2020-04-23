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
	  	<h1>회원가입 페이지</h1>
	  	<p>회원가입을 할 수 있는 페이지입니다 </p>
	  </div>     
	</div>
	
	<div class="container">
	  <h1>Member Join</h1>
	  <form action="./memberJoin" method="post">
	    <div class="form-group">
	      <label for="id">아이디:</label>
	      <input type="text" class="form-control" id="id" placeholder="Enter id" name="id" value="${id}">
	    </div>
	
	    <div class="form-group">
	      <label for="pw">비밀번호: </label>
	      <input type="password" class="form-control" id="pw" placeholder="Enter pw" name="pw">
	    </div>    
	    
	    <div class="form-group">
	      <label for="name">이름: </label>
	      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
	    </div>  
	      
	    <div class="form-group">
	      <label for="age">나이: </label>
	      <input type="text" class="form-control" id="age" placeholder="Enter age" name="age">
	    </div> 
	    
	     <div class="form-group">
	      <label for="phone">핸드폰번호: </label>
	      <input type="text" class="form-control" id="phone" placeholder="Enter phone number" name="phone">
	    </div> 
	    <div class="form-group">
	      <label for="email">E-mail: </label>
	      <input type="text" class="form-control" id="email" placeholder="Enter email" name="email">
	    </div> 
	   
	    <button type="submit" class="btn btn-default">Submit</button>
	  </form>
	</div>
</body>
</html>