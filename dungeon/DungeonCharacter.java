package dungeon;

/**
 * Title: dungeon.DungeonCharacter.java
 *
 * Description: Abstract Base class for inheritance hierarchy for a
 *              role playing game
 *
 *  class variables (all will be directly accessible from derived classes):
 *    name (name of character)
 *    hitPoints (points of damage a character can take before killed)
 *    attackSpeed (how fast the character can attack)
 *    chanceToHit (chance an attack will strike the opponent)
 *    damageMin, damageMax (range of damage the character can inflict on
 *     opponent)
 *
 *  class methods (all are directly accessible by derived classes):
 *    dungeon.DungeonCharacter(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax)
	  public String getName()
	  public int getHitPoints()
	  public int getAttackSpeed()
	  public void addHitPoints(int hitPoints)
	  public void subtractHitPoints(int hitPoints) -- this method will be
	    overridden
	  public boolean isAlive()
	  public void attack(dungeon.DungeonCharacter opponent) -- this method will be
	    overridden
 *
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public abstract class DungeonCharacter implements Comparable
{
	protected DungeonCharacterStats stats;

	public int compareTo(Object o)
	{
		return 1;
	}

//-----------------------------------------------------------------
//explicit constructor to initialize instance variables -- it is called
// by derived classes
	public DungeonCharacter(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax)
	{

		stats = new DungeonCharacterStats(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);

	}//end constructor

//-----------------------------------------------------------------
	public String getName()
	{
		return stats.name;
	}//end getName

//-----------------------------------------------------------------
	public int getHitPoints()
	{
		return stats.hitPoints;
	}//end getHitPoints
//-----------------------------------------------------------------
	public int getAttackSpeed()
	{
		return stats.attackSpeed;
	}//end getAttackSpeed


/*-------------------------------------------------------
addHitPoints is used to increment the hitpoints a dungeon character has

Receives: number of hit points to add
Returns: nothing

This method calls: nothing
This method is called by: heal method of monsters and dungeon.Sorceress
---------------------------------------------------------*/
	public void addHitPoints(int hitPoints)
	{
		if (hitPoints <=0)
			System.out.println("Hitpoint amount must be positive.");
		else
		{
			stats.hitPoints += hitPoints;
			//System.out.println("Remaining Hit Points: " + hitPoints);

		}
	}//end addHitPoints method

/*-------------------------------------------------------
subtractHitPoints is used to decrement the hitpoints a dungeon character has.
It also reports the damage and remaining hit points (these things could be
done in separate methods to make code more modular ;-)

Receives: number of hit points to subtract
Returns: nothing

This method calls: nothing
This method is called by: overridden versions in dungeon.Hero and dungeon.Monster
---------------------------------------------------------*/
	public void loseHealth(int hitPoints)
	{
		if (hitPoints <= 0)
			System.out.println("Hitpoint amount must be positive.");
		else {
			stats.hitPoints -= hitPoints;
			if (stats.hitPoints < 0)
				stats.hitPoints = 0;
			reportHealthLoss(hitPoints);
			System.out.println();
		} //end else if

		if (stats.hitPoints == 0)
			System.out.println(stats.name + " has been killed.");


	}//end method

	private void reportHealthLoss(int damage) {
		System.out.println(getName() + " hit " +
				"for <" + damage + "> points damage.");
		System.out.println(getName() + " now has " +
				getHitPoints() + " hit points remaining.");
	}



/*-------------------------------------------------------
isAlive is used to see if a character is still alive by checking hit points

Receives: nothing
Returns: true is hero is alive, false otherwise

This method calls: nothing
This method is called by: unknown (intended for external use)
---------------------------------------------------------*/
    public boolean isAlive()
	{
	  return (stats.hitPoints > 0);
	}//end isAlive method

/*-------------------------------------------------------
attack allows character to attempt attack on opponent.  First, chance to hit
is considered.  If a hit can occur, then the damage is calculated based on
character's damage range.  This damage is then applied to the opponenet.

Receives: opponent being attacked
Returns: nothing

This method calls: Math.random(), subtractHitPoints()
This method is called by: overridden versions of the method in monster and
hero classes and externally
---------------------------------------------------------*/
	public void normalAttack(DungeonCharacter opponent)
	{
		boolean canAttack;
		int damage;

		canAttack = Math.random() <= stats.chanceToHit;

		if (canAttack)
		{
			damage = (int)(Math.random() * (stats.damageMax - stats.damageMin + 1))
						+ stats.damageMin ;
			opponent.loseHealth(damage);

			System.out.println();
		}//end if can attack
		else
		{

			System.out.println(getName() + "'s attack on " + opponent.getName() +
								" failed!");
			System.out.println();
		}//end else

	}//end attack method

//-----------------------------------------------------------------



}//end class Character