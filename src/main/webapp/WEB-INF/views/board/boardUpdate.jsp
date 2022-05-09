<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
<style type="text/css">
.board_view{
	text-align: center;
	display: table; 
	margin-left: 120px;
	--toggle-color: #DDD;
	color: var(--text-color);
    transition: var(--tran-03);
}
a { 
	text-decoration:none 
}
a:visited {
  color: var(--text-color);
  transition: var(--tran-03);
  text-decoration: none;
}
a:hover {
  color: var(--text-color);
  transition: var(--tran-03);
  text-decoration: underline;
}
a:active {
  color: var(--text-color);
  transition: var(--tran-03);
  text-decoration: none;
}
</style>
</head>
<body>
<%@ include file="/WEB-INF/include/include-body.jspf" %>
 <section class="home">
    
<form id="updateBoard" method="post" action="/updateBoard" accept-charset="utf-8"> 
	<table class="board_view"> 
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
		<td> ${map.IDX } 
		<input type="hidden" id="IDX" name="IDX" value="${map.IDX}"> </td> 
		<th scope="row">조회수</th> 
		<td>${map.HIT_CNT}</td> 
		</tr> 
		<tr> 
			<th scope="row">작성자</th> 
				<td>${map.CREA_ID}</td> 
			<th scope="row">작성시간</th> 
				<td><fmt:formatDate pattern="yyyy.MM.dd" value="${row.CREA_DTM}"/></td> 
			</tr> 
			<tr> <th scope="row">제목</th> 
			<td colspan="3"> 
			<input type="text" id="TITLE" name="TITLE" class="wdp_90" value="${map.TITLE }"/> </td> </tr> 
			<tr> <td colspan="4" class="view_text"> 
			<textarea rows="20" cols="100" title="내용" id="CONTENTS" name="CONTENTS">${map.CONTENTS}</textarea> 
			</td> 
			</tr> 
			</tbody> 
			</table> 
			 
			<a style="margin-left: 120px;" href="/boardList" class="btn" id="list">목록으로</a> 
			<!-- <input type="submit" value="수정하기"/> -->
			<a href="#" class="btn" id="update">수정하기</a> 
			<a href="/deleteBoard" class="btn" id="delete">삭제하기</a>
   			</form>

    </section>

</body>
<script>
	$('#update').click(function(){
		$('#updateBoard').submit();
	});
</script>
<script src="/js/common.js"></script>
</html>