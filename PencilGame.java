package lastpencil;


public class PencilGame {

    private static final String JOHN = "John";
    private static final String JACK = "Jack";

    private final GameIO io;

    public PencilGame(GameIO io) {
        this.io = io;
    }

    public void start() {
        io.print("How many pencils would you like to use:");
        int pencils = getPencils();
        io.print("Who will be the first (John, Jack):");
        Player firstPlayer = getFirstPlayer();
        Player secondPlayer = firstPlayer.getName().equals(JOHN) ? new BotPlayer(JACK, io) : new HumanPlayer(JOHN, io);
        play(pencils, firstPlayer, secondPlayer);
    }

    private void play(int pencils, Player currentPlayer, Player nextPlayer) {
        while (pencils > 0) {
            io.printPencils(pencils);
            io.print(currentPlayer.getName() + "'s turn!");
            int taken = currentPlayer.takeTurn(pencils);
            pencils -= taken;
            if (pencils == 0) {
                io.print(nextPlayer.getName() + " won!");
                return;
            }
            // Swap players
            Player temp = currentPlayer;
            currentPlayer = nextPlayer;
            nextPlayer = temp;
        }
    }

    private int getPencils() {
        while (true) {
            String input = io.readLine().trim();
            if (input.matches("\\d+")) {
                int pencils = Integer.parseInt(input);
                if (pencils > 0) {
                    return pencils;
                } else {
                    io.print("The number of pencils should be positive");
                }
            } else {
                io.print("The number of pencils should be numeric");
            }
        }
    }

    private Player getFirstPlayer() {
        while (true) {
            String name = io.readLine().trim();
            if (name.equals(JOHN)) {
                return new HumanPlayer(JOHN, io);
            } else if (name.equals(JACK)) {
                return new BotPlayer(JACK, io);
            } else {
                io.printf("Choose between '%s' and '%s'%n", JOHN, JACK);
            }
        }
    }
}
