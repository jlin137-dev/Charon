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
		
		boolean movementUnlocked = true;
		if (game.map.currentLevel == 1 && map.jblockUnlocked == false) {
				movementUnlocked = false;
			}
		else if (game.map.currentLevel == 3 && map.lockerUnlocked == false) {
				movementUnlocked = false;
		}
		else {
			movementUnlocked = true;
		}
		
		// Read what is happening TODO finish off the story and if there are any special locations
		story.readStory(game.map.currentLevel, playerLocation[0], playerLocation[1]);
		//Getting user input
		Scanner scanner = new Scanner(System.in);
		// Point to pass something into it
		String input = "";
		input = scanner.nextLine().trim();
		// Split commands by space
		String[] commands = input.split("\\s+");
		//test print
		//Check for the action
		if (commands.length > 1) {
			if (commands[1] != null) {
				String item = "";
				switch(commands[0].toLowerCase()) {
				// Movement
				// TODO add they can enter wasd and it moves
				case "go":
				case "run":
				case "walk":
				case "travel":
					// Need to fix so player can't go out of bounds (working on rn)
					
					if (movementUnlocked == true) {
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
					}
					else {
						System.out.println("The room is locked...\n walking into walls wont help you with English?");
					}
					
				// Interaction
					break;
				case "grab":
					for(int i = 1; i < commands.length - 1; i++) {
						item = item + commands[i] + " ";
					}
					item = item + commands[commands.length - 1];
					if (map.returnInventory().in(item)) {
						System.out.println("You grab " + item + " from the ground and put it in your inventory.");
						inventory.add(map.returnInventory().get(item));
						// TODO remove from ground
						map.remove(commands[1]);
						turn++;
					} else {
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
					for(int i = 1; i < commands.length - 1; i++) {
						item = item + commands[i] + " ";
					}
					item = item + commands[commands.length - 1];
					// Check if the item exists in the player inventory
					// Fix if player has nothing error
					if (inventory.in(item)) {
						switch(item.toLowerCase()) {
						case "laptop":
							Item laptop = inventory.get("laptop");
							switch(laptop.state(null)) {
							case "off":
								System.out.println("You turn on your laptop. You see the word document with your English\nessay. You stare at it.");
								laptop.state("on");
								break;
							case "on":
								if(laptop.state(null) == "") {
									
								} else {
									System.out.println("You keep staring at your English assignment. It isn't really effective... \nIf only there was a printer somewhere so I could actually hand it in...");
								}
								break;
							case "broken":
								System.out.println("The laptop breaks. \n\n\n");
								System.out.println("How the h");
								break;
							default:
								System.out.println("If you see this message someone messed up the spelling and now the game is broken.\nHopefully you're not Mr Venz");
								break;
							}
							break;
							
							
						case "j block key":
							map.jblockUnlocked = true;
							System.out.println("You use J block Key to unlock J Block");
							turn ++;
							break;
						case "locker code":
							System.out.println("You type the locker code... The locker unlocks");
							map.lockerUnlocked = true;
							break;
							//TODO fix item replace thing to state
						case "printer":
							if (inventory.in("paper") && inventory.in("laptop") && inventory.get("laptop").state(null) == "on") {
									inventory.add(map.returnInventory().get("unstapled assignment"));
									System.out.println("You load in your paper and press print...");
									System.out.println("The printer prints your assignment for you");
									System.out.println("Please use stapler to staple assignment. Oh wait you have no stapler on you");
									System.out.println("But you left a stapler in your locker");
									turn += 2;
									
							} else if (inventory.in("paper") && inventory.in("laptop") == false) {
								System.out.println("You load paper into the printer");
								System.out.println("Wait... what are you printing? Where's your laptop?");
								turn ++;
							}
							else {
								System.out.println("You need to get some paper to print on");
								System.out.println("Don't try break the printer... your english marks depend on it");
								turn ++;
							}
							break;
							
						case "cricuit boards":
							System.out.println("Ouuuuuuch..........");
							System.out.println(". \n\n\n");
							System.out.println("You wake up... did you electrute yourself?");
							System.out.println("You realise you just wasted half an hour");
							turn += 30;
							break;
						
						case "stapler":
							if (inventory.in("unstapled assignment")) {
								System.out.println("You staple your assignment");
								System.out.println("There, a printed, stapled assignment read for submission");
								inventory.add(map.returnInventory().get("stapled essay"));
							}
							else {
								System.out.println("You don't have the printed assignment to staple");
								System.out.println("You waste 1 of your 2 precious staples");
							}
							turn ++;
							break;
							
						
						
						
						}
						
						//Call and command or something
					}else {
						switch(commands[1]) {
						case "":
							break;
						default:
							System.out.println("You search through your laptop bag but " + commands[1] + " isn't there.");
							break;
						}
					}
					
					break;
				case "start":
					if(commands[1].equals("minesweeper")) {
						System.out.println("This is a debug command");
						try {
							new MineSweeperMain();
							game.MineSweeperMain.mineSweeper(Integer.parseInt(commands[2]), Integer.parseInt(commands[3]), Integer.parseInt(commands[4]));
						} catch (Exception e) {
							System.out.println("L wrong format.\nstart minesweeper WIDTH HEIGHT MINES_COUNT");
						}
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
				System.out.println(
						"\n\n if you manage to break your laptop, the school printer or something, good job, you can't hand in your english assignment anymore"
						
						+ "\n Restart the game \n \n"
						+ ""
						+"Avalible commands:"
						+ "\n\t* Go + [NESW]: Allows you to move within the level, up being north"
						+"\n\t* Up/ Down: Allows you to move across levels, like in a skyscraper"
						+ "\n\t* Grab + [ITEM]: Picks up the item and put it in your inventory"
						+ "\n\t* Use + [ITEM]: Use an item in your inventory. This may get rid of"
						+ "\n\tanother item in your inventory"
						+ "\n\t* Inventory: Check your inventory"
						+"\n\t* Look: Look around the room"
						+"\n\t* Drop + [ITEM]: Remove an item from your inventory"			
						);
			}else if (commands[0].equalsIgnoreCase("look")) {
				// Looks and gets the objects around in the same room
				if (map.returnInventory().length() == 0) {
					System.out.println("The room you are in is very empty, there is no point looking for more stuff.");
				}else {
					//TODO fix dupe glitch
					System.out.println("The current room contains:\n" + String.join(", ",map.returnContents()));
				}
				
			// current level vs player level?
			}else if (commands[0].equals("up")) {
				// Limit up properly
				playerLocation[0] = 0;
				playerLocation[1] = 0;
				//movementUnlocked = true;
				
				//TODO: fix up this
				//if (map.currentLevel+1 == 1 && map.jblockUnlocked == false) {
					//System.out.println("You arrive outside J block. You look around, but the door is locked");
					//System.out.println("Student service at A block won't be open this early, right?");
					//movementUnlocked = false;
					//TODO: movement locked
				//}
				//else if (map.currentLevel+1 == 3 && map.lockerUnlocked == false) {
					//System.out.println("You run back to your locker on the other side of the school");
					//System.out.println("Then, you realize you forgot your locker password \n But you remember you stored it on your phone at least…");
					//movementUnlocked = false;
				//}
				game.map.currentLevel++;
				System.out.println("You moved up a level to " + game.map.currentLevel);
				
				
				
			}else if (commands[0].equals("down")) {
				if (game.map.currentLevel > 0) {
					playerLocation[0] = 0;
					playerLocation[1] = 0;
					//movementUnlocked = true;
					
					//if (map.currentLevel-1 == 1 && map.jblockUnlocked == false) {
						//System.out.println("You arrive outside J block. You look around, but the door is locked");
						//System.out.println("Student service at A block won't be open this early, right?");
						//movementUnlocked = false;
					//}
					//else if (map.currentLevel-1 == 3 && map.lockerUnlocked == false) {
						//System.out.println("You run back to your locker on the other side of the school");
						//System.out.println("Then, you realize you forgot your locker password \n But you remember you stored it on your phone at least…");
						//movementUnlocked = false;
					//}
					game.map.currentLevel--;
					System.out.println("You moved down a level to " + game.map.currentLevel);
					
					
					
				}else {
					System.out.println("You can't go down you're not a miner.");
				}
			}else if (commands[0].equals("debug")) {
				Gamemain.debug = !Gamemain.debug;
				System.out.println(Gamemain.debug);
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
	}
	// Moving the location of the player
	private void movement(int x, int y) {
		// Check if the new location y is valid
		if (playerLocation[1] + y < map.returnLevel().length && playerLocation[1] + y > -1 && playerLocation[0] + x <  map.returnLevel()[0].length && playerLocation[0] + x > -1) {
			// Check if new location is and empty space (literally) :)
			if (map.returnLevel()[playerLocation[1] + y][playerLocation[0] + x] == " ") {
				// Only move if new location is empty and on map
				if (x != 0 && playerLocation[0] + x <  map.returnLevel()[0].length && playerLocation[0] + x > -1) {
					System.out.println(map.returnLevelMsg()[playerLocation[1] + y][playerLocation[0] + x]);
					playerLocation[0] += x;
					turn++;
				}else {
					// the x at the end is for debugging
					//ngl idk why this is here i have no idea what would trigger it
					if (x != 0) {
						System.out.println("You can't walk off the out of the school you have a assignment to hand in.");
					}
				}
				if (y != 0 && playerLocation[1] + y < map.returnLevel().length && playerLocation[1] + y > -1) {
					System.out.println(map.returnLevelMsg()[playerLocation[1] + y][playerLocation[0] + x]);
					playerLocation[1] += y;
					turn++;
				}else {
					//ngl idk why this is here
					if (y != 0) {
						// the y at the end is for debugging
						System.out.println("You can't walk off the out of the school you have a assignment to hand in.");
					}
				}
			}else if (map.returnLevel()[playerLocation[1] + y][playerLocation[0] + x] == "█") {
				System.out.println("Walking into walls won't help with your english.");
			} else {
				
			}
			
		}
		else {
			System.out.println("You cannot leave this place, the your english marks depends on it.");
		}
	} 
}
