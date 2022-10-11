package minigames;
import java.util.*;
//System.out.println(mineChar.codePointCount(0, mineChar.length()));

public class MineSweeperMain {
	public static void main(String[] args) {
		//variables
		int width = 10;
		int height = 8;
		boolean inGame = true;
		int minesLeft = ((width  * height)/6);
		//activate
		System.out.println(mineSweeper(width, height, minesLeft));
	}
	
	//create map
	public static ArrayList<String> map = new ArrayList<String>();
	public static ArrayList<String> mapShow = new ArrayList<String>();
	public static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static boolean mineSweeper(int x, int y, int mines) {
		int movesCount = 0;
		char tile = '*';						//no mine tile
		String mineChar = "Ф";					//mine tile
		boolean inGame = true;
		map.clear();
		mapShow.clear();
		
		//initial print
		System.out.println("\nBeginning minigame Minesweeper...");
		//generate covered map
		for(int i = 0; i < y; i++) {
			String row = new String();
			for(int j = 0; j < x; j++) {
				row = row + " " + tile;
			}
			map.add(row + " \n");
			mapShow.add(row + "\n");
		}
		//place mines
		for(int i = 0; i < mines; i++) {
			int xx = (int)(Math.random() * x/2) + 0;
			int yy = (int)(Math.random() * y) + 0;
			String[] charMap = map.get(yy).split("");
			charMap[xx * 4 + 1] = mineChar;
			map.set(yy, String.join("", charMap));
		}
		//random number make
		for(int i = 0; i < map.size(); i++) {					//goes through each row
			String[] row = map.get(i).split("");				//
			for(int j = 1; j < row.length - 1; j = j + 2) {		//goes through each character
				//variables
				int minesAround = 0;
				if(row[j].equals(mineChar)) {
				} else {
				//check mines
					if(j - 2 > -1) { //left
						if(map.get(i).split("(?!^)")[j - 2].equals(mineChar)) minesAround++;
						//System.out.print("l ");
					};
					if(j + 2 < map.get(i).length() + 1) { //right
						if(map.get(i).split("(?!^)")[j + 2].equals(mineChar)) minesAround++;
						//System.out.print("r ");
					};
					if(i - 1 > - 1) { //up
						if(map.get(i - 1).split("(?!^)")[j].equals(mineChar)) minesAround++;
						//System.out.print("u ");
					};
					if(i + 1 < map.size() + 0) { //down
						if(map.get(i + 1).split("(?!^)")[j].equals(mineChar)) minesAround++;
						//System.out.print("d ");
					};
					if(i - 1 > -1 && j - 2 > -1) { //up left
						if(map.get(i - 1).split("(?!^)")[j - 2].equals(mineChar)) minesAround++;
						//System.out.print("l ");
					};
					if(i + 1 < map.size() + 0 && j - 2 > -1) { //down left
						if(map.get(i + 1).split("(?!^)")[j - 2].equals(mineChar)) minesAround++;
						//System.out.print("dl ");
					};
					if(i - 1 > -1 && j + 2 < map.get(i).length() + 1) { //up right
						if(map.get(i - 1).split("(?!^)")[j + 2].equals(mineChar)) minesAround++;
						//System.out.print("ur ");
					};
					if(i + 1 < map.size() && j + 2 < map.get(i).length() + 1) { //down right
						if(map.get(i + 1).split("(?!^)")[j + 2].equals(mineChar)) minesAround++;
						//System.out.print("dr ");
					};
					//System.out.println("Mines around: " + minesAround);
					if(!(minesAround == 0)) {
						row[j] = String.valueOf(minesAround);
					} else {
						row[j] = " ";
					}
				}
			}
			map.set(i, String.join("", row));
		}
		//begin game
		while(inGame = true) {
			System.out.println(
					"Moves: " + movesCount + "     Mines:" + mines + //"❤️❤️❤️" +
					"\n|===================|"
					);
			printMap(x, y);
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine().trim().toLowerCase();
			//command handler
			if (input.length() > 1) {
				switch(input) {
				case "help":
					System.out.println("Google therules for minesweeeper, too lazy to write them again" + "\r\n"
							+ "Coordinates are done in the format LETTER_NUMBER, e.g 'a1'" + "\r\n"
							+ "Available commands:" + "\r\n"
							+ "help		show this message" + "\r\n"
							+ "restart		restart Minesweeper" + "\r\n"
							+ "flag *coords*	place a flag at the spot" + "\r\n"
							+ "*coords*	reveal a tile" + "\r\n");
					break;
				case "restart":
					return mineSweeper(x, y, mines);
				case "use jimmy":
					System.out.println("You used Jimmy to help you beat the game!");
					System.out.println("You beat Minesweeper within " + movesCount + " moves.");
					return true;
				default:
					//place mine where user states\
					try {
						String[] coords = input.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");		//Split into letters and numbers
						if((coords.length == 2)) {												//filter out any junk command
							int InputX = alphabet.indexOf(coords[0].toUpperCase()) + 1;
							if(InputX <= 0 || InputX > x) throw new Exception("X coordinate not within range!");
							int InputY = Integer.parseInt(coords[1]);
							if(InputY <= 0 || InputY > y) throw new Exception("Y coordinate not within range!");
							
							System.out.println("X: "  + InputX + "; Y: " + InputY);
							String number = map.get(y - InputY).split("")[InputX * 2 - 1];
							String[] yRow = mapShow.get(y - InputY).split("");
							yRow[(InputX - 1) * 2 + 1] = number;
							mapShow.set(y - InputY, String.join("", yRow));
							//debug
//							System.out.println("debug");
//							System.out.println(String.join("", map));
//							System.out.println("number: " + number);
							movesCount++;
							if(number == String.valueOf(mineChar)) {
								System.out.println("boom");
							}
						} else {
							System.out.println("Looks like I didn't recognise the command... (use help)");
						}
					} catch(Exception e) {
						System.out.println("Oops, seems like there was an error: \n" + e);
					}
					break;
				}
			}
		}
		return false;
	}
	//map printing
	public static void printMap(int x, int y) {
		ArrayList<String> mapShowCoords = (ArrayList<String>) mapShow.clone();
		//vertical coordinates
		for(int i = 0; i < y; i++) {
			String newString = (y - i) + mapShowCoords.get(i);
			mapShowCoords.set(i, newString);
		}
		//horizontal
		String horizontal = " ";
		for (int i = 0; i < x; i++) {
			horizontal = horizontal + " " + alphabet.substring(i, i+1);
		}
		mapShowCoords.add(horizontal);
		System.out.println(String.join("", mapShowCoords));
	}
}