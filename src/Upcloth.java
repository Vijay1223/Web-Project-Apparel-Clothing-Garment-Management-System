

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Upcloth
 */
@WebServlet("/Upcloth")
public class Upcloth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upcloth() {
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
		PrintWriter p = response.getWriter();
		response.setContentType("text/html");
		
		//String cloth_id = String.valueOf(request.getParameter("Cloth_idd"));
		//String brand_na = request.getParameter("Brand_namee");
		String material_ty = request.getParameter("Material_typeidd");
		String type_na = request.getParameter("Type_namee");
		String color = request.getParameter("Colorr");
		String size = request.getParameter("Sizee");	
		int attri = Integer.valueOf(request.getParameter("attribute"));
		String brand_na = request.getParameter("Brand_namee");
		try {
			if(brand_na!=null||material_ty!=null||type_na!=null||color!=null||size!=null)
			{
			Class.forName(driverName);
			Connection con = DriverManager.getConnection(url, user, paassword);
			String queryString1 = "update Cloth set Brand_name=?,Material_typeid=?,Type_name=?,Color=?,Size=? where Cloth_id=?";
			PreparedStatement ps1 = con.prepareStatement(queryString1);
			//ps1.setString(1, cloth_id);
			ps1.setString(1, brand_na);
			ps1.setString(2, material_ty);
			ps1.setString(3, type_na);
			ps1.setString(4, color);
			ps1.setString(5, size);
			ps1.setInt(6, attri);
			ps1.executeUpdate();
		
			p.println("<HTML><HEAD><TITLE>Successful</TITLE></HEAD><BODY bgcolor= #eb984e><h1 styl> Success!! updated  in database</h1></body></html>");
		ps1.close();
		con.close();

			}
			else {
				p.println("<HTML><HEAD><TITLE>Not Successful</TITLE></HEAD><BODY bgcolor= #eb984e><h1 styl> Failed!!in database</h1></body></html>");
			}
		}
		catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
}
}

