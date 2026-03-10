import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B_2587{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> array = new ArrayList<>();

        int sum=0;
        for(int i=0; i<5; i++){
            int num = Integer.parseInt(br.readLine());
            sum+=num;
            array.add(num);
        }

        Collections.sort(array);
        sb.append(sum/5).append('\n');
        sb.append(array.get(2)).append('\n');

        System.out.println(sb);



    }
}