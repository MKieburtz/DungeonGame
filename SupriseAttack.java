public class SupriseAttack implements SpecialMove {

    private double supriseThreshold, blockThreshold;

    public SupriseAttack(double supriseThreshold, double blockThreshold) {
        this.supriseThreshold = supriseThreshold;
        this.blockThreshold = blockThreshold;
    }

    @Override
    public void preformSpecial(Hero attacker, Monster opponent) {
        double surprise = Math.random();
        if (surprise <= supriseThreshold)
        {
            System.out.println("Surprise attack was successful!\n" +
                    attacker.getName() + " gets an additional turn.");
            attacker.incrementNumTurns();
            attacker.normalAttack(opponent);
        }//end surprise
        else if (surprise >= blockThreshold)
        {
            System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
                    " blocked your attack!");
        }
        else
            attacker.normalAttack(opponent);
    }

    @Override
    public String getName() {
        return "Surprise Attack";
    }
}
