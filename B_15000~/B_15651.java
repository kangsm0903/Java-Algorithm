import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_15651{

    static int N;
    static int M;
    
    static boolean[] isUsed;
    static int[] arr;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        isUsed = new boolean[N+1];

        func(0);

        System.out.println(sb);
    }


    public static void func(int k){
        if(k==M){
            for(int i : arr){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            // if(isUsed[i]==false){
                arr[k]=i;
                isUsed[i]=true;

                func(k+1);

                isUsed[i]=false;
            // }
        }
        return;
    }
}