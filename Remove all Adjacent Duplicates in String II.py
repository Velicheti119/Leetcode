from collections import deque

class Solution(object):
    def removeDuplicates(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        stack = deque()
        for c in s:
            if not stack:
                stack.append((c, 1))
                continue
            prev_char, prev_count = stack[-1]
            if c == prev_char:
                count = prev_count + 1
                if count == k:
                    for _ in range(prev_count):
                        stack.pop()
                else:
                    stack.append((c, count)) 
            else:
                stack.append((c, 1))
        string = ""
        for i in range(len(stack)):
            character, count = stack[i]
            string = string + character
        return string
            
            

        
