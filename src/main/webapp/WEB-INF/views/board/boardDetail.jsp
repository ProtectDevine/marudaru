<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
</head>
<body>
<%@ include file="/WEB-INF/include/include-body.jspf" %>
 <section class="home">
        <div class="text">Dashboard Sidebar</div>
		<table style="margin:120px" class="board_view">
		<colgroup>
			<col width="15%"/>
			<col width="35%"/>
			<col width="15%"/>
			<col width="35%"/>
		</colgroup>
		<caption>게시글 상세</caption>
		<tbody>
			<tr>
				<th scope="row">글 번호</th>
				<td>${map.TITLE}</td>
				<th scope="row">조회수</th>
				<td>${map.HIT_CNT}</td>
			</tr>
			<tr>
				<th scope="row">작성자</th>
				<td>${map.CREA_ID}</td>
				<th scope="row">작성시간</th>
				<td>${map.CREA_DTM}</td>
			</tr>
			<tr>
				<th scope="row">제목</th>
				<td colspan="3">${map.TITLE}</td>
			</tr>
			<tr>
				<td colspan="4">${map.CONTENTS}</td>
			</tr>
		</tbody>
	</table>
	
	<a style="margin:120px" href="/boardList" class="btn" id="list">목록으로</a>
	<a href="/openBoardUpdate?IDX=${map.IDX}" class="btn" id="update">수정하기</a>
   	<a href="/deleteBoard?IDX=${map.IDX}" class="btn" id="delete">삭제하기</a>

	</section>

</body>
<script src="/js/common.js"></script>
</html>