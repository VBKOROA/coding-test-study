package programmers;

public class Q43165 {
    static class Solution {
        static int[] numbers;
        static int target;
        static int answer = 0;

        public int solution(int[] numbers, int target) {
            Solution.numbers = numbers;
            Solution.target = target;

            // 1. 첫 번째 숫자로 시작
            search(1, Solution.numbers[0]);
            search(1, (Solution.numbers[0]) * -1);
            return answer;
        }

        public void search(int depth, int num) {
            // 1. 모든 숫자를 탐색했을 때
            if(depth == numbers.length) {
                if(num == target) {
                    // 2. 타겟 숫자와 일치하면 정답 증가
                    answer++;
                }
            // 3. 모든 숫자를 탐색하지 않았을 때
            } else {
                // 4. 다음 숫자로 이동
                search(depth+1, num + numbers[depth]);
                search(depth+1, num - numbers[depth]);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{4,1,2,1};
        System.out.println(solution.solution(nums, 2));
    }
}
