package lastpencil;

import java.util.Random;

public class BotPlayer extends Player {

    private static final Random RANDOM = new Random();

    public BotPlayer(String name, GameIO io) {
        super(name, io);
    }

    @Override
    public int takeTurn(int pencils) {
        int taken;
        if (pencils % 4 == 0) {
            taken = 3;
        } else if (pencils % 4 == 3) {
            taken = 2;
        } else if (pencils % 4 == 2) {
            taken = 1;
        } else {
            taken = RANDOM.nextInt(1, 4);
        }
        io.print(String.valueOf(taken));
        return taken;
    }
}
