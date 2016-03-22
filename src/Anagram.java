
public class Anagram {
	
public static String str = "cat";

	public static void main(String args[]) {
		anagram("", "caty");
	}
	
	public static void anagram(String perm, String anagram) {
		if (anagram.isEmpty()) {
			System.out.println(perm);
		} else {
			for (int i=0; i<anagram.length(); i++) {
				anagram(perm + anagram.charAt(i), anagram.substring(0,i)+anagram.substring(i+1, anagram.length()) );
			}
		}	
	}

}
