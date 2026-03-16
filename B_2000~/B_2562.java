import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B_2562{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<9; i++){
            arr.add(Integer.parseInt(br.readLine()));
        }

        int max = Collections.max(arr);
        int index = arr.indexOf(max)+1;

        sb.append(max).append('\n');
        sb.append(index);

        System.out.println(sb);
    }
}

