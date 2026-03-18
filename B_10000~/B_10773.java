import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class B_10773{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i<num; i++){
            int data = Integer.parseInt(br.readLine());

            if(data==0){
                stack.pollFirst();
            } else {
                stack.offerFirst(data);
            }
        }

        int sum=0;
        for(int i : stack){
            sum=sum+i;
        }
        sb.append(sum);
        System.out.println(sb);
    }
}