package Example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;

public class Pro_4 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        double array[] = new double[32]; // 0~31 32개

        for (int i=0; i<32; i++){
            array[i]= Math.pow(2, i);
        }

        for (int i=0; i<32; i++){
            if(N < array[i]){
                sb.append((int)array[i-1]);
                break;
            }
        }

        System.out.println(sb);
    }
}
