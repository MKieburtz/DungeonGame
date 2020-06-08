public class DragonWelp extends Monster
{

    public DragonWelp()
    {
        super("Nexxis the DragonWelp", 100, 5, .8, .1, 15, 30, 20, 40);

    }//end constructor

    public void normalAttack(DungeonCharacter opponent)
    {
        System.out.println(stats.name + " uses his fireball at " +
                opponent.getName() + ":");
        super.normalAttack(opponent);

    }//end override of attack


}//end class Gremlin