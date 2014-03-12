package com.db.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.db.entities.Client;
import com.db.entities.Restaurant;

public class ClientDao {
		
		private static final String PERSISTENCE_UNIT_NAME = "EatIt";
		private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		
		public Client save(Client client) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			em.persist(client);
			
			em.getTransaction().commit();
			em.close();

			return client;
		}

	public boolean validateCredential(String userName,String password) {
		List<Client> clients = load();
		for (Client c : clients)
			if ((c.getUsername().equals(userName))
			  && (c.getPassword().equals(password)))
				return true;
		
		return false;

	}
		
		public boolean validate(Client client){
			
			List<Client> clients= load();
			for(Client c: clients)
				{
				if(client.getUsername().equals(c.getUsername()))
				 return false;	
				}
			return true;
					
		
		}
		
		public Client load(int id) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			Client client = em.find(Client.class, id);
			
			em.getTransaction().commit();
			em.close();
			return client;
		}	
		
		public List<Client> load() {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			List<Client> clients = (List<Client>)em.createNamedQuery("findAllClients", Client.class).getResultList();
			
			em.getTransaction().commit();
			em.close();
			return clients;
		}
		
		public void remove(int id) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			em.remove(em.getReference(Client.class, id));
			
			em.getTransaction().commit();
			em.close();
		}
		
		public Client update(Client client) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();

			em.merge(client);
			
			em.getTransaction().commit();
			em.close();
			return client;
		}
		public Client loadbyName(String userName) {
			System.out.println("ready");
			EntityManager em = factory.createEntityManager();
			String query=" FROM Client r where r.username = :rewq";
			Query q=em.createQuery(query);
			q.setParameter("rewq", userName);
			List<Client> reser=q.getResultList();
			System.out.println(reser.get(0).getId());
			em.getTransaction().begin();
			em.getTransaction().commit();
			em.close();
			System.out.println("client id is" + reser.get(0).getId());
			 return (reser.get(0));
            
			
		}
		
		public static void main(String[] args) {
			Client client= new Client();
			client.setUsername("mon");
			ClientDao clientDao = new ClientDao();
			clientDao.loadbyName("mon");
			//clientDao.save(client);
			clientDao.validate(client);
			
			
		}
		
		

	
	}

	

