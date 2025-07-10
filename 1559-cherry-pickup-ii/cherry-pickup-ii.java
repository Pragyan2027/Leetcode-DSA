class Solution{
/* Function to find the maximum cherries
that can be collected using memoization*/
private int func(int i, int j1, int j2, int n, int m, int[][] grid, int[][][] dp) {
    // Base cases
    if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m)
        return (int)(-1e9);

    if (i == n - 1) {
        if (j1 == j2)
            return grid[i][j1];
        else
            return grid[i][j1] + grid[i][j2];
    }
    
    /* If the result for this state 
    is already computed, return it*/
    if (dp[i][j1][j2] != -1)
        return dp[i][j1][j2];

    int maxi = Integer.MIN_VALUE;

    // Try all possible moves for both positions (j1, j2)
    for (int di = -1; di <= 1; di++) {
        for (int dj = -1; dj <= 1; dj++) {
            int ans;

            if (j1 == j2)
                ans = grid[i][j1] + func(i + 1, j1 + di, j2 + dj, n, m, grid, dp);
            else
                ans = grid[i][j1] + grid[i][j2] + func(i + 1, j1 + di, j2 + dj, n, m, grid, dp);

            // Update the maximum result
            maxi = Math.max(maxi, ans);
        }
    }

    // Store the result in the dp array and return it
    return dp[i][j1][j2] = maxi;
}

// Function to find maximum cherries that can be collected
public int cherryPickup(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    
    // Declare a 3D array to store computed results
    int dp[][][] = new int[n][m][m];

    // Initialize the dp array with -1
    for (int row1[][] : dp) {
        for (int row2[] : row1) {
            Arrays.fill(row2, -1);
        }
    }

    // Return the maximum cherries collected
    return func(0, 0, m - 1, n, m, grid, dp);
}
}