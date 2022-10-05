package game;

public class Item {
	private String name;
	private static boolean moveable;
	//goes down and if its zero it magically disappears
	private int maxUses;
	
	public Item(String itemName, boolean itemMoveable, int itemUses){
		name = itemName;
		moveable = itemMoveable;
		maxUses = itemUses; 
	}
	
	public String name() {
		return name;
	}
	
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
	
	
	//TODO make a nicer way to do this
	public void delete() {
		name = "___DELETED___";
	}
}
// Eason was here