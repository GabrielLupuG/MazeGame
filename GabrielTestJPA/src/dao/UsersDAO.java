package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Users;

public class UsersDAO {
	
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("unt");
	
	public UsersDAO() {
		
	}
	
	public void persistUsers(Users users) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(users);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void mergeUsers() {
		
	}
	
	public void removeUsers() {
		
	}

	public void persistDUser(Users user1) {
		// TODO Auto-generated method stub
		
	}

}
