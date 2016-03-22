
public class BinarySearch {
	
	public static int[] items = {1, 23, 35, 44, 56, 67, 78, 89, 90,101};
	
	public static void main(String[] args) {
		System.out.println(binarySearch(0, items.length-1, 90));
	}
	
	public static int binarySearch(int lowerBound, int upperBound, int key) {
		int index = (lowerBound + upperBound)/2;
		if (lowerBound> upperBound) {
			return -1;
		}
		if (items[index] == key) {
		} else if (items[index] < key) {
			index = binarySearch(index+1, upperBound, key);
		} else if (items[index] > key) {
			index =  binarySearch(lowerBound, index-1, key);
		}
		return index;
	}
	
	
	

}
