package game;
import java.util.HashMap;

public class story {
	
	private static HashMap<String, String> storyLocations = new HashMap<String, String>();
	
	
	public void init() {
		// Create the hash map and add the things to it
				// Format: [Level#] [x] [y]
				//storyLocations.put("0 0 0", "\nIt's Mondays morning 7:00 am, no one is at school yet.\nYour english assignment is due and it makes up a solid 60% of your grade.\nYou have finished it but you don't have a printer at home.\nYou enter the research centre in hopes to print it but when you try to print, and error that makes your blood run cold appears.\nNO PAPER");
				// Leave empty if there is nothing storyLocations.put("0 1 0", "");
	}
	public void readStory(int level, int x, int y){
		if (storyLocations.get(level +" " + x + " " + y) != null) {
			System.out.println(storyLocations.get(level +" " + x + " " + y));
		}
		// So that the text isn't too cramped together
		System.out.println();
	}
}
