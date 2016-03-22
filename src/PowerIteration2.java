import java.util.Random;

/**
 * @author Abhishek
 * This class implements Power Iteration method to compute matrix multiplication.
 */
public class PowerIteration2 {
	
	static int len = 1000;
	
	static Random rn = new Random();

	public static void main(String[] args) {
		float A[][] = new float[len][len];
		for (int i=0; i<len; i++) {
			for (int j=0; j<=i; j++) {
				float a = rn.nextFloat();
				A[i][j] = a;
				A[j][i] = a;
			}
		}
		
		float b[] = new float[len];
		for (int j=0; j<len; j++) {
			float a = rn.nextFloat();
			b[j] = a;
		}
		
		float e0 = lengthOfVector(b);
		
		float[] eV0 = normalizeVector(b,e0);
		
		float[] appr = multipy(A, eV0);

		System.out.println("Final Eigen Value: "+powerIteration(A, appr, e0));
		
	}
	
	public static float powerIteration(float[][] A, float[] appr, float oldEigenValue) {
		float eigenValue = lengthOfVector(appr);
		float[] eigenVector = normalizeVector(appr, eigenValue);
		
		if (Math.abs(eigenValue - oldEigenValue) < .000001) {
			System.out.println(eigenValue);
			return eigenValue;
		} else {
			System.out.println(eigenValue);
			float[] nextAppr = multipy(A, eigenVector);
			return powerIteration(A, nextAppr, eigenValue);
		}
	}
	
	public static float[] multipy(float[][] A, float[] b) {
		float[] temp = new float[len]; 
		for (int i = 0; i<len; i++) {
			for (int j = 0; j<len; j++) {
				temp[i] +=A[j][i] * b[j];
			}
		}
		return temp;
	}
	
	public static float lengthOfVector(float[] b) {
		float sum=0; 
		for (int j=0; j<len; j++) {
			sum+= Math.pow(b[j], 2);
		}
		return (float) Math.sqrt(sum);
	}
	
	public static float[] normalizeVector(float[] b, float e) {
		for (int j=0; j<len; j++) {
			b[j]= b[j]/e;
		}
		return b;
	}
}
