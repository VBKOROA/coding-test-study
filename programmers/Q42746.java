package programmers;

import java.util.*;

public class Q42746 {
    static class Solution {
        public String solution(int[] numbers) {
            String answer = "";
            List<String> sorted = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted(new Comparator<>() {
                    @Override
                    public int compare(String prev, String next) {
                        String a = prev+next;
                        String b = next+prev;
                        return b.compareTo(a);
                    }
                })
                .toList();
            for (String s : sorted) {
                answer += s;
            }

            if(answer.startsWith("0")) {
                return "0";
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] numbers = new int[] { 6, 10, 2 };
        System.out.println(sol.solution(numbers));
    }
}