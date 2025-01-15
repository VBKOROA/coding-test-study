import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int total = Integer.parseInt(st.nextToken());
        int objective = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int max = Arrays.stream(arr).max().orElse(0);

        int cnt = 0;
        int cur = 0;
        for(;cur < max;cur++) {
            for(int i = 0; i < total; i++) {
                if(arr[i] >= max-cur) {
                    cnt++;
                }
            }
            if(cnt >= objective) {
                break;
            }
        }
        System.out.println(max-cur-1);
    }

    // 시간초과...
}
