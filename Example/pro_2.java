package Example;
import java.io.IOException;

public class pro_2 {
    public static void main(String[] args) throws IOException{
        int array_size = 2;
        int[] array = {1,52,48};

        System.out.println(func2(array, array_size));
        System.out.println(func3(array, array_size));
    }

    public static int func2(int[] array, int N){
        
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                if(array[i]+array[j]==100){
                    return 1;
                }
            }
        }
        
        return 0;
    }

    public static int func3(int[] array, int N){
        int freq[] = new int[101];

        for(int i: array){
            freq[i]++;
        }

        for(int i=0; i<101; i++){
            if(freq[i]>0 && freq[100-i]>0){
                return 1;
            }
        }
        return 0;
    }
}
