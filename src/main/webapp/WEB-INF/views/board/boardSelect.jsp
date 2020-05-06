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
		<div class="panel panel-info">
			<div class="panel-heading">TITLE</div>
			<div class="panel-body">${vo.title}</div>
			<div class="panel-heading">Writer</div>
			<div class="panel-body">${vo.writer}</div>
			<div class="panel-heading">Contents</div>
			<div class="panel-body">${vo.contents}</div>
		</div>
		<div class="panel panel-warning">
			<div class="panel-heading">${vo.regDate}</div>
		</div>

		<div>
			<c:catch>
			<c:forEach items="${vo.boardFileVOs}" var="file">
				<div>
					<a href="../boardFile/fileDown?fileNum=${file.fileNum}&board=${file.board}">${file.oriName}</a> 
				</div>
			</c:forEach>
			</c:catch>
		</div>
		
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
</body>
</html>