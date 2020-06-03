package dungeon;

public class Siren extends Monster
{

    public Siren()
    {
        super("Silva the dungeon.Siren", 80, 5, .8, .4, 20, 30, 20, 40);

    }//end constructor

    public void attack(DungeonCharacter opponent)
    {
        System.out.println(stats.name + "  screams at " +
                opponent.getName() + ":");
        super.normalAttack(opponent);

    }//end override of attack


}//end class dungeon.Gremlin
