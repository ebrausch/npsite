package com.techelevator.npgeek;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NpgeekController {
	
	@Autowired
	npgeekDao npgeekDao;
	
	@RequestMapping("/")
	public String displayHomePage (
			ModelMap map
			) {
		List<Park> allParks = npgeekDao.getAllParks();
		map.put("parklist", allParks);
		return "index";
	}
	
	@RequestMapping("/survey")
	public String displaySurvey (
			ModelMap map
			) {
		List<Park> allParks = npgeekDao.getAllParks();
		map.put("parklist", allParks);
		return "survey";
	}



	@RequestMapping("/detail")
	public String displayDetail (
					ModelMap map,
					@RequestParam String parkCode	
			) {
		Park thisPark = npgeekDao.getParkByCode(parkCode);
		List<Weather> thisWeather = npgeekDao.getWeather(parkCode);
		map.put("p", thisPark);
		map.put("weatherList", thisWeather);
		return "detail";
	}
	
	
	@RequestMapping("/detailSession")
	public String displayDetailWithSession (
						ModelMap map,
						@RequestParam String parkCode,
						@RequestParam String tempScale,
						HttpSession session
			) {
		session.setAttribute("tempScale", tempScale);
		
		return "redirect:/detail?parkCode=" + parkCode;
	}
	
	
	
	
	@RequestMapping("/surveyresults")
	public String displayResults (@RequestParam String parkcode,
								@RequestParam String activityLevel,
								@RequestParam String stateOfResidence,
								@RequestParam String emailAddress) {
		Survey s = new Survey();
		s.setActivitylevel(activityLevel);
		s.setEmailaddress(emailAddress);
		s.setParkcode(parkcode.toUpperCase());
		s.setState(stateOfResidence);
		npgeekDao.save(s);
		return "redirect:/results";
	}
	
	
	@RequestMapping("/results")
	public String displayResults(ModelMap map
			) {
		List<ParkSurvey> surveyList = npgeekDao.displayParkSurvey();
		map.put("surveyList", surveyList);
		return "results";
	}

}