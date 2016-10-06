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
	public static void update(Gulprestaurantrating rating) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(rating);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
//		Gulprestaurantrating getRestaurant = getRatingsForID(rating.getId());
//		List<Gulprestaurantrating> restaurantList = getRatings((int) getRestaurant.getId());
//		long average = 0;
//		for(int i = 0; i < restaurantList.size(); i++){
//			average += restaurantList.get(i).getRating();		
//		}
//		int size = restaurantList.size();
//		if(size == 0){
//			size = 1;
//		}
//		BigDecimal num = new BigDecimal(average/size);
//		Gulprestaurant restaurant = DBGulpRestaurant.getRestaurantByID((int) getRestaurant.getId());
//		restaurant.setAveragerating(num.longValue());
//		DBGulpRestaurant.update(restaurant);
		
	}
	public static Gulprestaurantrating getRatingsForID(long ratingID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		TypedQuery<Gulprestaurantrating> query = em.createQuery("SELECT g FROM Gulprestaurantrating g where g.id = :ratingID", Gulprestaurantrating.class);
		query.setParameter("ratingID", ratingID);
		Gulprestaurantrating restaurant = null;
		try {
			restaurant = query.getSingleResult();		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return restaurant;
	}
	
	public static List<Gulprestaurantrating> getRatingsForUser(int userID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		TypedQuery<Gulprestaurantrating> query = em.createQuery("SELECT g FROM Gulprestaurantrating g where g.gulpuser.id = :userID", Gulprestaurantrating.class);
		query.setParameter("userID", userID);
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
