public class SummonVoidDemon implements SpecialMove {

    private double summonVoidDemon;

    public SummonVoidDemon(double chance) {
        this.summonVoidDemon = chance;
    }

    @Override
    public void preformSpecial(Hero attacker, Monster opponent)

    {
        if (Math.random() <= summonVoidDemon)
        {
            int blowPoints = (int)(Math.random() * 76) + 100;
            System.out.println(attacker.getName() + " summons void demon does " + blowPoints
                    + " damage!");
            opponent.loseHealth(blowPoints);
        }//end blow succeeded

        else
        {
            System.out.println(attacker.getName() + " failed to summon void demon");
            System.out.println();
        }//blow failed
    }

    @Override
    public String getName() {
        return "Summon void demon on Opponent";
    }
}
