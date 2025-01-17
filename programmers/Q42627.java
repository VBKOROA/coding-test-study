package programmers;

import java.util.*;

public class Q42627 {
    static class Solution {
        public int solution(int[][] jobs) {
            // 0 - index
            // 1 - requestTime
            // 2 - doingTime
            int jobsSize = jobs.length;

            PriorityQueue<int[]> diskController = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] prev, int[] next){
                    if(prev[1] != next[1]) {
                        return prev[1] - next[1];
                    }
                    return 0;
                }
            });

            PriorityQueue<int[]> waitQueue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] prev, int[] next) {
                    if(prev[2] != next[2]) {
                        return prev[2] - next[2];
                    } else if (prev[1] != next[1]) {
                        return prev[1] - next[1];
                    } else if (prev[0] != next[0]) {
                        return prev[0] - next[0];
                    }
                    return 0;
                }
            });

            for(int i = 0; i < jobs.length; i++) {
                diskController.offer(new int[]{i, jobs[i][0], jobs[i][1]});
            }

            int endJobTime = -1;
            int turnAround = 0;
            int time = 0;
            while(!(diskController.isEmpty() && waitQueue.isEmpty())) {
                System.out.println("loop");
                if(endJobTime == time) { // 만약 작업 끝 시간에 다다랐다면.
                    endJobTime = -1; // 작업 끗
                    System.out.println("work end: "+time);
                }
                while(!diskController.isEmpty() && time == diskController.peek()[1]) { // 현재 시간이 최소 작업 요청 시간이라면 
                    waitQueue.offer(diskController.poll()); // 대기큐에 삽입!
                    System.out.println("wait added");
                }
                if(endJobTime == -1 && !waitQueue.isEmpty()) { // 만약 현재 진행중인 작업이 없다면
                    int[] temp = waitQueue.poll(); // 대기큐에서 작업 빼.
                    endJobTime = time+temp[2]; // 작업 시작.
                    turnAround += endJobTime - temp[1];
                    System.out.println("work start: "+endJobTime);
                }
                time++;
            }

            return turnAround/jobsSize;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] jobs = new int[][] {{0, 3}, {1, 9}, {3, 5}};
        System.out.println(sol.solution(jobs));
    }
}
