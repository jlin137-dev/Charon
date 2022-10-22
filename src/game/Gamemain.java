package game;
import java.io.IOException;
import java.util.Scanner;

public class Gamemain {
	// TODO Finish off story
	public static boolean debug = false;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		player player = new player();
		
		
		TextAnimation textanimate = new TextAnimation();
		
		//System.out.print(TextAnimation.Logo());														//Show ascii QASMT logo
		//TextAnimation.LoadingBar(5000);																//Show loading bar
		System.out.println("\nHello Adventurer what is your name? ");
		player.name = scanner.nextLine().trim();
		if(player.name == ""||player.name == null) player.name = "student";
		System.out.println("Welcome, " + player.name + ", to the land of QASMT.");
		// Init the locations and story
		//story story = new story();
		//story.init();
		
		System.out.println("\nIt's Monday morning, 7:00 am. The school is completely empty. Your"
				+ "\nEnglish assignment is due at 8:30 am, and you spent the entire night"
				+ "\ncramming completing it. You don't have a printer at home, so you arrive"
				+ "\nat L block to print it.\nPress [ENTER] to continue...");
        try {
            int read = System.in.read(new byte[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
		System.out.println("The rest of the story which I haven't yet written\nType in some command:");
		// Game loop
		while (player.alive || !(player.gameFinished)) {
			player.action();
			//story.readStory(player.playerLevel,player.playerLocation[0],player.playerLocation[1]);
			//debugging
			if(debug == true) {
				System.out.println("\nLevel: " + String.valueOf(player.playerLevel) + "\nCoords: " + String.valueOf(player.playerLocation[0]) + " " + String.valueOf(player.playerLocation[1]) + "\nTurns: " + String.valueOf(player.turn)); 
			}
		}
		scanner.close();
		System.out.println("You finally submit your english assignment...");
		System.out.println("You look at your timetable:");
		System.out.println("English");
		System.out.println("...");
		System.out.println("\n\n\n You win.");
	}

}
