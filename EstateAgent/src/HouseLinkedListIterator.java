// C15712195 Gabriel Lupu DT354/4

import java.util.LinkedList;

public class HouseLinkedListIterator implements HouseIterator {

	LinkedList<House> houseChain = new LinkedList<House>();
	int currentPosition;

	public HouseLinkedListIterator(String[][] data) {
		for (int i = 0; i < data.length; i++) {
			houseChain.add(new House(data[i][0], data[i][1], Integer.parseInt(data[i][2]), 
					Integer.parseInt(data[i][3]), Double.parseDouble(data[i][4]), data[i][5], data[i][6]));
		}		
	}

	public boolean atBeginning() {
		return (currentPosition == 0);
	}
	
	public boolean atEnd() {
		return (currentPosition == (houseChain.size() - 1));
	}
	
	public House first() {
		currentPosition = 0;
		return houseChain.get(currentPosition);
	}

	public House last() {
		currentPosition = houseChain.size() - 1;
		return houseChain.get(currentPosition);	
	}

	public House next() {
		if (currentPosition < (houseChain.size() - 1))
			currentPosition++;
		return houseChain.get(currentPosition);	
	}

	public House prev() {
		if (currentPosition > 0)
			currentPosition--;
		return houseChain.get(currentPosition);					
	}

}
