

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */




public class Warrior extends Hero
{

    public Warrior()
	{

		super("Warrior", 125, 4, .8, 35, 60, .2);
		specialMove = new CrushingBlow(.4);

    }//end constructor


	public void normalAttack(DungeonCharacter opponent)
	{
		System.out.println(stats.name + " swings a mighty sword at " +
							opponent.getName() + ":");
		super.normalAttack(opponent);
	}//end override of attack method

}//end Hero class