class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;
         for(int num : nums) {
            high = Math.max(high, num);
         }
        int ans = high; 
        while(low <= high){
            int sum = 0;
            int mid = low + (high - low)/2;
            for(int i = 0; i< nums.length; i++){
                sum = sum + (nums[i] + mid -1)/mid;
            }
            if(sum <= threshold){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}