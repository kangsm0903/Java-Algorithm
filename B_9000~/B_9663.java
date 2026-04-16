import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_9663{

    static boolean[][] board;
    static int N;
    
    static boolean[] isUsed0; // row
    static boolean[] isUsed1; // col
    static boolean[] isUsed2; // diagonal 좌하향
    static boolean[] isUsed3; // diagonal 우하향

    static int cnt;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        board = new boolean[N][N];

        isUsed0 = new boolean[N];
        isUsed1 = new boolean[N];
        isUsed2 = new boolean[2*N-1];
        isUsed3 = new boolean[2*N-1];

        func(N-1);

        sb.append(cnt);

        System.out.println(sb);
    }

    public static void func(int Queen){
        if(Queen==-1){ // 전부 착수했을 경우
            cnt++;
            return;
        }

        // Still going
        for(int i=0; i<N; i++){
            if(isUsed0[Queen]==false && isUsed1[i]==false && isUsed2[N+(Queen+i)-N]==false && isUsed3[N-(Queen-i)-1]==false){
                board[Queen][i]=true;
                isUsed0[Queen]=true;
                isUsed1[i]=true;
                isUsed2[N+(Queen+i)-N]=true; // 좌하향
                isUsed3[N-(Queen-i)-1]=true; // 우하향
    
                func(Queen-1);
    
                board[Queen][i]=false;
                isUsed0[Queen]=false;
                isUsed1[i]=false;
                isUsed2[N+(Queen+i)-N]=false;
                isUsed3[N-(Queen-i)-1]=false;
            }
        } // return 추가
        return;
    }
}