package servlets.dlithe.strore;

import java.io.IOException;
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
 * Servlet implementation class UpdatePassword
 */
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePassword() {
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
		String us=request.getParameter("user");
		String ps=request.getParameter("pass");
		String conps=request.getParameter("conpass");
		if(ps.equals(conps))
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dlithe","root","");
				String qry="update users set user_pass=? where user_name=?";
				PreparedStatement pre=con.prepareStatement(qry);
				pre.setString(1, ps);pre.setString(2, us);
				int ack=pre.executeUpdate();
				RequestDispatcher dis=request.getRequestDispatcher("index.jsp");
				if(ack!=0)
				{
					request.setAttribute("info", us+" password reset done");
				}
				else
				{
					request.setAttribute("info", us+" password reset failed");
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
		else
		{
			RequestDispatcher dis=request.getRequestDispatcher("index.jsp");
			request.setAttribute("info", us+" password reset failed due to mismatch credentials");
			dis.forward(request, response);
		}
	}

}
