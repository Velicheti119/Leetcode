class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int fp = m - 1;
        int sp = n - 1;
        int pointer = m + n - 1;
        while (fp >= 0 && sp >= 0) {
            if  (nums1[fp] >= nums2[sp]) {
                nums1[pointer] = nums1[fp];
                fp -= 1;
                pointer -= 1;               
            } else {
                nums1[pointer] = nums2[sp];
                sp -= 1;
                pointer -= 1;
            }
        }
        while (fp >= 0) {
            nums1[pointer] = nums1[fp];
            fp -= 1;
            pointer -= 1;
        }
        while (sp >= 0) {
            nums1[pointer] = nums2[sp];
            sp -= 1;
            pointer -= 1;
        }
    }
}
