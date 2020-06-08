package dungeon;

public class DungeonAdventure {
    public static void main(String[] args) {
        Dungeon dungeon = new Dungeon(new Sorceress());
        dungeon.testRevealSurroundingRooms();
        // do stuff
    }


    public static boolean playAgain()
    {
        char again;

        System.out.println("Play again (y/n)?");
        again = Keyboard.kb.next().trim().charAt(0);

        return (again == 'Y' || again == 'y');
    }//end playAgain method
}
