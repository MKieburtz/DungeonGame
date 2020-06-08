package dungeon;

public class PillarOfOO implements RoomContent {
    @Override
    public void onHeroEnter(Hero hero) {
        hero.aquirePillar();
    }
}
