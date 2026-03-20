import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class B_1874{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int currentPosition = 1;

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i<N; i++){
            int data = Integer.parseInt(br.readLine());

            if(data >= currentPosition){
                for(int j=currentPosition; j<data+1; j++){ // currentPosition ~ 들어온 data까지 넣어줌
                    stack.offerFirst(j);
                    sb.append("+").append("\n");
                }
                currentPosition=data+1; //Update currentPosition
            }

            if(stack.isEmpty() || stack.peekFirst()!=data){
                sb.delete(0, sb.length());
                sb.append("NO").append("\n");
                break;
            } else if (stack.peekFirst()==data){
                stack.pollFirst();
                sb.append("-").append("\n");
            }   
        }
        System.out.println(sb);
    }
}