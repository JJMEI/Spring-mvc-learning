<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 表单命令对象commandName将结果包装 然后通过Http请求进行进行绑定 -->
	<mvc:form commandName="book" action="book_save" method="post">
		<label for="category">Category</label>
		<mvc:select id="category" path="category.id" items="${categories}" itemLabel="name" itemValue="id"></mvc:select>
		<br/>
		
		<label for="title">Title</label>
		<mvc:input id="title" path="title"/>
		<br/>
		
		<label for="author">Author</label>
		<mvc:input id="author" path="author"/>
		<br/>
		
		<label for="isbn">ISBN</label>
		<mvc:input id="isbn" path="isbn"/>
		<br/>
		<input id="reset" type="reset" tabindex="4"/>
		<input id="submit" type="submit" tabindex="5" value="Add Book">
	</mvc:form>
</body>
</html>