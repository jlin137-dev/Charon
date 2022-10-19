package game;
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
		//System.out.println("\nHello Adventurer what is your name? ");
		//player.name = scanner.nextLine().trim();
		//System.out.println("Welcome " + player.name + " to the land of QASMT.");
		// Init the locations and story
		//story story = new story();
		//story.init();
		
		System.out.println("\nIt's Mondays morning 7:00 am, no one is at school yet.\nYour english assignment is due and it makes up a solid 60% of your grade.\nYou have finished it but you don't have a printer at home.\nYou enter the research centre in hopes to print it but when you try to \nprint,and error that makes your blood run cold appears.\nNO PAPER");
		System.out.println("Type 'help' for help \n You remember there may be paper around the school");
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
