import java.io.*;
import java.util.*;

public class Q10828 {
    static class Stack {
        int[] content;
        int length;
    
        public Stack() {
            content = new int[0];
            length = 0;
        }
    
        public void push(int n) {
            int[] arr = new int[length+1];
            for(int i = 0; i < length; i++)  {
                arr[i] = content[i];
            }
            arr[length++] = n;
            content = arr;
        }
    
        public int pop() {
            if(length == 0) {
                return -1;
            }
            int ret = content[--length];
            int[] arr = new int[length];
            for(int i = 0; i < length; i++)  {
                arr[i] = content[i];
            }
            content = arr;
            return ret;
        }
    
        public int size() {
            return length;
        }
    
        public int empty() {
            return length == 0 ? 1 : 0;
        }
    
        public int top() {
            return length == 0 ? -1 : content[length-1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack stack = new Stack();
        
        int cnt = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(stack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.empty()).append("\n");
                    break;
                case "top":
                    sb.append(stack.top()).append("\n");
                    break;
            }
            
        }
        System.out.print(sb);
    }

    // 맞힌 사람 보니 대부분 String 배열로 풀고
    // 아예 배열의 최대 갯수를 명령행의 갯수로 고정시키는
    // 미친 최적화를 보여주고 있다..
    // 생각도 몬했네
}
