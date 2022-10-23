package game;

public class Use {
	public static void use(String item, Map map) {
		Inventory inventory = Player.inventory;
		int turn = Player.turn;
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
				laptop.use();
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
				Item printer = inventory.get("printer");
				switch(printer.state(null)) {
				case "on":
					if (inventory.in("paper") && inventory.in("laptop") && inventory.get("laptop").state(null) == "on") {
							inventory.add(map.returnInventory().get("unstapled assignment"));
							System.out.println("You load in your paper and press print...");
							System.out.println("The printer prints your assignment for you");
							System.out.println("Please use stapler to staple assignment. Oh wait you have no stapler on you");
							System.out.println("But you left a stapler in your locker");
							turn += 2;
							
					}else if (inventory.in("paper") && inventory.in("laptop") && inventory.get("laptop").state(null) == "off") {
						System.out.println("Wait... what are you printing? Your laptop is off");
						System.out.println("Use the laptop to turn it on");
						turn ++;
					}
					else if (inventory.in("paper") && inventory.in("laptop") == false) {
						System.out.println("You load paper into the printer");
						System.out.println("Wait... what are you printing? Where is your laptop?");
						turn ++;
					}
					else {
						System.out.println("Error: No paper...");
						System.out.println("You need to get some paper to print on");
						System.out.println("Don't try break the printer... your english marks depend on it");
						turn ++;
					}
					printer.use();
					break;
				case "off":
					System.out.println("You turn on the printer.");
					printer.state("on");
					turn ++;
					break;
				case "broken":
					System.out.println("You try printing yet again");
					System.out.println("The printer suddenly stops printing");
					System.out.println("Wait... why can you smell smoke!?");
					System.out.println("The printer catches fire.");
					System.out.println("You race to switch off the L block power supply. The printer stops burning");
					System.out.println("All power supply to the block is cut. Including Wifi");
					System.out.println("Have fun waiting for the maintanence crew to get on shift, you are not printing until then");
					System.out.println("And for your english assignment? well you can't print it now can you?");
					System.out.println("Try turning this file off and on again");
					break;
					
					
				case "cricuit boards":
				System.out.println("Ouuuuuuch..........");
				System.out.println(". \n\n\n");
				System.out.println("You wake up... did you electrute yourself?");
				System.out.println("You realise you just wasted half an hour");
				turn += 30;
				break;
			case "test":
				Item test = inventory.get("test");
				System.out.println("You used test");
				test.use();
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
		}}else {
			switch(item) {
			case "":
				break;
			default:
				System.out.println("You search through your laptop bag but " + item + " isn't there.");
				System.out.println("Searching for nothing costs time you can use to hand in english, you know");
				turn ++;
				break;
			}
		}
	}
}
