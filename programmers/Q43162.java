package programmers;

/**
 * 문제 설명
 *
 * 네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다. 
 * 예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고, 
 * 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다. 
 * 따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.
 * 
 * 컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 
 * 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.
 */

public class Q43162 {
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                answer++;
                visited[i] = true;
                search(i, computers);
            }
        }
        return answer;
    }

    private void search(int n, int[][] computers) {
        int[] myConnections = computers[n]; // 현재 컴퓨터의 네트워크
        for(int i = 0; i < myConnections.length; i++) { // 네트워크 전부 탐색
            if(visited[i]) continue; // 만약 이미 탐색한 컴퓨터면 continue
            if(myConnections[i] == 1) { // 만약 연결되어있는 컴퓨터라면
                visited[i] = true;
                search(i, computers); // 해당 컴퓨터의 네트워크 탐색
            }
        }
    }

    public static void main(String[] args) {
        Q43162 q43162 = new Q43162();
        int n = 3;
        int[][] computers = new int[][]{
            {1, 1, 0},
            {1, 1, 1},
            {0, 1, 1}
        };
        System.out.println(q43162.solution(n, computers));
    }
}
