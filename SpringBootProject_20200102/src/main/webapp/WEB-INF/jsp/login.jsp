<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>login page</title>
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
    
	<form class="login-form" method="POST">
	  <input type ="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
	  <div class="row">
	    <div class="input-field col s12">
	      <input id="email" type="text" name="username" class="validate"/>
	      <label for="email">ID</label>
	    </div>
	  </div>
	  <div class="row">
	    <div class="input-field col s12">
	      <input id="password" type="password" name="password" class="validate"/>
	      <label for="password">PASSWORD</label>
	    </div>
	  </div>
	  <input class="login-btn waves-effect waves-light btn" type="submit" value="로그인" />
	</form>
	
	<!-- FOOTER -->
    <jsp:include page = "common/footer.jsp" flush="true"/>
    <!-- FOOTER END-->
</body>
</html>

