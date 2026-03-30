import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1926{

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
    
        int cnt=0;
        int size=0;
        int[][] board = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> Q = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            for (int j=0; j<m; j++){

                // 이미 방문을 했거나, 벽이라면 넘김
                if(visited[i][j]==true || board[i][j]==0){
                    continue;
                }

                int temp=0;
                cnt++;

                visited[i][j] = true;
                Q.offer(new int[]{i,j});

                while(!Q.isEmpty()){
                    int[] cur = Q.poll();
                    temp++;
                    
                    int curX = cur[0];
                    int curY = cur[1];

                    for(int dir=0; dir<4; dir++){
                        int nx = curX + dx[dir];
                        int ny = curY + dy[dir];

                        if(nx<0 || ny<0 || nx>=n || ny>=m){
                            continue;
                        }

                        if(visited[nx][ny]==true || board[nx][ny]==0){
                            continue;
                        }

                        visited[nx][ny]=true;
                        Q.offer(new int[]{nx, ny});
                    }
                }
            
                if(size<temp){
                    size=temp;
                }
            }
        }
        sb.append(cnt).append('\n');
        sb.append(size);

        System.out.println(sb);
    }
}