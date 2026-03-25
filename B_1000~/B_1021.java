import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B_1021{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 0<=N<50
        int cnt = Integer.parseInt(st.nextToken()); // M<N
        int total = 0;

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[cnt];
        LinkedList<Integer> list = new LinkedList<>();


        for(int i=0; i<cnt; i++){
            arr[i]=Integer.parseInt(st.nextToken())-1;
        }

        for(int i=0; i<N; i++){ // deque 설정 1 2 3 4 5 6 7 8 9 10
            list.offerLast(i);
        }

        for(int value : arr){
            int idx;
            if(list.contains(value)){
                idx = list.indexOf(value);
                if(list.size()/2 >= idx){ // 앞으로
                    for(int j=0; j<idx; j++){
                        list.offerLast(list.pollFirst());
                    }
                    total+=idx;
                    list.pop();
                    continue;
                } else { // 뒤로
                    idx = list.size()-idx;
                    for(int j=0; j<idx; j++){
                        list.offerFirst(list.pollLast());
                    }
                    total+=idx;
                    list.pop();
                    continue;
                }
            }
        }

        sb.append(total);
        System.out.println(sb);
    }
}