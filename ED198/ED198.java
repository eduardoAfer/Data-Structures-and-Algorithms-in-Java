import java.util.*;

class ED198 {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int N = stdin.nextInt();
        int[] numeros = new int[N];

        for (int i = 0; i < N; i++)
            numeros[i] = stdin.nextInt();

        System.out.println(maxSubArraySum(numeros, 0, N - 1));
    }

    // Find the maximum possible sum in arr[]
    // such that arr[m] is part of it
    static int maxCrossingSum(int arr[], int l, int m, int h) {
        // Include elements on left of mid.
        int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        for (int i = m; i >= l; i--) {
            sum = sum + arr[i];
            if (sum > left_sum)
                left_sum = sum;
        }

        // Include elements on right of mid
        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int i = m + 1; i <= h; i++) {
            sum = sum + arr[i];
            if (sum > right_sum)
                right_sum = sum;
        }

        return Math.max(left_sum + right_sum, Math.max(left_sum, right_sum));
    }

    public static int maxSubArraySum(int arr[], int l, int h) {
        if (l == h)
            return arr[l];

        int m = (l + h) / 2;

        return Math.max(Math.max(maxSubArraySum(arr, l, m), maxSubArraySum(arr, m + 1, h)),
                maxCrossingSum(arr, l, m, h));
    }

}
