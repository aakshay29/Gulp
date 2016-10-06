package customTools;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import UserData.DBUtil;
import model.Gulprestaurantreview;

public class DBGulpRestaurantReview {
	public static void insert(Gulprestaurantreview review) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(review);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}
	public static List<Gulprestaurantreview> getReviews(int restaurantID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		TypedQuery<Gulprestaurantreview> query = em.createQuery("SELECT g FROM Gulprestaurantreview g where g.gulprestaurant.id = :restaurantID", Gulprestaurantreview.class);
		query.setParameter("restaurantID", restaurantID);
		List<Gulprestaurantreview> reviewList = null;
		try {
			reviewList = query.getResultList();		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return reviewList;
	}
	public static Gulprestaurantreview getReviewsForID(int reviewID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		TypedQuery<Gulprestaurantreview> query = em.createQuery("SELECT g FROM Gulprestaurantreview g where g.id = :reviewID", Gulprestaurantreview.class);
		query.setParameter("reviewID", reviewID);
		Gulprestaurantreview review = null;
		try {
			review = query.getSingleResult();		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return review;
	}
	public static void update(Gulprestaurantreview review) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(review);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	public static List<Gulprestaurantreview> getReviewsForUser(int userID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		TypedQuery<Gulprestaurantreview> query = em.createQuery("SELECT g FROM Gulprestaurantreview g where g.gulpuser.id = :userID", Gulprestaurantreview.class);
		query.setParameter("userID", userID);
		List<Gulprestaurantreview> reviewList = null;
		try {
			reviewList = query.getResultList();		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return reviewList;
	}
}
