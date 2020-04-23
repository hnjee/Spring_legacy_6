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
		<c:catch>
			<c:choose>
				<c:when test="${board ne 'notice'}">
					<c:if test="${not empty member}"> 
						<a href="./${board}Reply?num=${vo.num}" class="btn btn-info"> Reply </a>
						<a href="./${board}Update?num=${vo.num}" class="btn btn-primary"> Update</a>
						<a href="./${board}Delete?num=${vo.num}" class="btn btn-danger"> Delete</a>
					</c:if>
				</c:when>
				<c:otherwise>
				 	<c:if test="${member.id eq 'admin'}">
				 		<a href="./${board}Update?num=${vo.num}" class="btn btn-primary"> Update</a>
						<a href="./${board}Delete?num=${vo.num}" class="btn btn-danger"> Delete</a>
				 	</c:if>
				</c:otherwise>
			</c:choose>
		</c:catch>
		
		
	</div>
	<br> <br> <br> <br>
	</div>
</body>
</html>