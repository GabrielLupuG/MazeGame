// C15712195 Gabriel Lupu DT354/4

public class HouseArrayIterator implements HouseIterator {

	House[] houseArray;
	int currentPosition;

	public HouseArrayIterator(String[][] data) {

		houseArray = new House[data.length];
		for (int i = 0; i < data.length; i++) {
			houseArray[i] = new House(data[i][0], data[i][1], Integer.parseInt(data[i][2]), 
					Integer.parseInt(data[i][3]), Double.parseDouble(data[i][4]), data[i][5], data[i][6]);
		}		
	}

	public boolean atBeginning() {
		return (currentPosition == 0);
	}
	
	public boolean atEnd() {
		return (currentPosition == (houseArray.length - 1));
	}

	
	public House first() {
		currentPosition = 0;
		return houseArray[currentPosition];
	}

	public House last() {
		currentPosition = houseArray.length - 1;
		return houseArray[currentPosition];
	}

	public House next() {
		if (currentPosition < (houseArray.length - 1))
			currentPosition++;
		return houseArray[currentPosition];
	}

	public House prev() {
		if (currentPosition > 0)
			currentPosition--;
		return houseArray[currentPosition];
	}

}
