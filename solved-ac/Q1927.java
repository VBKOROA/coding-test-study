import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        while(cnt-- > 0) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0) {
                sb.append(pq.size() == 0 ? 0 : pq.poll()).append("\n");
            } else {
                pq.offer(input);
            }
        }
        System.out.print(sb);
    }
}
