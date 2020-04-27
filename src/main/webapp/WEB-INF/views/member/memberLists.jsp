<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

	<div id="result">
		<!-- 멤버리스트 -->
		<table class="table table-hover">
			<tr>
				<td>ID</td>
				<td>NAME</td>
				<td>EMAIL</td>
				<td>
					<input type="checkbox" id="all">
					<button class="btn btn-danger" id="delete">DELETE</button>
				</td>
			</tr>
			<c:forEach items="${list}" var="vo">
				<tr>
					<td>${vo.id}</td>
					<td>${vo.name}</td>
					<td>${vo.email}</td>
					<td>
						<input type="checkbox" name="del" class="chks" value="${vo.id}"> 
					</td>
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
	</div>