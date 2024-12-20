<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>

<!-- 스크립트 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<script type="text/javascript">

//  화면 시작
$(document).ready(function() {
	selectBoardList(); // 게시판 조회
});

// 게시판 조회
function selectBoardList() {
	let param = {};
	$.ajax({
		type: 'POST'
		,url: '/selectBoardList'
		,cache: false
		,contentType: 'application/json; charset=utf-8'
		,data: JSON.stringify(param)
		,success: function(data) {
			console.log(data);
			if (data.result == '성공') {
				let html = ''; // 게시판 html
				let list = data.list; // 게시판 목록
				if (list != null && list.length > 0) {
					for (let row of list) {
						html += '<tr onclick="board(' + row.boardSeq + ');">';
						
						if (row.userNm != null && row.userNm != '') {
							html += '<td>' + row.userNm + '</td>';
						} else {
							html += '<td></td>';	
						}
						
						if (row.title != null && row.title != '') {
							html += '<td>' + row.title + '</td>';
						} else {
							html += '<td></td>';	
						}
						
						if (row.regDt != null && row.regDt != '') {
							html += '<td>' + row.regDt + '</td>';
						} else {
							html += '<td></td>';	
						}
						
						html += '</tr>';
					}
				}
				
				$('#board').append(html); // 게시판 목록 추가
				
			} else {
				alert('조회에 실패했습니다.');
			}
		}
		,error: function(e) {
			alert('조회에 실패했습니다.');
		}
	});
}

// 게시판 상세조회
function board(boardSeq) {
	
	console.log(boardSeq);
	
	// 폼 형태로 post 로 이동.
	let form = document.createElement('form');
    form.method = 'POST';
    form.action = '/board';
	
    // 숨김의로 넘길 파람 설정
    let input = document.createElement('input');
    input.type = 'hidden';
    input.name = 'boardSeq';
    input.value = boardSeq;
    form.appendChild(input);
    document.body.appendChild(form);
    
    form.submit();  // 폼 제출
}

</script>
<body>

<div class="container">
	<br/>
		<h2>게시판</h2>
		<br/>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>이름</th>
					<th>제목</th>
					<th>날짜</th>
				</tr>
			</thead>
			<tbody id="board">
			</tbody>	
		</table>	
		<button type="button" class="btn btn-warning" onclick="board()">글쓰기</button>
	</div>
</body>

</html>