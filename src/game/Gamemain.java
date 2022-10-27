package game;
import java.util.Scanner;

public class Gamemain {
	public static boolean debug = false;

	public static void main(String[] args) {
		TextAnimation tA = new TextAnimation();
		Scanner scanner = new Scanner(System.in);
		Player player = new Player();

		System.out.print(tA.Logo());														//Show ascii QASMT logo
		tA.LoadingBar(5000);																//Show loading bar
		System.out.println("\nHello Adventurer what is your name? ");
		player.name = scanner.nextLine().trim();
		if(player.name.equals("jimmy")) debug = true;
		if(player.name == ""||player.name == null) player.name = "student";
		if(debug) System.out.println("You've entered developer mode.");
		System.out.println("Welcome, " + player.name + ", to the land of QASMT.");
		// Init the locations and story
		//story story = new story();
		//story.init();
		
		System.out.println("It's Monday morning, 7:00 am. The school is completely empty. Your"
				+ "\nEnglish assignment is due at 8:30 am, and you spent the entire night"
				+ "\ncramming completing it. You don't have a printer at home, so you arrive"
				+ "\nat L block in the morning to print it.\nPress [ENTER] to continue...");

        TextAnimation.EnterReturn();
        tA.StatusBar(player.name);
		System.out.println("You've entered L block, and need to look for that printer.\nType 'help' if you're stuck");
		// Game loop
		while (player.alive || !(player.gameFinished)) {
			try {
				player.action();
			} catch (Exception e) {
				System.out.println("There's an error lmfao\nError: " + e);
			}
			//story.readStory(player.playerLevel,player.playerLocation[0],player.playerLocation[1]);
			//debugging
			if(debug) System.out.println("\nLevel: " + String.valueOf(player.playerLevel) + ", " + Player.blocks[player.playerLevel] + "\nCoords: " + String.valueOf(player.playerLocation[0]) + " " + String.valueOf(player.playerLocation[1]) + "\nTurns: " + String.valueOf(player.turn));
		}
		scanner.close();
		if ((player.alive)) {
			tA.winMessage();
		} else {
			tA.looseMessage();
		}
	}

}
