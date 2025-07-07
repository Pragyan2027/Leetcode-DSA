class Solution {
    private int solve(int[]arr){
         int n =  arr.length;
        int prev = arr[0];
        int prev2= 0 ;

        for(int i = 1 ; i<n;i++){
            int pick = arr[i];

            if(i > 1){
                pick += prev2;
            }
            int nonPick  = 0 + prev;
            int curr = Math.max(pick , nonPick);

            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];

        int[]arr1 = new int[n-1];
        int[]arr2 = new int[n-1];

        for(int i = 0 ; i < n ;i++){
            if(i != n-1)
                arr1[i] = nums[i];
            if(i != 0)
                arr2[i - 1] = nums[i];
        }
        int ans1 = solve(arr1);
        int ans2 = solve(arr2);

        return Math.max(ans1 , ans2);
    }
}