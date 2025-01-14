import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11726 {
    static int dp[] = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 2;
        if(dp[n] == 0) {
            for(int i = 3; i <= n; i++) {
                dp[i] = (dp[i-1] + dp[i-2])%10007;
            }
        }
        System.out.println(dp[n]);
    }

    // 1. 점화식 만드는거 실패 (dp를 사용해야 한다는건 알겠는데..)
    // 2. 왜 각 단계에서 10007로 나눈 나머지를 기록하는거지...? 
}
