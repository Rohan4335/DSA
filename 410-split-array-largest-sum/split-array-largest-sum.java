class Solution {
    public int splitArray(int[] nums, int k) {
        int x = 0;
        int sum = 0;
        for(int num: nums){
            sum += num;
            x = Math.max(num, x);
        }
        int low = x;
        int high = sum;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(canDo(nums, mid, k)){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    public boolean canDo(int[] nums, int maxSum, int k){
        int sum = 0;
        int cnt = 1;
        for(int i = 0; i<nums.length; i++){
            if(sum + nums[i] <= maxSum){
                sum += nums[i];
            }else{
                cnt++;
                sum = nums[i];
            }
        }
        return cnt <= k;
    }
}