import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine(), "");
            ArrayList<String> p = new ArrayList<>();

            StringBuilder sb1 = new StringBuilder();
            
            // while(st.hasMoreTokens()){
            //     p.add(st.nextToken());
            // }

            for(String k : st.nextToken().split("")){
                p.add(k);
            }
            
            Deque<Integer> x1 = new ArrayDeque<>();
            Deque<Integer> x2 = new ArrayDeque<>();
            int flag=1;

            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[],");

            for(int j=0; j<n; j++){
                x1.offerLast(Integer.parseInt(st.nextToken()));
            }

            sb1.append('[');

            for(String s : p){
                if(s.equals("D") && flag==1 && x1.isEmpty()){
                    sb1.delete(0, sb1.length());
                    sb1.append("error").append("\n");
                    flag=0;
                    break;
                } else if(s.equals("D") && flag==-1 && x2.isEmpty()){
                    sb1.delete(0, sb1.length());
                    sb1.append("error").append("\n");
                    flag=0;
                    break;
                }

                if(s.equals("R") && flag==1){
                    while(!x1.isEmpty()){
                        x2.offerFirst(x1.pollFirst());
                    }
                    flag*=-1;
                    continue;
                } else if(s.equals("R") && flag==-1){ 
                    while(!x2.isEmpty()){
                        x1.offerFirst(x2.pollFirst());
                    }
                    flag*=-1;
                    continue;
                } else if(s.equals("D") && flag==1){
                    x1.pollFirst();
                    continue;
                } else if (s.equals("D") && flag==-1){
                    x2.pollFirst();
                    continue;
                }
            }

            if(flag==1){
                for(int data : x1){
                    sb1.append(data).append(',');
                }
            } else if(flag==-1){
                for(int data : x2){
                    sb1.append(data).append(',');
                }
            }

            if(flag!=0){
                sb1.delete(sb1.length()-1, sb1.length());
                sb1.append(']').append('\n');
            }

            sb.append(sb1);
        }
        
        System.out.println(sb);
    }
}