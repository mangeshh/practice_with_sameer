package string;


/**
 * https://leetcode.com/problems/check-if-the-sentence-is-pangram/description/
 */
public class SentenceIsPangram {

    public static boolean checkIfPangram(String sentence) {

        char [] chars = sentence.toCharArray();
        int[] charIndexes = new int[26];
        for(int i=0; i < chars.length; i++){
            // lower case 'a' starts from 97 so subtracting 97 to make index 0 (starting point).
            charIndexes[(int) chars[i]-97] = 1;
        }
        for(int j=0; j < charIndexes.length; j++){
            if(charIndexes[j] < 1){

                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println(checkIfPangram(sentence));
    }
}