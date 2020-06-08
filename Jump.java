public class Jump implements SpecialMove {

    private double jump;

    public Jump(double chance) {
        this.jump = chance;
    }

    @Override
    public void preformSpecial(Hero attacker, Monster opponent)

    {
        if (Math.random() <= jump)
        {
            int blowPoints = (int)(Math.random() * 76) + 100;
            System.out.println(attacker.getName() + " jumps and deals " + blowPoints
                    + " damage!");
            opponent.loseHealth(blowPoints);
        }//end blow succeeded

        else
        {
            System.out.println(attacker.getName() + " failed to jump");
            System.out.println();
        }//blow failed
    }

    @Override
    public String getName() {
        return "Preform jump on opponent";
    }
}