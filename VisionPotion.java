public class VisionPotion implements RoomContent {

    @Override
    public void onHeroEnter(Hero hero) {
        hero.aquireVisionPotion();
    }
}