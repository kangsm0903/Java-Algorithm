import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2577{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int temp = 1;

        for(int i=0; i<3; i++){
            int num = Integer.parseInt(br.readLine());
            temp *= num;
        }
        
        String target = Integer.toString(temp);

        int arr [] = new int[10];

        for(char i : target.toCharArray()){
            arr[i-'0']++;
        }

        for(int i : arr){
            sb.append(i).append('\n');
        }


        System.out.print(sb);
    }
}