/**
 * Title: Hero.java
 *
 * Description: Abstract base class for a hierarchy of heroes.  It is derived
 *  from DungeonCharacter.  A Hero has battle choices: regular attack and a
 *  special skill which is defined by the classes derived from Hero.
 *
 *  class variables (all are directly accessible from derived classes):
 *    chanceToBlock -- a hero has a chance to block an opponents attack
 *    numTurns -- if a hero is faster than opponent, their is a possibility
 *                for more than one attack per round of battle
 *
 *  class methods (all are public):
 *    public Hero(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock)
	  public void readName()
	  public boolean defend()
	  public void subtractHitPoints(int hitPoints)
	  public void battleChoices(DungeonCharacter opponent)

 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */


public abstract class Hero extends DungeonCharacter
{
	protected double chanceToBlock;  //field
	protected int numTurns;           //field
    protected SpecialMove specialMove;

//-----------------------------------------------------------------
//calls base constructor and gets name of hero from user
  public Hero(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock)
  {
	super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
	this.chanceToBlock = chanceToBlock;
	readName();
  }

/*-------------------------------------------------------
readName obtains a name for the hero from the user

Receives: nothing
Returns: nothing

This method calls: nothing
This method is called by: hero constructor
---------------------------------------------------------*/
  public void readName()
  {
		System.out.print("Enter character name: ");
		stats.name = Keyboard.kb.next();
  }//end readName method

/*-------------------------------------------------------
defend determines if hero blocks attack

Receives: nothing
Returns: true if attack is blocked, false otherwise

This method calls: Math.random()
This method is called by: subtractHitPoints()
---------------------------------------------------------*/
  public boolean defend()
  {
		return Math.random() <= chanceToBlock;

  }
  //end defend method
  public void incrementNumTurns() {
      numTurns++;
  }

/*-------------------------------------------------------
subtractHitPoints checks to see if hero blocked attack, if so a message
is displayed, otherwise base version of this method is invoked to
perform the subtraction operation.  This method overrides the method
inherited from DungeonCharacter promoting polymorphic behavior

Receives: hit points to subtract
Returns: nothing

This method calls: defend() or base version of method
This method is called by: attack() from base class
---------------------------------------------------------*/
public void loseHealth(int hitPoints)
	{
		if (defend())
		{
			System.out.println(stats.name + " BLOCKED the attack!");
		}
		else
		{
			super.loseHealth(hitPoints);
		}


	}//end method

/*-------------------------------------------------------
battleChoices will be overridden in derived classes.  It computes the
number of turns a hero will get per round based on the opponent that is
being fought.  The number of turns is reported to the user.  This stuff might
go better in another method that is invoked from this one...

Receives: opponent
Returns: nothing

This method calls: getAttackSpeed()
This method is called by: external sources
---------------------------------------------------------*/
	public void battleChoices(DungeonCharacter opponent)
	{
	    numTurns = stats.attackSpeed/opponent.getAttackSpeed();

		if (numTurns == 0)
			numTurns++;

		System.out.println("Number of turns this round is: " + numTurns);
        int choice;
        do
        {
            info();
            System.out.println("1. Attack Opponent");
            System.out.println("2. " + specialMove.getName());
            System.out.print("Choose an option: ");
            choice = Keyboard.kb.nextInt();

            switch (choice)
            {
                case 1: normalAttack(opponent);
                    break;
                case 2: specialMove.preformSpecial(this, (Monster) opponent);
                    break;
                default:
                    System.out.println("invalid choice!");
            }//end switch
            numTurns--;
            if (numTurns > 0)
                System.out.println("Number of turns remaining is: " + numTurns);
        } while(numTurns > 0);
    }//end battleChoices

    public void info() {
		System.out.println("Name: " + stats.name);
		System.out.println("Health: " + stats.hitPoints);
		System.out.println("Healing Potions:");
		System.out.println("Vision Potions:");
		System.out.println("Total pillars found:");
	}
}//end Hero class