package com.pradeep.owm.service;

import com.pradeep.owm.model.WeatherModel;

import junit.framework.TestCase;

public class WeatherServiceTest extends TestCase {

	WeatherService  service = new WeatherService();
	
	WeatherModel model = null;
	
	String city ="";
	
	public void testShowWeatherOne() {
		city ="London";
		model = service.showWeather(city);
		System.out.println(model);
	}
	public void testShowWeatherTwo() {
		city ="Hong Kong";
		model = service.showWeather(city);
		System.out.println(model);
	}
	
	public void testShowWeatherThree() {
		city ="HongKong";
		model = service.showWeather(city);
		System.out.println(model);
	}
	public void testShowWeatherFour() {
		city ="";
		model = service.showWeather(city);
		System.out.println(model);
	}
	public void testShowWeatherFive() {
		city=" ";
		model = service.showWeather(city);
		System.out.println(model);
	}
	
	public void testShowWeatherSix() {
		city=null;
		model = service.showWeather(city);
		System.out.println(model);
	}
}
