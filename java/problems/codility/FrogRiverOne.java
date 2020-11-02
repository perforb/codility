package codility;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogRiverOne {

    public static void main(String[] args) {
        int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
        int answer = new FrogRiverOne().solution(5, A);
        System.out.println(answer);
    }

    // O(N)
    public int solution(int X, int[] A) {
        Set<Integer> positions = new HashSet<>();
        for (int position = 1; position <= X; position++) {
            positions.add(position);
        }
        for (int K = 0; K < A.length; K++) {
            positions.remove(A[K]);
            if (positions.isEmpty()) {
                return K;
            }
        }
        return -1;
    }

    // O(N^2)
    public int heavySolution(int X, int[] A) {
        Map<Integer, Integer> leafCounter = new HashMap<>();
        for (int position = 1; position <= X; position++) {
            leafCounter.put(position, 0);
        }
        for (int K = 0; K < A.length; K++) {
            int position = A[K];
            leafCounter.computeIfPresent(position, (k, v) -> v + 1);
            int min = Collections.min(leafCounter.values());
            if (min > 0) {
                return K;
            }
        }
        return -1;
    }
}
