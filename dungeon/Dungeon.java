package dungeon;

public class Dungeon {
    private Hero player;

    public Dungeon(Hero hero) {
        this.player = hero;
        generateDungeon();
    }

    private static boolean goNorth = false;
    private static boolean goSouth = false;
    private static boolean goEast = false;
    private static boolean goWest = false;

    private Room[][] dungeon;
    public Room[][] generateDungeon() {
        dungeon = new Room[5][5];
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
        // if it exists, start with the top left room, otherwise the room directly to the left, or the room directly to the right.
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

    // this can be a junit test
    public void testRevealSurroundingRooms() {
        revealSurroundingRooms(dungeon[1][1]);
    }

    private void printRowOfRooms(Room[] rooms) {
        // print all the rooms in the row
        // py = 0 top of the room, py = 1 middle row of the room, py = 2 bottom row of the room
        for (int py = 0; py < 3; py++) {
            for (Room r : rooms) {
                switch (py) {
                    case 0:
                        // check if there's a room above, to print a door.
                        if (roomExists(r.getX(), r.getY()-1)) {
                            System.out.print("* - * ");
                        } else {
                            System.out.print("* * * ");
                        }
                        break;
                    case 1:
                        // check if there's a room to the left then right
                        if (roomExists(r.getX()-1, r.getY())) {
                            System.out.print(" | ");
                        } else {
                            System.out.print("* ");
                        }
                        //TODO: add the letter for what's in the room
                        //for now just a space
                        System.out.print(" ");
                        
                        if (roomExists(r.getX()+1, r.getY())) {
                            System.out.print(" |");
                        } else {
                            System.out.print(" *");
                        }
                        break;
                    case 2:
                        // similarly check if there's a room below to print a door
                        if (roomExists(r.getX(), r.getY()+1)) {
                            System.out.print("* - * ");
                        } else {
                            System.out.print("* * * ");
                        }
                        break;
                }
            }
            System.out.println("");
        }
    }
}
