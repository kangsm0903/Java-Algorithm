import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2178{

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

        Queue<int[]> Q = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<m; j++){
                board[i][j] = line.charAt(j)-'0';
            }
        }


                visited[0][0]=1;
                Q.offer(new int[]{0,0});

                while(!Q.isEmpty()){
                    int[] cur =  Q.poll();
                    int curX = cur[0];
                    int curY = cur[1];

                    for(int dir=0; dir<4; dir++){
                        int nx = curX + dx[dir];
                        int ny = curY + dy[dir];

                        if (nx<0 || ny<0 || nx>=n || ny>=m){
                            continue;
                        }

                        // 이미 방문했음 == 0보다 큼 || board==0 벽이면 넘김
                        if (visited[nx][ny]>0 || board[nx][ny]!=1){
                            continue;
                        }

                        visited[nx][ny] = visited[curX][curY]+1;
                        Q.offer(new int[]{nx,ny});
                    }
                }


        sb.append(visited[n-1][m-1]);
        System.out.println(sb);
    }
}