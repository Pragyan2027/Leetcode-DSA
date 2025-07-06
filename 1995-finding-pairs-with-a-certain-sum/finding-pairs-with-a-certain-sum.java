
class FindSumPairs {
    int[] n1, n2;
    Map<Integer, Integer> map = new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
        n1 = nums1;
        n2 = nums2;
        for (int x : n2) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
    }

    public void add(int index, int val) {
        // Decrease the count of the original value in the map
        map.put(n2[index], map.get(n2[index]) - 1);
        
        // Update the value in n2
        n2[index] += val;
        
        // Increase the count of the new value in the map
        map.put(n2[index], map.getOrDefault(n2[index], 0) + 1);
    }

    public int count(int tot) {
        int c = 0;
        for (int x : n1) {
            c += map.getOrDefault(tot - x, 0);
        }
        return c;
    }
}


/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */