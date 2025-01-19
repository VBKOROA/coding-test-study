package programmers;

import java.util.*;

public class Q42840 {
    static class Solution {
        public List<Integer> solution(int[] answers) {
            List<Integer> answer = new ArrayList<>();

            int[] studentA = new int[]{1, 2, 3, 4, 5};
            int[] studentB = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
            int[] studentC = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

            int studentASum = 0;
            int studentBSum = 0;
            int studentCSum = 0;

            for(int i = 0; i < answers.length; i++) {
                studentASum += answers[i] == studentA[i % studentA.length] ? 1 : 0;
                studentBSum += answers[i] == studentB[i % studentB.length] ? 1 : 0;
                studentCSum += answers[i] == studentC[i % studentC.length] ? 1 : 0;
            }

            int max = Math.max(studentASum, Math.max(studentBSum, studentCSum));

            if (studentASum == max) answer.add(1);
            if (studentBSum == max) answer.add(2);
            if (studentCSum == max) answer.add(3);

            return answer;
        }
    }
}
