package dungeon;

public class Room {
    Dungeon dungeon;
    int x, y;
    public Room(Dungeon dungeon, int x, int y) {
        this.dungeon = dungeon;
        this.x = x;
        this.y = y;
    }

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
