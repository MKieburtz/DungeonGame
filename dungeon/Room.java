package dungeon;

import java.util.ArrayList;
import java.util.Random;

public class Room {
    private static Random random = new Random();
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


    public void populateConsumables(){

        if(random.nextInt(100) > 60){roomContents.add(new HealingPotion());}

        if(random.nextInt(100) > 80){roomContents.add(new Pit(10));}

        if(random.nextInt(100) > 60){roomContents.add(MonsterFactory.generateMonster());}

        if(random.nextInt(100) > 90){roomContents.add(new VisionPotion());}

    }

    public static Room[][] fillRooms(final Room[][] rooms,final GameOverListener listener){

        rooms[0][0].roomContents.add(new Entrance());
        rooms[5][5].roomContents.add(new Exit(listener));

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
                if (i != 0 && k != 0) {
                    if (i != 4 && k != 4) {
                        rooms[i][k].populateConsumables();
                    }
                }
            }
        }

            return rooms;
        }
}


