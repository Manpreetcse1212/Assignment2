package com.groupD.week5.assignment2;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
@WebServlet("/DetailsServlet")
public class DetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetailsServlet() {
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
		JSONParser parser = new JSONParser();
		// load the json file.
		FileReader reader = new FileReader(this.getServletContext().getRealPath("/") + "jsonfiles/Details.json");

		List<String> firstnameValues = new ArrayList<String>();
		List<String> lastnameValues = new ArrayList<String>();
		List<String> addressValues = new ArrayList<String>();
		List<String> sub1Values = new ArrayList<String>();
		List<String> sub2Values = new ArrayList<String>();
		List<String> sub3Values = new ArrayList<String>();
		List<String> sub4Values = new ArrayList<String>();
		List<String> sub5Values = new ArrayList<String>();

		Object obj;
		try {
			obj = parser.parse(reader);
			JSONObject jsonObject = (JSONObject) obj;
			//Extraction of data

			JSONArray firstname = (JSONArray) jsonObject.get("FirstName");
			for (int i = 0; i < firstname.size(); i++) {
				firstnameValues.add(String.valueOf(firstname.get(i)));
			}
			JSONArray lastname = (JSONArray) jsonObject.get("LastName");
			for (int i = 0; i < lastname.size(); i++) {
				lastnameValues.add(String.valueOf(lastname.get(i)));
			}
			JSONArray address = (JSONArray) jsonObject.get("Address");
			for (int i = 0; i < address.size(); i++) {
				JSONObject ob = (JSONObject) address.get(i);
				addressValues.add(ob.get("city") + ", " + ob.get("state"));
			}
			JSONArray sub1 = (JSONArray) jsonObject.get("Subject1");
			for (int i = 0; i < sub1.size(); i++) {
				sub1Values.add(String.valueOf(sub1.get(i)));
			}
			JSONArray sub2 = (JSONArray) jsonObject.get("Subject2");
			for (int i = 0; i < sub2.size(); i++) {
				sub2Values.add(String.valueOf(sub2.get(i)));
			}
			JSONArray sub3 = (JSONArray) jsonObject.get("Subject3");
			for (int i = 0; i < sub3.size(); i++) {
				sub3Values.add(String.valueOf(sub3.get(i)));
			}
			JSONArray sub4 = (JSONArray) jsonObject.get("Subject4");
			for (int i = 0; i < sub4.size(); i++) {
				sub4Values.add(String.valueOf(sub4.get(i)));
			}
			JSONArray sub5 = (JSONArray) jsonObject.get("Subject5");
			for (int i = 0; i < sub5.size(); i++) {
				sub5Values.add(String.valueOf(sub5.get(i)));
			}

		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		HttpSession session = request.getSession(false);

		session.setAttribute("firstnameValues", firstnameValues);
		session.setAttribute("lastnameValues", lastnameValues);

		session.setAttribute("addressValues", addressValues);
		session.setAttribute("sub1Values", sub1Values);
		session.setAttribute("sub2Values", sub2Values);
		session.setAttribute("sub3Values", sub3Values);
		session.setAttribute("sub4Values", sub4Values);
		session.setAttribute("sub5Values", sub5Values);

		response.sendRedirect("Details.jsp"); // redirecting to the Details.jsp file
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
