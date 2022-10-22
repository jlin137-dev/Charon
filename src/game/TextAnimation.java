package game;

import java.util.ArrayList;

public class TextAnimation {
	public static void LoadingBar(int Delay) {
		int length = 60;
		String output = "";
		float percentage = 0;
		//print new line
		System.out.print("0% [");
		for(int j = 0; j < length + 2; j++) {
			System.out.print("-");
		}
		System.out.print("]\r");
		for(int i = 0; i < length; i++) {
			try {
				output = output + "#";
				percentage = percentage + ((float)100/length);
				System.out.print("\r" + Math.round(percentage) + "% [" + output);
				Thread.sleep(Delay/length);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.print("]");
	}
	
	public static String Logo() {
		return "   ____             _____ __  __ _______    _____                      \r\n"
				+ "  / __ \\     /\\    / ____|  \\/  |__   __|  / ____|                     \r\n"
				+ " | |  | |   /  \\  | (___ | \\  / |  | |    | |  __  __ _ _ __ ___   ___ \r\n"
				+ " | |  | |  / /\\ \\  \\___ \\| |\\/| |  | |    | | |_ |/ _` | '_ ` _ \\ / _ \\\r\n"
				+ " | |__| | / ____ \\ ____) | |  | |  | |    | |__| | (_| | | | | | |  __/\r\n"
				+ "  \\___\\_\\/_/    \\_\\_____/|_|  |_|  |_|     \\_____|\\__,_|_| |_| |_|\\___|\r\n"
				+ "  Loading...\n";
	}
	
	public static void StatusBar(String name) {
		String spaces = "   ";
		if(name.length() < 15) {
			for(int i = 0; i < 15 - name.length(); i++) {
				spaces = spaces + " ";
			}
		} else {
			name = name.substring(0, 15) + "...";
		}
		System.out.println(
				  "   QASMT Game - " + name + "'s adventure                  " + spaces + "Time: " + "07:00" +
				"\n===========================================================================");
	}
}