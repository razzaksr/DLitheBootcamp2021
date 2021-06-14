package servlets.dlithe.strore;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DonwloadServlet
 */
@WebServlet("/download")
public class DonwloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonwloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String param=request.getParameter("id");
		int aid=Integer.parseInt(param);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dlithe","root","");
			
			String q="select * from store where app_id=?";
			PreparedStatement pre=con.prepareStatement(q);
			pre.setInt(1, aid);
			ResultSet set=pre.executeQuery();
			RequestDispatcher dis=request.getRequestDispatcher("home.jsp");
			if(set.next())
			{
				InputStream is=(InputStream)set.getBinaryStream("app");
				byte[] tmp=new byte[is.available()];
				File file=new File("C:\\Users\\ADMIN\\Downloads\\"+set.getString("app_name")+".txt");
				is.read(tmp);
				FileOutputStream fos=new FileOutputStream(file);
				fos.write(tmp);
				fos.close();
				String qry="update store set app_downloads=app_downloads+1 where app_id = ?";
				pre=con.prepareStatement(qry);
				pre.setInt(1, aid);
				int ack=pre.executeUpdate();
				if(ack!=0)
				{
					request.setAttribute("msg", aid+" app downloaded successfully");
				}
				else
				{
					request.setAttribute("msg", aid+" app not downloaded");
				}
			}
			else
			{
				request.setAttribute("msg", aid+" app not downloaded");
			}
			dis.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
