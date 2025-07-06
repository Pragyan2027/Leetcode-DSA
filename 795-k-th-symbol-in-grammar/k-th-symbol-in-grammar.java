class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1) return 0;
        int parent = (k + 1) / 2;
        int parentVal = kthGrammar(n - 1, parent);
        return (k % 2 == 1) ? parentVal : 1 - parentVal;
    }
}