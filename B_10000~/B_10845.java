import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B_10845{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Deque<Integer> queue = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());


        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String operator = st.nextToken();
            
            if(operator.equals("push")){
                int data = Integer.parseInt(st.nextToken());
                push(data, queue);
                continue;
            } else if (operator.equals("pop")){
                sb.append(pop(queue)).append("\n");
                continue;
            } else if (operator.equals("size")){
                sb.append(size(queue)).append("\n");
                continue;
            } else if (operator.equals("empty")){
                sb.append(empty(queue)).append("\n");
                continue;
            } else if (operator.equals("front")){
                sb.append(front(queue)).append("\n");
                continue;
            } else if (operator.equals("back")){
                sb.append(back(queue)).append("\n");
                continue;
            }
        }

        System.out.println(sb);
    }

    public static void push(int data, Deque<Integer> queue){
        queue.offerLast(data);
    }

    public static int pop(Deque<Integer> queue){
        if(queue.isEmpty()){
            return -1;
        } else {
            return queue.pollFirst();
        }
    }

    public static int size(Deque<Integer> queue){
        return queue.size();
    }

    public static int empty(Deque<Integer> queue){
        if(queue.isEmpty()){
            return 1;
        } else {
            return 0;
        }
    }

    public static int front(Deque<Integer> queue){
        if(queue.isEmpty()){
            return -1;
        } else {
            return queue.peekFirst();
        }
    }

    public static int back(Deque<Integer> queue){
        if(queue.isEmpty()){
            return -1;
        } else {
            return queue.peekLast();
        }
    }
}