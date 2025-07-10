class Solution {
    public int solve(int m , int n ){
        int[] prev = new int[n];
        for(int i =0 ; i <= m-1 ;i++){
            int[] temp = new int[n];
            for(int j = 0; j <= n-1 ;j++){
                if(i == 0 && j == 0){
                   temp[j] = 1;
                    continue;
                }
                int up = 0;
                int left = 0;
                if(i > 0){
                    up = prev[j];
                }
                if(j > 0){
                    left = temp[j-1];
                }
                temp[j] = up + left;
            }
            prev = temp;
        }
        return prev[n-1];
    }
    public int uniquePaths(int m, int n) {
        
        return solve(m,n);
    }
}