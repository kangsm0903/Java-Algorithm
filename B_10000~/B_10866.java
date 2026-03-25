import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B_10866{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        String operand;
        int data;


        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            operand = st.nextToken();

            if(operand.equals("push_back")){
                data = Integer.parseInt(st.nextToken());
                deque.offerLast(data);
                continue;
            } else if (operand.equals("push_front")){
                data = Integer.parseInt(st.nextToken());
                deque.offerFirst(data);
                continue;
            } else if (operand.equals("pop_back")){
                if(deque.isEmpty()){
                    sb.append(-1).append("\n");
                } else{
                    data = deque.pollLast();
                    sb.append(data).append("\n");
                }
            } else if (operand.equals("pop_front")){
                if(deque.isEmpty()){
                    sb.append(-1).append("\n");
                } else{
                    data = deque.pollFirst();
                    sb.append(data).append("\n");
                }
            } else if (operand.equals("size")){
                data = deque.size();
                sb.append(data).append("\n");
            } else if (operand.equals("empty")){
                if(deque.isEmpty()){
                    sb.append(1).append("\n");
                } else{
                    sb.append(0).append("\n");
                }
            } else if (operand.equals("front")){
                if(deque.isEmpty()){
                    sb.append(-1).append("\n");
                } else{
                    data = deque.peekFirst();
                    sb.append(data).append("\n");
                }
            } else if (operand.equals("back")){
                if(deque.isEmpty()){
                    sb.append(-1).append("\n");
                } else{
                    data = deque.peekLast();
                    sb.append(data).append("\n");
                }
            }
        }
    
        System.out.println(sb);
    }
}