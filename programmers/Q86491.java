package programmers;

public class Q86491 {
    static class Solution {
        public int solution(int[][] sizes) {
            int max = 0;
            int min = 0;
            for(int[] size : sizes) {
                if(size[0] > size[1]) {
                    max = Math.max(size[0], max);
                    min = Math.max(size[1], min);
                } else {
                    max = Math.max(size[1], max);
                    min = Math.max(size[0], min);
                }
            }
            return max*min;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}));
    }
}