
public class SelectionSort {
	
	public static void main(String [] args) {
		
		Integer items[] = {88, 99, 44, 55, 22, 88, 77, 66, 33,
				99, 22, 33, 44, 55, 66, 77, 11, 0};
		selectionSort(items, 0);
		for (Integer item : items) {
			System.out.println(item);
		}
		
	}
	
	public static void selectionSort(Integer items[], int offset) {
		int min=items[offset];
		int minIndex = offset;
		for (int i = offset+1; i<items.length;i++) {
			if (items[i]<min) {
				min = items[i];
				minIndex = i;
			}
		}
		int temp = items[offset];
		items[offset] = min;
		items[minIndex] = temp;
		if (offset < items.length-1) {
			selectionSort(items, ++offset);
		}
		return;
	}
}
