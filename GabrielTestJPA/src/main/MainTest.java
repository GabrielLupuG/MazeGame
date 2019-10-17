package main;

import dao.DepartmentDAO;
import dao.JobsDAO;
import dao.UsersDAO;
import entities.Department;
import entities.Jobs;
import entities.Users;

public class MainTest {

	public MainTest() {
		
		
		Department department= new Department("Department of justice");
		DepartmentDAO departmentdao = new DepartmentDAO();
		departmentdao.persistDepartment(department);
		

		UsersDAO userdao = new UsersDAO();
		Users users = new Users("Gabriel", "Alexander", "Sofia", department );
		userdao.persistUsers(users);

		Department department1 = new Department("It");
		DepartmentDAO departmentdao1 = new DepartmentDAO();
		departmentdao1.persistDepartment(department1);
		
		Users User1 = new Users("John", "Ion", "Sifon", department1);
		UsersDAO userdao1 = new UsersDAO();
		userdao1.persistUsers(User1);
		
		
		Department department2 = new Department("Computer");
		DepartmentDAO departmentdao2 = new DepartmentDAO();
		departmentdao2.persistDepartment(department2);
		
		Users User2 = new Users("Robert", "e-mail@yahoo", "Pass", department2);
		UsersDAO userdao2 = new UsersDAO();
		userdao2.persistUsers(User2);

		Department department3 = new Department("School");
		DepartmentDAO departmentdao3 = new DepartmentDAO();
		departmentdao3.persistDepartment(department3);
		
		Users User3 = new Users("Oana", "email@yahoo", "Password", department1);
		UsersDAO userdao3 = new UsersDAO();
		userdao3.persistUsers(User3);
		
		

		Users userss= new Users("gabriel", "email@ya", "Pwd", department1);
		UsersDAO usersdao = new UsersDAO();
		usersdao.persistUsers(userss);
		
		Jobs jobs = new Jobs("Mechanic", 2000, 15,userss);
		JobsDAO jobsdao = new JobsDAO();
		jobsdao.persistJobs(jobs);


	}

	public static void main(String[] args) {
		new MainTest();
	}

}
