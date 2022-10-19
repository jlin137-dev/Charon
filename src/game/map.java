package game;

public class map {
	
	public map(){
		this.init();
	}
	
	public boolean jblockUnlocked = false;
	public boolean lockerUnlocked = false;
	
	public static int currentLevel = 0;
	// L block
	//-█------
	//-█---█--
	//-█-█████
	//--------
	//-█--██--
	//-█---█--
	//-█---█--
	public String[][] level0 = {
			{" ","█"," "," "," "," "," "," "},
			{" ","█"," "," "," ","█"," "," "},
			{" ","█"," ","█","█","█","█","█"},
			{" "," "," "," "," "," "," "," "},
			{" ","█"," "," ","█","█"," "," "},
			{" ","█"," "," ","1","█"," "," "},
			{" ","█"," "," "," ","█"," "," "},
	};
	public String[][] level0Msg = {
			{" ","█","Oh look circuitboards","OMG ITS JIMMY. Wait, he doesn't want to give us any answers. What a shame...","There's nothing on this spot but a door east","A doorway","You're in a storage room. There's more ciruitboards.\nJimmy followed you inside.","You somehow stand on a lazer cutter."},
			{"You see a long corridor before you","█","The robotics room extends east and contains a bunch of electronic parts which you don't need.","Bunch of shelves","More shelves","█","You stand in the courner... and nothing happensq","It's another shelf"},
			{"Something appears to be ahead","█","The entrance to the robotics room. All you see right now is a doorway.","█","█","█","█","█"},
			{"A door comes up on your left","You go through the door and stop in the doorway. Now you're annoying everyone else.","You step forward and 3 room entrances are available around you."," "," "," "," "," "},
			{"You miss the door","█","You walk through the south doorway","You walk through the south doorway","█","█"," "," "},
			{"Why are going forward there was legit a door back there","█","A computer room","A room with computers around the walls, and a printer and scanner in the courner.","You come up to the printer-scanner.","█"," "," "},
			{"Dead end. GO BACK TO THE DOOR YOU SMART PERSON","█"," "," "," ","█"," "," "},
	};
	public String[][] level1 = {
			{" ","█"," "," "," "," "," "," "},
			{" ","█"," "," "," ","█"," "," "},
			{" ","█"," ","█","█","█","█","█"},
			{" "," "," "," "," "," "," "," "},
			{" ","█"," "," ","█","█"," "," "},
			{" ","█"," "," ","1","█"," "," "},
			{" ","█"," "," "," ","█"," "," "},
	};
	public String[][] level1Msg = {
			{" ","█"," "," "," "," "," "," "},
			{" ","█"," "," "," ","█"," "," "},
			{" ","█"," ","█","█","█","█","█"},
			{" "," "," "," "," "," "," "," "},
			{" ","█"," "," ","█","█"," "," "},
			{" ","█"," "," ","1","█"," "," "},
			{" ","█"," "," "," ","█"," "," "},
	};
	public String[][] level2 = {
			{" ","█"," "," "," "," "," "," "},
			{" ","█"," "," "," ","█"," "," "},
			{" ","█"," ","█","█","█","█","█"},
			{" "," "," "," "," "," "," "," "},
			{" ","█"," "," ","█","█"," "," "},
			{" ","█"," "," ","1","█"," "," "},
			{" ","█"," "," "," ","█"," "," "},
	};
	public String[][] level2Msg = {
			{" ","█"," "," "," "," "," "," "},
			{" ","█"," "," "," ","█"," "," "},
			{" ","█"," ","█","█","█","█","█"},
			{" "," "," "," "," "," "," "," "},
			{" ","█"," "," ","█","█"," "," "},
			{" ","█"," "," ","1","█"," "," "},
			{" ","█"," "," "," ","█"," "," "},
	};
	public String[][] level3 = {
			{" ","█"," "," "," "," "," "," "},
			{" ","█"," "," "," ","█"," "," "},
			{" ","█"," ","█","█","█","█","█"},
			{" "," "," "," "," "," "," "," "},
			{" ","█"," "," ","█","█"," "," "},
			{" ","█"," "," ","1","█"," "," "},
			{" ","█"," "," "," ","█"," "," "},
	};
	public String[][] level3Msg = {
			{" ","█"," "," "," "," "," "," "},
			{" ","█"," "," "," ","█"," "," "},
			{" ","█"," ","█","█","█","█","█"},
			{" "," "," "," "," "," "," "," "},
			{" ","█"," "," ","█","█"," "," "},
			{" ","█"," "," ","1","█"," "," "},
			{" ","█"," "," "," ","█"," "," "},
	};
	public String[][] level4 = {
			{" ","█"," "," "," "," "," "," "},
			{" ","█"," "," "," ","█"," "," "},
			{" ","█"," ","█","█","█","█","█"},
			{" "," "," "," "," "," "," "," "},
			{" ","█"," "," ","█","█"," "," "},
			{" ","█"," "," ","1","█"," "," "},
			{" ","█"," "," "," ","█"," "," "},
	};
	public String[][] level4Msg = {
			{" ","█"," "," "," "," "," "," "},
			{" ","█"," "," "," ","█"," "," "},
			{" ","█"," ","█","█","█","█","█"},
			{" "," "," "," "," "," "," "," "},
			{" ","█"," "," ","█","█"," "," "},
			{" ","█"," "," ","1","█"," "," "},
			{" ","█"," "," "," ","█"," "," "},
	};
	
