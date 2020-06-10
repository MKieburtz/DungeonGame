    package dungeon;

    public class DungeonAdventure implements GameOverListener {
        private Dungeon dungeon;
        private Hero hero;
        private boolean gameOver;

        public DungeonAdventure() {
            playGame();
        }
        public static void main(String[] args) {
            new DungeonAdventure();
        }

        private void playGame() {
            howToPlay();
            gameOver = false;
            hero = HeroFactory.chooseHero(this);
            dungeon = new Dungeon(hero, this);
            hero.setCurrRoom(dungeon.getRoom(0, 0));
            while (!gameOver) {
                hero.info();
                System.out.println("You find yourself in a room: ");
                Room currentRoom = hero.getCurrentRoom();
                hero.getCurrentRoom().printRoom();

                giveOptions(currentRoom);

                String input;
                while (!(input=Keyboard.kb.nextLine()).matches("[NSWE]|[nswe]")) {
                    switch (input.toLowerCase()) {
                        case "v":
                            hero.consumeVisionPotion();
                            break;
                        case "h":
                            hero.consumeHealingPotion();
                            break;
                        case "reveal":
                            System.out.println("the dungeon is revealed...");
                            System.out.println(dungeon.toString());
                            giveOptions(currentRoom);
                            break;
                    }
                }

                boolean validDirection = false;
                do {
                    switch (input.toLowerCase()) {
                        case "n":
                            if (checkMoveDirection(currentRoom, 0, -1))
                                validDirection = true;
                            else
                                input=Keyboard.kb.nextLine();
                            break;
                        case "e":
                            if (checkMoveDirection(currentRoom, 1, 0))
                                validDirection = true;
                            else
                                input=Keyboard.kb.nextLine();
                            break;
                        case "s":
                            if (checkMoveDirection(currentRoom, 0, 1))
                                validDirection = true;
                            else
                                input=Keyboard.kb.nextLine();
                            break;
                        case "w":
                            if (checkMoveDirection(currentRoom, -1, 0))
                                validDirection = true;
                            else
                                input=Keyboard.kb.nextLine();
                            break;
                    }
                } while (!validDirection);
            }
        }

        private boolean checkMoveDirection(Room currentRoom, int dx, int dy) {
            if (dungeon.roomExists(currentRoom.getX()+dx, currentRoom.getY()+dy)) {
                hero.setCurrRoom(dungeon.getAdjacentRoom(currentRoom, dx, dy));
                return true;
            }
            else
                System.out.println("You can't go that way!");

            return false;
        }

        private void giveOptions(Room currentRoom) {
            System.out.println("You can: ");
            if (dungeon.roomExists(currentRoom.getX(), currentRoom.getY() - 1)) {
                System.out.println("Type N to go North.");
            }
            if (dungeon.roomExists(currentRoom.getX() + 1, currentRoom.getY())) {
                System.out.println("Type E to go East.");
            }
            if (dungeon.roomExists(currentRoom.getX(), currentRoom.getY() + 1)) {
                System.out.println("Type S to go South.");
            }
            if (dungeon.roomExists(currentRoom.getX()-1, currentRoom.getY())) {
                System.out.println("Type W to go West.");
            }
            if (hero.visionPotions > 0) {
                System.out.println("Type V to drink a vision potion.");
            }
            if (hero.healingPotions > 0) {
                System.out.println("Type H to drink a healing potion");
            }
        }

        @Override
        public void onGameOver(boolean won) {
            gameOver = true;
            if (won) {
                System.out.println("Congrats you beat the game! You found all 4 pillars of OO!");
            } else {
                System.out.println("Oh no! You died!");
            }
            System.out.println(dungeon.toString());
            if(playAgain()) {
                playGame();
            }
        }

        public boolean playAgain()
        {
            char again;

            System.out.println("Play again (y/n)?");
            again = Keyboard.kb.next().trim().charAt(0);

            return (again == 'Y' || again == 'y');
        }//end playAgain method

        public void howToPlay() {
            System.out.println("------------------------------------------------------------\n" +
                    "*                  HOW TO PLAY                            *\n" +
                    "------------------------------------------------------------\n" +
                    "*The goal of the game to collect the four pillars of Object*\n" +
                    "*Oriented(OO) programming and exit the dungeon. You first  *\n" +
                    "*get to choose from the 5 special heros and create a name  *\n" +
                    "*for yourself. Be careful though once you step in, you     *\n" +
                    "*will have to get past traps and monsters!                 *\n" +
                    "*Not to worry there are 2 types of potions to help you     *\n" +
                    "*along the way:                                            *\n" +
                    "*1. Health Potion: To regain your health                   *\n" +
                    "*2. Vision Potion: Helps see whats in the next rooms that  *\n" +
                    "*   are around you.                                        *\n" +
                    "*Find these Potions in rooms to help you.                  *\n" +
                    "*        Good luck on your travels, Adventurer             *\n" +
                    "------------------------------------------------------------");

        }
    }
