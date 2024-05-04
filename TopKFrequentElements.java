// https://leetcode.com/problems/top-k-frequent-elements/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        List<Integer>[] elements = new List[nums.length + 1];
        for (int num : nums) {
            int freq = counts.getOrDefault(num, 0);
            freq++;
            counts.put(num, freq);
        }
        for (int key : counts.keySet()) {
            int frequency = counts.get(key);
            if (elements[frequency] == null) {
                elements[frequency] = new ArrayList<>();
            }
            elements[frequency].add(key);
        }
        int[] res = new int[k];
        int i = 0;
        for (int pos = elements.length - 1; pos >= 0; pos--) {
            if(elements[pos] != null) {
                for(int j = 0; j < elements[pos].size() && i < k; j++) {
                    res[i] = elements[pos].get(j);
                    i++;
                }
            }
        }
        return res;
    }
}
