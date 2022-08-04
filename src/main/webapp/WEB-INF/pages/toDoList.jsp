<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!--  FORM: Ajouter une tache -->

	<div>
		<fieldset>
			<h3>Ajouter une tache</h3>
			<form action="/Jpa/list?req=add" method="POST">
				<label>Nom:</label> 
					<input type="text" id="nom" placeholder="Nom" name="nom"><br> 
				<label>Description:</label> 
					<input type="text" id="description" placeholder="Description" name="desc"><br>
					<input type="submit" id="add" value="ajouter">
			</form>
		</fieldset>
	</div>

	<h3>Liste des taches</h3>
	<ul>
		<c:forEach items="${tasks}" var="task" varStatus="status">

			<li>
				<form action="/Jpa/list?req=del&id=${ task._id}" method="POST">
					<input type="submit" id="add" value="Supprimer">
				</form>
			 	<em> Id: <c:out value="${ task._id}" /></em> --- Nom: <c:out value="${ task._nom}" /> --- Description: <c:out value="${ task._description}"/>
			</li>
			 
			<form action="/Jpa/list?req=mod&id=${ task._id}" method="POST">
					<input type="submit" id="add" value="Modifier">
				<label>Nom:</label> 
					<input type="text" id="nom" placeholder="Nom" name="nom"> 
				<label>Description:</label> 
					<input type="text" id="description" placeholder="Description" name="desc"><br>
			</form>
			<br>
		</c:forEach>
	</ul>


</body>
</html>