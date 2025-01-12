import java.io.*;
import java.util.*;

public class Q11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.print(useArrayList(n, k));
    }

    public static String myAlgorithm(int n, int k) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i, true);
        }

        int cur = 0;
        int step = 1;
        int cnt = 0;

        String[] result = new String[n];

        /*
         * while 수도코드:
         * 1. cnt가 n이 될 때까지 반복 (모든 사람이 제거될 때까지)
         * 2. 현재 위치(cur)의 사람이 아직 제거되지 않은 경우:
         * 2-1. k번째 카운트라면:
         * - 결과 배열에 현재 위치+1을 저장
         * - 현재 위치의 사람을 제거 표시(false)
         * - 스텝 카운트를 1로 초기화
         * 2-2. k번째가 아니라면:
         * - 스텝 카운트 증가
         * 3. 다음 위치로 이동 (원형으로 돌아가도록 모듈로 연산 사용)
         */
        while (cnt != n) {
            if (map.get(cur)) {
                if (step == k) {
                    result[cnt++] = String.valueOf(cur + 1);
                    map.put(cur, false);
                    step = 1;
                } else {
                    step++;
                }
            }
            cur = (cur + 1) % n;
        }

        return "<" + String.join(", ", result) + ">";
    }

    public static String useArrayList(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }

        int index = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("<");


        /*
         * 수도코드:
         * 1. 리스트 크기가 1보다 클 때까지 반복
         * 2. 다음 제거할 사람의 인덱스 = (현재 인덱스 + k - 1) % 리스트 크기
         *    - k-1을 하는 이유: 현재 위치도 카운트에 포함되기 때문
         * 3. 해당 인덱스의 숫자를 결과 문자열에 추가
         * 4. 해당 인덱스의 숫자를 리스트에서 제거
         */
        while (list.size() > 1) {
            index = ((index + k) - 1) % list.size();
            sb.append(list.get(index)).append(", ");
            list.remove(index);
        }
        sb.append(list.get(0)).append(">");
        return sb.toString();
    }

    // 처음에는 그냥 원시 배열이 빠를것 같아서 사용했는데
    // ArrayList가 더 빠르다...
    // 그냥 ArrayList를 사용하자.
}
