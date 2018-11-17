<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<c:import url="/WEB-INF/jsp/template.jsp">
<c:param name="pageCSS" value="CSS/index.css"/>
</c:import>





<c:forEach items="${parklist}" var="p">
<section id="main-content">
<div id="test">
	
	<c:url var="parkDetail" value="/detail?parkCode=${p.parkcode}" />
	<a href="${parkDetail}"><img class="parkimg" src="<c:url value = "img/parks/${p.parkcode}.jpg"/>" /></a>
	<div class="index"></div>
	<h2 class="name"><a href="${parkDetail}">${p.parkname}</a>, ${p.state }</h2>
	<p>${p.parkdescription}</p>
	
	</div>
	</div>
	</section>
</c:forEach>

		



</body>
</html>