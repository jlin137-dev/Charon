package game;

public class BlockA {

	
	public static void main (String[] args) {
		//Just rough layout, need to update to integrate into game
		// jumping over reception desk, getting key & chair should have a low time count.
		// searching drawers, unlocking drawer and smashing drawer should have higher time count.
		
		//simplified position system, placeholder user input
		int playerPos = 0;
		String userInput = "";
		
		//simplified inventory just for this level
		boolean hasB_Key = false;
		boolean hasChair = false;
		
		boolean B_Unlocked = false;
		boolean C_Unlocked = false;
		
		//System.out.println("You enter A block, the reception block");
		//System.out.println("In front of you, the reception desk is empty. There's a drawer behind the reception desk");
		//System.out.println("The reception desk blocks your way");
		
		
		if (userInput.equals( "Jump over desk")) {
			playerPos ++;
			System.out.println("You jumped over the reception desk");
			System.out.println("In front of you are three drawers, and a chair. A key lies on the floor");
			System.out.println("The left drawer, labelled A, is open");
			System.out.println("The middle drawer, labelled B, is locked");
			System.out.println("The right drawer, labelled C, is locked but has a glass door");
		}
		
		// gets the key for drawerB
		if (userInput.equals("get key") && playerPos > 0) { 
			System.out.println("You grab the key");
			hasB_Key = true;
		}
		
		if (userInput.equals("Unlock drawer B") && hasB_Key == true) {
			System.out.println("You unlock drawer B");
			B_Unlocked = true;
		}
		
		if (userInput.equals("Unlock drawer C") && hasB_Key == true) {
			System.out.println("You can not unlock this drawer with this key...");
		}
		
		// gets the chair to smash open C
		if (userInput.equals("grab chair") && playerPos > 0) {
			System.out.println("You pick up the chair");
			hasChair = true;
		}
		
		if (userInput.equals("Throw chair at drawer C") && hasChair == true) {
			System.out.println("You throw the chair at the glass door of drawer C. It breaks and drawer C unlocks. You can see a key in the drawer");
			C_Unlocked = true;
		}
		
		
		
		if (userInput.equals("search left drawer") || userInput.equals("Search drawer A")) {
			System.out.println("You search the drawer. There is nothing in there");
		}
		
		if (userInput.equals("Search drawer B") && B_Unlocked == true) {
			System.out.println("you search the drawer. There is nothing in there");
		}
		
		if (userInput.equals("Get key") && C_Unlocked == true || userInput.equals("Search drawer C") && C_Unlocked == true) {
			System.out.println("You search the drawer. You find a key labelled 'For use: J Block'");
			if (userInput.equals("Get key")) {
				System.out.println("You add the key to your inventory");
				// add key to inventory, can now unlock J block
			}
		}
		
		
		
	}
	
	
}
