

import java.io.IOException;

import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Apparal_one
 */
@WebServlet("/Apparal_one")
public class Apparal_one extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Apparal_one() {
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
		// TODO Auto-generated method stub
		
		
		String driverName = "com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/apparel_management";
		String user = "root";
		String paassword = "root";
	

		response.setContentType("text/html");
		String uname = request.getParameter("User_name");
		String pass = request.getParameter("Password");

		try {
		
			Class.forName(driverName); 
			Connection con = DriverManager.getConnection(url,user,paassword); 
			
			String queryString = "SELECT User_name FROM Customer where User_name=? and Password=?";
	
			PreparedStatement	ps = con.prepareStatement(queryString);
			
			  ps.setString(1, uname);
		        ps.setString(2, pass);
		ResultSet	rs = ps.executeQuery();
		
			if (rs.next()) {
			
					// HttpSession session = request.getSession();
				//session.setAttribute("name", uname);

					response.sendRedirect("welcome.jsp");										 					 
				} 
			else {
					response.sendRedirect("logout.jsp");
				  }
			
			con.close();
			ps.close();

			}
		catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}


}


