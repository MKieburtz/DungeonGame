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
		howToPlay();
		Dungeon dungeon = new Dungeon(HeroFactory.chooseHero(this), this);
		gameOver = false;
	}

	public static void main(String[] args) {
		new DungeonAdventure();
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
		if (playAgain()) {
			new DungeonAdventure();
		}
	}

	public boolean playAgain() {
		char again;
		System.out.println("Play again (y/n)?");
		again = Keyboard.kb.next().trim().charAt(0);

		return (again == 'Y' || again == 'y');
	}//end playAgain method

	public void howToPlay() {
		System.out.println("------------------------------------------------------------\n" +
						"*          ****WELCOME TO DUNGEON ADVENTURE****           *\n" +
				"------------------------------------------------------------\n" +
				"*                  HOW TO PLAY                            *\n" +
				"------------------------------------------------------------\n" +
				"*The goal of the game to collect the four pillars of Object*\n" +
				"*Oriented(OO) and exit the dungeon. You first get to choose*\n" +
				"*from the 5 special heros and create a name for yourself.  *\n" +
				"*Be careful though once you step in, you must get past the *\n" +
				"*traps and monsters.                                       *\n" +
				"*Not to worry there are 2 types of potions to help you     *\n" +
				"*along the way:                                            *\n" +
				"*1. Health Potion: To regain your health                   *\n" +
				"*2. Vision Potion: Helps see whats in the next rooms that  *\n" +
				"*   are around you.                                        *\n" +
				"*Find these Potions in rooms to help you along the way.    *\n" +
				"*        Good luck on your travels Adventure               *\n" +
				"------------------------------------------------------------");

	}
	
}

