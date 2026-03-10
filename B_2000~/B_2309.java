import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B_2309{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> arr = new ArrayList<>();

        int sum=0;
        for(int i=0; i<9; i++){
            int num = Integer.parseInt(br.readLine());
            arr.add(num);
            sum+=num;
        }

        int target = sum-100;

        int temp1 = 0;
        int temp2 = 0;

        for(int i : arr){
            if(arr.contains(target-i) && i!=(target-i)){
                temp1=i;
                temp2=target-i;
                break;
            }
        }
        
        arr.remove(Integer.valueOf(temp1));
        arr.remove(Integer.valueOf(temp2));
        Collections.sort(arr);

        for(int i: arr){
            sb.append(i).append('\n');
        }

        System.out.println(sb);

        
    }
}