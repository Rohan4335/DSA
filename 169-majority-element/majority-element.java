class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int pivot = 0; 
        int freq = 0;
        for(int i=0; i<n; i++){
            if(freq == 0){
                pivot = nums[i];
            }
            if(nums[i] == pivot){
                freq++;
            }else{
                freq--;
            }
        }
        return pivot;
    }
}