public class CrushingBlow implements SpecialMove {
    private double crushingBlowChance;

    public CrushingBlow(double chance) {
        this.crushingBlowChance = chance;
    }

    @Override
    public void preformSpecial(Hero attacker, Monster opponent)
    {
        if (Math.random() <= crushingBlowChance)
        {
            int blowPoints = (int)(Math.random() * 76) + 100;
            System.out.println(attacker.getName() + " lands a CRUSHING BLOW for " + blowPoints
                    + " damage!");
            opponent.loseHealth(blowPoints);
        }//end blow succeeded
        else
        {
            System.out.println(attacker.getName() + " failed to land a crushing blow");
            System.out.println();
        }//blow failed
    }

    @Override
    public String getName() {
        return "Crushing Blow on Opponent";
    }
}
