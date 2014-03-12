package com.db.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.db.entities.Favourite;

public class FavouriteDao {

		
		private static final String PERSISTENCE_UNIT_NAME = "EatIt";
		private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		
		public Favourite save(Favourite favourite) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			em.persist(favourite);
			
			em.getTransaction().commit();
			em.close();

			return favourite;
		}
		
		public Favourite load(int id) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			Favourite favourite = em.find(Favourite.class, id);
			
			em.getTransaction().commit();
			em.close();
			return favourite;
		}
		
		public List<Favourite> load() {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			List<Favourite> favourites = (List<Favourite>)em.createNamedQuery("findAllFavourite", Favourite.class).getResultList();
			
			em.getTransaction().commit();
			em.close();
			return favourites;
		}
		
		public void remove(int id) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			em.remove(em.getReference(Favourite.class, id));
			
			em.getTransaction().commit();
			em.close();
		}
		
		public Favourite update(Favourite favourite) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			em.merge(favourite);
			
			em.getTransaction().commit();
			em.close();
			return favourite;
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


