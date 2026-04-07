import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_7562{
    
    static int[] dR = {2,1,-1,-2,-2,-1,1,2};
    static int[] dC = {1,2,2,1,-1,-2,-2,-1};   
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            int I = Integer.parseInt(br.readLine());
            
            int[][] visit = new int[I][I];
            Queue<int[]> Q = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());
            int curR = Integer.parseInt(st.nextToken());
            int curC = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int goalR = Integer.parseInt(st.nextToken());
            int goalC = Integer.parseInt(st.nextToken());

            Q.offer(new int[]{curR, curC});
            visit[curR][curC] = 1;
            
            while(!Q.isEmpty()){
                int[] now = Q.poll();
                int nowR = now[0];
                int nowC = now[1];

                if(nowR==goalR && nowC==goalC){
                    break;
                }

                for(int j=0; j<8; j++){
                    int nR = nowR + dR[j];
                    int nC = nowC + dC[j];

                    // 장외
                    if(nR<0 || nC<0 || nR>=I || nC>=I){
                        continue;
                    }

                    // 이미 방문했는데, counting이 나보다 낮으면 그냥 넘김
                    // if(visit[nR][nC]!=0 && visit[nowR][nowC]+1 >= visit[nR][nC] ){
                    //     continue;
                    // }

                    if(visit[nR][nC]!=0){
                        continue;
                    }

                    Q.offer(new int[]{nR,nC});
                    visit[nR][nC]=visit[nowR][nowC]+1;
                }
            }
            sb.append(visit[goalR][goalC]-1).append('\n');
        }

        System.out.println(sb);
    }
}