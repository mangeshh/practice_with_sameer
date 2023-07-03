package backtracking;

import java.util.Arrays;

/**
 * Interview camp, using auxiliary buffer.
 */
public class PrintCombo {

    public static void print(String space, int [] array, int [] buffer, int startIndex, int bufferIndex){
        //System.out.print(space);

        // base case.
        if(buffer.length == bufferIndex){
            System.out.println(Arrays.toString(buffer));
            return;
        }

        for(int i = startIndex; i < array.length; i++){
            buffer[bufferIndex] = array[i];
            print("-"+space,array, buffer, i + 1, bufferIndex+1);
        }

    }

    public static void main(String[] args) {
        print("",new int[]{1,2,3,4,5,6,7,8,9}, new int[3], 0,0);
    }
}
