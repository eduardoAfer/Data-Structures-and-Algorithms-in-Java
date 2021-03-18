
import java.util.*;


public class Estatisticas{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int [] arr = new int [n];

        for(int i = 0; i < n; i++) arr[i] = in.nextInt();
        
        double mediaArray = 0;
        for(int i = 0; i < n; i++) mediaArray+= arr[i];
        mediaArray /=n;

        System.out.printf("%.2f%n", mediaArray);

        Arrays.sort(arr);

        int amplitudeArray = arr[n - 1] - arr[0];
        System.out.printf("%d%n", amplitudeArray);
       
    }
}

