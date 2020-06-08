public class Dungeon {
    private Hero player;
    private static boolean goNorth = false;
    private static boolean goSouth = false;
    private static boolean goEast = false;
    private static boolean goWest = false;

    public Dungeon(Hero hero) {
        this.player = hero;
        generateDungeon();
    }

    public static Room[][] generateDungeon() {
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

    public void movingHero(Hero hero) {
        boolean goNorth = roomExists(Hero.getCurrX(), Hero.getCurrY() + 1);
        boolean goSouth = roomExists(Hero.getCurrX(), Hero.getCurrY() - 1);
        boolean goEast = roomExists(Hero.getCurrX() + 1, Hero.getCurrY());
        boolean goWest = roomExists(Hero.getCurrX() - 1, Hero.getCurrY());

    }


    public static boolean isgoNorth() {
        return goNorth;
    }

    public static boolean isGoSouth() {
        return goSouth;
    }

    public static boolean isGoEast() {
        return goEast;
    }

    public static boolean isGoWest() {
        return goWest;
    }
}
