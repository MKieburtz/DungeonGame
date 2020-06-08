import java.util.Random;
public class Pit implements RoomContent {

    private int maxDamage;
    private final int minDamage = 1;

    public Pit(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public void onHeroEnter(Hero hero) {
        Random rand = new Random();
        int damage = minDamage + rand.nextInt(maxDamage);
        System.out.println(hero.getName() + " fell into a pit!");
        hero.loseHealth(damage, false);
    }
}