package two_pointers;

public class DutchNationalFlag {
    public static void main(String[] args) {
//        Our goal is to rearrange the elements in this array such that all elements smaller than pivot appear before
//        Then equal to pivot can be in middle
//        And greater than in the end

        int [] arr = new int[] {2, 7, 8, 5, 4, 1, 6};

        int pivot = 5;

        int left = 0, right = arr.length - 1;
        int index = 0;

//        left is that index where the next element smaller than pivot will come while going from left to right
//        right is that index where the next element larger than pivot will come while going from left to right

        while(index <= right){
            if(arr[index] < pivot){
                int temp = arr[left];
                arr[left] = arr[index];
                arr[index] = temp;

                index++;
                left++;
            }

            else if(arr[index] > pivot){
                int temp = arr[right];
                arr[right] = arr[index];
                arr[index] = temp;

                right--;
//                We are not increasing index by one since we don't know if arr[right] is smaller or not.
            }

            else{
                index++;
            }

        }

        System.out.println();

        for(int i = 0; i < arr.length; ++i){
            System.out.print(arr[i] + " ");
        }

    }
}
