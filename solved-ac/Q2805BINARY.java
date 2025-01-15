import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2805BINARY {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        st.nextToken();
        int objective = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int max = Arrays.stream(arr).max().orElse(0);
        int min = 0;
        int mid = 0;

        while ( min < max ) {
            mid = (max+min) / 2;

            long sum=0;
            for(int i : arr) {
                if(i - mid > 0) {
                    sum += i - mid;
                }
            }

            if(sum >= objective) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        System.out.print(min-1);
    }
    // 이진탐색
    // 음.. 코드가 잘 이해가 안되네;
    // 잘랐을때의 sum이 objective보다 크거나 같으면
    // min = mid+1로 하는데
    // 이게 무슨 의미일까?
    // 왜 objective와 sum이 같아도 min을 mid+1로 하는걸까?
    // Answer: 이진탐색은 정확히 일치하는 값을 찾는 것이 아니라
    // 조건을 만족하는 최소값을 찾는 것이기 때문에
    // sum >= objective 일때도 min을 mid+1로 해야한다.
    // 더 이해하기 쉽게 얘기해주자면
    // sum >= objective 일때는 mid가 정답이 될 수 있지만
    // sum > objective 일때는 mid가 정답이 될 수 없다.
    // 그래서 min = mid+1로 해야한다.
    // 모르겟네;;
}
