package game;
import java.util.HashMap;

public class Story {
	
	private static HashMap<String, String> storyLocations = new HashMap<String, String>();
	
	
	public void init() {
		// Create the hash map and add the things to it
				// Format: [Level#] [x] [y]
				//storyLocations.put("0 0 0", "\nIt's Mondays morning 7:00 am, no one is at school yet.\nYour english assignment is due and it makes up a solid 60% of your grade.\nYou have finished it but you don't have a printer at home.\nYou enter the research centre in hopes to print it but when you try to print, and error that makes your blood run cold appears.\nNO PAPER");
				// Leave empty if there is nothing storyLocations.put("0 1 0", "");
		
		// J block
		storyLocations.put("1, 0, 0", "You arrive outside J block.  \n Student service at A block won't be open this early, right?");
		storyLocations.put("1, 0, 1", "You arrive outside J block, and use your key to open the door. \n the door unlocks \n you see papers on a desk");
		// A block
		storyLocations.put("2, 0, 0", "You arrive at the reception gate. No one is inside. But the sliding door opens \n"
				+ "You step inside A block. The reception desk stands in front of you, blocking your way\n"
				+"Behind, you can see 3 drawers. Maybe these have paper?");
		storyLocations.put("2, 0, 1", "You enter A block, the reception block \n In front of you, the reception desk is empty. There's a drawer behind the reception desk \n The reception desk blocks your way");
		// Lockers
		storyLocations.put("3, 0, 0", "You run back to your locker on the other side of the school"
				+ "\nYou find 3 identical lockers… which one is your locker?"
				+ "\nWhats your locker password?"
				+"\nBut you remember you stored it on your phone at least…");
		//Oval
		storyLocations.put("4, 0, 0", "Have you found your charger yet?");
		storyLocations.put("4, 0, 1", "You arrive at the courtyard to search for a charger \n "
				+ "Just then, someone from soccer training across the road kicks a soccer ball past your head \n"
				+ "It lands on the oval \n"
				+ "Bang!\n"
				+ "A mine explodes, and sends you flying backwards\n"
				+ "It seems like the school mined the oval… You're going to have to un-mine the oval to find the charger..."
				+ "\n Move south to start minesweeper");
		//
		storyLocations.put("5, 0, 0", null);
		
	}
	public void readStory(int level, int x, int y){
		if (storyLocations.get(level +", " + x + ", " + y) != null) {
			System.out.println(storyLocations.get(level +", " + x + ", " + y));
		}
		// So that the text isn't too cramped together
		System.out.println();
	}
}
