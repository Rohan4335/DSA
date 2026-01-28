class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k-1);
    }
    public int helper(int[] nums, int k){
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int low = 0;
        int count = 0;
        for(int high = 0; high<n; high++){
            map.put(nums[high],map.getOrDefault(nums[high],0)+1);
            while(map.size() > k){
                map.put(nums[low], map.get(nums[low]) - 1);
                if(map.get(nums[low]) == 0){  
                   map.remove(nums[low]);
                }   
                   low++;
            }
            count += high - low + 1;
        }
        return count;
    }
}