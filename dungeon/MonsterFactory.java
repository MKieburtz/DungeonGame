package dungeon;

public class MonsterFactory extends Monster {


    public MonsterFactory(String name, int hitPoints, int attackSpeed, double chanceToHit, double chanceToHeal, int damageMin, int damageMax, int minHeal, int maxHeal) {
        super(name, hitPoints, attackSpeed, chanceToHit, chanceToHeal, damageMin, damageMax, minHeal, maxHeal);
    }

	/*-------------------------------------------------------------------
            generateMonster randomly selects a dungeon.dungeon.Monster and returns it.  It utilizes
            a polymorphic reference (dungeon.dungeon.Monster) to accomplish this task.
            This was moved from dungeon.Dungeon to dungeon.dungeon.MonsterFactory to create monsters.
            ---------------------------------------------------------------------*/

    public static Monster generateMonster()
    {
        int choice;

        choice = (int)(Math.random() * 5) + 1;

        switch(choice)
        {
            case 1: return new Ogre();

            case 2: return new Gremlin();

            case 3: return new Skeleton();

            case 4: return new DragonWelp();

            case 5: return new Siren();

            default: System.out.println("invalid choice, returning Skeleton");
                return new Skeleton();

        }//end switch
    }//end generateMonster method
}//end of MonsterFactory class
