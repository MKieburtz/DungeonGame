package dungeon;

public class HeroFactory extends Hero{

    public HeroFactory(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin, int damageMax, double chanceToBlock, GameOverListener listener) {
        super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, chanceToBlock);
    }
    /*-------------------------------------------------------------------
                  chooseHero allows the user to select a hero, creates that hero, and
                  returns it.  It utilizes a polymorphic reference (dungeon.dungeon.Hero) to accomplish
                  this task. This was moved from dungeon.Dungeon to dungeon.dungeon.MonsterFactory to create heros.
                  ---------------------------------------------------------------------*/
    public static Hero chooseHero(GameOverListener listener)
    {
        int choice;

        System.out.println("Choose a hero:\n" +
                "1. Warrior\n" +
                "2. Sorceress\n" +
                "3. Thief\n" +
                "4. Lancer\n" +
                "5. Warlock");
        choice = Integer.parseInt(Keyboard.kb.nextLine()); // this is Erics
        Hero hero;
        switch(choice)
        {
            case 1: hero = new Warrior();
                    break;
            case 2: hero = new Sorceress();
                    break;
            case 3: hero = new Thief();
                    break;
            case 4: hero = new Lancer();
                    break;
            case 5: hero = new Warlock();
                    break;
            default: System.out.println("invalid choice, returning Thief");
                hero = new Thief();
        }//end switch
        hero.setGameOverListener(listener);
        return hero;
    }//end chooseHero method
}//end dungeon.HeroFactory class