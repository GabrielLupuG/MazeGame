package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Jobs;

public class JobsDAO {
	protected  static EntityManagerFactory emf = Persistence.createEntityManagerFactory("unt");
	
	public JobsDAO() {
		
	}
	
public void persistJobs(Jobs jobs) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(jobs);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void mergeDepartment() {
		
	}
	public void removeDepartment() {
		
	}

}