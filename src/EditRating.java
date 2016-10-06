

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBGulpRestaurant;
import customTools.DBGulpRestaurantRating;
import customTools.DBGulpRestaurantReview;
import model.Gulprestaurant;
import model.Gulprestaurantrating;
import model.Gulprestaurantreview;

/**
 * Servlet implementation class EditRating
 */
@WebServlet("/EditRating")
public class EditRating extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditRating() {
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
		int ratingID = Integer.parseInt(request.getParameter("ratingID"));
		int rating = Integer.parseInt(request.getParameter("rating"));
		
		Gulprestaurantrating rating2 = DBGulpRestaurantRating.getRatingsForID(ratingID);
		rating2.setRating(rating);
		DBGulpRestaurantRating.update(rating2);
		List<Gulprestaurant> restaurantList = null;
		HttpSession session = request.getSession();
		int userID = (int) session.getAttribute("userID");
		List<Gulprestaurantreview> reviewList = null;
		reviewList = DBGulpRestaurantReview.getReviewsForUser(userID);
		session.setAttribute("reviewList", reviewList);			
		List<Gulprestaurantrating> ratingList = null;
		ratingList = DBGulpRestaurantRating.getRatingsForUser(userID);
		session.setAttribute("ratingList", ratingList);	
		
		restaurantList = DBGulpRestaurant.getRestaurantList();		
		session.setAttribute("restaurantList", restaurantList);
		
		response.sendRedirect(request.getContextPath()+"/Profile.jsp");
	}

}
