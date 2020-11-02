package codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class OddOccurrencesInArray {

    public static void main(String[] args) {
        int[] A = {9, 3, 9, 3, 9, 7, 9};
        int answer = new OddOccurrencesInArray().solution(A);
        System.out.println(answer); // 7
    }

    public int solution(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length - 1; i += 2) {
            if (A[i] != A[i + 1]) {
                return A[i];
            }
        }
        return A[A.length - 1];
    }

    public int badSolution(int[] A) {
        Map<Integer, List<Integer>> counter = new HashMap<>();
        for (int number : A) {
            counter
                .computeIfAbsent(number, i -> new ArrayList<>())
                .add(number);
        }
        return counter.values().stream()
            .filter(pair -> pair.size() == 1)
            .map(unpaired -> unpaired.get(0))
            .findFirst()
            .orElseThrow(NoSuchElementException::new);
    }
}
