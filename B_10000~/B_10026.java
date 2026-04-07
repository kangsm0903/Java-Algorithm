import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B_10026{

    static int[] dRow = {1,0,-1,0};
    static int[] dCol = {0,1,0,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        char[][] board = new char[N][N];
        int[][] visit = new int[N][N];
        int cnt = 0;

        Queue<int[]> Q = new ArrayDeque<>();
        
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<N; j++){
                board[i][j] = line.charAt(j);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visit[i][j]==0){
                    cnt++;

                    Q.offer(new int[]{i,j});
                    visit[i][j]=1;
    
                    while(!Q.isEmpty()){
                        int[] cur = Q.poll();
                        int curR = cur[0];
                        int curC = cur[1];
    
                        for(int k = 0; k<4; k++){
                            int row = curR + dRow[k];
                            int col = curC + dCol[k];
    
                            // 장외
                            if(row < 0 || col < 0 || row >= N || col >= N){
                                continue;
                            }
    
                            // 이미 방문했거나 
                            if(visit[row][col]!=0 || board[row][col]!=board[i][j]){
                                continue;
                            }
    
                            Q.offer(new int[]{row, col});
                            visit[row][col]=1;
                        }
                    }
                }
            }
        }

        sb.append(cnt).append(' ');
        
        
        cnt=0;
        Queue<int[]> Q2 = new ArrayDeque<>();
        int[][] visit2 = new int[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(board[i][j]=='G'){
                    board[i][j]='R';
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visit2[i][j]==0){
                    cnt++;

                    Q2.offer(new int[]{i,j});
                    visit2[i][j]=1;
    
                    while(!Q2.isEmpty()){
                        int[] cur = Q2.poll();
                        int curR = cur[0];
                        int curC = cur[1];
    
                        for(int k = 0; k<4; k++){
                            int row = curR + dRow[k];
                            int col = curC + dCol[k];
    
                            if(row < 0 || col < 0 || row >= N || col >= N){
                                continue;
                            }
    
                            if(visit2[row][col]!=0 || board[row][col]!=board[i][j]){
                                continue;
                            }
    
                            Q2.offer(new int[]{row, col});
                            visit2[row][col]=1;
                        }
                    }
                }
            }
        }

        sb.append(cnt);

        System.out.println(sb);
    }
}