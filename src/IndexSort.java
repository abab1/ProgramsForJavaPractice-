
/**
 * @author Abhishek
 * Class to find index sequence of an array
 */
public class IndexSort {
	
	public static void main(String[] args) {
		
		int data[] = {0,23, 46, 17, 98, 43, 67, 88, 78, 99,1};
		
		int[] index = new int[data.length];
		
		for (int i = 0; i< data.length; i++) {
			index[i] = i;
		}
		int [] index1 = sort (data, index, data.length);
		
		for (int j : index1) {
			System.out.println(j);
		}
	}
	
	public static int[] sort (int data[], int index[], int len) {
		int flag = 1;
		while (flag == 1) {
			flag = 0;
			for (int i = 0; i<len-1; i++ ) {
				if (data[index[i]] > data[index[i+1]]) {
					int temp = index[i+1];
					index[i+1] = index[i];
					index[i] = temp;
					flag = 1;
				}
			}
		}
		
		return index;
	}
	
	public static int sched(float startTime[], float endTime[], int indx[], int scheduled[], int len) {
		int counter = 0;
		scheduled[0] = indx[0];
		for (int i = 1; i<len; i++) {
			if(startTime[indx[i]] >= endTime[scheduled[counter]]) {
				scheduled[++counter] = indx[i];
			}
		}
		return counter;
	}

}
