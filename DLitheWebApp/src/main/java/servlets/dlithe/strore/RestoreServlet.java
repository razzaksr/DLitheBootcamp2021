package servlets.dlithe.strore;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RestoreServlet
 */
@WebServlet("/restore")
public class RestoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int aid=Integer.parseInt(request.getParameter("id"));
		HttpSession session=request.getSession();
		ArrayList<Store> bin =(ArrayList<Store>) session.getAttribute("bin");
		RequestDispatcher dis=request.getRequestDispatcher("bin.jsp");
		Store temp=null;
		for(Store tmp:bin)
		{
			if(tmp.getApp_id()==aid)
			{
				temp=tmp;break;
			}
			else
			{
				request.setAttribute("msg", aid+" restore failed due to mismatch");
			}
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dlithe","root","");
			String qry="insert into store values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pre=con.prepareStatement(qry);
			pre.setInt(1, temp.getApp_id());pre.setString(2, temp.getApp_name());
			pre.setString(3,temp.getApp_by());pre.setString(4, temp.getApp_type());
			pre.setString(5, temp.getApp_category());pre.setDouble(6, temp.getApp_rating());
			pre.setInt(7, temp.getApp_downloads());pre.setBinaryStream(8, temp.getApp());
			pre.setBinaryStream(9, temp.getApp_image());pre.setDouble(10, temp.getApp_sum());
			int ack=pre.executeUpdate();
			if(ack!=0)
			{
				bin.remove(temp);
				request.setAttribute("msg", aid+" has restored and removed from bin");
			}
			else {
				request.setAttribute("msg", aid+" restore failed");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
