import java.io.*;
import java.util.*;

public class Q9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        usingStack(br);
    }

    // 정수형을 사용한 풀이
    public static void usingInt(BufferedReader br) throws IOException {
        int cnt = Integer.parseInt(br.readLine());

        String[][] tkns = new String[cnt][];

        for (int i = 0; i < cnt; i++) {
            tkns[i] = br.readLine().split("");
        }

        outerLoop:
        for (String[] tk : tkns) {
            int openString = 0;
            for (String tkn : tk) {
                if (tkn.equals("(")) {
                    openString += 1;
                } else {
                    openString -= 1;
                    if(openString < 0) {
                        System.out.println("NO");
                        continue outerLoop;
                    }
                }
            }
            if (openString == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    // 스택 사용한 풀이
    public static void usingStack(BufferedReader br) throws IOException {
        Stack<Boolean> stack;

        int cnt = Integer.parseInt(br.readLine());

        String[][] tkns = new String[cnt][];

        for (int i = 0; i < cnt; i++) {
            tkns[i] = br.readLine().split("");
        }

        outerLoop:
        for (String[] tk : tkns) {
            stack = new Stack<>();
            // vps가 아닌 경우
            // 1. 스택에 아이템이 남아있을 경우
            // 2. 스택에 아이템이 없는데 뽑을 경우
            for (String tkn : tk) {
                if (tkn.equals("(")) {
                    stack.push(true);
                } else {
                    try {
                        stack.pop();
                    } catch (Exception e) {
                        System.out.println("NO");
                        continue outerLoop;
                    } 
                }
            }
            if (stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
