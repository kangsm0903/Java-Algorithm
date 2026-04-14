import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_2448{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        char[][] board = new char[N][2*N-1];

        for(int i=0; i<N; i++){
            Arrays.fill(board[i], ' ');
        }

        func(board, 0, 0, N);

        for(char[] i : board){
            for(char j : i){
                sb.append(j);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }


    public static void func(char[][] arr, int row, int col, int size){
        if(size==3){
            for(int i=row; i<row+size; i++){
                for(int j=col; j<col+(2*size-1); j++){
                    if(i==row && j==col+size-1){
                        arr[i][j]='*';
                    } else if(i==row+1 && (j==col+size-2 || j==col+size)){
                        arr[i][j]='*';
                    } else if(i==row+2){
                        arr[i][j]='*';
                    } else {
                        
                    }
                }
            }
            return;
        }

        int temp = size/2;

        func(arr, row,          col+temp,   temp);
        func(arr, row+temp,     col,        temp);
        func(arr, row+temp,     col+temp*2, temp);
        return;
    }
}