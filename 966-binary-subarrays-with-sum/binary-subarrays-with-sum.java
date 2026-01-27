class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums, goal) - helper(nums, goal-1);
    }
    public int helper(int[] nums, int goal){
        int tail = 0, sum = 0, result = 0;
        for(int head = 0; head< nums.length; head++){
            sum += nums[head];
            while(sum > goal && tail <=head){
                sum -= nums[tail];
                tail++;
            }
            result += head - tail +1;
        }
        return result;
    }
}