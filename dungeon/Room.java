package dungeon;

import java.util.ArrayList;
import java.util.Random;

public class Room {
    private static Random random = new Random();
    private Dungeon dungeon;
    private int x, y;
    private ArrayList<RoomContent> roomContents;

    private final int HEALING_POT_CHANCE = 40;
    private final int PIT_CHANCE = 20;
    private final int MONSTER_CHANCE = 30;
    private final int VISION_POT_CHANCE = 20;

    public Room(Dungeon dungeon, int x, int y) {
        this.dungeon = dungeon;
        this.x = x;
        this.y = y;
        roomContents = new ArrayList<>();
    }

    public void populateConsumables(){

        if(random.nextInt(100) < HEALING_POT_CHANCE){roomContents.add(new HealingPotion());}

        if(random.nextInt(100) < PIT_CHANCE){roomContents.add(new Pit(10));}

        if(random.nextInt(100) < MONSTER_CHANCE){roomContents.add(MonsterFactory.generateMonster());}

        if(random.nextInt(100) < VISION_POT_CHANCE){roomContents.add(new VisionPotion());}

    }

    public static void fillRooms(final Room[][] rooms, final GameOverListener listener){

        rooms[0][0].roomContents.add(new Entrance());
        rooms[4][4].roomContents.add(new Exit(listener));

        int p = 0;
        while(p < 4)
            for (int x = 0; x < rooms.length; x++) {
                for(int y = 0; y < rooms.length; y++) {

                    if(rooms[x][y].roomContents.size() == 0){
                        if(random.nextInt(100)>90){
                            rooms[x][y].roomContents.add(new PillarOfOO());
                            p++;
                        }
                    }

                }
            }

        for (int i = 0; i < rooms.length; i++) {
            for (int k = 0; k < rooms.length; k++) {
                if (!(i == 0 && k == 0 ||
                        i == 4 && k == 4)) {
                    rooms[i][k].populateConsumables();
                }
            }
        }
    }


    public boolean hasMultipleItems() {
        return roomContents.size() > 1;
    }

    public ArrayList<RoomContent> getRoomContents() { return roomContents; }

    public void onHeroEnter(Hero hero) {
        for (RoomContent content : roomContents) {
            content.onHeroEnter(hero);
        }
        // if there were any healing or vision potions in the room, remove them
        roomContents.removeIf(content -> content instanceof HealingPotion);
        roomContents.removeIf(content -> content instanceof VisionPotion);
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

    public void printRoom() {
        dungeon.printRoom(this);
    }

}


