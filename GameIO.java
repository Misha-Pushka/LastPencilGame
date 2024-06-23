package lastpencil;

public interface GameIO {

    void print(String message);

    void printf(String format, Object... args);

    String readLine();

    void printPencils(int pencils);
}
