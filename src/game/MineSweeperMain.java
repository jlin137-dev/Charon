package game;
import java.util.*;

/*	Minesweeper file
 * 	Run with `mineSweeper(width, height, total mines);`
 * 	Temporary main class should be deleted
 * 	Method will return `true` when the game is finished, and keep autorestarting itself if you die
 */
public class MineSweeperMain {
	public static void main(String[] args) {
		boolean ms = mineSweeper(10, 8, 4);
	}
	
	//create variables
	public static ArrayList<String> map = new ArrayList<String>();
	public static ArrayList<String> mapShow = new ArrayList<String>();
	public static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static int attemptCount = 0;
	
	public static boolean mineSweeper(int x, int y, int mines) {
		attemptCount++;
		int movesCount = 0;
		String tile = "*";						//no mine tile
		String mineChar = "▣";					//mine tile
		int minesFound = 0;
		int minesTotal = mines;
		map.clear();
		mapShow.clear();
		
		//initial print
		System.out.println("\nBeginning minigame Minesweeper...");
		System.out.println("Attempt " + attemptCount);
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
		while(true) {
			System.out.println(
					"Moves: " + movesCount + "     Mines:" + mines + //"❤️❤️❤️" +
					"\n|===================|"
					);
			printMap(x, y);
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			String[] input = scanner.nextLine().trim().toLowerCase().split(" ");
			//command handler
			if (input[0].length() > 1) {
				String number = "";
				String[] coords = {};
				switch(input[0]) {
				case "help":
					System.out.println("Google therules for minesweeeper, too lazy to write here" + "\r\n"
							+ "Coordinates are done in the format LETTER_NUMBER, e.g 'a1'" + "\r\n"
							+ "Available commands:" + "\r\n"
							+ "	help		show this message" + "\r\n"
							+ "	restart		restart Minesweeper" + "\r\n"
							+ "	flag xy		place a flag at the spot" + "\r\n"
							+ "	unflag xy	remove a flag at the spot" + "\r\n"
							+ "	xy		reveal a tile" + "\r\n");
					break;
				case "restart":
					return mineSweeper(x, y, mines);
				case "use":
					if(input[1].equals("jimmy")) {
						System.out.println("You used Jimmy to help you beat the game!");
						System.out.println("You beat Minesweeper within " + movesCount + " moves.");
						return true;
					}
					break;
				case "flag":
					number = "⚑";
					mines--;
					try {
						coords = input[1].split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");		//Split into letters and numbers
						if((coords.length == 2)) {												//filter out any junk command
							int InputX = alphabet.indexOf(coords[0].toUpperCase()) + 1;
							if(InputX <= 0 || InputX > x) throw new Exception("X coordinate not within range!");
							int InputY = Integer.parseInt(coords[1]);
							if(InputY <= 0 || InputY > y) throw new Exception("Y coordinate not within range!");
							
							System.out.println("X: "  + InputX + "; Y: " + InputY);
							String[] yRow = mapShow.get(y - InputY).split("");
							yRow[(InputX - 1) * 2 + 1] = number;
							mapShow.set(y - InputY, String.join("", yRow));
							movesCount++;
							
							if(map.get(y - InputY).split("")[InputX * 2 - 1].equals(mineChar)) {
								minesFound ++;
							}
						}
					} catch(Exception e) {
						System.out.println("Oops, seems like there was an error: \n" + e);
					}
					break;//⚑
				case "unflag":
					number = tile;
					mines++;
					try {
						coords = input[1].split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");		//Split into letters and numbers
						if((coords.length == 2)) {												//filter out any junk command
							int InputX = alphabet.indexOf(coords[0].toUpperCase()) + 1;
							if(InputX <= 0 || InputX > x) throw new Exception("X coordinate not within range!");
							int InputY = Integer.parseInt(coords[1]);
							if(InputY <= 0 || InputY > y) throw new Exception("Y coordinate not within range!");
							
							System.out.println("X: "  + InputX + "; Y: " + InputY);
							String[] yRow = mapShow.get(y - InputY).split("");
							yRow[(InputX - 1) * 2 + 1] = number;
							mapShow.set(y - InputY, String.join("", yRow));
							movesCount++;
							
							if(map.get(y - InputY).split("")[InputX * 2 - 1].equals(mineChar)) {
								minesFound --;
							}
						}
					} catch(Exception e) {
						System.out.println("Oops, seems like there was an error: \n" + e);
					}
					break;
				case "debug":
					System.out.print(String.join("", map));
					break;
				default:
					//place mine where user states\
					try {
						coords = input[0].split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");		//Split into letters and numbers
						if((coords.length == 2)) {												//filter out any junk command
							int InputX = alphabet.indexOf(coords[0].toUpperCase()) + 1;
							if(InputX <= 0 || InputX > x) throw new Exception("X coordinate not within range!");
							int InputY = Integer.parseInt(coords[1]);
							if(InputY <= 0 || InputY > y) throw new Exception("Y coordinate not within range!");
							
							System.out.println("X: "  + InputX + "; Y: " + InputY);
							number = map.get(y - InputY).split("")[InputX * 2 - 1];
							String[] yRow = mapShow.get(y - InputY).split("");
							yRow[(InputX - 1) * 2 + 1] = number;
							mapShow.set(y - InputY, String.join("", yRow));
							//debug
//							System.out.println("debug");
//							System.out.println(String.join("", map));
//							System.out.println("number: " + number);
							movesCount++;
							if(number.equals(mineChar)) {
								System.out.println("You exploded on a mine! Wait a minute, why am I \nstill alive... And why did everything reset?\nPress ENTER to restart.");
								Scanner scanner2 = new Scanner(System.in);
								String input2 = scanner.nextLine().trim().toLowerCase();
								return mineSweeper(x, y, mines);
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
			if(minesFound == minesTotal && mines == 0) {
				scanner.close();
				printMap(x, y);
				System.out.println("You finally flag out the last mine, and you see your charger.");
				return true;
			}
		}
		//return false;
	}
	//map printing
	public static void printMap(int x, int y) {
		@SuppressWarnings("unchecked")
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