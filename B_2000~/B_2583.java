import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2583{

    static int[] dR = {1,0,-1,0};
    static int[] dC = {0,1,0,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] board = new int[M][N];
        int[][] visit = new int[M][N];

        ArrayList<Integer> move = new ArrayList<>();

        Queue<int[]> Q = new ArrayDeque<>();

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int[] startPoint = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            int[] endPoint = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            for(int m=startPoint[1]; m<endPoint[1]; m++){
                for(int n=startPoint[0]; n<endPoint[0]; n++){
                    board[m][n]=1;
                }
            }
        }

        int cnt = 0;
        for(int m=0; m<M; m++){
            for(int n=0; n<N; n++){
                // 벽이거나 방문한 적 있다면 continue
                if(board[m][n]==1 || visit[m][n]!=0){
                    continue;
                }

                cnt++;
                Q.offer(new int[]{m,n});
                visit[m][n]=cnt;
                int move_count=1;

                while(!Q.isEmpty()){
                    int[] cur = Q.poll();
                    int curR = cur[0];
                    int curC = cur[1];

                    for(int i=0; i<4; i++){
                        int nR = curR + dR[i];
                        int nC = curC + dC[i];

                        if(nR<0 || nC<0 || nR>=M || nC>=N){
                            continue;
                        }

                        // 이미 방문했거나 벽이라면 continue;
                        if(visit[nR][nC]!=0 || board[nR][nC]==1){
                            continue;
                        }

                        Q.offer(new int[]{nR, nC});
                        visit[nR][nC]=cnt;
                        move_count++;
                    }
                }
                move.add(move_count);
            }
        }
    
    Collections.sort(move);

    for(int i : move){
        sb.append(i).append(' ');
    }

    System.out.println(cnt);
    System.out.println(sb);
    }
}