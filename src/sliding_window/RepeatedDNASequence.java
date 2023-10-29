package sliding_window;

import java.util.HashSet;

// fixed length
public class RepeatedDNASequence {

    public static void main(String[] args) {
        //   AGCTGAAAGCTTAGCTG
        //   k = 5

        String input = "AGCTGAAAGCTTAGCTG";
        int n = input.length();
        int k = 5;


        String currentSequence = input.substring(0, k);
        HashSet <String> occurrence = new HashSet<>();
        occurrence.add(currentSequence);

        int right = k;

        while(right < n){
            // currentSequence keeps on changing
            currentSequence = currentSequence.substring(1) + input.charAt(right);

            if(occurrence.contains(currentSequence)){
                System.out.println("Repeating Sequence is " + currentSequence);
                break;
            }
            else {
                occurrence.add(currentSequence);
            }

            right++;
        }

    }
}
