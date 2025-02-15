package programmers;

public class Q87946 {
    static class Solution {
        static boolean[] visited;
        static int[][] allDungeons;
        static int answer = 0;

        public int solution(int k, int[][] dungeons) {
            allDungeons = dungeons;
            visited = new boolean[allDungeons.length];

            search(k, 0);
            return answer;
        }

        // 완전 탐색 구현
        private void search(int k, int cnt) {
            answer = Math.max(answer, cnt);
            for (int i = 0; i < allDungeons.length; i++) {
                int afterK = k - allDungeons[i][1];
                if (!visited[i] && exploreValid(k, afterK, i)) {
                    visited[i] = true;
                    search(afterK, cnt + 1);
                    visited[i] = false;
                }
            }
        }

        // 조건 처리
        private boolean exploreValid(int k, int afterK, int i) {
            boolean condition1 = k >= allDungeons[i][0];
            boolean condition2 = afterK >= 0;
            return condition1 && condition2;
        }
    }
}
