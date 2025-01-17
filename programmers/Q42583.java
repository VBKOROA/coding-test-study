package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Q42583 {
    static class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            Queue<Integer> bridge = new LinkedList<>();
    
            int curTruck = 0;
            int weightSum = 0;
            int time = 0;
    
            while(curTruck < truck_weights.length) {
                if(bridge.size() == bridge_length) { // 만약 공간이 없다면
                    // 먼저 공간을 만들어야함
                    int n = bridge.poll(); 
                    weightSum -= n;
                } 
                if(weightSum + truck_weights[curTruck] > weight) { // 다리가 무겁다면
                    // 그냥 전진~
                    bridge.offer(0); 
                } else { // 공간도 남고 중량도 널널하다면면
                    // 차 추가~
                    bridge.offer(truck_weights[curTruck]);
                    weightSum += truck_weights[curTruck];
                    curTruck++;
                }
                time++;
            }
            return time + bridge_length;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(sol.solution(100, 100, new int[]{10}));
        System.out.println(sol.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));
    }
}
