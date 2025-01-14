import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2606DFS {
    static int node, line;
    static boolean[] visited;
    static boolean[][] nodes;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());
        nodes = new boolean[node+1][node+1];
        visited = new boolean[node+1];
        line = Integer.parseInt(br.readLine());

        while(line-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            nodes[i][j] = true;
            nodes[j][i] = true;
        }

        dfs(1);
        System.out.println(count - 1);
    }

    public static void dfs(int n) {
        visited[n] = true; // 하위 노드 다 체크했음
        count++; // 감염됨

        for(int i = 1; i <= node; i++) {
            if(nodes[n][i] && !visited[i]) { // 만약 i가 n이랑 연결되어 있으며 i의 하위 노드가 체크 되지 않았다면
                dfs(i); // 하위노드 탐색 ㄱㄱ
            }
        }
    }
}
