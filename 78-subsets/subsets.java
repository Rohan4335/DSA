class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(result,list ,0,nums);
        return result;
    }
    public void helper(List<List<Integer>> result, List<Integer> list,int i, int[] nums){
        if(i == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        helper(result, list,i+1,nums);
        list.remove(list.get(list.size() -1));
        helper(result ,list, i+1, nums);
    }
}