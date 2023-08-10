<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<meta charset="UTF-8">

<title>글쓰기</title>

<script>
   
//쓰기5   
	//작성	
	function contentWrite() {
		//# : id / . : class
		//let, var, const
		//let 변수명
		//. val()은 양식(form)의 값을 가져오거나 값을 설정하는 메서드
		let memberId = $("#memberId").val();
		let title = $("#title").val();
		let text = $("#text").val();					
		
		//  *
		let data = {
		//내가정한이름 :
			memberId    : memberId
			, title		: title
			, text		: text
		};

		//개발자 모드에서 확인을 위해 필요
		//						*
		console.log("data : ", data);
		
//쓰기6		
		$.ajax({
			type : "POST"
			//쓰기7
			,url : "/contentWrite"
			,cache : false
			//						*
			,data : JSON.stringify(data)
			,contentType : 'application/json; charset=utf-8'
			//entity = new ResponseEntity<String>(strBoardId, HttpStatus.OK);
			//result에 strBoardId이 들어온다
			//쓰기20
			,success : function(result){
				//console.log("result", result);
				alert("작성되었습니다.");
				location.href = "/board/"+result;
			}
			,error : function(e){
				console.log(e);
				alert("작성 실패하였습니다.");
			}
		});//ajax end
		
	}//contentWrite() end
   
</script>

</head>

<!-- 쓰기3 -->
<body>

	<div class="container">
	<br/>
		<h2>글</h2>
		<br/>
		<table class="table table-bordered">
			<tr>
				<td>이름</td>
				<td>
					<input id="memberId" style="width:100%;">
				</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>
					<input id="title" style="width:100%;">
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea rows="10" id="text" style="width:100%;"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" class="btn btn-success" onclick="location.href='/list'">목록보기</button> &nbsp;&nbsp; 
					<!-- 쓰기4 -->
					<button type="button" class="btn btn-warning" onclick="contentWrite()">작성</button><!--11 --><!-- &nbsp : space -->
				</td>
			</tr>
		</table>
	</div>
   
</body>
</html>