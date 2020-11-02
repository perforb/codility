package codility;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
// excellent solutions:
// https://funnelgarden.com/cyclic-rotation-codility-solution/
public class CyclicRotation {

    public static void main(String[] args) {
        int[] A = {3, 8, 9, 7, 6};
        int K = 3;
        int[] answer = new CyclicRotation().solution(A, K);
        System.out.println(Arrays.toString(answer)); // {9, 7, 6, 3, 8}
    }

    public int[] solution(int[] A, int K) {
        int[] answer = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int index = (i + K) % A.length;
            answer[index] = A[i];
        }
        return answer;
    }

    public int[] inefficientSolution(int[] A, int K) {
        if (!check(A, K)) {
            return A;
        }
        return rotate(A, K);
    }

    private int[] rotate(int[] A, int K) {
        int[] numbers = Arrays.copyOf(A, A.length);
        for (int i = 0; i < K; i++) {
            int[] a = {numbers[numbers.length - 1]};
            int[] b = slice(numbers, 0, numbers.length - 1);
            numbers = merge(a, b);
        }
        return numbers;
    }

    private int[] slice(int[] a, int start, int end) {
        return Arrays.copyOfRange(a, start, end);
    }

    private int[] merge(int[] a, int[] b) {
        return IntStream.concat(Arrays.stream(a), Arrays.stream(b)).toArray();
    }

    private boolean check(int[] A, int K) {
        int length = A.length;
        if (length == K || length < 2) {
            return false;
        }
        Set<Integer> set = Arrays.stream(A).boxed().collect(Collectors.toSet());
        return set.size() != 1;
    }
}
