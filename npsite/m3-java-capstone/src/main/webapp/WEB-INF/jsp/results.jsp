<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<c:import url="/WEB-INF/jsp/template.jsp">
<c:param name="pageCSS" value="CSS/results.css"/>
</c:import>


<section class="results">

<h2>Survey results</h2>


<table>


<c:forEach items="${surveyList}" var="ps">
<tr>
	<td><a href="${parkDetail}"><img class="parkimg" src="<c:url value = "img/parks/${ps.parkcode}.jpg"/>" /></a></td>
	
	<c:url var="parkDetail" value="/detail?parkCode=${ps.parkcode}" />
	
 	<td><h3><a href="${parkDetail}">${ps.parkName}</a></h3></td>
	<c:choose>
    		<c:when test="${ps.numberOfReviews == 1}">
        		<c:set var="votes" value="Vote" />
    		</c:when>    
    			<c:otherwise>
      			<c:set var="votes" value="Votes" />
    			</c:otherwise>
		</c:choose>
	<td><h3 >${ps.numberOfReviews} ${votes}</h3></td>
</tr>
</c:forEach>
	</table>
</section>


</body>
</html>