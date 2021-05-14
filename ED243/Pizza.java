import java.util.*;

class Pizza {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int N = stdin.nextInt(); // numeros de ingredientes indesejados
        int[] arr = new int[N];// ingredientes indesejados

        for (int i = 0; i < N; i++) {
            arr[i] = stdin.nextInt();
        }
        int indice = -1;
        int P = stdin.nextInt(); // numero de pizzas
        boolean[] pizzaAceite = new boolean[P]; // array conterá true para as pizzas aceites

        // entrada das pizzas
        for (int i = 0; i < P; i++) {
            int k = stdin.nextInt();
            indice++;
            for (int j = 0; j < k; j++) {
                int b = stdin.nextInt();
                contem(arr, b, indice, pizzaAceite);
            }
        }

        int acc = 0;

        for (int f = 0; f < P; f++) {
            if (pizzaAceite[f] == false)
                acc++;
        }

        System.out.println(acc);

    }

    private static void contem(int[] arr, int b, int indice, boolean[] pizzaAceite) {
        for (int i = 0; i < arr.length; i++) {
            if (b == arr[i])
                pizzaAceite[indice] = true;
        }
    }
}
