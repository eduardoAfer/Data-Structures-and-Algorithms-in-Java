import java.util.Scanner; // para importar biblioteca stdio.h
public class Primos {
        public static void main(String[] args){
            Scanner read = new Scanner(System.in); 
            int acc = 0;
            int a = read.nextInt();
            int b = read.nextInt();

            boolean[] primos = filtro(b);

            for(; a <= b; a++){
                if(primos[a]) acc++;
            }

            System.out.println(acc);

        }
        public static boolean[] filtro(int j){ 
            boolean[] primos = new boolean[j + 1];
            for(int k=2; k <= j; k++) primos[k] = true;

            
            for(int k=2; k*k <= j; k++){
                
                if(primos[k]){
                    for(int m = k*k; m <= j; m+=k)  primos[m] = false;
                    
             }
            } 
            return primos;
        } 

    }



    