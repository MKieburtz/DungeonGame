

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */



public class Sorceress extends Hero
{
	public final int MIN_ADD = 25;
	public final int MAX_ADD = 50;

//-----------------------------------------------------------------
    public Sorceress()
	{
		super("Sorceress", 75, 5, .7, 25, 50, .3);

		specialMove = new IncreaseHitPoints(MIN_ADD, MAX_ADD);
    }//end constructor


//-----------------------------------------------------------------
	public void normalAttack(DungeonCharacter opponent)
	{
		System.out.println(stats.name + " casts a spell of fireball at " +
							opponent.getName() + ":");
		super.normalAttack(opponent);
	}//end override of attack method

//-----------------------------------------------------------------

}//end class