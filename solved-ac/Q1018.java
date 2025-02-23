import java.io.*;

public class Q1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine().split(" ")[0]);
        
        String[][] board = new String[cnt][];
        
        for(int i = 0; i < cnt; i++) {
            board[i] = br.readLine().split("");
        }
        
        int min = Integer.MAX_VALUE;
        
        String[][] pattern = new String[][]{{"W", "B"}, {"B", "W"}};
        
        for(int startX = 0; startX+7 < board.length; startX++) {
            for(int startY = 0; startY+7 < board[startX].length; startY++) {
                int sumA = 0;
                // int sumB = 0;
                for(int x = 0; x < 8; x++) {
                    for(int y = 0; y < 8; y++) {
                        if(!board[startX+x][startY+y].equals(pattern[x%2][y%2])) {
                            sumA++;
                        }
                        // if(!board[startX+x][startY+y].equals(pattern[x%2][(y+1)%2])) {
                        //     sumB++;
                        // }
                    }
                }
                // sumA는 하얀색으로 시작하는 경우
                // 그 반대의 경우는 단순히 전체 칸에서 sumA를 빼면 된다.
                // 그 이유는 두 경우는 서로 대칭이기 때문이다.
                min = Math.min(min, Math.min(sumA, 64-sumA));
            }
        }
        
        System.out.print(min);
    }
}