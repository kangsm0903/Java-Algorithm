import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class B_9012{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String[] arr = br.readLine().split("");
            Deque<String> stack = new ArrayDeque<>();

            int flag = 1;

            for(String s : arr){
                if(s.equals("(") || s.equals("[")){
                    stack.offerFirst(s);
                    continue;
                } else if(s.equals(")")){
                    if(stack.isEmpty() || !stack.peekFirst().equals("(")){
                        flag*=-1;
                        break;
                    } else {
                        stack.pollFirst();
                        continue;
                    }
                } else if(s.equals("]")){
                    if(stack.isEmpty() || !stack.peekFirst().equals("[")){
                        flag*=-1;
                        break;
                    } else {
                        stack.pollFirst();
                        continue;
                    }
                }
            }
        
            if(flag==1 && stack.isEmpty()){
                sb.append("YES").append('\n');
            } else {
                sb.append("NO").append('\n');
            }
        }

        System.out.println(sb);
    }
}