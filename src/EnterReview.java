

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
import model.Gulpuser;

/**
 * Servlet implementation class EnterReview
 */
@WebServlet("/EnterReview")
public class EnterReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnterReview() {
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
		String rating = request.getParameter("review");
		Gulpuser user = (Gulpuser) session.getAttribute("user");
		List<Gulprestaurant> restaurantList = null;
		Gulprestaurant restaurant = null;
		restaurant = DBGulpRestaurant.getRestaurantByID(restaurantID);
		int userID = (int) session.getAttribute("userID");
		
		Gulprestaurantreview review2 = new Gulprestaurantreview();
		review2.setReview(rating);
		review2.setGulpuser(user);
		review2.setGulprestaurant(restaurant);
		
		
		if(DBGulpRestaurant.isValidRestaurant(restaurantID) == true){
			
			List<Gulprestaurantrating> ratingList = null;
			ratingList = DBGulpRestaurantRating.getRatingsForUser(userID);
			session.setAttribute("ratingList", ratingList);	
			List<Gulprestaurantreview> reviewList = null;
			reviewList = DBGulpRestaurantReview.getReviewsForUser(userID);
			session.setAttribute("reviewList", reviewList);	
			
			DBGulpRestaurantReview.insert(review2);
			restaurantList = DBGulpRestaurant.getRestaurantList();		
			session.setAttribute("restaurantList", restaurantList);
			response.sendRedirect(request.getContextPath()+"/RestaurantList.jsp");
		}
		else{
			request.getSession().setAttribute("alert", "Restaurant Number does not exist");
			response.sendRedirect(request.getContextPath()+"/RestaurantList.jsp");
		}
	}

}
