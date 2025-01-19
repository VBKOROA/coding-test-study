package programmers;

import java.util.Arrays;

public class Q42842 {
    static class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = {0, 0};
            for(int i = 1; i*i <= brown+yellow; i++) {
                if((brown+yellow) % i == 0) {
                    int tempY = i - 2;
                    int tempX = ((brown+yellow) / i) - 2;
                    if(tempY * tempX == yellow) {
                        answer[0] = tempX+2;
                        answer[1] = tempY+2;
                        break;
                    } 
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(24, 24)));
    }
}
