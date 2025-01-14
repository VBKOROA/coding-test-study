import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1012 {
    static boolean[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            board = new boolean[n][m];
            visited = new boolean[n][m];

            for(int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                board[x][y] = true;
            }

            if(k == 1) {
                sb.append(k).append("\n");
                continue;
            }

            int cnt = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(board[i][j] && !visited[i][j]) {
                        cnt++;
                        baechu(i, j);
                    }
                }
            }

            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }

    public static void baechu(int i, int j) {
        visited[i][j] = true;
        try {
            if(board[i+1][j] && !visited[i+1][j]) {
                baechu(i+1, j);
            }
        } catch(Exception e) {}

        try {
            if(board[i-1][j] && !visited[i-1][j]) {
                baechu(i-1, j);
            }
        } catch(Exception e) {}

        try {
            if(board[i][j+1] && !visited[i][j+1]) {
                baechu(i, j+1);
            }
        } catch(Exception e) {}

        try {
            if(board[i][j-1] && !visited[i][j-1]) {
                baechu(i, j-1);
            }
        } catch(Exception e) {}
    }
}
