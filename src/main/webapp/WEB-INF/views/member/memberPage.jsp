<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

	<div class="container">
		<div class="jumbotron">
			<h1>멤버 정보</h1>
		</div>     
		 <form action="./memberPage" method="post">
	  
		    <div class="form-group">
		      <label for="Id">ID:</label>
		      <input type="text" class="form-control" id="id" placeholder="Enter ID" name="id" value="${member.id}">
		    </div>
		       
		    <div class="form-group">
		      <label for="Name">Name:</label>
		      <input type="text" class="form-control" id="name" placeholder="Enter Name" name="uname" value="${member.name}">
		    </div>
		    
		     <div class="form-group">
		      <label for="Age">Age:</label>
		      <input type="text" class="form-control" id="age" placeholder="Enter Age" name="age" value="${member.age}">
		    </div>
		    
		     <div class="form-group">
		      <label for="Email">email:</label>
		      <input type="text" class="form-control" id="email" placeholder="Enter Email" name="email" value="${member.email}">
		    </div>
		    
		    <div class="form-group">
		      <label for="Phone">phone:</label>
		      <input type="text" class="form-control" id="phone" placeholder="Enter Phone" name="phone" value="${member.phone}" >
		    </div>
		    
		    <div>
		    	<a href="./fileDelete">FileDelete</a>
		    </div>
	  		<img id="cat" alt="cat" src="../resources/memberUpload/${member.memberFileVO.fileName}"/>
	  </form>
	  
	 
	   <button class="btn btn-primary" id="up" > Update </button>
	   <button class="btn btn-danger" id="del" > Delete </button>
	</div>

<script type="text/javascript">

	
	$("#up").on("click", function() {
		location.href="./memberUpdate";
	});
	
	$("#del").click(function() {
		var result = confirm("정말 탈퇴하시겠습니까?");
		if(result){
			location.href="./memberDelete";	
		}
	});
</script>
</body>
</html>



