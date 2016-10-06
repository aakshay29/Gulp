

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
import model.Gulprestaurant;
import model.Gulprestaurantrating;
import model.Gulpuser;

/**
 * Servlet implementation class EnterGrade
 */
@WebServlet("/EnterRating")
public class EnterRating extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnterRating() {
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
		int rating = Integer.parseInt(request.getParameter("rating"));
		Gulpuser user = (Gulpuser) session.getAttribute("user");
		
		List<Gulprestaurant> restaurant = null;
		restaurant = DBGulpRestaurant.getRestaurantByID(restaurantID);
		
		Gulprestaurantrating rating2 = new Gulprestaurantrating();
		rating2.setRating(rating);
		rating2.setGulpuser(user);
		rating2.setGulprestaurant(restaurant.get(0));
		
		
		if(DBGulpRestaurant.isValidRestaurant(restaurantID) == true){
			DBGulpRestaurantRating.insertAndUpdate(rating2,restaurantID);
			//DBGulpRestaurantRating.insertAndUpdate(rating, restaurantID);
			//average = DBGrade.gbPostStudentAverage(studentID);
			//request.getSession().setAttribute("average", "Student("+studentID+") average: " + average);
			response.sendRedirect(request.getContextPath()+"/RestaurantList.jsp");
		}
		else{
			request.getSession().setAttribute("alert", "Restaurant Number does not exist");
			response.sendRedirect(request.getContextPath()+"/RestaurantList.jsp");
		}
	}

}
