class Solution {
    public List<Integer> getRow(int rowIndex) {
      List<Integer> ans = new ArrayList<>(); // to store the answer
         long val = 1;
        for (int i = 0; i <= rowIndex; i++) {
            ans.add((int) val);
            // Update val for next position using binomial coefficient relation
            val = val * (rowIndex - i) / (i + 1);
        }
        return ans;
    }
}