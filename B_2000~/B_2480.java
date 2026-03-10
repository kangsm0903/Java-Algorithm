import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2480{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int result=0;

        if(a==b && b==c){
            result = 10000+a*1000;
        } else if(a!=b && b!=c && a!=c){
            if(a>b && a>c){
                result = a*100;
            } else if(b>a && b>c){
                result = b*100;
            } else if(c>a && c>b){
                result = c*100;
            }
        } else {
            if(a-b==0){
                result = 1000+a*100;
            } else if(b-c==0){
                result = 1000+b*100;
            } else if(a-c==0){
                result = 1000+a*100;
            }
        }

        sb.append(result);

        System.out.println(sb);

    }
}