
/**
 * @author Abhishek
 */
public class Combination {

	public static char[] players = {'A', 'B', 'C', 'D', 'E', 'F'};
	
	public static void main(String[] args) {
		
		makeTeam("",3,0);
	}
	
	/**
	 * Prints all possible combinations of a particular size.
	 */
	public static void makeTeam(String team, int size, int index) {
		if (team.length() == size) {
			System.out.println(team);
			return;
		}
		for (int i=index; i<players.length; i++) {
			makeTeam(team +players[i], 3, i+1);
		}
	}
}
