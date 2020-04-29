<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
<!DOCTYPE html>
<html>
<head>
	<title>Insert title here</title>
	<meta charset="UTF-8">
	<c:import url = "./template/boot.jsp"></c:import>
</head>
<body>
	<c:import url="./template/header.jsp"></c:import>
	
<div class="container">
  <h2>Carousel Example</h2>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
	      <div class="item active">
	        <img src="${pageContext.request.contextPath}/resources/images/la.jpg" alt="Los Angeles" style="width:100%;">
	        <div class="carousel-caption">
	          <h3>Los Angeles</h3>
	          <p>LA is always so much fun!</p>
	        </div>
	      </div>
	
	      <div class="item">
	        <img src="${pageContext.request.contextPath}/resources/images/chicago.jpg" alt="Chicago" style="width:100%;">
	        <div class="carousel-caption">
	          <h3>Chicago</h3>
	          <p>Thank you, Chicago!</p>
	        </div>
	      </div>
	    
	      <div class="item">
	        <img src="${pageContext.request.contextPath}/resources/images/ny.jpg" alt="New York" style="width:100%;">
	        <div class="carousel-caption">
	          <h3>New York</h3>
	          <p>We love the Big Apple!</p>
	        </div>
	      </div>
	    </div>
	    <!-- Left and right controls -->
	    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
	      <span class="glyphicon glyphicon-chevron-left"></span>
	      <span class="sr-only">Previous</span>
	    </a>
	    <a class="right carousel-control" href="#myCarousel" data-slide="next">
	      <span class="glyphicon glyphicon-chevron-right"></span>
	      <span class="sr-only">Next</span>
	    </a>
	  </div>
	</div>
	<button id="btn">BUTTON</button>
	<button id="btn2">BUTTON2</button>
	
	<script type="text/javascript">
		$("#btn2").click(function() {
			$.get("https://api.manana.kr/exchange/rate.json?base=KRW&code=KRW,USD,JPY", function(data){
				console.log(data[1].rate);
			});	
			
		});
		
		$("#btn").click(function() {
			$.get("./json/json1", function(data) {
				//0. data가 String인지 Json Object인지 판별	
				// console.log(data);  //"name":"hj" -> String / object -> json Object  
				
				//1. 만약 String이면 Json Object 변환 
		
				console.log(data); 
				console.log(data.num);
				console.log(data.title);
			});
		});
	</script>
</body>

</html>