package dungeon;

import java.sql.SQLOutput;

public class DungeonAdventure implements GameOverListener {
    private Dungeon dungeon;
    private boolean gameOver;

    public DungeonAdventure() {
        Dungeon dungeon = new Dungeon(HeroFactory.chooseHero(this), this);
        gameOver = false;
    }
    public static void main(String[] args) {
        new DungeonAdventure();
    }

    @Override
    public void onGameOver(boolean won) {
        gameOver = true;
        if (won) {
            System.out.println("Congrats you beat the game! You found all 4 pillars of OO!");
        } else {
            System.out.println("Oh no! You died!");
        }
        System.out.println(dungeon.toString());
        if(playAgain()) {
            new DungeonAdventure();
        }
    }

    public boolean playAgain()
    {
        char again;

        System.out.println("Play again (y/n)?");
        again = Keyboard.kb.next().trim().charAt(0);

        return (again == 'Y' || again == 'y');
    }//end playAgain method
}
