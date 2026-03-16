import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1475{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int array [] = new int [10];

        String num = br.readLine();
        int cnt = 0;

        for(char i: num.toCharArray()){
            if((i=='6' || i=='9') && cnt>0){
                cnt--;
            } else if((i=='6' || i=='9') && cnt==0){
                cnt++;
                // array[i-'0']++;
                array[6]++;
            } else{
                array[i-'0']++;
            }
        }

        int imax=-1;

        for(int i: array){
            if(i>imax){
                imax=i;
            }
        }
        sb.append(imax);
        System.out.println(sb);
    }
}