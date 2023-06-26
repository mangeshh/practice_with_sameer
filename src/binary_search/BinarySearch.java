package binary_search;

public class BinarySearch {
    public static int binarySearch(int []nums, int target){
        int low = 0;
        int high = nums.length;
        int answer = -1;

        while(low <= high){
            int mid = (low + high) / 2;

            if(nums[mid] < target){
                low = mid + 1;
            }
            else if(nums[mid] == target){
                answer = mid;
                break;
            }
            else{
                high = mid - 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int []nums = new int[]{2, 4, 6, 7};
        System.out.println(binarySearch(nums, 6));
    }
}
