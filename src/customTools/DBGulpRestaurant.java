package customTools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import UserData.DBUtil;

import model.Gulprestaurant;

public class DBGulpRestaurant {
	public static List<Gulprestaurant> getRestaurantList() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		TypedQuery<Gulprestaurant> query = em.createQuery("SELECT g FROM Gulprestaurant g", Gulprestaurant.class);
		List<Gulprestaurant> restaurantList = null;
		try {
			restaurantList = query.getResultList();		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return restaurantList;
	}
	public static Gulprestaurant getRestaurantByID(int restaurantID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		TypedQuery<Gulprestaurant> query = em.createQuery("SELECT g FROM Gulprestaurant g where g.id = :restaurantID", Gulprestaurant.class);
		query.setParameter("restaurantID", restaurantID);
		Gulprestaurant resto = null;
		try {
			resto = query.getSingleResult();		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return resto;
	}
	public static long getRestaurantAverageRating(int restaurantID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		TypedQuery<Gulprestaurant> query = em.createQuery("SELECT g FROM Gulprestaurant g where g.id = :restaurantID", Gulprestaurant.class);
		query.setParameter("restaurantID", restaurantID);
		List<Gulprestaurant> restaurantList = null;
		long averageRating = 0;
		try {
			restaurantList = query.getResultList();		
			averageRating = 0;
			int numberOfRatings = restaurantList.get(0).getGulprestaurantratings().size();
			for(int j = 0; j < numberOfRatings; j++){
				//averageRating += Integer.parseInt(restaurantList.get(0).getGulprestaurantratings().get(j).getRating().toString());
			}
			averageRating = averageRating/numberOfRatings;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return averageRating;
	}
	public static int getAverageRating(int restaurantID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		TypedQuery<Gulprestaurant> query = em.createQuery("SELECT g.averagerating FROM Gulprestaurant g where g.id = :restaurantID", Gulprestaurant.class);
		query.setParameter("restaurantID", restaurantID);
		int average = 0;
		try {
			average = query.getFirstResult();
			System.out.println("AAAVVGGGGGGGG: " + average);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return average;
	}
	public static void update(Gulprestaurant restaurant) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(restaurant);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	public static boolean isValidRestaurant(int restaurantID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT count(g) FROM Gulprestaurant g "
				+ "where g.id = :restaurantID";
		TypedQuery<Long> q = em.createQuery(qString, Long.class);
		boolean result = false;
		q.setParameter("restaurantID", restaurantID);

		try {
			long userId = q.getSingleResult();
			if (userId > 0) {
				result = true;
			}
		} catch (Exception e) {

			result = false;
		} finally {
			em.close();
		}
		return result;

	}
	public static void insert(Gulprestaurant restaurant) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(restaurant);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
}
}
