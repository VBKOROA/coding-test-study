package programmers;

public class Q86971 {
    static class Solution {
        static boolean[][] lines;
        static int cnt;

        public int solution(int n, int[][] wires) {
            lines = new boolean[n + 1][n + 1];
            for (int[] wire : wires) {
                lines[wire[0]][wire[1]] = true;
                lines[wire[1]][wire[0]] = true;
            }

            int answer = n;
            for (int[] wire : wires) {
                cnt = 0;
                lines[wire[0]][wire[1]] = false;
                lines[wire[1]][wire[0]] = false;
                search(wire[0]);
                answer = Math.min(Math.abs(cnt - (n - cnt)), answer);
                if (cnt == n / 2) {
                    return answer;
                }
                lines[wire[0]][wire[1]] = true;
                lines[wire[1]][wire[0]] = true;
            }

            return answer;
        }

        public void search(int top) {
            cnt++;
            for (int i = 1; i < lines[top].length; i++) {
                if (lines[top][i] == true) {
                    lines[top][i] = false;
                    lines[i][top] = false;
                    search(i);
                    lines[top][i] = true;
                    lines[i][top] = true;
                }
            }
        }
    }
}
