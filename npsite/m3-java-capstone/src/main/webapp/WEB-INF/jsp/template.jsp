<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>National Park Geek</title>

  <c:url value="CSS/template.css" var="cssURL"/>
    <link rel="stylesheet" type="text/css" href="${cssURL}" />
     <link rel="stylesheet" type="text/css" href="${param.pageCSS}"/> 
    
    
    		<c:url var="index" value="/" />
    		<c:url var="survey" value="/survey" />
    		

</head>
<body>

   <header>
   		<img id="logo" src="<c:url value = "img/logo.png"/>" />
        
    </header>
    <nav>
        <ul>
            <li><a href="${index}">Home</a></li>
            <li><a href="${survey}">Survey</a></li>
           
        </ul>
        
    </nav>
