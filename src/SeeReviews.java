

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBGulpRestaurant;
import customTools.DBGulpRestaurantReview;
import model.Gulprestaurantreview;

/**
 * Servlet implementation class SeeReviews
 */
@WebServlet("/SeeReviews")
public class SeeReviews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeeReviews() {
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
		HttpSession session = request.getSession();
		int restaurantID = Integer.parseInt(request.getParameter("restaurantID"));
		
		List<Gulprestaurantreview> rev = null;
		
		if(DBGulpRestaurant.isValidRestaurant(restaurantID) == true){
			rev = DBGulpRestaurantReview.getReviews(restaurantID);
			session.setAttribute("rev", rev);
			response.sendRedirect(request.getContextPath()+"/ReviewList.jsp");
		}
		else{
			request.getSession().setAttribute("alert", "Restaurant Number does not exist");
			response.sendRedirect(request.getContextPath()+"/RestaurantList.jsp");
		}
	}

}
