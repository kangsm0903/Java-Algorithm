import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2443{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 5

        for(int i=N; i>0; i--){
            sb.append(" ".repeat(N-i));
            sb.append("*".repeat(2*i-1));
            sb.append("\n");
        }

        System.out.print(sb);
    }
}