	public Inventory level0Inventory = new Inventory(false);
	public Inventory level1Inventory = new Inventory(false);
	public Inventory level2Inventory = new Inventory(false);
	public Inventory level3Inventory = new Inventory(false);
	public Inventory level4Inventory = new Inventory(false);
	// Hidden level that stores all the items player must unlock through other items
	public Inventory LockedInventory = new Inventory(false);

	public void init() {
		// Add all the items and stuff here
		level0Inventory.add(new Item("laptop", "lpt", "off", true, 99, 0, 0));
		level0Inventory.add(new Item("printer", "1", "off", false, 10, 0, 0));
		level0Inventory.add(new Item("circuit boards", "", "empty", true, 1, 0, 0));
		level1Inventory.add(new Item("paper", "ppr", "empty", true, 1, 0, 0));
		level2Inventory.add(new Item ("j_block_key", "", "empty", true, 2, 0, 0));
		level3Inventory.add(new Item ("stapler", "", "usable", true, 2, 0, 0));
		
		LockedInventory.add(new Item ("unstapled_assignment", "", "usable", true, 2, 0, 0));
		LockedInventory.add(new Item ("locker_code", "", "usable", true, 2, 0, 0));
		LockedInventory.add(new Item ("charger", "", "usable", true, 2, 0, 0));
		LockedInventory.add(new Item ("stapled_essay", "", "usable", true, 2, 0, 0));
	}
	// Don't need it
	public void printMap() {
		String[][] level = returnLevel();
		// Making a map border to make it look nice
		System.out.print("|");
		for (int i = 0; i < level[0].length * 2; i++) {
			System.out.print("=");
		}
		
		// Actually printing out the world content
		for (int y = 0; y < level.length; y++) {
			System.out.println("|");
			for (int x = 0; x < level[0].length; x++) {
				if (x == 0) {
					System.out.print("|");
				}
				System.out.print(level[y][x]);					
				// Spaces between the locations
				System.out.print(" ");
				
			}
		}
		// Making a map border to make it look nice
		System.out.print("|");
		System.out.println();
		System.out.print("|");
		for (int i = 0; i < level[0].length * 2; i++) {
			System.out.print("=");
		}
		System.out.print("|");
	}
	
	// Returns what the map level is
	public String[][] returnLevel() {
		switch(currentLevel) {
		case 0:
			return level0;
		case 1:
			return level1;
		case 2:
			return level2;
		case 3:
			return level3;
		case 4:
			return level4;
		default:
			return null;
		}
	}
	
	public String[][] returnLevelMsg() {
		switch(currentLevel) {
		case 0:
			return level0Msg;
		case 1:
			return level1Msg;
		case 2:
			return level2Msg;
		case 3:
			return level3Msg;
		case 4:
			return level4Msg;
		default:
			return null;
		}
	}
	
	public Inventory returnInventory() {
		switch(currentLevel) {
		case 0:
			return level0Inventory;
		case 1:
			return level1Inventory;
		case 2:
			return level2Inventory;
		case 3:
			return level3Inventory;
		case 4:
			return level4Inventory;
		default:
			return null;
		}
	}
	
	public void addToRoom(Item item) {
		switch(currentLevel) {
			case 0:
				level0Inventory.add(item);
				break;
			case 1:
				level1Inventory.add(item);
				break;
			case 2:
				level2Inventory.add(item);
				break;
			case 3:
				level3Inventory.add(item);
				break;
			case 4:
				level4Inventory.add(item);
				break;
			default:
				break;
		}
	}
	
	public void remove(String itemName) {
		switch(currentLevel) {
		case 0:
			level0Inventory.remove(itemName);
		case 1:
			level1Inventory.remove(itemName);
		case 2:
			level2Inventory.remove(itemName);
		case 3:
			level3Inventory.remove(itemName);
		case 4:
			level4Inventory.remove(itemName);
		default:
			break;
		}
	
	}
	// TODO fix so some stuff is locked
	public String[] returnContents() {
		switch(currentLevel) {
		case 0:
			return level0Inventory.returnContents();
		case 1:
			return level1Inventory.returnContents();
		case 2:
			return level2Inventory.returnContents();
		case 3:
			return level3Inventory.returnContents();
		case 4:
			return level4Inventory.returnContents();
		default:
			return null;
		}
	}

}
