/*package com.pradeep.owm.model;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.pradeep.owm.constants.WeatherModelConstants;

public class WeatherData {

	JSONObject jsonObject;

	public WeatherData() {
	}

	public WeatherData(JSONObject jsonObject) {
		super();
		this.jsonObject = jsonObject;
	}


	public Map<String,String> transform(JSONObject jsonObject){
		Map<String, String> model = new HashMap<String,String>();

		model.put(WeatherModelConstants.cityName,jsonObject.getString(WeatherModelConstants.cityName));
		model.put(WeatherModelConstants.descWeather,jsonObject.getJSONArray(WeatherModelConstants.weatherObj).getJSONObject(0).getString(WeatherModelConstants.descWeather));
		model.put(WeatherModelConstants.sunriseTime,todaysTime(jsonObject.getJSONObject(WeatherModelConstants.sysObj).optString(WeatherModelConstants.sunriseTime)));
		model.put(WeatherModelConstants.sunsetTime,todaysTime(jsonObject.getJSONObject(WeatherModelConstants.sysObj).optString(WeatherModelConstants.sunsetTime)));
		model.put(WeatherModelConstants.tempC,tempC(jsonObject.getJSONObject(WeatherModelConstants.mainObj).optString(WeatherModelConstants.temp)));
		model.put(WeatherModelConstants.tempF,tempF(jsonObject.getJSONObject(WeatherModelConstants.mainObj).optString(WeatherModelConstants.temp)));

		model.put(WeatherModelConstants.todaysDate,todaysDate(jsonObject.optString(WeatherModelConstants.todaysDate)));
		return model;

	}
	
	
	public WeatherModel transform(JSONObject jsonObject){
		WeatherModel model = new WeatherModel();
		model.setCityName(jsonObject.getString(WeatherModelConstants.cityName));
		model.setDescWeather(jsonObject.getJSONArray(WeatherModelConstants.weatherObj).getJSONObject(0).getString(WeatherModelConstants.descWeather));
		model.setSunriseTime(todaysTime(jsonObject.getJSONObject(WeatherModelConstants.sysObj).optString(WeatherModelConstants.sunriseTime)));
		model.setSunsetTime(todaysTime(jsonObject.getJSONObject(WeatherModelConstants.sysObj).optString(WeatherModelConstants.sunsetTime)));
		model.setTempC(tempC(jsonObject.getJSONObject(WeatherModelConstants.mainObj).optString(WeatherModelConstants.temp)));
		model.setTempF(tempF(jsonObject.getJSONObject(WeatherModelConstants.mainObj).optString(WeatherModelConstants.temp)));
		model.setTodaysDate(todaysDate(jsonObject.optString(WeatherModelConstants.todaysDate)));
		return model;

	}

	private String tempC(String temp){
		double tempC =  (Double.valueOf(temp)-273.15);
		return String.valueOf(tempC);
	}

	private String tempF(String temp){
		//F = 1.8(K - 273) + 32
		double tempF = 1.8*(Double.valueOf(temp)-273.15)+32;
		return String.valueOf(tempF);

	}


	private String todaysDate(String time){

		long timeStamp = (long) Long.parseLong(time) * 1000;
		Date date = new Date(timeStamp);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy H:mm:ss zzz");
		String dateString = formatter.format(date);

	formatter = new SimpleDateFormat("hh:mm a");
	String time = formatter.format(date);
		return dateString;
	}
	private String todaysTime(String time){
		long timeStamp = (long) Long.parseLong(time) * 1000;
		Date date = new Date(timeStamp);
		SimpleDateFormat formatter= new SimpleDateFormat("hh:mm a");
		return formatter.format(date);
	}
}
*/