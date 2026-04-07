import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1697{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Integer> Q = new ArrayDeque<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] dist = new int[100001];
        Arrays.fill(dist, -1);

        Q.offer(N);
        dist[N]=0;

        while(!Q.isEmpty()){
            int index = Q.poll();
            if(index==K){ // 발견하면 끝냄
                sb.append(dist[index]);
                System.out.println(sb);
                break;
            }


            for(int i=0; i<3; i++){
                int pos=index;
                if (i==0){
                    pos -= 1;
                } else if (i==1){
                    pos += 1;
                } else if (i==2){
                    pos *= 2;
                }

                if(pos<0 || pos>100000){
                    continue;
                }

                if(dist[pos]!=-1){
                    continue;
                }

                Q.offer(pos);
                dist[pos] = dist[index]+1;

            }
        }
    }
}