
public class SpecialPalindrome {
	
	public static void main(String [] args) {
	
		String str1 = "pal#^in&dr!ome";
		String str2 = "emo@rdni%l)ap";
		
		str1 = str1.replaceAll("[!@$#%^&*()]", "");
		str2 = str2.replaceAll("[!@$^%#&*()]", "");
		
		if (str1.length() != str2.length()){
			System.out.println("not a palindrome");
		} else {
			for (int i = 0; i< str1.length(); i++)  {
				if (str1.charAt(i) != str2.charAt(str1.length() - 1 -i)) {
					System.out.println("Not a Palindrome");
					return;
				}
			}
			System.out.println("Palindrome");
		}
	}
		

}
