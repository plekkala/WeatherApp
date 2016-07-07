package com.pradeep.owm.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pradeep.owm.model.WeatherModel;
import com.pradeep.owm.service.WeatherService;

/**
 * Servlet implementation class WeatherDetails
 */
@WebServlet(name = "details", urlPatterns = "/details", loadOnStartup = 1)
public class WeatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WeatherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("first");
		String returnPage = "/search.jsp";
		System.out.println("action" + action);
		if (action != null && action.equals("back")) {
			returnPage = "/search.jsp";
		} else if (action != null && action.equals("refresh")) {
			// Invoke Refresh job here.
		} else if (action != null && action.equals("search")) {
			returnPage = "/display.jsp";
			String city = request.getParameter("city");
			WeatherModel model = service(city);
			System.out.println(model.toString());
			request.setAttribute("date", model.getTodaysDate());
			request.setAttribute("city", city);
			request.setAttribute("desc", model.getDescWeather());
			request.setAttribute("tempC", model.getTempC());
			request.setAttribute("tempF", model.getTempF());
			request.setAttribute("sunrise", model.getSunriseTime());
			request.setAttribute("sunset", model.getSunsetTime());
			request.setAttribute("message", model.getErrorMessage());
			request.setAttribute("cod", model.getCod());
			request.setAttribute("error", true);
		}

		request.getRequestDispatcher(returnPage).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private WeatherModel service(String city) {
		WeatherService ws = new WeatherService();
		return ws.showWeather(city);

	}

}
