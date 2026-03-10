import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B_2576{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> array = new ArrayList<>();
        for(int i=0; i<7; i++){
            int num = Integer.parseInt(br.readLine());
            if(num%2==1){
                array.add(num);
            }
        }

        if(array.isEmpty()){
            sb.append(-1);
        } else {

            int sum=0;
            for(int i : array){
                sum+=i;
            }

            sb.append(sum).append('\n');
            sb.append(Collections.min(array)).append('\n');

        }

        System.out.println(sb);
    }
}