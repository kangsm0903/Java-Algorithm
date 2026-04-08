import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class B_2667{

    static int[] dR = {1,0,-1,0};
    static int[] dC = {0,1,0,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];
        int[][] visit = new int[N][N];
        ArrayList<Integer> home = new ArrayList<>();

        Queue<int[]> Q = new ArrayDeque<>();

        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<N; j++){
                int target = line.charAt(j)-'0';
                board[i][j]=target;
            }
        }

        int cnt_hometown = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){

                // 이미 방문했거나 벽이라면 continue;
                if(visit[i][j]!=0 || board[i][j]==0){
                    continue;
                }

                Q.offer(new int[]{i,j});
                cnt_hometown++;
                int cnt_home=1;
                visit[i][j]=cnt_hometown;

                while(!Q.isEmpty()){
                    int[] cur = Q.poll();
                    int curR = cur[0];
                    int curC = cur[1];

                    for(int k=0; k<4; k++){
                        int nR = curR + dR[k];
                        int nC = curC + dC[k];

                        if(nR<0 || nC<0 || nR>=N || nC>=N){
                            continue;
                        }

                        if(visit[nR][nC]!=0 || board[nR][nC]==0){
                            continue;
                        }

                        Q.offer(new int[]{nR,nC});
                        visit[nR][nC]=cnt_hometown;
                        cnt_home++;
                    }
                }
                home.add(cnt_home);
            }
        }
        Collections.sort(home);

        for(int i : home){
            sb.append(i).append('\n');
        }

        System.out.println(cnt_hometown);
        System.out.println(sb);

    }
}