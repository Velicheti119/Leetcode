class Solution {
    public int[] charArray(String a) {
        int[] alphabetArray = new int[26];
        for(char ch : a.toCharArray()) {
            int index = ch - 'a';
            alphabetArray[index]++;
        }
        return alphabetArray;
    }

    public boolean isAnagram(String s, String t) {
        int[] sArray = charArray(s);
        int[] tArray = charArray(t);
        // return Arrays.equal(sArray, tArray);
        for(int i = 0; i < 26; i++) {
            if(sArray[i] != tArray[i]) {
                return false;
            }
        }
        return true;
    }
}
