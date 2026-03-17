import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1158{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Integer> queue = new ArrayDeque<>();

        int num = Integer.parseInt(st.nextToken());
        int jump = Integer.parseInt(st.nextToken());

        for(int i=1; i<num+1; i++){
            queue.offer(i);
        }

        sb.append("<");

        while(!queue.isEmpty()){
            for(int i=1; i<jump+1; i++){
                if(i==jump){
                    sb.append(queue.poll()).append(", ");
                } else { 
                    queue.offer(queue.poll());
                }
            }
        }
        sb.delete(sb.length()-2,sb.length());
        sb.append(">");

        System.out.println(sb);
    }
}