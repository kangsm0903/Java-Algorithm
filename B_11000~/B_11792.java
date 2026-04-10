import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_11792{
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = hanoi(1,3,N);

        System.out.println(result);
        System.out.println(sb);
    }

    public static int hanoi(int a, int b, int n){
        if(n==1){
            sb.append(a).append(" ").append(b).append('\n');
            return 1;
        }

        return hanoi(a, 6-a-b, n-1) + hanoi(a, b, 1) + hanoi(6-a-b, b, n-1);
    }
}