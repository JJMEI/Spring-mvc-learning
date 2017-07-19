<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<mvc:form commandName="employee" action="employee_save" method="post">
		<label for="firstName">FirstName</label>
		<mvc:input id="firstName" path="firstName"/>
		<br/>
		<label for="lastName">LastName</label>
		<mvc:input id="lastName" path="lastName"/>
		<br/>
		<mvc:errors path="birthDate"/>
		<label for="birthDate">BirthDate</label>
		<mvc:input id="birthDate" path="birthDate"/>
		<br/>
		
		<input id="reset" type="reset" tabindex="4"/>
		<input id="submit" type="submit" tabindex="5" value="Add Employee">
	</mvc:form>
</body>
</html>