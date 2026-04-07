import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1012{

    static int[] dRow = {1,0,-1,0};
    static int[] dCol = {0,1,0,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken()); // Verical
            int N = Integer.parseInt(st.nextToken()); // horizon
            int K = Integer.parseInt(st.nextToken()); // the number of position

            int[][] board = new int[N][M];
            int[][] visit = new int[N][M];
            int cnt = 0;

            Queue<int[]> Q = new ArrayDeque<>();

            // initalize board setting
            for(int j=0; j<K; j++){
                st = new StringTokenizer(br.readLine());
                int pos1 = Integer.parseInt(st.nextToken());
                int pos2 = Integer.parseInt(st.nextToken());

                board[pos2][pos1] = 1;
            }

            for(int j=0; j<N; j++){
                for(int q=0; q<M; q++){

                    // 배추인데 아직 방문 안했다면 BFS
                    if(board[j][q]==1 && visit[j][q]==0){
                        Q.offer(new int[]{j,q});
                        cnt++;
                        visit[j][q]=cnt;
                    }

                    while(!Q.isEmpty()){
                        int[] cur = Q.poll();
                        int curX = cur[0];
                        int curY = cur[1];
        
                        for(int l=0; l<4; l++){
                            int nx = curX + dRow[l];
                            int ny = curY + dCol[l];
    
                            if(nx<0 || ny<0 || nx>=N || ny>=M){
                                continue;
                            }
        
                            if(visit[nx][ny]!=0 || board[nx][ny]==0){
                                continue;
                            }
        
                            Q.offer(new int[]{nx,ny});
                            visit[nx][ny]=cnt;
                        }
                    }
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}