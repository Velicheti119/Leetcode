class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] retArr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                retArr[0] = map.get(diff);
                retArr[1] = i;
                return retArr;
            } else {
                map.put(nums[i], i);
            }
        }
        return retArr;
    }
}
