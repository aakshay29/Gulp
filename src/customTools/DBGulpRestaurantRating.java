package customTools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import UserData.DBUtil;
import model.Gulprestaurant;
import model.Gulprestaurantrating;

public class DBGulpRestaurantRating {
	public static void insertAndUpdate(Gulprestaurantrating rating, int restaurantID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(rating);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
		List<Gulprestaurantrating> restaurantList = getRatings(restaurantID);
		int average = 0;
		for(int i = 0; i < restaurantList.size(); i++){
			average += restaurantList.get(i).getRating();
			System.out.println("$$$$$$$$$: " + average);
		}
		average = average/restaurantList.size();
		List<Gulprestaurant> restaurant = DBGulpRestaurant.getRestaurantByID(restaurantID);
		Gulprestaurant resto = restaurant.get(0);
		resto.setAveragerating(average);
		DBGulpRestaurant.update(resto);
	}
	
	public static List<Gulprestaurantrating> getRatings(int restaurantID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		TypedQuery<Gulprestaurantrating> query = em.createQuery("SELECT g.rating FROM Gulprestaurantrating g where g.id = :restaurantID", Gulprestaurantrating.class);
		query.setParameter("restaurantID", restaurantID);
		List<Gulprestaurantrating> restaurantList = null;
		try {
			restaurantList = query.getResultList();		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return restaurantList;
	}
	
}
