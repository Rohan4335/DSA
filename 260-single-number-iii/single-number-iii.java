class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0; 
        for(int num : nums){
            xor ^= num;
        }
        int ele = (xor&(xor-1))^xor;
        int[] arr = new int[2];
        for(int num:nums){
            if((num & ele) == ele){
                arr[0] ^= num;
            }else{
                arr[1] ^= num;
            }
        }
        return arr;
     }
}