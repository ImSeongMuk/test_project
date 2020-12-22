<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<!DOCTYPE html>
<html>
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
    
    <form action="/user/signup" method="post" >
    	ID : <input type="text" name="username"> <br>
    	PASSWORD : <input type="password" name="password"> <br>
    	이름 : <input type="text" name="name"> <br>
    	
    	<input type="submit" value="회원가입">
    </form>
	
    <!-- FOOTER -->
    <jsp:include page = "common/footer.jsp" flush="true"/>
    <!-- FOOTER END-->
</body>
</html>