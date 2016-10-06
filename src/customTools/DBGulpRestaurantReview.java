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
}
