/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

class Solution {
public:
    int count;
    int retval;
    int kthSmallest(TreeNode* root, int k) {
           count = 0;
           retval = -1;
           inOrder(root, k);
           return retval;
    }

    void inOrder(TreeNode* node, int k) {
        if(!node) return;

        inOrder(node->left, k);

        count++;
        if(k == count) {
            retval = node->val;
            return;
        }

        inOrder(node->right, k);
    }
};
