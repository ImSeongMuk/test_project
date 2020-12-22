<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
<header>
	<div class="wrappers">
		<h1><a href="/">TITLE</a></h1>
		<nav>
			<ul class="menu">
				<c:if test="${username ne null}">
					<li><a>${username}님 환영합니다.</a></li>
					<li><a href="/logout">logout</a></li>
				</c:if>
				<c:if test="${empty username}">
					<li><a href="/login">login</a></li>
					<li><a href="/user/signup">sing up</a></li>
				</c:if>
				<li><a href="/">home</a></li>
			</ul>
		</nav>
	</div>
	
</header>
</div>
<hr>
