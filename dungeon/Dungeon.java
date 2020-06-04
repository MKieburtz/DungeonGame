package dungeon;

public class Dungeon {
    private static boolean goNorth = false;
    private static boolean goSouth = false;
    private static boolean goEast = false;
    private static boolean goWest = false;

    public static Room[][] newDungeon() {
        Room[][] dungeon = new Room[5][5];
        for (int i = 0; i < dungeon.length; i++) {
            for(int k = 0; k < dungeon.length; k++) {
                //dungeon[i][k] =
            }
        }
        Hero.setCurrRoom(dungeon[1][1]);  //This is where the hero will start
        return dungeon;
    }

    public boolean roomExists(int x, int y) {
        return (rowExists(x)) && (colExists(y));
    }

    public boolean rowExists(int x) {
        return (x >= 0) && (x <= 4);
    }

    public boolean colExists(int y) {
        return (y >= 0) && (y <= 4);
    }
}
