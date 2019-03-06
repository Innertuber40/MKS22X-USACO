import java.io.FileNotFoundException;

public class Tester {
    public static void main(String[] args) {
        try {
            USACO.bronze("testCases/makelake.1.in");
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}