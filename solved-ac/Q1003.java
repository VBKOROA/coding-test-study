import java.io.*;

public class Q1003 {
    static Integer[][] dp = new Integer[41][2]; // 0 <= n <= 40
    static int calculated = 1;

    /**
     * 피보나치 수열의 0과 1의 호출 횟수를 계산하는 메서드
     * 동적 프로그래밍(DP) 방식을 사용하여 중복 계산을 방지
     * dp[n][0]은 n번째 피보나치 수를 계산할 때 0이 출력되는 횟수
     * dp[n][1]은 n번째 피보나치 수를 계산할 때 1이 출력되는 횟수
     * 
     * 동작 과정:
     * 1. dp[n]이 null인 경우 (아직 계산되지 않은 경우)
     * 2. n-1번째와 n-2번째 피보나치 수의 0,1 호출 횟수를 재귀적으로 계산
     * 3. 현재 n에 대한 0,1 호출 횟수는 n-1번째와 n-2번째의 각각의 합
     * 
     * @param n 계산하고자 하는 피보나치 수의 인덱스
     * @return Integer[] 배열로 [0의 호출 횟수, 1의 호출 횟수] 반환
     */
    static Integer[] fibonacciTopDown(int n) {
    
        if(dp[n][0] == null || dp[n][1] == null) {
            Integer[] first = fibonacciTopDown(n-1);
            Integer[] second = fibonacciTopDown(n-2);
            dp[n][0] = first[0] + second[0]; 
            dp[n][1] = first[1] + second[1]; 
        }
        return dp[n];
    }

    static Integer[] fibonacciBottomUp(int n) {
        if(dp[n][0] != null) {
            return dp[n];
        }
        for(int i = calculated+1; i <= n; i++) {
            dp[i][0] = dp[i-1][0]+dp[i-2][0];
            dp[i][1] = dp[i-1][1]+dp[i-2][1];
        }
        calculated = n;
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(cnt-- > 0) {
            Integer[] sol = fibonacciBottomUp(Integer.parseInt(br.readLine()));
            sb.append(sol[0]).append(" ").append(sol[1]).append("\n");
        }
        System.out.print(sb);
    }

    // dp bottom up 짱짱..!!
}