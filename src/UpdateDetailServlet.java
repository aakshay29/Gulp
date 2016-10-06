

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customTools.DBGulpRestaurant;
import model.Gulprestaurant;

/**
 * Servlet implementation class UpdateDetailServlet
 */
@WebServlet("/UpdateDetailServlet")
public class UpdateDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDetailServlet() {
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
		
		String name= request.getParameter("name");
		String address= request.getParameter("address");
		
		Gulprestaurant rest= new Gulprestaurant();
		rest.setName(name);
		rest.setAddress(address);			
		DBGulpRestaurant.update(rest);
		System.out.println("Insert done");
		String nextURL="/RestaurantList.jsp";
		response.sendRedirect(request.getContextPath()+nextURL);
	}

}
