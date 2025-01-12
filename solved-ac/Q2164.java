import java.io.*;
import java.util.*;

public class Q2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        // Queue 사용법
        // queue.offer(): 큐에 데이터를 넣는다.
        // queue.poll(): 큐에서 데이터를 뺀다.
        // queue는 FIFO(First In First Out)의 구조를 가지고 있다.

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < cnt; i++) {
            queue.offer(i+1);
        }

        cnt = 0;
        while(true) {
            if(cnt % 2 == 0) {
                // 해당 if문이 poll뒤에 있으면 size가 1일때 break를 하지 않아서
                // NoSuchElementException이 발생한다.
                if(queue.size() == 1) {
                    break;
                }
                queue.poll();
            } else {
                int i = queue.poll();
                queue.offer(i);
            }
            cnt++;
        }

        System.out.print(queue.peek());
    }
}