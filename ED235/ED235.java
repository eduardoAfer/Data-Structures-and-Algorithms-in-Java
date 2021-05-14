import java.util.*;

class ED235 {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int j = 0; // controla a quantidade de interacoes dos desenhos dos triangulos
        int N = stdin.nextInt(); // qnt de triangulos a desenhar
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) // entrada dos tamanhos dos triangulos
            arr[i] = stdin.nextInt();

        while (j < N) {
            int controlador = arr[j];
            for (int m = 0; m < arr[j]; m++) {
                for (int n = 0; n < arr[j]; n++) {
                    if (n > controlador - 1)
                        System.out.print('.');

                    else
                        System.out.print('#');
                }
                controlador--;
                System.out.print('\n');
            }

            j++;
        }

    }
}
