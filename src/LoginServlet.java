

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBGulpRestaurant;
import customTools.DBGulpUser;
import model.Gulprestaurant;
import model.Gulpuser;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		request.getSession().setAttribute("alert", "");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String nextUrl;
		
		List<Gulprestaurant> restaurantList = null;
		
		if(DBGulpUser.isValidUser(username, password)){
			Gulpuser user = null;		
			user = DBGulpUser.getUserByUsername(username);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			int userID = (int) user.getId();
			session.setAttribute("userID", userID);		
			long userRole = user.getRole();
			session.setAttribute("userRole", userRole);		
			
			if(userRole == 1){
				nextUrl = "/AddRestaurants.jsp";	
			}
			else{
				restaurantList = DBGulpRestaurant.getRestaurantList();		
				session.setAttribute("restaurantList", restaurantList);
				nextUrl = "/RestaurantList.jsp";	
			}
		}
		else{	
			request.getSession().setAttribute("alert", "Incorrect username or password");
			nextUrl = "/Login.jsp";
		}
		response.sendRedirect(request.getContextPath()+nextUrl);
	}

}
