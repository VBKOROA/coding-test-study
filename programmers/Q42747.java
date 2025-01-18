package programmers;

import java.util.*;

public class Q42747 {
    static class Solution {
        public int solution(int[] citations) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i : citations) {
                pq.offer(i);
            }

            int result = 0;
            int idx = 0;
            while(idx <= pq.size()) {
                result = idx;
                while(!pq.isEmpty() && pq.peek() == idx) {
                    pq.poll();
                } 
                idx++;
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{3, 0, 6, 1, 5}));
    }
}
