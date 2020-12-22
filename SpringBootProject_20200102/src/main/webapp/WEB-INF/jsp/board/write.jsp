<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
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
    
    <form  action="/post" method="post" >
        제목 : <input type="text" name="title"> <br>
        작성자 : <input type="text" name="writer"> <br>
        <textarea name="content"></textarea><br>
        <input type="submit" value="등록">
    </form>
    
    
	
    <!-- FOOTER -->
    <jsp:include page = "common/footer.jsp" flush="true"/>
    <!-- FOOTER END-->
</body>
</html>