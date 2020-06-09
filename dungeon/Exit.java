package dungeon;

public class Exit implements RoomContent {
    private GameOverListener listener;

    public Exit(GameOverListener listener) {
        this.listener = listener;
    }

    @Override
    public void onHeroEnter(Hero hero) {
        if (hero.pillarsFound == 4) {
            listener.onGameOver(true);
        }
    }

    @Override
    public char getIdentifier() {
        return 'O';
    }
}
