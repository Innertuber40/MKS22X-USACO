import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class USACO {
    public static int bronze(String myFile) throws FileNotFoundException {
        File toAnalyze = new File(myFile);
        Scanner instr = new Scanner(toAnalyze);
        int R = instr.nextInt();
        int C = instr.nextInt();
        int E = instr.nextInt();
        int N = instr.nextInt();
        int [][] pasture = new int[R][C];
        String past = "";
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                pasture[i][j] = instr.nextInt();
                past = past + pasture[i][j] + " ";
            }
            past += "\n";
        }
        int[][] stompDig = new int[N][3];
        String stomp = "";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                stompDig[i][j] = instr.nextInt();
                stomp += stompDig[i][j] + " ";
            }
            stomp += "\n";
        }
        instr.close();
        System.out.println(past);
        System.out.println(stomp);
        for (int i = 0; i < N; i++) {
            int[] elevations = new int[9];
            int spot = 0;
            for (int j = -1; j < 2; j++) {
                for (int k = -1; k < 2; k++) {
                    elevations[spot] = pasture[stompDig[i][0] + j][stompDig[i][1] + k];
                    System.out.print(elevations[spot] + " ");
                    spot++;
                }
                System.out.println();
            }
            Sorts.insertionSort(elevations);
        }
        return 6;
    }
    public static int silver(String myFile) {
        return 6;
    }
}