package com.techelevator.npgeek;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;



@Component
public class JDBCnpgeekDao implements npgeekDao{

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void JdbcReviewDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Park> getAllParks() {
		List<Park> allParks = new ArrayList<>();
		String sqlSelectAllParks = "SELECT * FROM park ORDER BY parkname;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		while(results.next()) {
			Park p = new Park();		
			p.setAcreage(results.getInt("acreage"));
			p.setAnnualvisitorcount(results.getInt("annualvisitorcount"));
			p.setParkname(results.getString("parkname"));
			p.setClimate(results.getString("climate"));
			p.setElevationinfeet(results.getInt("elevationinfeet"));
			p.setEntryfee(results.getInt("entryfee"));
			p.setMilesoftrail(results.getFloat("milesoftrail"));
			p.setYearfounded(results.getInt("yearfounded"));
			p.setInspirationalquote(results.getString("inspirationalquote"));
			p.setInspirationalquotesource(results.getString("inspirationalquotesource"));
			p.setNumberofanimalspecies(results.getInt("numberofanimalspecies"));
			p.setNumberofcampsites(results.getInt("numberofcampsites"));
			p.setState(results.getString("state"));
			p.setParkdescription(results.getString("parkdescription"));
			p.setParkcode(results.getString("parkcode").toLowerCase());
			allParks.add(p);
		}
		return allParks;
	}

	//////////////////////////////////////Needs work/////////////////
	@Override
	public List<Weather> getWeather(String parkcode) {
		
		parkcode = parkcode.toUpperCase();
		List<Weather> weatherList= new ArrayList<>();
		String sqlGetWeather = "SELECT * FROM weather WHERE parkcode = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetWeather, parkcode);
		while(results.next()) {
			Weather w = new Weather();
			w.setFivedayforecastvalue(results.getInt("fivedayforecastvalue"));
			w.setForecast(results.getString("forecast"));
			w.setHigh(results.getInt("high"));
			w.setLow(results.getInt("low"));
			
			weatherList.add(w);
		}
		return weatherList;
	}


	
	@Override
	public void save(Survey post) {

		String sqlInsertSurvey = "INSERT INTO survey_result( parkcode,emailaddress, state, activitylevel) VALUES ( ?,?,?,?)";
		jdbcTemplate.update(sqlInsertSurvey,  post.getParkcode(), post.getEmailaddress(), post.getState(), post.getActivitylevel());
		
	}

	@Override
	public Park getParkByCode(String parkcode) {
		List<Park> allparks = getAllParks();
		Park thisPark = null;
		for (Park p : allparks) {
			if (parkcode.toUpperCase().equals(p.getParkcode().toUpperCase())) {
				 thisPark = p;
			}
		}
		
		
		return thisPark;
	}

	@Override
	public List<ParkSurvey> displayParkSurvey() {
		List <ParkSurvey> parkSurveyList = new ArrayList<>();
		String sql = "select park.parkcode, parkname, COUNT(parkname) AS scount FROM park\n" + 
				" JOIN survey_result ON\n" + 
				"    park.parkcode = survey_result.parkcode \n" + 
				"    GROUP BY park.parkcode ORDER BY scount DESC	, parkname;";
				
		SqlRowSet results =jdbcTemplate.queryForRowSet(sql);
		while(results.next()) {
			ParkSurvey ps = new ParkSurvey();
			ps.setNumberOfReviews(results.getInt("scount"));
			ps.setParkcode(results.getString("parkcode").toLowerCase());
			ps.setParkName(results.getString("parkname"));
			parkSurveyList.add(ps);
		}
		return parkSurveyList;
	}

}
