

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Skeleton extends Monster
{

    public Skeleton()
	{
		super("Sargath the Skeleton", 100, 3, .8, .3, 30, 50, 30, 50);

    }//end constructor

	public void normalAttack(DungeonCharacter opponent)
	{
		System.out.println(stats.name + " slices his rusty blade at " +
							opponent.getName() + ":");
		super.normalAttack(opponent);

	}//end override of attack


}//end class Skeleton