public class Menu {

    public static void menuChoices() {
        System.out.println("-----------------------------------------------\n" +
                "*   Hello user welcome to Dungeon Adventure   *\n" +
                "-----------------------------------------------\n" +
                "This is the main menu choose from one of the following\n" +
                "------------------------------------------------------\n" +
                "1. Start Game \n" +
                "2. Hero Information \n" +
                "3. How To Play \n" +
                "4. Quit Game");
    }
/*
    public static void startGame() {
        Hero theHero;
        Monster theMonster;
        //Dungeon theDungeon;

        do
        {
            theHero = HeroFactory.chooseHero();  //Creates the hero
            theMonster = MonsterFactory.generateMonster();  //moved method generateMonster() to MonsterFactory class
            Hero.movingChoice(theHero);
            Dungeon.battle(theHero, theMonster);

        } while (DungeonGame.playAgain());

    }


 */
    public static void aboutHeros() {
        System.out.println("Here are the Heros you can choose from\n" +
                "------------------------------------------------------\n" +
                "*   Class                  ***  Stats                *\n" +
                "------------------------------------------------------\n" +
                "* Warrior: The sword       ***  Health: 125          *\n" +
                "* wielded melee fighter.   ***  Attack Speed: 4      *\n" +
                "*                          ***  Chance to Hit: .8    *\n" +
                "*                          ***  Minimal Damage: 35   *\n" +
                "*                          ***  Maximum Damage: 60   *\n" +
                "*                          ***  Chance to Block: .2  *\n" +
                "------------------------------------------------------\n" +
                "* Sorceress: The magic     ***  Health: 75          *\n" +
                "* wielded fighter who      ***  Attack Speed: 5      *\n" +
                "* can cast a fireball      ***  Chance to Hit: .7    *\n" +
                "* and can heal.            ***  Minimal Damage: 25   *\n" +
                "*                          ***  Maximum Damage: 50   *\n" +
                "*                          ***  Chance to Block: .3  *\n" +
                "------------------------------------------------------\n" +
                "* Thief: The quick         ***  Health: 75          *\n" +
                "* melee fighter.           ***  Attack Speed: 6      *\n" +
                "*                          ***  Chance to Hit: .8    *\n" +
                "*                          ***  Minimal Damage: 20   *\n" +
                "*                          ***  Maximum Damage: 40   *\n" +
                "*                          ***  Chance to Block: .5  *\n" +
                "------------------------------------------------------\n" +
                "* Lancer: The spear        ***  Health: 95           *\n" +
                "* wielded melee fighter    ***  Attack Speed: 4      *\n" +
                "* who can perform a        ***  Chance to Hit: .7    *\n" +
                "* jump attack.             ***  Minimal Damage: 18   *\n" +
                "*                          ***  Maximum Damage: 30   *\n" +
                "*                          ***  Chance to Block: .5  *\n" +
                "------------------------------------------------------\n" +
                "* Warlock: The dark magic  ***  Health: 75          *\n" +
                "* wielded fighter who      ***  Attack Speed: 8      *\n" +
                "* casts a bolt of          ***  Chance to Hit: .8    *\n" +
                "* lightening and can       ***  Minimal Damage: 25   *\n" +
                "* summon a void demon.     ***  Maximum Damage: 42   *\n" +
                "*                          ***  Chance to Block: .5  *\n" +
                "------------------------------------------------------\n"
        );
        DungeonAdventure.mainMenu();
    }

    public static void howToPlay() {
        System.out.println("------------------------------------------------------------\n" +
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
        DungeonAdventure.mainMenu();

    }

}
