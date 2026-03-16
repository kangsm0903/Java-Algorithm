import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2445{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int space = 2*N;

        for(int i=1; i<=N; i++){
            sb.append("*".repeat(i));
            sb.append(" ".repeat(space-2*i));
            sb.append("*".repeat(i)).append('\n');
        }

        for(int i=N-1; i>0; i--){
            sb.append("*".repeat(i));
            sb.append(" ".repeat(space-2*i));
            sb.append("*".repeat(i)).append('\n');
        }

        System.out.println(sb);
    }
}

// 5
// *        *
// **      **
// ***    ***
// ****  ****
// **********
// ****  ****
// ***    ***
// **      **
// *        *
