package dungeon;

// this interface is implemented by classes that can be in a room
public interface RoomContent {
    public void onHeroEnter(Hero hero);
}
