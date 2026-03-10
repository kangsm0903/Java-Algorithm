import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_1267{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> arr = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }

        int result1 = version1(arr);
        int result2 = version2(arr);

        if(result1 < result2){
            sb.append("Y").append(" ");
            sb.append(result1);
        } else if(result1 > result2){
            sb.append("M").append(" ");
            sb.append(result2);
        } else {
            sb.append("Y M").append(" ");
            sb.append(result2); 
        }

        System.out.println(sb);
    }

    public static int version1(ArrayList<Integer> arr){
        int cnt = 0;

        for(int i: arr){
            cnt+= i/30+1;
        }

        return cnt*10;
    }

    public static int version2(ArrayList<Integer> arr){
        int cnt = 0;

        for(int i: arr){
            cnt+= i/60+1;
        }

        return cnt*15;
    }
}