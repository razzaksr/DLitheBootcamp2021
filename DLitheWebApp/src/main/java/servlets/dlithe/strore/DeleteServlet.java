package servlets.dlithe.strore;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/del")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String data=request.getParameter("id");
		int aid=Integer.parseInt(data);
		HttpSession session=request.getSession();
		ArrayList<Store> bin =(ArrayList<Store>) session.getAttribute("bin");
		RequestDispatcher dispatch=request.getRequestDispatcher("deleteapp.jsp");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dlithe","root","");
			String qry="select * from store where app_id=?";
			PreparedStatement ps=con.prepareStatement(qry);
			ps.setInt(1, aid);
			ResultSet set=ps.executeQuery();
			Store store=null;
			if(set.next())
			{
				store=new Store();
				store.setApp_by(set.getString("app_by"));
				store.setApp_category(set.getString("app_category"));
				store.setApp_downloads(set.getInt("app_downloads"));
				store.setApp_id(set.getInt("app_id"));
				store.setApp_image(set.getBinaryStream("app_image"));
				store.setApp(set.getBinaryStream("app"));
				store.setApp_name(set.getString("app_name"));
				store.setApp_rating(set.getDouble("app_rating"));
				store.setApp_sum(set.getDouble("app_sum"));
				store.setApp_type(set.getString("app_type"));
				bin.add(store);
				qry="delete from store where app_id=?";
				ps=con.prepareStatement(qry);
				ps.setInt(1, aid);
				int ack=ps.executeUpdate();
				if(ack!=0)
				{
					request.setAttribute("msg", aid+" has deleted");
				}
				else
				{
					request.setAttribute("msg", aid+" has not deleted yet");
				}
			}
			else
			{
				request.setAttribute("msg", aid+" has not deleted yet");
			}
			dispatch.forward(request, response);
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
		doGet(request, response);
	}

}
