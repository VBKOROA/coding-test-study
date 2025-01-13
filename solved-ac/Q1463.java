import java.io.*;
import java.util.*;

public class Q1463 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int[] dp = new int[N + 1];
        dp[0] = dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1; // 현재 값에서 -1을 했을때 최소연산수 + 1
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1); // 현재 값에서 /2을 했을때 최소연산수 + 1
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1); // 현재 값에서 /3을 했을때 최소연산수 + 1
            }
        }
        System.out.println(dp[N]);
    }

    // 난 dp쪽은 top down보다 bottom up이 더 이해가 잘 되는것 같음
    // 둘 다 잘 할 수 있어야 할것 같은데 흠
}