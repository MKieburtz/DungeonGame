package dungeon;

public class Dungeon {
    private Hero player;
    GameOverListener listener;

    public Dungeon(Hero hero, GameOverListener listener) {
        this.player = hero;
        generateDungeon();
    }

    private final int DUNGEON_WIDTH = 5;
    private final int DUNGEON_HEIGHT = 5;

    private static boolean goNorth = false;
    private static boolean goSouth = false;
    private static boolean goEast = false;
    private static boolean goWest = false;

    private Room[][] dungeon;
    public Room[][] generateDungeon() {
        dungeon = new Room[DUNGEON_WIDTH][DUNGEON_HEIGHT];
        for (int i = 0; i < dungeon.length; i++) {
            for(int k = 0; k < dungeon.length; k++) {
                dungeon[i][k] = new Room(this, i, k);
            }
        }
        player.setCurrRoom(dungeon[1][1]);  //This is where the hero will start
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

    public void revealSurroundingRooms(Room room) {
        // if it exists, start with the top left room.
        int startx = room.getX() - 1;
        int starty = room.getY() - 1;
        Room[] roomsToPrint = new Room[3];
        int n = 0;
        for (int y = starty; y < starty + 3; y++) {
            for (int x = startx; x < startx + 3; x++) {
                if (roomExists(x, y)) {
                    // add it to the array of rooms to print
                    //System.out.println("revealing room: " + x + " " + y + " in slot: " + n);
                    roomsToPrint[n] = dungeon[x][y];
                    n++;
                }
            }
            printRowOfRooms(roomsToPrint);
            n = 0;
        }
    }

    private String getRowOfRooms(Room[] rooms) {
        // get all the rooms in the row
        // py = 0 top of the room, py = 1 middle row of the room, py = 2 bottom row of the room
        StringBuilder row = new StringBuilder();
        for (int py = 0; py < 3; py++) {
            for (Room r : rooms) {
                switch (py) {
                    case 0:
                        // check if there's a room above, to print a door.
                        if (roomExists(r.getX(), r.getY()-1)) {
                            row.append("* - * ");
                        } else {
                            row.append("* * * ");
                        }
                        break;
                    case 1:
                        // check if there's a room to the left then right
                        if (roomExists(r.getX()-1, r.getY())) {
                            row.append(" | ");
                        } else {
                            row.append("* ");
                        }
                        // add the contents of the room
                        if (r.hasMultipleItems()) {
                            row.append("M");
                        } else if (!r.getRoomContents().isEmpty()){
                            row.append(r.getRoomContents().get(0).getIdentifier());
                        } else {
                            row.append(" ");
                        }

                        if (roomExists(r.getX()+1, r.getY())) {
                            row.append(" |");
                        } else {
                            row.append(" *");
                        }
                        break;
                    case 2:
                        // similarly check if there's a room below to print a door
                        if (roomExists(r.getX(), r.getY()+1)) {
                            row.append("* - * ");
                        } else {
                            row.append("* * * ");
                        }
                        break;
                }
            }
            row.append("\n");
        }
        return row.toString();
    }

    private void printRowOfRooms(Room[] rooms) {
        System.out.println(getRowOfRooms(rooms));
    }

    public void printRoom(Room room) {
        Room[] r = {room};
        printRowOfRooms(r);
    }

    @Override
    public String toString() {
        StringBuilder dungeonString = new StringBuilder();
        for (int y = 0; y < DUNGEON_HEIGHT; y++) {
            Room[] row = new Room[DUNGEON_WIDTH];
            for (int x = 0; x < DUNGEON_WIDTH; x++) {
                if (roomExists(x, y)) // all these rooms should exist
                    row[x] = dungeon[x][y];
            }
            dungeonString.append(getRowOfRooms(row)).append("\n");
        }
        return dungeonString.toString();
    }
}