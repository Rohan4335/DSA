class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(result, new ArrayList<>(), candidates, 0, target);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> list, int[] candidates, int start, int target) {

        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int j = start; j < candidates.length; j++) {

            // skip duplicates
            if (j > start && candidates[j] == candidates[j - 1]) continue;

            // pruning
            if (candidates[j] > target) break;

            list.add(candidates[j]);
            helper(result, list, candidates, j + 1, target - candidates[j]);
            list.remove(list.size() - 1);
        }
    }
}
