package codility;

// https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
public class FrogJmp {

    public static void main(String[] args) {
        int X = 10;
        int Y = 85;
        int D = 30;
        int answer = new FrogJmp().solution(X, Y, D);
        System.out.println(answer); // 3
    }

    public int solution(int X, int Y, int D) {
        if (X == Y) {
            return 0;
        }
        return calculate(X, Y, D);
    }

    private int calculate(int X, int Y, int D) {
        int distance = (Y - X);
        return (distance % D) == 0
            ? distance / D
            : (distance / D) + 1;
    }
}
