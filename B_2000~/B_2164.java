import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class B_2164{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> Queue = new ArrayDeque<>();

        for(int i=1; i<=N; i++){
            Queue.offerLast(i);
        }

        while(Queue.size()!=1){
            Queue.pollFirst();
            Queue.offerLast(Queue.pollFirst());
            // if (Queue.size()!=1){
            //     Queue.offerLast(Queue.pollFirst());
            // } else {
            //     break;
            // }
        }

        sb.append(Queue.pollFirst());
        System.out.println(sb);
    }
}