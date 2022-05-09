<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
<link rel="stylesheet" href="/resources/css/sideMenu.css">
<link rel="stylesheet" href="/resources/css/board_util.css">
<link rel="stylesheet" href="/resources/css/board_main.css">
<style>
<style>
.btnCon:target  {
  opacity: 0.5;
}
.btnCon:target .tabCon{
  display: block;
}

ul, ol, li { list-style:none; margin:0; padding:0; }

ul.myMenu {}
ul.myMenu > li { display:inline-block; width:80px; padding:5px 10px; background:#eee; text-align:center; }
ul.myMenu > li ul.submenu { display:none; }
</style>

</head>
<body>
<%@ include file="/WEB-INF/include/include-body.jspf" %>
    <section class="home">
        <div class="text">게시판</div>
<%-- 		<form id="frm" action="/openBoardDetail" method="post">
<table class="table table-striped" style="width:70%; border:1px solid #ccc; margin:120px; text-align:center;">
	<colgroup>
		<col width="10%"/>
		<col width="*"/>
		<col width="15%"/>
		<col width="20%"/>
	</colgroup>
	<thead>
		<tr>
			<th scope="col">글번호</th>
			<th scope="col">제목</th>
			<th scope="col">조회수</th>
			<th scope="col">작성일</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${fn:length(list) > 0}">
						<c:forEach items="${list}" var="row"> 
					<tr> 
						<td>${row.IDX}</td> 
						<td class="title"> 
						<a href = "/openBoardDetail?IDX=${row.IDX}"> ${row.TITLE}</a>
						<input type="hidden" id="IDX" name="IDX" value='${row.IDX}'/>
						</td>
						<td>${row.HIT_CNT}</td>
						<td><fmt:formatDate pattern="yyyy.MM.dd" value="${row.CREA_DTM}"/>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="4">조회된 결과가 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
		
	</tbody>
</table>
</form> --%>
<div id="container" style="margin:0 120px;">
<ul class="myMenu">
    <li class="menu1"><a href="/boardList?tab=1">자유</a></li>
    <li class="menu2">
        <a href="/boardList?tab=2">공략</a>
<!--         <ul class="menu2_s submenu">
            <li>메뉴 2-1</li>
            <li>메뉴 2-2</li>
            <li>메뉴 2-3</li>
        </ul>    -->
    </li>
</ul>
</div>

		<div class="table100 ver1 m-b-110" style="width:70%; margin:0 120px;">
		<div class="table100-head">
			<table>
				<thead>
					<tr class="row100 head">
						<th class="cell100 column1">제목</th>
						<th class="cell100 column2">글번호</th>
						<th class="cell100 column3">조회수</th>
						<th class="cell100 column4">작성일</th>
						<th class="cell100 column5">작성자</th>
					</tr>
				</thead>
			</table>
		</div>

		<div class="table100-body js-pscroll">
			<table>
				<tbody>
					<tr class="row100 body" >
		<c:choose>
		<c:when test="${fn:length(list) > 0}">
					<c:forEach items="${list}" var="row"> 
				<tr> 
					<td class="cell100 column1" style="text-align:center"> 
					<a href = "/openBoardDetail?IDX=${row.IDX}"> ${row.TITLE}</a>
					<input type="hidden" id="IDX" name="IDX" value='${row.IDX}'/>
					</td>
					<td class="cell100 column2" style="text-align:center"> 
					${row.IDX}						
					</td>
					<td class="cell100 column3" style="text-align:center">${row.HIT_CNT}</td>
					<td class="cell100 colum4" style="text-align:center"><fmt:formatDate pattern="yyyy.MM.dd" value="${row.CREA_DTM}"/>
					<td class="cell100 colum5" style="text-align:center">${row.CREA_ID}</td>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td class="cell100 column1">조회된 결과가 없습니다.</td>
			</tr>
		</c:otherwise>
		</c:choose>
							</tbody>
						</table>
					</div>
				</div>


<a style="margin:120px;" href="/openBoardWrite" id="insertBoard">작성</a>
</section>
</body>
<script src="/js/common.js"></script>



</html>