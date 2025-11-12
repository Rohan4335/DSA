class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int ele1 = 0;
        int ele2 = 0;
        int freq1 = 0;
        int freq2 = 0;
        for(int num : nums){
             if (num == ele1) {
                freq1++;
            } else if (num == ele2) {
                freq2++;
            } else if (freq1 == 0) {
                ele1 = num;
                freq1++;
            } else if (freq2 == 0) {
                ele2 = num;
                freq2++;
            } else {
                freq1--;
                freq2--;
            }
        }
        freq1 = 0; 
        freq2 = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == ele1){
                freq1++;
            }else if(nums[i] == ele2){
                freq2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if(freq1 > nums.length/3) res.add(ele1);
        if(freq2 > nums.length/3) res.add(ele2);
        return res;
    }
}