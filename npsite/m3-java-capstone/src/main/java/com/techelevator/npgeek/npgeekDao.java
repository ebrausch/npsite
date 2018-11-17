package com.techelevator.npgeek;

import java.util.List;

public interface npgeekDao {

	public List<Park> getAllParks();
	public void save(Survey post);
	public Park getParkByCode(String parkcode);
	public List<Weather> getWeather(String parkcode);
	public List<ParkSurvey>displayParkSurvey();
}
