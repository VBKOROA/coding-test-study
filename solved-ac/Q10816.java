import java.io.*;
import java.util.*;

public class Q10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(br);
    }    

    public static void solution(BufferedReader br) throws IOException {
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();

        while(st.hasMoreTokens()) {
            int key = Integer.parseInt(st.nextToken());
            map.put(key, map.getOrDefault(key, 0)+1);
        }

        br.readLine();
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(st.hasMoreTokens()) {
            int key = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(key, 0)).append(" ");
        }
        System.out.print(sb);
    }

    // 이분 탐색 방법으로도 푸는게 있는데 다음기회에...
    // 아직 몰라서 사용할 수가 없네;
}
