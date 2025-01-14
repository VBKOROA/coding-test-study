import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

// dfs를 몰라서 hashset이랑 map을 사용한 풀이.
public class Q2606 {
    static HashMap<Integer, HashSet<Integer>> nodes = new HashMap<>(); 
    static HashSet<Integer> set = new HashSet<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int coms = Integer.parseInt(br.readLine());
        for(int i = 1; i <= coms; i++) {
            nodes.put(i, new HashSet<>());
        }
        visited = new boolean[coms+1];
        int cnt = Integer.parseInt(br.readLine());
        for(int i = 0; i < cnt; i++) {
            String[] inputs = br.readLine().split(" ");
            int j = Integer.parseInt(inputs[0]);
            int k = Integer.parseInt(inputs[1]);
            nodes.get(j).add(k);
            nodes.get(k).add(j);
        }

        virus(1);
        System.out.print(Math.max(set.size()-1, 0));
    }

    public static void virus(int n) {
        set.add(n);
        visited[n] = true; 
        nodes.get(n).forEach(i -> {
            if(!visited[i]) { // 해당 숫자가 아직 탐색되지 않았다면
                virus(i);
            }
        });
    }
}
