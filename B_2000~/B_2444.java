import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2444{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 5

        for(int i=1; i<=N; i++){
            sb.append(" ".repeat(N-i));
            sb.append("*".repeat(2*i-1));
            sb.append("\n");
        }

        for(int i=N-1; i>0; i--){
            sb.append(" ".repeat(N-i));
            sb.append("*".repeat(2*i-1));
            sb.append("\n");
        }

        System.out.print(sb);
    }
}