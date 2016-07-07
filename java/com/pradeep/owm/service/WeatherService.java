package com.pradeep.owm.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

import org.json.JSONObject;

import com.pradeep.owm.constants.WeatherModelConstants;
import com.pradeep.owm.model.WeatherModel;

//http://api.openweathermap.org/data/2.5/weather?q=London&
//appid=a6b28ecb80055b5497e57472dfcd3199

public class WeatherService {

	String URL = "http://api.openweathermap.org/data/2.5/weather?q=";

	//API Key can be taken of out this class
	String key = "a6b28ecb80055b5497e57472dfcd3199";

	String appid = "&appid=";

	private static DecimalFormat df1 = new DecimalFormat(".#");

	/*public Map<String,String> showWeather(String city) {
		System.out.println("city is: " + city);
		String response = getWeather(city);
		System.out.println("response is: " + response);

		JSONObject jsonObj = (response != null) ? new JSONObject(response) : null;

		WeatherData weatherData = new WeatherData();
		Map<String, String> map = new HashMap<>();
		map.putAll(weatherData.transform(jsonObj));
		return map;
	}*/
	
	

	public WeatherModel showWeather(String city) {
		if(city!=null){
			String response = getWeatherFromURL(city);
			JSONObject jsonObj = StringToJSON(response);
			WeatherModel model = transform(jsonObj);
			return model;
		}
		else
			return null;
		
	}
	
	private JSONObject StringToJSON(String response){
		if(response!=null){
			JSONObject jsonObj = (response != null) ? new JSONObject(response) : null;
			return jsonObj;
		}
		return null;
		
	}
	
	private WeatherModel transform(JSONObject jsonObject){
		//System.out.println("jsonObject"+jsonObject);
		WeatherModel model = new WeatherModel();
		if(jsonObject!=null){
			if(!jsonObject.has(WeatherModelConstants.weatherObj) && jsonObject.getString(WeatherModelConstants.cod).equals("404")){
				model.setCod(jsonObject.getString(WeatherModelConstants.cod));
				model.setErrorMessage(jsonObject.getString(WeatherModelConstants.errorMessage));
				return model;
			}
			else{
				
				model.setCityName(jsonObject.getString(WeatherModelConstants.cityName));
				model.setDescWeather(jsonObject.getJSONArray(WeatherModelConstants.weatherObj).getJSONObject(0).getString(WeatherModelConstants.descWeather));
				model.setSunriseTime(todaysTime(jsonObject.getJSONObject(WeatherModelConstants.sysObj).optString(WeatherModelConstants.sunriseTime)));
				model.setSunsetTime(todaysTime(jsonObject.getJSONObject(WeatherModelConstants.sysObj).optString(WeatherModelConstants.sunsetTime)));
				model.setTempC(tempC(jsonObject.getJSONObject(WeatherModelConstants.mainObj).optString(WeatherModelConstants.temp)));
				model.setTempF(tempF(jsonObject.getJSONObject(WeatherModelConstants.mainObj).optString(WeatherModelConstants.temp)));
				model.setTodaysDate(todaysDate(jsonObject.optString(WeatherModelConstants.todaysDate)));
				return model;}
			}
		else
			return null;
	
		

	}

	private String tempC(String temp){
		double tempC =  (Double.valueOf(temp)-273.15);
		return String.valueOf(df1.format(tempC));
	}

	private String tempF(String temp){
		//F = 1.8(K - 273) + 32
		double tempF = 1.8*(Double.valueOf(temp)-273.15)+32;
		return String.valueOf(df1.format(tempF));

	}

	private String todaysDate(String time){

		long timeStamp = (long) Long.parseLong(time) * 1000;
		Date date = new Date(timeStamp);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy H:mm:ss zzz");
		String dateString = formatter.format(date);
		return dateString;
	}
	
	private String todaysTime(String time){
		long timeStamp = (long) Long.parseLong(time) * 1000;
		Date date = new Date(timeStamp);
		SimpleDateFormat formatter= new SimpleDateFormat("hh:mm a");
		return formatter.format(date);
	}
	
	private String getWeatherFromURL(String city) {
		city = city.replace(" ", "");
		String url = URL + city + appid + key;
		//System.out.println(url);
		String response = httpGET(url);
		return response;

	}
	
	private String httpGET(String requestAddress) {
		URL request;
		HttpURLConnection connection = null;
		BufferedReader reader = null;

		String tmpStr;
		String response = null;

		try {
			request = new URL(requestAddress);

			connection = (HttpURLConnection) request.openConnection();

			connection.setRequestMethod("GET");
			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(false);
			connection.setRequestProperty("Accept-Encoding", "gzip, deflate");
			connection.connect();

			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				String encoding = connection.getContentEncoding();

				try {
					if (encoding != null && "gzip".equalsIgnoreCase(encoding)) {
						reader = new BufferedReader(
								new InputStreamReader(new GZIPInputStream(connection.getInputStream())));
					} else if (encoding != null && "deflate".equalsIgnoreCase(encoding)) {
						reader = new BufferedReader(new InputStreamReader(
								new InflaterInputStream(connection.getInputStream(), new Inflater(true))));
					} else {
						reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
					}

					while ((tmpStr = reader.readLine()) != null) {
						response = tmpStr;
					}
				} catch (IOException e) {
					System.err.println("Error: " + e.getMessage());
				} finally {
					if (reader != null) {
						try {
							reader.close();
						} catch (IOException e) {
							System.err.println("Error: " + e.getMessage());
						}
					}
				}
			} else { // if HttpURLConnection is not okay
				try {
					reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
					while ((tmpStr = reader.readLine()) != null) {
						response = tmpStr;
					}
				} catch (IOException e) {
					System.err.println("Error: " + e.getMessage());
				} finally {
					if (reader != null) {
						try {
							reader.close();
						} catch (IOException e) {
							System.err.println("Error: " + e.getMessage());
						}
					}
				}

				// if response is bad
				System.err.println("Bad Response: " + response + "\n");
				return null;
			}
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
			response = null;
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}

		return response;
	}
}
