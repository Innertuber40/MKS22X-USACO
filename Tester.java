import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Tester {
    public static void main(String[] args) {
        try {
            for (int i = 1; i < 6; i++) {
                File correct = new File("testCases/makelake." + i + ".out");
                Scanner yes = new Scanner(correct);
                System.out.println(USACO.bronze("testCases/makelake." + i + ".in") == yes.nextInt());
                yes.close(); 
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}