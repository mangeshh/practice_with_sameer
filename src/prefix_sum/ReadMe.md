   -->  Below methods are common patterns.
     

     // Returns the sum from index l to r (r >= l)
     // when i want to take sum from index 4 to index 8
     // i will take sum till index 8 and then subtract sum between index 0 to 3(4-1)
     // so we are using like = totalSum -= prefSum[l - 1]
    int getSum(int[] prefSum, int l, int r){

        int totalSum = prefSum[r]; // sum from 0 to r
        
        if(l > 0){
            totalSum -= prefSum[l - 1]; // sum from 0 to l - 1
        }

        return totalSum; // sum from l to r
    }

     // calculate prefix sum array.
     // Example :
     // {1, 4, 3, 7} = 1, 5, 8, 15
    public int[] prefixSum(int []nums){

        int[] prefSum = new int[nums.length];

        for(int i = 0; i < nums.length; ++i){
            prefSum[i] = nums[i] + (i > 0 ? prefSum[i - 1] : 0);
        }

        return prefSum;
    }
    