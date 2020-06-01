public class IncreaseHitPoints implements SpecialMove {
    private final int MIN_ADD, MAX_ADD;

    public IncreaseHitPoints(int min_add, int max_add) {
        MIN_ADD = min_add;
        MAX_ADD = max_add;
    }

    @Override
    public void preformSpecial(Hero attacker, Monster opponent) {
        int hPoints;

        hPoints = (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
        attacker.addHitPoints(hPoints);
        System.out.println(attacker.getName() + " added [" + hPoints + "] points.\n"
                + "Total hit points remaining are: "
                + attacker.getHitPoints());
        System.out.println();
    }

    @Override
    public String getName() {
        return "Increase Hit Points";
    }
}
