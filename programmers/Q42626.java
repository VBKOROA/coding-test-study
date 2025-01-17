package programmers;

import java.util.*;

public class Q42626 {
    static class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i : scoville) {
                pq.offer(i);
            }
            while (pq.peek() < K) {
                try {
                    int newScoville = pq.poll() + (pq.poll() * 2);
                    pq.offer(newScoville);
                    answer++;
                } catch (Exception e) {
                    return -1;
                }

            }
            return answer;
        }
    }
}