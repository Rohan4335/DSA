class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans,new ArrayList<>(), nums, 0);
        return ans;
    }
    public void helper(List<List<Integer>> ans , List<Integer> list, int[] nums, int i){
        if(i == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        helper(ans, list, nums, i+1);
        list.remove(list.size()-1);
        helper(ans, list, nums, i+1);
    }
}