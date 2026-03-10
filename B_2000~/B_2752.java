import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.*;

public class B_2752{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> array = new ArrayList<>();

        for (int i=0; i<3; i++){
            array.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(array);

        for (int i=0; i<3; i++){
            sb.append(array.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}