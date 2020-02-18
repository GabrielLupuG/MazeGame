package maze;

public class Direction {
	
	public final static int North = 0;
	public final static int East = 1;
	public final static int South = 2;
	public final static int West = 3;
	
	private final static String[] directionNames = {"north", "east", "south", "west"};
	
	private int value;
	
	public Direction() {
		value = 0;
	}
	
	public Direction (int value) {
		this.value = value;
	}
	
	public int getDirection() {
		return value;
	}
	
	public static String getDirectionName(int value) {
		return directionNames[value];
	}

}
