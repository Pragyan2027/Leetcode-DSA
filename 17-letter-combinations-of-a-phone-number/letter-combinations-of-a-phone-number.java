class Solution {
     private final String[]map;
    public Solution() {
        // Mapping digits to corresponding characters
        map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    }
    private void solve(String digits , List<String>ans , int index , String current){
        if(index == digits.length()){
            ans.add(current);
            return;
        }
        String s = map[digits.charAt(index) - '0'];
        for(int i = 0 ; i<s.length();i++){
            solve(digits, ans, index + 1, current + s.charAt(i));
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0) return ans;
        solve(digits ,  ans , 0 ,"");
        return ans;
    }
}