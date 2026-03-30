import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_7576{

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int total=0;

        int[][] board = new int[n][m];
        int[][] visited = new int[n][m];

        Queue<int[]> Q = new ArrayDeque<>();

        // inital setting
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==1){
                    Q.offer(new int[]{i,j});
                    visited[i][j]=1;
                }
            }
        }
    


                while(!Q.isEmpty()){
                    int[] cur = Q.poll();
                    int curX = cur[0];
                    int curY = cur[1];

                    for(int dir=0; dir<4; dir++){
                        int nx = curX + dx[dir];
                        int ny = curY + dy[dir];

                        // 장외면 넘김
                        if(nx<0 || ny<0 || nx>=n || ny>=m){
                            continue;
                        }

                        // 
                        if((visited[nx][ny]>0 && visited[nx][ny] <= visited[curX][curY]+1) ||  board[nx][ny]==-1){
                            continue;
                        }

                        visited[nx][ny] = visited[curX][curY]+1;
                        Q.offer(new int[]{nx,ny});
                    }
                }


        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j]==0 && board[i][j]!=-1){
                    total=0;
                    sb.append(total-1);
                    System.out.println(sb);
                    return;
                } else if(visited[i][j] > total){
                    total = visited[i][j];
                }
            }
        }

        sb.append(total-1);
        System.out.println(sb);

    }
}