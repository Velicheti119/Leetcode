class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        // () -> 40, 41
        // {} -> 123, 125
        // [] -> 91, 93

        for(char ch : s.toCharArray()) {
            if(ch == 40) {
                stack.push(')');
            } else if (ch == 123) {
                stack.push('}');
            } else if (ch == 91) {
                stack.push(']');
            } else if (stack.empty() || stack.pop() != ch) {
                return false;
            }
        }
        return stack.empty();
    }
}
