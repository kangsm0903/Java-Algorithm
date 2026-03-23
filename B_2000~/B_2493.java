import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B_2493{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        Deque <int[]> stack = new ArrayDeque<>();
        int pos = 0;

        for(int i=0; i<N; i++){ // Stack 초기 셋팅 O(N)
            int num = Integer.parseInt(st.nextToken());
            pos++;

            while (!stack.isEmpty() && stack.peekFirst()[1] <= num){
                stack.pollFirst();
            }

            if(stack.isEmpty()){
                stack.offerFirst(new int[]{pos, num});
                sb.append(0).append(" ");
                
                continue;
            } else if (stack.peekFirst()[1] > num){
                sb.append(stack.peekFirst()[0]).append(" ");
                
                stack.offerFirst(new int[]{pos, num});
                continue;
            } 
            
        }

        System.out.println(sb);

    }
}