package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Department;

public class DepartmentDAO {
	
	protected  static EntityManagerFactory emf = Persistence.createEntityManagerFactory("unt");
	
	public DepartmentDAO() {
		
	}

	public void persistDepartment(Department department) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(department);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void mergeDepartment() {
		
	}
	public void removeDepartment() {
		
	}
}
