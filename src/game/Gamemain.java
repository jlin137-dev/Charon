package game;
import java.util.Scanner;

public class Gamemain {
	public static boolean debug = false;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Player player = new Player();

		//System.out.print(TextAnimation.Logo());														//Show ascii QASMT logo
		//TextAnimation.LoadingBar(5000);																//Show loading bar
		System.out.println("\nHello Adventurer what is your name? ");
		player.name = scanner.nextLine().trim();
		if(player.name == ""||player.name == null) player.name = "student";
		System.out.println("Welcome, " + player.name + ", to the land of QASMT.");
		// Init the locations and story
		//story story = new story();
		//story.init();
		
		System.out.println("It's Monday morning, 7:00 am. The school is completely empty. Your"
				+ "\nEnglish assignment is due at 8:30 am, and you spent the entire night"
				+ "\ncramming completing it. You don't have a printer at home, so you arrive"
				+ "\nat L block in the morning to print it.\nPress [ENTER] to continue...");

        TextAnimation.EnterReturn();
        TextAnimation.StatusBar(player.name);
		System.out.println("You've entered L block, and need to look for that printer.\nType 'help' if you're stuck");
		// Game loop
		while (player.alive || !(player.gameFinished)) {
			player.action();
			//story.readStory(player.playerLevel,player.playerLocation[0],player.playerLocation[1]);
			//debugging
			if(debug == true) {
				System.out.println("\nLevel: " + String.valueOf(player.playerLevel) + "\nCoords: " + String.valueOf(player.playerLocation[0]) + " " + String.valueOf(player.playerLocation[1]) + "\nTurns: " + String.valueOf(player.turn)); 
			}
			if (player.gameFinished == true) {
				break;
			}
		}
		scanner.close();
		if (player.alive == false) {
			System.out.println("Yes, 60% of your english grade really did go down the drain");
			System.out.println("Welcome to QA~!  ?");
			System.out.println("Game over");
		}
		else {
		System.out.println("You finally submit your english assignment...");
		System.out.println("You look at your timetable:");
		System.out.println("English");
		System.out.println("...");
		System.out.println("\n\n\n You win.");
		}
	}

}
