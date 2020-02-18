// C15712195 Gabriel Lupu DT354/4
public class House {

	private int id;
	private String imageLocation;
	private String street;
	private String city;
	private int bedrooms;
	private int bathrooms;
	private double price;
	private double change;
	private String contactNo;
	
	/* Static integer used to count number of instances created. */
	public static int count = 0;
	
	/* Note the difference in the set of parameters - the id is now generated automatically 
	 * rather than being entered as a parameter. */
	public House(String street, String city, int bedrooms, int bathrooms, double price, String imageLocation, String contactNo) {
		/* Id for first record will be 1 and increases by 1 for each subsequent record. */
		this.id = ++count;
		this.street = street;
		this.city = city;
		this.bedrooms = bedrooms;
		this.bathrooms = bathrooms;
		this.price = price;
		this.change = 0.0;
		this.imageLocation = imageLocation;
		this.contactNo = contactNo;
	}
	
	public int getId() {
		return id;
	}
	
	public String getStreet() {
		return street;
	}
	
	public String getCity() {
		return city;
	}
	
	public int getBedrooms() {
		return bedrooms;
	}
	
	public int getBathrooms() {
		return bathrooms;
	}
	
	public double getPrice() {
		return price;
	}
	
	public double getChange() {
		return change;
	}
	
	public String getImageLocation() {
		return imageLocation;
	}
	
	public String getContactNo() {
		return contactNo;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setChange(double change) {
		this.change = change;
	}
	
}
