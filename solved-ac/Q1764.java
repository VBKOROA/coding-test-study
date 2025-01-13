import java.io.*;
import java.util.*;

public class Q1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Boolean> map = new HashMap<>();
        while(n-- > 0) {
            map.put(br.readLine(), true);
        }

        List<String> list = new ArrayList<>();
        while(m-- > 0) {
            String name = br.readLine();
            if(map.containsKey(name)) {
                list.add(name);
            }
        }

        Collections.sort(list);
        
        StringBuilder sb = new StringBuilder();

        sb.append(list.size()).append("\n");
        for(String a : list) {
            sb.append(a).append("\n");
        }

        System.out.print(sb);
    }

    // 첫 듣도 못한 사람의 명단을 리스트에 담으면 시간 제한에 걸려버린다.
    // 중복되는 데이터가 없음으로 HashMap으로 빠르게 처리하는게 좋다.
}