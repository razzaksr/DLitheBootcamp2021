package servlets.dlithe.strore;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UploadApp
 */
@WebServlet("/upload")
public class UploadApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadApp() {
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
		String apple=request.getParameter("name");
		String banana=request.getParameter("type");
		String cupcake=request.getParameter("category");
		String donut=request.getParameter("app");
		String eclairs=request.getParameter("by");
		String froyo=request.getParameter("image");
		File file=new File(donut);
		InputStream is=new FileInputStream(file);
		InputStream is1=new FileInputStream(froyo);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dlithe","root","");
			String qry="insert into store(app_name,app_type,app_category,app_by,app,app_image) values(?,?,?,?,?,?)";
			PreparedStatement pre=con.prepareStatement(qry);
			pre.setString(1, apple);pre.setString(2, banana);pre.setString(3, cupcake);pre.setString(4, eclairs);
			pre.setBinaryStream(5, is);pre.setBinaryStream(6, is1);
			int ack=pre.executeUpdate();
			if(ack!=0)
			{
				RequestDispatcher dis=request.getRequestDispatcher("home.jsp");
				request.setAttribute("msg", apple+" uploaded successfully");
				dis.forward(request, response);
			}
			else
			{
				RequestDispatcher dis=request.getRequestDispatcher("uploadapp.jsp");
				request.setAttribute("msg", apple+" is not uploaded successfully");
				dis.forward(request, response);
			}
			is.close();is1.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
