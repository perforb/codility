package codility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

// https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
public class MissingInteger {

    public static void main(String[] args) {
        int[] A = {1, 3, 6, 4, 1, 2};  // 5
        int[] B = {1, 2, 3};           // 4
        int[] C = {-1, -3};            // 1
        int[] D = {-1000000, 1000000}; // 1
        System.out.println(new MissingInteger().solution(A));
        System.out.println(new MissingInteger().solution(B));
        System.out.println(new MissingInteger().solution(C));
        System.out.println(new MissingInteger().solution(D));
    }

    public int solution(int[] A) {
        Arrays.sort(A);
        int answer = 1;
        for (int i : A) {
            if (i == answer) {
                answer++;
            }
        }
        return answer;
    }

    // O(N^2)
    // TreeSet への要素追加部分で O(N^2) になってしまう.
    public int heavySolution(int[] A) {
        Set<Integer> set = new TreeSet<>();
        Set<Integer> sequentialSet = new TreeSet<>();

        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
            sequentialSet.add(i + 1);
        }

        for (int current : sequentialSet) {
            if (!set.contains(current)) {
                return current;
            }
        }

        if (sequentialSet.size() == set.size()) {
            return sequentialSet.size() + 1;
        }

        return 1;
    }

    public int badSolution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int number : A) {
            set.add(number);
        }
        int answer = -1;
        for (int i = 1; i <= A.length; i++) {
            int a = A[i - 1];
            if (a < 0) {
                continue;
            }
            answer = Math.max(answer, a);
            if (!set.contains(i)) {
                return i;
            }
        }
        if (answer < 0) {
            return 1;
        } else {
            return answer + 1;
        }
    }
}
