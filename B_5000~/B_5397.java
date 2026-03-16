import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class B_5397{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        int num = Integer.parseInt(br.readLine());

        for(int i=0; i<num; i++){
            for(char j : br.readLine().toCharArray()){
                if(j=='<'){
                    if(!left.isEmpty()){
                        right.push(left.pop());
                    }
                    continue;
                } else if(j=='>'){
                    if(!right.isEmpty()){
                        left.push(right.pop());
                    }
                    continue;
                } else if(j=='-'){
                    if(!left.isEmpty()){
                        left.pop();
                    }
                    continue;
                } else {
                    left.push(j);
                }
            }
            
            while(!left.isEmpty()){
                sb.append(left.pollLast());
            }

            // if(!right.isEmpty()){sb.append(" ");}

            while(!right.isEmpty()){
                sb.append(right.pop());
            }

            sb.append('\n');
        }
        System.out.println(sb);
    }
}