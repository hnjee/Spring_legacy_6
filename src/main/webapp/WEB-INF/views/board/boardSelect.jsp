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
	<div class="row">
			<h2>Title : ${vo.title}</h2>
			<h2>Writer :${vo.writer} </h2>
			<h2>Contents : ${vo.contents}</h2>
			<h2>Date : ${vo.regDate}</h2>
			<h2>Hit : ${vo.hit}</h2>	
	</div>
	<div>
		<a href="./${board}Update?num=${vo.num}" class="btn btn-primary"> Update</a>
		<a href="./${board}Delete?num=${vo.num}" class="btn btn-danger"> Delete</a>
		<c:if test="${board ne 'notice'}">
			<a href="./${board}Reply?num=${vo.num}" class="btn btn-info"> Reply </a>
		</c:if>
	
	</div>
	<br> <br> <br> <br>
	</div>
</body>
</html>