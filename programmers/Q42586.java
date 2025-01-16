package programmers;

import java.util.*;

public class Q42586 {
    static class Solution {
        public List<Integer> solution(int[] progresses, int[] speeds) {
            int[] taking = new int[progresses.length];
            for(int i = 0; i < progresses.length; i++) {
                taking[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]); 
            }
            int max = taking[0];
            List<Integer> arr = new ArrayList<>();
            arr.add(1);
            for(int i = 1; i < taking.length; i++) {
                if(max < taking[i]) {
                    arr.add(1);
                    max = taking[i];
                } else {
                    arr.set(arr.size()-1, arr.get(arr.size()-1)+1);
                }
            }
            return arr;
        }
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] testCaseOne = new int[][]{{93, 30, 55}, {1, 30, 5}};
        int[][] testCaseTwo = new int[][]{{95, 90, 99, 99, 80, 99}, {1, 1, 1, 1, 1, 1}};
        System.out.println(sol.solution(testCaseOne[0], testCaseOne[1]));
        System.out.println(sol.solution(testCaseTwo[0], testCaseTwo[1]));
    }
}
