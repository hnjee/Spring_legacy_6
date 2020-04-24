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
			<div class="form-group">
  				<label for="usr">Writer:</label>
  				<input type="text" class="form-control" id="writer">
			</div>
			
			<div class="form-group">
  				<label for="comment">Contents:</label>
  				<textarea class="form-control" rows="5" id="contents"></textarea>
			</div>
			
			<button id="btn" class="btn btn-danger">WRITE</button>
		</div>
		
		<div class="row"> 
			<table class="table table-striped" id="result">
				<tr>
					<td>Num</td>
					<td>Contents</td>
					<td>Writer</td>
					<td>Date</td>
				</tr>
				
			</table>
		</div>
		
		<div>
			<button id="more">더보기</button>
		</div>
	</div>
	
	<script type="text/javascript">
		//전역변수 
		var count = 1;
	
		//함수 만들어놓기 
		function getList(curPage){
			$.get("getList?curPage="+curPage, function(result){
				$("#result").append(result);
			});
		} 

		getList(count);
		
		$("#btn").click(function(){
			var writer = $("#writer").val();
			var contents = $("#contents").val();
			//console.log(w);
			//console.log(c);
			
			$("#writer").val('');
			$("#contents").val('');
			
			$.post("./memoWrite", {writer: writer, contents: contents}, function(result){
				result= result.trim();
				if(result>0){
					location.reload();
				} else{
					alert("Write Fail");
				}
			});
		});
		
		$("#more").click(function(){
			getList(++count);
		});
		
	</script>
	
</body>
</html>