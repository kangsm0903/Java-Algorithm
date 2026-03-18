import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B_10828{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Deque<Integer> stack = new ArrayDeque<>();

        int num = Integer.parseInt(br.readLine());

        for(int i=0; i<num; i++){
            st = new StringTokenizer(br.readLine());
            String instruction = st.nextToken();

            if(instruction.equals("push")){
                int data = Integer.parseInt(st.nextToken());
                push(data, stack);
            } else if (instruction.equals("top")) {
                sb.append(top(stack)).append("\n");
            } else if (instruction.equals("pop")) {
                sb.append(pop(stack)).append("\n");
            } else if (instruction.equals("empty")) {
                sb.append(empty(stack)).append("\n");
            } else if (instruction.equals("size")) {
                sb.append(size(stack)).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void push(int data, Deque<Integer> stack){
        stack.offerFirst(data);
    }

    public static int pop(Deque<Integer> stack){
        if(empty(stack)==1){
            return -1;
        } else {
            return stack.pollFirst();
        }
    }

    public static int size(Deque<Integer> stack){
        return stack.size();
    }

    public static int empty(Deque<Integer> stack){
        if (stack.isEmpty()){
            return 1;
        } else {
            return 0;
        }
    }

    public static int top(Deque<Integer> stack){
        if (empty(stack)==1){
            return -1;
        } else {
            return stack.getFirst();
        }
    }
}