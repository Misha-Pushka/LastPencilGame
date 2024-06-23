package lastpencil;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameIO io = new ConsoleGameIO(scanner);
        PencilGame game = new PencilGame(io);
        game.start();
    }
}
