package com.db.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.db.entities.Feedback;

public class FeedbackDao {
		
		private static final String PERSISTENCE_UNIT_NAME = "EatIt";
		private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		
		public Feedback save(Feedback feedback) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			em.persist(feedback);
			
			em.getTransaction().commit();
			em.close();

			return feedback;
		}
		
		public Feedback load(int id) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			Feedback feedback = em.find(Feedback.class, id);
			
			em.getTransaction().commit();
			em.close();
			return feedback;
		}
		
		public List<Feedback> load() {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			List<Feedback> feedbacks = (List<Feedback>)em.createNamedQuery("findAllFeedbacks", Feedback.class).getResultList();
			
			em.getTransaction().commit();
			em.close();
			return feedbacks;
		}
		
		public void remove(int id) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			em.remove(em.getReference(Feedback.class, id));
			
			em.getTransaction().commit();
			em.close();
		}
		
		public Feedback update(Feedback feedback) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			em.merge(feedback);
			
			em.getTransaction().commit();
			em.close();
			return feedback;
		}
		
	/*	public static void main(String[] args) {
			Application application = new Application();
	        application.setId(1);
	        application.setName("app1");
	        Developer developer = new Developer();
	        developer.setId(70);
	        developer.setFirstName("apurva");
	        application.setDeveloper(developer);
			ApplicationDao dao = new ApplicationDao();

			application = dao.save(application);
			System.out.println(application);
			
			List<Application> vertices = dao.load();
			for(Application v:vertices)
				System.out.println(v);
			
			Application v5 = dao.load(5);
			System.out.println(v5);
		}*/
	}

