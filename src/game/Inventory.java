package game;
import java.util.ArrayList;

public class Inventory {
	public ArrayList<Item> inventory = new ArrayList<Item>(); 
	public boolean locked;
	
	public Inventory(boolean inventoryLock){
		locked = inventoryLock;
		
	}
	public void add(Item item) {
		if (!locked) {
			inventory.add(item);
		}
	}
	
	public void remove(Item item) {
		if (inventory.contains(item)) {
			inventory.remove(item);
		}
	}
	
	public boolean in(Item item) {
		if (inventory.contains(item)) {
			return true;
		}
		return false;
	}
	
	public boolean in(String itemName) {
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).name().equals(itemName)) {
				return true;
			}
		}
		return false;
	}
	
	public Item get(int i) {
		return inventory.get(i);
	}
	
	public Item get(String itemName) {
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).name().equals(itemName)) {
				return inventory.get(i);
			}
		}
		return null;
	}
	
	public int length() {
		return inventory.size();
	}
	
	public void lock() {
		locked = !locked;
	}
}
