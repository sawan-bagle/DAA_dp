public class LongestIncreasingSubsequence {
    
    // Function to find the length of the longest increasing subsequence
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) { //base case -If the array is empty, return 0
            return 0; 
        }

        int n = nums.length;
        int[] dp = new int[n]; // Array to store the lengths of dp= LIS[1,1,1,1...]
        int maxLength = 1; // LIS is 1 (any single element)

        // Initialize dp array
        for (int i = 0; i < n; i++) {
            dp[i] = 1; // Each element is an increasing subsequence of length 1
        }

        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // If current_index > prev_index
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); // Update the LIS length
                }
            }
            maxLength = Math.max(maxLength, dp[i]); // Update the maximum length
        }

        return maxLength; // Return the length of the longest increasing subsequence
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18,49}; 
        int result = lengthOfLIS(nums); 
        System.out.println("Length of Longest Increasing Subsequence: " + result); 
    }
}