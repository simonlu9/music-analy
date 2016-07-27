package org.analy.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class AnalyServlet
 */
@WebServlet("/AnalyServlet")
public class AnalyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnalyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public static void main(String[] args) throws JSONException {
    	  JSONObject jsonObject = new JSONObject();
    	JSONArray jsonArray = new JSONArray();  
        jsonArray.put(0, "this is a jsonArray value");  
        jsonArray.put(1,"another jsonArray value");  
        jsonObject.put("jsonArray", jsonArray);  
        System.out.println(jsonObject);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  JSONObject jsonObject = new JSONObject();
	    	JSONArray jsonArray = new JSONArray();  
	        try {
				jsonArray.put(0, "this is a jsonArray value");
				   jsonArray.put(1,"another jsonArray value");  
			        jsonObject.put("jsonArray", jsonArray);  
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	     
	    //    System.out.println(jsonObject);
		response.getWriter().append("Served at: ").append(jsonObject.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
