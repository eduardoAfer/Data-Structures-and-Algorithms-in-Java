import java.util.*;

class ED183 {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int N = stdin.nextInt();
        int[] valores = new int[N];

        float media = 0;
        for (int i = 0; i < N; i++) {
            valores[i] = stdin.nextInt();
            media += valores[i];
        }
        media /= N;
        Arrays.sort(valores);

        int amplitude = valores[N - 1] - valores[0];

        System.out.printf("%.2f\n%d", media, amplitude);

    }
}
