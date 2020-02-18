package maze;

public class Wall extends MapSite {
	  
	private int wallNr;
	private static int wallCnt = 1;
	
	public Wall(){ 
	    wallNr = wallCnt++;
	    System.out.println("creating Wall #" + new Integer(wallNr).toString()); 
	}

	public String toString(){ 
		return "Wall #" + new Integer(wallNr).toString();
	}

}
