package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String email;
	private String password;

	
	@ManyToOne()
	private Department department;
	
	public Users() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	public Users( String username, String email, String password, Department departments ) {

	
		this.username = username;
		this.email = email;
		this.password= password;
		this.department = departments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
		
	}
//	
//	public Department getDepartmet() {
//		return department;
//	}
	
//	public void setDepId(String Department, Department department) {
//		this.department= department;
//	}
	
	

	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
	      this.department = department;
	   }
	
	

}
