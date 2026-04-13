import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public static int[] result = {0,0};

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

        func1(board, 0, 0, N);

        for(int i:result){
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }


    public static void func1(int[][] arr, int row, int col, int size){
        int target = arr[row][col];

        for(int i=row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                if(target!=arr[i][j]){
                    // 4개로 분할
                    int temp = size/2;

                    func1(arr, row,         col,        temp);
                    func1(arr, row,         col+temp,   temp);
                    func1(arr, row+temp,    col,        temp);
                    func1(arr, row+temp,    col+temp,   temp);

                    return;
                }
            }
        }

        if(target==1){
            result[1]++;
            return;
        } else {
            result[0]++;
            return;
        }
    }
}