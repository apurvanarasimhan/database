package com.db.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.db.entities.Databasemanager;

public class DatabaseManagerDao {
	
		
		private static final String PERSISTENCE_UNIT_NAME = "EatIt";
		private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		
		public Databasemanager save(Databasemanager database) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			em.persist(database);
			
			em.getTransaction().commit();
			em.close();

			return database;
		}
		
		public Databasemanager load(int id) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			Databasemanager database= em.find(Databasemanager.class, id);
			
			em.getTransaction().commit();
			em.close();
			return database;
		}
		
		public List<Databasemanager> load() {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			List<Databasemanager> databases = (List<Databasemanager>)em.createNamedQuery("findAllDatabasemanager", Databasemanager.class).getResultList();
			
			em.getTransaction().commit();
			em.close();
			return databases;
		}
		
		public void remove(int id) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			em.remove(em.getReference(Databasemanager.class, id));
			
			em.getTransaction().commit();
			em.close();
		}
		
		public Databasemanager update(Databasemanager database) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			em.merge(database);
			
			em.getTransaction().commit();
			em.close();
			return database;
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


