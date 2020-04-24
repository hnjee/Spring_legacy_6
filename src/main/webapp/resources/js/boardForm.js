		var count =1;
		$("#file").on("click", ".remove", function() {
			$(this).parent().remove();
			count--;
		});

		$("#add").click(function() {
			if(count<6){
				$("#file").append('<div class="form-group"> <label for="file"> File :</label> <input type="file" class="form-control files" name="files"> <i class="glyphicon glyphicon-remove remove"></i> </div> ');
				count++;
			}else {
				alert("파일은 최대 5개까지 업로드 가능합니다");
			}
		});
		
	 	$("#btn").click(function(){
	 		//title, contents 데이터 유무 검증 
	 		var ch1 = !($("#title").val()=="")
	 		var ch2 = !($("#contents").summernote('isEmpty'));
	 		
	 		var ch3 = true;
			$(".files").each(function() {
				if($(this).val()==""){
					ch3 = false;
				}
			});
			
	 		if(ch1 && ch2 && ch3){
	 			//form 전송 (submit event 강제 발생)
	 			$("#frm").submit();
	 		} else{
	 			alert("필수요소는 다 입력하세요");
	 		}
		});
	 	
 		//$("선택자").action();
		$("#contents").summernote({
			height: 400
		});