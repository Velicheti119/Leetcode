from collections import deque

class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        stack = deque()
        string = ""
        num = 0
        for c in s:
            if c == "[":
                stack.append(num)
                stack.append(string)
                num = 0
                string = ""
            elif c == "]":
                prevString = stack.pop()
                prevNum = stack.pop()
                string = prevString + prevNum * string
            elif c.isdigit():
                num = num * 10 + int(c)
            else:
                string += c
        return string

        
