<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- <script>
function showWeather() {
    var x = document.getElementById("weather");
        x.style.display = "flex";  
        window.scrollTo(0,document.body.scrollHeight);
}
</script> -->

<c:import url="/WEB-INF/jsp/template.jsp">
<c:param name="pageCSS" value="CSS/detail.css"/>
</c:import>



<section id="main-content">
<div>
	
	<c:url var="parkDetail" value="/detail?parkCode=${p.parkcode}" />
	<img id="detailimg" src="<c:url value = "img/parks/${p.parkcode}.jpg"/>" />
	<h2 class="name">${p.parkname}</h2>
	<p><i>${p.inspirationalquote } <br>-${p.inspirationalquotesource}</i></p>
	<p class="description">${p.parkdescription}</p>

	<p>State: ${p.state}</p>
	<p>Climate: ${p.climate }</p>
	<p>Miles of Trails: ${p.milesoftrail }</p>
	<p>Entry Fee: $${p.entryfee }</p>
	<p>Number of Campsites: ${p.numberofcampsites}</p>
	<p>Acreage: ${p.stringAcreage}</p>
	<p>Elevation: ${p.elevationinfeet} feet</p>
	<p>Founded ${p.yearfounded}</p>
	<p>Annual Visitors: ${p.stringVisitors}</p>
	<p>Number of Animal Species: ${p.numberofanimalspecies}</p>
	<br />
<!-- 	<button id="wbutton" onclick="showWeather()">Show Five Day Forecast</button> -->
	
	</div>
	</section>

<section class="weather" id="weather">
	


	
	<c:forEach items="${weatherList}" var="w">

<div class="day">
	<h4 id="date">${w.date }</h4>
	<img class = "weatherimg" id="day${w.fivedayforecastvalue }" src="<c:url value="/img/weather/${w.forecast}.png" />"/>
	<c:choose>
    		<c:when test="${tempScale=='c'}">
        		<p>High: ${w.celsiusHigh}°</p>
			<p>Low:  ${w.celsiusLow}°</p>
    		</c:when>    
    			<c:otherwise>
      			<p>High: ${w.high}°</p>
				<p>Low:  ${w.low}°</p>
    			</c:otherwise>
		</c:choose>

	
	<p>${w.message}</p>
	</div>
	
</c:forEach>
<br />

	<div id="scaletoggle">
<c:url var="submitUrl" value="/detailSession?parkCode=${p.parkcode}"/>
<form action="${submitUrl}" method="POST" id="toggle">

	<c:choose>
    		<c:when test="${tempScale=='c'}">

		<p><input type="radio" name ="tempScale" value="c" checked> Celcius</p>
		<p><input type="radio" name ="tempScale" value="f"> Fahrenheit</p>
		<p><input Type="submit" value="Submit" /></p>
	</c:when>    
    			<c:otherwise>	
				<p><input type="radio" name ="tempScale" value="c" > C°</p>
				<p><input type="radio" name ="tempScale" value="f" checked> F°</p>
				<p><input Type="submit" value="Submit" /></p>
			</c:otherwise>
		</c:choose>

</form>
</div>

</section>

</body>
</html>