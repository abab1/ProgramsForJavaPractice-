
public class BubbleSort {

	public static void main(String [] args) {
		
		Integer items[] = {11, 99, 44, 55, 22, 88, 77, 66, 33,
				99, 22, 33, 44, 55, 66, 77, 88, 0};
		bubbleSort(items, items.length -1);
		for (Integer item : items) {
			System.out.println(item);
		}
		
	}
	
	public static void bubbleSort(Integer items[], int offset) {
		for (int i = 0; i<offset; i++) {
			if(items[i] > items[i+1] ) {
				int temp = items[i+1];
				items[i+1] = items[i];
				items[i] = temp;
			}
		}
		if (offset > 1) {
			bubbleSort(items, --offset);
		}
		return;
	}
	
}
