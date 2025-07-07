
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> arr = new HashSet<>();
        
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    arr.add(nums1[i]);
                }
            }
        }

        int[] arr1 = new int[arr.size()];
        int i = 0;
        for (int j : arr) {
            arr1[i++] = j;
        }

        return arr1;
    }
}