class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums,k) - helper(nums, k-1);
    }
    public int helper(int[] nums, int k){
        int n = nums.length;
        int low = 0;
        int count=0;
        for(int high = 0; high<n; high++){
            if(nums[high]%2 != 0){
                k--;
            }
            while(k<0 && low <= high){
                if(nums[low] % 2 != 0) k++;
                low++;
            }
            count += high - low + 1;
        }
        return count;
    }
}