package dungeon;

public class Warlock extends Hero
{

    public Warlock()
    {
        super("Warlock", 75, 8, .8, 25, 42, .5);
        specialMove = new SummonVoidDemon(.4);


    }//end constructor

    public void normalAttack(DungeonCharacter opponent)        //created a spell instead of a melee attack used form sorceress
    {
        System.out.println(stats.name + " summons a bolt of lightning at " +
                opponent.getName() + ":");
        super.normalAttack(opponent);
    }//end override of attack method

}