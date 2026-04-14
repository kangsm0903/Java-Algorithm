import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2447{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        char[][] board = new char[N][N];

        func(board, N, 0, 0, 0);

        for(char[] i : board){
            for(char j : i){
                sb.append(j);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void func(char[][] arr, int size, int row, int col, int flag){

        if(flag == 1){
            for(int i=row; i<row+size; i++){
                for(int j=col; j<col+size; j++){
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if(size==3){
            int cnt = 0;
            for(int i=row; i<row+size; i++){
                for(int j=col; j<col+size; j++){
                    if(cnt==4){
                        cnt++;
                        arr[i][j]=' ';
                        continue;
                    }
                    cnt++;
                    arr[i][j] = '*';
                }
            }
            return;
        } else {
            int temp = size/3;

            func(arr, temp, row, col, 0);
            func(arr, temp, row, col+temp*1, 0);
            func(arr, temp, row, col+temp*2, 0);

            func(arr, temp, row+temp*1, col, 0);
            func(arr, temp, row+temp*1, col+temp*1, 1);
            func(arr, temp, row+temp*1, col+temp*2, 0);

            func(arr, temp, row+temp*2, col, 0);
            func(arr, temp, row+temp*2, col+temp*1, 0);
            func(arr, temp, row+temp*2, col+temp*2, 0);

            return;
        }


    }
}



// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.Arrays;

// public class Main{
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringBuilder sb = new StringBuilder();

//         int N = Integer.parseInt(br.readLine());

//         char[][] board = new char[N][N];

//         for(int i=0; i<N; i++){
//             Arrays.fill(board[i], ' ');
//         }

//         func(board, N, 0, 0);

//         for(char[] i : board){
//             for(char j : i){
//                 sb.append(j);
//             }
//             sb.append('\n');
//         }

//         System.out.println(sb);
//     }

//     public static void func(char[][] arr, int size, int row, int col){

//         if(size==1){
//             arr[row][col]='*';
//             return;
//         }

//         int temp = size/3;

//         for(int i=0; i<3; i++){
//             for(int j=0; j<3; j++){
//                 if(i==1 && j==1){
//                     continue;
//                 }
//                 func(arr, temp, row+temp*i, col+temp*j);
//             }
//         }
//         return;
//     }
// }