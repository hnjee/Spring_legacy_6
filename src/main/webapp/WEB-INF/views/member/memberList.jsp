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
			<h1>Member List</h1>
			<!-- 검색 -->
			<form class="col-xs-6" action="./memberList">
			    <div class="input-group">
				  <select class="form-control" id="sel1" name="kind">
				    <option value="id">id</option>
				    <option value="name">name</option>
				    <option value="email">email</option>
				  </select>
				  
			      <input type="text" class="form-control" placeholder="Search" name="search">
			      
			      <div class="input-group-btn">
			        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
			      </div>
			    </div>
			</form>
			 
			<!-- 멤버리스트 -->
			<table class="table table-hover">
				<tr>
					<td>ID</td>
					<td>NAME</td>
					<td>EMAIL</td>
				</tr>
				<c:forEach items="${list}" var="vo">
					<tr>
						<td>${vo.id}</td>
						<td>${vo.name}</td>
						<td>${vo.email}</td>
					</tr>
				</c:forEach>
			</table>
			
			<div>
				<ul class="pagination">
					<c:if test="${pager.curBlock gt 1}">
						<li><a href="./memberList?curPage=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}"> < </a></li>
					</c:if>
					
					<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
						<li><a href="./memberList?curPage=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
					</c:forEach>
					
					<c:if test="${pager.curBlock lt pager.totalBlock}">
				 		<li><a href="./memberList?curPage=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}"> > </a></li>
					</c:if>
				</ul>
			</div>
			<div>
				<a href="./memberJoin" class="btn btn-primary">ADD</a>
				<a href="./memberDelete" class="btn btn-danger">DELETE</a>
			</div>
		</div>
		<br> <br> <br> <br>
	</div>
</body>
</html>