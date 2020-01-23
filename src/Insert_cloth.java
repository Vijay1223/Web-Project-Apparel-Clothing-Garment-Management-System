
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Insert_cloth
 */
@WebServlet("/Insert_cloth")
public class Insert_cloth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert_cloth() {
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
		String cid = String.valueOf(request.getParameter("Cloth_iddd"));
		String size = request.getParameter("Sizeee");
		String bname = request.getParameter("Brand_nameee");
		String mtypeid = request.getParameter("Material_typeiddd");
		String tname = request.getParameter("Type_nameee");
		String color = request.getParameter("Colorrr");

		try {

			Class.forName(driverName);
			Connection con = DriverManager.getConnection(url, user, paassword);
			
			PrintWriter p = response.getWriter();
			
			
				String queryString = "insert into Cloth(Cloth_id,Brand_name,Material_typeid,Type_name,Color,Size) values (? , ?, ?, ?, ?, ?)";
				PreparedStatement ps = con.prepareStatement(queryString);
			//	ResultSet rs = ps.executeQuery();
			//	if (rs.next()) {
				ps.setString(1, cid);
				ps.setString(2, bname);
				ps.setString(3, mtypeid);
				ps.setString(4, tname);
				ps.setString(5, color);
				ps.setString(6, size);
				ps.executeUpdate();
				//response.sendRedirect("Successregister.jsp");
				p.println("<HTML><HEAD><TITLE>Successful</TITLE></HEAD><BODY bgcolor= #eb984e><h1 styl> Success!!  Admin has Stored in database</h1></body></html>");
				con.close();
				ps.close();


	//	}
		 
	//	else {
	//		p.println("<HTML><HEAD><TITLE>Successful</TITLE></HEAD><BODY bgcolor= #eb984e><h1 styl> Fail!! Failed</h1></body></html>");
		//}
		}
		catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	

	}

}


