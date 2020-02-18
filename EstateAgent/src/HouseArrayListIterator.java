// C15712195 Gabriel Lupu DT354/4

import java.util.ArrayList;

public class HouseArrayListIterator implements HouseIterator {

	ArrayList<House> houseList = new ArrayList<House>();
	int currentPosition;

	public HouseArrayListIterator(String[][] data) {
		for (int i = 0; i < data.length; i++) {
			houseList.add(new House(data[i][0], data[i][1], Integer.parseInt(data[i][2]), 
					Integer.parseInt(data[i][3]), Double.parseDouble(data[i][4]), data[i][5], data[i][6]));
		}		
	}

	public boolean atBeginning() {
		return (currentPosition == 0);
	}
	
	public boolean atEnd() {
		return (currentPosition == (houseList.size() - 1));
	}
	
	public House first() {
		currentPosition = 0;
		return houseList.get(currentPosition);
	}

	public House last() {
		currentPosition = houseList.size() - 1;
		return houseList.get(currentPosition);	
	}

	public House next() {
		if (currentPosition < (houseList.size() - 1))
			currentPosition++;
		return houseList.get(currentPosition);	
	}

	public House prev() {
		if (currentPosition > 0)
			currentPosition--;
		return houseList.get(currentPosition);					
	}

}
