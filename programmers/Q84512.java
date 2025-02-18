package programmers;

public class Q84512 {
    static class Solution {
        static int answer;
        static char[] vowels = new char[]{'A', 'E', 'I', 'O', 'U'};
        public int solution(String word) {
            answer = 0;
            // 1. 모음 1개로 시작
            for(int i = 0; i < 5; i++) {
                // 2. A로 시작한 후, U로 끝난다.
                boolean complete = search(word, 1, ""+vowels[i]);
                // 3. 단어를 찾으면 탐색 종료
                if(complete) {
                    break;
                }
            }
            return answer;
        }
        
        public boolean search(String searchWord, int depth, String curWord) {
            // 1. 단어를 찾지 못하면 탐색 종료
            if(depth == 6) {
                return false;
            }
            // 2. 탐색 횟수 증가
            answer++;
            // 3. 단어를 찾으면 탐색 종료
            if(curWord.equals(searchWord)) {
                return true;
            }
            // 4. A로 시작한 후, U로 끝난다.
            for(int i = 0; i < 5; i++) {
                boolean complete = search(searchWord, depth+1, curWord+vowels[i]);
                if(complete) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("EIO"));
    }
}