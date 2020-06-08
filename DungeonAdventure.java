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



/*
  This class is the driver file for the Heroes and Monsters project.  It will
  do the following:

  1.  Allow the user to choose a hero
  2.  Randomly select a monster
  3.  Allow the hero to battle the monster

  Once a battle concludes, the user has the option of repeating the above

*/
public class DungeonAdventure
{
    public static void main(String[] args)
	{

		Hero theHero;
		Monster theMonster;

		do
		{
		    theHero = HeroFactory.chooseHero();  //Creates the hero
		    theMonster = MonsterFactory.generateMonster();  //moved method generateMonster() to MonsterFactory class
			//Hero.movingChoice(theHero);
			//DungeonGame.battle(theHero, theMonster);

		} while (DungeonGame.playAgain());

    }//end main method



	}//end Dungeon class