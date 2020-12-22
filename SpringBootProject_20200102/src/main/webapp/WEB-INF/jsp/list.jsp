<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="java.util.List"%>
<%@ page import="com.project.spring.dto.BoardDto"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
    	/*reset*/
    	*{margin: 0;padding: 0;}
    	li{list-style: none;}
    	a{text-decoration: none;}
    	
    	/*common*/
    	.wrapper{width: 1170px; margin: 0 auto;}
    	.clearfix{content: '';display: block;clear: both;}
    	header, footer{
    		background-color:#080a80;
    		height: 75px; 
    	}
    	/*header*/
    	header{
    		border: 1px solid #253342;
    		position: fixed;
    		width: 100%;
    		z-index: 9999;
    		top: 0;
    		left: 0;
    		text-align: left;
    	}
    	h1{color: white; line-height: 75px;float: left;}
    	.menu{float: right;}
    	.menu li{float: left;}
    	.menu a{line-height: 75px; color: white; padding: 0 15px; display: block;}
    	
    	/*main*/
    	.main{padding: 200px 0;}
    	
    	/*footer*/
    	footer{
    	}
    	
    </style>
    <script>
	//이전 버튼 이벤트
	function fn_prev(page, range, rangeSize) {
		//page
		var page = ((range - 2) * rangeSize) + 1;
		var range = range - 1;
		var url = "/board/";
		url = url + "?page=" + page;
		
		location.href = url;
	}
	
  	//페이지 번호 클릭
	function fn_pagination(page, range, rangeSize, searchType, keyword) {
		var url = "${pageContext.request.contextPath}/board/getBoardList";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		location.href = url;	
	}
  
	//다음 버튼 이벤트
	function fn_next(page, range, rangeSize) {
		var page = parseInt((range * rangeSize)) + 1;
		var range = parseInt(range) + 1;
		var url = "${pageContext.request.contextPath}/board/getBoardList";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		
		location.href = url;
	}
	</script>
</head>
<body>
    <!-- HEADER -->
    <jsp:include page = "common/header.jsp" flush="true"/>
    <!-- HEADER END-->
    
    <div class="main">
		<!-- http://localhost:8080/post 경로  -->
		<span><a href="/post">글쓰기</a></span>
	    <span><a href="/user/signup">회원가입</a></span>
	    
	    <div>
		    <table>
		        <thead>
			        <tr>
			            <th class="one wide">번호</th>
			            <th class="ten wide">글제목</th>
			            <th class="two wide">작성자</th>
			            <th class="three wide">작성일</th>
			        </tr>
		        </thead>
		        <tbody>
		        <!-- CONTENTS 게시판-->
		        <c:forEach items="${boardList}" var="board">
		        	<tr>
		        		<td><c:out value="${board.id}"/></td>
		        		<td ><a href="/post/${board.id}">${board.title}</a></td>
		        		<td><c:out value="${board.writer}"/></td>
		        		<td><c:out value="${board.createdDate}"/></td> 
		        	</tr>
		        </c:forEach>
		        </tbody>
		    </table>
	    </div>
	    
	<!-- pagination{s} -->
	<div id="paginationBox">

		<ul class="pagination">

			<c:if test="${pagination.prev}">
				<li class="page-item"><a class="page-link" href="#" onClick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}')">Previous</a></li>
			</c:if>
			
			<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
				<li class="page-item <c:out value="${pagination.page == idx ? 'active' : ''}"/> ">
					<a class="page-link" href="#" onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}')"> ${idx} </a>
				</li>
			</c:forEach>
			
			<c:if test="${pagination.next}">
				<li class="page-item"><a class="page-link" href="#" onClick="fn_next('${pagination.range}', 
					'${pagination.range}', '${pagination.rangeSize}')" >Next</a></li>
			</c:if>
		</ul>

	</div>
	<!-- pagination{e} -->
	
		<form action="/board/search" method="POST">
		    <div>
		        <input name="keyword" type="text" placeholder="검색어를 입력해주세요">
		    </div>
		
		    <button>검색하기</button>
		</form>
	</div>
    <!-- FOOTER -->
    <jsp:include page = "common/footer.jsp" flush="true"/>
    <!-- FOOTER END-->
</body>
</html>