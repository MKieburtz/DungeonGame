public class HealingPotion implements RoomContent {

    @Override
    public void onHeroEnter(Hero hero) {
        hero.aquireHealingPotion();
    }
}