package game;
import java.util.Arrays;
import java.util.Scanner;

public class Player {
	// Variables
	
	// I'm sure you can figure out what this mean
	public String name;
	
	private Map map = new Map();
	Story story = new Story();
	// Keeps tracks of how many actions the user has done
	public static int turn = 0;
	
	// I'm sure you can figure out what these mean
	public int playerLevel = 0;
	public int[] playerLocation = {0,0};
	
	public static Inventory inventory = new Inventory(false);
	
	
	// I'm sure you can figure out what these mean
	// Game loop
	public boolean alive = true;
	public boolean gameFinished = false;
	
	public static String TurnTime () {
		int NumTurn = turn;
		int timer = NumTurn;
		boolean MoreThanEight = false;
		String returnVal = "";
		if (NumTurn < 60) {
			timer = NumTurn;
		} else {
			timer = NumTurn - 60;
			MoreThanEight = true;
		}
		
		if (MoreThanEight == false) {
			if (timer < 10) {
				returnVal = "7:0"+timer;
			} else {
				returnVal = "7:"+timer;
			}
		} else if (MoreThanEight == true) {
			if (timer < 10) {
				returnVal = "8:0"+timer;
			} else {
				returnVal = "8:"+timer;
			}
		}
		
		return returnVal;
	}
	
