package com.db.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.db.entities.Reservation;
import com.db.entities.Restaurant;
public class RestaurantDao {

		private static final String PERSISTENCE_UNIT_NAME = "EatIt";
		private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		
		public Restaurant save(Restaurant restaurant) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			em.persist(restaurant);
			
			em.getTransaction().commit();
			em.close();

			return restaurant;
		}
		
		public Restaurant loadbyName (String name) {
			System.out.println("ready");
			EntityManager em = factory.createEntityManager();
			String query=" FROM Restaurant r where r.name = :rewq";
			Query q=em.createQuery(query);
			q.setParameter("rewq", name);
			List<Restaurant> reser=q.getResultList();
			System.out.println(reser.get(0).getId());
			em.getTransaction().begin();
			em.getTransaction().commit();
			em.close();
			System.out.println("restaurant id is" +reser.get(0).getId());
            return (reser.get(0));
            
		}
		public Restaurant load(int id) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			Restaurant restaurant = em.find(Restaurant.class, id);
			
			em.getTransaction().commit();
			em.close();
			return restaurant;
		}
		
		public List<Restaurant> load() {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			List<Restaurant> restaurants = (List<Restaurant>)em.createNamedQuery("findAllResturants", Restaurant.class).getResultList();
			
			em.getTransaction().commit();
			em.close();
			return restaurants;
		}
		
		public void remove(int id) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			em.remove(em.getReference(Restaurant.class, id));
			
			em.getTransaction().commit();
			em.close();
		}
		
		public Restaurant update(Restaurant restaurant) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			em.merge(restaurant);
			
			em.getTransaction().commit();
			em.close();
			return restaurant;
		}
		
	public static void main(String[] args) {
		RestaurantDao reservationDao = new RestaurantDao();
		reservationDao.loadbyName("mcd");
		}
	}

