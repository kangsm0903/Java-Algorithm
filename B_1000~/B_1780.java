import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1780{

    public static int[] result = {0,0,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        func(board, 0, 0, N);

        sb.append(result[2]).append('\n');
        sb.append(result[0]).append('\n');
        sb.append(result[1]);

        System.out.println(sb);
    }

    public static void func(int[][] arr, int row, int col, int size){
        int target = arr[row][col];

        for(int i=row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                if(arr[i][j]!=target){
                    //9개로 분할

                    func(arr, row, col,         size/3);
                    func(arr, row, col+(size/3)*1,  size/3);
                    func(arr, row, col+(size/3)*2,  size/3);

                    func(arr, row+(size/3)*1, col,         size/3);
                    func(arr, row+(size/3)*1, col+(size/3)*1,  size/3);
                    func(arr, row+(size/3)*1, col+(size/3)*2,  size/3);
                    
                    func(arr, row+(size/3)*2, col,         size/3);
                    func(arr, row+(size/3)*2, col+(size/3)*1,  size/3);
                    func(arr, row+(size/3)*2, col+(size/3)*2,  size/3);

                    return;
                }
            }
        }

        if(target==0){
            result[0]+=1;
            return;
        } else if(target==1){
            result[1]+=1;
            return;
        } else {
            result[2]+=1;
            return;
        }
    } 
}