

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customTools.DBGulpRestaurant;
import customTools.DBGulpUser;
import model.Gulprestaurant;
import model.Gulpuser;

/**
 * Servlet implementation class NewuserServlet
 */
@SuppressWarnings("unused")
@WebServlet("/NewuserServlet")
public class NewuserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewuserServlet() {
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
		String nextUrl="";
		String newname=request.getParameter("username");
		String newemail=request.getParameter("email");
		String newzip=request.getParameter("zipcode");
		String role =request.getParameter("role");
		String password = request.getParameter("password");
		
		
		Gulpuser user = new Gulpuser();
		user.setName(newname);
		user.setUsername(newname);
		user.setEmail(newemail);
		user.setRole(Long.parseLong(role));
		user.setPassword(password);
		user.setZipcode(newzip);
		
		DBGulpUser.insert(user);
		
		System.out.println("insert done");
		nextUrl="/Login.jsp";
		
		response.sendRedirect(request.getContextPath() + nextUrl);
	}

}
