class Solution {
        static void find(int index, int[] candidates, int target,
                     List<Integer> count, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(count));  // Add a copy of current combination
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // Skip duplicates
            if (i > index && candidates[i] == candidates[i - 1]) continue;

            // No point in continuing if the current number exceeds the target
            if (candidates[i] > target) break;

            count.add(candidates[i]);
            find(i + 1, candidates, target - candidates[i], count, result);  // Move to next index
            count.remove(count.size() - 1);  // Backtrack
        }
                     }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         Arrays.sort(candidates);  // Sort to handle duplicates
        List<List<Integer>> result = new ArrayList<>();
        find(0, candidates, target, new ArrayList<>(), result);
        return result;
    }
}
