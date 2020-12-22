<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>게시판 수정페이지</title>
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
    <form action="/post/edit/${boardDto.id}" method="post">
	    <input type="hidden" name="_method" value="put"/>
	    <input type="hidden" name="id" value="${boardDto.id}"/>
	
	        제목 : <input type="text" name="title" value="${boardDto.title}"> <br>
	        작성자 : <input type="text" name="writer" value="${boardDto.writer}"> <br>
	    <textarea name="content">${boardDto.content}</textarea><br>
	
	    <input type="submit" value="수정">
    </form>
    
    
	
    <!-- FOOTER -->
    <jsp:include page = "common/footer.jsp" flush="true"/>
    <!-- FOOTER END-->
</body>
</html>