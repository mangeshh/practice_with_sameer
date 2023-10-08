package array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-common-characters/
 */
public class FindCommonCharacter {

    public List<String> commonChars(String[] words) {
        List<int[]> minOccurance = new ArrayList<>();
        List<String> list = new ArrayList<>();

        for(String word : words){
            int [] array = new int[26];

            char [] chars = word.toCharArray();

            for (char ch : chars){
                int index = (int) ch - (int)'a';
                array[index] = array[index] + 1;
            }
            minOccurance.add(array);
        }

        for(int col=0; col< 26; col++){
            int minCount = Integer.MAX_VALUE;
            for(int arrayTrace=0; arrayTrace<minOccurance.size(); arrayTrace++ ){
                int [] array = minOccurance.get(arrayTrace);
                minCount = Math.min(minCount, array[col]);
            }


            String charString = Character.toString((char) (col + 97));
            while(minCount-- > 0){
                list.add(charString);
            }

        }
        return list;
    }
}
