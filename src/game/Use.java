package game;

public class Use {
	public static void use(String item, Map map) {
		Inventory inventory = Player.inventory;
		int turn = Player.turn;
		if (inventory.in(item)) {
			System.out.println("Testing");
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
				Player.turn ++;
				laptop.use();
				break;
			case "j block key":
				map.jblockUnlocked = true;
				System.out.println("You use J block Key to unlock J Block");
				Player.turn++;
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
								inventory.add(map.returnLockedInventory().get("unstapled assignment"));
								System.out.println("You load in your paper and press print...");
								System.out.println("The printer prints your assignment for you");
								System.out.println("Please use stapler to staple assignment. Oh wait you have no stapler on you");
								System.out.println("But you left a stapler in your locker");
								Player.turn += 2;
								
						}else if (inventory.in("paper") && inventory.in("laptop") && inventory.get("laptop").state(null) == "off") {
							System.out.println("Wait... what are you printing? Your laptop is off");
							System.out.println("Use the laptop to turn it on");
							Player.turn ++;
						}
						else if (inventory.in("paper") && inventory.in("laptop") == false) {
							System.out.println("You load paper into the printer");
							System.out.println("Wait... what are you printing? Where is your laptop?");
							Player.turn ++;
						}
						else {
							System.out.println("Error: No paper...");
							System.out.println("You need to get some paper to print on");
							System.out.println("Don't try break the printer... your english marks depend on it");
							Player.turn ++;
						}
						printer.use();
						break;
					case "off":
						System.out.println("You turn on the printer.");
						printer.state("on");
						Player.turn ++;
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
				}
				break;
					
				case "phone":
					Item phone = inventory.get("phone");
					switch (phone.state(null)) {
					case "uncharged":
						System.out.println("You try to open your phone. It has no charge");
						System.out.println("A while back, your put a charger in the middle of the oval to hide it\n"
								+ "It wouldn't be hard to find it right?");
						break;
					case "charged":
						System.out.println("You turn on your phone, and search for the locker password");
						System.out.println("You find the password");
						System.out.println("Now you can get the stapler!");
						inventory.add(map.returnLockedInventory().get("locker code"));
					}
					Player.turn++;
					break;
				
				case "circuit boards":
					System.out.println("Ouuuuuuch..........");
					System.out.println(". \n\n\n");
					System.out.println("You wake up... did you electrute yourself?");
					System.out.println("You realise you just wasted half an hour");
					Player.turn += 30;
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
					System.out.println("Remember, submit your essay in J block. Use your essay to submit it");
					inventory.add(map.returnLockedInventory().get("stapled essay"));
				}
				else {
					System.out.println("You don't have the printed assignment to staple");
					System.out.println("You waste 1 of your 2 precious staples");
				}
				Player.turn ++;
				break;
			
			case "charger":
				if (inventory.in("phone") && inventory.get("phone").state(null) == "uncharged") {
					System.out.println("You connect to the nearest power station, and charge up your phone");
					System.out.println("It takes a while before your phone turns on");
					System.out.println("But there, your phone can be used now!");
					turn += 5;
					inventory.get("phone").state("charged");
				} else {
					System.out.println("Where is your phone?");
					System.out.println("Have you taken it out of your bag? Use it to take it out of your bad");
				}
				break;
			
			case "stapled essay":
				if (game.Map.currentLevel == 1) {
					System.out.println("You rush in, and submit your assignment!");
					Player.gameFinished = true;
				}
				else {
					System.out.println("You need to submit your english essay in J block, or its not getting marked");
				}
				break;
		
			//Call and command or something
		}}else {
			switch(item) {
			case "":
				break;
			default:
				System.out.println("You search through your laptop bag but " + item + " isn't there.");
				System.out.println("Searching for nothing costs time you can use to hand in english, you know");
				Player.turn ++;
				break;
			}
		}
	}
}
