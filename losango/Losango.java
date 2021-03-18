import java.util.*;

class Losango{
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
         
        int N = in.nextInt();
        
        losango1(N);
        losango2(N);
    }
    public static void losango1(int N){
        int ponto = N/2;
        int hastag = 1;
        for(int i = 0; i <= N/2; i++){
            for(int j = 0; j < ponto; j++) System.out.printf(".");
            for(int j = 0; j < hastag; j++) System.out.printf("#");
            for(int j = 0; j < ponto; j++) System.out.printf(".");
            System.out.printf("%n");

            ponto--;
            hastag += 2;
        }   
    }

    public static void losango2(int N){
        int ponto = 1;
        int hastag = N - 2;
        for(int i = 0; i < N/2; i++){
            for(int j = 0; j < ponto; j++) System.out.printf(".");
            for(int j = 0; j < hastag; j++) System.out.printf("#");
            for(int j = 0; j < ponto; j++) System.out.printf(".");
            System.out.printf("%n");

            ponto++;
            hastag -= 2;
        }   
    }
}