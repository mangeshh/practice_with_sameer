package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
//        [[2, 7], [4, 5], [9, 10]]
//        Common Note:
//          For every interval i, i[0] <= i[1]
//          The whole list of intervals is sorted by start point of interval. (2 < 4 < 9)

//        current_start = intervals[0][0]
//        current_end =   intervals[0][1]

//        [4, 5]
//        if 4 < current_end:
//                We can merge it
//                current_end = Math.max(current_end, 5)
//        else:
//                We can never merge
//                Print / Add {current_start, current_end} in my list of merged intervals
//                current_start = 9
//                current_end = 10
//

        int [][] intervals = {{1, 12}, {2, 7}, {4, 5}, {7, 10}};

        List<String> mergedIntervals = new ArrayList<>();

        int current_start = intervals[0][0];
        int current_end = intervals[0][1];

        for(int i = 1; i < intervals.length; ++i){
            if(current_end >= intervals[i][0]){
//                I can merge it
                current_end = Math.max(current_end, intervals[i][1]);
            }
            else{
//                Apna current interval to khatam ho gaya
//                Means it cannot extend any further now
                mergedIntervals.add(Arrays.toString(new int[]{current_start, current_end}));
                current_start = intervals[i][0];
                current_end = intervals[i][1];
            }
        }

        mergedIntervals.add(Arrays.toString(new int[]{current_start, current_end}));

        System.out.println(mergedIntervals);

    }
}
