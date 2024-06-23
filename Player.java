package lastpencil;


abstract class Player {

    private final String name;
    protected final GameIO io;

    public Player(String name, GameIO io) {
        this.name = name;
        this.io = io;
    }

    public String getName() {
        return name;
    }

    public abstract int takeTurn(int pencils);
}
