import java.io.*;
import java.util.StringTokenizer;

public class Q10845 {
    static class Queue {
        int[] content;
        int length;

        public Queue() {
            length = 0;
            content = new int[length];
        }

        public void push(int n) {
            // length + 1인 배열 생성
            // 그 안에 기본 content 복붙
            // n 삽입
            // content에 적용

            int[] temp = new int[length + 1];
            for(int i = 0; i < length; i++) {
                temp[i] = content[i];
            }
            temp[length++] = n;
            content = temp;
        }

        public int pop() {
            // content에서 0번째 반환
            // length - 1의 크기 배열 생성
            // 1부터 length까지의 요소 배열에 삽입
            // length - 1
            // content에 배열 적용

            if(length == 0) {
                return -1;
            }

            int ret = content[0];
            int[] temp = new int[length-1];
            for(int i = 1; i < length; i++) {
                temp[i-1] = content[i];
            }
            length--;
            content = temp;
            return ret;
        }

        public int size() {
            return length;
        }

        public int empty() {
            return length == 0 ? 1 : 0;
        }

        public int front() {
            return length == 0 ? -1 : content[0];
        }

        public int back() {
            return length == 0 ? -1 : content[length-1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        Queue queue = new Queue();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    queue.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(queue.pop()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.empty()).append("\n");
                    break;
                case "front":
                    sb.append(queue.front()).append("\n");
                    break;
                case "back":
                    sb.append(queue.back()).append("\n");
                    break;
            }
        }
        System.out.print(sb);
    }

    // 상위권은 죄다 String 배열 쓰거나 linkedlist로 queue를 구현함.
    // 나만 이 악물고 Queue 손수 구현했네...
    // 에라이
}