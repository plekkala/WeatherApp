package com.pradeep.owm.model;

public class WeatherModel implements java.io.Serializable {


	private static final long serialVersionUID = 3689178667009112214L;

	private String todaysDate;
	
	private String cityName;
	
	private String descWeather;
	
	private String tempF;
	
	private String tempC;
	
	private String sunriseTime;
	
	private String sunsetTime;
	
	private String errorMessage;
	
	private String cod;

	
	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "WeatherModel [todaysDate=" + todaysDate + ", cityName=" + cityName + ", descWeather=" + descWeather
				+ ", tempF=" + tempF + ", tempC=" + tempC + ", sunriseTime=" + sunriseTime + ", sunsetTime="
				+ sunsetTime + ", errorMessage=" + errorMessage + ", cod=" + cod + "]";
	}

	public WeatherModel() {
		// TODO Auto-generated constructor stub
	}

	public String getTodaysDate() {
		return todaysDate;
	}

	public void setTodaysDate(String todaysDate) {
		this.todaysDate = todaysDate;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDescWeather() {
		return descWeather;
	}

	public void setDescWeather(String descWeather) {
		this.descWeather = descWeather;
	}

	public String getTempF() {
		return tempF;
	}

	public void setTempF(String tempF) {
		this.tempF = tempF;
	}

	public String getTempC() {
		return tempC;
	}

	public void setTempC(String tempC) {
		this.tempC = tempC;
	}

	public String getSunriseTime() {
		return sunriseTime;
	}

	public void setSunriseTime(String sunriseTime) {
		this.sunriseTime = sunriseTime;
	}

	public String getSunsetTime() {
		return sunsetTime;
	}

	public void setSunsetTime(String sunsetTime) {
		this.sunsetTime = sunsetTime;
	}
	

}

