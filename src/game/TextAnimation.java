package game;

import java.io.IOException;

public class TextAnimation {
	public void LoadingBar(int Delay) {
		int length = 60;						//bar length
		String output = "";						//init output string
		float percentage = 0;					//init percentage
		System.out.print("0% [");				//beginning part print
		for(int j = 0; j < length + 2; j++) {	//create a beinning line of pre set length
			System.out.print("-");
		}
		System.out.print("]\r");				//end part print
		for(int i = 0; i < length; i++) {		//repeat preset length times
			try {
				output = output + "#";			//add a "pixel" to loading bar
				percentage = percentage + ((float)100/length);	//calculate percentage
				System.out.print("\r" + Math.round(percentage) + "% [" + output); //move return carriage to end
				Thread.sleep(Delay/length);		//stop code for total delay divided by length
			}
			catch (Exception e) {
				e.printStackTrace();			//check for errors
			}
		}
		System.out.print("]");					//print the very end
	}
	
	public String Logo() {
		return "   ____             _____ __  __ _______    _____                      \r\n"
				+ "  / __ \\     /\\    / ____|  \\/  |__   __|  / ____|                     \r\n"
				+ " | |  | |   /  \\  | (___ | \\  / |  | |    | |  __  __ _ _ __ ___   ___ \r\n"
				+ " | |  | |  / /\\ \\  \\___ \\| |\\/| |  | |    | | |_ |/ _` | '_ ` _ \\ / _ \\\r\n"
				+ " | |__| | / ____ \\ ____) | |  | |  | |    | |__| | (_| | | | | | |  __/\r\n"
				+ "  \\___\\_\\/_/    \\_\\_____/|_|  |_|  |_|     \\_____|\\__,_|_| |_| |_|\\___|\r\n"
				+ "  Loading...\n";
	}
	
	public static void StatusBar(String name) {
		//make the spacing fit different name lengths
		String spaces = "";
		if(name.length() < 15) {
			spaces = "   ";
			for(int i = 0; i < 15 - name.length(); i++) {
				spaces = spaces + " ";
			}
		} else {
			name = name.substring(0, 15) + "...";
		}
		System.out.println(
				  "   Level: " + Player.blocks[Map.currentLevel] + " - " + name + "'s adventure               " + spaces + "Time: " + Player.TurnTime() +
				"\n===========================================================================");
	}
	public void looseMessage() {
		System.out.println("\nThe clock outside strikes 8:30");
		System.out.println("Your assignment is overdue");
		System.out.println("60% of your english grade goes down the drain");
		System.out.println("\nGame over");
	}
	public void winMessage() {
		System.out.println("You finally submit your english assignment...");
		System.out.println("You look at your timetable:");
		System.out.println("English");
		System.out.println("...");
		System.out.println("\n\n\n You win.");
	}
	public static void EnterReturn() {
		try {
            System.in.read(new byte[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}