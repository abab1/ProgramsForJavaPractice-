
public class MergeSort {

	static Integer items[] = {11, 99, 44, 55, 22, 88, 77, 66, 33,
			99, 22, 33, 44, 55, 66, 77, 88, 0};
	static int workspace[] = new int[items.length];
	
	public static void main(String [] args) {
		mergeSort(0,items.length-1);
		for (Integer item : items) {
			System.out.println(item);
		}
		
	}
	
	public static void mergeSort(int lowerBound, int upperBound) {
		if (lowerBound == upperBound) {
			return;
		}
		int midPoint = (lowerBound + upperBound) / 2; 
		mergeSort(lowerBound, midPoint); 
		mergeSort(midPoint + 1, upperBound); 
		merge(workspace, lowerBound, midPoint+1, upperBound);
	}
	
	public static void merge(int[] workspace, int lowerBound, int pivot, int upperBound) {
		
		int i = lowerBound;
		int j = pivot;
		int k = 0;
		while (i<pivot && j<=upperBound) {
			if (items[i] <items[j]) {
				workspace[k++] = items[i++];
			} else {
				workspace[k++] = items[j++];
			}
		}
		while (i<pivot) {
			workspace[k++] = items[i++];
		}
		while (j<=upperBound) {
			workspace[k++] = items[j++];
		}
		for (int x = 0; x<upperBound-lowerBound+1; x++) {
			items[lowerBound + x] = workspace[x];
		}
		
	}
}
