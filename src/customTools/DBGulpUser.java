package customTools;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import UserData.DBUtil;
import model.Gulpuser;

public class DBGulpUser {
	public static boolean isValidUser(String username, String password) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select count(g) from Gulpuser g "
				+ "where g.username = :username and g.password = :userpass";
		TypedQuery<Long> q = em.createQuery(qString, Long.class);
		boolean result = false;
		q.setParameter("username", username);
		q.setParameter("userpass", password);

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
	
	public static Gulpuser getUserByUsername(String username) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Gulpuser u " + "where u.username = :username";
		TypedQuery<Gulpuser> q = em.createQuery(qString, Gulpuser.class);
		q.setParameter("username", username);
		Gulpuser user = null;
		try {
			user = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return user;

	}

	
		
		
		

		
		public static void insert(Gulpuser user) {
		    
			 EntityManager em = DBUtil.getEmFactory().createEntityManager();
			 EntityTransaction trans = em.getTransaction();
			 //System.out.println("DbBullhorn: begin transaction");
			 try {
			 trans.begin();
			 em.persist(user);
			 //System.out.println("DbBullhorn: commit transaction");
			 trans.commit();
			 } catch (Exception e) {
			 e.printStackTrace();
			 //System.out.println("DbBullhorn: rollback transaction");
			 trans.rollback();
			 } finally {
			 //System.out.println("DbBullhorn: close em");
			 em.close();
			 }
	}
	}

	
	
	
	
	

