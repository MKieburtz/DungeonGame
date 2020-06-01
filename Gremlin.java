

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Gremlin extends Monster
{

    public Gremlin()
	{
		super("Gnarltooth the Gremlin", 70, 5, .8, .4, 15, 30, 20, 40);

    }//end constructor

	public void normalAttack(DungeonCharacter opponent)
	{
		System.out.println(stats.name + " jabs his kris at " +
							opponent.getName() + ":");
		super.normalAttack(opponent);

	}//end override of attack


}//end class Gremlin