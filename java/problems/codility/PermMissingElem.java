package codility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
public class PermMissingElem {

    public static void main(String[] args) {
        int[] A = {2, 3, 1, 5}; // 4
//      int[] A = {4, 2, 3, 1, 5, 6, 8, 7}; // 9
        int answer = new PermMissingElem().solution(A);
        System.out.println(answer); // 9
    }

    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int number : A) {
            set.add(number);
        }
        for (int i = 1; i <= A.length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        throw new RuntimeException();
    }

    public int badSolution(int[] A) {
        Arrays.sort(A); // {1, 2, 3, 5};
        if (A[0] != 1) {
            return 1;
        }
        for (int i = 0; i < A.length - 1; i += 2) {
            int diff = A[i + 1] - A[i];
            if (diff != 1) {
                return A[i + 1] - 1;
            }
        }
        return A[A.length - 1];
    }
}
