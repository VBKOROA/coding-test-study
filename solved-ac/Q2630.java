import java.io.*;
import java.util.*;

public class Q2630 {
    static int white = 0;
    static int blue = 0;
    static int size;
    static int[] count = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());

        int[][] board = new int[size][];

        for (int i = 0; i < size; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        divide(board, size);

        for(int i : count) {
            System.out.println(i);
        }
    }

    public static void divide(int[][] board, int boardSize) {
        int cur = board[0][0];
        boolean done = true;
        for (int i = 1; i < boardSize * boardSize; i++) {
            int temp = board[i / boardSize][i % boardSize];
            if (temp != cur) {
                done = false;
                break;
            }
        }
        if (done) {
            count[cur]++;
            for(int[] arr : board) {
                System.out.println(Arrays.toString(arr));
            }
            return;
        } else {
            for(int i = 0; i < 4; i++) {
                divide(realDivide(board, boardSize, i), boardSize/2);
            }
        }
    }

    public static int[][] realDivide(int[][] board, int boardSize, int area) {
        int divideSize = boardSize / 2;
        int startM = (area * divideSize) % boardSize;
        int startN = ((area * divideSize) / boardSize)*divideSize;
        int[][] cloneBoard = new int[divideSize][divideSize];

        for(int i = 0; i < divideSize; i++) {
            for(int j = 0; j < divideSize; j++) {
                System.out.println(area+" area: "+startN+i+", "+startM+j);
                cloneBoard[i][j] = board[startN+i][startM+j];
            }
        }

        return cloneBoard;
    }
}
