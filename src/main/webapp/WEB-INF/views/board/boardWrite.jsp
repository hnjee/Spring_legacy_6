<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<c:import url = "../template/boot.jsp"></c:import>
	<c:import url = "../template/summer.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="container">
	  <h1>글쓰기</h1>
	  <form action="./${board}Write" method="post" id="frm">
	 
	   <div class="form-group">
	      <label for="title">제목</label> <br/>
	      <input type="text" class="form-control" id="title" placeholder="Enter Title" name="title">
	    </div>    
	    
	    <div class="form-group">
	      <label for="writer"> 작성자 </label> <br/>
	      <input type="text" class="form-control" id="writer" placeholder="Enter Writer" name="writer">
	    </div> 
	    
	    <div class="form-group">
	      <label for="contents">내용 </label> <br/>
	      <input type="text" class="form-control" id="contents" placeholder="Enter Contents" name="contents1">
	    </div>  
	  <input type="hidden" id="con" name="contents">
	    <button type="button" class="btn btn-default" id="btn">Submit</button>
	  </form>
	</div>
	
	<script type="text/javascript">
 		//$("선택자").action();
		$("#contents").summernote({
			height: 400
		});
		
		$("#btn").click(function(){
			$("#con").val($("#contents").summernote('code'));
			$("#frm").submit();
		});
	</script>
</body>
</html>