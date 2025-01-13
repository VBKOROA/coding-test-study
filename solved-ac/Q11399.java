import java.io.*;
import java.util.*;

public class Q11399 { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[cnt];
        for(int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        int cur = arr[0];
        int sum = cur;
        
        for(int i = 1; i < cnt; i++) {
            cur += arr[i];
            sum += cur;
        }        
        
        System.out.print(sum);
    }
}