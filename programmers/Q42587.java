package programmers;

import java.util.*;

public class Q42587 {
    static class Solution {
        public int solution(int[] priorities, int location) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            Queue<Integer> queue = new LinkedList<>();
    
            for(int i = 0; i < priorities.length; i++) {
                pq.add(priorities[i]);
                queue.add(i);
            }
    
            int cnt = 1;
            int index = 0;
    
            while(!pq.isEmpty()) {
                int find = pq.poll();
                while(true) {
                    index = queue.poll();
                    if(priorities[index] == find) {
                        break;
                    }
                    queue.offer(index);
                }
                if(index == location) {
                    break;
                }
                cnt++;
            }
    
            return cnt;
        }
    }
}
