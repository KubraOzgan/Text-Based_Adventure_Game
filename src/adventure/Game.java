package adventure;

import java.util.Scanner;

public class Game {
	
	private Scanner sc = new Scanner(System.in);

	public void start() {
		System.out.println("Welcome to the game.");
		System.out.println("Please enter your name: ");
		String playerName = sc.next();
		
		Player player = new Player(playerName);
		System.out.println(player.getName() + ", be ready for a great adventure!");
		System.out.println("It is time for you to choose your character to begin! \n");
		player.selectCharacter();
		
		Location location = null;
		
		while(true) {
			player.playerInfo();
			System.out.println("\n**************************************************");
			System.out.println("Please select the location you want to go:\n");
			System.out.println("1 - Safe House"
					+ "\n2 - Tool Store"
					+ "\n3 - Cave => Fight with zombies."
					+ "\n4 - Forest => Figth with vampires."
					+ "\n5 - River => Figt with bears."
					+ "\n0 - End the Game");
			
			int select = sc.nextInt();
			
			switch(select) {
				case 0:
					location = null;
					break;
				case 1:
					location = new SafeHouse(player);
					break;
				case 2:
					location = new ToolStore(player);
					break;
				case 3:
					location = new Cave(player);
					break;
				case 4:
					location = new Forest(player);
					break;
				case 5:
					location = new River(player);
					break;
				default:
					System.out.println("Please enter a valid value!\n");
					continue;
			}

			if(location == null) {
				System.out.println("You left the game!");
				break;
			}
			
			if(!location.onLocation()) {
				System.out.println("GAME OVER!");
				break;
			}
			
		}
		
	}

}
