import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nums = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] sums = new int[nums+1];
        // 전체 누적합 배열
        for(int i = 1; i <= nums; i++) {
            sums[i] = sums[i-1]+arr[i-1];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            // 누적합 배열에서 
            // 1~end까지 더한 값에
            // 1~start-1까지 더한 값을 빼기
            // = start~end 까지의 누적합
            sb.append(sums[end] - sums[start-1]).append("\n");
        }
        System.out.print(sb);
    }

    // 1트 시간초과
    // 2트 검색 후 최적화 완료
    // 생각을 잘 해야하는 문제였음... 쉽지 않네
}
