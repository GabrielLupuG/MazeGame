package maze;

public class Door extends MapSite {
	  
	private static int doorCnt = 1; 
	private int doorNr;
	private Room room1; 
	private Room room2;
	
	public Door(Room r1, Room r2){ 
	    doorNr = doorCnt++;
	    System.out.println("creating a Door #" + doorNr + " between " + r1 + " and " + r2); 
	    room1 = r1;
	    room2 = r2;
	}
	
	public int getDoorNr() {
		return doorNr;
	}
	
	public Room getRoomOne() {
		return room1;
	}
	
	public Room getRoomTwo() {
		return room2;
	}
	  
	public String toString(){ 
	    return "Door #" + new Integer(doorNr).toString();
	}

}
