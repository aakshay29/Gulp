package customTools;

import java.math.BigDecimal;
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
		long average = 0;
		for(int i = 0; i < restaurantList.size(); i++){
			average += restaurantList.get(i).getRating();		
		}
		BigDecimal num = new BigDecimal(average/restaurantList.size());
		Gulprestaurant restaurant = DBGulpRestaurant.getRestaurantByID(restaurantID);
		restaurant.setAveragerating(num.longValue());
		DBGulpRestaurant.update(restaurant);
	}
	
	public static List<Gulprestaurantrating> getRatings(int restaurantID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		TypedQuery<Gulprestaurantrating> query = em.createQuery("SELECT g FROM Gulprestaurantrating g where g.gulprestaurant.id = :restaurantID", Gulprestaurantrating.class);
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
