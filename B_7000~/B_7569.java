import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_7569{

    static int[] dH = {0,0,0,0,1,-1};
    static int[] dR = {1,0,-1,0,0,0};
    static int[] dC = {0,1,0,-1,0,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(st.nextToken()); // vertical
        int N = Integer.parseInt(st.nextToken()); // horizon
        int H = Integer.parseInt(st.nextToken()); // height

        Queue<int[]> Q = new ArrayDeque<>();

        int[][][] board = new int[H][N][M];
        int[][][] visit = new int[H][N][M];

        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine()); 
                for(int k=0; k<M; k++){
                    int target=Integer.parseInt(st.nextToken());
                    if(target==1){
                        Q.offer(new int[]{i,j,k});
                        visit[i][j][k]=1;
                    }
                    board[i][j][k] = target;
                }
            }
        }

        while(!Q.isEmpty()){
            int[] cur = Q.poll();
            int curH = cur[0];
            int curR = cur[1];
            int curC = cur[2];

            for(int i=0; i<6; i++){
                int nH = curH + dH[i];
                int nR = curR + dR[i];
                int nC = curC + dC[i];

                if(nH < 0 || nR < 0 || nC < 0 || nH >= H || nR >= N || nC >= M){
                    continue;
                }

                if(visit[nH][nR][nC]!=0 || board[nH][nR][nC]==-1){
                    continue;
                }

                Q.offer(new int[]{nH,nR,nC});
                visit[nH][nR][nC] = visit[curH][curR][curC]+1;
            }
        }

        int imax = 0;

        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    // 안익었는데 방문 안했으면 -1
                    if(visit[i][j][k]==0 && board[i][j][k]==0){
                        sb.append("-1");
                        System.out.println(sb);
                        return;
                    // 그 외라면 계산
                    } else if(visit[i][j][k] > imax){
                        imax = visit[i][j][k];
                    }
                }
            }
        }

        sb.append(imax-1);
        System.out.println(sb);
    }
}