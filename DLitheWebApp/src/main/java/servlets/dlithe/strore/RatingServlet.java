package servlets.dlithe.strore;

import java.io.IOException;
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
 * Servlet implementation class RatingServlet
 */
@WebServlet("/rating")
public class RatingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RatingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String param1=request.getParameter("id");
		String param2=request.getParameter("rate");
		int aid=Integer.parseInt(param1);
		double arate=Double.parseDouble(param2);
		//System.out.println(arate+" is received for "+aid );
		RequestDispatcher dispatch=request.getRequestDispatcher("home.jsp");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dlithe","root","");
			String qry="update store set app_sum=app_sum+? where app_id=?";
			PreparedStatement pre=con.prepareStatement(qry);
			pre.setDouble(1, arate);pre.setInt(2, aid);
			int ack=pre.executeUpdate();
			if(ack!=0)
			{
				qry="select * from store where app_id=?";
				pre=con.prepareStatement(qry);pre.setInt(1,aid);
				ResultSet set=pre.executeQuery();
				if(set.next())
				{
					int count=set.getInt("app_downloads");
					double sum=set.getDouble("app_sum");
					double avg=sum/count;
					qry="update store set app_rating=? where app_id=?";
					pre=con.prepareStatement(qry);pre.setDouble(1, avg);pre.setInt(2, aid);
					int ak=pre.executeUpdate();
					if(ak!=0)
					{
						request.setAttribute("msg", aid+" App rated successfully");
					}
					else
					{
						request.setAttribute("msg", aid+" App rating failed");
					}
				}
				else {request.setAttribute("msg", aid+" App rating failed");}
			}
			else{request.setAttribute("msg", aid+" App rating failed");}
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
