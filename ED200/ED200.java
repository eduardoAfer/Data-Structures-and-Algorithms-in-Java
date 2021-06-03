import java.util.Scanner;

public class ED200 {
   static int rows; // Numero de linhas
   static int cols; // Numero de colunas
   static char m[][]; // Matriz de celulas
   static boolean visited[][]; // Saber se uma dada posicao ja foi visitada
   static int max;

   // Tamanho da mancha que inclui posicao (y,x)
   static int t(int y, int x) {
      if (y < 0 || y >= rows || x < 0 || x >= cols)
         return 0; // Caso base: fora dos limites
      if (visited[y][x])
         return 0; // Caso base: celula ja visitada
      if (m[y][x] == '.')
         return 0; // Caso base: celula vazia
      int count = 1; // celula nao vazia
      visited[y][x] = true; // marcar como visitada
      count += t(y - 1, x); // Adicionando celulas nao vizinhas
      count += t(y + 1, x);
      count += t(y, x + 1);
      count += t(y, x - 1);
      count += t(y - 1, x - 1);
      count += t(y + 1, x - 1);
      count += t(y + 1, x + 1);
      count += t(y - 1, x + 1);
      if (max < count)
         max = count;
      return count;
   }

   // -----------------------------------------------------------

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);

      int N = in.nextInt();

      for (int i = 0; i < N; i++) {

         // Leitura de uma matriz de caracteres
         rows = in.nextInt();
         cols = in.nextInt();
         m = new char[rows][cols];
         visited = new boolean[rows][cols];
         max = 0;
         for (int j = 0; j < rows; j++)
            m[j] = in.next().toCharArray();

         for (int f = 0; f < rows; f++) {
            for (int n = 0; n < cols; n++) {
               t(f, n);
            }
         }

         System.out.printf("%d\n", max);

         for (int f = 0; f < rows; f++) {
            for (int n = 0; n < cols; n++) {
               visited[f][n] = false;
               m[f][n] = '.';
            }
         }

      }

   }

}
