import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_5427{

    static int[] dR = {1,0,-1,0};
    static int[] dC = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            char[][] board = new char[h][w];
            int[][] visitF = new int[h][w];
            int[][] visitH = new int[h][w];

            Queue<int[]> Qf = new ArrayDeque<>(); // fire
            Queue<int[]> Qh = new ArrayDeque<>(); // human

            boolean flag = false;

            for(int j=0; j<h; j++){
                String line = br.readLine();
                for(int k=0; k<w; k++){
                    char target = line.charAt(k);
                    if(target=='*'){
                        Qf.offer(new int[]{j,k});
                        visitF[j][k]=1;
                    } else if(target=='@'){
                        Qh.offer(new int[]{j,k});
                        visitH[j][k]=1;
                    }

                    board[j][k]=target;
                }
            }
        
            
            while(!Qf.isEmpty()){
                int[] cur = Qf.poll();
                int curR = cur[0];
                int curC = cur[1];

                for(int l=0; l<4; l++){
                    int nR = curR + dR[l];
                    int nC = curC + dC[l];

                    if(nR<0 || nC<0 || nR>=h || nC>=w){
                        continue;
                    }

                    // 이미 방문을 했거나, 이미 벽이면
                    if(visitF[nR][nC]!=0 || board[nR][nC]=='#'){
                        continue;
                    }

                    Qf.offer(new int[]{nR,nC});
                    visitF[nR][nC] = visitF[curR][curC]+1;
                }
            }

            while(!Qh.isEmpty()){
                int[] cur = Qh.poll();
                int curR = cur[0];
                int curC = cur[1];

                for(int l=0; l<4; l++){
                    int nR = curR + dR[l];
                    int nC = curC + dC[l];

                    // 장외이면 다음
                    if(nR<0 || nC<0 || nR>=h || nC>=w){
                        sb.append(visitH[curR][curC]).append('\n');
                        flag = true;
                        break;
                    }

                    // 이미 방문을 했거나, 이미 벽이면
                    if(visitH[nR][nC]!=0 || board[nR][nC]=='#' || 
                    (visitF[nR][nC]!=0 && visitF[nR][nC] <= visitH[curR][curC]+1)){
                        continue;
                    }

                    Qh.offer(new int[]{nR,nC});
                    visitH[nR][nC] = visitH[curR][curC]+1;
                }

                if(flag){ // 탈출했다면
                    break;
                }
            }

            if(!flag){
                sb.append("IMPOSSIBLE").append('\n');
            }
            
        }

        System.out.println(sb);
    }
}