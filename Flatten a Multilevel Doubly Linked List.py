"""
# Definition for a Node.
class Node(object):
    def __init__(self, val, prev, next, child):
        self.val = val
        self.prev = prev
        self.next = next
        self.child = child
"""

class Solution(object):

    def merge(self, node):
        child = node.child
        while child.next is not None:
            child = child.next
        if node.next is not None:
            child.next = node.next
            node.next.prev = child
        node.next = node.child
        node.child.prev = node
        node.child = None

    def flatten(self, head):
        """
        :type head: Node
        :rtype: Node
        """
        currnode = head
        while currnode is not None:
            # print(currnode.val)
            if currnode.child is not None:
                self.merge(currnode)
            currnode = currnode.next
        return head
        
            


        
