import java.util.*;

class ED231 {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int N = stdin.nextInt();
        int[] casos = new int[N];

        for (int i = 0; i < N; i++)
            casos[i] = stdin.nextInt();

        int flag = stdin.nextInt();

        if (flag == 1)
            minMaxCasos(casos, N);
        else if (flag == 2)
            baixaPropagacao(casos, N);
        else
            constroiGrafico(casos, N);

    }

    public static void minMaxCasos(int[] casos, int N) {
        int[] novosCasos = new int[N];
        novosCasos[0] = casos[0];

        for (int i = 1; i < N; i++)
            novosCasos[i] = casos[i] - casos[i - 1];

        Arrays.sort(novosCasos);
        for (int i = 0; i < N; i++) {
            System.out.println(novosCasos[i]);
        }
        System.out.printf("%d %d\n", novosCasos[0], novosCasos[N - 1]);

    }

    public static void baixaPropagacao(int[] casos, int N) {
        double[] propagacao = new double[N];
        int j = 0;

        for (int i = 1; i < N; i++) {

            propagacao[j] = (double) (casos[i] - casos[i - 1]) / casos[i - 1];
            j++;
        }

        j = 0;
        int unidadesPer = 0;
        int unidadesPerMax = 0;
        int periodos = 0;
        while (j < N) {
            int flagIf = 0;
            if (propagacao[j] <= 0.05) {
                flagIf = 1;
                periodos++;
                unidadesPer = 0;
                while (j < N && propagacao[j] <= 0.05) {
                    if (j == N - 1) {
                        j++;
                        break;
                    }

                    unidadesPer++; // incrementa unidades
                    j++;
                    // System.out.println(j);
                }
                if (unidadesPerMax < unidadesPer)
                    unidadesPerMax = unidadesPer;

            } else if (flagIf != 1)
                j++;

        }
        System.out.println(periodos + " " + unidadesPerMax);

    }

    public static void constroiGrafico(int[] casos, int N) {
        int max = 0;

        for (int i = 0; i < N; i++)
            if (casos[i] / 100 > max)
                max = casos[i] / 100;

        String[][] matrix = new String[N][max];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < max; j++) {
                matrix[i][j] = ".";
            }
        }

        for (int i = 0; i < N; i++) {
            int casosDia = casos[i];
            casosDia /= 100;
            for (int j = casosDia; j > 0; j--) {
                matrix[max - j][i] = "#";
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < max; j++) {
                System.out.print(matrix[i][j]);
            }
            if (i != N - 1)
                System.out.print('\n');
        }

    }
}