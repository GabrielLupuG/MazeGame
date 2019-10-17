package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Jobs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int JobId;
	private String title;
	private int minSal;
	private int maxSal;
	
	@ManyToOne()
	private Users users;
	
	public Jobs() {
		
	}
	
	public Jobs(String title,int minSal, int maxSal,Users users) {
		this.title = title;
		this.minSal = minSal;
		this.maxSal= maxSal;
		this.users= users;
		
	}

	public int getJobId() {
		return JobId;
	}

	public void setJobId(int jobId) {
		JobId = jobId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMinSal() {
		return minSal;
	}

	public void setMinSal(int minSal) {
		this.minSal = minSal;
	}

	public int getMaxSal() {
		return maxSal;
	}

	public void setMaxSal(int maxSal) {
		this.maxSal = maxSal;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
	

	
}
