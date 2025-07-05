class Solution {
    public int findLucky(int[] arr) {
          int[] freq = new int[501]; // Index represents the number itself

        // Step 1: Count frequencies
        for (int num : arr) {
            freq[num]++;
        }

        // Step 2: Check from 500 to 1 for the largest lucky number
        for (int i = 500; i >= 1; i--) {
            if (freq[i] == i) {
                return i;
            }
        }

        return -1;
    }
}