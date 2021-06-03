import java.util.*;

class ED198 {

    public static int findMaximumSum(int[] A, int left, int right) {
        if (right == left) {
            return A[left];
        }
        int mid = (left + right) / 2;

        int leftMax = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += A[i];
            if (sum > leftMax) {
                leftMax = sum;
            }
        }

        int rightMax = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += A[i];
            if (sum > rightMax) {
                rightMax = sum;
            }
        }

        int maxLeftRight = Integer.max(findMaximumSum(A, left, mid), findMaximumSum(A, mid + 1, right));

        return Integer.max(maxLeftRight, leftMax + rightMax);
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int N = stdin.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = stdin.nextInt();
        }

        System.out.println(findMaximumSum(arr, 0, arr.length - 1));
    }
}