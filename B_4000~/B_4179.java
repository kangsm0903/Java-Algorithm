import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_4179{

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        int[][] visited = new int[n][m];
        int[][] fire = new int[n][m];

        Queue<int[]> Q_fire = new ArrayDeque<>();
        Queue<int[]> Q_human = new ArrayDeque<>();

        // initial Setting
        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<m; j++){
                char target = line.charAt(j);
                if (target=='#'){
                    board[i][j]=-1;
                    continue;
                } else if (target=='J'){
                    board[i][j]=1;
                    visited[i][j]=1;
                    Q_human.offer(new int[]{i,j});
                    continue;
                } else if (target=='F'){
                    board[i][j] = -10;
                    fire[i][j]=1;
                    Q_fire.offer(new int[]{i,j});
                    continue;
                }
            }
        }
    
        // Running BFS fire
        while(!Q_fire.isEmpty()){
            int[] cur = Q_fire.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int dir = 0; dir<4; dir++){
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];

                // 장외
                if(nx<0 || ny<0 || nx>=n || ny>=m){
                    continue;
                }

                // 방문했거나 벽이면 continue
                if(fire[nx][ny]!=0 || board[nx][ny]==-1){
                    continue;
                }

                fire[nx][ny] = fire[curX][curY] + 1;
                Q_fire.offer(new int[]{nx,ny});
            }
        }

                // Running BFS human
        while(!Q_human.isEmpty()){
            int[] cur = Q_human.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int dir = 0; dir<4; dir++){
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];

                // 장외
                if(nx<0 || ny<0 || nx>=n || ny>=m){
                    sb.append(visited[curX][curY]);
                    System.out.println(sb);
                    return;
                }

                // 방문했거나 벽이면 continue
                if(visited[nx][ny]!=0 || board[nx][ny]==-1 || (visited[curX][curY]+1 >= fire[nx][ny] && fire[nx][ny]!=0)){
                    continue;
                }

                visited[nx][ny] = visited[curX][curY] + 1;
                Q_human.offer(new int[]{nx,ny});
            }
        }
        
        sb.append("IMPOSSIBLE");
        System.out.println(sb);

    }
}