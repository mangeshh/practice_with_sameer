package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> rows = new ArrayList(numRows);

        for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {

            List<Integer> currentRow = new ArrayList();
            currentRow.add(0, 1);
            for (int columnIndex = 1; columnIndex < rowIndex; columnIndex++) {
                List<Integer> previousRow = rows.get(rowIndex - 1);
                currentRow.add(previousRow.get(columnIndex - 1) + previousRow.get(columnIndex));
            }
            if (rowIndex > 0) {
                currentRow.add(1);
            }
            rows.add(currentRow);
        }

        return rows;
    }


    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}

