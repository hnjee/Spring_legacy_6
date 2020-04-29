		
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
		/////////////////////////////////////////////////
		
		$("#contents").summernote({
			height:300,
			callbacks:{
				onImageUpload:function(files, editor){
					var formData = new FormData(); 		//<form> </form>
					formData.append('files', files[0]);	//<input type="file" name="">
					
					$.ajax({
						type:"POST",
						url: "../boardFile/fileInsert",
						data: formData, 
						enctype: "multipart/form-data",
						cache: false,
						contentType: false,
						processData: false,
						success: function(imageName){
							imageName=imageName.trim();
							$("#contents").summernote('editor.insertImage', imageName);
						}
					});
				}, //onImageUpload
				onMediaDelete:function(files){
					var fileName = $(files[0]).attr("src");
					fileName = fileName.substring(fileName.lastIndexOf("/")+1);
					console.log(fileName);
					
					$.ajax({
						type:"POST", 
						url: "../boardFile/summerDelete",
						data: {
							fileName: fileName
						},
						success: function(){
							console.log(data);
						}
					})
				} //onMediaDelete
			}//callBack
		});
		/////////////////////////////////////////////////
		
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
			
	 		if(ch1 && ch2 && ch3) {
	 			//form 전송 (submit event 강제 발생)
	 			$("#frm").submit();
	 		} else{
	 			alert("필수요소는 다 입력하세요");
	 		}
		});
	 	/////////////////////////////////////////////////
 		
		