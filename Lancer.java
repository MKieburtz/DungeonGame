public class Lancer extends Hero {

    public Lancer() {
        super("Lancer", 95, 4, .7, 18, 30, .5);
        specialMove = new Jump(.4);

    }//end constructor

    public void normalAttack(DungeonCharacter opponent)
    {
        System.out.println(stats.name + " attacks with spear " +
                opponent.getName() + ":");
        super.normalAttack(opponent);
    }//end override of attack method
}