	public Player(){
		story.init();
	}

	
	public void action() {
		boolean movementUnlocked = true;
		if (game.Map.currentLevel == 1 && map.jblockUnlocked == false) {
				movementUnlocked = false;
			}
		else if (game.Map.currentLevel == 3 && map.lockerUnlocked == false) {
				movementUnlocked = false;
		} else if (game.Map.currentLevel == 4 && map.OvalCleared == true) {
			movementUnlocked = false;
			System.out.println("The oval is clear! Let's print your english assignment");
		}
		else {
			movementUnlocked = true;
		}
		if (turn > 90) {
			System.out.println("The clock outside strikes 8:30");
			System.out.println("Your assignment is overdue");
			System.out.println("60% of your english grade goes down the drain");
			System.out.println("Game over");
			gameFinished = true;
			alive = false;
		}
		
		if (game.Map.currentLevel == 4 && playerLocation[1] == 2) {
			game.MineSweeperMain.mineSweeper(8, 8, 10);
			System.out.println("The oval is unmined. You dig around for a bit, and find your charger!");
			System.out.println("You leave the oval, and lock the door to its entrance");
			map.OvalCleared = true;
			inventory.add(map.returnInventory().get("charger"));
			playerLocation[1] = 0;
		}
		
		// Read what is happening
		story.readStory(game.Map.currentLevel, playerLocation[0], playerLocation[1]);
		//Getting user input
		Scanner scanner = new Scanner(System.in);
		System.out.print("- ");
		// Point to pass something into it
		String input = "";
		input = scanner.nextLine().trim();
		// Split commands by space
		String[] commands = input.split("\\s+");
		//Check for the action
		if (commands.length > 1) {
			TextAnimation.StatusBar(name);	//show status bar
			if (commands[1] != null) {
				String item = "";
				for(int i = 1; i < commands.length - 1; i++) {
					item = item + commands[i] + " ";
				}
				item = item + commands[commands.length - 1];
				switch(commands[0].toLowerCase()) {
				// Movement
				// TODO add they can enter wasd and it moves
				case "go":
				case "run":
				case "walk":
				case "travel":
					// Need to fix so player can't go out of bounds (working on rn)
					if (movementUnlocked == true) {
						if(item.toLowerCase().equals("east")) { 
							movement(1, 0);
							}
						else if (item.toLowerCase().equals("west")) {
							movement(-1, 0);
							}
						else if (item.toLowerCase().equals("north")) {
							movement(0, -1);
							}
						else if (item.toLowerCase().equals("south")) {
							movement(0, 1);
							}
						else {
							System.out.println("You can't go '" + item + "', only north, south, east or west.");
						}
						
					}
					else {
						System.out.println("You bump into a locked door. Be glad no one's here, you looked very stupid doing that.");
					}
					break;
				case "grab":
					if (movementUnlocked == true) {
					if (map.returnInventory().in(item)) {
						System.out.println("You grab " + item + " from the ground and put it in your inventory.");
						inventory.add(map.returnInventory().get(item));
						// TODO remove from ground
						map.remove(commands[1]);
						turn++;
					} else {
						System.out.println("You can't grab '" + item + "' out of thin air.");
					}
					} else {
						System.out.println("The room is locked. Read the instructions again");
					}
					break;
				case "drop":	//Drop the item from player inventory to level inventory
					if (inventory.in(item)) {
						System.out.println("You drop '" + item + "' on to the ground.");
						// TODO pass Item object in instead of by name
						map.addToRoom(inventory.get(item));
						inventory.remove(item);
					}else {
						System.out.println("You can't drop '" + item+ "', you don't have it.");
					}
					
					break;
				case "use":		// Check if the item exists in the player inventory
					Use.use(item, map);
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
					System.out.println("You can't do '" + String.join(" ", commands) + "'");
					break;
				}
			}
		}else {
			switch(commands[0].toLowerCase()) {
			case "east":
				movement(1,0);
				break;
			case "west":
				movement(-1,0);
				break;
			case "north":
				movement(0,1);
				break;
			case "south":
				movement(0,-1);
				break;
			case "inventory":
				TextAnimation.StatusBar(name);	//show status bar
				System.out.println("Inventory: " + Arrays.toString(inventory.returnContents()));
				break;
			case "help":
				TextAnimation.StatusBar(name);	//show status bar
				System.out.println(
						"Go print that English assignment! 60% of your term grade is on the line."
						+ "\nFull list of avalible commands:"
						+ "\nGo [NESW]	Allows you to move within the level, up being north."
						+ "\nUp/Down		Allows you to move across levels, like in a skyscraper."
						+ "\nGrab [ITEM]	Picks up the item and put it in your inventory."
						+ "\nUse [ITEM]	Use an item in your inventory. Items can be single use."
						+ "\nInventory	Check your inventory."
						+ "\nLook		Look around the room."
						+ "\nDrop [ITEM]	Remove an item from your inventory."			
						);
				break;
			case "look":
				TextAnimation.StatusBar(name);	//show status bar
				if (movementUnlocked == true) {
				// Looks and gets the objects around in the same room
				if (map.returnInventory().length() == 0) {
					System.out.println("The room you are in is very empty, there is no point looking for more stuff.");
				}else {
					//TODO fix dupe glitch
					System.out.println("The current room contains:\n" + String.join(", ",map.returnContents()));
				}
				}else {
					System.out.println("You try looking at the room but the door is locked");
				}
				break;
			case "up":
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
				game.Map.currentLevel++;
				TextAnimation.StatusBar(name);	//show status bar
				map.jblockUnlocked = false;
				map.jblockUnlocked = false;
				System.out.println("You lock all doors behind you");
				System.out.println("You moved up a level to " + game.Map.currentLevel);
				break;
			case "down":
				if (game.Map.currentLevel > 0) {
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
					game.Map.currentLevel--;
					TextAnimation.StatusBar(name);	//show status bar
					map.jblockUnlocked = false;
					map.jblockUnlocked = false;
					System.out.println("You lock all doors behind you");
					System.out.println("You moved down a level to " + game.Map.currentLevel);
				}else {
					System.out.println("You can't go down you're not a miner.");
				}
				break;
			case "debug": 
				Gamemain.debug = !Gamemain.debug;
				System.out.println("Debug: " + Gamemain.debug);
				break;
			default:
				System.out.println("I don't know what " + commands[0]+ " means.");
				break;
			}
			//TODO state of game
			// inventory
			// what rooms are unlocked
			// what room you are in
			// state of printers
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
