<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 주석 단축키 : ctrl+shift+/ -->

<!-- c:forEach jstl의 c사용하려면 적어줘야함 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<meta charset="UTF-8">

<title>목록</title>

</head>
<body>

	<div class="container">
	<br/>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>제목</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
					<c:forEach items="${list}" var="list" varStatus="status">
	<!--			jstl의 반복문 items=Collection 객체 / var = 사용할 변수명 / varStatus=status(상태 속성.검색하면 속성 다양함)	  -->				
	<!-- 					    items=BoardController의 return "list"를 의미 -->
						<tr>
							<td>${status.count}</td>  <!-- 1부터의 순서 -->
							<td>${list.memberId}</td>
							<td><a href="/board/${list.boardId}">${list.title}</a></td>
	<!--											  -->
	<!--						a태그 = 글씨눌렀을 때 링크로 이동 href = 링크    -->						
							<td>${list.boardDate}</td>
							<td>${list.hit}</td>
						</tr>
					</c:forEach>
			</tbody>			
		</table>
		<button type="button" class="btn btn-warning" onclick="location.href='/contentWriteForm';">글쓰기</button>
	
	</div>
</body>
</html>