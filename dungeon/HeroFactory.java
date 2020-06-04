package dungeon;

public class HeroFactory extends Hero{

    public HeroFactory(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin, int damageMax, double chanceToBlock) {
        super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, chanceToBlock);
    }
    /*-------------------------------------------------------------------
                  chooseHero allows the user to select a hero, creates that hero, and
                  returns it.  It utilizes a polymorphic reference (dungeon.dungeon.Hero) to accomplish
                  this task. This was moved from dungeon.Dungeon to dungeon.dungeon.MonsterFactory to create heros.
                  ---------------------------------------------------------------------*/
    public static Hero chooseHero()
    {
        int choice;

        System.out.println("Choose a hero:\n" +
                "1. Warrior\n" +
                "2. Sorceress\n" +
                "3. Thief");
        choice = Integer.parseInt(Keyboard.kb.nextLine()); // this is Erics

        switch(choice)
        {
            case 1: return new Warrior();

            case 2: return new Sorceress();

            case 3: return new Thief();

            default: System.out.println("invalid choice, returning Thief");
                return new Thief();
        }//end switch
    }//end chooseHero method
}//end dungeon.HeroFactory class


