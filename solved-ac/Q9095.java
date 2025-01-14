import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9095 {
    static int[] dp;
    static int calculated = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new int[11];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        int cnt = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (cnt-- > 0) {
            int i = Integer.parseInt(br.readLine());
            solution(i, sb);
        }

        System.out.print(sb);
    }

    public static void solution(int i, StringBuilder sb) {
        if (i > calculated) {
            for (int j = calculated + 1; j <= i; j++) {
                dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
            }
            calculated = i;
        }
        sb.append(dp[i]).append("\n");
    }

    // 점화식을 못찾아서 거진 실패...
    // 점화식 찾는 연습을 좀 해야할듯?
}
