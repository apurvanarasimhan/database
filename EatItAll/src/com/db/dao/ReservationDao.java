package com.db.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.db.entities.Reservation;
public class ReservationDao {
		
		private static final String PERSISTENCE_UNIT_NAME = "EatIt";
		private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		
		public Reservation save(Reservation reservation) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			em.persist(reservation);
			
			em.getTransaction().commit();
			em.close();

			return reservation;
		}
		
		public Reservation load(int id) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			Reservation reservation = em.find(Reservation.class, id);
			
			em.getTransaction().commit();
			em.close();
			return reservation;
		}
		
		
		
		public List<Reservation> load() {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			List<Reservation> reservations = (List<Reservation>)em.createNamedQuery("findAllReservation", Reservation.class).getResultList();
			
			em.getTransaction().commit();
			em.close();
			return reservations;
		}
		
		public void remove(int id) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			em.remove(em.getReference(Reservation.class, id));
			
			em.getTransaction().commit();
			em.close();
		}
		
		public Reservation update(Reservation reservation) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			em.merge(reservation);
			
			em.getTransaction().commit();
			em.close();
			return reservation;
		}
		
		public static void main(String[] args) {
			
		}
	}


