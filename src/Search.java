

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
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
		String url = "jdbc:mysql://localhost:3306/apparel_management";
		String user = "root";
		String paassword = "root";

		response.setContentType("text/html");
		try {

			Class.forName(driverName);
			Connection con = DriverManager.getConnection(url, user, paassword);
			String queryString = "select C.Cloth_id,C.Type_name,C.Brand_name,M.Material_name,No.No_of_garments,B.Price from Cloth C,Billing B ,Total_no_garments No,Material_type M where C.Cloth_id=No.Cloth_id  and C.Cloth_id=B.Cloth_id;";
			PreparedStatement ps1 = con.prepareStatement(queryString);
			PrintWriter p = response.getWriter();
			ResultSet rs = ps1.executeQuery();
			ResultSetMetaData metadata = rs.getMetaData();
			int columnCount = metadata.getColumnCount();
			p.print("<table border='1'>");
			if (rs.next()) {
				p.println(
						"<HTML><HEAD><TITLE>Display </TITLE></HEAD><BODY bgcolor= #eb984e><h2 styl>The total no of divisions is </h2> <h1> Filtered items are </h1></body></html>");
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
					p.print("<td>" + rs.getInt(5) + "</td>");
					p.print("<td>" + rs.getInt(6) + "</td>");
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
