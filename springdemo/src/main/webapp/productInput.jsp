<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Form</title>
<style>
.err {
	color: #ff0000
}
</style>
</head>
<body>
	<h1>Product Form</h1>
	<form:form modelAttribute="product" action="addProduct.do">
		Name <form:input path="name"/> <form:errors path="name" cssClass="err"/><br />
		Price <form:input path="price"/> <form:errors path="price" cssClass="err"/><br />
		Quantity <form:input path="quantity" /> <form:errors path="quantity" cssClass="err"/><br />
		<button type="submit">Add Product</button>
	</form:form>
</body>
</html>

