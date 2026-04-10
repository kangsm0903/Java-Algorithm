import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1074{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());


        int result = func1(r, c, N);
        System.out.println(result);
    }

    public static int func1(int row, int col, int N){
        if(N==1){ // 00=0, 01=1, 10=2, 11=3
            if(row==0 & col==0){
                return 0;
            } else if(row==0 && col==1){
                return 1;
            } else if (row==1 && col==0){
                return 2;
            } else if (row==1 && col==1){
                return 3;
            }
        }

        int base = (int)Math.pow(2, N)/2;
        if(row < base && col < base){ // 1
            return func1(row, col, N-1);
        } else if(row < base && col >= base){ // 2
            return func1(row, col - base, N-1) + (base*base);
        } else if(row >= base && col < base){ // 3
            return func1(row - base, col, N-1) + 2*(base*base);
        } else if(row >= base && col >= base){ // 4
            return func1(row - base, col - base, N-1) + 3*(base*base);
        } else {
            return -1;
        }
    }
}