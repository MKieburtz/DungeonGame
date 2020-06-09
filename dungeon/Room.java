package dungeon;

import java.util.ArrayList;

public class Room {
    private Dungeon dungeon;
    private int x, y;
    private ArrayList<RoomContent> roomContents;

    public Room(Dungeon dungeon, int x, int y) {
        this.dungeon = dungeon;
        this.x = x;
        this.y = y;
    }

    public boolean hasMultipleItems() {
        return roomContents.size() > 1;
    }

    public ArrayList<RoomContent> getRoomContents() { return roomContents; }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void revealSurroundingRooms() {
        dungeon.revealSurroundingRooms(this);
    }
}
