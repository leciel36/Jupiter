package rpc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class Recommendation
 */
@WebServlet("/recommendation")
public class Recommendation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Recommendation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		JSONArray array = new JSONArray();
		JSONObject obj1 = new JSONObject();
		JSONObject obj2 = new JSONObject();
		try {
			obj1.put("name", "abcd");
			obj1.put("address", "san francisco");
			obj1.put("time", "01/01/2017");
			
			obj2.put("name", "1234");
			obj2.put("address", "san jose");
			obj2.put("time", "01/02/2017");
			
			array.put(obj1);
			array.put(obj2);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		RpcHelper.writeJsonArray(response, array);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
