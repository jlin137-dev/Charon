package game;

public class map {
	
	public map(){
		this.init();
	}
	
	boolean jblockUnlocked = false;
	boolean lockerUnlocked = false;
	
	public int currentLevel = 0;
	// L block
	public char[][] level0 = {
			{' ','|',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ','|',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{'|',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '}
	};
	public char[][] level1 = {
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '}
	};
	public char[][] level2 = {
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '}
	};
	public char[][] level3 = {
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '}
	};
	public char[][] level4 = {
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '}
	};
	
	public Inventory level0Inventory = new Inventory(false);
	public Inventory level1Inventory = new Inventory(false);
	public Inventory level2Inventory = new Inventory(false);
	public Inventory level3Inventory = new Inventory(false);
	public Inventory level4Inventory = new Inventory(false);

	public void init() {
		// Add all the items and stuff here
		level0Inventory.add(new Item("Laptop".toLowerCase(), true, 99));
		level1Inventory.add(new Item("Paper".toLowerCase(), true, 1));
	}

	// Don't need it
	public void printMap() {
		char[][] level = returnLevel();
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
	public char[][] returnLevel() {
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
