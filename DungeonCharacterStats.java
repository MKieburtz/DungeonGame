public class DungeonCharacterStats {
    protected String name;
    protected int hitPoints;
    protected int attackSpeed;
    protected double chanceToHit;
    protected int damageMin, damageMax;

    public DungeonCharacterStats(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin, int damageMax)
    {

        this.name = name;
        this.hitPoints = hitPoints;
        this.attackSpeed = attackSpeed;
        this.chanceToHit = chanceToHit;
        this.damageMin = damageMin;
        this.damageMax = damageMax;
    }//end constructor
}
