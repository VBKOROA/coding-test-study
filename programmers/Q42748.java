package programmers;

import java.util.*;

public class Q42748 {
    static class Solution {
        public List<Integer> solution(int[] array, int[][] commands) {
            List<Integer> answer = new ArrayList<>();
            for(int[] command : commands) {
                int[] arrCp = Arrays.copyOfRange(array, command[0]-1, command[1]);
                Arrays.sort(arrCp);
                answer.add(arrCp[command[2]-1]);
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(sol.solution(arr, commands).toString());
    }
}
