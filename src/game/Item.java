package game;

public class Item {
	private String name;
	private static boolean moveable;
	private int x;
	private int y;
	//goes down and if its zero it magically disappears
	private int maxUses;
	private String id;
	private String state;
	
	public Item(String itemName, String itemId, String itemState, boolean itemMoveable, int itemUses, int itemX, int itemY){
		x = itemX;
		y = itemY;
		name = itemName;
		moveable = itemMoveable;
		maxUses = itemUses; 
		id = itemId;
		state = itemState;
		
	}
	
	// Return name
	public String name() {
		return name;
	}
	public String state(String setState) {
		if(setState == null) {
			return state;
		} else {
			state = setState;
			return null;
		}
	}
	
	// Checks if its moveable
	public boolean moveable() {
		return moveable;
	}
	
	public boolean use() {
		if (maxUses > 0) {
			maxUses--;
			return true;
		}
		return false;
	}
}
// Eason was here
