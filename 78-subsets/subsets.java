class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), ans);
        return ans;
    }
    public void backtrack(int idx, int[]nums, List<Integer> cur, List<List<Integer>> ans){
        ans.add(new ArrayList<>(cur));
        for(int i=idx; i<nums.length;i++){
            cur.add(nums[i]);
            backtrack(i+1, nums, cur, ans);
            cur.remove(cur.size()-1);
        }
    }
}