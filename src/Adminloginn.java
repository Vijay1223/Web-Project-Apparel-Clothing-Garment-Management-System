

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Adminloginn
 */
@WebServlet("/Adminloginn")
public class Adminloginn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adminloginn() {
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
		String unamee = request.getParameter("User_namee");
		String passs = request.getParameter("Passwordd");

		try {
		
			Class.forName(driverName); 
			Connection con = DriverManager.getConnection(url,user,paassword);
			
			String queryString = "SELECT User_name FROM Admin where User_name=? and Passwordd=?";
	
			PreparedStatement	ps = con.prepareStatement(queryString);
			
			  ps.setString(1, unamee);
		        ps.setString(2, passs);
		ResultSet	rs = ps.executeQuery();
		
			if (rs.next()) {
			
					// HttpSession session = request.getSession();
				//session.setAttribute("name", uname);

					response.sendRedirect("admin_work.jsp");										 					 
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
