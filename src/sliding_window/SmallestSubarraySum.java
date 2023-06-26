package sliding_window;

public class SmallestSubarraySum {
//    L
//             R
//    3, 4, 1, 5, 3, 1

//    What is the smallest subarray length that sum greater than equal to 10?
//    3 is smallest subarray

//    Fixed Length: 1 pointer is enough (Why? Because other one is that plus k)
//    current_window_sum += nums[index + k]
//    current_window_sum -= nums[index]

//    Variable Length: 2 pointers are needed (left, right)

    public static void main(String[] args) {
        int nums[] = new int[]{3, 4, 1, 5, 3, 1};

        int target_sum = 10;

        int n = nums.length;

        int left = 0;

//        Right ko ek ek kar ke fixed krna hai
        int right = 0;
        int current_window_sum = 0;

        int minLen = Integer.MAX_VALUE;

        while (right < n){
            current_window_sum += nums[right];

//            Main left ko aage tabhi bahaunga jab current window ka sum 10 ya usse bada hai
            while (current_window_sum >= target_sum){
                minLen = Math.min(minLen, right - left + 1);
                current_window_sum -= nums[left];
                left++;
            }

            right++;
        }

        System.out.println("Minimum window length that sum up to " + target_sum + " is " + minLen);

    }
}


// How many numbers between [5, 9] = 5 (5, 6, 7, 8, 9)
// [3, 19] = 19 - 3 + 1

// Total numbers in the range from l to r is = r - l + 1

