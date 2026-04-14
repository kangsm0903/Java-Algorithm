import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1992{
    
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];

        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<N; j++){
                board[i][j] = line.charAt(j)-'0';
            }
        }

        func1(board, 0, 0, N);

        System.out.println(sb);

        
    }

    public static void func1(int[][] arr, int row, int col, int size){
        int target = arr[row][col];

        for(int i=row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                if(target!=arr[i][j]){
                    // 4분할

                    int temp = size/2;

                    sb.append('(');

                    func1(arr, row, col, temp);
                    func1(arr, row, col + temp, temp);
                    func1(arr, row + temp, col, temp);
                    func1(arr, row + temp, col + temp, temp);

                    sb.append(')');
                    return;
                }
            }
        }

        if(target==0){
            sb.append(0);
            return;
        } else {
            sb.append(1);
            return;
        }
    }
}