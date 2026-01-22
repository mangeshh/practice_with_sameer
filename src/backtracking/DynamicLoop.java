package backtracking;

import java.util.Arrays;

public class DynamicLoop {

    static void dynamicLoops(int position, int totalPositions, int[] buffer, int from, int to) {
        if (position == totalPositions) {
            // buffer is full -> one combination ready
            System.out.println(Arrays.toString(buffer));
            return;
        }

        for (int value = from; value <= to; value++) {
            buffer[position] = value;  // choose for this position
            dynamicLoops(position + 1, totalPositions, buffer, from, to);  // move to next position
        }
    }

    static void staticLoops(int position, int totalPositions, int[] buffer, int from, int to) {
            for (int i = 1; i <= 3; i++)
                for (int j = 1; j <= 3; j++)
                    for (int k = 1; k <= 3; k++)
                        System.out.println(i +", "+ j + ", " k);
    }

    public static void main(String[] args) {
        int positions = 3;          // like 3 nested loops
        int[] buffer = new int[positions];
        dynamicLoops(0, positions, buffer, 1, 3); // value range 1..3
    }
}
