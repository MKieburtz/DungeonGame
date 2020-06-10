package dungeon;

public interface SpecialMove {
    void preformSpecial(Hero attacker, Monster opponent);
    String getName();
}