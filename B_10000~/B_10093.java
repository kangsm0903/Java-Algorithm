import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_10093{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        StringBuilder sb = new StringBuilder();

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long imax = Math.max(a,b);
        long imin = Math.min(a,b);

        if(imax-imin==0){
            sb.append(0).append('\n');
        } else {
            sb.append(imax-imin-1).append('\n');
        }

        for(long i=imin+1; i<imax; i++){
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}