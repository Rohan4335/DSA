class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(result, new ArrayList<>(), 0, nums);
        return result;
    }
    public void helper(List<List<Integer>> result, List<Integer> list, int i, int[] nums){
        if(i == nums.length){
            if(!result.contains(list)){
              result.add(new ArrayList<>(list));
            }
            return;
        }
        list.add(nums[i]);
        helper(result, list, i+1, nums);
        list.remove(list.size()-1);
        while(i+1 < nums.length && nums[i] == nums[i+1]){
            i++;
        }
        helper(result, list,i+1, nums);
    }
}