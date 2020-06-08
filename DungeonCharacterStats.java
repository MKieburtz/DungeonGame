public class DungeonCharacterStats {

    protected String name;
    protected int hitPoints;
    protected int attackSpeed;
    protected double chanceToHit;
    protected int damageMin, damageMax;
    protected int maxHealth;

    public DungeonCharacterStats(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin, int damageMax)

    {
        this.name = name;
        this.hitPoints = hitPoints;
        this.attackSpeed = attackSpeed;
        this.chanceToHit = chanceToHit;
        this.damageMin = damageMin;
        this.damageMax = damageMax;

    }//end constructor

    public void heal(int healAmount) {
        if (hitPoints + healAmount > maxHealth) {
            hitPoints = maxHealth;
        } else {
            hitPoints += healAmount;
        }
    }
}