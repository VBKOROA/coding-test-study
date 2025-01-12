import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        usingSet(br);
        System.out.println();
        usingBinarySearch(br);
    }

    // set을 사용하는 방식
    // 시간 복잡도: O(N+M)
    // N: set의 크기
    // M: 찾아야 하는 수의 개수
    public static void usingSet(BufferedReader br) throws IOException {
        int cnt = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>(cnt);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        cnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // get time collapse if use set.contains() in for loop

        var startTime = System.currentTimeMillis();

        for (int i = 0; i < cnt; i++) {
            sb.append(set.contains(Integer.parseInt(st.nextToken())) ? 1 : 0)
                    .append("\n");
        }

        var endTime = System.currentTimeMillis();
        sb.append("Time: ").append(endTime - startTime).append("ms");

        System.out.print(sb);
    }

    // Arrays.sort 후 binarySearch 사용하는 방식
    // 시간 복잡도: O(NlogN + MlogN)
    // N: 배열의 크기
    // M: 찾아야 하는 수의 개수
    public static void usingBinarySearch(BufferedReader br) throws IOException {
        int cnt = Integer.parseInt(br.readLine());
        int[] arr = new int[cnt];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        cnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        // get time collapse if use Arrays.binarySearch() in for loop

        var startTime = System.currentTimeMillis();

        Arrays.sort(arr);
        for(int i = 0; i < cnt; i++) {
            int j = Integer.parseInt(st.nextToken());
            sb.append(Arrays.binarySearch(arr, j) > -1 ? 1 : 0).append("\n");
        }

        var endTime = System.currentTimeMillis();
        sb.append("Time: ").append(endTime - startTime).append("ms");

        System.out.print(sb);
    }

    // Arrays.stream을 사용하면 100ms가 추가되어서 사용안함.
}
