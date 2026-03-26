import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class B_4949{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String[] arr = br.readLine().split("");

            if(arr.length==1 && arr[0].equals(".")){
                break;
            }
    
            Deque<String> stack = new ArrayDeque<>();
    
            int isValid = 1;

            for(String s : arr){
                if(s.equals("[") || s.equals("(")){
                    stack.offerFirst(s);
                    continue;
                } else if(s.equals("]")){
                    if( stack.isEmpty() || stack.peekFirst().equals("(")){
                        isValid *= -1;
                        break;
                    }
                    stack.pollFirst();
                } else if(s.equals(")")){
                    if(stack.isEmpty() || stack.peekFirst().equals("[")){
                        isValid *= -1;
                        break;
                    }
                    stack.pollFirst();
                }
            }
    
            if(isValid==1 && stack.isEmpty()){
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }

        }

        System.out.println(sb);

    }
}