package com.techelevator.npgeek;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Weather {

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd");
	LocalDate localDate = LocalDate.now();
	
	private String parkcode;
	private int fivedayforecastvalue;
	private int low;
	private int high;
	private String forecast;
	private LocalDate date;
	private String StringDate;
	
	
	
	public String getParkcode() {
		return parkcode;
	}
	public void setParkcode(String parkcode) {
		this.parkcode = parkcode;
	}
	public int getFivedayforecastvalue() {
		return fivedayforecastvalue;
	}
	public void setFivedayforecastvalue(int fivedayforecastvalue) {
		this.fivedayforecastvalue = fivedayforecastvalue;
	}
	public int getLow() {
		return low;
	}
	public void setLow(int low) {
		this.low = low;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	public int getCelsiusHigh() {
		int celsiusHigh = (this.high -32) * 5/9;
		return celsiusHigh;
	}
	public int getCelsiusLow() {
		int celsiusLow = (this.low -32) * 5/9;
		return celsiusLow;
	}
	
	public String getMessage() {
		String message = returnMessage();
		return message;
	}
	
	public String returnMessage() {
		String message= "";
		if (this.high -20 >= this.low) {
			message += "Be sure to wear breathable layers. ";
		} if (this.forecast.equals("snow")) {
			message += "Pack your snowshoes! ";
		} if (this.forecast.equals("rain")) {
			message += "Pack rain gear and wear waterproof shoes.";
		} if (this.forecast.equals("thunderstorms")) {
			message += "Seek shelter and avoid hiking on exposed ridges. ";
		} if (this.forecast.equals("sunny")) {
			message += "Remember to pack sunblock. ";
		} if (this.high > 75) {
			message += "Bring an extra gallon of water. ";
		} if (this.low < 20) {
			message += "Exposure to frigid temperatures can be dangerous. ";
		}
		
		return message;
	}
	public String getDate() {
		this.date = localDate.plus(fivedayforecastvalue -1, ChronoUnit.DAYS);
		String StringDate = this.date.format(dtf);
		return StringDate;
	}

	public String getStringDate() {
		return StringDate;
	}
	public void setStringDate(String stringDate) {
		StringDate = stringDate;
	}
}
