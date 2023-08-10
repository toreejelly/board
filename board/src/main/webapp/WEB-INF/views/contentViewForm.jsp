<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<meta charset="UTF-8">

<title>글</title>

<script type="text/javascript">
   
//삭제2   
	//삭제
	function contentDetele() {
		//# : id / . : class
		//let, var, const
		//let 변수명
		let boardId = $("#boardId").val();          
		
		//	*
		var data = {
				  boardId 	: boardId
		};
		
		//개발자 모드에서 확인을 위해 필요
		//						*
		// console.log("data", data);
		
		$.ajax({
			type : "DELETE"
			//삭제3
			,url : "/board/"+boardId
			,cache : false
			,contentType : 'application/json; charset=utf-8'
			//						*
			,data : JSON.stringify(data)
			//entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			//result 값에 "SUCCESS"가 들어온다
			//삭제10
			,success : function(result) {
				if (result == "SUCCESS") {
					alert("삭제되었습니다.");
					location.href = "/list";
				}
			}
			//e에 e.getMessage()가 들어온다
			,error : function(e) {
				alert("삭제 실패했습니다.");
				console.log(e);
			}
		})//ajax end
		
	}//contentDetele() end
	
</script>

</head>
<body>

<!-- 조회8 -->
	<div class="container">
	<br/>
		<h2>글</h2>
		<br/>
		<input type="hidden" id="boardId" value="${content.boardId}">
		<table class="table table-bordered">
			<tr>
				<td>번호</td>
				<td>${content.boardId}</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${content.hit}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${content.memberId}</td>
			</tr>
			<tr>
				<td>제목</td>
					<!-- input type 없을 떄는 기본 text -->				
				<td><input id="title" value="${content.title}" disabled style="width:100%;"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" id="text" disabled style="width:100%;">${content.text}</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" class="btn btn-success" onclick="location.href='/list'">목록보기</button>&nbsp;&nbsp;
					<!-- 수정1 -->
					<!-- content어디있음?? BoardController @GetMapping("/board/{boardId}")에서 넘어왔음 --> 
					<!--													페이지로 가는거임?컨트롤러로 가는거임?  -->
					<!-- 무조건 컨트롤러에 갔다가 페이지를 열 수 있다. 컨트롤러에서 페이지를 열어준다. 																	 -->
					<button type="button" class="btn btn-warning" onclick="location.href='/contentModifyForm/${content.boardId}'">수정</button>&nbsp;&nbsp;
					<!-- 삭제1 --> 
					<button type="button" class="btn btn-danger" onclick="contentDetele()">삭제</button>
				</td>
			</tr>
		</table>
	</div>
   
</body>
</html>