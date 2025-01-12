import java.io.*;
import java.util.*;

// Comparator 사용하는거 보다 Comparable를 사용하는게 속도가 더 빠르다.
class Cord implements Comparable<Cord> {
    int x;
    int y;
    
    public Cord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 양의 정수일때는 매게변수로 받은 객체랑 자리를 바꾼다
    // 라는 식으로 외웠음.
    @Override
    public int compareTo(Cord o) {
        return this.x == o.x ? this.y - o.y : this.x - o.x;
    }

    public String toString() {
        return x + " " + y+ "\n";
    }
}

// 2차원 배열 부터는 계수 정렬 보다 Arrays.sort가 더 빠르다.
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
