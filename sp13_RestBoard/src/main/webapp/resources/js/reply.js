
$(function(){

	// 댓글버튼이 눌렸을 때
	$('#replyConfirm').click(function(){
	
		//serialize() jquery api 메소드를 이용해서 form 의 모든 element의 name과 value 값을 넘길수 있음!!         
        var params = $('#replyFrm').serialize();
	
		$.ajax({
             	type :'post',
             	// [확인시] data : { replyText : $('#reply').val()},  
             	data : params,
             	url : '../replies/new',
             	success : function(result){
             		alert(result);
             		// 화면초기화
             		$('#reply').val('');
             		// 입력 후 목록보기 
             		replyList();
             	},
            	error : function(err){
            		alert('error');
            		console.log(err);
            	}
       }); // end of ajax      	
	}); // end of click
	
	
	// 댓글목록 출력하기
	replyList();
	function replyList(){
				$.ajax({
             	type :'get',
             	url : '../replies',
             	dataType : 'json',
             	success : function(result){
             		//alert(result);
             		//console.log(result);
             		// 화면에 출력
             		var replyList = $('#replyList');
             		replyList.empty();
             		for(row of result){
             			//console.log(row);
             			var tr = $('<tr/>');
             			var rno =  $('<td/>').html(row['rno']);
             			tr.append(rno);
             			var replyer =  $('<td/>').html(row['replyer']);
             			tr.append(replyer);
             			var reply =  $('<td/>').html(row['reply']);
             			tr.append(reply);
          
		             			// 4. 수정과 삭제 버튼 추가
		             			//		(1) 동적 버튼 만들기
		             			tr.append('<td><button class="modify">수정</button></td>');
		             			tr.append('<td><button class="delete">삭제</button></td>');
		          
               			replyList.append(tr);            			
          
             		}
             	},
            	error : function(err){
            		alert('error');
            		console.log(err);
            	}
       }); // end of ajax 
	}
	
	// 수정과 삭제 버튼 클릭시
	$('#replyList').on('click','button', function(){
		//alert( $(this).text() )
		//alert( $(this).parents('tr').children().eq(0).text() );
		
		var btn = $(this);
		var rno = $(this).parents('tr').children().eq(0).text();
		
		if( btn.text() == '수정') {
			
			replyModify();
		}else if( btn.text() == '삭제'){
			$.ajax({
             	type :'delete',
             	url : '../replies/'+ rno,
             	success : function(result){
             		//alert(result); 
             		replyList();	// 입력 후 목록보기 
             	},
            	error : function(err){
            		alert('error');
            		console.log(err);
            	}
       		}); // end of ajax        
		}
		
		// '수정하기' 버튼일 경우
		else if( btn.text() == '수정하기'){		
			
			//alert( btn.parents('tr').find('input').eq(0).val());
			//alert( btn.parents('tr').find('input').eq(1).val());
			
			var params = { rno : rno ,
						replyer :  btn.parents('tr').find('input').eq(0).val(),
						reply : btn.parents('tr').find('input').eq(1).val()
						 }
			//alert(JSON.stringify(params));
			
				
			$.ajax({
             	type :'put',
             	url : '../replies/'+ rno,
             	data : JSON.stringify(params),
             	contentType : 'application/json; charset=utf-8',
             	success : function(result){             		 
             		replyList();	// 입력 후 목록보기 
             	},
            	error : function(err){
            		alert('error');
            		console.log(err);
            	}
       		}); // end of ajax   
		}
		
			
		// 첫번째 수정버튼이 클릭하면 화면에서 수정모드로 변경
		function replyModify(){
			//alert('>>'+btn.text());		// 여기서 $(this)가 버튼이 아니네
					
			// 댓글작성자부분
			var replyertd = btn.parents('tr').children().eq(1);
			var replyertdText = replyertd.text();
			replyertd.text('');
			replyertd.append('<input type="text" name="mod_replyer" value="'+ replyertdText +'">');
			// 댓글부분						
			var replytd = btn.parents('tr').children().eq(2);
			var replytdText = replytd.text();
			replytd.text('');
			replytd.append('<input type="text" name="mod_reply" value="'+ replytdText +'">');
			
			btn.text('수정하기');
		}
		
	}); // end of click


});