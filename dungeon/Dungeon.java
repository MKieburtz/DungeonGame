package dungeon;

/**
 * Title: dungeon.Dungeon.java
 *
 * Description: Driver file for Heroes and Monsters project
 *
 * Copyright:    Copyright (c) 2001
 * Company: Code Dogs Inc.
 * I.M. Knurdy
 *
 * History:
 *  11/4/2001: Wrote program
 *    --created dungeon.DungeonCharacter class
 *    --created dungeon.Hero class
 *    --created dungeon.Monster class
 *    --had dungeon.Hero battle dungeon.Monster
 *    --fixed attack quirks (dead monster can no longer attack)
 *    --made dungeon.Hero and dungeon.Monster abstract
 *    --created dungeon.Warrior
 *    --created dungeon.Ogre
 *    --made dungeon.Warrior and dungeon.Ogre battle
 *    --added battleChoices to dungeon.Hero
 *    --added special skill to dungeon.Warrior
 *    --made dungeon.Warrior and dungeon.Ogre battle
 *    --created dungeon.Sorceress
 *    --created dungeon.Thief
 *    --created dungeon.Skeleton
 *    --created dungeon.Gremlin
 *    --added game play features to dungeon.Dungeon.java (this file)
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
public class Dungeon
{
    public static void main(String[] args)
	{

		Hero theHero;
		Monster theMonster;

		do
		{
		    theHero = HeroFactory.chooseHero();
		    theMonster = MonsterFactory.generateMonster();
			DungeonGame.battle(theHero, theMonster);

		} while (DungeonGame.playAgain());

    }//end main method

}//end dungeon.Dungeon class