package game;
import java.util.Scanner;

public class Gamemain {
	// TODO Finish off story

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		player player = new player();
		
		story story = new story();
		TextAnimation textanimate = new TextAnimation();
		
		//System.out.print(TextAnimation.Logo());														//Show ascii QASMT logo
		//TextAnimation.LoadingBar(5000);																//Show loading bar
		//System.out.println("\nHello Adventurer what is your name? ");
		//player.name = scanner.nextLine().trim();
		//System.out.println("Welcome " + player.name + " to the land of QASMT.");
		// Init the locations and story
		story.init();
		// Game loop
		while (player.alive || !(player.gameFinished)) {
			// TODO fix later cuz i moved the map class
			//story.readStory(map.currentLevel, player.playerLocation[0], player.playerLocation[1]);
			//map.printMap();
			player.action();
			System.out.println("Player at " + String.valueOf(player.playerLocation[0]) + " " + String.valueOf(player.playerLocation[1]) + " this is for debugging if you see this Mr Venz it mean that someone forgot to remove it :)");
			
		}
		scanner.close();
	}

}
