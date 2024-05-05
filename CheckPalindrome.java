// https://leetcode.com/problems/valid-palindrome/

class Solution {
    public boolean isPalindrome(String s) {
        // Convert the string to char array and check range
        String lowerS = s.toLowerCase();
        ArrayList<Character> word = new ArrayList<Character>();
        for(int i = 0; i < lowerS.length(); i++) {
            char c = lowerS.charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || 
                (c >= '0' && c <= '9')) {
                word.add(c);
            }
        }
        int i = 0;
        int j = word.size() - 1;
        boolean palindrome = true;
        while (i < j) {
            if(word.get(i) != word.get(j)) {
                palindrome = false;
                break;
            } else {
                i++;
                j--;
            }
        }
        return palindrome;
    }
}
