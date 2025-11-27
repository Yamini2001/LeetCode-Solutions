class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++)
            prefixSum[i + 1] = prefixSum[i] + nums[i];        
        
        long[] minSoFar = new long[k];
        Arrays.fill(minSoFar, Long.MAX_VALUE);
        minSoFar[0] = 0;
        
        long[] subMax = new long[n + 1];
        Arrays.fill(subMax, Long.MIN_VALUE);
        
        long maxSum = Long.MIN_VALUE;
        
        for (int i = 1; i <= n; i++) {
            int mod = i % k;
            
            if (minSoFar[mod] != Long.MAX_VALUE) {
                subMax[i] = prefixSum[i] - minSoFar[mod];
                maxSum = Math.max(maxSum, subMax[i]);
            }
            
            minSoFar[mod] = Math.min(minSoFar[mod], prefixSum[i]);
        }
        
        return maxSum;
    }
}