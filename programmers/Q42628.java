package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q42628 {
    static class Solution {
        public int[] solution(String[] operations) {
            PriorityQueue<Integer> lowQueue = new PriorityQueue<>();
            PriorityQueue<Integer> highQueue = new PriorityQueue<>(Comparator.reverseOrder());
            
            for(String s : operations) {
                StringTokenizer st = new StringTokenizer(s);
                switch (st.nextToken()) {
                    case "I":
                        int value = Integer.parseInt(st.nextToken());
                        lowQueue.offer(value);
                        highQueue.offer(value);
                        break;
                    case "D":
                        try {
                            if(Integer.parseInt(st.nextToken()) == 1) {
                                lowQueue.remove(highQueue.poll());
                            } else {
                                highQueue.remove(lowQueue.poll());
                            }
                        } catch (Exception e) {}
                        break;
                }
            }

            if(lowQueue.size() == 0) {
                return new int[]{0, 0};
            } else {
                return new int[]{highQueue.peek(), lowQueue.peek()};
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})));
        System.out.println(Arrays.toString(sol.solution(new String[]{"I 10", "I 20", "D 1", "I 30", "I 40", "D -1", "D -1"})));
    }
}