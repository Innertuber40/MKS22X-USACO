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
        //System.out.println(past);
        //System.out.println(stomp);
        for (int i = 0; i < N; i++) {
            int[] elevations = new int[9];
            int spot = 0;
            for (int j = -1; j < 2; j++) {
                for (int k = -1; k < 2; k++) {
                    elevations[spot] = pasture[stompDig[i][0] + j][stompDig[i][1] + k];
                    //System.out.print(elevations[spot] + " ");
                    spot++;
                }
                //System.out.println();
            }
            Sorts.insertionSort(elevations);
            for (int l = 0; l < stompDig[i][2]; l++) {
                for (int j = -1; j < 2; j++) {
                    for (int k = -1; k < 2; k++) {
                        if (pasture[stompDig[i][0] + j][stompDig[i][1] + k] == elevations[8] - l) {
                            pasture[stompDig[i][0] + j][stompDig[i][1] + k]--;
                        }
                    }
                }
            }
        }
        int depths = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                pasture[i][j] = E - pasture[i][j];
                if (pasture[i][j] > 0) {
                    depths += pasture[i][j];
                }
                //System.out.print(pasture[i][j] + " ");

            }
            //System.out.println();
        }
        return 72 * 72 * depths;
    }
    public static int silver(String myFile) throws FileNotFoundException {
        File toAnalyze = new File(myFile);
        Scanner field = new Scanner(toAnalyze);
        int N = field.nextInt();
        int M = field.nextInt();
        int T = field.nextInt();
        field.close();
        field = new Scanner(toAnalyze);
        field.nextLine();
        //System.out.println(N);
        //System.out.println(M);
        char[][] pasture = new char[N][M];
        String past = "";
        for (int i = 0; i < N; i++) {
            String thisLine = field.nextLine();
            //System.out.println(thisLine);
            for (int j = 0; j < M; j++) {
                //System.out.println(".");
                pasture[i][j] = thisLine.charAt(j);
                past = past + pasture[i][j] + " ";
            }
            past += "\n";
        }
        int R1 = field.nextInt();
        int C1 = field.nextInt();
        int R2 = field.nextInt();
        int C2 = field.nextInt();
        field.close();
        //System.out.println(past);
        //System.out.println(R1);
        //System.out.println(C2);
        return solver(R1, C1, R2, C2, 0, 0, T, pasture);
    }
    private static int solver(int y, int x, int R2, int C2, int count, int time, int max, char[][] pasture) {
		if (time == max && y == R2 && x == C2) {
			count++;
        }
        if (time < max) {
		    if (pasture[y - 1][x - 1] == '.') {
                if (x < pasture[0].length) {
                    int right = solver(y, x + 1, R2, C2, 0, time + 1, max, pasture);
                    count += right;
                }
                if (x > 1) {
                    int left = solver(y, x - 1, R2, C2, 0, time + 1, max, pasture);
                    count += left;
                }
                if (y < pasture.length) {
                    int down = solver(y + 1, x, R2, C2, 0, time + 1, max, pasture);
                    count += down;
                }
                if (y > 1) {
                    int up = solver(y - 1, x, R2, C2, 0, time + 1, max, pasture);
                    count += up;
                }
            }
        }
		return count;
	}
    
}