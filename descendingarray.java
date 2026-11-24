import java.util.*; 
public class descendingarray {

        public static void main(String[] args) {
                int[] arr = {5, 2, 8, 1, 9};
                Arrays.sort(arr);
                System.out.println("Sorted array in ascending order: " + Arrays.toString(arr));

                int len = arr.length - 1;
                int temp;

                for( int i = 0; i <len; i++){
                    if (len > i){
                        temp = arr[i];
                        arr[i] = arr[len];
                        arr[len] = temp;
                        len--;
                    }
                    
                }
                System.out.println(Arrays.toString(arr));

        }
}