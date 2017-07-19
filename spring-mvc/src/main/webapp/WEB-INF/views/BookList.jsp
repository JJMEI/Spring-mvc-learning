<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<c:url value="/book_input"/>">Add book</a>
	
	<table>
		<tr>
			<th>Category</th>
			<th>Title</th>
			<th>ISBN</th>
			<th>Author</th>
			<th> &nbsp</th>
		</tr>
		
		<c:forEach items="${books}" var="book">
		
			<tr>
				<td>${book.category.name}</td>
				<td>${book.title}</td>
				<td>${book.isbn} </td>
				<td>${book.author}</td>
				<td><a href="/mvc/book_edit/${book.id}">Edit</a></td>
				<td><a href="/mvc/book_delete/${book.id}">delete</a></td>
				
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>