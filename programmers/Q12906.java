package programmers;

import java.util.*;

public class Q12906 {
    static class Solution {
        public int[] solution(int[] arr) {
            LinkedList<Integer> queue = new LinkedList<>();
            queue.offer(arr[0]);
            for(int i = 1; i < arr.length; i++) {
                if(queue.peekLast() == arr[i]) {
                    continue;
                }
                queue.offer(arr[i]);
            }
            return queue.stream().mapToInt(Integer::intValue).toArray();
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = new int[]{1,1,3,3,0,1,1};
        System.out.print(Arrays.toString(sol.solution(arr)));
    }
}
