class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        int zerocount = 0;
        int start = 0;
        for(int end = 0; end <n; end++){
            if(nums[end] == 0){
                zerocount++;
            }
            while(zerocount > k){
                if(nums[start] == 0) zerocount--;
                start++;
            }
            max = Math.max(max, end - start +1);
        }
        return max;
    }
}