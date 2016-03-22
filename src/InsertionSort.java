
public class InsertionSort {
	static Integer items[] = {88, 99, 44, 55, 22, 88, 77, 66, 33,
			99, 22, 33, 44, 55, 66, 77, 11, 0};

	public static void main(String [] args) {
		insertionSort();
		for (Integer item : items) {
			System.out.println(item);
		}
		
	}
	
	public static void insertionSort() {
		for (int offset = 1; offset<items.length; offset++) {
			int temp = items[offset];
			int index = offset;
			while(index>0 && items[index-1]>temp) {
				items[index] = items[index-1];
				--index;
			}
			items[index] = temp;
		}
	}

}
