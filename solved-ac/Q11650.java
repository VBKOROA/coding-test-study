/*

문제

2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
입력

첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.

*/

import java.io.*;
import java.util.*;

class Cord implements Comparable<Cord> {
    int x;
    int y;
    
    public Cord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Cord o) {
        return this.x == o.x ? this.y - o.y : this.x - o.x;
    }

    public String toString() {
        return x + " " + y+ "\n";
    }
}

public class Q11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        List<Cord> cords = new ArrayList<>();
        
        StringTokenizer st;
        for(int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            cords.add(new Cord(x, y));
        }

        Collections.sort(cords);
        
        StringBuilder sb = new StringBuilder();
        for(Cord cord : cords) {
            sb.append(cord.toString());
        }
        System.out.print(sb);
    }
}