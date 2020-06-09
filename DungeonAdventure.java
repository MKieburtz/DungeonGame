/**
 * Title: DungeonAdventure.java
 *
 * Description: Driver file for Heroes and Monsters project
 *
 * Copyright:    Copyright (c) 2001
 * Company: Code Dogs Inc.
 * I.M. Knurdy
 *
 * History:
 *  11/4/2001: Wrote program
 *    --created DungeonCharacter class
 *    --created Hero class
 *    --created Monster class
 *    --had Hero battle Monster
 *    --fixed attack quirks (dead monster can no longer attack)
 *    --made Hero and Monster abstract
 *    --created Warrior
 *    --created Ogre
 *    --made Warrior and Ogre battle
 *    --added battleChoices to Hero
 *    --added special skill to Warrior
 *    --made Warrior and Ogre battle
 *    --created Sorceress
 *    --created Thief
 *    --created Skeleton
 *    --created Gremlin
 *    --added game play features to DungeonAdventure.java (this file)
 *  11/27/2001: Finished documenting program
 * version 1.0
 */

public class DungeonAdventure implements GameOverListener {
	private Dungeon dungeon;
	private boolean gameOver;
	public DungeonAdventure() {
		Dungeon dungeon = new Dungeon(HeroFactory.chooseHero(this), this);
		gameOver = false;
	}

	public static void main(String[] args) {
		mainMenu();
	}

	@Override
	public void onGameOver(boolean won) {

		gameOver = true;
		if (won) {
			System.out.println("Congrats you beat the game! You found all 4 pillars of OO!");
		} else {
			System.out.println("Oh no! You died!");
		}
		System.out.println(dungeon.toString());
		if(playAgain()) {
			new DungeonAdventure();
		}
	}

	public boolean playAgain()
	{
		char again;
		System.out.println("Play again (y/n)?");
		again = Keyboard.kb.next().trim().charAt(0);

		return (again == 'Y' || again == 'y');
	}//end playAgain method

	public static void mainMenu() {
		boolean gameSet = false;
		do {
			Menu.menuChoices();
			String choice = Keyboard.kb.nextLine();
			switch (choice) {
				case "1":
					new DungeonAdventure();
					gameSet = true;
					break;
				case "2":
					Menu.aboutHeros();
					gameSet = true;
					break;
				case "3":
					Menu.howToPlay();
					gameSet = true;
					break;
				case "4":
					System.exit(0);
			}

		} while (!gameSet);

	}
}