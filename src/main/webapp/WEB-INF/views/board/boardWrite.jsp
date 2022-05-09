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
        <div class="text">Dashboard Sidebar</div>

<form id="frm" method="post" action="/insertBoard">
		<table class="board_view">
			<colgroup>
				<col width="15%">
				<col width="*"/>
			</colgroup>
			<caption>게시글 작성</caption>
			<tbody>
				<tr>
					<th scope="row">제목</th>
					<td><input type="text" id="TITLE" name="TITLE" class="wdp_90"></input></td>
				</tr>
				<tr>
					<td colspan="2" class="view_text">
						<textarea class="summernote" rows="20" cols="100" title="내용" id="editordata" name="editordata"></textarea>
					</td>
				</tr>
			</tbody>
		</table>
		<a style="margin:120px" href="#" class="btn" id="write" >작성하기</a><br>
		<a style="margin:120px" href="/boardList" class="btn" id="list" >목록으로</a>
	</form>

    </section>

</body>
<script src="/js/common.js"></script>
<script>
$('#write').click(function(){
	$('#frm').submit();
});
	
</script>
</html>