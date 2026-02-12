class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        res[0] = helper(nums, target, true);
        res[1] = helper(nums, target, false);
        return res;
    }
    public int helper(int[] nums, int target , boolean findIndex){
        int low = 0;
        int high = nums.length-1;
        int  ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] > target){
                high = mid - 1;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                    ans = mid;
                if(findIndex){
                    high = mid-1;
                }else{
                    low = mid + 1;
                }
            }
        }
            return ans;
    }
}