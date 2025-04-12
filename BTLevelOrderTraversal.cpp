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
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> retArr;
        dfs(root, retArr, 0);
        return retArr;
    }

    void dfs(TreeNode* root, vector<vector<int>>& retArr, int level) {
        if(!root) return;
        if(retArr.size() == level) {
            retArr.push_back({});
        }

        retArr[level].push_back(root->val);

        dfs(root->left, retArr, level + 1);
        dfs(root->right, retArr, level + 1);
    }
};
