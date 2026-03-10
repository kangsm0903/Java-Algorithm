import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_9498{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int score = Integer.parseInt(br.readLine());

        if(90<=score && score <= 100){
            sb.append("A");
        } else if (80<=score && score <= 89) {
            sb.append("B");
        } else if (70<=score && score <= 79) {
            sb.append("C");
        } else if (60<=score && score <= 69) {
            sb.append("D");
        } else {
            sb.append("F");
        }

        System.out.println(sb);
    }
}