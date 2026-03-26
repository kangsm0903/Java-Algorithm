import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class B_5430{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine(), "");
            ArrayList<String> p = new ArrayList<>();

            StringBuilder sb1 = new StringBuilder();

            for(String k : st.nextToken().split("")){
                p.add(k);                                           // R D D
            }
            
            Deque<Integer> x1 = new ArrayDeque<>();
            int flag=1;

            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[],");

            for(int j=0; j<n; j++){
                x1.offerLast(Integer.parseInt(st.nextToken()));     // R D D
            }

            sb1.append('[');

            for(String s : p){
                if(s.equals("D") && x1.isEmpty()){
                    sb1.delete(0, sb1.length());
                    sb1.append("error").append("\n");
                    flag=0;
                    break;
                }

                if(s.equals("R")){
                    flag*=-1;
                    continue;
                } else if(s.equals("D") && flag==1){
                    x1.pollFirst();
                    continue;
                } else if (s.equals("D") && flag==-1){
                    x1.pollLast();
                    continue;
                }
            }

            int x1_size = x1.size();

            if(flag==1){
                for(int j=0; j<x1_size; j++){
                    sb1.append(x1.pollFirst()).append(',');
                }
            } else if(flag==-1){
                for(int j=0; j<x1_size; j++){
                    sb1.append(x1.pollLast()).append(',');
                }
            }

            if(flag!=0 && x1_size!=0){ // error가 아니면
                sb1.delete(sb1.length()-1, sb1.length());
                sb1.append(']').append('\n');
            } else if(flag!=0 && x1_size==0){
                sb1.append(']').append('\n');
            }
            sb.append(sb1);
        }
        
        System.out.println(sb);
    }
}