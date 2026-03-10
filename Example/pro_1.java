// package Example;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.StringTokenizer;
// import java.util.ArrayList;


// public class pro_1 {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringBuilder sb = new StringBuilder();

//         // StringTokenizer st = new StringTokenizer(br.readLine());

//         ArrayList<Integer> array = new ArrayList<>();

//         int num = Integer.parseInt(br.readLine());
//         func3(num, array);
//         func5(num, array);
//         func15(num, array);

//         int sum = 0;
//         for (int result : array){
//             sum += result;
//         }

//         sb.append(sum).append('\n');
//         System.out.print(sb);
//     }

//     public static void func3 (int number, ArrayList<Integer> array){

//         for (int i=0; i<number; i++){
//             if (number < i*3){
//                 break;
//             } else {
//                 array.add(i*3);
//             }
//         }
//     }

//     public static void func5 (int number, ArrayList<Integer> array){
//         for (int i=0; i<number; i++){
//             if (number < i*5){
//                 break;
//             } else {
//                 array.add(i*5);
//             }
//         }
//     }

//     public static void func15 (int number, ArrayList<Integer> array){
//         for (int i=0; i<number; i++){
//             if (number < i*15){
//                 break;
//             } else {
//                 array.remove(Integer.valueOf(i*15));
//             }
//         }
//     }
// }


// ------------------------------------------------------------------------------------------------------------------------
package Example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class pro_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        System.out.println(func1(num));
    }

    public static long func1(int num){
        long sum = 0;

        for(int i=1; i <= num; i++){
            if(i%3==0 || i%5==0){
                sum+=i;
            }
        }

        return sum;
    }
}