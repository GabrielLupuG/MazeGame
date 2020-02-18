// C15712195 Gabriel Lupu DT354/4
public class HouseIteratorFactory {

	public HouseIteratorFactory() {
	
	}
	
	public static HouseIterator getIterator(int type, String[][] records) {
		if (type == 0) {
			return new HouseArrayIterator(records);		
		}
		if (type == 1)  {
			return new HouseArrayListIterator(records);		
		}
		if (type == 2) {
			return new HouseLinkedListIterator(records);		
		}
		return new HouseArrayIterator(records);
	}

}
