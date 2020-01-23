

import java.io.IOException;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Customer_register
 */
@WebServlet("/Customer_register")
public class Customer_register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customer_register() {
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
	//	doGet(request, response);
		
		String driverName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/apparel_management";
		String user = "root";
		String paassword = "root";

		response.setContentType("text/html");
		String uname = request.getParameter("User_name");
		String pass = request.getParameter("Password");
		String fname = request.getParameter("First_name");
		String lname = request.getParameter("Last_name");
		String addr = request.getParameter("Address");
		
		String phone = String.valueOf(request.getParameter("Phone_num"));

		try {

			Class.forName(driverName);
			Connection con = DriverManager.getConnection(url, user, paassword);
			String queryString1 = "SELECT User_name FROM Customer where User_name = ?";

			PreparedStatement ps1 = con.prepareStatement(queryString1);

			ps1.setString(1, uname);
			PrintWriter p = response.getWriter();
			ResultSet rs = ps1.executeQuery();
			if (rs.next()) {
				//HttpSession session = request.getSession();
				//session.setAttribute("name", uname);
				//response.sendRedirect("Notregistered.jsp");
			//PrintWriter p = response.getWriter();
				
				p.println("<HTML><HEAD><TITLE>not valid</TITLE></HEAD><BODY bgcolor= #eb984e><h1 styl> This username is alredy taken by some body</h1></body></html>");

				
			} else {
				//response.sendRedirect("logout.jsp");
			
				String queryString = "insert into Customer(Customer_firstname,Customer_lastname,Phone_number,Customer_address,User_name,Password) values (? , ?, ?, ?, ?, ?)";
				PreparedStatement ps = con.prepareStatement(queryString);
				ps.setString(1, fname);
				ps.setString(2, lname);
				ps.setString(3, phone);
				ps.setString(4, addr);
				ps.setString(5, uname);
				ps.setString(6, pass);
				ps.executeUpdate();
				//response.sendRedirect("Successregister.jsp");
				p.println("<HTML><HEAD><TITLE>Successful</TITLE></HEAD><BODY bgcolor= #eb984e><h1 styl> Success!! Stored in database</h1></body></html>");
				ps.close();

			}

			con.close();
			ps1.close();

		}

		catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}
	}
