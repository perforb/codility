package codility;

import java.util.Arrays;

public class TapeEquilibrium {

    public static void main(String[] args) {
        int[] A = {3, 1, 2, 4, 3};
        int answer = new TapeEquilibrium().solution(A);
        System.out.println(answer); // 1
    }

    // O(N)
    public int solution(int[] A) {
        int sum = sum(A);
        int answer = Integer.MAX_VALUE;
        int a = 0;
        int b;
        for (int P = 0; P < A.length - 1; P++) { // -1 は left と right を比較するため. 省くと 0 が answer になってしまう.
            a += A[P];
            b = sum - a;
            answer = Math.min(answer, Math.abs(a - b));
        }
        return answer;
    }

    // O(N^2)
    public int heavySolution(int[] A) {
        int answer = Integer.MAX_VALUE;
        int N = A.length;
        for (int P = 1; P < N; P++) {
            int[] a = slice(A, 0, P);
            int[] b = slice(A, P, N);
            int abs = Math.abs(sum(a) - sum(b));
            answer = Math.min(answer, abs);
        }
        return answer;
    }

    private int[] slice(int[] numbers, int start, int end) {
        return Arrays.copyOfRange(numbers, start, end);
    }

    private int sum(int[] numbers) {
//      return Arrays.stream(numbers).sum(); // slow
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
