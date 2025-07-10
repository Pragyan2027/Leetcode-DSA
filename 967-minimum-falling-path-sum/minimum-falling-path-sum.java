class Solution {
    /* Function to find the minimum
    path sum in the given matrix */
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        /* Create a 2D DP array to
        store minimum path sums*/
        int[][] dp = new int[n][m];

        /* Initialize the first row of 
        dp with values from the matrix*/
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        /* Iterate through the matrix rows
        starting from the second row*/
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                /* Calculate the minimum path sum for the
                current cell considering three possible
                directions: up, left diagonal, and right diagonal*/

                // Up direction
                int up = matrix[i][j] + dp[i - 1][j];

                // Left diagonal direction (if it's a valid move)
                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += dp[i - 1][j - 1];
                } else {
                    leftDiagonal = Integer.MAX_VALUE;
                }

                // Right diagonal direction
                int rightDiagonal = matrix[i][j];
                if (j + 1 < m) {
                    rightDiagonal += dp[i - 1][j + 1];
                } else {
                    rightDiagonal = Integer.MAX_VALUE; 
                }

                // Store the minimum of the three paths in dp
                dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
        }

        /* Find the minimum value in the last row of dp, which
        represents the minimum path sums ending at each cell*/
        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            mini = Math.min(mini, dp[n - 1][j]);
        }

        // Minimum path sum is the minimum value in last row
        return mini;
    }
}