import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_15650{

    static int N;
    static int M;

    static int[] arr;
    static boolean[] isUsed;

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

    public static void func(int pos){
        if(pos==M){
            for(int i=0; i<M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<N+1; i++){
            if(!isUsed[i]){
                if(pos==0){
                    arr[pos]=i;
                    isUsed[i]=true;

                    func(pos+1);

                    isUsed[i]=false;
                } else if(arr[pos-1] < i){
                    arr[pos]=i;
                    isUsed[i]=true;

                    func(pos+1);

                    isUsed[i]=false;
                }
            }
        }


    }
}