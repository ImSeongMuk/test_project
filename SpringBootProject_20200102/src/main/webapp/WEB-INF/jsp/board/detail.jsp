<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>게시판 상세페이지</title>
    <style>
    	html, body, p{
    		 margin: 0;
    		 padding: 0;
    	}
    	header{
    		text-align: left;
    		background-color:silver;
    		height: 50px; 
    	}
    	footer{
    		text-align: center;
    		background-color:silver;
    		height: 50px; 
    	}
    </style>
</head>
<body>
	<!-- HEADER -->
    <jsp:include page = "common/header.jsp" flush="true"/>
    <!-- HEADER END-->
    <h2>제목 : ${boardDto.title}</h2>
    <p>작성일 : [${boardDto.createdDate}]</p>
    <p>내용 : ${boardDto.content}</p>
    <!-- 수정/삭제 -->
    <a href="/post">글쓰기</a>
	<div>
	    <a href="/post/edit/${boardDto.id}">
	        <button>수정</button>
	    </a>
	    <form action="/post/${boardDto.id}" method="post">
	        <input type="submit" value="삭제">
	    </form>
	</div>
	
    
	
    <!-- FOOTER -->
    <jsp:include page = "common/footer.jsp" flush="true"/>
    <!-- FOOTER END-->
</body>
</html>