import java.io.*;
import java.util.*;

public class B_1000 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        int result = num1 + num2;
        sb.append(result).append("\n");

        System.out.print(sb.toString());

        br.close();
    }
}
