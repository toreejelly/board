<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<script type="text/javascript">

// 변수
let boardSeq = '';
if (${boardSeq} != null && ${boardSeq} != '') {
	boardSeq = JSON.parse('${boardSeq}');
}

// 화면 초기화
//onclick="init()">취소
$(document).ready(function() {
	init(); // 초기화
});

// 초기화
function init() {
	// 게시판 순번에 따른 처리
	if (boardSeq == null || boardSeq == '') {
		// 게시판 순번이 없다면 게시판 작성
		layout('작성');
		
	} else {
		selectBoard(); // 게시판 조회
	}
}

//게시판 조회
function selectBoard() {
	
	layout('조회');
	
	$.ajax({
		type: 'POST'
		,url: '/selectBoardList'
		,cache: false
		,contentType: 'application/json; charset=utf-8'
		,data: JSON.stringify({
			boardSeq: boardSeq
		})
		,success: function(data) {
			//console.log(data);
			if (data.result == '성공') {
				
				let list = data.list; // 게시판 목록
				if (list != null && list.length == 1) { // 상세조회이므로 하나만 조회
					let data = list[0]; // 상세 데이터
					
					// 값
					$('#userNm').val(data.userNm);
					$('#title').val(data.title);
					$('#content').val(data.content);
				}
				
			} else {
				alert('조회에 실패했습니다.');
			}
		}
		,error: function(e) {
			alert('조회에 실패했습니다.');
		}
	});
}

//게시판 등록 & 수정
function save() {
	
	if(confirm('저장하겠습니까?')) {
		
		let url = '';
		// 게시판 순번에 따른 처리
		if (boardSeq == null || boardSeq == '') {
			// 등록
			url = '/insertBoard';
			
		} else {
			// 수정
			url = '/updateBoard';
		}

		$.ajax({
			type: 'POST'
			,url: url
			,cache: false
			,contentType: 'application/json; charset=utf-8'
			,data: JSON.stringify({
				boardSeq: boardSeq
				,userNm: $('#userNm').val()
				,title: $('#title').val()
				,content: $('#content').val()
			})
			,success: function(data) {
				console.log(data);
				if (data.result == '성공') {
					
					alert('저장하였습니다.');
					
					if (data.boardSeq != null && data.boardSeq != '') {
						boardSeq = data.boardSeq;	
					}
					selectBoard(); // 게시판 조회
					
				} else {
					alert('저장에 실패했습니다.');
				}
			}
			,error: function(e) {
				alert('저장에 실패했습니다.');
			}
		});
	}
}

//게시판 삭제
function delete() {
	
	if(confirm('삭제하겠습니까?')) {
		$.ajax({
			type: 'POST'
			,url: '/deleteBoard'
			,cache: false
			,contentType: 'application/json; charset=utf-8'
			,data: JSON.stringify({
				boardSeq: boardSeq
			})
			,success: function(data) {
				if (data.result == '성공') {
					alert('삭제하였습니다.');
					location.href = '/';
					
				} else {
					alert('삭제에 실패했습니다.');
				}
			}
			,error: function(e) {
				alert('삭제에 실패했습니다.');
			}
		});
	}
}

// 상태에 따른 버튼, 폼 설정.
function layout(상태) {	
	
	// 유효성..
	// 상태 값 있어야 함.
	if (상태 == null || 상태 == '') {
		return false;		
	}
	
	// 기본.

	// 1. 폼 비활성화
	document.getElementById('userNm').disabled = true;
	document.getElementById('title').disabled = true;
	document.getElementById('content').disabled = true;
	
	// 2. 버튼 숨기기.
	//$('#listBtn').hide();
	$('#modifyBtn').hide();
	$('#deleteBtn').hide();
	$('#saveBtn').hide();
	$('#cancleBtn').hide();
	
	// 개별
	// 상태에 따른 설정
	if (상태 == '작성') {
		// 값 초기화
		$('#userNm').val('');
		$('#title').val('');
		$('#content').val('');
		
		// 활성화
		document.getElementById('userNm').disabled = false;
		document.getElementById('title').disabled = false;
		document.getElementById('content').disabled = false;
		
		$('#saveBtn').show();
		$('#cancleBtn').show();
		
	} else if (상태 == '수정') {
		// 활성화
		document.getElementById('userNm').disabled = false;
		document.getElementById('title').disabled = false;
		document.getElementById('content').disabled = false;
		
		$('#saveBtn').show();
		$('#cancleBtn').show();
		
	} else if (상태 == '조회') {
		$('#modifyBtn').show();
		$('#deleteBtn').show();
	}
}
</script>
</head>

<body>
	
	<div class="container">
		<br />
		<h2>글</h2>
		<br /> 

		<table class="table table-bordered">
			<tr>
				<td>이름</td>
				<td>
					<input id="userNm" style="width: 100%;">
				</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>
					<input id="title" style="width: 100%;">
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea rows="10" id="content" style="width: 100%;"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: right;">
					<button type="button" class="btn btn-success" onclick="location.href='/'">목록보기</button>
					<button id="modifyBtn" type="button" class="btn btn-warning" onclick="layout('수정')">수정</button>
					<button id="deleteBtn" type="button" class="btn btn-danger" onclick="delete()">삭제</button>
					<button id="saveBtn" type="button" class="btn btn-danger" onclick="save()">저장</button>
					<button id="cancleBtn" type="button" class="btn btn-warning" onclick="init()">취소</button>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>