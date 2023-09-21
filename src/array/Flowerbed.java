package array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/can-place-flowers/submissions/
 * Leetcode - 605. Can Place Flowers
 */
public class Flowerbed {

        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            // 1 0 0 0 0 0 0 0 0 1
            // 0 0 1 0 0 0 0 1 1 0

            List<Integer> list = new ArrayList<>();
            int count = 0;
            int i =0;

            while(i < flowerbed.length && flowerbed[i] == 0){
                i++;
                count++;
            }
            if(i == flowerbed.length){
                if(n <= (count+1)/2){
                    return true;
                }else{
                    return false;
                }
            }
            int noOfPossibilities = 0;

            noOfPossibilities = noOfPossibilities + count/2;
            count = 0;

            for (;i < flowerbed.length; i++){
                if(flowerbed[i] == 0){
                    count++;
                }else{
                    list.add(count);
                    count = 0;
                }
            }

            noOfPossibilities = noOfPossibilities + count/2;

            for(int c = 0 ; c < list.size(); c++){
                int noOfZeros = list.get(c);
                if(noOfZeros > 2){
                    noOfPossibilities = noOfPossibilities + ((noOfZeros-1)/2);
                }
            }

            if(n <= noOfPossibilities){
                return true;
            }
            return false;

        }

    }

