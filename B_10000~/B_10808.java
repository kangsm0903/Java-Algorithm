import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_10808{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String target = br.readLine();

        int arr[] = new int[123];

        for(int i=0; i<target.length(); i++){
            char a = target.charAt(i);
            arr[(int)a] += 1;
        }

        for(int i=97; i<123; i++){
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
        
    }
}