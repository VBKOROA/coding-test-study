import java.io.*;
import java.util.*;

public class Q11723 {
    static Set<Integer> set = new HashSet<>(20);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        while(cnt-- > 0) {
            doMethod(br.readLine().split(" "));
        }

        System.out.print(sb);
    }

    static public void doMethod(String[] args) {
        switch(args[0]) {
            case "add":
                set.add(Integer.parseInt(args[1]));
                break;
            case "remove":
                set.remove(Integer.parseInt(args[1]));
                break;
            case "check":
                sb.append(set.contains(Integer.parseInt(args[1])) ? 1 : 0).append("\n");
                break;
            case "toggle":
                int n = Integer.parseInt(args[1]);
                if(set.contains(n)) {
                    set.remove(n);
                } else {
                    set.add(n);
                }
                break;
            case "all":
                for(int i = 1; i < 21; i++) {
                    set.add(i);
                }
                break;
            case "empty":
                set.clear();
                break;
        }
    }

    // 굳이 set으로 안해도 boolean 배열도 있고 여러 구현 방법이 있는것 같음.
}
