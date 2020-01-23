

import java.io.IOException;


import java.sql.ResultSetMetaData;
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

/**
 * Servlet implementation class Display
 */
@WebServlet("/Displayy")
public class Displayy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Displayy() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		String driverName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/apparel_management";
		String user = "root";
		String paassword = "root";

		response.setContentType("text/html");
		try {

			Class.forName(driverName);
			Connection con = DriverManager.getConnection(url, user, paassword);
			String queryString = "SELECT * FROM Cloth";
			PreparedStatement ps1 = con.prepareStatement(queryString);
			PrintWriter p = response.getWriter();
			ResultSet rs = ps1.executeQuery();
			ResultSetMetaData metadata = rs.getMetaData();
			int columnCount = metadata.getColumnCount();
			p.print("<table border='1'>");
			if (rs.next()) {
				p.println(
						"<HTML><HEAD><TITLE>Display </TITLE></HEAD><BODY bgcolor= #eb984e><h2 styl>The total no of divisions is </h2> <h1> Display of all the garments and details:- </h1></body></html>");
				p.println("" + columnCount + ",");
				p.print("<tr>");
				for (int i = 1; i <= columnCount; i++) {
					String col_name = metadata.getColumnName(i);
					p.print("<td>" + col_name + "</td>");
				}
				p.print("</tr>");
				while (rs.next()) {

					p.print("<tr>");
					p.print("<td>" + rs.getInt(1) + "</td>");
					p.print("<td>" + rs.getString(2) + "</td>");
					p.print("<td>" + rs.getString(3) + "</td>");
					p.print("<td>" + rs.getString(4) + "</td>");
					p.print("<td>" + rs.getString(5) + "</td>");
					p.print("<td>" + rs.getString(6) + "</td>");
					p.print("</tr>");
				}
				p.print("</table>");

			} else {
				p.println(
						"<HTML><HEAD><TITLE>Successful</TITLE></HEAD><BODY bgcolor= #eb984e><h1 styl> Nothing is found in database !!</h1></body></html>");
			}
			con.close();
			ps1.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}