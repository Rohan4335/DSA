class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        sum(result, new ArrayList<>(), 0, target, candidates);
        return result;
    }

    public void sum(List<List<Integer>> result, List<Integer> list, int idx, int target, int[] candidates) {
        if (target < 0) return;                // overshot — stop
        if (target == 0) {                     // found valid combination
            result.add(new ArrayList<>(list));
            return;
        }
        if (idx == candidates.length) return;  // no more candidates to try

        // include current candidate (can reuse it) 
        list.add(candidates[idx]);
        sum(result, list, idx, target - candidates[idx], candidates);

        // backtrack and exclude current candidate
        list.remove(list.size() - 1);
        sum(result, list, idx + 1, target, candidates);
    }
}
