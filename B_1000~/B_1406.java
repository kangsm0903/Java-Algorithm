import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class B_1406{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        for (char i : br.readLine().toCharArray()){ // abcd
            left.push(i);
        }

        int num = Integer.parseInt(br.readLine()); // num



        for(int i=0; i<num; i++){
            String line = br.readLine();
            char command = line.charAt(0);

            if(!left.isEmpty() && command=='L'){
                right.push(left.pop());
            } else if(!right.isEmpty() && command=='D'){
                left.push(right.pop());
            } else if(!left.isEmpty() && command=='B'){
                left.pop();
            } else if(command=='P'){
                char text = line.charAt(2);
                left.push(text);
            }
        }

        while(!left.isEmpty()){
            sb.append(left.pollLast());
        }

        while(!right.isEmpty()){
            sb.append(right.poll());
        }
        
        System.out.println(sb);




    }
}