package Example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pro_3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int result = func4(N);

        sb.append(result);
        System.out.println(sb);
    }

    public static int func3(int n){
        for(double i=1; i<n; i++){
            if((double)(n/i)==i){
                return 1;
            }
        }
        return 0;
    }

    public static int func4(int n){
        for(int i=1; i*i<=n; i++){
            if(i*i==n){
                return 1;
            }
        }
        return 0;
    }
}
