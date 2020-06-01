public class DungeonGame {

    /*-------------------------------------------------------------------
    playAgain allows gets choice from user to play another game.  It returns
    true if the user chooses to continue, false otherwise.
    ---------------------------------------------------------------------*/
    public static boolean playAgain()
    {
        char again;

        System.out.println("Play again (y/n)?");
        again = Keyboard.kb.next().trim().charAt(0);

        return (again == 'Y' || again == 'y');
    }//end playAgain method


    /*-------------------------------------------------------------------
    battle is the actual combat portion of the game.  It requires a Hero
    and a Monster to be passed in.  Battle occurs in rounds.  The Hero
    goes first, then the Monster.  At the conclusion of each round, the
    user has the option of quitting.
    ---------------------------------------------------------------------*/
    public static void battle(Hero theHero, Monster theMonster)
    {
        char pause = 'p';
        System.out.println(theHero.getName() + " battles " +
                theMonster.getName());
        System.out.println("---------------------------------------------");

        //do battle
        while (theHero.isAlive() && theMonster.isAlive() && pause != 'q')
        {
            //hero goes first
            theHero.battleChoices(theMonster);

            //monster's turn (provided it's still alive!)
            if (theMonster.isAlive())
                theMonster.normalAttack(theHero);

            //let the player bail out if desired
            System.out.print("\n-->q to quit, anything else to continue: ");
            pause = Keyboard.kb.next().trim().charAt(0);

        }//end battle loop

        if (!theMonster.isAlive())
            System.out.println(theHero.getName() + " was victorious!");
        else if (!theHero.isAlive())
            System.out.println(theHero.getName() + " was defeated :-(");
        else//both are alive so user quit the game
            System.out.println("Quitters never win ;-)");

    }//end battle method


}
