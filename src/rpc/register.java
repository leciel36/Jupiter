package rpc;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import db.DBConnection;
import db.DBConnectionFactory;
import db.mysql.MySQLDBUtil;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnection connection = DBConnectionFactory.getConnection();
		System.out.println("hello");
		try {
			JSONObject input = RpcHelper.readJSONObject(request);
			String userId = input.getString("user_id");
			String password = input.getString("password");
			String firstName = input.getString("first_name");
			String lastName = input.getString("last_name");
			System.out.println(userId + password + firstName + lastName);
			
			connection.setRegistration(userId, password, firstName, lastName);
			RpcHelper.writeJsonObject(response, new JSONObject().put("status", "OK"));
		} catch (Exception e) {
	  		 e.printStackTrace();
	  	} finally {
	  		 connection.close();
	  	}
		
	}

}
