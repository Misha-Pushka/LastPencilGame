package lastpencil;

public class HumanPlayer extends Player {

    public HumanPlayer(String name, GameIO io) {
        super(name, io);
    }

    @Override
    public int takeTurn(int pencils) {
        while (true) {
            String input = io.readLine().trim();
            if (input.matches("[1-3]")) {
                int taken = Integer.parseInt(input);
                if (taken <= pencils) {
                    return taken;
                } else {
                    io.print("Too many pencils were taken");
                }
            } else {
                io.print("Possible values: '1', '2', or '3'");
            }
        }
    }
}
