package maze;

import java.util.HashSet;
import java.util.Set;

public class Maze {
	
	private Set<Room> rooms = new HashSet<Room>();

	public Maze(){ 
		System.out.println("creating a Maze"); 
	}
	  
	void addRoom(Room r){ 
		if (!rooms.contains(r)){
	      rooms.add(r);
	    }
	}
	
}
