package com.groupD.week5.assignment2;

import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Date: 16.02.2022
 * Group D 
 * Member1: Manpreet kaur
 * Member2: Manpreet Kaur
 * Member3: Bhumikaben Manubhai Patel
 * Member4: Ashikkumar Nareshbhai Patel
 * Member5: Hardeep Kaur Chahal 
 */
@WebServlet("/CalcServlet")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalcServlet() {
		super();
		// Comment1
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		JSONParser jsonparser = new JSONParser(); // parse the json file calling jsonparser.
		// load the json file.
		FileReader reader = new FileReader(this.getServletContext().getRealPath("/") + "jsonfiles/Calculate.json");

		float Area_of_triangle = 0, Area_of_square = 0;
		Object obj;
		try {
			obj = jsonparser.parse(reader);
			JSONObject areaObj = (JSONObject) obj;
			JSONArray arr = (JSONArray) areaObj.get("area");

			// Extraction of data

			float height = Float.parseFloat(String.valueOf(arr.get(0)));
			float base = Float.parseFloat(String.valueOf(arr.get(1)));
			float side = Float.parseFloat(String.valueOf(arr.get(2)));

			Area_of_triangle = (float) ((0.5) * base * height);
			Area_of_square = side * side;

		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // java object
		
		//Creating http session
		HttpSession session = request.getSession(false);

		session.setAttribute("area_of_triangle", Area_of_triangle);
		session.setAttribute("area_of_square", Area_of_square);

		response.sendRedirect("CalculateArea.jsp"); // redirecting to CalculateArea.jsp
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

}
