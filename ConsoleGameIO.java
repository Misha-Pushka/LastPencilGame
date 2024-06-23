package lastpencil;

import java.util.Scanner;

public class ConsoleGameIO implements GameIO {

    private final Scanner scanner;

    public ConsoleGameIO(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }

    @Override
    public void printPencils(int pencils) {
        System.out.println("|".repeat(pencils));
    }

}
