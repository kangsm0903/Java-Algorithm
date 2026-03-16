
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_3273{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int [1000001]; // 0 1 2 3 ~ 1,000,000

        for(int i=0; i<n; i++){
            int a = Integer.parseInt(st.nextToken());
            arr[a]++;
        }

        int x = Integer.parseInt(br.readLine());
        int cnt=0;

        for(int i=1; i<1000001; i++){
            if(x > i && x-i<=1000000 && arr[i]==1 && arr[x-i]==1){
                cnt++;
            }
        }

        sb.append(cnt/2);
        System.out.println(sb);
    }
}