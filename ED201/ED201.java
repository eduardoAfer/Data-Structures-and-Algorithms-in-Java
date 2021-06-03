import java.util.*;

public class ED201 {

   static int max;
   static int D;

   // Escrever todos os subconjuntos do array v[]
   static void sets(int v[]) {
      // array de booleanos para representar o conjunto
      boolean used[] = new boolean[v.length];
      goSets(0, v, used); // chamar funcao recursiva
   }

   // Gera todos os subconjuntos a partir da posicao 'cur'
   static void goSets(int cur, int v[], boolean used[]) {
      if (cur == v.length) { // Caso base: terminamos o conjunto
         // Escrever conjunto
         // System.out.print("Set:");
         // max = Integer.MIN_VALUE;
         int aux = 0;
         for (int i = 0; i < v.length; i++) {
            if (used[i])
               aux += v[i];
            if (max < aux && aux < D)
               max = aux;
            // if (i == v.length - 1)
            // System.out.println(max);

         }

      } else { // Se nao terminamos, continuar a gerar
         used[cur] = true; // Subconjuntos que incluem o elemento actual
         goSets(cur + 1, v, used);// Chamada recursiva
         used[cur] = false; // Subconjuntos que nao incluem o el. actual
         goSets(cur + 1, v, used);// Chamada recursiva
      }
   }

   // -----------------------------------------------------------

   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);

      D = stdin.nextInt();
      int N = stdin.nextInt();
      int[] musicas = new int[N];

      for (int i = 0; i < N; i++)
         musicas[i] = stdin.nextInt();
      max = Integer.MIN_VALUE;
      sets(musicas);
      System.out.println(max);
   }
}
