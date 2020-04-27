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
			
			<c:catch>
				<c:if test="${member.id eq 'admin'}">
					<div>
						<a href="./memberJoin" class="btn btn-primary">ADD</a>
						<a href="./memberDelete" class="btn btn-danger">DELETE</a>
					</div>
				</c:if>
			</c:catch>
			
		</div>
		<br> <br> <br> <br>
	</div>
	<script>
		//이벤트 위임 
		$("#result").on("click", "#all", function(){
			$(".chks").prop("checked", $("#all").prop("checked"));
		});
		
		$("#result").on("click", ".chks", function(){
			var res = true;
			$(".chks").each(function(){
				if($(this).prop("checked")==false){
					res = false;	
				}
			});
			$("#all").prop("checked", res);	
		});
	
		$("#result").on("click", "#delete", function(){
			var ids = [];
			$(".chks").each(function(){
				if($(this).prop("checked")){
					ids.push($(this).val());
				}
			});
			$.ajax({
				type: "GET",
				url: "./membersDelete",
				data: {ids: ids},
				traditional : true,	//파라미터로 배열을 넘기는 경우 이걸 추가해줘야 넘어간다.  
				success: function(data){
					$.get("memberLists", function(data){
						$("#result").html(data.trim());
					});
				}
			});		
		});
	

	</script>
	
	
</body>
</html>