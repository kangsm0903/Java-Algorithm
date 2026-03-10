package Example;
import java.io.IOException;

public class pro_2 {
    public static void main(String[] args) throws IOException{
        int array_size = 2;
        int[] array = {50, 42};

        System.out.println(func2(array, array_size));
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
}
