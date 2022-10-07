package game;
import java.util.Arrays;
import java.util.Scanner;

public class player {
	// Variables
	
	// I'm sure you can figure out what this mean
	public String name;
	
	private map map = new map();
	
	story story = new story();
	// Keeps tracks of how many actions the user has done
	public int turn = 0;
	
	// I'm sure you can figure out what these mean
	public int playerLevel = 0;
	public int[] playerLocation = {0,0};
	
	public Inventory inventory = new Inventory(false);
	
	
	// I'm sure you can figure out what these mean
	// Game loop
	public boolean alive = true;
	public boolean gameFinished = false;
	
	public player(){
		story.init();
	}

	
	public void action() {
		// Read what is happening TODO finish off the story and if there are any special locations
		story.readStory(map.currentLevel, playerLocation[0], playerLocation[1]);
		//Getting user input
		Scanner scanner = new Scanner(System.in);
		// Point to pass something into it
		System.out.println();
		String input = scanner.nextLine().trim();
		// Split commands by space
		String[] commands = input.split("\\s+");
		//Check for the action
		if (commands.length > 1) {
			if (commands[1] != null) {
				switch(commands[0].toLowerCase()) {
				// Movement
				// TODO add they can press wasd and it moves
				case "go":
				case "run":
				case "walk":
				case "travel":
					// Need to fix so player can't go out of bounds (working on rn)
					if(commands[1].toLowerCase().equals("east")) { 
						movement(1, 0);
						}
					else if (commands[1].toLowerCase().equals("west")) {
						movement(-1, 0);
						}
					else if (commands[1].toLowerCase().equals("north")) {
						movement(0, -1);
						}
					else if (commands[1].toLowerCase().equals("south")) {
						movement(0, 1);
						}
					else {
						System.out.println("You can't go " + commands[1]);
					}
					
					break;
				// Interaction
				case "grab":
					if (map.returnInventory().in(commands[1])) {
						System.out.println("You grab " + commands[1] + " from the ground and put it in your inventory.");
						inventory.add(map.returnInventory().get(commands[1]));
						// TODO remove from ground
						map.remove(commands[1]);
						turn++;
					}else {
						System.out.println("You can't grab " + commands[1] + " out of thin air.");
					}
					break;
				case "drop":
					if (inventory.in(commands[1])) {
						System.out.println("You drop " + commands[1] + " on to the ground.");
						// TODO pass Item object in instead of by name
						map.addToRoom(inventory.get(commands[1]));
						inventory.remove(commands[1]);
					}else {
						System.out.println("You can't drop " + commands[1]+ ", you don't have it.");
					}
					
					break;
				case "use":
					// Check if the item exists in the player inventory
					// Fix if player has nothing error
					if (inventory.in(commands[1])) {
						System.out.println("You use " + commands[1]);
						//Call and command or something
					}else {
						System.out.println("You search through your laptop bag but " + commands[1] + " isn't there.");
					}
					
					break;
				default:
					System.out.println("You can't do " + commands[0]);
					break;
				}
			}
		}else {
			// This part needs to look better
			if (commands[0].equalsIgnoreCase("inventory")) {
				System.out.println("Inventory: " + Arrays.toString(inventory.returnContents()));
			}else if (commands[0].equalsIgnoreCase("help")) {
				// Finish of this area with all the commands
				System.out.println("Avalible commands:"
						+ "\n\tGo + [NESW]"
						+"\n\tUp/ Down"
						+ "\n\tGrab + [ITEM]"
						+ "\n\tUse + [ITEM]"
						+ "\n\tInventory"
						+"\n\tLook"
						+"\n\tDrop + [ITEM]"
						);
			}else if (commands[0].equalsIgnoreCase("look")) {
				// Looks and gets the objects around in the same room
				if (map.returnInventory().length() == 0) {
					System.out.println("The room you are in is very empty, there it no point looking for more stuff.");
				}else {
					System.out.println(Arrays.toString(map.returnContents()));
				}
			}else if (commands[0].equals("up")) {
				// Limit up properly
				playerLocation[0] = 0;
				playerLocation[1] = 0;
				
				map.currentLevel++;
			}else if (commands[0].equals("down")) {
				if (map.currentLevel > 0) {
					playerLocation[0] = 0;
					playerLocation[1] = 0;
					
					map.currentLevel--;
				}else {
					System.out.println("You can't go down your not a miner.");
				}
				//TODO Remove this later this is for testing
			}else if (commands[0].equals("test")) {
				//System.out.println(Arrays.toString(inventory.returnContents()));
			}
			//TODO state of game
			// inventory
			// what rooms are unlocked
			// what room you are in
			// state of printers
			else {
				System.out.println("I don't know what " + commands[0]+ " means.");
			}
		}
		
		scanner.close();
	}
	// Moving the location of the player
	private void movement(int x, int y) {
		// Check if the new location y is valid
		if (playerLocation[1] + y < map.returnLevel().length && playerLocation[1] + y > -1 && playerLocation[0] + x <  map.returnLevel()[0].length && playerLocation[0] + x > -1) {
			// Check if new location is and empty space (literally) :)
			if (map.returnLevel()[playerLocation[1] + y][playerLocation[0] + x] == ' ') {
				// Only move if new location is empty and on map
				if (x != 0 && playerLocation[0] + x <  map.returnLevel()[0].length && playerLocation[0] + x > -1) {
					playerLocation[0] += x;
					turn++;
				}else {
					// the x at the end is for debugging
					//ngl idk why this is here i have no idea what would trigger it
					if (x != 0) {
						System.out.println("You can't walk off the out of the school you have a assignment to hand in. x");
					}
				}
				if (y != 0 && playerLocation[1] + y < map.returnLevel().length && playerLocation[1] + y > -1) {
					playerLocation[1] += y;
					turn++;
				}else {
					//ngl idk why this is here
					if (y != 0) {
						// the y at the end is for debugging
						System.out.println("You can't walk off the out of the school you have a assignment to hand in. y");
					}
				}
			}else {
				System.out.println("Walking into walls won't help with your english.");
			}
			
		}
		else {
			System.out.println("You cannot leave this place, the your english marks depends on it.");
		}
	} 
}
