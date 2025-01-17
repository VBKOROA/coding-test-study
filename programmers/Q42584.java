package programmers;

import java.util.Stack;

public class Q42584 {
    static class Solution {
        public Integer[] solution(int[] prices) {
            // 가격을 저장할 스택 생성
            Stack<Integer> priceStack = new Stack<>();
            // 첫 번째 가격을 스택에 push
            priceStack.push(prices[0]);
            // 결과를 저장할 배열 생성
            Integer[] result = new Integer[prices.length];

            // 인덱스 초기화
            int idx = 1;

            // 주식 가격 배열을 순회
            for (; idx < prices.length; idx++) {
                // 현재 가격 저장
                int curPrice = prices[idx];
                // 스택이 비어있지 않고, 스택의 top이 현재 가격보다 큰지 확인
                boolean condition = !priceStack.empty() && priceStack.peek() > curPrice;
                if (condition) {
                    // 가격이 떨어진 기간을 계산하기 위한 변수
                    int num = 1;
                    // 스택이 비어있지 않을 때까지 반복
                    while (!priceStack.empty()) {
                        // 결과가 계산되지 않은 경우
                        if (result[idx - num] == null) {
                            int prevPrice = priceStack.peek();
                            // 이전 가격이 현재 가격보다 높은 경우
                            if (prevPrice > curPrice) {
                                // 스택에서 제거하고 결과 저장
                                priceStack.pop();
                                result[idx - num] = num;

                            } else {
                                break;
                            }
                        }
                        // 이전 가격을 확인
                        num++;
                    }
                }
                // 현재 가격을 스택에 push
                priceStack.push(curPrice);
            }

            // 아직 결과가 계산되지 않은 가격들에 대해 처리
            for (int i = 0; i < result.length; i++) {
                if (result[i] == null) {
                    // 끝까지 가격이 떨어지지 않은 경우
                    result[i] = result.length - 1 - i;
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        for (int i : sol.solution(new int[] { 5, 8, 6, 2, 4, 1 })) {
            System.out.println(i);
        }
    }
}
