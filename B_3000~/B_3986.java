import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class B_3986{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int total=0;

        for(int i=0; i<N; i++){
            String[] arr = br.readLine().split("");

            Deque<String> stack = new ArrayDeque<>();

            for(String s : arr){
                if(stack.isEmpty() || !stack.peekFirst().equals(s)){ // 비어있거나 서로 다르면 그냥 넣음
                    stack.offerFirst(s);
                    continue;
                } else if(stack.peekFirst().equals(s)){ 
                    stack.pollFirst();
                }
            }

            if(stack.isEmpty()){
                total++;
            }
        }
        sb.append(total);
        System.out.println(sb);
    }
}