<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action='<c:url value="/ClassPathResource.html"></c:url>'>
		<input type="submit" name="ClassPathResource"
			value="ClassPathResource" />
	</form>
	<form action='<c:url value="/FileSystemResource.html"></c:url>'>
		<input type="submit" name="FileSystemResource"
			value="FileSystemResource" />
	</form>
</body>
</html>